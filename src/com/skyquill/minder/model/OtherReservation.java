//package com.skyquill.minder.model;
//
//import java.io.Serializable;
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//import javax.persistence.Transient;
//
//
///**
// * Represents an other reservation
// * 
// * @author mjb
// */
//@Entity
//@Table(name="OTHERRESERVATIONS")
//public class OtherReservation extends Reservation  implements Reservable, Serializable  {
//
//	private static final long serialVersionUID = 7526472295622776147L;
//	private Date resvDate;
//	private City city;
//	private Long cityId;
//	private Float cost = new Float(0);
//	private Currency currency;
//	private Long currencyId;
//	private String costCenter;
//	private String purpose;       
//	private String comments;
//	private Boolean needsFollowUp = false;
//	private boolean dirty;
//	
//	public OtherReservation() {
//		this.setResType(Reservable.OTHER_TYPE);
//	}
//	@Column(name="RESV_DATE")
//	public Date getResvDate() {
//		return resvDate;
//	}
//	public void setResvDate(Date resvDate) {
//		this.resvDate = resvDate;
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
//    @Column(name="COST_CENTER", length=40)
//	public String getCostCenter() {
//		return costCenter;
//	}
//
//	public void setCostCenter(String costCenter) {
//		this.costCenter = costCenter;
//	}
//    
//	public void setCurrencyId(Long currencyId) {
//		this.currencyId = currencyId;
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
//        if ( !(other instanceof OtherReservation) ) return false;
//
//        final OtherReservation ores = (OtherReservation) other;
//
//        if ( !ores.getId().equals( getId() ) ) return false;
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
//    public OtherReservation clone(long adjTime) {
//    	OtherReservation clone = new OtherReservation();
//
//    	clone.setCityId(cityId);
//    	clone.setResvDate(new Date(resvDate.getTime() + adjTime));
//    	clone.setCost(cost);
//    	clone.setCurrencyId(currencyId);
//    	clone.setCostCenter(costCenter);
//    	clone.setPurpose(purpose);
//    	clone.setComments(comments);
//    	clone.setNeedsFollowUp(needsFollowUp);
//    	clone.setOrder(getOrder());
//    	
//    	return clone;
//    	
//    }
//    
//}
