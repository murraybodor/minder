package com.skyquill.minder.model;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION,detachable="true")
public class FareSchedule extends ModelBase  implements Serializable  {
	
	private static final long serialVersionUID = -7733554809019492929L;
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String id;
	@Persistent
	private String flightRouteId;
	@Persistent
	private String fareCategory;
	@Persistent
	private Float standardPrice;
	@Persistent
	private String cabinClass;
	@Persistent
	private Date startDate;
	@Persistent
	private Date endDate;
	@Persistent
	private String endorsements;
	@Persistent
	private Float taxRate;
	@Persistent
	private Float otherFee;
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
	public String getFlightRouteId() {
		return flightRouteId;
	}
	public void setFlightRouteId(String flightRouteId) {
		this.flightRouteId = flightRouteId;
	}
	public String getFareCategory() {
		return fareCategory;
	}
	public void setFareCategory(String fareCategory) {
		this.fareCategory = fareCategory;
	}
	public Float getStandardPrice() {
		return standardPrice;
	}
	public void setStandardPrice(Float standardPrice) {
		this.standardPrice = standardPrice;
	}
	public String getCabinClass() {
		return cabinClass;
	}
	public void setCabinClass(String cabinClass) {
		this.cabinClass = cabinClass;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getEndorsements() {
		return endorsements;
	}
	public void setEndorsements(String endorsements) {
		this.endorsements = endorsements;
	}
	public Float getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(Float taxRate) {
		this.taxRate = taxRate;
	}
	public Float getOtherFee() {
		return otherFee;
	}
	public void setOtherFee(Float otherFee) {
		this.otherFee = otherFee;
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
				+ ((cabinClass == null) ? 0 : cabinClass.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result
				+ ((endorsements == null) ? 0 : endorsements.hashCode());
		result = prime * result
				+ ((fareCategory == null) ? 0 : fareCategory.hashCode());
		result = prime * result
				+ ((flightRouteId == null) ? 0 : flightRouteId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((otherFee == null) ? 0 : otherFee.hashCode());
		result = prime * result
				+ ((standardPrice == null) ? 0 : standardPrice.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((taxRate == null) ? 0 : taxRate.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof FareSchedule))
			return false;
		FareSchedule other = (FareSchedule) obj;
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
		if (cabinClass == null) {
			if (other.cabinClass != null)
				return false;
		} else if (!cabinClass.equals(other.cabinClass))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (endorsements == null) {
			if (other.endorsements != null)
				return false;
		} else if (!endorsements.equals(other.endorsements))
			return false;
		if (fareCategory == null) {
			if (other.fareCategory != null)
				return false;
		} else if (!fareCategory.equals(other.fareCategory))
			return false;
		if (flightRouteId == null) {
			if (other.flightRouteId != null)
				return false;
		} else if (!flightRouteId.equals(other.flightRouteId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (otherFee == null) {
			if (other.otherFee != null)
				return false;
		} else if (!otherFee.equals(other.otherFee))
			return false;
		if (standardPrice == null) {
			if (other.standardPrice != null)
				return false;
		} else if (!standardPrice.equals(other.standardPrice))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (taxRate == null) {
			if (other.taxRate != null)
				return false;
		} else if (!taxRate.equals(other.taxRate))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
	
}
