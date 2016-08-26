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
public class SecurityProfile extends ModelBase implements Serializable  {

	private static final long serialVersionUID = -122360701226808043L;
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String id;
	@Persistent
	private String travellerId;
	@Persistent
	private String homeAddress;
	@Persistent
	private String emergContact1Name;
	@Persistent
	private String emergContact1Rship;
	@Persistent
	private String emergContact1DayPhone;
	@Persistent
	private String emergContact1EvePhone;
	@Persistent
	private String emergContact1CellPhone;
	@Persistent
	private String emergContact1LocAlt;
	@Persistent
	private String emergContact2Name;
	@Persistent
	private String emergContact2Rship;
	@Persistent
	private String emergContact2DayPhone;
	@Persistent
	private String emergContact2EvePhone;
	@Persistent
	private String emergContact2CellPhone;
	@Persistent
	private String emergContact2LocAlt;
	@Persistent
	private String doctorName;
	@Persistent
	private String doctorAddress;
	@Persistent
	private String doctorPhone;
	@Persistent
	private String bloodType;
	@Persistent
	private String pharmName;
	@Persistent
	private String pharmAddress;
	@Persistent
	private String pharmPhone;
	@Persistent
	private String vitalPrescrip;
	@Persistent
	private String allergies;
	@Persistent
	private String optoName;
	@Persistent
	private String optoAddress;
	@Persistent
	private String optoPhone;
	@Persistent
	private String prescripLe;
	@Persistent
	private String prescripRe;
	@Persistent
	private Boolean glasses = false;
	@Persistent
	private Boolean contacts = false;
	@Persistent
	private String contactSolution;
	@Persistent
	private String visionConditions;
	@Persistent
	private String dentName;
	@Persistent
	private String dentAddress;
	@Persistent
	private String dentPhone;
	@Persistent
	private String dentConditions;
	@Persistent
	private String physDescription;
	@Persistent
	private String likes;
	@Persistent
	private String dislikes;
	@Persistent
	private String activityParticipates;
	@Persistent
	private String activityDislikes;
	@Persistent
	private String codePhrase;
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
	public String getTravellerId() {
		return travellerId;
	}
	public void setTravellerId(String travellerId) {
		this.travellerId = travellerId;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getEmergContact1Name() {
		return emergContact1Name;
	}
	public void setEmergContact1Name(String emergContact1Name) {
		this.emergContact1Name = emergContact1Name;
	}
	public String getEmergContact1Rship() {
		return emergContact1Rship;
	}
	public void setEmergContact1Rship(String emergContact1Rship) {
		this.emergContact1Rship = emergContact1Rship;
	}
	public String getEmergContact1DayPhone() {
		return emergContact1DayPhone;
	}
	public void setEmergContact1DayPhone(String emergContact1DayPhone) {
		this.emergContact1DayPhone = emergContact1DayPhone;
	}
	public String getEmergContact1EvePhone() {
		return emergContact1EvePhone;
	}
	public void setEmergContact1EvePhone(String emergContact1EvePhone) {
		this.emergContact1EvePhone = emergContact1EvePhone;
	}
	public String getEmergContact1CellPhone() {
		return emergContact1CellPhone;
	}
	public void setEmergContact1CellPhone(String emergContact1CellPhone) {
		this.emergContact1CellPhone = emergContact1CellPhone;
	}
	public String getEmergContact1LocAlt() {
		return emergContact1LocAlt;
	}
	public void setEmergContact1LocAlt(String emergContact1LocAlt) {
		this.emergContact1LocAlt = emergContact1LocAlt;
	}
	public String getEmergContact2Name() {
		return emergContact2Name;
	}
	public void setEmergContact2Name(String emergContact2Name) {
		this.emergContact2Name = emergContact2Name;
	}
	public String getEmergContact2Rship() {
		return emergContact2Rship;
	}
	public void setEmergContact2Rship(String emergContact2Rship) {
		this.emergContact2Rship = emergContact2Rship;
	}
	public String getEmergContact2DayPhone() {
		return emergContact2DayPhone;
	}
	public void setEmergContact2DayPhone(String emergContact2DayPhone) {
		this.emergContact2DayPhone = emergContact2DayPhone;
	}
	public String getEmergContact2EvePhone() {
		return emergContact2EvePhone;
	}
	public void setEmergContact2EvePhone(String emergContact2EvePhone) {
		this.emergContact2EvePhone = emergContact2EvePhone;
	}
	public String getEmergContact2CellPhone() {
		return emergContact2CellPhone;
	}
	public void setEmergContact2CellPhone(String emergContact2CellPhone) {
		this.emergContact2CellPhone = emergContact2CellPhone;
	}
	public String getEmergContact2LocAlt() {
		return emergContact2LocAlt;
	}
	public void setEmergContact2LocAlt(String emergContact2LocAlt) {
		this.emergContact2LocAlt = emergContact2LocAlt;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorAddress() {
		return doctorAddress;
	}
	public void setDoctorAddress(String doctorAddress) {
		this.doctorAddress = doctorAddress;
	}
	public String getDoctorPhone() {
		return doctorPhone;
	}
	public void setDoctorPhone(String doctorPhone) {
		this.doctorPhone = doctorPhone;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public String getPharmName() {
		return pharmName;
	}
	public void setPharmName(String pharmName) {
		this.pharmName = pharmName;
	}
	public String getPharmAddress() {
		return pharmAddress;
	}
	public void setPharmAddress(String pharmAddress) {
		this.pharmAddress = pharmAddress;
	}
	public String getPharmPhone() {
		return pharmPhone;
	}
	public void setPharmPhone(String pharmPhone) {
		this.pharmPhone = pharmPhone;
	}
	public String getVitalPrescrip() {
		return vitalPrescrip;
	}
	public void setVitalPrescrip(String vitalPrescrip) {
		this.vitalPrescrip = vitalPrescrip;
	}
	public String getAllergies() {
		return allergies;
	}
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}
	public String getOptoName() {
		return optoName;
	}
	public void setOptoName(String optoName) {
		this.optoName = optoName;
	}
	public String getOptoAddress() {
		return optoAddress;
	}
	public void setOptoAddress(String optoAddress) {
		this.optoAddress = optoAddress;
	}
	public String getOptoPhone() {
		return optoPhone;
	}
	public void setOptoPhone(String optoPhone) {
		this.optoPhone = optoPhone;
	}
	public String getPrescripLe() {
		return prescripLe;
	}
	public void setPrescripLe(String prescripLe) {
		this.prescripLe = prescripLe;
	}
	public String getPrescripRe() {
		return prescripRe;
	}
	public void setPrescripRe(String prescripRe) {
		this.prescripRe = prescripRe;
	}
	public Boolean getGlasses() {
		return glasses;
	}
	public void setGlasses(Boolean glasses) {
		this.glasses = glasses;
	}
	public Boolean getContacts() {
		return contacts;
	}
	public void setContacts(Boolean contacts) {
		this.contacts = contacts;
	}
	public String getContactSolution() {
		return contactSolution;
	}
	public void setContactSolution(String contactSolution) {
		this.contactSolution = contactSolution;
	}
	public String getVisionConditions() {
		return visionConditions;
	}
	public void setVisionConditions(String visionConditions) {
		this.visionConditions = visionConditions;
	}
	public String getDentName() {
		return dentName;
	}
	public void setDentName(String dentName) {
		this.dentName = dentName;
	}
	public String getDentAddress() {
		return dentAddress;
	}
	public void setDentAddress(String dentAddress) {
		this.dentAddress = dentAddress;
	}
	public String getDentPhone() {
		return dentPhone;
	}
	public void setDentPhone(String dentPhone) {
		this.dentPhone = dentPhone;
	}
	public String getDentConditions() {
		return dentConditions;
	}
	public void setDentConditions(String dentConditions) {
		this.dentConditions = dentConditions;
	}
	public String getPhysDescription() {
		return physDescription;
	}
	public void setPhysDescription(String physDescription) {
		this.physDescription = physDescription;
	}
	public String getLikes() {
		return likes;
	}
	public void setLikes(String likes) {
		this.likes = likes;
	}
	public String getDislikes() {
		return dislikes;
	}
	public void setDislikes(String dislikes) {
		this.dislikes = dislikes;
	}
	public String getActivityParticipates() {
		return activityParticipates;
	}
	public void setActivityParticipates(String activityParticipates) {
		this.activityParticipates = activityParticipates;
	}
	public String getActivityDislikes() {
		return activityDislikes;
	}
	public void setActivityDislikes(String activityDislikes) {
		this.activityDislikes = activityDislikes;
	}
	public String getCodePhrase() {
		return codePhrase;
	}
	public void setCodePhrase(String codePhrase) {
		this.codePhrase = codePhrase;
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
		result = prime
				* result
				+ ((activityDislikes == null) ? 0 : activityDislikes.hashCode());
		result = prime
				* result
				+ ((activityParticipates == null) ? 0 : activityParticipates
						.hashCode());
		result = prime * result
				+ ((allergies == null) ? 0 : allergies.hashCode());
		result = prime * result
				+ ((auditDateTime == null) ? 0 : auditDateTime.hashCode());
		result = prime * result
				+ ((auditUserId == null) ? 0 : auditUserId.hashCode());
		result = prime * result
				+ ((bloodType == null) ? 0 : bloodType.hashCode());
		result = prime * result
				+ ((codePhrase == null) ? 0 : codePhrase.hashCode());
		result = prime * result
				+ ((contactSolution == null) ? 0 : contactSolution.hashCode());
		result = prime * result
				+ ((contacts == null) ? 0 : contacts.hashCode());
		result = prime * result
				+ ((dentAddress == null) ? 0 : dentAddress.hashCode());
		result = prime * result
				+ ((dentConditions == null) ? 0 : dentConditions.hashCode());
		result = prime * result
				+ ((dentName == null) ? 0 : dentName.hashCode());
		result = prime * result
				+ ((dentPhone == null) ? 0 : dentPhone.hashCode());
		result = prime * result
				+ ((dislikes == null) ? 0 : dislikes.hashCode());
		result = prime * result
				+ ((doctorAddress == null) ? 0 : doctorAddress.hashCode());
		result = prime * result
				+ ((doctorName == null) ? 0 : doctorName.hashCode());
		result = prime * result
				+ ((doctorPhone == null) ? 0 : doctorPhone.hashCode());
		result = prime
				* result
				+ ((emergContact1CellPhone == null) ? 0
						: emergContact1CellPhone.hashCode());
		result = prime
				* result
				+ ((emergContact1DayPhone == null) ? 0 : emergContact1DayPhone
						.hashCode());
		result = prime
				* result
				+ ((emergContact1EvePhone == null) ? 0 : emergContact1EvePhone
						.hashCode());
		result = prime
				* result
				+ ((emergContact1LocAlt == null) ? 0 : emergContact1LocAlt
						.hashCode());
		result = prime
				* result
				+ ((emergContact1Name == null) ? 0 : emergContact1Name
						.hashCode());
		result = prime
				* result
				+ ((emergContact1Rship == null) ? 0 : emergContact1Rship
						.hashCode());
		result = prime
				* result
				+ ((emergContact2CellPhone == null) ? 0
						: emergContact2CellPhone.hashCode());
		result = prime
				* result
				+ ((emergContact2DayPhone == null) ? 0 : emergContact2DayPhone
						.hashCode());
		result = prime
				* result
				+ ((emergContact2EvePhone == null) ? 0 : emergContact2EvePhone
						.hashCode());
		result = prime
				* result
				+ ((emergContact2LocAlt == null) ? 0 : emergContact2LocAlt
						.hashCode());
		result = prime
				* result
				+ ((emergContact2Name == null) ? 0 : emergContact2Name
						.hashCode());
		result = prime
				* result
				+ ((emergContact2Rship == null) ? 0 : emergContact2Rship
						.hashCode());
		result = prime * result + ((glasses == null) ? 0 : glasses.hashCode());
		result = prime * result
				+ ((homeAddress == null) ? 0 : homeAddress.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((likes == null) ? 0 : likes.hashCode());
		result = prime * result
				+ ((optoAddress == null) ? 0 : optoAddress.hashCode());
		result = prime * result
				+ ((optoName == null) ? 0 : optoName.hashCode());
		result = prime * result
				+ ((optoPhone == null) ? 0 : optoPhone.hashCode());
		result = prime * result
				+ ((pharmAddress == null) ? 0 : pharmAddress.hashCode());
		result = prime * result
				+ ((pharmName == null) ? 0 : pharmName.hashCode());
		result = prime * result
				+ ((pharmPhone == null) ? 0 : pharmPhone.hashCode());
		result = prime * result
				+ ((physDescription == null) ? 0 : physDescription.hashCode());
		result = prime * result
				+ ((prescripLe == null) ? 0 : prescripLe.hashCode());
		result = prime * result
				+ ((prescripRe == null) ? 0 : prescripRe.hashCode());
		result = prime * result
				+ ((travellerId == null) ? 0 : travellerId.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		result = prime
				* result
				+ ((visionConditions == null) ? 0 : visionConditions.hashCode());
		result = prime * result
				+ ((vitalPrescrip == null) ? 0 : vitalPrescrip.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof SecurityProfile))
			return false;
		SecurityProfile other = (SecurityProfile) obj;
		if (activityDislikes == null) {
			if (other.activityDislikes != null)
				return false;
		} else if (!activityDislikes.equals(other.activityDislikes))
			return false;
		if (activityParticipates == null) {
			if (other.activityParticipates != null)
				return false;
		} else if (!activityParticipates.equals(other.activityParticipates))
			return false;
		if (allergies == null) {
			if (other.allergies != null)
				return false;
		} else if (!allergies.equals(other.allergies))
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
		if (bloodType == null) {
			if (other.bloodType != null)
				return false;
		} else if (!bloodType.equals(other.bloodType))
			return false;
		if (codePhrase == null) {
			if (other.codePhrase != null)
				return false;
		} else if (!codePhrase.equals(other.codePhrase))
			return false;
		if (contactSolution == null) {
			if (other.contactSolution != null)
				return false;
		} else if (!contactSolution.equals(other.contactSolution))
			return false;
		if (contacts == null) {
			if (other.contacts != null)
				return false;
		} else if (!contacts.equals(other.contacts))
			return false;
		if (dentAddress == null) {
			if (other.dentAddress != null)
				return false;
		} else if (!dentAddress.equals(other.dentAddress))
			return false;
		if (dentConditions == null) {
			if (other.dentConditions != null)
				return false;
		} else if (!dentConditions.equals(other.dentConditions))
			return false;
		if (dentName == null) {
			if (other.dentName != null)
				return false;
		} else if (!dentName.equals(other.dentName))
			return false;
		if (dentPhone == null) {
			if (other.dentPhone != null)
				return false;
		} else if (!dentPhone.equals(other.dentPhone))
			return false;
		if (dislikes == null) {
			if (other.dislikes != null)
				return false;
		} else if (!dislikes.equals(other.dislikes))
			return false;
		if (doctorAddress == null) {
			if (other.doctorAddress != null)
				return false;
		} else if (!doctorAddress.equals(other.doctorAddress))
			return false;
		if (doctorName == null) {
			if (other.doctorName != null)
				return false;
		} else if (!doctorName.equals(other.doctorName))
			return false;
		if (doctorPhone == null) {
			if (other.doctorPhone != null)
				return false;
		} else if (!doctorPhone.equals(other.doctorPhone))
			return false;
		if (emergContact1CellPhone == null) {
			if (other.emergContact1CellPhone != null)
				return false;
		} else if (!emergContact1CellPhone.equals(other.emergContact1CellPhone))
			return false;
		if (emergContact1DayPhone == null) {
			if (other.emergContact1DayPhone != null)
				return false;
		} else if (!emergContact1DayPhone.equals(other.emergContact1DayPhone))
			return false;
		if (emergContact1EvePhone == null) {
			if (other.emergContact1EvePhone != null)
				return false;
		} else if (!emergContact1EvePhone.equals(other.emergContact1EvePhone))
			return false;
		if (emergContact1LocAlt == null) {
			if (other.emergContact1LocAlt != null)
				return false;
		} else if (!emergContact1LocAlt.equals(other.emergContact1LocAlt))
			return false;
		if (emergContact1Name == null) {
			if (other.emergContact1Name != null)
				return false;
		} else if (!emergContact1Name.equals(other.emergContact1Name))
			return false;
		if (emergContact1Rship == null) {
			if (other.emergContact1Rship != null)
				return false;
		} else if (!emergContact1Rship.equals(other.emergContact1Rship))
			return false;
		if (emergContact2CellPhone == null) {
			if (other.emergContact2CellPhone != null)
				return false;
		} else if (!emergContact2CellPhone.equals(other.emergContact2CellPhone))
			return false;
		if (emergContact2DayPhone == null) {
			if (other.emergContact2DayPhone != null)
				return false;
		} else if (!emergContact2DayPhone.equals(other.emergContact2DayPhone))
			return false;
		if (emergContact2EvePhone == null) {
			if (other.emergContact2EvePhone != null)
				return false;
		} else if (!emergContact2EvePhone.equals(other.emergContact2EvePhone))
			return false;
		if (emergContact2LocAlt == null) {
			if (other.emergContact2LocAlt != null)
				return false;
		} else if (!emergContact2LocAlt.equals(other.emergContact2LocAlt))
			return false;
		if (emergContact2Name == null) {
			if (other.emergContact2Name != null)
				return false;
		} else if (!emergContact2Name.equals(other.emergContact2Name))
			return false;
		if (emergContact2Rship == null) {
			if (other.emergContact2Rship != null)
				return false;
		} else if (!emergContact2Rship.equals(other.emergContact2Rship))
			return false;
		if (glasses == null) {
			if (other.glasses != null)
				return false;
		} else if (!glasses.equals(other.glasses))
			return false;
		if (homeAddress == null) {
			if (other.homeAddress != null)
				return false;
		} else if (!homeAddress.equals(other.homeAddress))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (likes == null) {
			if (other.likes != null)
				return false;
		} else if (!likes.equals(other.likes))
			return false;
		if (optoAddress == null) {
			if (other.optoAddress != null)
				return false;
		} else if (!optoAddress.equals(other.optoAddress))
			return false;
		if (optoName == null) {
			if (other.optoName != null)
				return false;
		} else if (!optoName.equals(other.optoName))
			return false;
		if (optoPhone == null) {
			if (other.optoPhone != null)
				return false;
		} else if (!optoPhone.equals(other.optoPhone))
			return false;
		if (pharmAddress == null) {
			if (other.pharmAddress != null)
				return false;
		} else if (!pharmAddress.equals(other.pharmAddress))
			return false;
		if (pharmName == null) {
			if (other.pharmName != null)
				return false;
		} else if (!pharmName.equals(other.pharmName))
			return false;
		if (pharmPhone == null) {
			if (other.pharmPhone != null)
				return false;
		} else if (!pharmPhone.equals(other.pharmPhone))
			return false;
		if (physDescription == null) {
			if (other.physDescription != null)
				return false;
		} else if (!physDescription.equals(other.physDescription))
			return false;
		if (prescripLe == null) {
			if (other.prescripLe != null)
				return false;
		} else if (!prescripLe.equals(other.prescripLe))
			return false;
		if (prescripRe == null) {
			if (other.prescripRe != null)
				return false;
		} else if (!prescripRe.equals(other.prescripRe))
			return false;
		if (travellerId == null) {
			if (other.travellerId != null)
				return false;
		} else if (!travellerId.equals(other.travellerId))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		if (visionConditions == null) {
			if (other.visionConditions != null)
				return false;
		} else if (!visionConditions.equals(other.visionConditions))
			return false;
		if (vitalPrescrip == null) {
			if (other.vitalPrescrip != null)
				return false;
		} else if (!vitalPrescrip.equals(other.vitalPrescrip))
			return false;
		return true;
	}
	
}
