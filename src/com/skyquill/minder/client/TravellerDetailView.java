package com.skyquill.minder.client;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.skyquill.minder.client.util.VH;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.events.ItemChangeEvent;
import com.smartgwt.client.widgets.form.events.ItemChangeHandler;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.layout.VLayout;

public class TravellerDetailView extends VLayout {

	final DynamicForm travellerForm;  
	private TravellerModel model;
	private SectionStack emplStack;
	private DynamicForm emplForm;
	private DynamicForm contrForm;
//	private boolean travDirty = false;
	private boolean emplDirty = false;
	private boolean contrDirty = false;
	
	public TravellerDetailView(TravellerModel model) {

		GWT.log("TravellerDetailView init ", null);
		
		setWidth100();
		setHeight100();
		setMembersMargin(0);
		setLayoutMargin(0);

		this.model = model;
		
		travellerForm = new DynamicForm();  
		travellerForm.setDataSource(model.getTravellerDataSource());  
		travellerForm.setUseAllDataSourceFields(true);
		travellerForm.setWrapItemTitles(false);
		travellerForm.addItemChangeHandler(new ItemChangeHandler() {
			@Override
			public void onItemChange(ItemChangeEvent event) {
//				travDirty = true;
			}
		});
		
		DateItem birthDate = new DateItem("birthDate");
		birthDate.setTitle("Birth Date");
		birthDate.setRequired(true);
		birthDate.setStartDate(VH.getYmdFormat().parse("1901-01-01"));
		
		CheckboxItem emplCbItem = new CheckboxItem("employee");  
		emplCbItem.setTitle("Employee?");  
		emplCbItem.addChangeHandler(new ChangeHandler () {

			@Override
			public void onChange(ChangeEvent event) {
				GWT.log("TravellerDetailView emplCbItem changed to " + event.getValue(), null);
				processEmplCbClick((Boolean)event.getValue());
			}
			
		});
		
		travellerForm.setFields(birthDate, emplCbItem);
		
		HLayout hLayout = new HLayout();
		hLayout.setWidth100();
		hLayout.setHeight100();
		hLayout.setMembersMargin(10);
		hLayout.setLayoutMargin(0);
		
		hLayout.addMember(travellerForm);
		
		drawEmplForm();
		
		SectionStackSection emplSection = new SectionStackSection();  
		emplSection.setID("EMPL");  
		emplSection.setTitle("Employment Details");  
		emplSection.setItems(emplForm);  
		emplSection.setExpanded(true);
		emplSection.setCanCollapse(false);
		emplSection.setHidden(true);

		drawContrForm();
		
		SectionStackSection contrSection = new SectionStackSection();  
		contrSection.setID("CONTR");  
		contrSection.setTitle("Contractor Details");  
		contrSection.setItems(contrForm);  
		contrSection.setExpanded(true);
		contrSection.setCanCollapse(false);
		contrSection.setHidden(true);

		emplStack = new SectionStack();
		emplStack.setSections(emplSection, contrSection);  
		emplStack.setVisibilityMode(VisibilityMode.MUTEX);  
		emplStack.setAnimateSections(false);  
		emplStack.setHeight(370);  
		emplStack.setOverflow(Overflow.HIDDEN);
		
		hLayout.addMember(emplStack);
		
		addMember(hLayout);
		
		GWT.log("TravellerDetailView init done", null);
		
	}

	private void drawEmplForm() {
		emplForm = new DynamicForm();
		emplForm.setPadding(10);
		emplForm.setWrapItemTitles(false);
		emplForm.setNumCols(4);
		emplForm.setDataSource(model.getEmploymentDetailsDataSource());
		emplForm.addItemChangeHandler(new ItemChangeHandler() {
			@Override
			public void onItemChange(ItemChangeEvent event) {
				emplDirty = true;
			}
		});
		

		TextItem title = new TextItem("title");
		title.setWidth(150);
		title.setTitle("Title");

		TextItem department = new TextItem("department");
		department.setWidth(150);
		department.setTitle("Department");

		TextItem division = new TextItem("division");
		division.setWidth(150);
		division.setTitle("Division");

		TextItem businessUnit = new TextItem("businessUnit");
		businessUnit.setWidth(150);
		businessUnit.setTitle("Business Unit");

		TextItem costCenter = new TextItem("costCenter");
		costCenter.setWidth(150);
		costCenter.setTitle("Cost Center");

		TextItem employeeNumber = new TextItem("employeeNumber");
		employeeNumber.setWidth(150);
		employeeNumber.setTitle("Employee Number");

		TextItem email = new TextItem("email");
		email.setWidth(150);
		email.setTitle("Email Address");

		TextItem officePhone = new TextItem("officePhone");
		officePhone.setWidth(150);
		officePhone.setTitle("Office Phone");

		TextItem officeFax = new TextItem("officeFax");
		officeFax.setWidth(150);
		officeFax.setTitle("Office Fax");
		
		SelectItem adminAssistant = new SelectItem("adminAssistantId", "Admin Assistant");
		adminAssistant.setOptionDataSource(Cache.getAdminsDataSource());
		adminAssistant.setValueField("id");
		adminAssistant.setDisplayField("name");
		adminAssistant.setWidth(150);

		SelectItem supervisor = new SelectItem("supervisorId", "Supervisor");
		supervisor.setOptionDataSource(Cache.getSupervisorsDataSource());
		supervisor.setValueField("id");
		supervisor.setDisplayField("name");
		supervisor.setWidth(150);

		DateItem startDate = new DateTimeItem("startDate");
		startDate.setTitle("Start Date");
		startDate.setUseTextField(true);
		startDate.setWidth(120);
		startDate.setDateFormatter(VH.getYmdDisplayFormat());  	
		startDate.setStartRow(true);

		DateItem terminationDate = new DateTimeItem("terminationDate");
		terminationDate.setTitle("Termination Date");
		terminationDate.setUseTextField(true);
		terminationDate.setWidth(120);
		terminationDate.setDateFormatter(VH.getYmdDisplayFormat());  	

		CheckboxItem exPatCb = new CheckboxItem("exPat");  
		exPatCb.setTitle("Ex Pat");  

		
		emplForm.setFields(title, department, division, businessUnit, costCenter, employeeNumber, email, officePhone, officeFax, adminAssistant, supervisor, startDate, terminationDate, exPatCb, VH.drawCommentsField(), VH.drawAuditDateTimeField(), VH.drawAuditUserIdField());
	}

	private void drawContrForm() {
		contrForm = new DynamicForm();
		contrForm.setPadding(10);
		contrForm.setWrapItemTitles(false);
		contrForm.setNumCols(4);
		contrForm.setDataSource(model.getNonEmploymentDetailsDataSource());
		
		contrForm.addItemChangeHandler(new ItemChangeHandler() {
			@Override
			public void onItemChange(ItemChangeEvent event) {
				contrDirty = true;
			}
		});

		TextItem title = new TextItem("title");
		title.setWidth(150);
		title.setTitle("Title");
		
		TextItem companyName = new TextItem("companyName");
		companyName.setWidth(150);
		companyName.setTitle("Company Name");

		TextItem officePhone = new TextItem("officePhone");
		officePhone.setWidth(150);
		officePhone.setTitle("Office Phone");

		TextItem email = new TextItem("email");
		email.setWidth(150);
		email.setTitle("Email Address");
		
		TextItem costCenter = new TextItem("costCenter");
		costCenter.setWidth(150);
		costCenter.setTitle("Cost Center");

		TextItem supervisorEmail = new TextItem("supervisorEmail");
		supervisorEmail.setWidth(150);
		supervisorEmail.setTitle("Supervisor Email");

		TextItem supervisorName = new TextItem("supervisorName");
		supervisorName.setWidth(150);
		supervisorName.setTitle("Supervisor Name");

		TextItem supervisorPhone = new TextItem("supervisorPhone");
		supervisorPhone.setWidth(150);
		supervisorPhone.setTitle("Supervisor Phone");
		
		SelectItem supervisor = new SelectItem("corpSupervisorId", "Corp. Supervisor");
		supervisor.setOptionDataSource(Cache.getSupervisorsDataSource());
		supervisor.setValueField("id");
		supervisor.setDisplayField("name");
		supervisor.setWidth(150);

		DateItem contractEffectiveDate = new DateTimeItem("contractEffectiveDate");
		contractEffectiveDate.setTitle("Contract Start Date");
		contractEffectiveDate.setUseTextField(true);
		contractEffectiveDate.setWidth(120);
		contractEffectiveDate.setDateFormatter(VH.getYmdDisplayFormat());  	
		contractEffectiveDate.setStartRow(true);

		DateItem contractExpiryDate = new DateTimeItem("contractExpiryDate");
		contractExpiryDate.setTitle("Contract Expiry Date");
		contractExpiryDate.setUseTextField(true);
		contractExpiryDate.setWidth(120);
		contractExpiryDate.setDateFormatter(VH.getYmdDisplayFormat());  	
		
		CheckboxItem dependantCb = new CheckboxItem("dependantCb");  
		dependantCb.setTitle("Dependant");  

		CheckboxItem guestCb = new CheckboxItem("guestCb");  
		guestCb.setTitle("Guest");  
		
		contrForm.setFields(title, companyName, officePhone, email, costCenter, supervisorEmail, supervisorName, supervisorPhone, supervisor, contractEffectiveDate, contractExpiryDate, dependantCb, guestCb, VH.drawCommentsField(), VH.drawAuditDateTimeField(), VH.drawAuditUserIdField());
	}
	
	private void processEmplCbClick(boolean employee) {
		GWT.log("TravellerDetailView processEmplCbClick", null);

		if (employee) {
			emplStack.hideSection("CONTR");
			emplStack.showSection("EMPL");
		} else {
			emplStack.hideSection("EMPL");
			emplStack.showSection("CONTR");
		}
			
		GWT.log("TravellerDetailView processEmplCbClick done", null);
	}  
	
	public void loadEmplData() {
		GWT.log("TravellerDetailView.loadEmplData starting", null);
		
		if (model.getTravellerId()!=null) {
			
			DSCallback emplCallback = new DSCallback() {

				@Override
				public void execute(DSResponse response, Object rawData, DSRequest request) {
					GWT.log("TravellerDetailView.loadEmplData emplCallback starting", null);
					Record emplRec;
					if (response.getData()!=null) {
						GWT.log("TravellerDetailView.loadEmplData emplCallback response data not null", null);
						Record[] emplRecs = response.getData();
						if (emplRecs==null || emplRecs.length==0) {
							GWT.log("TravellerDetailView.loadEmplData emplCallback response data not null but array is null or empty", null);
							Map<String, String> newVals = new HashMap<String, String>();
							newVals.put("travellerId", model.getTravellerId());
							emplForm.editNewRecord(newVals);
						} else {
							emplRec = emplRecs[0];
							GWT.log("TravellerDetailView.loadEmplData emplCallback response data not null and found an emplDetails rec", null);
							emplForm.editRecord(emplRec);
						}
					} else {
						GWT.log("TravellerDetailView.loadEmplData emplCallback response data is null", null);
						Map<String, String> newVals = new HashMap<String, String>();
						newVals.put("travellerId", model.getTravellerId());
						emplForm.editNewRecord(newVals);
					}
					GWT.log("TravellerDetailView.loadData emplCallback done", null);
				}
			};
			
			GWT.log("TravellerDetailView.loadEmplData fetching employee data ");
			emplForm.fetchData(new Criteria("travellerId", model.getTravellerId().toString()), emplCallback);

			DSCallback nonEmplCallback = new DSCallback() {

				@Override
				public void execute(DSResponse response, Object rawData, DSRequest request) {
					GWT.log("TravellerDetailView.loadEmplData nonEmplCallback starting", null);
					Record nonEmplRec;
					if (response.getData()!=null) {
						GWT.log("TravellerDetailView.loadEmplData nonEmplCallback response data not null", null);
						Record[] nonEmplRecs = response.getData();
						if (nonEmplRecs==null || nonEmplRecs.length==0) {
							GWT.log("TravellerDetailView.loadEmplData nonEmplCallback response data not null but array is null or empty", null);
							Map<String, String> newVals = new HashMap<String, String>();
							newVals.put("travellerId", model.getTravellerId());
							contrForm.editNewRecord(newVals);
						} else {
							nonEmplRec = nonEmplRecs[0];
							GWT.log("TravellerDetailView.loadEmplData nonEmplCallback response data not null and found an emplDetails rec", null);
							contrForm.editRecord(nonEmplRec);
						}
					} else {
						GWT.log("TravellerDetailView.loadEmplData nonEmplCallback response data is null", null);
						Map<String, String> newVals = new HashMap<String, String>();
						newVals.put("travellerId", model.getTravellerId());
						contrForm.editNewRecord(newVals);
					}
					GWT.log("TravellerDetailView.loadEmplData nonEmplCallback done", null);
				}
			};
			
			GWT.log("TravellerDetailView.loadEmplData fetching contractor data ");
			contrForm.fetchData(new Criteria("travellerId", model.getTravellerId().toString()), nonEmplCallback);
			
			boolean isEmployee = model.getTravellerRecord().getAttributeAsBoolean("employee");
			
			processEmplCbClick(isEmployee);					
			
		}
		
		GWT.log("TravellerDetailView.loadEmplData done", null);
	}

	public void loadTravellerData(DSCallback callback) {
		GWT.log("TravellerDetailView.loadTravellerData starting", null);
		
		if (model.getTravellerId()!=null) {
			GWT.log("TravellerDetailView.loadTravellerData fetching traveller " + model.getTravellerId(), null);
			travellerForm.fetchData(new Criteria("id", model.getTravellerId()), callback);
		}
		
		GWT.log("TravellerDetailView.loadTravellerData done", null);
	}
	
	public void validate() {
		GWT.log("TravellerDetailView.validate", null);
	}
	
	public void saveEmploymentEdits() {
		
		if (emplDirty) {
			emplForm.setValue("auditDateTime", VH.getYmdHmsFormat().format(new Date()));
			emplForm.setValue("auditUserId", VH.getUserId());
			emplForm.setValue("travellerId", model.getTravellerId());
			emplForm.saveData();
		}
		if (contrDirty) {
			contrForm.setValue("auditDateTime", VH.getYmdHmsFormat().format(new Date()));
			contrForm.setValue("auditUserId", VH.getUserId());
			contrForm.setValue("travellerId", model.getTravellerId());
			contrForm.saveData();
		}
		
	}
	
	public void saveTravellerEdits(DSCallback callback) {
		
		GWT.log("TravellerDetailView.saveTravellerEdits", null);
		travellerForm.saveData(callback);
		GWT.log("TravellerDetailView.ssaveTravellerEdits done", null);
		
	}
}
