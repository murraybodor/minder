package com.skyquill.minder.client;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;

public class TravellerModel {

	private String travellerId;
	private Record travellerRecord;
	private DataSource travellerDataSource;
	private DataSource personalDetailsDataSource;
	private DataSource employmentDetailsDataSource;
	private DataSource nonEmploymentDetailsDataSource;
	private DataSource itineraryDataSource;
	private DataSource reservationDataSource;
	private DataSource visaDataSource;
	private DataSource passportDataSource;
	private DataSource vaccinationDataSource;
	private DataSource medAssessDataSource;
	private DataSource insuranceDataSource;
	private DataSource sosDataSource;
	private DataSource orientationDataSource;
	private DataSource secProfileDataSource;
	
	public TravellerModel(String travellerId) {
		this.travellerId = travellerId;
		travellerDataSource = DataSource.get("travellers");
		personalDetailsDataSource = DataSource.get("personaldetails");
		employmentDetailsDataSource = DataSource.get("employmentdetails");
		nonEmploymentDetailsDataSource = DataSource.get("nonemploymentdetails");
		itineraryDataSource = DataSource.get("itineraries");
		reservationDataSource = DataSource.get("reservations");
		visaDataSource = DataSource.get("visas");
		passportDataSource = DataSource.get("passports");
		vaccinationDataSource = DataSource.get("vaccinations");
		medAssessDataSource = DataSource.get("medicalassessments");
		insuranceDataSource = DataSource.get("insurances");
		sosDataSource = DataSource.get("soscoverages");
		orientationDataSource = DataSource.get("securityorientations");
		secProfileDataSource = DataSource.get("securityprofiles");
	}

	public DataSource getTravellerDataSource() {
		return travellerDataSource;
	}

	public void setTravellerDataSource(DataSource travellerDataSource) {
		this.travellerDataSource = travellerDataSource;
	}

	public DataSource getPersonalDetailsDataSource() {
		return personalDetailsDataSource;
	}

	public void setPersonalDetailsDataSource(DataSource personalDetailsDataSource) {
		this.personalDetailsDataSource = personalDetailsDataSource;
	}

	public DataSource getEmploymentDetailsDataSource() {
		return employmentDetailsDataSource;
	}

	public void setEmploymentDetailsDataSource(
			DataSource employmentDetailsDataSource) {
		this.employmentDetailsDataSource = employmentDetailsDataSource;
	}

	public DataSource getNonEmploymentDetailsDataSource() {
		return nonEmploymentDetailsDataSource;
	}

	public void setNonEmploymentDetailsDataSource(
			DataSource nonEmploymentDetailsDataSource) {
		this.nonEmploymentDetailsDataSource = nonEmploymentDetailsDataSource;
	}

	public DataSource getItineraryDataSource() {
		return itineraryDataSource;
	}

	public void setItineraryDataSource(DataSource itineraryDataSource) {
		this.itineraryDataSource = itineraryDataSource;
	}

	public DataSource getReservationDataSource() {
		return reservationDataSource;
	}

	public void setReservationDataSource(DataSource reservationDataSource) {
		this.reservationDataSource = reservationDataSource;
	}

	public String getTravellerId() {
		return travellerId;
	}

	public void setTravellerId(String travellerId) {
		this.travellerId = travellerId;
	}

	public Record getTravellerRecord() {
		return travellerRecord;
	}

	public void setTravellerRecord(Record travellerRecord) {
		this.travellerRecord = travellerRecord;
	}

	public DataSource getVisaDataSource() {
		return visaDataSource;
	}

	public void setVisaDataSource(DataSource visaDataSource) {
		this.visaDataSource = visaDataSource;
	}

	public DataSource getPassportDataSource() {
		return passportDataSource;
	}

	public void setPassportDataSource(DataSource passportDataSource) {
		this.passportDataSource = passportDataSource;
	}

	public DataSource getVaccinationDataSource() {
		return vaccinationDataSource;
	}

	public void setVaccinationDataSource(DataSource vaccinationDataSource) {
		this.vaccinationDataSource = vaccinationDataSource;
	}

	public DataSource getMedAssessDataSource() {
		return medAssessDataSource;
	}

	public void setMedAssessDataSource(DataSource medAssessDataSource) {
		this.medAssessDataSource = medAssessDataSource;
	}

	public DataSource getInsuranceDataSource() {
		return insuranceDataSource;
	}

	public void setInsuranceDataSource(DataSource insuranceDataSource) {
		this.insuranceDataSource = insuranceDataSource;
	}

	public DataSource getSosDataSource() {
		return sosDataSource;
	}

	public void setSosDataSource(DataSource sosDataSource) {
		this.sosDataSource = sosDataSource;
	}

	public DataSource getOrientationDataSource() {
		return orientationDataSource;
	}

	public void setOrientationDataSource(DataSource orientationDataSource) {
		this.orientationDataSource = orientationDataSource;
	}

	public DataSource getSecProfileDataSource() {
		return secProfileDataSource;
	}

	public void setSecProfileDataSource(DataSource secProfileDataSource) {
		this.secProfileDataSource = secProfileDataSource;
	}


}
