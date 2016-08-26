package com.skyquill.minder.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable="true")
public class ReportParameters extends ModelBase implements Serializable {

	private static final long serialVersionUID = 3012318918541261429L;
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String id;
	@Persistent
	private String reportName;
	@Persistent
	private String reportTitle;
	@Persistent
	private Date submitDate;
	@Persistent
	private String submitUserId;
	
	@Persistent
	private Date depFromDate;
	@Persistent
	private Date depToDate;
	@Persistent
	private Date arrFromDate;
	@Persistent
	private Date arrToDate;
	@Persistent
	private String showTerminated;
	@Persistent
	private String empType;
	@Persistent
	private String outputFormat;
	@Persistent
	private String userComments;
	@Persistent
	private String originCityId;
	@Persistent
	private String originCountryId;
	@Persistent
	private String destinationCityId;
	@Persistent
	private String destinationCountryId;
	@Persistent
	private List<String> reportColumns = new ArrayList<String>();
	
	public ReportParameters() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getReportTitle() {
		return reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	public String getSubmitUserId() {
		return submitUserId;
	}

	public void setSubmitUserId(String submitUserId) {
		this.submitUserId = submitUserId;
	}

	public Date getDepFromDate() {
		return depFromDate;
	}

	public void setDepFromDate(Date depFromDate) {
		this.depFromDate = depFromDate;
	}

	public Date getDepToDate() {
		return depToDate;
	}

	public void setDepToDate(Date depToDate) {
		this.depToDate = depToDate;
	}

	public Date getArrFromDate() {
		return arrFromDate;
	}

	public void setArrFromDate(Date arrFromDate) {
		this.arrFromDate = arrFromDate;
	}

	public Date getArrToDate() {
		return arrToDate;
	}

	public void setArrToDate(Date arrToDate) {
		this.arrToDate = arrToDate;
	}

	public String getShowTerminated() {
		return showTerminated;
	}

	public void setShowTerminated(String showTerminated) {
		this.showTerminated = showTerminated;
	}

	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public String getOutputFormat() {
		return outputFormat;
	}

	public void setOutputFormat(String outputFormat) {
		this.outputFormat = outputFormat;
	}

	public String getUserComments() {
		return userComments;
	}

	public void setUserComments(String userComments) {
		this.userComments = userComments;
	}

	public String getOriginCityId() {
		return originCityId;
	}

	public void setOriginCityId(String originCityId) {
		this.originCityId = originCityId;
	}

	public String getOriginCountryId() {
		return originCountryId;
	}

	public void setOriginCountryId(String originCountryId) {
		this.originCountryId = originCountryId;
	}

	public String getDestinationCityId() {
		return destinationCityId;
	}

	public void setDestinationCityId(String destinationCityId) {
		this.destinationCityId = destinationCityId;
	}

	public String getDestinationCountryId() {
		return destinationCountryId;
	}

	public void setDestinationCountryId(String destinationCountryId) {
		this.destinationCountryId = destinationCountryId;
	}

	public List<String> getReportColumns() {
		return reportColumns;
	}

	public void setReportColumns(List<String> reportColumns) {
		this.reportColumns = reportColumns;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((arrFromDate == null) ? 0 : arrFromDate.hashCode());
		result = prime * result
				+ ((arrToDate == null) ? 0 : arrToDate.hashCode());
		result = prime * result
				+ ((depFromDate == null) ? 0 : depFromDate.hashCode());
		result = prime * result
				+ ((depToDate == null) ? 0 : depToDate.hashCode());
		result = prime
				* result
				+ ((destinationCityId == null) ? 0 : destinationCityId
						.hashCode());
		result = prime
				* result
				+ ((destinationCountryId == null) ? 0 : destinationCountryId
						.hashCode());
		result = prime * result + ((empType == null) ? 0 : empType.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((originCityId == null) ? 0 : originCityId.hashCode());
		result = prime * result
				+ ((originCountryId == null) ? 0 : originCountryId.hashCode());
		result = prime * result
				+ ((outputFormat == null) ? 0 : outputFormat.hashCode());
		result = prime * result
				+ ((reportColumns == null) ? 0 : reportColumns.hashCode());
		result = prime * result
				+ ((reportName == null) ? 0 : reportName.hashCode());
		result = prime * result
				+ ((reportTitle == null) ? 0 : reportTitle.hashCode());
		result = prime * result
				+ ((showTerminated == null) ? 0 : showTerminated.hashCode());
		result = prime * result
				+ ((submitDate == null) ? 0 : submitDate.hashCode());
		result = prime * result
				+ ((submitUserId == null) ? 0 : submitUserId.hashCode());
		result = prime * result
				+ ((userComments == null) ? 0 : userComments.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof ReportParameters))
			return false;
		ReportParameters other = (ReportParameters) obj;
		if (arrFromDate == null) {
			if (other.arrFromDate != null)
				return false;
		} else if (!arrFromDate.equals(other.arrFromDate))
			return false;
		if (arrToDate == null) {
			if (other.arrToDate != null)
				return false;
		} else if (!arrToDate.equals(other.arrToDate))
			return false;
		if (depFromDate == null) {
			if (other.depFromDate != null)
				return false;
		} else if (!depFromDate.equals(other.depFromDate))
			return false;
		if (depToDate == null) {
			if (other.depToDate != null)
				return false;
		} else if (!depToDate.equals(other.depToDate))
			return false;
		if (destinationCityId == null) {
			if (other.destinationCityId != null)
				return false;
		} else if (!destinationCityId.equals(other.destinationCityId))
			return false;
		if (destinationCountryId == null) {
			if (other.destinationCountryId != null)
				return false;
		} else if (!destinationCountryId.equals(other.destinationCountryId))
			return false;
		if (empType == null) {
			if (other.empType != null)
				return false;
		} else if (!empType.equals(other.empType))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (originCityId == null) {
			if (other.originCityId != null)
				return false;
		} else if (!originCityId.equals(other.originCityId))
			return false;
		if (originCountryId == null) {
			if (other.originCountryId != null)
				return false;
		} else if (!originCountryId.equals(other.originCountryId))
			return false;
		if (outputFormat == null) {
			if (other.outputFormat != null)
				return false;
		} else if (!outputFormat.equals(other.outputFormat))
			return false;
		if (reportColumns == null) {
			if (other.reportColumns != null)
				return false;
		} else if (!reportColumns.equals(other.reportColumns))
			return false;
		if (reportName == null) {
			if (other.reportName != null)
				return false;
		} else if (!reportName.equals(other.reportName))
			return false;
		if (reportTitle == null) {
			if (other.reportTitle != null)
				return false;
		} else if (!reportTitle.equals(other.reportTitle))
			return false;
		if (showTerminated == null) {
			if (other.showTerminated != null)
				return false;
		} else if (!showTerminated.equals(other.showTerminated))
			return false;
		if (submitDate == null) {
			if (other.submitDate != null)
				return false;
		} else if (!submitDate.equals(other.submitDate))
			return false;
		if (submitUserId == null) {
			if (other.submitUserId != null)
				return false;
		} else if (!submitUserId.equals(other.submitUserId))
			return false;
		if (userComments == null) {
			if (other.userComments != null)
				return false;
		} else if (!userComments.equals(other.userComments))
			return false;
		return true;
	}

}
