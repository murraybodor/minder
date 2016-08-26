package com.skyquill.minder.server;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.isomorphic.log.Logger;


/**
 * Looks up a session factory in the spring context based on the user's context
 *  
 * @author M
 *
 */
public class SessionFactoryProxy implements ApplicationContextAware {

	Logger log = new Logger(SessionFactoryProxy.class.getName());
	private Map<String, SessionFactory> sessionFactoryMap = new HashMap<String, SessionFactory>();
    protected ApplicationContext ctx;

	public SessionFactoryProxy() {
		log.debug("SessionFactoryProxy.constructor");
	}

	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.ctx = arg0;
	}
	
	public SessionFactory getThreadSessionFactory() throws IllegalAccessException {
		log.debug("SessionFactoryProxy.getThreadSessionFactory starting");

//		if (context==null) {
//			logger.error("SessionFactoryProxy.lookupThreadSessionFactory - found no user context in threadlocal!");
//			throw new IllegalAccessException("No user context found, no session factory available");
//		}
//		
//		String sessionFactoryName = context.getTenantContext();

		String tenant = TenantHolder.getTenant();
		log.debug("SessionFactoryProxy.getThreadSessionFactory - found " + tenant + "  in threadlocal!");
		String sessionFactoryName = tenant + "SessionFactory";
		
		log.debug("SessionFactoryProxy.getThreadSessionFactory - sf name=" + sessionFactoryName);
		
		SessionFactory sf = sessionFactoryMap.get(sessionFactoryName);

		if (sf!=null) {
			log.debug("SessionFactoryProxy.lookupThreadSessionFactory found an existing sessionfactory in the map: " + sessionFactoryName + ", returning");
			return sf;
		}

		Object bean = ctx.getBean(sessionFactoryName);
		
		if (bean==null) {
			log.error("SessionFactoryProxy.getThreadSessionFactory - found no session factory named " + sessionFactoryName + " in context!");
			throw new IllegalAccessException("Found no session factory named " + sessionFactoryName + " in context!");
		}
		
		sf = (SessionFactory)bean;
		
//		logger.debug("SessionFactoryProxy.lookupThreadSessionFactory added a new sessionfactory to the map: " + sessionFactoryName + ", returning");
		sessionFactoryMap.put(sessionFactoryName, sf);

		return sf;
	}


}
