//package com.skyquill.minder.model;
//
//
//import java.io.Serializable;
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.persistence.PrimaryKeyJoinColumn;
//import javax.persistence.Table;
//import javax.persistence.Transient;
//
//
///**
// * Represents a vehicle reservation
// * 
// * @author mjb
// */
//@Entity
//@Table(name="VEHICLERESERVATIONS")
//@PrimaryKeyJoinColumn(name="ID")
//public class VehicleReservation extends Reservation implements Reservable, Serializable  {
//	private static final long serialVersionUID = 7523372295622776147L;
//
//	private City city;
//	private Long cityId;
//	private Date startDate;
//	private Date endDate;
//	private String rentalAgency;
//	private String conf;
//	private String vehicleType;
//	private Float cost = new Float(0);
//	private Currency currency;
//	private Long currencyId;
//	private String costCenter;
//	private String purpose;       
//	private String comments;
//	private Boolean needsFollowUp = false;
//	private boolean dirty;
//
//	public VehicleReservation() {
//		this.setResType(Reservable.VEHICLE_TYPE);
//	}
//	
//	@Column(name="START_DATE")
//	public Date getStartDate() {
//		return startDate;
//	}
//	public void setStartDate(Date startDate) {
//		this.startDate = startDate;
//	}
//	@Column(name="END_DATE")
//	public Date getEndDate() {
//		return endDate;
//	}
//	public void setEndDate(Date endDate) {
//		this.endDate = endDate;
//	}
//	@OneToOne
//    @JoinColumn(name="CITY_ID",insertable=false,updatable=false)
//	public City getCity() {
//		return city;
//	}
//	public void setCity(City city) {
//		this.city = city;
//	}
//    @Column(name="CITY_ID")
//	public Long getCityId() {
//		return cityId;
//	}
//	public void setCityId(Long cityId) {
//		this.cityId = cityId;
//	}
//	@Column(name="RENTAL_AGENCY", length=300)
//	public String getRentalAgency() {
//		return rentalAgency;
//	}
//	public void setRentalAgency(String rentalAgency) {
//		this.rentalAgency = rentalAgency;
//	}
//	@Column(name="VEH_TYPE", length=80)
//	public String getVehicleType() {
//		return vehicleType;
//	}
//	public void setVehicleType(String vehicleType) {
//		this.vehicleType = vehicleType;
//	}
//	@Column(name="COST")
//	public Float getCost() {
//		return cost;
//	}
//	public void setCost(Float cost) {
//		this.cost = cost;
//	}
//	@OneToOne
//    @JoinColumn(name="CURRENCY_ID",insertable=false,updatable=false)
//	public Currency getCurrency() {
//		return currency;
//	}
//	public void setCurrency(Currency currency) {
//		this.currency = currency;
//	}
//    @Column(name="CURRENCY_ID")
//	public Long getCurrencyId() {
//		return currencyId;
//	}
//
//	public void setCurrencyId(Long currencyId) {
//		this.currencyId = currencyId;
//	}
//
//    @Column(name="COST_CENTER", length=40)
//	public String getCostCenter() {
//		return costCenter;
//	}
//
//	public void setCostCenter(String costCenter) {
//		this.costCenter = costCenter;
//	}
//
//	@Column(name="COMMENTS", length=400)
//	public String getComments() {
//		return comments;
//	}
//	public void setComments(String comments) {
//		this.comments = comments;
//	}
//
//    @Column(name="CONF", length=40)
//	public String getConf() {
//		return conf;
//	}
//
//	public void setConf(String conf) {
//		this.conf = conf;
//	}
//	
//	@Column(name="PURPOSE", length=240)
//	public String getPurpose() {
//		return purpose;
//	}
//
//	public void setPurpose(String purpose) {
//		this.purpose = purpose;
//	}
//
//	@Column(name="FOLLOWUP")
//	public Boolean getNeedsFollowUp() {
//		return needsFollowUp;
//	}
//
//	public void setNeedsFollowUp(Boolean needsFollowUp) {
//		this.needsFollowUp = needsFollowUp;
//	}
//	
//	@Transient
//	public boolean isDirty() {
//		return dirty;
//	}
//
//	public void setDirty(boolean dirty) {
//		this.dirty = dirty;
//		if (this.itinerary!=null) {
//			itinerary.setDirty(dirty);
//		}
//	}
//	
//	public boolean equals(Object other) {
//        if (this == other) return true;
//        if ( !(other instanceof VehicleReservation) ) return false;
//
//        final VehicleReservation vres = (VehicleReservation) other;
//
//        if ( !vres.getId().equals( getId() ) ) return false;
//
//        return true;
//    }
//
//    public int hashCode() {
//        int result;
//        result = getId()==null?29:getId().hashCode();
//        return result;
//    }
//
//    public VehicleReservation clone(long adjTime) {
//    	VehicleReservation clone = new VehicleReservation();
//
//    	clone.setStartDate(new Date(startDate.getTime() + adjTime));
//    	clone.setEndDate(new Date(endDate.getTime() + adjTime));
//    	clone.setVehicleType(vehicleType);
//    	clone.setRentalAgency(rentalAgency);
//    	clone.setConf(conf);
//    	clone.setCityId(cityId);
//    	clone.setCost(cost);
//    	clone.setCurrencyId(currencyId);
//    	clone.setCostCenter(costCenter);
//    	clone.setComments(comments);
//    	clone.setPurpose(purpose);
//    	clone.setNeedsFollowUp(needsFollowUp);
//    	clone.setOrder(getOrder());
//    	clone.setVersion(0);
//    	
//    	return clone;
//    	
//    }
//
//    
//}
