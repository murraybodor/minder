//package com.skyquill.minder.client;
//
//
//import com.smartgwt.client.data.DataSource;  
//import com.smartgwt.client.data.fields.DataSourceFloatField;  
//import com.smartgwt.client.data.fields.DataSourceIntegerField;  
//import com.smartgwt.client.data.fields.DataSourceTextField;  
//
//public class ItinTreeDataSource extends DataSource {
//
//	private static ItinTreeDataSource instance = null;  
//
//	public static ItinTreeDataSource getInstance() {  
//		if (instance == null) {  
//			instance = new ItinTreeDataSource("itinTreeDS");  
//		}  
//		return instance;  
//	}  
//
//	public ItinTreeDataSource(String id) {  
//
//		setID(id);  
//		setTitleField("Title");  
//		//	         setRecordXPath("/List/employee");  
//		DataSourceTextField titleField = new DataSourceTextField("title", "Title", 128);  
//
//		DataSourceIntegerField idField = new DataSourceIntegerField("id", "ID");  
//		idField.setPrimaryKey(true);  
//		idField.setRequired(true);  
//
//		DataSourceIntegerField parentIdField = new DataSourceIntegerField("parentId", "Manager");  
//		parentIdField.setRequired(true);  
//		parentIdField.setForeignKey(id + ".id");  
//		parentIdField.setRootValue("1");  
//
//		//	         DataSourceTextField jobField = new DataSourceTextField("Job", "Title", 128);  
//		//	         DataSourceTextField emailField = new DataSourceTextField("Email", "Email", 128);  
//		//	         DataSourceTextField statusField = new DataSourceTextField("EmployeeStatus", "Status", 40);  
//		//	         DataSourceFloatField salaryField = new DataSourceFloatField("Salary", "Salary");  
//		//	         DataSourceTextField orgField = new DataSourceTextField("OrgUnit", "Org Unit", 128);  
//		//	         DataSourceTextField genderField = new DataSourceTextField("Gender", "Gender", 7);  
//		//	         genderField.setValueMap("male", "female");  
//		//	         DataSourceTextField maritalStatusField = new DataSourceTextField("MaritalStatus", "Marital Status", 10);  
//
//		setFields(idField, parentIdField, titleField);  
//
//		//	         setDataURL("ds/test_data/employees.data.xml");  
//		setClientOnly(true);  
//	}  
//}  	
