package com.skyquill.minder.model;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
public class MedicalAssessment extends ModelBase implements Serializable  {

	private static final long serialVersionUID = -3749065554814263817L;
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String id;
	@Persistent
	private String travellerId;
	@Persistent
	private String assessmentType;
	@Persistent
	private Date assessmentDate;
	@Persistent
	private String countryId;
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
	public String getAssessmentType() {
		return assessmentType;
	}
	public void setAssessmentType(String assessmentType) {
		this.assessmentType = assessmentType;
	}
	public Date getAssessmentDate() {
		return assessmentDate;
	}
	public void setAssessmentDate(Date assessmentDate) {
		this.assessmentDate = assessmentDate;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
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
				+ ((assessmentDate == null) ? 0 : assessmentDate.hashCode());
		result = prime * result
				+ ((assessmentType == null) ? 0 : assessmentType.hashCode());
		result = prime * result
				+ ((auditDateTime == null) ? 0 : auditDateTime.hashCode());
		result = prime * result
				+ ((auditUserId == null) ? 0 : auditUserId.hashCode());
		result = prime * result
				+ ((comments == null) ? 0 : comments.hashCode());
		result = prime * result
				+ ((countryId == null) ? 0 : countryId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isDeleted ? 1231 : 1237);
		result = prime * result + (isNew ? 1231 : 1237);
		result = prime * result
				+ ((travellerId == null) ? 0 : travellerId.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof MedicalAssessment))
			return false;
		MedicalAssessment other = (MedicalAssessment) obj;
		if (assessmentDate == null) {
			if (other.assessmentDate != null)
				return false;
		} else if (!assessmentDate.equals(other.assessmentDate))
			return false;
		if (assessmentType == null) {
			if (other.assessmentType != null)
				return false;
		} else if (!assessmentType.equals(other.assessmentType))
			return false;
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
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (countryId == null) {
			if (other.countryId != null)
				return false;
		} else if (!countryId.equals(other.countryId))
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
		if (travellerId == null) {
			if (other.travellerId != null)
				return false;
		} else if (!travellerId.equals(other.travellerId))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
	
}
