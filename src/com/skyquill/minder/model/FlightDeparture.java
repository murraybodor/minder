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
public class FlightDeparture extends ModelBase implements Serializable  {

	private static final long serialVersionUID = -9092186198449792313L;
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String id;
	@Persistent
	private String flightRouteId;
	@Persistent
	private Date departureDate;
	@Persistent
	private Integer departureTimeHrs;
	@Persistent
	private Integer departureTimeMins;
	@Persistent
	private Date arrivalDate;
	@Persistent
	private Integer arrivalTimeHrs;
	@Persistent
	private Integer arrivalTimeMins;
	@Persistent
	private String flightStatus;
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

	public String getFlightRouteId() {
		return flightRouteId;
	}

	public void setFlightRouteId(String flightRouteId) {
		this.flightRouteId = flightRouteId;
	}
	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getFlightStatus() {
		return flightStatus;
	}

	public void setFlightStatus(String flightStatus) {
		this.flightStatus = flightStatus;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getDepartureTimeHrs() {
		return departureTimeHrs;
	}

	public void setDepartureTimeHrs(Integer departureTimeHrs) {
		this.departureTimeHrs = departureTimeHrs;
	}

	public Integer getDepartureTimeMins() {
		return departureTimeMins;
	}

	public void setDepartureTimeMins(Integer departureTimeMins) {
		this.departureTimeMins = departureTimeMins;
	}

	public Integer getArrivalTimeHrs() {
		return arrivalTimeHrs;
	}

	public void setArrivalTimeHrs(Integer arrivalTimeHrs) {
		this.arrivalTimeHrs = arrivalTimeHrs;
	}

	public Integer getArrivalTimeMins() {
		return arrivalTimeMins;
	}

	public void setArrivalTimeMins(Integer arrivalTimeMins) {
		this.arrivalTimeMins = arrivalTimeMins;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((arrivalDate == null) ? 0 : arrivalDate.hashCode());
		result = prime * result
				+ ((arrivalTimeHrs == null) ? 0 : arrivalTimeHrs.hashCode());
		result = prime * result
				+ ((arrivalTimeMins == null) ? 0 : arrivalTimeMins.hashCode());
		result = prime * result
				+ ((auditDateTime == null) ? 0 : auditDateTime.hashCode());
		result = prime * result
				+ ((auditUserId == null) ? 0 : auditUserId.hashCode());
		result = prime * result
				+ ((comments == null) ? 0 : comments.hashCode());
		result = prime * result
				+ ((departureDate == null) ? 0 : departureDate.hashCode());
		result = prime
				* result
				+ ((departureTimeHrs == null) ? 0 : departureTimeHrs.hashCode());
		result = prime
				* result
				+ ((departureTimeMins == null) ? 0 : departureTimeMins
						.hashCode());
		result = prime * result
				+ ((flightRouteId == null) ? 0 : flightRouteId.hashCode());
		result = prime * result
				+ ((flightStatus == null) ? 0 : flightStatus.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof FlightDeparture))
			return false;
		FlightDeparture other = (FlightDeparture) obj;
		if (arrivalDate == null) {
			if (other.arrivalDate != null)
				return false;
		} else if (!arrivalDate.equals(other.arrivalDate))
			return false;
		if (arrivalTimeHrs == null) {
			if (other.arrivalTimeHrs != null)
				return false;
		} else if (!arrivalTimeHrs.equals(other.arrivalTimeHrs))
			return false;
		if (arrivalTimeMins == null) {
			if (other.arrivalTimeMins != null)
				return false;
		} else if (!arrivalTimeMins.equals(other.arrivalTimeMins))
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
		if (departureDate == null) {
			if (other.departureDate != null)
				return false;
		} else if (!departureDate.equals(other.departureDate))
			return false;
		if (departureTimeHrs == null) {
			if (other.departureTimeHrs != null)
				return false;
		} else if (!departureTimeHrs.equals(other.departureTimeHrs))
			return false;
		if (departureTimeMins == null) {
			if (other.departureTimeMins != null)
				return false;
		} else if (!departureTimeMins.equals(other.departureTimeMins))
			return false;
		if (flightRouteId == null) {
			if (other.flightRouteId != null)
				return false;
		} else if (!flightRouteId.equals(other.flightRouteId))
			return false;
		if (flightStatus == null) {
			if (other.flightStatus != null)
				return false;
		} else if (!flightStatus.equals(other.flightStatus))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

//	public FlightDeparture clone(long adjTime, Audit audit) {
//		FlightDeparture clone = new FlightDeparture();
//
//		clone.setFlightRoute(flightRoute.clone(audit));
//		
//		clone.setDepartureDate(new Date(departureDate.getTime() + adjTime));
//		clone.setDepartureTimeHrs(departureTimeHrs);
//		clone.setDepartureTimeMins(departureTimeMins);
//		
//		clone.setArrivalDate(new Date(arrivalDate.getTime() + adjTime));
//		clone.setArrivalTimeHrs(arrivalTimeHrs);
//		clone.setArrivalTimeMins(arrivalTimeMins);
//		
//		clone.setFlightStatus(flightStatus);
//		clone.setComments(comments);
//		clone.setVersion(0);
//		clone.setAudit(audit);
//		
//		return clone;
//	}
}
