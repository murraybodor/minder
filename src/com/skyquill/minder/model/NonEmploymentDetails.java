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
public class NonEmploymentDetails extends ModelBase implements Serializable  {

	private static final long serialVersionUID = -819338909440091842L;
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String id;
    @Persistent
    private String travellerId;
	@Persistent
	private String officePhone;
	@Persistent
	private String email;
	@Persistent
	private String title;
	@Persistent
	private String companyName;
	@Persistent
	private String costCenter;
	@Persistent
	private String supervisorName;
	@Persistent
	private String supervisorEmail;
	@Persistent
	private String supervisorPhone;
	@Persistent
	private String corpSupervisorId;
	@Persistent
	private Date contractEffectiveDate;
	@Persistent
	private Date contractExpiryDate;
	@Persistent
	private Traveller traveller;
	@Persistent
	private boolean guest;
	@Persistent
	private boolean dependant;
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
	public String getTravellerId() {
		return travellerId;
	}
	public void setTravellerId(String travellerId) {
		this.travellerId = travellerId;
	}
	public String getOfficePhone() {
		return officePhone;
	}
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCostCenter() {
		return costCenter;
	}
	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}
	public String getSupervisorName() {
		return supervisorName;
	}
	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}
	public String getSupervisorEmail() {
		return supervisorEmail;
	}
	public void setSupervisorEmail(String supervisorEmail) {
		this.supervisorEmail = supervisorEmail;
	}
	public String getSupervisorPhone() {
		return supervisorPhone;
	}
	public void setSupervisorPhone(String supervisorPhone) {
		this.supervisorPhone = supervisorPhone;
	}
	public String getCorpSupervisorId() {
		return corpSupervisorId;
	}
	public void setCorpSupervisorId(String corpSupervisorId) {
		this.corpSupervisorId = corpSupervisorId;
	}
	public Date getContractEffectiveDate() {
		return contractEffectiveDate;
	}
	public void setContractEffectiveDate(Date contractEffectiveDate) {
		this.contractEffectiveDate = contractEffectiveDate;
	}
	public Date getContractExpiryDate() {
		return contractExpiryDate;
	}
	public void setContractExpiryDate(Date contractExpiryDate) {
		this.contractExpiryDate = contractExpiryDate;
	}
	public Traveller getTraveller() {
		return traveller;
	}
	public void setTraveller(Traveller traveller) {
		this.traveller = traveller;
	}
	public boolean isGuest() {
		return guest;
	}
	public void setGuest(boolean guest) {
		this.guest = guest;
	}
	public boolean isDependant() {
		return dependant;
	}
	public void setDependant(boolean dependant) {
		this.dependant = dependant;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((auditDateTime == null) ? 0 : auditDateTime.hashCode());
		result = prime * result
				+ ((auditUserId == null) ? 0 : auditUserId.hashCode());
		result = prime * result
				+ ((comments == null) ? 0 : comments.hashCode());
		result = prime * result
				+ ((companyName == null) ? 0 : companyName.hashCode());
		result = prime
				* result
				+ ((contractEffectiveDate == null) ? 0 : contractEffectiveDate
						.hashCode());
		result = prime
				* result
				+ ((contractExpiryDate == null) ? 0 : contractExpiryDate
						.hashCode());
		result = prime
				* result
				+ ((corpSupervisorId == null) ? 0 : corpSupervisorId.hashCode());
		result = prime * result
				+ ((costCenter == null) ? 0 : costCenter.hashCode());
		result = prime * result + (dependant ? 1231 : 1237);
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (guest ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((officePhone == null) ? 0 : officePhone.hashCode());
		result = prime * result
				+ ((supervisorEmail == null) ? 0 : supervisorEmail.hashCode());
		result = prime * result
				+ ((supervisorName == null) ? 0 : supervisorName.hashCode());
		result = prime * result
				+ ((supervisorPhone == null) ? 0 : supervisorPhone.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result
				+ ((traveller == null) ? 0 : traveller.hashCode());
		result = prime * result
				+ ((travellerId == null) ? 0 : travellerId.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof NonEmploymentDetails))
			return false;
		NonEmploymentDetails other = (NonEmploymentDetails) obj;
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
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (contractEffectiveDate == null) {
			if (other.contractEffectiveDate != null)
				return false;
		} else if (!contractEffectiveDate.equals(other.contractEffectiveDate))
			return false;
		if (contractExpiryDate == null) {
			if (other.contractExpiryDate != null)
				return false;
		} else if (!contractExpiryDate.equals(other.contractExpiryDate))
			return false;
		if (corpSupervisorId == null) {
			if (other.corpSupervisorId != null)
				return false;
		} else if (!corpSupervisorId.equals(other.corpSupervisorId))
			return false;
		if (costCenter == null) {
			if (other.costCenter != null)
				return false;
		} else if (!costCenter.equals(other.costCenter))
			return false;
		if (dependant != other.dependant)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (guest != other.guest)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (officePhone == null) {
			if (other.officePhone != null)
				return false;
		} else if (!officePhone.equals(other.officePhone))
			return false;
		if (supervisorEmail == null) {
			if (other.supervisorEmail != null)
				return false;
		} else if (!supervisorEmail.equals(other.supervisorEmail))
			return false;
		if (supervisorName == null) {
			if (other.supervisorName != null)
				return false;
		} else if (!supervisorName.equals(other.supervisorName))
			return false;
		if (supervisorPhone == null) {
			if (other.supervisorPhone != null)
				return false;
		} else if (!supervisorPhone.equals(other.supervisorPhone))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (traveller == null) {
			if (other.traveller != null)
				return false;
		} else if (!traveller.equals(other.traveller))
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
