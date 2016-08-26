package com.skyquill.minder.model;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable="true")
public class Vaccination extends ModelBase implements Serializable  {

	private static final long serialVersionUID = 249231354649363928L;
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String id;
	@Persistent
	private String travellerId;
	@Persistent
	private String vaccinationType;
	@Persistent
	private Date vaccinationDate;
	@Persistent
	private Date expiryDate;
	@Persistent
	private boolean remindOnExpiry;
	@Persistent
	private Date remindDate;
	@Persistent
	private Date booster1DueDate;
	@Persistent
	private Date booster1RemindDate;
	@Persistent
	private Date booster2DueDate;
	@Persistent
	private Date booster2RemindDate;
	@Persistent
	private String comments;
	@Persistent
	private Date auditDateTime;
    @Persistent
	private String auditUserId;
    @Persistent
	private Integer version;
    @Persistent
	private boolean isNew = false;
    @Persistent
	private boolean isDeleted = false;

    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTravellerId() {
		return travellerId;
	}
	public void setTravellerId(String travellerId) {
		this.travellerId = travellerId;
	}
	public String getVaccinationType() {
		return vaccinationType;
	}
	public void setVaccinationType(String vaccinationType) {
		this.vaccinationType = vaccinationType;
	}
	public Date getVaccinationDate() {
		return vaccinationDate;
	}
	public void setVaccinationDate(Date vaccinationDate) {
		this.vaccinationDate = vaccinationDate;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public boolean isRemindOnExpiry() {
		return remindOnExpiry;
	}
	public void setRemindOnExpiry(boolean remindOnExpiry) {
		this.remindOnExpiry = remindOnExpiry;
	}
	public Date getRemindDate() {
		return remindDate;
	}
	public void setRemindDate(Date remindDate) {
		this.remindDate = remindDate;
	}
	public Date getBooster1DueDate() {
		return booster1DueDate;
	}
	public void setBooster1DueDate(Date booster1DueDate) {
		this.booster1DueDate = booster1DueDate;
	}
	public Date getBooster1RemindDate() {
		return booster1RemindDate;
	}
	public void setBooster1RemindDate(Date booster1RemindDate) {
		this.booster1RemindDate = booster1RemindDate;
	}
	public Date getBooster2DueDate() {
		return booster2DueDate;
	}
	public void setBooster2DueDate(Date booster2DueDate) {
		this.booster2DueDate = booster2DueDate;
	}
	public Date getBooster2RemindDate() {
		return booster2RemindDate;
	}
	public void setBooster2RemindDate(Date booster2RemindDate) {
		this.booster2RemindDate = booster2RemindDate;
	}
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
	public boolean isNew() {
		return isNew;
	}
	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
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
				+ ((booster1DueDate == null) ? 0 : booster1DueDate.hashCode());
		result = prime
				* result
				+ ((booster1RemindDate == null) ? 0 : booster1RemindDate
						.hashCode());
		result = prime * result
				+ ((booster2DueDate == null) ? 0 : booster2DueDate.hashCode());
		result = prime
				* result
				+ ((booster2RemindDate == null) ? 0 : booster2RemindDate
						.hashCode());
		result = prime * result
				+ ((comments == null) ? 0 : comments.hashCode());
		result = prime * result
				+ ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isDeleted ? 1231 : 1237);
		result = prime * result + (isNew ? 1231 : 1237);
		result = prime * result
				+ ((remindDate == null) ? 0 : remindDate.hashCode());
		result = prime * result + (remindOnExpiry ? 1231 : 1237);
		result = prime * result
				+ ((travellerId == null) ? 0 : travellerId.hashCode());
		result = prime * result
				+ ((vaccinationDate == null) ? 0 : vaccinationDate.hashCode());
		result = prime * result
				+ ((vaccinationType == null) ? 0 : vaccinationType.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vaccination other = (Vaccination) obj;
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
		if (booster1DueDate == null) {
			if (other.booster1DueDate != null)
				return false;
		} else if (!booster1DueDate.equals(other.booster1DueDate))
			return false;
		if (booster1RemindDate == null) {
			if (other.booster1RemindDate != null)
				return false;
		} else if (!booster1RemindDate.equals(other.booster1RemindDate))
			return false;
		if (booster2DueDate == null) {
			if (other.booster2DueDate != null)
				return false;
		} else if (!booster2DueDate.equals(other.booster2DueDate))
			return false;
		if (booster2RemindDate == null) {
			if (other.booster2RemindDate != null)
				return false;
		} else if (!booster2RemindDate.equals(other.booster2RemindDate))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (expiryDate == null) {
			if (other.expiryDate != null)
				return false;
		} else if (!expiryDate.equals(other.expiryDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isDeleted != other.isDeleted)
			return false;
		if (isNew != other.isNew)
			return false;
		if (remindDate == null) {
			if (other.remindDate != null)
				return false;
		} else if (!remindDate.equals(other.remindDate))
			return false;
		if (remindOnExpiry != other.remindOnExpiry)
			return false;
		if (travellerId == null) {
			if (other.travellerId != null)
				return false;
		} else if (!travellerId.equals(other.travellerId))
			return false;
		if (vaccinationDate == null) {
			if (other.vaccinationDate != null)
				return false;
		} else if (!vaccinationDate.equals(other.vaccinationDate))
			return false;
		if (vaccinationType == null) {
			if (other.vaccinationType != null)
				return false;
		} else if (!vaccinationType.equals(other.vaccinationType))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
	
}
