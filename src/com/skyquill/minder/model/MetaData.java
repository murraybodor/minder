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
public class MetaData extends ModelBase implements Serializable
{
	private static final long serialVersionUID = 4014636966326023978L;
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String id;
	@Persistent
	private String metaKey;
	@Persistent
	private String strValue;
	@Persistent
	private Integer numValue;
	@Persistent
	private Date dateValue;
	@Persistent
	private Boolean booleanValue;
	@Persistent
	private byte[] blobValue;
	@Persistent
	private String metaDescription;
	@Persistent
	private String metaSuppInfo;
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

	public String getMetaKey() {
		return metaKey;
	}

	public void setMetaKey(String metaKey) {
		this.metaKey = metaKey;
	}

	public String getStrValue() {
		return strValue;
	}

	public void setStrValue(String strValue) {
		this.strValue = strValue;
	}

	public Integer getNumValue() {
		return numValue;
	}

	public void setNumValue(Integer numValue) {
		this.numValue = numValue;
	}

	public Date getDateValue() {
		return dateValue;
	}

	public void setDateValue(Date dateValue) {
		this.dateValue = dateValue;
	}

	public Boolean getBooleanValue() {
		return booleanValue;
	}

	public void setBooleanValue(Boolean booleanValue) {
		this.booleanValue = booleanValue;
	}

	public byte[] getBlobValue() {
		return blobValue;
	}

	public void setBlobValue(byte[] blobValue) {
		this.blobValue = blobValue;
	}

	public String getMetaDescription() {
		return metaDescription;
	}

	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}

	public String getMetaSuppInfo() {
		return metaSuppInfo;
	}

	public void setMetaSuppInfo(String metaSuppInfo) {
		this.metaSuppInfo = metaSuppInfo;
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

	public boolean equals(Object other) {
        if (this == other) return true;
        if ( !(other instanceof MetaData) ) return false;

        final MetaData setting = (MetaData) other;

        if ( !setting.getMetaKey().equals( getMetaKey() ) ) return false;
        if ( !setting.getStrValue().equals( getStrValue() ) ) return false;
        if ( !setting.getNumValue().equals( getNumValue() ) ) return false;
        if ( !setting.getDateValue().equals( getDateValue() ) ) return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = getMetaKey()==null?24:getMetaKey().hashCode();
//        result = 29 * result + (getStringValue()==null?29:getStringValue().hashCode());
//        result = 29 * result + (getNumericValue()==null?29:getNumericValue().hashCode());
//        result = 29 * result + (getDateValue()==null?29:getDateValue().hashCode());
        return result;
    }


}
