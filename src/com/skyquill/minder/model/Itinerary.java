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
public class Itinerary extends ModelBase implements Reservable, Serializable  {

	private static final long serialVersionUID = 1343263415291777847L;
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String id;
	@Persistent
	private Integer ticketNumber;
	@Persistent
	private String name;      
	@Persistent
	private String pnrLocator;      
	@Persistent
	private Boolean international;
	@Persistent
	private String travellerId;
	@Persistent
	private Date departDate;       
	@Persistent
	private Integer tripDays;      
	@Persistent
	private Date returnDate;       
	@Persistent
	private Date reservationDate;  
	@Persistent
	private String purpose;       
	@Persistent
	private String contact;      
	@Persistent
	private String comments;      
	@Persistent
	private String authorizationId;
	@Persistent
	private Float flightCost = new Float(0);
	@Persistent
	private Float tax = new Float(0);
	@Persistent
	private Float totalCost = new Float(0);
	@Persistent
	private String currencyId;
	@Persistent
	private Date auditDateTime;
	@Persistent
	private String auditUserId;
	@Persistent
	private Integer version;

//	private boolean isFetched = false;
	@Persistent
	private boolean isNew = false;
	@Persistent
	private boolean isDeleted = false;
	private boolean isDirty = false;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(Integer ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPnrLocator() {
		return pnrLocator;
	}

	public void setPnrLocator(String pnrLocator) {
		this.pnrLocator = pnrLocator;
	}

	public Boolean getInternational() {
		return international;
	}

	public void setInternational(Boolean international) {
		this.international = international;
	}

	public String getTravellerId() {
		return travellerId;
	}

	public void setTravellerId(String travellerId) {
		this.travellerId = travellerId;
	}

	public Date getDepartDate() {
		return departDate;
	}

	public void setDepartDate(Date departDate) {
		this.departDate = departDate;
	}

	public Integer getTripDays() {
		return tripDays;
	}

	public void setTripDays(Integer tripDays) {
		this.tripDays = tripDays;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getAuthorizationId() {
		return authorizationId;
	}

	public void setAuthorizationId(String authorizationId) {
		this.authorizationId = authorizationId;
	}

	public Float getFlightCost() {
		return flightCost;
	}

	public void setFlightCost(Float flightCost) {
		this.flightCost = flightCost;
	}

	public Float getTax() {
		return tax;
	}

	public void setTax(Float tax) {
		this.tax = tax;
	}

	public Float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Float totalCost) {
		this.totalCost = totalCost;
	}

	public String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
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

//	public boolean isFetched() {
//		return isFetched;
//	}
//
//	public void setFetched(boolean isFetched) {
//		this.isFetched = isFetched;
//	}

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

	public boolean isDirty() {
		return isDirty;
	}

	public void setDirty(boolean isDirty) {
		this.isDirty = isDirty;
	}

//	public Reservation getReservation(Long id) {
//		
//		for (Iterator<Reservation> iterator = reservations.iterator(); iterator.hasNext();) {
//			Reservation resv = (Reservation) iterator.next();
//			if (resv.getId().equals(id))
//				return resv;
//		}
//		return null;
//	}
//	
//	public void addReservation(Reservation reservation) {
//		reservation.setOrder(new Integer(this.reservations.size()+1));
//		reservation.setItinerary(this);
//		this.reservations.add(reservation);
//	}
//	
//	public void setReservation(Reservation resv) {
//		int index = reservations.indexOf(resv);
//		if (index > -1)
//			reservations.set(index, resv);
//		else {
//			addReservation(resv);
//		}
//	}
//
//	public void removeReservation(Reservation resv) {
//		int index = reservations.indexOf(resv);
//		if (index > -1) {
//			resv.setDeleted(true);
//			resv.setItinerary(null);
////			deletedReservations.add(resv);
//			reservations.remove(index);
//		}
//	}
	

//	public void addCostAllocation(CostAllocation allocation) {
//		allocation.setItinerary(this);
//		this.costAllocations.add(allocation);
//	}
//	
//	public void removeCostAllocation(CostAllocation allocation) {
//		int index = costAllocations.indexOf(allocation);
//		if (index > -1) {
//			allocation.setDeleted(true);
//			allocation.setItinerary(null);
////			deletedCostAllocations.add(allocation);
//			costAllocations.remove(index);
//		}
//	}
	
	public Itinerary clone(Date newItinDepDate, String newPnr, Date auditDateTime, String auditUserId) {
		
		Itinerary clone = new Itinerary();
		
		// advance reservation & return dates
		
		long adjTime = 0;
		
		if (newItinDepDate!=null) {
			adjTime = newItinDepDate.getTime() - departDate.getTime();
		}
		
		clone.setDepartDate(new Date(departDate.getTime() + adjTime));
		clone.setReturnDate(new Date(returnDate.getTime() + adjTime));
			
//		for (Iterator<Reservation> iterator2 = reservations.iterator(); iterator2.hasNext();) {
////			Reservation resv = (Reservation) iterator2.next();
////			clone.addReservation(ReservationFactory.getInstance().cloneReservation(resv, adjTime, audit));
//		}

		if (newPnr!=null)
			clone.setPnrLocator(newPnr);
		else
			clone.setPnrLocator(pnrLocator);
		
		clone.setPurpose(purpose);
		clone.setFlightCost(flightCost);
		clone.setTax(tax);
		clone.setTotalCost(totalCost);
		clone.setCurrencyId(currencyId);
		
//		for (Iterator<CostAllocation> iterator2 = costAllocations.iterator(); iterator2.hasNext();) {
//			CostAllocation alloc = (CostAllocation) iterator2.next();
//			CostAllocation clonedAlloc = alloc.clone();
//			clonedAlloc.setAuditDateTime(auditDateTime);
//			clonedAlloc.setAuditUserId(auditUserId);
//			clone.addCostAllocation(clonedAlloc);
//		}
		
		clone.setContact(contact);
		clone.setComments(comments);
		clone.setVersion(0);
		clone.setAuditDateTime(auditDateTime);
		clone.setAuditUserId(auditUserId);

		return clone;
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
				+ ((authorizationId == null) ? 0 : authorizationId.hashCode());
		result = prime * result
				+ ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result
				+ ((currencyId == null) ? 0 : currencyId.hashCode());
		result = prime * result
				+ ((departDate == null) ? 0 : departDate.hashCode());
		result = prime * result
				+ ((flightCost == null) ? 0 : flightCost.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((international == null) ? 0 : international.hashCode());
		result = prime * result + (isDeleted ? 1231 : 1237);
		result = prime * result + (isDirty ? 1231 : 1237);
		result = prime * result + (isNew ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((pnrLocator == null) ? 0 : pnrLocator.hashCode());
		result = prime * result + ((purpose == null) ? 0 : purpose.hashCode());
		result = prime * result
				+ ((reservationDate == null) ? 0 : reservationDate.hashCode());
		result = prime * result
				+ ((returnDate == null) ? 0 : returnDate.hashCode());
		result = prime * result + ((tax == null) ? 0 : tax.hashCode());
		result = prime * result
				+ ((ticketNumber == null) ? 0 : ticketNumber.hashCode());
		result = prime * result
				+ ((totalCost == null) ? 0 : totalCost.hashCode());
		result = prime * result
				+ ((travellerId == null) ? 0 : travellerId.hashCode());
		result = prime * result
				+ ((tripDays == null) ? 0 : tripDays.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Itinerary))
			return false;
		Itinerary other = (Itinerary) obj;
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
		if (authorizationId == null) {
			if (other.authorizationId != null)
				return false;
		} else if (!authorizationId.equals(other.authorizationId))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (currencyId == null) {
			if (other.currencyId != null)
				return false;
		} else if (!currencyId.equals(other.currencyId))
			return false;
		if (departDate == null) {
			if (other.departDate != null)
				return false;
		} else if (!departDate.equals(other.departDate))
			return false;
		if (flightCost == null) {
			if (other.flightCost != null)
				return false;
		} else if (!flightCost.equals(other.flightCost))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (international == null) {
			if (other.international != null)
				return false;
		} else if (!international.equals(other.international))
			return false;
		if (isDeleted != other.isDeleted)
			return false;
		if (isDirty != other.isDirty)
			return false;
		if (isNew != other.isNew)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pnrLocator == null) {
			if (other.pnrLocator != null)
				return false;
		} else if (!pnrLocator.equals(other.pnrLocator))
			return false;
		if (purpose == null) {
			if (other.purpose != null)
				return false;
		} else if (!purpose.equals(other.purpose))
			return false;
		if (reservationDate == null) {
			if (other.reservationDate != null)
				return false;
		} else if (!reservationDate.equals(other.reservationDate))
			return false;
		if (returnDate == null) {
			if (other.returnDate != null)
				return false;
		} else if (!returnDate.equals(other.returnDate))
			return false;
		if (tax == null) {
			if (other.tax != null)
				return false;
		} else if (!tax.equals(other.tax))
			return false;
		if (ticketNumber == null) {
			if (other.ticketNumber != null)
				return false;
		} else if (!ticketNumber.equals(other.ticketNumber))
			return false;
		if (totalCost == null) {
			if (other.totalCost != null)
				return false;
		} else if (!totalCost.equals(other.totalCost))
			return false;
		if (travellerId == null) {
			if (other.travellerId != null)
				return false;
		} else if (!travellerId.equals(other.travellerId))
			return false;
		if (tripDays == null) {
			if (other.tripDays != null)
				return false;
		} else if (!tripDays.equals(other.tripDays))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
}
