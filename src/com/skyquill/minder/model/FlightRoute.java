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
public class FlightRoute extends ModelBase implements Serializable  {

	private static final long serialVersionUID = 6518435651483069190L;
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String id;
	@Persistent
	private String airlineId;
	@Persistent
	private String flightNumber;
	@Persistent
	private String originAirportId;
	@Persistent
	private String destAirportId;
	@Persistent
	private String flightCategory;
	@Persistent
	private String availableDays;
	@Persistent
	private Boolean meal;
	@Persistent
	private Boolean movie;
	@Persistent
	private Boolean connecting = false;
	@Persistent
	private Integer numberOfStops;
	@Persistent
	private Integer flightDistance;
	@Persistent
	private String system;
	@Persistent
	private String locator;
	@Persistent
	private String aircraftId;
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
	public String getFlightCategory() {
		return flightCategory;
	}

	public void setFlightCategory(String flightCategory) {
		this.flightCategory = flightCategory;
	}

	public String getAvailableDays() {
		return availableDays;
	}

	public void setAvailableDays(String availableDays) {
		this.availableDays = availableDays;
	}

	public Boolean getMeal() {
		return meal;
	}

	public void setMeal(Boolean meal) {
		this.meal = meal;
	}

	public Boolean getMovie() {
		return movie;
	}

	public void setMovie(Boolean movie) {
		this.movie = movie;
	}

	public Integer getNumberOfStops() {
		return numberOfStops;
	}

	public void setNumberOfStops(Integer numberOfStops) {
		this.numberOfStops = numberOfStops;
	}

	public Integer getFlightDistance() {
		return flightDistance;
	}

	public void setFlightDistance(Integer flightDistance) {
		this.flightDistance = flightDistance;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getLocator() {
		return locator;
	}

	public void setLocator(String locator) {
		this.locator = locator;
	}

	public String getAircraftId() {
		return aircraftId;
	}

	public void setAircraftId(String aircraftId) {
		this.aircraftId = aircraftId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

//	public List<FlightDeparture> getFlightDepartures() {
//		return flightDepartures;
//	}
//
//	public void setFlightDepartures(List<FlightDeparture> flightDepartures) {
//		this.flightDepartures = flightDepartures;
//	}
//
//	public void addFlightDeparture(FlightDeparture departure) {
//		departure.setFlightRoute(this);
//		this.flightDepartures.add(departure);
//	}

//	public List<FareSchedule> getFareSchedules() {
//		return fareSchedules;
//	}
//
//	public void setFareSchedules(List<FareSchedule> fareSchedules) {
//		this.fareSchedules = fareSchedules;
//	}
	
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Boolean getConnecting() {
		return connecting;
	}

	public void setConnecting(Boolean connecting) {
		this.connecting = connecting;
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
				+ ((aircraftId == null) ? 0 : aircraftId.hashCode());
		result = prime * result
				+ ((airlineId == null) ? 0 : airlineId.hashCode());
		result = prime * result
				+ ((auditDateTime == null) ? 0 : auditDateTime.hashCode());
		result = prime * result
				+ ((auditUserId == null) ? 0 : auditUserId.hashCode());
		result = prime * result
				+ ((availableDays == null) ? 0 : availableDays.hashCode());
		result = prime * result
				+ ((comments == null) ? 0 : comments.hashCode());
		result = prime * result
				+ ((connecting == null) ? 0 : connecting.hashCode());
		result = prime * result
				+ ((destAirportId == null) ? 0 : destAirportId.hashCode());
		result = prime * result
				+ ((flightCategory == null) ? 0 : flightCategory.hashCode());
		result = prime * result
				+ ((flightDistance == null) ? 0 : flightDistance.hashCode());
		result = prime * result
				+ ((flightNumber == null) ? 0 : flightNumber.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((locator == null) ? 0 : locator.hashCode());
		result = prime * result + ((meal == null) ? 0 : meal.hashCode());
		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
		result = prime * result
				+ ((numberOfStops == null) ? 0 : numberOfStops.hashCode());
		result = prime * result
				+ ((originAirportId == null) ? 0 : originAirportId.hashCode());
		result = prime * result + ((system == null) ? 0 : system.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof FlightRoute))
			return false;
		FlightRoute other = (FlightRoute) obj;
		if (aircraftId == null) {
			if (other.aircraftId != null)
				return false;
		} else if (!aircraftId.equals(other.aircraftId))
			return false;
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
		if (availableDays == null) {
			if (other.availableDays != null)
				return false;
		} else if (!availableDays.equals(other.availableDays))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (connecting == null) {
			if (other.connecting != null)
				return false;
		} else if (!connecting.equals(other.connecting))
			return false;
		if (destAirportId == null) {
			if (other.destAirportId != null)
				return false;
		} else if (!destAirportId.equals(other.destAirportId))
			return false;
		if (flightCategory == null) {
			if (other.flightCategory != null)
				return false;
		} else if (!flightCategory.equals(other.flightCategory))
			return false;
		if (flightDistance == null) {
			if (other.flightDistance != null)
				return false;
		} else if (!flightDistance.equals(other.flightDistance))
			return false;
		if (flightNumber == null) {
			if (other.flightNumber != null)
				return false;
		} else if (!flightNumber.equals(other.flightNumber))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (locator == null) {
			if (other.locator != null)
				return false;
		} else if (!locator.equals(other.locator))
			return false;
		if (meal == null) {
			if (other.meal != null)
				return false;
		} else if (!meal.equals(other.meal))
			return false;
		if (movie == null) {
			if (other.movie != null)
				return false;
		} else if (!movie.equals(other.movie))
			return false;
		if (numberOfStops == null) {
			if (other.numberOfStops != null)
				return false;
		} else if (!numberOfStops.equals(other.numberOfStops))
			return false;
		if (originAirportId == null) {
			if (other.originAirportId != null)
				return false;
		} else if (!originAirportId.equals(other.originAirportId))
			return false;
		if (system == null) {
			if (other.system != null)
				return false;
		} else if (!system.equals(other.system))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
	
//	public FlightRoute clone(Audit audit) {
//		FlightRoute clone = new FlightRoute();
//
//		clone.setAirlineId(airlineId);
//		clone.setFlightNumber(flightNumber);
//		clone.setOriginAirportId(originAirportId);
//		clone.setDestAirportId(destAirportId);
//		clone.setConnecting(connecting);
//		
//		clone.setComments(comments);
//		clone.setVersion(0);
//		clone.setAudit(audit);
//
//		return clone;
//	}
}
