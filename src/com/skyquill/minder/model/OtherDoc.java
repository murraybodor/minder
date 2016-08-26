//package com.skyquill.minder.model;
//
//import java.io.Serializable;
//import java.util.*;
//
//import javax.persistence.*;
//
//
///**
// * Represents Other Travel Documentation
// * 
// * @author mbodor
// */
//@Entity
//@Table(name="OTHERTRAVELDOCS")
//public class OtherDoc extends ModelBase implements Serializable  {
//
//	private static final long serialVersionUID = 7526472295622774147L;
//	private Long id;
//	private Traveller traveller;
//	private Country country;
//	private Long countryId;
//	private String docType;
//	private String docId;
//	private Date expiryDate;
//	private Boolean remindOnExpiry;
//	private Date lastReminderDate;
//	private String comments;
//	private Audit audit;
//	private Integer version;
//
//	private boolean isNew = false;
//	private boolean isDeleted = false;
//	
//	@Id @GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(name="ID", insertable=false, updatable=false)
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	@OneToOne
//    @JoinColumn(name="COUNTRY_ID", insertable=false, updatable=false)
//	public Country getCountry() {
//		return country;
//	}
//
//	public void setCountry(Country country) {
//		this.country = country;
//	}
//
//    @Column(name="COUNTRY_ID")
//	public Long getCountryId() {
//		return countryId;
//	}
//
//	public void setCountryId(Long countryId) {
//		this.countryId = countryId;
//	}
//
//    @Column(name="DOC_TYPE", length=80)
//	public String getDocType() {
//		return docType;
//	}
//
//	public void setDocType(String docType) {
//		this.docType = docType;
//	}
//
//    @Column(name="DOC_ID", length=80)
//	public String getDocId() {
//		return docId;
//	}
//
//	public void setDocId(String docId) {
//		this.docId = docId;
//	}
//	
//    @Column(name="EXPIRY_DATE")
//	public Date getExpiryDate() {
//		return expiryDate;
//	}
//
//	public void setExpiryDate(Date expiryDate) {
//		this.expiryDate = expiryDate;
//	}
//
//    @Column(name="REMIND_ON_EXPIRY")
//	public Boolean isRemindOnExpiry() {
//		return remindOnExpiry;
//	}
//
//	public void setRemindOnExpiry(Boolean remindOnExpiry) {
//		this.remindOnExpiry = remindOnExpiry;
//	}
//
//    @Column(name="LAST_REMINDER_DATE")
//	public Date getLastReminderDate() {
//		return lastReminderDate;
//	}
//
//	public void setLastReminderDate(Date lastReminderDate) {
//		this.lastReminderDate = lastReminderDate;
//	}
//
//    @Column(name="COMMENTS", length=400)
//	public String getComments() {
//		return comments;
//	}
//
//	public void setComments(String comments) {
//		this.comments = comments;
//	}
//
//	public Audit getAudit() {
//		return audit;
//	}
//
//	public void setAudit(Audit audit) {
//		this.audit = audit;
//	}
//
//    @ManyToOne()
//    @JoinColumn(name="TRAVELLER_ID")
//	public Traveller getTraveller() {
//		return traveller;
//	}
//
//	public void setTraveller(Traveller traveller) {
//		this.traveller = traveller;
//	}
//
//	@Transient
//	public boolean isNew() {
//		return isNew;
//	}
//
//	public void setNew(boolean isNew) {
//		this.isNew = isNew;
//	}
//
//	@Transient
//	public boolean isDeleted() {
//		return isDeleted;
//	}
//
//	public void setDeleted(boolean isDeleted) {
//		this.isDeleted = isDeleted;
//	}
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
//}
