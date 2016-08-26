package com.skyquill.minder.client.reports;

import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.skyquill.minder.client.config.PanelFactory;
import com.skyquill.minder.client.util.VH;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.HeaderItem;
import com.smartgwt.client.widgets.layout.VLayout;

public class DeparturesManifestReportView extends ReportAbstractView {

//	private ReportController controller;
	
	DateItem depFromDate;
	DateItem depToDate;
	DateItem arrFromDate;
	DateItem arrToDate;
	
    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
        	DeparturesManifestReportView panel = new DeparturesManifestReportView();
            id = panel.getID();
            return panel;
        }

        public String getID() {
            return id;
        }

    }

	public DeparturesManifestReportView() {
	}

	@Override
	public Canvas getViewPanel() {

		VLayout vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		
		HeaderItem header = new HeaderItem();  
        header.setDefaultValue("Departures Manifest Report");

        depFromDate = new DateItem("depFromDate");        
		depFromDate.setTitle("Departure Date From");
		depFromDate.setRequired(true);
		depFromDate.setStartDate(VH.getYmdFormat().parse("1901-01-01"));

		depToDate = new DateItem("depToDate");
		depToDate.setTitle("Departure Date To");
		depToDate.setRequired(true);
		depToDate.setStartDate(VH.getYmdFormat().parse("1901-01-01"));
		depToDate.setValue(new Date());

		arrFromDate = new DateItem("arrFromDate");
		arrFromDate.setTitle("Arrival Date From");
		arrFromDate.setRequired(true);
		arrFromDate.setStartDate(VH.getYmdFormat().parse("1901-01-01"));

		arrToDate = new DateItem("arrToDate");
		arrToDate.setTitle("Arrival Date To");
		arrToDate.setRequired(true);
		arrToDate.setStartDate(VH.getYmdFormat().parse("1901-01-01"));
		arrToDate.setValue(new Date());

        parmForm.setFields(header, depFromDate, depToDate, arrFromDate, arrToDate, empTypeRb, outputFormatRb);  
        
		vLayout.addMember(parmForm);
		
		return vLayout;
		
	}

	@Override
	protected boolean validateParms() {
		GWT.log("validateParms starting");

		
		GWT.log("validateParms done");
		return true;
	}

//	protected void submitReport(){
//		GWT.log("DeparturesManifestReport:submitReport starting");
//
////		parmForm.
//		
//		// validate first
////		parms.setReportName("DEPMAN");
////		parms.setReportTitle("Departures Manifest");
////		parms.setSubmitDate(new Date());
////		parms.setSubmitUserId("MJB");
////		GWT.log("emptype=" + empTypeRb.getValue().toString());
////		parms.setEmpType(empTypeRb.getValue().toString());
////		GWT.log("output=" + outputFormatRb.getValue().toString());
////		parms.setOutputFormat(outputFormatRb.getValue().toString());
//		
//
//		// valid? no - show errors
//		
//		
//		// yes - submit to server
//
//		DSCallback submitReportCallback = new DSCallback() {
//
//			@Override
//			public void execute(DSResponse response, Object rawData, DSRequest request) {
//				GWT.log("DeparturesManifestReport:submitReport submitReportCallback starting", null);
//				if (response.getData()!=null) {
//					GWT.log("DeparturesManifestReport:submitReport submitReportCallback response has data", null);
//				} else {
//				}
//				GWT.log("DeparturesManifestReport:submitReport submitReportCallback done", null);
//			}
//		};
//		
//		parmForm.saveData(submitReportCallback);
//		
////		super.submitReport();
//	}
	
}
