package com.skyquill.minder.client;

import com.google.gwt.core.client.GWT;
import com.skyquill.minder.client.util.VH;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.layout.VLayout;

public class TravellerMedicalView extends VLayout {

	private TravellerModel model;
	private ListGrid medicalAssessmentGrid;
	private ListGrid vaccinationGrid;

	public TravellerMedicalView(TravellerModel aModel) {

		GWT.log("TravellerMedicalView init ", null);

		setWidth100();
		setHeight100();
		setMembersMargin(10);
		setLayoutMargin(5);

		this.model = aModel;

		SectionStack sectionStack = new SectionStack();
		
		SectionStackSection vacSection = drawVaccinationSection();  

		GWT.log("TravellerMedicalView init b", null);
		
		SectionStackSection maSection = drawMedicalAssessmentSection();  

		sectionStack.setSections(vacSection, maSection);  
		sectionStack.setVisibilityMode(VisibilityMode.MULTIPLE);  
		sectionStack.setAnimateSections(true);  
		sectionStack.setHeight(370);  
		sectionStack.setOverflow(Overflow.HIDDEN);

		addMember(sectionStack);

		GWT.log("TravellerMedicalView init done", null);

	}

	private SectionStackSection drawVaccinationSection() {
		GWT.log("TravellerMedicalView drawVaccinationSection ", null);
		
		vaccinationGrid = new ListGrid();
		vaccinationGrid.setAlternateRecordStyles(true);  
		vaccinationGrid.setCanEdit(true);  
		vaccinationGrid.setEditEvent(ListGridEditEvent.CLICK);  
		vaccinationGrid.setDataSource(model.getVaccinationDataSource());
		vaccinationGrid.setAutoFetchData(false);
		vaccinationGrid.setAutoSaveEdits(false);
		vaccinationGrid.setOverflow(Overflow.HIDDEN);
		
		ListGridField delete = VH.createDeleteField(vaccinationGrid);
		
		ListGridField vaccinationType = new ListGridField("vaccinationType", "Type");
		vaccinationType.setType(ListGridFieldType.TEXT);  
		vaccinationType.setAlign(Alignment.LEFT);
		vaccinationType.setWidth(100);
		
		ListGridField vaccinationDate = new ListGridField("vaccinationDate", "Vaccination Date");
		vaccinationDate.setAlign(Alignment.LEFT);
		vaccinationDate.setType(ListGridFieldType.DATE);  
		vaccinationDate.setWidth(90);
		
		ListGridField expiryDate = new ListGridField("expiryDate", "Expiry Date");
		expiryDate.setAlign(Alignment.LEFT);
		expiryDate.setType(ListGridFieldType.DATE);  
		expiryDate.setWidth(90);

		ListGridField reminder = new ListGridField("remindOnExpiry", "Remind?");
		reminder.setAlign(Alignment.CENTER);
		reminder.setType(ListGridFieldType.BOOLEAN);  
		reminder.setWidth(60);
		
		ListGridField remindDate = new ListGridField("remindDate", "Remind Date");
		remindDate.setAlign(Alignment.LEFT);
		remindDate.setType(ListGridFieldType.DATE);  
		remindDate.setWidth(90);

		ListGridField booster1DueDate = new ListGridField("booster1DueDate", "Booster 1 Due");
		booster1DueDate.setAlign(Alignment.LEFT);
		booster1DueDate.setType(ListGridFieldType.DATE);  
		booster1DueDate.setWidth(90);

		ListGridField booster1RemindDate = new ListGridField("booster1RemindDate", "B1 Remind Date");
		booster1RemindDate.setAlign(Alignment.LEFT);
		booster1RemindDate.setType(ListGridFieldType.DATE);  
		booster1RemindDate.setWidth(90);

		ListGridField booster2DueDate = new ListGridField("booster2DueDate", "Booster 2 Due");
		booster2DueDate.setAlign(Alignment.LEFT);
		booster2DueDate.setType(ListGridFieldType.DATE);  
		booster2DueDate.setWidth(90);

		ListGridField booster2RemindDate = new ListGridField("booster2RemindDate", "B2 Remind Date");
		booster2RemindDate.setAlign(Alignment.LEFT);
		booster2RemindDate.setType(ListGridFieldType.DATE);  
		booster2RemindDate.setWidth(90);
		
		ListGridField comments = new ListGridField("comments", "Comments");
		comments.setAlign(Alignment.LEFT);
		comments.setType(ListGridFieldType.TEXT);  
		comments.setWidth(300);

		ListGridField auditDateTime = VH.createAuditDateTimeField();
		ListGridField auditUserId = VH.createAuditUserIdField();
		
		vaccinationGrid.setFields(delete, vaccinationType, vaccinationDate, expiryDate, reminder, remindDate, booster1DueDate, booster1RemindDate, booster2DueDate, booster2RemindDate, comments, auditDateTime, auditUserId);

		ImgButton addVacButton = new ImgButton();  
		addVacButton.setSrc("[SKIN]actions/add.png");  
		addVacButton.setSize(16);  
		addVacButton.setTooltip("Add a new vaccination");
		addVacButton.setShowFocused(false);  
		addVacButton.setShowRollOver(false);  
		addVacButton.setShowDown(false);  
		addVacButton.addClickHandler(new ClickHandler() {  
			public void onClick(ClickEvent event) {  
				vaccinationGrid.startEditingNew(VH.getNewRecMap()) ;
			}  
		});  

		SectionStackSection vacSection = new SectionStackSection();  
		vacSection.setTitle("Vaccinations");  
		vacSection.setItems(vaccinationGrid);  
		vacSection.setControls(addVacButton);  
		vacSection.setExpanded(true);
		
		GWT.log("TravellerMedicalView drawVaccinationSection done", null);
		return vacSection;
	}
	
	private SectionStackSection drawMedicalAssessmentSection() {
		GWT.log("TravellerMedicalView drawMedicalAssessmentSection ", null);
		
		medicalAssessmentGrid = new ListGrid();
		medicalAssessmentGrid.setAlternateRecordStyles(true);  
		medicalAssessmentGrid.setCanEdit(true);  
		medicalAssessmentGrid.setEditEvent(ListGridEditEvent.CLICK);  
		medicalAssessmentGrid.setDataSource(model.getMedAssessDataSource());
		medicalAssessmentGrid.setAutoFetchData(false);
		medicalAssessmentGrid.setAutoSaveEdits(false);
		medicalAssessmentGrid.setOverflow(Overflow.HIDDEN);

		ListGridField delete = VH.createDeleteField(medicalAssessmentGrid);
		
		ListGridField country = new ListGridField("countryId", "Country");
		country.setOptionDataSource(Cache.getCountriesDataSource());
		country.setValueField("id");
		country.setDisplayField("name");
		country.setAlign(Alignment.LEFT);
		country.setWidth(140);

		ListGridField assessmentType = new ListGridField("assessmentType", "Assessment Type");
		assessmentType.setType(ListGridFieldType.TEXT);  
		assessmentType.setAlign(Alignment.LEFT);
		assessmentType.setWidth(100);

		ListGridField assessmentDate = new ListGridField("assessmentDate", "Date");
		assessmentDate.setAlign(Alignment.LEFT);
		assessmentDate.setType(ListGridFieldType.DATE);
		assessmentDate.setWidth(90);

		ListGridField comments = new ListGridField("comments", "Comments");
		comments.setAlign(Alignment.LEFT);
		comments.setType(ListGridFieldType.TEXT);  
		comments.setWidth(300);

		ListGridField auditDateTime = VH.createAuditDateTimeField();
		ListGridField auditUserId = VH.createAuditUserIdField();

		medicalAssessmentGrid.setFields(delete, country, assessmentType, assessmentDate, comments, auditDateTime, auditUserId);

		ImgButton addMedAssessButton = new ImgButton();  
		addMedAssessButton.setSrc("[SKIN]actions/add.png");  
		addMedAssessButton.setSize(16);  
		addMedAssessButton.setTooltip("Add a new medical assessment");
		addMedAssessButton.setShowFocused(false);  
		addMedAssessButton.setShowRollOver(false);  
		addMedAssessButton.setShowDown(false);  
		addMedAssessButton.addClickHandler(new ClickHandler() {  
			public void onClick(ClickEvent event) {  
				medicalAssessmentGrid.startEditingNew(VH.getNewRecMap()) ;
			}  
		});  

		SectionStackSection maSection = new SectionStackSection();  
		maSection.setTitle("Medical Assessments");  
		maSection.setItems(medicalAssessmentGrid);  
		maSection.setControls(addMedAssessButton);  
		maSection.setExpanded(true);
		
		GWT.log("TravellerMedicalView drawMedicalAssessmentSection done", null);
		
		return maSection;
	}


	public void loadData() {
		GWT.log("TravellerMedicalView loadData", null);

		if (model.getTravellerId()!=null) {
			GWT.log("TravellerMedicalView fetching related data for medicalAssessmentGrid");
			medicalAssessmentGrid.fetchRelatedData(model.getTravellerRecord(), model.getTravellerDataSource());
			GWT.log("TravellerMedicalView fetching related data for vaccinationGrid");
			vaccinationGrid.fetchRelatedData(model.getTravellerRecord(), model.getTravellerDataSource());
		}
	}

	public void saveAllEdits() {
		GWT.log("TravellerMedicalView saveAllEdits", null);

		saveGridChanges(medicalAssessmentGrid);

		saveGridChanges(vaccinationGrid);
		
		GWT.log("TravellerMedicalView saveAllEdits done", null);
	}
	
	private void saveGridChanges(ListGrid saveGrid) {
		
		if (saveGrid.hasChanges()) {
			
			int[] gridRows = saveGrid.getAllEditRows();
			for (int i = 0; i < gridRows.length; i++) {
				int j = gridRows[i];
				Record aRec = saveGrid.getEditedRecord(j);
				boolean deleted = aRec.getAttributeAsBoolean("isDeleted");
				
				if (deleted) {
					saveGrid.discardAllEdits(new int[] {j}, true);
					saveGrid.removeData(aRec);
				} else {
					saveGrid.setEditValue(j, "travellerId", model.getTravellerId());
				}
			}
			saveGrid.saveAllEdits();
		}
		
	}
}
