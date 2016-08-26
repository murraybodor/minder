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
public class Reservation extends ModelBase  implements Reservable, Serializable  {

	private static final long serialVersionUID = 378568333787516382L;
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String id;
	@Persistent
	private String itineraryId;
	@Persistent
	private String resType;
	@Persistent
	private Integer order;

	// flight
	@Persistent
	private String airlineId;
	@Persistent
	private String flightNumber;
	@Persistent
	private String originAirportId;
	@Persistent
	private String destAirportId;
	
	// hotel
	@Persistent
	private String cityId;
	@Persistent
	private String hotelId;
	@Persistent
	private String otherHotel;
	@Persistent
	private String conf;
	@Persistent
	private String roomType;
	
	// vehicle
	@Persistent
	private String rentalAgency;
	@Persistent
	private String vehicleType;

	// other
	
	// common
	@Persistent
	private Date resvBeginDate;
	@Persistent
	private String resvBeginTime;
	@Persistent
	private Date resvEndDate;
	@Persistent
	private String resvEndTime;
	@Persistent
	private Float cost = new Float(0);
	@Persistent
	private String currencyId;
	@Persistent
	private String costCenter;
	@Persistent
	private String purpose;       
	@Persistent
	private String comments;
	@Persistent
	private Boolean needsFollowUp = false;
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

	public String getItineraryId() {
		return itineraryId;
	}

	public void setItineraryId(String itineraryId) {
		this.itineraryId = itineraryId;
	}

	public String getResType() {
		return resType;
	}

	public void setResType(String resType) {
		this.resType = resType;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(String airlineId) {
		this.airlineId = airlineId;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getOriginAirportId() {
		return originAirportId;
	}

	public void setOriginAirportId(String originAirportId) {
		this.originAirportId = originAirportId;
	}

	public String getDestAirportId() {
		return destAirportId;
	}

	public void setDestAirportId(String destAirportId) {
		this.destAirportId = destAirportId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getOtherHotel() {
		return otherHotel;
	}

	public void setOtherHotel(String otherHotel) {
		this.otherHotel = otherHotel;
	}

	public String getConf() {
		return conf;
	}

	public void setConf(String conf) {
		this.conf = conf;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRentalAgency() {
		return rentalAgency;
	}

	public void setRentalAgency(String rentalAgency) {
		this.rentalAgency = rentalAgency;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Date getResvBeginDate() {
		return resvBeginDate;
	}

	public void setResvBeginDate(Date resvBeginDate) {
		this.resvBeginDate = resvBeginDate;
	}

	public String getResvBeginTime() {
		return resvBeginTime;
	}

	public void setResvBeginTime(String resvBeginTime) {
		this.resvBeginTime = resvBeginTime;
	}

	public Date getResvEndDate() {
		return resvEndDate;
	}

	public void setResvEndDate(Date resvEndDate) {
		this.resvEndDate = resvEndDate;
	}

	public String getResvEndTime() {
		return resvEndTime;
	}

	public void setResvEndTime(String resvEndTime) {
		this.resvEndTime = resvEndTime;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Boolean getNeedsFollowUp() {
		return needsFollowUp;
	}

	public void setNeedsFollowUp(Boolean needsFollowUp) {
		this.needsFollowUp = needsFollowUp;
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


    public Reservation clone(long adjTime) {
    	Reservation clone = new Reservation();

//    	clone.setFlightDeparture(flightDeparture.clone(adjTime, new Audit(auditUserId, auditDateTime)));
    	
    	clone.setHotelId(hotelId);
    	clone.setConf(conf);
    	clone.setRoomType(roomType);
    	
    	clone.setResvBeginDate(new Date(resvBeginDate.getTime() + adjTime));
//    	clone.setResvBeginTime(new Date(resvBeginTime.getTime() + adjTime));
    	clone.setResvEndDate(new Date(resvEndDate.getTime() + adjTime));
//    	clone.setResvEndTime(new Date(resvEndTime.getTime() + adjTime));
    	
    	clone.setVehicleType(vehicleType);
    	clone.setRentalAgency(rentalAgency);
    	clone.setConf(conf);
    	clone.setCityId(cityId);
    	
    	
    	clone.setCost(cost);
    	clone.setCurrencyId(currencyId);
    	clone.setCostCenter(costCenter);
    	clone.setComments(comments);
    	clone.setPurpose(purpose);
    	clone.setNeedsFollowUp(needsFollowUp);
    	
    	clone.setOrder(getOrder());
    	
    	clone.setVersion(0);
    	
    	return clone;
    	
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((airlineId == null) ? 0 : airlineId.hashCode());
		result = prime * result
				+ ((auditDateTime == null) ? 0 : auditDateTime.hashCode());
		result = prime * result
				+ ((auditUserId == null) ? 0 : auditUserId.hashCode());
		result = prime * result + ((cityId == null) ? 0 : cityId.hashCode());
		result = prime * result
				+ ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((conf == null) ? 0 : conf.hashCode());
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result
				+ ((costCenter == null) ? 0 : costCenter.hashCode());
		result = prime * result
				+ ((currencyId == null) ? 0 : currencyId.hashCode());
		result = prime * result
				+ ((destAirportId == null) ? 0 : destAirportId.hashCode());
		result = prime * result
				+ ((flightNumber == null) ? 0 : flightNumber.hashCode());
		result = prime * result + ((hotelId == null) ? 0 : hotelId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isDeleted ? 1231 : 1237);
		result = prime * result + (isNew ? 1231 : 1237);
		result = prime * result
				+ ((itineraryId == null) ? 0 : itineraryId.hashCode());
		result = prime * result
				+ ((needsFollowUp == null) ? 0 : needsFollowUp.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result
				+ ((originAirportId == null) ? 0 : originAirportId.hashCode());
		result = prime * result
				+ ((otherHotel == null) ? 0 : otherHotel.hashCode());
		result = prime * result + ((purpose == null) ? 0 : purpose.hashCode());
		result = prime * result
				+ ((rentalAgency == null) ? 0 : rentalAgency.hashCode());
		result = prime * result + ((resType == null) ? 0 : resType.hashCode());
		result = prime * result
				+ ((resvBeginDate == null) ? 0 : resvBeginDate.hashCode());
		result = prime * result
				+ ((resvBeginTime == null) ? 0 : resvBeginTime.hashCode());
		result = prime * result
				+ ((resvEndDate == null) ? 0 : resvEndDate.hashCode());
		result = prime * result
				+ ((resvEndTime == null) ? 0 : resvEndTime.hashCode());
		result = prime * result
				+ ((roomType == null) ? 0 : roomType.hashCode());
		result = prime * result
				+ ((vehicleType == null) ? 0 : vehicleType.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Reservation))
			return false;
		Reservation other = (Reservation) obj;
		if (airlineId == null) {
			if (other.airlineId != null)
				return false;
		} else if (!airlineId.equals(other.airlineId))
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
		if (cityId == null) {
			if (other.cityId != null)
				return false;
		} else if (!cityId.equals(other.cityId))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (conf == null) {
			if (other.conf != null)
				return false;
		} else if (!conf.equals(other.conf))
			return false;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (costCenter == null) {
			if (other.costCenter != null)
				return false;
		} else if (!costCenter.equals(other.costCenter))
			return false;
		if (currencyId == null) {
			if (other.currencyId != null)
				return false;
		} else if (!currencyId.equals(other.currencyId))
			return false;
		if (destAirportId == null) {
			if (other.destAirportId != null)
				return false;
		} else if (!destAirportId.equals(other.destAirportId))
			return false;
		if (flightNumber == null) {
			if (other.flightNumber != null)
				return false;
		} else if (!flightNumber.equals(other.flightNumber))
			return false;
		if (hotelId == null) {
			if (other.hotelId != null)
				return false;
		} else if (!hotelId.equals(other.hotelId))
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
		if (itineraryId == null) {
			if (other.itineraryId != null)
				return false;
		} else if (!itineraryId.equals(other.itineraryId))
			return false;
		if (needsFollowUp == null) {
			if (other.needsFollowUp != null)
				return false;
		} else if (!needsFollowUp.equals(other.needsFollowUp))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (originAirportId == null) {
			if (other.originAirportId != null)
				return false;
		} else if (!originAirportId.equals(other.originAirportId))
			return false;
		if (otherHotel == null) {
			if (other.otherHotel != null)
				return false;
		} else if (!otherHotel.equals(other.otherHotel))
			return false;
		if (purpose == null) {
			if (other.purpose != null)
				return false;
		} else if (!purpose.equals(other.purpose))
			return false;
		if (rentalAgency == null) {
			if (other.rentalAgency != null)
				return false;
		} else if (!rentalAgency.equals(other.rentalAgency))
			return false;
		if (resType == null) {
			if (other.resType != null)
				return false;
		} else if (!resType.equals(other.resType))
			return false;
		if (resvBeginDate == null) {
			if (other.resvBeginDate != null)
				return false;
		} else if (!resvBeginDate.equals(other.resvBeginDate))
			return false;
		if (resvBeginTime == null) {
			if (other.resvBeginTime != null)
				return false;
		} else if (!resvBeginTime.equals(other.resvBeginTime))
			return false;
		if (resvEndDate == null) {
			if (other.resvEndDate != null)
				return false;
		} else if (!resvEndDate.equals(other.resvEndDate))
			return false;
		if (resvEndTime == null) {
			if (other.resvEndTime != null)
				return false;
		} else if (!resvEndTime.equals(other.resvEndTime))
			return false;
		if (roomType == null) {
			if (other.roomType != null)
				return false;
		} else if (!roomType.equals(other.roomType))
			return false;
		if (vehicleType == null) {
			if (other.vehicleType != null)
				return false;
		} else if (!vehicleType.equals(other.vehicleType))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
	
	
}
