//package com.skyquill.minder.model;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import javax.persistence.*;
//
//import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.Parameter;
//
//
///**
// * Represents a reservation base class, using the joined inheritance strategy with a discriminator value
// * 
// * @author mjb
// */
//@Entity
//@Table(name="RESERVATIONS")
//public class ItineraryItem extends ModelBase  implements Reservable, Serializable  {
//
//	private static final long serialVersionUID = 7526472295622776147L;
//	
//	private Long id;
//	protected Itinerary itinerary;
//	private Long itineraryId;
//	private String resType;
//	private Integer order;
//
//	// flight
//	private FlightDeparture flightDeparture;
//	private Long flightDepartureId;
//	private FareSchedule fareSchedule;
//	private Long fareScheduleId;
////	private Boolean newFlight;
//	
//	// hotel
//	private City city;
//	private Long cityId;
//	private Hotel hotel;
//	private Long hotelId;
//	private String otherHotel;
//	private String conf;
//	private Date arrivalDate;
//	private Date checkoutDate;
//	private String roomType;
//	
//	// vehicle
//	private Date startDate;
//	private Date endDate;
//	private String rentalAgency;
//	private String vehicleType;
//
//	// other
//	private Date resvDate;
//	
//	// common
//	private Float cost = new Float(0);
//	private Currency currency;
//	private Long currencyId;
//	private String costCenter;
//	private String purpose;       
//	private String comments;
//	private Boolean needsFollowUp = false;
//	private Date auditDateTime;
//	private String auditUserId;
//	private Integer version;
//	
//	private boolean isNew = false;
//	private boolean isDeleted = false;
//	
//
//	@Id 
//	@GeneratedValue(strategy = GenerationType.AUTO, generator = "RESERVATIONS_SEQ")  
//	@SequenceGenerator(name = "RESERVATIONS_SEQ", sequenceName = "RESERVATIONS_SEQ")  
//	@Column(name="ID", insertable=false, updatable=false)
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	
//    @ManyToOne()
//    @JoinColumn(name="ITINERARY_ID", insertable=false, updatable=false)
//	public Itinerary getItinerary() {
//		return itinerary;
//	}
//	public void setItinerary(Itinerary itinerary) {
//		this.itinerary = itinerary;
//	}
//
//	@Column(name="ITINERARY_ID")
//	public Long getItineraryId() {
//		return itineraryId;
//	}
//	public void setItineraryId(Long itineraryId) {
//		this.itineraryId = itineraryId;
//	}
//	
//	@Column(name="RES_TYPE")
//	public String getResType() {
//		return resType;
//	}
//	public void setResType(String resType) {
//		this.resType = resType;
//	}
//	
//    @Column(name="RESV_ORDER")
//	public Integer getOrder() {
//		return order;
//	}
//	public void setOrder(Integer order) {
//		this.order = order;
//	}	
//	
//    @ManyToOne()
//    @JoinColumn(name="FLIGHTDEPARTURE_ID", insertable=false, updatable=false)
//	public FlightDeparture getFlightDeparture() {
//		return flightDeparture;
//	}
//	public void setFlightDeparture(FlightDeparture flightDeparture) {
//		this.flightDeparture = flightDeparture;
//	}
//    @Column(name="FLIGHTDEPARTURE_ID")
//	public Long getFlightDepartureId() {
//		return flightDepartureId;
//	}
//	public void setFlightDepartureId(Long flightDepartureId) {
//		this.flightDepartureId = flightDepartureId;
//	}
//    @ManyToOne()
//    @JoinColumn(name="FARESCHEDULE_ID", insertable=false, updatable=false)
//	public FareSchedule getFareSchedule() {
//		return fareSchedule;
//	}
//	public void setFareSchedule(FareSchedule fareSchedule) {
//		this.fareSchedule = fareSchedule;
//	}
//    @Column(name="FARESCHEDULE_ID")
//	public Long getFareScheduleId() {
//		return fareScheduleId;
//	}
//	public void setFareScheduleId(Long fareScheduleId) {
//		this.fareScheduleId = fareScheduleId;
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
//	
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
//	@Column(name="RESV_DATE")
//	public Date getResvDate() {
//		return resvDate;
//	}
//	public void setResvDate(Date resvDate) {
//		this.resvDate = resvDate;
//	}
//	
//	
//	
//	
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
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	@Column(name="AUDIT_DATETIME")
//	public Date getAuditDateTime() {return auditDateTime;}
//	public void setAuditDateTime(Date auditDateTime) {this.auditDateTime = auditDateTime;}
//	@Column(name="AUDIT_USERID", length=20)
//	public String getAuditUserId() {return auditUserId;}
//	public void setAuditUserId(String auditUserId) {this.auditUserId = auditUserId;}
//
//	@Transient
//	public boolean isNew() {
//		return isNew;
//	}
//	public void setNew(boolean isNew) {
//		this.isNew = isNew;
//	}
//	@Transient
//	public boolean isDeleted() {
//		return isDeleted;
//	}
//	public void setDeleted(boolean isDeleted) {
//		this.isDeleted = isDeleted;
//	}
//
//	
//	public boolean equals(Object other) {
//        if (this == other) return true;
//        if ( !(other instanceof Reservation) ) return false;
//
//        final Reservation res = (Reservation) other;
//
//        if ( !res.getId().equals( getId() ) ) return false;
//        if ( !res.getResType().equals( getResType() ) ) return false;
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
//	@Version
//    @Column(name="VERSION")
//	public Integer getVersion() {
//		return version;
//	}
//
//	public void setVersion(Integer version) {
//		this.version = version;
//	}
//
////	@Transient
////	public Reservation getThis() {
////		return this;
////	}
////	
////	@Transient
////	public List<Reservation> getReservations() {
////		List<Reservation> result = new ArrayList<Reservation>();
////		
////		result.add(this);
////		
////		return result;
////	}
////	@Transient
////	public List<HotelReservation> getHotelReservation() {
////		List<HotelReservation> result = new ArrayList<HotelReservation>();
////		
////		result.add((HotelReservation)this);
////
////		return result;
////	}
//	
//    public ItineraryItem clone(long adjTime) {
//    	ItineraryItem clone = new ItineraryItem();
//
//    	clone.setFlightDeparture(flightDeparture.clone(adjTime, new Audit(auditUserId, auditDateTime)));
//    	
//    	clone.setArrivalDate(new Date(arrivalDate.getTime() + adjTime));
//    	clone.setCheckoutDate(new Date(checkoutDate.getTime() + adjTime));
//    	clone.setHotelId(hotelId);
//    	clone.setConf(conf);
//    	clone.setRoomType(roomType);
//    	
//    	clone.setStartDate(new Date(startDate.getTime() + adjTime));
//    	clone.setEndDate(new Date(endDate.getTime() + adjTime));
//    	
//    	clone.setResvDate(new Date(resvDate.getTime() + adjTime));
//    	
//    	clone.setVehicleType(vehicleType);
//    	clone.setRentalAgency(rentalAgency);
//    	clone.setConf(conf);
//    	clone.setCityId(cityId);
//    	
//    	
//    	clone.setCost(cost);
//    	clone.setCurrencyId(currencyId);
//    	clone.setCostCenter(costCenter);
//    	clone.setComments(comments);
//    	clone.setPurpose(purpose);
//    	clone.setNeedsFollowUp(needsFollowUp);
//    	
//    	clone.setOrder(getOrder());
//    	
//    	clone.setVersion(0);
//    	
//    	return clone;
//    	
//    }
//	
//	
//}
