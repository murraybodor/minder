package com.skyquill.minder.server;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.isomorphic.datasource.BasicDataSource;
import com.isomorphic.datasource.DSRequest;
import com.isomorphic.datasource.DSResponse;
import com.isomorphic.datasource.DataSource;
import com.isomorphic.log.Logger;
import com.isomorphic.util.DataTools;

public class GenericDAO {

	Logger log = new Logger(GenericDAO.class.getName());
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public DSResponse fetch(DSRequest req) throws Exception {
		log.debug("GenericDAO.fetch starting");
		
		DataSource ds = req.getDataSource();
		String entityName = ((BasicDataSource)ds).getProperty("mappedBeanClass");
		log.debug("GenericDAO.fetch ds=" + ds.getName() + " class=" + entityName + " tenant=" + TenantHolder.getTenant());
		
		DSResponse dsResponse = new DSResponse();

		Session hibernateSession = sessionFactory.getCurrentSession();
		Criteria criteria = hibernateSession.createCriteria(entityName);

		
		// add filter for itemName, if exists
		String itemName = (String)req.getFieldValue("itemName");

		Criterion itemNameRestriction = null;
		if (itemName != null) {
			itemNameRestriction = Restrictions.like("itemName", itemName, MatchMode.ANYWHERE);
			criteria.add(itemNameRestriction);
		}

		// add filter for travellerId, if exists
		String travellerId = (String)req.getFieldValue("travellerId");

		Criterion travellerIdRestriction = null;
		if (travellerId != null) {
			log.info("GenericDAO.fetch filtering by travellerId=" + travellerId);
			travellerIdRestriction = Restrictions.eq("travellerId", new Long(travellerId));
			criteria.add(travellerIdRestriction);
		}
		
		// add filter for itineraryId, if exists
		String itineraryId = (String)req.getFieldValue("itineraryId");

		Criterion itineraryIdRestriction = null;
		if (itineraryId != null) {
			log.info("GenericDAO.fetch filtering by itineraryId=" + itineraryId);
			itineraryIdRestriction = Restrictions.eq("itineraryId", new Long(itineraryId));
			criteria.add(itineraryIdRestriction);
		}
		
		
		// DataSource protocol: get requested row range
		long startRow = (int)req.getStartRow();
		long endRow = (int)req.getEndRow();

		

		// determine total available rows
		// this is used by e.g. the ListGrid to auto-size its scrollbar
		criteria.setProjection(Projections.rowCount());
		Integer rowCount = (Integer)criteria.uniqueResult();
		long totalRows = rowCount == null ? 0 : rowCount.intValue();
		log.debug("GenericDAO.fetch - totalRows=" + totalRows);

		// clamp endRow to available rows and slice out requested range
		endRow = Math.min(endRow, totalRows);

		// rebuilt the criteria minus the rowCount projection
		criteria = hibernateSession.createCriteria(entityName);
		if (itemName != null) criteria.add(itemNameRestriction);
		if (travellerId != null) criteria.add(travellerIdRestriction);
		if (itineraryId != null) criteria.add(itineraryIdRestriction);

		// limit number of rows returned to just what the ListGrid asked for
//		criteria.setFirstResult((int)startRow);
//		criteria.setMaxResults((int)(endRow - startRow));
		List<?> matchingItems = criteria.list();

		dsResponse.setData(matchingItems);
		dsResponse.setStartRow(startRow);
		dsResponse.setEndRow(endRow);
		dsResponse.setTotalRows(totalRows);

		log.debug("GenericDAO.fetch done");
		return dsResponse;
	}

	public DSResponse add(DSRequest req) throws Exception {
		log.debug("GenericDAO.add starting");
		
		DataSource ds = req.getDataSource();
		String entityName = ((BasicDataSource)ds).getProperty("mappedBeanClass");
		Session currentSession = sessionFactory.getCurrentSession();
		DSResponse dsResponse = new DSResponse();
		
		log.debug("GenericDAO.add class: " + entityName);
		
		Object record = Class.forName(entityName).newInstance();
		
		DataTools.setProperties(req.getValues(), record);

		// perform validation
//		ErrorReport errorReport = req.getDataSource().validate(DataTools.getProperties(item), false);
//		if (errorReport != null) {
//			dsResponse.setStatus(DSResponse.STATUS_VALIDATION_ERROR);
//			dsResponse.setErrorReport(errorReport);
//			System.out.println("Errors: " + DataTools.prettyPrint(errorReport));
//			return dsResponse;
//		}

		currentSession.saveOrUpdate(entityName, record);

		dsResponse.setData(record);

		log.debug("GenericDAO.add done");
		return dsResponse;
	}


	public DSResponse update(DSRequest req) throws Exception	{
		log.debug("GenericDAO.update starting");
		
		DataSource ds = req.getDataSource();
		Object primaryKey = ds.getPrimaryKey();
		String entityName = ((BasicDataSource)ds).getProperty("mappedBeanClass");
		Session currentSession = sessionFactory.getCurrentSession();		
		DSResponse dsResponse = new DSResponse();
		
		log.debug("GenericDAO.update class: " + entityName);


		// perform validation
//		ErrorReport errorReport = dsRequest.getDataSource().validate(newValues, false);
//		if (errorReport != null) {
//			dsResponse.setStatus(DSResponse.STATUS_VALIDATION_ERROR);
//			dsResponse.setErrorReport(errorReport);
//			System.out.println("Errors: " + DataTools.prettyPrint(errorReport));
//			return dsResponse;
//		}

		Serializable id = (Serializable)req.getFieldValue(primaryKey);
		Object record = null;
		if (id != null) {
			record = currentSession.get(entityName, id);
		} else {
			log.error("GenericDAO.update Error: the primary key value was not supplied in the update request");
			throw new Exception("GenericDAO.update Error: the primary key value was not supplied in the update request");
		}

		DataTools.setProperties(req.getValues(), record);
		
		currentSession.saveOrUpdate(entityName, record);

		dsResponse.setData(record);
		
		log.debug("GenericDAO.update done");
		return dsResponse;
	}


	public DSResponse remove(DSRequest req) throws Exception {
		log.debug("GenericDAO.remove");
		
		DataSource ds = req.getDataSource();
		Object primaryKey = ds.getPrimaryKey();
		String entityName = ((BasicDataSource)ds).getProperty("mappedBeanClass");
		Session currentSession = sessionFactory.getCurrentSession();		
		DSResponse dsResponse = new DSResponse();
		dsResponse.setSuccess();
		
		log.debug("GenericDAO.remove class=" + entityName);

		Serializable id = (Serializable) req.getFieldValue(primaryKey);
		Object record = currentSession.get(entityName, id);
		currentSession.delete(entityName, record);

		dsResponse.setData(req.getCriteria());
		
		log.debug("GenericDAO.remove done");
		return dsResponse;
	}


}

