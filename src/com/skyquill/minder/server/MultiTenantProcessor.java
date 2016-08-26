package com.skyquill.minder.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isomorphic.log.Logger;
import com.isomorphic.servlet.IDACall;

public class MultiTenantProcessor extends IDACall {


	private static final long serialVersionUID = -1483088157905503631L;
	private Logger log = new Logger(MultiTenantProcessor.class.getName());
//	protected static SessionFactory sf;
//	private static WebApplicationContext appCtx;

//	@Override
//	public void init(ServletConfig arg0) throws ServletException {
//		log.debug("MultiTenantProcessor init");
//
//		super.init(arg0);
//		
//		ServletContext ser = this.getServletContext();
//		appCtx = WebApplicationContextUtils.getRequiredWebApplicationContext(ser) ;
//		log.debug("MultiTenantProcessor got ctx");
//		
//		sf = (SessionFactory)appCtx.getBean("demoSessionFactory");
//		log.debug("MultiTenantProcessor got sf, init done");
//	} 

	@Override
	public void processRequest(final HttpServletRequest arg0, final HttpServletResponse arg1) throws ServletException, IOException {
		log.debug("MultiTenantProcessor.processRequest starting");

//		Object tenantObj = arg0.getParameter("tenant");
//		if (tenantObj != null) {
//			String tenantarg = (String) tenantObj;
//			log.debug("MultiTenantProcessor.processRequest tenantObj = " + tenantarg);
//			TenantHolder.setTenant(tenantarg);
//		} else {
//			log.error("MultiTenantProcessor.processRequest tenantObj is NULL");
//		}
//
//		PlatformTransactionManager txManager = (PlatformTransactionManager) appCtx.getBean("demoTxManager");
//		log.debug("MultiTenantProcessor.processRequest got a txManager");
//
//		TransactionTemplate txTemplate = new TransactionTemplate(txManager);
//		log.debug("MultiTenantProcessor.processRequest created a txTemplate");
//
//		txTemplate.execute(new TransactionCallback() {
//
//			public Object doInTransaction(TransactionStatus status) {
//				try {
//					process(arg0, arg1);
//				} catch (ServletException e) {
//					log.error("MultiTenantProcessor.processRequest ServletException " + e.getMessage());
//					e.printStackTrace();
////					status.setRollbackOnly();
//				} catch (IOException e) {
//					log.error("MultiTenantProcessor.processRequest IOException " + e.getMessage());
//					e.printStackTrace();
////					status.setRollbackOnly();
//				} finally {
//				}
//
//				return null;
//			}
//		});		

		process(arg0, arg1);
		log.debug("MultiTenantProcessor.processRequest done");

	}

	private void process(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		log.debug("MultiTenantProcessor.process executing request");
		super.processRequest(arg0, arg1);

	}
	
//	private void authenticxate() {
//		
//		try {
//	        Authentication request = new UsernamePasswordAuthenticationToken(name, password);
//	        Authentication result = am.authenticate(request);
//	        SecurityContextHolder.getContext().setAuthentication(result);
//	        break;
//	      } catch(AuthenticationException e) {
//	        System.out.println("Authentication failed: " + e.getMessage());
//	      }
//	      
//	}

}
