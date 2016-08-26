//package com.skyquill.minder.model;
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
// * Represents a Hotel reservation
// * 
// * @author mjb
// */
//@Entity
//@Table(name="HOTELRESERVATIONS")
//@PrimaryKeyJoinColumn(name="ID")
//public class HotelReservation extends Reservation  implements Reservable, Serializable  { 
//
//	private static final long serialVersionUID = 7577472295622776147L;
//	private City city;
//	private Long cityId;
//	private Hotel hotel;
//	private Long hotelId;
//	private String otherHotel;
//	private String conf;
//	private Date arrivalDate;
//	private Date checkoutDate;
//	private String roomType;
//	private Float cost = new Float(0);
//	private Currency currency;
//	private String costCenter;
//	private Long currencyId;
//	private String purpose;       
//	private String comments;
//	private Boolean needsFollowUp = false;
//	private boolean dirty;
//
//	public HotelReservation() {
//		this.setResType(Reservable.HOTEL_TYPE);
//	}
//	
//	@OneToOne
//    @JoinColumn(name="CITY_ID", insertable=false, updatable=false)
//	public City getCity() {
//		return city;
//	}
//	public void setCity(City city) {
//		this.city = city;
//	}
//	@OneToOne
//    @JoinColumn(name="HOTEL_ID", insertable=false, updatable=false)
//	public Hotel getHotel() {
//		return hotel;
//	}
//	public void setHotel(Hotel hotel) {
//		this.hotel = hotel;
//	}
//    @Column(name="OTHER_HOTEL", length=120)
//	public String getOtherHotel() {
//		return otherHotel;
//	}
//	public void setOtherHotel(String otherHotel) {
//		this.otherHotel = otherHotel;
//	}
//    @Column(name="ARRIVAL_DATE")
//	public Date getArrivalDate() {
//		return arrivalDate;
//	}
//	public void setArrivalDate(Date arrivalDate) {
//		this.arrivalDate = arrivalDate;
//	}
//    @Column(name="CHECKOUT_DATE")
//	public Date getCheckoutDate() {
//		return checkoutDate;
//	}
//	public void setCheckoutDate(Date checkoutDate) {
//		this.checkoutDate = checkoutDate;
//	}
//    
//    @Column(name="ROOM_TYPE", length=80)
//	public String getRoomType() {
//		return roomType;
//	}
//	public void setRoomType(String roomType) {
//		this.roomType = roomType;
//	}
//    @Column(name="COST")
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
//    @Column(name="COMMENTS", length=400)
//	public String getComments() {
//		return comments;
//	}
//	public void setComments(String comments) {
//		this.comments = comments;
//	}
//	
//    @Column(name="CITY_ID")
//	public Long getCityId() {
//		return cityId;
//	}
//
//	public void setCityId(Long cityId) {
//		this.cityId = cityId;
//	}
//
//    @Column(name="HOTEL_ID")
//	public Long getHotelId() {
//		return hotelId;
//	}
//
//	public void setHotelId(Long hotelId) {
//		this.hotelId = hotelId;
//	}
//
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
//	@Column(name="PURPOSE", length=240)
//	public String getPurpose() {
//		return purpose;
//	}
//
//	public void setPurpose(String purpose) {
//		this.purpose = purpose;
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
//        if ( !(other instanceof HotelReservation) ) return false;
//
//        final HotelReservation hres = (HotelReservation) other;
//
//        if ( !hres.getId().equals( getId() ) ) return false;
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
//    public HotelReservation clone(long adjTime) {
//    	HotelReservation clone = new HotelReservation();
//
//    	clone.setArrivalDate(new Date(arrivalDate.getTime() + adjTime));
//    	clone.setCheckoutDate(new Date(checkoutDate.getTime() + adjTime));
//    	clone.setCityId(cityId);
//    	clone.setHotelId(hotelId);
//    	clone.setConf(conf);
//    	clone.setRoomType(roomType);
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
