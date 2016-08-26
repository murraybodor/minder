//package com.skyquill.minder.server.dao;
//
//import java.util.Iterator;
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import org.hibernate.Criteria;
//import org.hibernate.HibernateException;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.criterion.Criterion;
//import org.hibernate.criterion.Restrictions;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.GrantedAuthority;
//import org.springframework.security.userdetails.UserDetails;
//import org.springframework.security.userdetails.UsernameNotFoundException;
//
//import com.skyquill.minder.model.Audit;
//import com.skyquill.minder.model.auth.Authority;
//import com.skyquill.minder.model.auth.Principal;
//import com.skyquill.minder.model.auth.UserContext;
//import com.skyquill.minder.model.util.UserDTO;
//
///**
// * DAO methods to support authentication
// * 
// * @author mbodor
// */
//@SuppressWarnings("unchecked")	
//public class AuthDaoImpl implements AuthDao {
//
//
//    private SessionFactory sessionFactory;
//	protected static Logger logger = LoggerFactory.getLogger(AuthDaoImpl.class);
//
//	public SessionFactory getSessionFactory() {
//		return sessionFactory;
//	}
//
//	@Resource(name="authSessionFactory")
//	public void setSessionFactory(SessionFactory sessionFactory) {
//		logger.debug("AuthDaoImpl.setSessionFactory() starting");
//		this.sessionFactory = sessionFactory;
//	}
//
//	public UserDetails loadUserByUsername(String key) throws UsernameNotFoundException, HibernateException {
//		logger.debug("AuthDaoImpl.loadUserByUsername() starting");
//	
//		
//		Session sess = sessionFactory.getCurrentSession();
//		Transaction tx = sess.beginTransaction();
//		
//		// create criteria
//		Criteria userCrit = sess.createCriteria(Principal.class);
//		Criterion keyCrit = Restrictions.eq("username", key);
//		userCrit.add(keyCrit);
//
//		Principal user = (Principal)userCrit.uniqueResult();
//
//		if (user==null) {
//			logger.error("AuthDaoImpl.loadUserByUsername() user not found");
//			throw new UsernameNotFoundException("Not a valid username");
//		}
//		
//		logger.debug("AuthDaoImpl.loadUserByUsername() got user: " + user.getUsername() + " email=" + user.getEmailAddress() + " tenant dbname=" + user.getTenant().getContext());
//
//		Criteria authorityCrit = sess.createCriteria(Authority.class);
//		authorityCrit.add(keyCrit);
//
//		List<GrantedAuthority> authorities = (List)authorityCrit.list();
//
//		if (authorities!=null) {
//			GrantedAuthority[] authorityArray = new GrantedAuthority[authorities.size()];
//
//			int i=0;
//			
//			for (Iterator iterator = authorities.iterator(); iterator.hasNext();) {
//				GrantedAuthority grantedAuthority = (GrantedAuthority) iterator.next();
//				logger.debug("AuthDaoImpl.loadUserByUsername() got an authority: " + grantedAuthority.getAuthority());
//				authorityArray[i++] = grantedAuthority;
//			}
//			
//			user.setAuthorities(authorityArray);
//		}
//
//		
//		tx.commit();
//		
//		logger.debug("AuthDaoImpl.loadUserByUsername() done ");
//		
//		return user;
//	}
//
//	public List<Principal> getTenantUsers(UserContext userContext) {
//		logger.debug("AuthDaoImpl.getTenantUsers() starting");
//		
//		Session sess = sessionFactory.getCurrentSession();
//		Transaction tx = sess.beginTransaction();
//
//		Criteria prinCrit = sess.createCriteria(Principal.class)
//		.createAlias("tenant", "ten");
//		
//		Criterion contextCrit = Restrictions.eq("ten.context", userContext.getTenantContext());
//		prinCrit.add(contextCrit);
//		
//		List<Principal> principalList = prinCrit.list();
//		
////		String userQuery = "select pr " +
////		"from Principal pr " +
////		"join pr.tenant ten " +
////		"where ten.context = :context ";
////
////		Query query = sess.createQuery(userQuery);
////		query.setParameter("context", userContext.getTenantContext());
//
////		result = (List<Reservation>)query.list();
//		
////		Criteria principalCrit = sess.createCriteria(Principal.class);
//////		Criterion tenantContextCrit = Restrictions.eq("tenant.context", "demo");
////		Criterion tenantContextCrit = Restrictions.eq("tenant.tenantName", "Demo Company Ltd.");
//////		Criterion tenantContextCrit = Restrictions.eq("username", "demo");
////		principalCrit.add(tenantContextCrit);
//		
////		List<Principal> principalList = (List<Principal>)query.list();
//		
//		logger.debug("AuthDaoImpl.getTenantUsers() got " + principalList.size() + " users for tenant " + userContext.getTenantContext());
//		
//		for (Iterator iterator = principalList.iterator(); iterator.hasNext();) {
//			Principal principal = (Principal) iterator.next();
//			Criteria authCrit = sess.createCriteria(Authority.class);
//			Criterion userNameCrit = Restrictions.eq("username", principal.getUsername());
//			authCrit.add(userNameCrit);
//			
//			List<Authority> authList = authCrit.list();
//
//			logger.debug("AuthDaoImpl.getTenantUsers() got " + authList.size() + " authorities for user " + principal.getUsername());
//			GrantedAuthority[] authorities = new GrantedAuthority[authList.size()];
//			int i = 0;
//			
//			for (Iterator iterator2 = authList.iterator(); iterator2.hasNext();) {
//				Authority authority = (Authority) iterator2.next();
//				authorities[i] = authority;
//				i++;
//			}
//			
//			principal.setAuthorities(authorities);
//			
//			logger.debug("AuthDaoImpl.getTenantUsers() done loading " + principal.getUsername());
//		}
//		
//		tx.commit();
//
//		
//		logger.debug("AuthDaoImpl.getTenantUsers() done, size=" + principalList.size());
//		return principalList;
//		
//	}
//
//	public void saveUsers(List<UserDTO> changedUsers, UserContext userContext) {
//		
//		logger.debug("AuthDaoImpl.saveUsers() starting");
//		
//		Session sess = sessionFactory.getCurrentSession();
//		Transaction tx = sess.beginTransaction();
//
//		
//		for (Iterator<UserDTO> iterator = changedUsers.iterator(); iterator.hasNext();) {
//			UserDTO userDto = (UserDTO) iterator.next();
//	
//			Principal principal = new Principal();
//			principal.setId(userDto.getId());
//			principal.setFirstName(userDto.getFirstName());
//			principal.setLastName(userDto.getLastName());
//			principal.setEmailAddress(userDto.getEmailAddress());
//			principal.setUsername(userDto.getUserName());
//			principal.setPassword(userDto.getPassword());
//			principal.setEnabled(userDto.getEnabled());
//			principal.setAccountNonLocked(userDto.getAccountNonLocked());
//			principal.setCellPhone(userDto.getCellPhone());
//			principal.setOfficePhone(userDto.getOfficePhone());
//			principal.setAudit(new Audit(userDto.getAuditUserId(), userDto.getAuditDateTime()));
//			logger.debug("AuthDaoImpl.saveUsers() tenant: " + userDto.getTenantId());
//			principal.setTenantId(userDto.getTenantId());
////			principal.setAuthorities(authorities)
//
//			logger.debug("AuthDaoImpl.saveUsers() saving user " + userDto.getLastName());
//			
//			sess.saveOrUpdate(principal);
//			
//			// delete and reinsert authorities for this user
//			logger.debug("AuthDaoImpl.saveUsers() deleting existing user authorities");
//			
//			sess.delete("select auth from Authorities auth where username='" + userDto.getUserName() + "'");
//			
//			String[] authorityArr = userDto.getAuthorities();
//			
//			for (int i = 0; i < authorityArr.length; i++) {
//				String auth = authorityArr[i];
//				logger.debug("AuthDaoImpl.saveUsers() saving user authority " + auth);
//				
//				Authority newAuth = new Authority();
//				newAuth.setUsername(userDto.getUserName());
//				newAuth.setAuthority(auth);
//				newAuth.setAudit(new Audit(userDto.getAuditUserId(), userDto.getAuditDateTime()));
//				newAuth.setVersion(0);
//
//				sess.save(newAuth);
//				logger.debug("AuthDaoImpl.saveUsers() saved user authority " + auth);
//			}
//			
//		}
//		
//		tx.commit();
//		
//		logger.debug("AuthDaoImpl.saveUsers() done");
//	}
//	
//	
//}
