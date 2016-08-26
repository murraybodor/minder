package com.skyquill.minder.client;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;

public class TravellerSecProfileView extends HLayout {

	private TravellerModel model;
	private DynamicForm securityProfileForm;
	private ValuesManager vm;

	public TravellerSecProfileView(TravellerModel aModel) {

		GWT.log("TravellerSecProfileView init ", null);

		setWidth100();
		setHeight100();
		setMembersMargin(10);
		setLayoutMargin(5);

		this.model = aModel;

		vm = new ValuesManager();
		vm.setDataSource(model.getSecProfileDataSource());
		
		drawSecurityProfileForm();
		
		SectionStack lhsStack = new SectionStack();
		
		lhsStack.setSections(drawEmerg1Section(), drawPhysSection(), drawDocSection(), drawDentSection());  
		lhsStack.setVisibilityMode(VisibilityMode.MULTIPLE);  
		lhsStack.setAnimateSections(true);  
		lhsStack.setHeight(850);  

		addMember(lhsStack);

		SectionStack rhsStack = new SectionStack();

		rhsStack.setSections(drawEmerg2Section(), drawPharmSection(), drawOptoSection(), drawMiscSection());  
		rhsStack.setVisibilityMode(VisibilityMode.MULTIPLE);  
		rhsStack.setAnimateSections(true);  
		rhsStack.setHeight(850);  
		
		
		addMember(rhsStack);
		
		GWT.log("TravellerSecProfileView init done", null);

	}
	
	private SectionStackSection drawEmerg1Section() {
		SectionStackSection emerg1Section = new SectionStackSection();  
		emerg1Section.setTitle("Emergency Contact #1");  
		emerg1Section.setExpanded(true);
		
		DynamicForm emerg1Form = new DynamicForm();
		emerg1Form.setPadding(10);
		emerg1Form.setWrapItemTitles(false);
		emerg1Form.setWidth(300);
		emerg1Form.setValuesManager(vm);
		emerg1Form.setDataSource(model.getSecProfileDataSource());

		TextItem emergContact1Name = new TextItem("emergContact1Name");
		emergContact1Name.setTitle("Name");
		emergContact1Name.setWidth(200);

		TextItem emergContact1Rship = new TextItem("emergContact1Rship");
		emergContact1Rship.setTitle("Relationship");
		emergContact1Rship.setWidth(200);
		
		TextItem emergContact1DayPhone = new TextItem("emergContact1DayPhone");
		emergContact1DayPhone.setTitle("Daytime Phone");
		emergContact1DayPhone.setWidth(200);

		TextItem emergContact1EvePhone = new TextItem("emergContact1EvePhone");
		emergContact1EvePhone.setTitle("Evening Phone");
		emergContact1EvePhone.setWidth(200);

		TextItem emergContact1CellPhone = new TextItem("emergContact1CellPhone");
		emergContact1CellPhone.setTitle("Cell Phone");
		emergContact1CellPhone.setWidth(200);
		
		emerg1Form.setFields(emergContact1Name, emergContact1Rship, emergContact1DayPhone, emergContact1EvePhone, emergContact1CellPhone);
		
		emerg1Section.addItem(emerg1Form);
		
		return emerg1Section;
	}

	private SectionStackSection drawEmerg2Section() {
		SectionStackSection emerg2Section = new SectionStackSection();  
		emerg2Section.setTitle("Emergency Contact #2");  
		emerg2Section.setExpanded(true);
		
		DynamicForm emerg2Form = new DynamicForm();
		emerg2Form.setPadding(10);
		emerg2Form.setWidth(300);
		emerg2Form.setWrapItemTitles(false);
		emerg2Form.setValuesManager(vm);
		emerg2Form.setDataSource(model.getSecProfileDataSource());

		TextItem emergContact2Name = new TextItem("emergContact2Name");
		emergContact2Name.setTitle("Name");
		emergContact2Name.setWidth(200);

		TextItem emergContact2Rship = new TextItem("emergContact2Rship");
		emergContact2Rship.setTitle("Relationship");
		emergContact2Rship.setWidth(200);
		
		TextItem emergContact2DayPhone = new TextItem("emergContact2DayPhone");
		emergContact2DayPhone.setTitle("Daytime Phone");
		emergContact2DayPhone.setWidth(200);

		TextItem emergContact2EvePhone = new TextItem("emergContact2EvePhone");
		emergContact2EvePhone.setTitle("Evening Phone");
		emergContact2EvePhone.setWidth(200);

		TextItem emergContact2CellPhone = new TextItem("emergContact2CellPhone");
		emergContact2CellPhone.setTitle("Cell Phone");
		emergContact2CellPhone.setWidth(200);
		
		emerg2Form.setFields(emergContact2Name, emergContact2Rship, emergContact2DayPhone, emergContact2EvePhone, emergContact2CellPhone);
		
		emerg2Section.addItem(emerg2Form);
		
		return emerg2Section;
	}
	
	private SectionStackSection drawPhysSection() {
		SectionStackSection physSection = new SectionStackSection();  
		physSection.setTitle("Physical");  
		physSection.setExpanded(true);
		
		DynamicForm physForm = new DynamicForm();
		physForm.setPadding(10);
		physForm.setWidth(300);
		physForm.setWrapItemTitles(false);
		physForm.setValuesManager(vm);
		physForm.setDataSource(model.getSecProfileDataSource());
		
		TextItem bloodType = new TextItem("bloodType");
		bloodType.setTitle("Blood Type");
		bloodType.setWidth(200);

		TextAreaItem allergies = new TextAreaItem("allergies");
		allergies.setTitle("Allergies");
		allergies.setWidth(200);
		allergies.setHeight(50);

		TextAreaItem physDescription = new TextAreaItem("physDescription");
		physDescription.setTitle("Physical Description");
		physDescription.setWidth(200);
		physDescription.setHeight(50);
		
		physForm.setFields(bloodType, allergies, physDescription);
		
		physSection.addItem(physForm);
		
		return physSection;
	}

	private SectionStackSection drawDocSection() {
		SectionStackSection docSection = new SectionStackSection();  
		docSection.setTitle("Doctor");  
		docSection.setExpanded(true);
		
		DynamicForm docForm = new DynamicForm();
		docForm.setPadding(10);
		docForm.setWidth(300);
		docForm.setWrapItemTitles(false);
		docForm.setValuesManager(vm);
		docForm.setDataSource(model.getSecProfileDataSource());


		TextItem doctorName = new TextItem("doctorName");
		doctorName.setTitle("Name");
		doctorName.setWidth(200);

		TextAreaItem doctorAddress = new TextAreaItem("doctorAddress");
		doctorAddress.setTitle("Address");
		doctorAddress.setWidth(200);
		doctorAddress.setHeight(50);
		
		TextItem doctorPhone = new TextItem("doctorPhone");
		doctorPhone.setTitle("Phone");
		doctorPhone.setWidth(200);

		docForm.setFields(doctorName, doctorAddress, doctorPhone);
		
		docSection.addItem(docForm);
		
		return docSection;
	}
	
	private SectionStackSection drawDentSection() {
		SectionStackSection dentSection = new SectionStackSection();  
		dentSection.setTitle("Dentist");  
		dentSection.setExpanded(true);
		
		DynamicForm dentForm = new DynamicForm();
		dentForm.setPadding(10);
		dentForm.setWidth(300);
		dentForm.setWrapItemTitles(false);
		dentForm.setValuesManager(vm);
		dentForm.setDataSource(model.getSecProfileDataSource());


		TextItem dentName = new TextItem("dentName");
		dentName.setTitle("Name");
		dentName.setWidth(200);

		TextAreaItem dentAddress = new TextAreaItem("dentAddress");
		dentAddress.setTitle("Address");
		dentAddress.setWidth(200);
		dentAddress.setHeight(50);
		
		TextItem dentPhone = new TextItem("dentPhone");
		dentPhone.setTitle("Phone");
		dentPhone.setWidth(200);

		TextAreaItem dentConditions = new TextAreaItem("dentConditions");
		dentConditions.setTitle("Dental Conditions");
		dentConditions.setWidth(200);
		dentConditions.setHeight(50);
		
		dentForm.setFields(dentName, dentAddress, dentPhone, dentConditions);
		
		dentSection.addItem(dentForm);
		
		return dentSection;
	}
	
	private SectionStackSection drawPharmSection() {
		SectionStackSection pharmSection = new SectionStackSection();  
		pharmSection.setTitle("Pharmacy");  
		pharmSection.setExpanded(true);
		
		DynamicForm pharmForm = new DynamicForm();
		pharmForm.setPadding(10);
		pharmForm.setWidth(300);
		pharmForm.setWrapItemTitles(false);
		pharmForm.setValuesManager(vm);
		pharmForm.setDataSource(model.getSecProfileDataSource());

		TextItem pharmName = new TextItem("pharmName");
		pharmName.setTitle("Name");
		pharmName.setWidth(200);

		TextAreaItem pharmAddress = new TextAreaItem("pharmAddress");
		pharmAddress.setTitle("Address");
		pharmAddress.setWidth(200);
		pharmAddress.setHeight(50);
		
		TextItem pharmPhone = new TextItem("pharmPhone");
		pharmPhone.setTitle("Phone");
		pharmPhone.setWidth(200);

		TextItem vitalPrescrip = new TextItem("vitalPrescrip");
		vitalPrescrip.setTitle("Vital Prescriptions");
		vitalPrescrip.setWidth(200);
		
		pharmForm.setFields(pharmName, pharmAddress, pharmPhone, vitalPrescrip);
		
		pharmSection.addItem(pharmForm);
		
		return pharmSection;
	}

	private SectionStackSection drawOptoSection() {
		SectionStackSection optoSection = new SectionStackSection();  
		optoSection.setTitle("Optometrist");  
		optoSection.setExpanded(true);
		
		DynamicForm optoForm = new DynamicForm();
		optoForm.setPadding(10);
		optoForm.setWidth(300);
		optoForm.setWrapItemTitles(false);
		optoForm.setValuesManager(vm);
		optoForm.setDataSource(model.getSecProfileDataSource());

		TextItem optoName = new TextItem("optoName");
		optoName.setTitle("Name");
		optoName.setWidth(200);

		TextAreaItem optoAddress = new TextAreaItem("optoAddress");
		optoAddress.setTitle("Address");
		optoAddress.setWidth(200);
		optoAddress.setHeight(50);
		
		TextItem optoPhone = new TextItem("optoPhone");
		optoPhone.setTitle("Phone");
		optoPhone.setWidth(200);

		TextAreaItem visionConditions = new TextAreaItem("visionConditions");
		visionConditions.setTitle("Vision Conditions");
		visionConditions.setWidth(200);
		visionConditions.setHeight(50);
		
		optoForm.setFields(optoName, optoAddress, optoPhone, visionConditions);
		
		optoSection.addItem(optoForm);
		
		return optoSection;
	}
	
	private SectionStackSection drawMiscSection() {
		SectionStackSection miscSection = new SectionStackSection();  
		miscSection.setTitle("Misc");  
		miscSection.setExpanded(true);
		
		DynamicForm miscForm = new DynamicForm();
		miscForm.setPadding(10);
		miscForm.setWidth(300);
		miscForm.setWrapItemTitles(false);
		miscForm.setValuesManager(vm);
		miscForm.setDataSource(model.getSecProfileDataSource());

		TextAreaItem homeAddress = new TextAreaItem("homeAddress");
		homeAddress.setTitle("Home Address");
		homeAddress.setWidth(200);
		homeAddress.setHeight(50);

		TextAreaItem likes = new TextAreaItem("likes");
		likes.setTitle("Interests");
		likes.setWidth(200);
		likes.setHeight(50);

		TextAreaItem codePhrase = new TextAreaItem("codePhrase");
		codePhrase.setTitle("Code Phrase");
		codePhrase.setWidth(200);
		codePhrase.setHeight(50);
		
		miscForm.setFields(homeAddress, likes, codePhrase);
		
		miscSection.addItem(miscForm);
		
		return miscSection;
	}
	
	private void drawSecurityProfileForm() {
		securityProfileForm = new DynamicForm();
		securityProfileForm.setPadding(10);
		securityProfileForm.setWrapItemTitles(false);
		securityProfileForm.setNumCols(4);
		securityProfileForm.setDataSource(model.getSecProfileDataSource());
		securityProfileForm.setUseAllDataSourceFields(true);
	}



	public void loadData() {

		if (model.getTravellerId()!=null) {
			GWT.log("TravellerSecProfileView fetching traveller " + model.getTravellerId().toString(), null);
			
			DSCallback secCallback = new DSCallback() {

				@Override
				public void execute(DSResponse response, Object rawData, DSRequest request) {
					GWT.log("TravellerSecProfileView.loadData sosCallback starting", null);
					Record secRec;
					if (response.getData()!=null) {
						GWT.log("TravellerSecProfileView.loadData sosCallback response data not null", null);
						Record[] secRecs = response.getData();
						if (secRecs==null || secRecs.length==0) {
							GWT.log("TravellerSecProfileView.loadData sosCallback response data not null but array is null or empty", null);
							Map<String, String> newVals = new HashMap<String, String>();
							newVals.put("travellerId", model.getTravellerId());
							vm.editNewRecord(newVals);
						} else {
							secRec = secRecs[0];
							GWT.log("TravellerSecProfileView.loadData sosCallback response data not null and found an emplDetails rec", null);
							vm.editRecord(secRec);
						}
					} else {
						GWT.log("TravellerSecProfileViewloadData sosCallback response data is null", null);
						Map<String, String> newVals = new HashMap<String, String>();
						newVals.put("travellerId", model.getTravellerId());
						vm.editNewRecord(newVals);
					}
					GWT.log("TravellerSecProfileView.loadData sosCallback done", null);
				}
			};
			
			
			vm.fetchData(new Criteria("travellerId", model.getTravellerId()), secCallback);
			GWT.log("TravellerSecProfileView done fetching traveller " + model.getTravellerId(), null);
		}
	}

	public void saveAllEdits() {
		GWT.log("TravellerSecProfileView.saveAllEdits ");

		// update records for travellerid from model
		
		vm.setValue("travellerId", model.getTravellerId());
		vm.saveData();

		GWT.log("TravellerSecProfileView.saveAllEdits done");
	}
}
