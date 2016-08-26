package com.skyquill.minder.client;

//import java.util.HashMap;
//import java.util.Map;
//
//import com.skyquill.minder.model.MetaData;

public class UserSession {
	
//	private static UserSession _instance = null;
	
//	private UserContext userContext;
//	private Map<String, MetaData> metaDataMap = new HashMap<String, MetaData>();
	
//	public static synchronized UserSession getInstance() {
//		if (_instance==null) {
//			_instance = new UserSession();
//		}
//		return _instance;
//	} 	
//
//	private UserSession() {
//	}

//	public UserContext getUserContext() {
//		return userContext;
//	}
//
//	public void setUserContext(UserContext userContext) {
//		this.userContext = userContext;
//		this.setMetaDataMap(userContext.getMetadataMap());
//	}
	
	public static String getUserName() {
		return "murray";
//		return userContext.getUsername();
	}

//	public String getTenantName() {
//		return ((MetaData)metaDataMap.get("TENANT_NAME")).getStringValue();
//	}
//	
//	public void setMetaDataMap(Map<String, MetaData> metaDataMap) {
//		this.metaDataMap = metaDataMap;
//	}
	
	
}
