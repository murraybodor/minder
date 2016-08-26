package com.skyquill.minder.model.auth;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.skyquill.minder.model.ModelBase;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Tenant extends ModelBase implements Serializable  {

	private static final long serialVersionUID = 7526472295622776147L;

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String id;
	@Persistent
	private String tenantName;
	@Persistent
	private String context;
	@Persistent
	private String logoFileName;
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

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getLogoFileName() {
		return logoFileName;
	}

	public void setLogoFileName(String logoFileName) {
		this.logoFileName = logoFileName;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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
        if ( !(other instanceof Tenant) ) return false;
//        final Tenant tenant = (Tenant) other;
//        if ( !user.getLastName().equals( getLastName() ) ) return false;
        return true;
    }

    public int hashCode() {
        int result = 0;
//        result = (getLastName()!=null?getLastName().hashCode():66);
//        result = 29 * result + (getFirstName()!=null?getFirstName().hashCode():88);
//        result = 29 * result + (getBirthDate()!=null?getBirthDate().hashCode():22);
//        result = 29 * result + (getBirthCountry()!=null?getBirthCountry().hashCode():44);
        return result;
    }
}
