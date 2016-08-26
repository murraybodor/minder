package com.skyquill.minder.client.reports;

//import com.skyquill.minder.client.ReportController;
//import com.skyquill.minder.model.ReportParameters;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.skyquill.minder.client.Cache;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.RadioGroupItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.VLayout;

public abstract class ReportAbstractView extends VLayout {

//	ListGrid listGrid = new ListGrid();  
	
	RadioGroupItem empTypeRb = new RadioGroupItem("empType");  
	RadioGroupItem outputFormatRb = new RadioGroupItem("outputFormat");  
//	ReportParameters parms = new ReportParameters();
	DynamicForm parmForm = new DynamicForm();  
	private static final String REPORT_SERVICE_PATH = "report.smvc";


	public ReportAbstractView() {

		setWidth100();
		setHeight100();

		Layout layout = new HLayout();

		layout.setWidth100();
		layout.setMargin(10);
		layout.setMembersMargin(10);

		parmForm.setNumCols(2);
		parmForm.setWrapItemTitles(false);
		parmForm.setWidth(400);
		parmForm.setCellPadding(5);
        parmForm.setDataSource(Cache.getReportParmsDataSource());  

		
		empTypeRb.setTitle("<b>Employment Type</b>");  
		empTypeRb.setValueMap("Both Employees and Contractors", "Employees only", "Contractors only");  		
		empTypeRb.setDefaultValue("Both Employees and Contractors");
		
		outputFormatRb.setTitle("<b>Report Output Format</b>");  
		outputFormatRb.setValueMap("PDF (Adbobe Acrobat)", "XLS (Excel worksheet)", "CSV (comma-separated values)");  		
		outputFormatRb.setDefaultValue("PDF (Adbobe Acrobat)");
		
//		listGrid.setHeight(300);
//		listGrid.setAlternateRecordStyles(true);  
//		listGrid.setCanEdit(true);  
//		listGrid.setEditEvent(ListGridEditEvent.CLICK);  
//		listGrid.setAutoFetchData(true);
//		listGrid.setAutoSaveEdits(false);  
//		listGrid.setModalEditing(true);
		
		Canvas panel = getViewPanel();
		
		HLayout wrapper = new HLayout();
		wrapper.setWidth100();
		wrapper.addMember(panel);

		layout.addMember(wrapper);
		addMember(layout);
		
		Canvas buttonPanel = getButtonPanel();
		addMember(buttonPanel);
		
	}

	public abstract Canvas getViewPanel();

	public Canvas getButtonPanel() {
		
		HLayout buttonLayout = new HLayout();
		buttonLayout.setWidth100();
		buttonLayout.setMargin(10);
		buttonLayout.setMembersMargin(20);
		buttonLayout.setAlign(Alignment.CENTER);
		
		IButton runButton = new IButton("Run Report");  
		runButton.addClickHandler(new ClickHandler() {  
			public void onClick(ClickEvent event) {  
				submitReport();  
			}  
		});  
		buttonLayout.addMember(runButton);  

		return buttonLayout;
		
	}
	
//	private static String[][] getEmpTypes() {  
//		return new String[][]{  
//				new String[]{"STAFF", "Staff Only"},
//				new String[]{"CONTRACTORS", "Contractors Only"},
//				new String[]{"STAFF_AND_CONTRACTORS", "Both Staff and Contractors"}
//		};}
//
//	private static String[][] getOutputFormats() {  
//		return new String[][]{  
//				new String[]{"PDF", "PDF Document"},
//				new String[]{"EXCEL", "Excel Spreadsheet"},
//				new String[]{"CSV", "CSV file"}
//		};}
	
	
	protected void submitReport() {
		GWT.log("ReportAbstractView.submitReport starting", null);
		
		if (validateParms()) {
			DSCallback submitReportCallback = new DSCallback() {

				@Override
				public void execute(DSResponse response, Object rawData, DSRequest request) {
					GWT.log("ReportAbstractView.submitReport submitReportCallback starting", null);
					if (response.getData()!=null) {
						GWT.log("ReportAbstractView.submitReport submitReportCallback response has data", null);
						Record[] recs = response.getData();
						Record rec = recs[0];
						String id = rec.getAttribute("id");
						GWT.log("ReportAbstractView.submitReport submitReportCallback response rec id=" + id, null);
						Window.open(GWT.getHostPageBaseURL()+REPORT_SERVICE_PATH+"?rptId=" + id, "Report", "");
						
					} else {
					}
					GWT.log("ReportAbstractView.submitReport submitReportCallback done", null);
				}
			};
			
			parmForm.saveData(submitReportCallback);
		}
		
		GWT.log("ReportAbstractView.submitReport done", null);
	}
	
	protected abstract boolean validateParms();
}
