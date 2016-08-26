package com.skyquill.minder.model;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION,detachable = "true")
public class Traveller extends ModelBase implements Serializable  {

	private static final long serialVersionUID = 7509172694306292271L;
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String id;
	@Persistent
	private String firstName;
	@Persistent
	private String lastName;
	@Persistent
	private Date birthDate;
	@Persistent
	private String birthPlace;
	@Persistent
	private String birthCountryId;
	@Persistent
	private String email;
	@Persistent
	private String homePhone;
	@Persistent
	private String cellPhone;
	@Persistent
	private Boolean employee;
	@Persistent
	private String comments;
	@Persistent
	private Date auditDateTime;
	@Persistent
	private String auditUserId;
	@Persistent
	private Integer version;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getBirthCountryId() {
		return birthCountryId;
	}

	public void setBirthCountryId(String birthCountryId) {
		this.birthCountryId = birthCountryId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public Boolean getEmployee() {
		return employee;
	}

	public void setEmployee(Boolean employee) {
		this.employee = employee;
	}

//	public EmploymentDetails getEmploymentDetails() {
//		return employmentDetails;
//	}
//
//	public void setEmploymentDetails(EmploymentDetails employmentDetails) {
//		this.employmentDetails = employmentDetails;
//	}
//
//	public NonEmploymentDetails getContractDetails() {
//		return contractDetails;
//	}
//
//	public void setContractDetails(NonEmploymentDetails contractDetails) {
//		this.contractDetails = contractDetails;
//	}
//
//	public List<Dependant> getDependants() {
//		return dependants;
//	}
//
//	public void setDependants(List<Dependant> dependants) {
//		this.dependants = dependants;
//	}
//
//	public SecurityProfile getSecurityProfile() {
//		return securityProfile;
//	}
//
//	public void setSecurityProfile(SecurityProfile securityProfile) {
//		this.securityProfile = securityProfile;
//	}
//
//	public List<Itinerary> getItineraries() {
//		return itineraries;
//	}
//
//	public void setItineraries(List<Itinerary> itineraries) {
//		this.itineraries = itineraries;
//	}
//
//	public List<Passport> getPassports() {
//		return passports;
//	}
//
//	public void setPassports(List<Passport> passports) {
//		this.passports = passports;
//	}

//	public List<Visa> getVisas() {
//		return visas;
//	}
//
//	public void setVisas(List<Visa> visas) {
//		this.visas = visas;
//	}

//	public List<Insurance> getInsurances() {
//		return insurances;
//	}
//
//	public void setInsurances(List<Insurance> insurances) {
//		this.insurances = insurances;
//	}
//
//	public List<SecurityOrientation> getSecurities() {
//		return securities;
//	}
//
//	public void setSecurities(List<SecurityOrientation> securities) {
//		this.securities = securities;
//	}
//
//	public List<Vaccination> getVaccinations() {
//		return vaccinations;
//	}
//
//	public void setVaccinations(List<Vaccination> vaccinations) {
//		this.vaccinations = vaccinations;
//	}
//
//	public List<MedicalAssessment> getMedicalAssessments() {
//		return medicalAssessments;
//	}
//
//	public void setMedicalAssessments(List<MedicalAssessment> medicalAssessments) {
//		this.medicalAssessments = medicalAssessments;
//	}
//
//	public SOSCoverage getSosCoverage() {
//		return sosCoverage;
//	}
//
//	public void setSosCoverage(SOSCoverage sosCoverage) {
//		this.sosCoverage = sosCoverage;
//	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getAuditDateTime() {
		return auditDateTime;
	}

	public void setAuditDateTime(Date auditDateTime) {
		this.auditDateTime = auditDateTime;
	}

	public String getAuditUserId() {
		return auditUserId;
	}

	public void setAuditUserId(String auditUserId) {
		this.auditUserId = auditUserId;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((auditDateTime == null) ? 0 : auditDateTime.hashCode());
		result = prime * result
				+ ((auditUserId == null) ? 0 : auditUserId.hashCode());
		result = prime * result
				+ ((birthCountryId == null) ? 0 : birthCountryId.hashCode());
		result = prime * result
				+ ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result
				+ ((birthPlace == null) ? 0 : birthPlace.hashCode());
		result = prime * result
				+ ((cellPhone == null) ? 0 : cellPhone.hashCode());
		result = prime * result
				+ ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((employee == null) ? 0 : employee.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((homePhone == null) ? 0 : homePhone.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Traveller))
			return false;
		Traveller other = (Traveller) obj;
		if (auditDateTime == null) {
			if (other.auditDateTime != null)
				return false;
		} else if (!auditDateTime.equals(other.auditDateTime))
			return false;
		if (auditUserId == null) {
			if (other.auditUserId != null)
				return false;
		} else if (!auditUserId.equals(other.auditUserId))
			return false;
		if (birthCountryId == null) {
			if (other.birthCountryId != null)
				return false;
		} else if (!birthCountryId.equals(other.birthCountryId))
			return false;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (birthPlace == null) {
			if (other.birthPlace != null)
				return false;
		} else if (!birthPlace.equals(other.birthPlace))
			return false;
		if (cellPhone == null) {
			if (other.cellPhone != null)
				return false;
		} else if (!cellPhone.equals(other.cellPhone))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (homePhone == null) {
			if (other.homePhone != null)
				return false;
		} else if (!homePhone.equals(other.homePhone))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	
}
