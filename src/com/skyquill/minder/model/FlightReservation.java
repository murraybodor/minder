//package com.skyquill.minder.model;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//import javax.persistence.Transient;
//
//
///**
// * Represents a Flight Booking
// * 
// * @author mjb
// */
//@Entity
//@Table(name="FLIGHTRESERVATIONS")
//public class FlightReservation extends Reservation implements Reservable, Serializable  {
//
//	private static final long serialVersionUID = 7526472295622776147L;
//	private FlightDeparture flightDeparture;
////	private Long flightDepartureId;
//	private FareSchedule fareSchedule;
//	private Float cost = new Float(0);
//	private Currency currency;
//	private Long currencyId;
//	private String costCenter;
//	private String purpose;       
//	private String comments;
//	private Boolean newFlight;
//	private Boolean needsFollowUp = false;
//	private boolean dirty;
//	
//	public FlightReservation() {
//		this.setResType(Reservable.FLIGHT_TYPE);
//	}
//    @ManyToOne()
//    @JoinColumn(name="FLIGHTDEPARTURE_ID")
//	public FlightDeparture getFlightDeparture() {
//		return flightDeparture;
//	}
//	public void setFlightDeparture(FlightDeparture flightDeparture) {
//		this.flightDeparture = flightDeparture;
//	}
////    @Column(name="FLIGHTDEPARTURE_ID")
////	public Long getFlightDepartureId() {
////		return flightDepartureId;
////	}
////	public void setFlightDepartureId(Long flightDepartureId) {
////		this.flightDepartureId = flightDepartureId;
////	}
//    @ManyToOne()
//    @JoinColumn(name="FARESCHEDULE_ID")
//	public FareSchedule getFareSchedule() {
//		return fareSchedule;
//	}
//	public void setFareSchedule(FareSchedule fareSchedule) {
//		this.fareSchedule = fareSchedule;
//	}
//	@Column(name="COST")
//	public Float getCost() {
//		return cost;
//	}
//	public void setCost(Float cost) {
//		this.cost = cost;
//	}
//	@OneToOne
//    @JoinColumn(name="CURRENCY_ID", insertable=false, updatable=false)
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
//	@Column(name="PURPOSE", length=240)
//	public String getPurpose() {
//		return purpose;
//	}
//
//	public void setPurpose(String purpose) {
//		this.purpose = purpose;
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
//	public Boolean isNewFlight() {
//		return newFlight;
//	}
//	public void setNewFlight(Boolean newFlight) {
//		this.newFlight = newFlight;
//	}
//	
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
//        if ( !(other instanceof FlightReservation) ) return false;
//
//        final FlightReservation fres = (FlightReservation) other;
//
//        if ( !fres.getId().equals( getId() ) ) return false;
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
//    public FlightReservation clone(long adjTime, Audit audit) {
//    	FlightReservation clone = new FlightReservation();
//
//    	clone.setFlightDeparture(flightDeparture.clone(adjTime, audit));
//    	
//    	clone.setCost(cost);
//    	clone.setCurrencyId(currencyId);
//    	clone.setCostCenter(costCenter);
//    	clone.setComments(comments);
//    	clone.setOrder(getOrder());
//    	clone.setPurpose(purpose);
//    	clone.setNeedsFollowUp(needsFollowUp);
//    	clone.setVersion(0);
//    	clone.setAudit(audit);
//    	
//    	return clone;
//    	
//    }
//    
//}
