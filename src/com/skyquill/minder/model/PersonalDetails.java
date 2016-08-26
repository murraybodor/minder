//package com.skyquill.minder.model;
//
//import java.io.Serializable;
//import java.util.*;
//
//import javax.persistence.*;
//
//
///**
// * Represents personal details
// * 
// * @author mjb
// */
//@Entity
//@Table(name="PERSONALDETAILS")
//public class PersonalDetails extends ModelBase implements Serializable  {
//
//	private static final long serialVersionUID = 7526472295622776147L;
//	private Long id;
//	private Traveller traveller;
//	private Long travellerId;
//	private String firstName;
//	private String lastName;
//	private Date birthDate;
//	private String birthPlace;
//	private Country birthCountry;
//	private String email;
//	private String homePhone;
//	private String cellPhone;
//	private Boolean employee;
//	private String comments;
//	private Date auditDateTime;
//	private String auditUserId;
//	private Integer version;
//	private boolean dirty;
//	
//
//	@Id 
//	@GeneratedValue(strategy = GenerationType.AUTO, generator = "PERSONALDETAILS_SEQ")  
//	@SequenceGenerator(name = "PERSONALDETAILS_SEQ", sequenceName = "PERSONALDETAILS_SEQ")  
//	@Column(name="ID", insertable=false, updatable=false)
//	public Long getId() {
//		return id;
//	}
//    
//    public void setId(Long id) {
//    	this.id = id;
//    }
//
//	@OneToOne()
//    @JoinColumn(name="TRAVELLER_ID", insertable=false, updatable=false)
//    public Traveller getTraveller() {
//		return traveller;
//	}
//
//	public void setTraveller(Traveller traveller) {
//		this.traveller = traveller;
//	}
//
//    @Column(name="TRAVELLER_ID")
//	public Long getTravellerId() {
//		return travellerId;
//	}
//
//	public void setTravellerId(Long travellerId) {
//		this.travellerId = travellerId;
//	}
//
//	@Column(name="FIRST_NAME", length=40)
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	@Column(name="LAST_NAME", length=40)
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	@Column(name="EMAIL", length=40)
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	@Column(name="HOME_PHONE", length=20)
//	public String getHomePhone() {
//		return homePhone;
//	}
//
//	public void setHomePhone(String homePhone) {
//		this.homePhone = homePhone;
//	}
//
//	@Column(name="CELL_PHONE", length=20)
//	public String getCellPhone() {
//		return cellPhone;
//	}
//
//	public void setCellPhone(String cellPhone) {
//		this.cellPhone = cellPhone;
//	}
//	
//	@Column(name="BIRTH_DATE")
//	public Date getBirthDate() {
//		return birthDate;
//	}
//
//	public void setBirthDate(Date birthDate) {
//		this.birthDate = birthDate;
//	}
//
//	@Column(name="BIRTH_PLACE", length=80)
//	public String getBirthPlace() {
//		return birthPlace;
//	}
//
//	public void setBirthPlace(String birthPlace) {
//		this.birthPlace = birthPlace;
//	}	
//	
//	@OneToOne
//    @JoinColumn(name="BIRTH_COUNTRY_ID")
//	public Country getBirthCountry() {
//		return birthCountry;
//	}
//
//	public void setBirthCountry(Country birthCountry) {
//		this.birthCountry = birthCountry;
//	}
//
//    @Column(name="EMPLOYEE")
//	public Boolean isEmployee() {
//		return employee;
//	}
//
//	public void setEmployee(Boolean employee) {
//		this.employee = employee;
//	}
//
//	@Transient
//	public Boolean getEmployee() {
//		return employee;
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
//	@Column(name="AUDIT_DATETIME")
//	public Date getAuditDateTime() {return auditDateTime;}
//	public void setAuditDateTime(Date auditDateTime) {this.auditDateTime = auditDateTime;}
//	@Column(name="AUDIT_USERID", length=20)
//	public String getAuditUserId() {return auditUserId;}
//	public void setAuditUserId(String auditUserId) {this.auditUserId = auditUserId;}
//
//	public boolean equals(Object other) {
//        if (this == other) return true;
//        if ( !(other instanceof PersonalDetails) ) return false;
//
//        final PersonalDetails person = (PersonalDetails) other;
//
//        if ( !person.getLastName().equals( getLastName() ) ) return false;
//        if ( !person.getFirstName().equals( getFirstName() ) ) return false;
//        if ( !person.getBirthDate().equals( getBirthDate() ) ) return false;
//        if ( !person.getBirthCountry().equals( getBirthCountry() ) ) return false;
//
//        return true;
//    }
//
//    public int hashCode() {
//        int result;
//        result = (getLastName()!=null?getLastName().hashCode():66);
//        result = 29 * result + (getFirstName()!=null?getFirstName().hashCode():88);
//        result = 29 * result + (getBirthDate()!=null?getBirthDate().hashCode():22);
//        result = 29 * result + (getBirthCountry()!=null?getBirthCountry().hashCode():44);
//        return result;
//    }
//
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
//	@Transient
//	public boolean isDirty() {
//		return dirty;
//	}
//
//	public void setDirty(boolean dirty) {
//		this.dirty = dirty;
//	}
//	
//}
