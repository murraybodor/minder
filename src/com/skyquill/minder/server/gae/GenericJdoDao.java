package com.skyquill.minder.server.gae;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.springframework.stereotype.Repository;

import com.isomorphic.datasource.BasicDataSource;
import com.isomorphic.datasource.DSRequest;
import com.isomorphic.datasource.DSResponse;
import com.isomorphic.datasource.DataSource;
import com.isomorphic.log.Logger;
import com.isomorphic.util.DataTools;
import com.skyquill.minder.model.ModelBase;

@Repository
public class GenericJdoDao {

	private Logger log = new Logger(GenericJdoDao.class.getName());
	
	@SuppressWarnings("unchecked")
	public DSResponse fetch(DSRequest req) throws Exception {
		log.debug("GenericDAO.fetch starting");

		DataSource ds = req.getDataSource();
		String entityName = ((BasicDataSource)ds).getProperty("mappedBeanClass");
		log.debug("GenericDAO.fetch ds=" + ds.getName() + " class=" + entityName);

		PersistenceManager pm = PMF.get().getPersistenceManager();

		DSResponse dsResponse = new DSResponse();

		try {
			pm.currentTransaction().begin();

			String id = (String)req.getFieldValue("id");
			
			if (id !=null) {
				Object obj = pm.getObjectById(Class.forName(entityName), id);			
				log.info("GenericDAO.fetching specific " + entityName + " with id=" + id);
				dsResponse.setData(obj);
				dsResponse.setTotalRows(obj==null?0:1);
			} else {
				StringBuffer searchQuery = new StringBuffer();
				List<? extends ModelBase> objects = null;
				Query query = null;

				if (entityName.equals("com.skyquill.minder.model.Traveller")) {
					String firstName = (String)req.getFieldValue("firstName");
					if (firstName != null) {
						String firstNameQuery = firstName.substring(0, 1).toUpperCase();
						if (firstName.length()>1) {
							firstNameQuery = firstNameQuery + firstName.substring(1);
						}
						searchQuery.append(" firstName.matches('" + firstNameQuery + ".*') ");
					}
					String lastName = (String)req.getFieldValue("lastName");
					if (lastName != null) {
						String lastNameQuery = lastName.substring(0, 1).toUpperCase();
						if (lastName.length()>1) {
							lastNameQuery = lastNameQuery + lastName.substring(1);
						}
						searchQuery.append(" lastName.matches('" + lastNameQuery + ".*') ");
					}

					log.info("GenericDAO.fetch using query: " + searchQuery.toString());
					if (searchQuery.length()>0)
						query = pm.newQuery (Class.forName(entityName), searchQuery.toString());
					else 
						query = pm.newQuery (Class.forName(entityName));
					objects = (List<? extends ModelBase>) query.execute();
				} else {
					String travellerId = (String)req.getFieldValue("travellerId");
					if (travellerId != null) {
						searchQuery.append(" travellerId == travellerIdParam");

						log.info("GenericDAO.fetch getting: " + entityName + " for traveller " + travellerId);

						query = pm.newQuery (Class.forName(entityName), searchQuery.toString());
						query.declareParameters("String travellerIdParam");
						objects = (List<? extends ModelBase>) query.execute(travellerId);
					} else {
						log.info("GenericDAO.fetch getting all of: " + entityName);
						query = pm.newQuery (Class.forName(entityName));
						objects = (List<? extends ModelBase>) query.execute();
					}
				}
				log.info("GenericDAO.fetch done, got " + objects.size() + " objects");
//				for (Iterator iterator = objects.iterator(); iterator.hasNext();) {
//					ModelBase base = (ModelBase) iterator.next();
//					if (base instanceof Visa) {
//						Visa visa = (Visa) base;
//						String travId = visa.getTravellerId();
//						log.info("GenericDAO.fetch got a visa with travid=" + travId);
//					} else {
//						log.info("GenericDAO.fetch got something other than a visa");
//
//					}
//				}
				dsResponse.setData(objects);
				dsResponse.setTotalRows(objects.size());
			}

			pm.currentTransaction().commit();
		}
		catch (Exception e)
		{
			if (pm.currentTransaction().isActive())
			{
				pm.currentTransaction().rollback();
			}
		}		

		// DataSource protocol: get requested row range
		long startRow = (int)req.getStartRow();
		long endRow = (int)req.getEndRow();
		dsResponse.setStartRow(startRow);
		dsResponse.setEndRow(endRow);
		dsResponse.setEndRow(Math.min(endRow, dsResponse.getTotalRows()));

		log.debug("GenericDAO.fetch done");
		return dsResponse;
	}

	@SuppressWarnings("unchecked")
	public DSResponse add(DSRequest req) throws Exception {
		log.debug("GenericDAO.add starting");
		
		DataSource ds = req.getDataSource();
		String entityName = ((BasicDataSource)ds).getProperty("mappedBeanClass");
		
		DSResponse dsResponse = new DSResponse();
		
		log.info("GenericDAO.add class= " + entityName);
		
		Object record = Class.forName(entityName).newInstance();
		
		Map<String, String> vals = req.getValues();
		
		Object travIdObj = vals.get("travellerId");
		if (travIdObj!=null) {
			log.info("GenericDAO.add - object has a travellerId = " + travIdObj.toString());
		} else {
			log.info("GenericDAO.add - object has NO travellerId");
			
		}

		DataTools.setProperties(req.getValues(), record);

		PersistenceManager pm = PMF.get().getPersistenceManager();
		log.debug("GenericDAO.add got pm, trying to save");
		
//		Visa savedVisa = null;
		try {
			pm.currentTransaction().begin();
//			if (record instanceof Visa) {
//				savedVisa = (Visa)record;
//				
//				
//				pm.makePersistent(savedVisa);
//	    		log.info("GenericDAO.add - saving a visa");
//			} else {
				pm.makePersistent(record);
	    		log.info("GenericDAO.add - persisting");
//			}
			pm.currentTransaction().commit();
			log.debug("GenericDAO.add saving committed");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pm.currentTransaction().isActive())
			{
				// Error occurred so rollback the transaction
				log.error("GenericDAO.add rolling back!");
				pm.currentTransaction().rollback();
				throw new Exception("GenericDAO.add rolling back!");
			}
			pm.close();
			log.debug("GenericDAO.add pm closed");
		}
//		if (record instanceof Visa) {
//			log.info("GenericDAO.add - saved a visa with id=" + savedVisa.getId());
//			log.info("GenericDAO.add - saved a visa with travellerId=" + savedVisa.getTravellerId());
//		} else {
//			Traveller trav = (Traveller)record;
//			log.info("GenericDAO.add - saved a traveller with id=" + trav.getId());
//		}
		
		dsResponse.setData(record);

		log.debug("GenericDAO.add done");
		return dsResponse;
	}


	public DSResponse update(DSRequest req) throws Exception	{
		log.debug("GenericDAO.update starting");

		DataSource ds = req.getDataSource();
		Object primaryKey = ds.getPrimaryKey();
		String entityName = ((BasicDataSource)ds).getProperty("mappedBeanClass");
		
		DSResponse dsResponse = new DSResponse();
		
		log.info("GenericDAO.update class: " + entityName);
		PersistenceManager pm = PMF.get().getPersistenceManager();

		Serializable id = (Serializable)req.getFieldValue(primaryKey);
		Object record = null;
		
		if (id != null) {
			log.info("GenericDAO.update retrieving existing object " + id.toString());
			record = pm.getObjectById(Class.forName(entityName), id);
			if (record==null) {
				log.error("GenericDAO.update retrieved null!");
				throw new Exception("GenericDAO.update could not retrieve an object to update for id=" + id);
			}
				
		} else {
			log.error("GenericDAO.update Error: the primary key value was not supplied in the update request");
			throw new Exception("GenericDAO.update Error: the primary key value was not supplied in the update request");
		}

		DataTools.setProperties(req.getValues(), record);
		
        try {
			pm.currentTransaction().begin();
            pm.makePersistent(record);
    		log.info("GenericDAO.update - saved updated object");
			pm.currentTransaction().commit();
        } finally {
			if (pm.currentTransaction().isActive())
			{
				// Error occurred so rollback the transaction
				log.error("GenericDAO.add rolled back!");
				pm.currentTransaction().rollback();
				throw new Exception("GenericDAO.add rolled back!");
			}
			pm.close();
        }
		
		dsResponse.setData(record);
		
		log.debug("GenericDAO.update done");
		return dsResponse;
	}


	public DSResponse remove(DSRequest req) throws Exception {
		log.debug("GenericDAO.remove");
		
		DataSource ds = req.getDataSource();
		String entityName = ((BasicDataSource)ds).getProperty("mappedBeanClass");
		log.info("GenericDAO.remove class=" + entityName);

		String primaryKey = ds.getPrimaryKey();
		log.info("GenericDAO.remove pk=" + primaryKey);
		
		DSResponse dsResponse = new DSResponse();
		dsResponse.setSuccess();

		PersistenceManager pm = PMF.get().getPersistenceManager();
		log.debug("GenericDAO.remove got pm, now trying to remove");
		
        try {
			pm.currentTransaction().begin();
    		log.info("GenericDAO.remove getting object to delete");
        	Object toDelete = pm.getObjectById(primaryKey);
    		log.info("GenericDAO.remove got object to delete");
    		
            pm.deletePersistent(toDelete);
			pm.currentTransaction().commit();
    		log.info("GenericDAO.remove - object removed!");
        }
        catch (Exception e) {
			log.error("GenericDAO.remove caught exception: " + e.getMessage());
			e.printStackTrace();
        } finally {
			if (pm.currentTransaction().isActive())
			{
				// Error occurred so rollback the transaction
				log.error("GenericDAO.remove rolled back!");
				pm.currentTransaction().rollback();
				throw new Exception("GenericDAO.remove failed!");
			}
			pm.close();
        }
		
		dsResponse.setData(req.getCriteria());
		
		log.debug("GenericDAO.remove done");
		return dsResponse;
	}
    
    
}
