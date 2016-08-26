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

public class TravellerDocumentsView extends VLayout {

	private TravellerModel model;
	private ListGrid ppGrid;
	private ListGrid visaGrid;

	public TravellerDocumentsView(TravellerModel aModel) {

		GWT.log("TravellerDocumentsView init ", null);

		setWidth100();
		setHeight100();
		setMembersMargin(10);
		setLayoutMargin(5);

		this.model = aModel;

		SectionStack sectionStack = new SectionStack();
		
		SectionStackSection visaSection = drawVisaSection();  

		SectionStackSection ppSection = drawPassportSection();  

		sectionStack.setSections(visaSection, ppSection);  
		sectionStack.setVisibilityMode(VisibilityMode.MULTIPLE);  
		sectionStack.setAnimateSections(true);  
		sectionStack.setHeight(370);  
		sectionStack.setOverflow(Overflow.HIDDEN);

		addMember(sectionStack);

		GWT.log("TravellerDocumentsView init done", null);

	}

	private SectionStackSection drawVisaSection() {
		
		visaGrid = new ListGrid();
		visaGrid.setAlternateRecordStyles(true);  
		visaGrid.setCanEdit(true);  
		visaGrid.setEditEvent(ListGridEditEvent.CLICK);  
		visaGrid.setDataSource(model.getVisaDataSource());
		visaGrid.setAutoFetchData(false);
		visaGrid.setAutoSaveEdits(false);
		visaGrid.setOverflow(Overflow.HIDDEN);
		visaGrid.setModalEditing(true);
		
		ListGridField delete = VH.createDeleteField(visaGrid);
		
		ListGridField country = new ListGridField("countryId", "Country");
		country.setOptionDataSource(Cache.getCountriesDataSource());
		country.setValueField("id");
		country.setDisplayField("name");
		country.setAlign(Alignment.LEFT);
		country.setWidth(140);

		ListGridField visaType = new ListGridField("visaType", "Type");
		visaType.setType(ListGridFieldType.TEXT);  
		visaType.setAlign(Alignment.LEFT);
		visaType.setWidth(100);
		
		ListGridField visaId = new ListGridField("visaId", "Visa Number");
		visaId.setType(ListGridFieldType.TEXT);  
		visaId.setAlign(Alignment.LEFT);
		visaId.setWidth(100);

		ListGridField issueDate = new ListGridField("issueDate", "Issue Date");
		issueDate.setAlign(Alignment.LEFT);
		issueDate.setType(ListGridFieldType.DATE);  
//		issueDate.setCellFormatter(VH.getYmdFormatter());
		issueDate.setWidth(90);
		
		ListGridField expiryDate = new ListGridField("expiryDate", "Expiry Date");
		expiryDate.setAlign(Alignment.LEFT);
		expiryDate.setType(ListGridFieldType.DATE);  
//		expiryDate.setCellFormatter(VH.getYmdFormatter());
		expiryDate.setWidth(90);

		ListGridField reminder = new ListGridField("remindOnExpiry", "Remind?");
		reminder.setAlign(Alignment.CENTER);
		reminder.setType(ListGridFieldType.BOOLEAN);  
		reminder.setWidth(60);
		
		ListGridField remindDate = new ListGridField("remindDate", "Remind Date");
		remindDate.setAlign(Alignment.LEFT);
		remindDate.setType(ListGridFieldType.DATE);  
//		remindDate.setCellFormatter(VH.getYmdFormatter());
		remindDate.setWidth(90);
		
		ListGridField comments = new ListGridField("comments", "Comments");
		comments.setAlign(Alignment.LEFT);
		comments.setType(ListGridFieldType.TEXT);  
		comments.setWidth(300);

		ListGridField auditDateTime = VH.createAuditDateTimeField();
		ListGridField auditUserId = VH.createAuditUserIdField();
		
		visaGrid.setFields(delete, country, visaType, visaId, issueDate, expiryDate, reminder, remindDate, comments, auditDateTime, auditUserId);

		ImgButton addVisaButton = new ImgButton();  
		addVisaButton.setSrc("[SKIN]actions/add.png");  
		addVisaButton.setSize(16);  
		addVisaButton.setTooltip("Add a new visa");
		addVisaButton.setShowFocused(false);  
		addVisaButton.setShowRollOver(false);  
		addVisaButton.setShowDown(false);  
		addVisaButton.addClickHandler(new ClickHandler() {  
			public void onClick(ClickEvent event) {  
				visaGrid.startEditingNew(VH.getNewRecMap()) ;
			}  
		});  

		SectionStackSection visaSection = new SectionStackSection();  
		visaSection.setTitle("Visas");  
		visaSection.setItems(visaGrid);  
		visaSection.setControls(addVisaButton);  
		visaSection.setExpanded(true);
		
		return visaSection;
	}
	
	private SectionStackSection drawPassportSection() {
		
		ppGrid = new ListGrid();
		ppGrid.setAlternateRecordStyles(true);  
		ppGrid.setCanEdit(true);  
		ppGrid.setEditEvent(ListGridEditEvent.CLICK);  
		ppGrid.setDataSource(model.getPassportDataSource());
		ppGrid.setAutoFetchData(false);
		ppGrid.setAutoSaveEdits(false);
		ppGrid.setOverflow(Overflow.HIDDEN);

		ListGridField delete = VH.createDeleteField(ppGrid);
		
		ListGridField country = new ListGridField("countryId", "Country");
		country.setOptionDataSource(Cache.getCountriesDataSource());
		country.setValueField("id");
		country.setDisplayField("name");
		country.setAlign(Alignment.LEFT);
		country.setWidth(140);

		ListGridField passportNumber = new ListGridField("passportNumber", "Passport Number");
		passportNumber.setType(ListGridFieldType.TEXT);  
		passportNumber.setAlign(Alignment.LEFT);
		passportNumber.setWidth(100);

		ListGridField issueDate = new ListGridField("issueDate", "Issue Date");
		issueDate.setAlign(Alignment.LEFT);
		issueDate.setType(ListGridFieldType.DATE);
//		issueDate.setCellFormatter(VH.getYmdFormatter());
		issueDate.setWidth(90);

		ListGridField firstName = new ListGridField("firstName", "First Name");
		firstName.setAlign(Alignment.LEFT);
		firstName.setType(ListGridFieldType.TEXT);  
		firstName.setWidth(130);

		ListGridField middleName = new ListGridField("middleName", "Middle");
		middleName.setAlign(Alignment.LEFT);
		middleName.setType(ListGridFieldType.TEXT);  
		middleName.setWidth(130);

		ListGridField lastName = new ListGridField("lastName", "Last Name");
		lastName.setAlign(Alignment.LEFT);
		lastName.setType(ListGridFieldType.TEXT);  
		lastName.setWidth(130);

		ListGridField placeOfIssue = new ListGridField("placeOfIssue", "Place of Issue");
		placeOfIssue.setAlign(Alignment.LEFT);
		placeOfIssue.setType(ListGridFieldType.TEXT);  
		placeOfIssue.setWidth(130);
		
		ListGridField expiryDate = new ListGridField("expiryDate", "Expiry Date");
		expiryDate.setAlign(Alignment.LEFT);
		expiryDate.setType(ListGridFieldType.DATE);  
//		expiryDate.setCellFormatter(VH.getYmdFormatter());
		expiryDate.setWidth(90);

		ListGridField reminder = new ListGridField("remindOnExpiry", "Remind?");
		reminder.setAlign(Alignment.CENTER);
		reminder.setType(ListGridFieldType.BOOLEAN);  
		reminder.setWidth(60);
		
		ListGridField remindDate = new ListGridField("remindDate", "Remind Date");
		remindDate.setAlign(Alignment.LEFT);
		remindDate.setType(ListGridFieldType.DATE);  
//		remindDate.setCellFormatter(VH.getYmdFormatter());
		remindDate.setWidth(90);
		
		ListGridField comments = new ListGridField("comments", "Comments");
		comments.setAlign(Alignment.LEFT);
		comments.setType(ListGridFieldType.TEXT);  
		comments.setWidth(300);

		ListGridField auditDateTime = VH.createAuditDateTimeField();
		ListGridField auditUserId = VH.createAuditUserIdField();

		ppGrid.setFields(delete, country, passportNumber, issueDate, firstName, middleName, lastName, placeOfIssue, expiryDate, reminder, remindDate, comments, auditDateTime, auditUserId);

		ImgButton addPassportButton = new ImgButton();  
		addPassportButton.setSrc("[SKIN]actions/add.png");  
		addPassportButton.setSize(16);  
		addPassportButton.setTooltip("Add a new passport");
		addPassportButton.setShowFocused(false);  
		addPassportButton.setShowRollOver(false);  
		addPassportButton.setShowDown(false);  
		addPassportButton.addClickHandler(new ClickHandler() {  
			public void onClick(ClickEvent event) {  
				ppGrid.startEditingNew(VH.getNewRecMap()) ;
			}  
		});  

		SectionStackSection ppSection = new SectionStackSection();  
		ppSection.setTitle("Passports");  
		ppSection.setItems(ppGrid);  
		ppSection.setControls(addPassportButton);  
		ppSection.setExpanded(true);
		
		return ppSection;
	}


//	public void loadData() {
//
//		if (model.getTravellerId()!=null) {
//			GWT.log("TravellerDocumentsView fetching traveller " + model.getTravellerId().toString(), null);
//			ppGrid.fetchData(new Criteria("travellerId", model.getTravellerId().toString()));
//			visaGrid.fetchData(new Criteria("travellerId", model.getTravellerId().toString()));
//			GWT.log("TravellerDocumentsView done fetching traveller " + model.getTravellerId().toString(), null);
//		}
//	}

	public void loadData() {

		GWT.log("TravellerDocumentsView fetching related data ");
		if (model.getTravellerId()!=null) {
			GWT.log("TravellerDocumentsView fetching related data for visas");
			
			visaGrid.fetchRelatedData(model.getTravellerRecord(), model.getTravellerDataSource());
			GWT.log("TravellerDocumentsView done fetching related data for visas, traveller=" + model.getTravellerId(), null);
			
			GWT.log("TravellerDocumentsView fetching related data for passports");
			ppGrid.fetchRelatedData(model.getTravellerRecord(), model.getTravellerDataSource());
			GWT.log("TravellerDocumentsView done fetching related data for passports, traveller=" + model.getTravellerId(), null);
			
		}
	}
	
	public void validate() {
		GWT.log("TravellerDocumentsView validate", null);
		
	}
	
	public void saveAllEdits() {
		GWT.log("TravellerDocumentsView saveAllEdits starting", null);

		saveGridChanges(ppGrid);
		
		saveGridChanges(visaGrid);
		
		GWT.log("TravellerDocumentsView saveAllEdits done", null);
	}
	
	private void saveGridChanges(ListGrid saveGrid) {
		GWT.log("TravellerDocumentsView saveGridChanges", null);
		
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
					GWT.log("TravellerDocumentsView saveGridChanges setting travellerId on visa rec " + i, null);
					saveGrid.setEditValue(j, "travellerId", model.getTravellerId());
				}
			}
			saveGrid.saveAllEdits();
		}
		
		GWT.log("TravellerDocumentsView saveGridChanges done", null);
	}

	public ListGrid getVisaGrid() {
		return visaGrid;
	}
	
}
