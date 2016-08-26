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
public class Hotel extends ModelBase implements Serializable  {

	private static final long serialVersionUID = 2271651692698745555L;
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String id;
	@Persistent
	private String hotelChainId;
	@Persistent
	private String name;
	@Persistent
	private String location;
	@Persistent
	private String address;
	@Persistent
	private String address2;
	@Persistent
	private String address3;
	@Persistent
	private String address4;
	@Persistent
	private String cityId;
	@Persistent
	private String phone;
	@Persistent
	private String fax;
	@Persistent
	private String photoFileName;
	@Persistent
	private String url;
	@Persistent
	private String closestAirportId;
	@Persistent
	private Boolean active;
	@Persistent
	private Integer preferredOrder;
	@Persistent
	private String comments;
	@Persistent
	private Float latitude;
	@Persistent
	private Float longitude;
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
	public String getHotelChainId() {
		return hotelChainId;
	}
	public void setHotelChainId(String hotelChainId) {
		this.hotelChainId = hotelChainId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	public String getAddress4() {
		return address4;
	}
	public void setAddress4(String address4) {
		this.address4 = address4;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getPhotoFileName() {
		return photoFileName;
	}
	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getClosestAirportId() {
		return closestAirportId;
	}
	public void setClosestAirport(String closestAirportId) {
		this.closestAirportId = closestAirportId;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Integer getPreferredOrder() {
		return preferredOrder;
	}
	public void setPreferredOrder(Integer preferredOrder) {
		this.preferredOrder = preferredOrder;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Float getLatitude() {
		return latitude;
	}
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	public Float getLongitude() {
		return longitude;
	}
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
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
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((address2 == null) ? 0 : address2.hashCode());
		result = prime * result
				+ ((address3 == null) ? 0 : address3.hashCode());
		result = prime * result
				+ ((address4 == null) ? 0 : address4.hashCode());
		result = prime * result
				+ ((auditDateTime == null) ? 0 : auditDateTime.hashCode());
		result = prime * result
				+ ((auditUserId == null) ? 0 : auditUserId.hashCode());
		result = prime * result + ((cityId == null) ? 0 : cityId.hashCode());
		result = prime
				* result
				+ ((closestAirportId == null) ? 0 : closestAirportId.hashCode());
		result = prime * result
				+ ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((fax == null) ? 0 : fax.hashCode());
		result = prime * result
				+ ((hotelChainId == null) ? 0 : hotelChainId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result
				+ ((longitude == null) ? 0 : longitude.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result
				+ ((photoFileName == null) ? 0 : photoFileName.hashCode());
		result = prime * result
				+ ((preferredOrder == null) ? 0 : preferredOrder.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Hotel))
			return false;
		Hotel other = (Hotel) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (address2 == null) {
			if (other.address2 != null)
				return false;
		} else if (!address2.equals(other.address2))
			return false;
		if (address3 == null) {
			if (other.address3 != null)
				return false;
		} else if (!address3.equals(other.address3))
			return false;
		if (address4 == null) {
			if (other.address4 != null)
				return false;
		} else if (!address4.equals(other.address4))
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
		if (closestAirportId == null) {
			if (other.closestAirportId != null)
				return false;
		} else if (!closestAirportId.equals(other.closestAirportId))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (fax == null) {
			if (other.fax != null)
				return false;
		} else if (!fax.equals(other.fax))
			return false;
		if (hotelChainId == null) {
			if (other.hotelChainId != null)
				return false;
		} else if (!hotelChainId.equals(other.hotelChainId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!latitude.equals(other.latitude))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!longitude.equals(other.longitude))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (photoFileName == null) {
			if (other.photoFileName != null)
				return false;
		} else if (!photoFileName.equals(other.photoFileName))
			return false;
		if (preferredOrder == null) {
			if (other.preferredOrder != null)
				return false;
		} else if (!preferredOrder.equals(other.preferredOrder))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
		
}
