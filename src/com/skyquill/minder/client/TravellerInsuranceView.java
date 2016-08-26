package com.skyquill.minder.client;

import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.skyquill.minder.client.util.VH;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.events.ItemChangeEvent;
import com.smartgwt.client.widgets.form.events.ItemChangeHandler;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.layout.VLayout;

public class TravellerInsuranceView extends VLayout {

	private TravellerModel model;
	private ListGrid insuranceGrid;
	private DynamicForm sosForm;
	private boolean sosDirty = false;

	public TravellerInsuranceView(TravellerModel aModel) {

		GWT.log("TravellerInsuranceView init ", null);

		setWidth100();
		setHeight100();
		setMembersMargin(10);
		setLayoutMargin(5);

		this.model = aModel;

		SectionStack sectionStack = new SectionStack();
		
		SectionStackSection insSection = drawInsuranceSection();  

		GWT.log("TravellerInsuranceView init b", null);
		
		SectionStackSection sosSection = drawSosSection();  

		sectionStack.setSections(insSection, sosSection);  
		sectionStack.setVisibilityMode(VisibilityMode.MULTIPLE);  
		sectionStack.setAnimateSections(true);  
		sectionStack.setHeight(370);  
		sectionStack.setOverflow(Overflow.HIDDEN);

		addMember(sectionStack);

		GWT.log("TravellerInsuranceView init done", null);

	}

	private SectionStackSection drawInsuranceSection() {
		GWT.log("TravellerInsuranceView drawInsuranceSection ", null);
		
		insuranceGrid = new ListGrid();
		insuranceGrid.setAlternateRecordStyles(true);  
		insuranceGrid.setCanEdit(true);  
		insuranceGrid.setEditEvent(ListGridEditEvent.CLICK);  
		insuranceGrid.setDataSource(model.getInsuranceDataSource());
		insuranceGrid.setAutoFetchData(false);
		insuranceGrid.setAutoSaveEdits(false);
		insuranceGrid.setOverflow(Overflow.HIDDEN);
		
		ListGridField delete = VH.createDeleteField(insuranceGrid);
		
		ListGridField insuranceType = new ListGridField("type", "Type");
		insuranceType.setType(ListGridFieldType.TEXT);  
		insuranceType.setAlign(Alignment.LEFT);
		insuranceType.setWidth(100);

		ListGridField provider = new ListGridField("provider", "Provider");
		provider.setType(ListGridFieldType.TEXT);  
		provider.setAlign(Alignment.LEFT);
		provider.setWidth(200);

		ListGridField policyNum = new ListGridField("policyNum", "Policy Number");
		policyNum.setType(ListGridFieldType.TEXT);  
		policyNum.setAlign(Alignment.LEFT);
		policyNum.setWidth(150);
		
		
		ListGridField issueDate = new ListGridField("issueDate", "Issue Date");
		issueDate.setAlign(Alignment.LEFT);
		issueDate.setType(ListGridFieldType.DATE);  
		issueDate.setWidth(90);
		
		ListGridField expiryDate = new ListGridField("expiryDate", "Expiry Date");
		expiryDate.setAlign(Alignment.LEFT);
		expiryDate.setType(ListGridFieldType.DATE);  
		expiryDate.setWidth(90);

		ListGridField policyContact = new ListGridField("policyContact", "Policy Contact");
		policyContact.setType(ListGridFieldType.TEXT);  
		policyContact.setAlign(Alignment.LEFT);
		policyContact.setWidth(200);

		
		ListGridField comments = new ListGridField("comments", "Comments");
		comments.setAlign(Alignment.LEFT);
		comments.setType(ListGridFieldType.TEXT);  
		comments.setWidth(300);
		
		ListGridField auditDateTime = VH.createAuditDateTimeField();
		ListGridField auditUserId = VH.createAuditUserIdField();
		
		insuranceGrid.setFields(delete, insuranceType, provider, policyNum, issueDate, expiryDate, policyContact, comments, auditDateTime, auditUserId);

		ImgButton addInsButton = new ImgButton();  
		addInsButton.setSrc("[SKIN]actions/add.png");  
		addInsButton.setSize(16);  
		addInsButton.setTooltip("Add a new insurance policy");
		addInsButton.setShowFocused(false);  
		addInsButton.setShowRollOver(false);  
		addInsButton.setShowDown(false);  
		addInsButton.addClickHandler(new ClickHandler() {  
			public void onClick(ClickEvent event) {  
				insuranceGrid.startEditingNew(VH.getNewRecMap()) ;
			}  
		});  

		SectionStackSection insSection = new SectionStackSection();  
		insSection.setTitle("Insurance");  
		insSection.setItems(insuranceGrid);  
		insSection.setControls(addInsButton);  
		insSection.setExpanded(true);
		
		GWT.log("TravellerInsuranceView drawInsuranceSection done", null);
		return insSection;
	}
	
	private SectionStackSection drawSosSection() {
		GWT.log("TravellerInsuranceView drawSosSection ", null);
		
		sosForm = new DynamicForm();
		sosForm.setDataSource(model.getSosDataSource());
		sosForm.setNumCols(4);
		
		sosForm.addItemChangeHandler(new ItemChangeHandler() {
			@Override
			public void onItemChange(ItemChangeEvent event) {
				sosDirty = true;
			}
		});

		CheckboxItem persCoverageItem = new CheckboxItem("personalCoverage");  
		persCoverageItem.setTitle("Has Personal Coverage?");  

		TextItem cardType = new TextItem("cardType");
		cardType.setWidth(150);
		cardType.setTitle("Card Type");
		
		TextItem cardNumber = new TextItem("cardNumber");
		cardNumber.setWidth(150);
		cardNumber.setTitle("Card Number");

		DateItem issueDate = new DateTimeItem("issueDate");
		issueDate.setTitle("Issue Date");
		issueDate.setUseTextField(true);
		issueDate.setWidth(120);
		issueDate.setDateFormatter(VH.getYmdDisplayFormat());  	
//		issueDate.setStartRow(true);
		
		DateItem expiryDate = new DateTimeItem("expiryDate");
		expiryDate.setTitle("Expiry Date");
		expiryDate.setUseTextField(true);
		expiryDate.setWidth(120);
		expiryDate.setDateFormatter(VH.getYmdDisplayFormat());  	

		DateItem returnDate = new DateTimeItem("returnDate");
		returnDate.setTitle("Return Date");
		returnDate.setUseTextField(true);
		returnDate.setWidth(120);
		returnDate.setDateFormatter(VH.getYmdDisplayFormat());  	
		
		sosForm.setFields(persCoverageItem, cardType, cardNumber, issueDate, expiryDate, returnDate, VH.drawCommentsField(), VH.drawAuditDateTimeField(), VH.drawAuditUserIdField());
		
		SectionStackSection sosSection = new SectionStackSection();  
		sosSection.setTitle("SOS Coverage");  
		sosSection.setItems(sosForm);  
		sosSection.setExpanded(true);
		
		GWT.log("TravellerInsuranceView drawSosSection done", null);
		
		return sosSection;
	}


	public void loadData() {
		GWT.log("TravellerInsuranceView loadData", null);

		if (model.getTravellerId()!=null) {
			
			DSCallback sosCallback = new DSCallback() {

				@Override
				public void execute(DSResponse response, Object rawData, DSRequest request) {
					Record sosRec;
					if (response.getData()!=null) {
						Record[] emplRecs = response.getData();
						if (emplRecs==null || emplRecs.length==0) {
							sosForm.editNewRecord(VH.getFKMap(model));
						} else {
							sosRec = emplRecs[0];
							sosForm.editRecord(sosRec);
						}
					} else {
						sosForm.editNewRecord(VH.getFKMap(model));
					}
				}
			};
			
			sosForm.fetchData(new Criteria("travellerId", model.getTravellerId()), sosCallback);
			
			insuranceGrid.fetchRelatedData(model.getTravellerRecord(), model.getTravellerDataSource());
		}
	}

	public void validate() {
		GWT.log("TravellerInsuranceView validate", null);
		
	}
	public void saveAllEdits() {
		GWT.log("TravellerInsuranceView saveAllEdits", null);

		saveGridChanges(insuranceGrid);
		
		if (sosDirty) {
			sosForm.setValue("travellerId", model.getTravellerId());
			sosForm.setValue("auditDateTime", VH.getYmdHmsFormat().format(new Date()));
			sosForm.setValue("auditUserId", VH.getUserId());
			sosForm.saveData();
		}
		
		GWT.log("TravellerInsuranceView saveAllEdits done", null);
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
