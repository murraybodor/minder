package com.skyquill.minder.client;

import com.google.gwt.core.client.GWT;
import com.skyquill.minder.client.util.VH;
import com.smartgwt.client.data.Criteria;
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

public class TravellerOrientationsView extends VLayout {

	private TravellerModel model;
	private ListGrid orientationGrid;

	public TravellerOrientationsView(TravellerModel aModel) {

		GWT.log("TravellerOrientationsView init ", null);

		setWidth100();
		setHeight100();
		setMembersMargin(10);
		setLayoutMargin(5);

		this.model = aModel;

		SectionStack sectionStack = new SectionStack();
		
		SectionStackSection oriSection = drawOrientationSection();  

		sectionStack.setSections(oriSection);  
		sectionStack.setVisibilityMode(VisibilityMode.MULTIPLE);  
		sectionStack.setAnimateSections(true);  
		sectionStack.setHeight(370);  
		sectionStack.setOverflow(Overflow.HIDDEN);

		addMember(sectionStack);

		GWT.log("TravellerOrientationsView init done", null);

	}

	private SectionStackSection drawOrientationSection() {
		GWT.log("TravellerOrientationsView drawOrientationSection ", null);
		
		orientationGrid = new ListGrid();
		orientationGrid.setAlternateRecordStyles(true);  
		orientationGrid.setCanEdit(true);  
		orientationGrid.setEditEvent(ListGridEditEvent.CLICK);  
		orientationGrid.setDataSource(model.getOrientationDataSource());
		orientationGrid.setAutoFetchData(false);
		orientationGrid.setAutoSaveEdits(false);
		orientationGrid.setOverflow(Overflow.HIDDEN);
		
		ListGridField delete = VH.createDeleteField(orientationGrid);
		
		ListGridField orientationType = new ListGridField("type", "Type");
		orientationType.setType(ListGridFieldType.TEXT);  
		orientationType.setAlign(Alignment.LEFT);
		orientationType.setWidth(100);

		ListGridField country = new ListGridField("countryId", "Country");
		country.setOptionDataSource(Cache.getCountriesDataSource());
		country.setValueField("id");
		country.setDisplayField("name");
		country.setAlign(Alignment.LEFT);
		country.setWidth(140);
		
		ListGridField name = new ListGridField("name", "Given By");
		name.setType(ListGridFieldType.TEXT);  
		name.setAlign(Alignment.LEFT);
		name.setWidth(200);
		
		ListGridField orientationDate = new ListGridField("orientationDate", "Orientation Date");
		orientationDate.setAlign(Alignment.LEFT);
		orientationDate.setType(ListGridFieldType.DATE);  
		orientationDate.setWidth(90);
		
		ListGridField comments = new ListGridField("comments", "Comments");
		comments.setAlign(Alignment.LEFT);
		comments.setType(ListGridFieldType.TEXT);  
		comments.setWidth(300);
		
		ListGridField auditDateTime = VH.createAuditDateTimeField();
		ListGridField auditUserId = VH.createAuditUserIdField();
		
		orientationGrid.setFields(delete, orientationType, country, name, orientationDate, comments, auditDateTime, auditUserId);

		ImgButton addInsButton = new ImgButton();  
		addInsButton.setSrc("[SKIN]actions/add.png");  
		addInsButton.setSize(16);  
		addInsButton.setTooltip("Add a new security orientation");
		addInsButton.setShowFocused(false);  
		addInsButton.setShowRollOver(false);  
		addInsButton.setShowDown(false);  
		addInsButton.addClickHandler(new ClickHandler() {  
			public void onClick(ClickEvent event) {  
				orientationGrid.startEditingNew(VH.getNewRecMap()) ;
			}  
		});  

		SectionStackSection insSection = new SectionStackSection();  
		insSection.setTitle("Security Orientations");  
		insSection.setItems(orientationGrid);  
		insSection.setControls(addInsButton);  
		insSection.setExpanded(true);
		
		GWT.log("TravellerOrientationsView drawOrientationSection done", null);
		return insSection;
	}
	

	public void loadData() {
		GWT.log("TravellerOrientationsView loadData", null);

		if (model.getTravellerId()!=null) {
			orientationGrid.fetchData(new Criteria("travellerId", model.getTravellerId().toString()));
		}
	}

	public void validate() {
		GWT.log("TravellerOrientationsView validate", null);
		
	}
	public void saveAllEdits() {
		GWT.log("TravellerOrientationsView saveAllEdits", null);

		saveGridChanges(orientationGrid);
		
		GWT.log("TravellerOrientationsView saveAllEdits done", null);
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
