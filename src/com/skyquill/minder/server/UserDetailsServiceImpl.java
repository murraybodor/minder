package com.skyquill.minder.server;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.skyquill.minder.model.auth.Authority;
import com.skyquill.minder.model.auth.Principal;

/**
 * Service class for user details
 * 
 */
public class UserDetailsServiceImpl implements UserDetailsService {

	protected static Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	
    private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public UserDetails loadUserByUsername(String key) throws UsernameNotFoundException, HibernateException {
		logger.debug("UserDetailsServiceImpl.loadUserByUsername() starting");
	
		if (key==null || key.length()==0) {
			logger.info("UserDetailsServiceImpl.loadUserByUsername() username is null");
			throw new UsernameNotFoundException("Username cannot be empty");
		}
		
		Session sess = sessionFactory.getCurrentSession();
		Transaction tx = sess.beginTransaction();
		
		// create criteria
		Criteria userCrit = sess.createCriteria(Principal.class);
		Criterion keyCrit = Restrictions.eq("username", key);
		userCrit.add(keyCrit);

		Principal user = (Principal)userCrit.uniqueResult();

		if (user==null) {
			logger.error("UserDetailsServiceImpl.loadUserByUsername() user not found");
			throw new UsernameNotFoundException("Not a valid username");
		}
		
		logger.debug("UserDetailsServiceImpl.loadUserByUsername() got user: " + user.getUsername() + " email=" + user.getEmailAddress() + " tenant dbname=" + user.getTenant().getContext());

		
		
		
		Criteria authorityCrit = sess.createCriteria(Authority.class);
		authorityCrit.add(keyCrit);

		List<GrantedAuthority> authorities = (List)authorityCrit.list();

		if (authorities!=null) {
			
			for (Iterator<GrantedAuthority> iterator = authorities.iterator(); iterator.hasNext();) {
				GrantedAuthority grantedAuthority = (GrantedAuthority) iterator.next();
				logger.debug("UserDetailsServiceImpl.loadUserByUsername() got an authority: " + grantedAuthority.getAuthority());
			}
			
			user.setAuthorities(authorities);
		}

		
		tx.commit();
		
		logger.debug("UserDetailsServiceImpl.loadUserByUsername() done ");
		
		return user;
	}
	
}
