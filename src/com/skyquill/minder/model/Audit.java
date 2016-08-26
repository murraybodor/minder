//package com.skyquill.minder.model;
//
//import java.io.Serializable;
//import java.util.*;
//
//import javax.persistence.*;
//
///**
// * Represents audit information
// * 
// * @author mjb
// */
//@Embeddable
//public class Audit implements Serializable {
//	
//	private static final long serialVersionUID = 7526472295622776147L;
//	private Date auditDateTime;
//	private String auditUserId;
//
//	public Audit() {
//	}
//	
//	public Audit(String userId, Date aDate) {
//		this.auditUserId = userId;
//		this.auditDateTime = aDate;
//	}
//	public Audit(String userId) {
//		this(userId, new Date());
//	}
//	
//	@Column(name="AUDIT_DATETIME")
//	public Date getAuditDateTime() {return auditDateTime;}
//	public void setAuditDateTime(Date auditDateTime) {this.auditDateTime = auditDateTime;}
//	@Column(name="AUDIT_USERID", length=20)
//	public String getAuditUserId() {return auditUserId;}
//	public void setAuditUserId(String auditUserId) {this.auditUserId = auditUserId;}
//	
//}
