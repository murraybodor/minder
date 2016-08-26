package com.skyquill.minder.client;

import com.google.gwt.core.client.GWT;
import com.smartgwt.client.data.DataSource;

public class Cache {

	private static DataSource currenciesDataSource = DataSource.get("currencies");  
	private static DataSource worldAreasDataSource = DataSource.get("worldareas"); 
	private static DataSource countriesDataSource = DataSource.get("countries");  
	private static DataSource airlinesDataSource = DataSource.get("airlines");  
	private static DataSource citiesDataSource = DataSource.get("cities");  
	private static DataSource statesDataSource = DataSource.get("states");  
	private static DataSource adminsDataSource = DataSource.get("adminassistants");  
	private static DataSource supervisorsDataSource = DataSource.get("supervisors");  
	private static DataSource airportsDataSource = DataSource.get("airports");  
	private static DataSource hotelsDataSource = DataSource.get("hotels");  

	// types
	private static DataSource bloodTypeDataSource = DataSource.get("bloodtype");  
	private static DataSource insuranceTypeDataSource = DataSource.get("insurancetype");  
	private static DataSource medicalAssessmentTypeDataSource = DataSource.get("matype");  
	private static DataSource otherDocTypeDataSource = DataSource.get("otherdoctype");  
	private static DataSource reserveSystemTypeDataSource = DataSource.get("resvsystype");  
	private static DataSource roomTypeDataSource = DataSource.get("roomtype");  
	private static DataSource secOrientTypeDataSource = DataSource.get("secorienttype");  
	private static DataSource sosCardTypeDataSource = DataSource.get("soscardtype");  
	private static DataSource vacTypeDataSource = DataSource.get("vactype");  
	private static DataSource vehTypeDataSource = DataSource.get("vehtype");  
	private static DataSource visaTypeDataSource = DataSource.get("visatype");  

	private static DataSource reportParmsDataSource = DataSource.get("reportparameters");  
	
	public static DataSource getCurrenciesDataSource() {
		return currenciesDataSource;
	}

	public static DataSource getWorldAreasDataSource() {
		return worldAreasDataSource;
	}

	public static DataSource getCountriesDataSource() {
		return countriesDataSource;
	}

	public static DataSource getAirlinesDataSource() {
		return airlinesDataSource;
	}

	public static DataSource getCitiesDataSource() {
		return citiesDataSource;
	}

	public static DataSource getStatesDataSource() {
		return statesDataSource;
	}

	public static DataSource getAdminsDataSource() {
		return adminsDataSource;
	}

	public static DataSource getSupervisorsDataSource() {
		return supervisorsDataSource;
	}

	public static DataSource getAirportsDataSource() {
		return airportsDataSource;
	}

	public static DataSource getHotelsDataSource() {
		return hotelsDataSource;
	}

	public static DataSource getBloodTypeDataSource() {
		return bloodTypeDataSource;
	}

	public static DataSource getInsuranceTypeDataSource() {
		return insuranceTypeDataSource;
	}

	public static DataSource getMedicalAssessmentTypeDataSource() {
		return medicalAssessmentTypeDataSource;
	}

	public static DataSource getOtherDocTypeDataSource() {
		return otherDocTypeDataSource;
	}

	public static DataSource getReserveSystemTypeDataSource() {
		return reserveSystemTypeDataSource;
	}

	public static DataSource getRoomTypeDataSource() {
		return roomTypeDataSource;
	}

	public static DataSource getSecOrientTypeDataSource() {
		return secOrientTypeDataSource;
	}

	public static DataSource getSosCardTypeDataSource() {
		return sosCardTypeDataSource;
	}

	public static DataSource getVacTypeDataSource() {
		return vacTypeDataSource;
	}

	public static DataSource getVehTypeDataSource() {
		return vehTypeDataSource;
	}

	public static DataSource getVisaTypeDataSource() {
		return visaTypeDataSource;
	}

	public static DataSource getReportParmsDataSource() {
		return reportParmsDataSource;
	}

	public static void setReportParmsDataSource(DataSource reportParmsDataSource) {
		Cache.reportParmsDataSource = reportParmsDataSource;
	}

	public static void init() {
		GWT.log("Cache.init", null);
	}
	
	

}
