package com.skyquill.minder.client;

import com.google.gwt.core.client.GWT;
import com.skyquill.minder.client.util.VH;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Side;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

public class TravellerView  extends VLayout {

	TravellerDetailView detailView;
	ItinerariesView itinerariesView;
	TravellerDocumentsView documentsView;
	TravellerMedicalView medicalView;
	TravellerInsuranceView insuranceView;
	TravellerOrientationsView orientationsView;
	TravellerSecProfileView secProfileView;
	TravellerModel model;
	
	public TravellerView(String travellerId) {
		
		GWT.log("TravellerView init ", null);
		
		setWidth100();
		setHeight100();
		setMembersMargin(5);
		setLayoutMargin(0);
		
		TabSet travellerTabSet = new TabSet();  

		travellerTabSet.setTabBarPosition(Side.TOP);  
		travellerTabSet.setTabBarAlign(Side.LEFT);  
		travellerTabSet.setWidth(VH.TRAVELLER_TABSET_WIDTH);
		travellerTabSet.setHeight(VH.TRAVELLER_TABSET_HEIGHT);

		
		model = new TravellerModel(travellerId);
		detailView = new TravellerDetailView(model);
		itinerariesView = new ItinerariesView(model);
		documentsView = new TravellerDocumentsView(model);
		medicalView = new TravellerMedicalView(model);
		insuranceView = new TravellerInsuranceView(model);
		orientationsView = new TravellerOrientationsView(model);
		secProfileView = new TravellerSecProfileView(model);
		
		Tab travellerDetailTab = new Tab("Traveller");
		travellerDetailTab.setPane(detailView);
		travellerTabSet.addTab(travellerDetailTab);  

		Tab itinerariesTab = new Tab("Itineraries");  
		itinerariesTab.setPane(itinerariesView);
		travellerTabSet.addTab(itinerariesTab);  

		Tab documentTab = new Tab("Travel Documents");  
		documentTab.setPane(documentsView);
		travellerTabSet.addTab(documentTab);  

		Tab medicalTab = new Tab("Medical");  
		medicalTab.setPane(medicalView);
		travellerTabSet.addTab(medicalTab);  

		Tab insuranceTab = new Tab("Insurance");  
		insuranceTab.setPane(insuranceView);
		travellerTabSet.addTab(insuranceTab);  

		Tab orientTab = new Tab("Orientations");  
		orientTab.setPane(orientationsView);
		travellerTabSet.addTab(orientTab);  

		Tab profileTab = new Tab("Detailed Profile");  
		profileTab.setPane(secProfileView);
		travellerTabSet.addTab(profileTab);  

		addMember(travellerTabSet);

		HLayout hLayout = new HLayout(15);  
		hLayout.setAlign(Alignment.CENTER);
		
		IButton saveButton = new IButton("Save");  
		saveButton.addClickHandler(new ClickHandler() {  
			public void onClick(ClickEvent event) {  
				saveTraveller();
			}  
		});  
		hLayout.addMember(saveButton);  

		IButton discardButton = new IButton("Discard");  
		discardButton.addClickHandler(new ClickHandler() {  
			public void onClick(ClickEvent event) {  
//				listGrid.discardAllEdits();  
			}  
		});  
		hLayout.addMember(discardButton); 

		addMember(hLayout);
		
//		loadData();
		
		GWT.log("TravellerView init done", null); 
	}
	
	public void saveTraveller() {
		
		DSCallback callback = new DSCallback() {

			@Override
			public void execute(DSResponse response, Object rawData, DSRequest request) {
				
				Record[] travellers = response.getData();
				GWT.log("TravellerDetailView saveTraveller callback, travellers.length=" + travellers.length, null);
				if (travellers.length>0) {
					Record travRec = travellers[0];
					String travellerId = travRec.getAttribute("id");
					GWT.log("TravellerDetailView saveTraveller travellerId=" + travellerId.toString(), null);
					
					model.setTravellerId(travellerId);
					detailView.saveEmploymentEdits();
//					itinerariesView.saveAllEdits();
					documentsView.saveAllEdits();
					medicalView.saveAllEdits();
					insuranceView.saveAllEdits();
//					orientationsView.saveAllEdits();
					secProfileView.saveAllEdits();
				}
			}
			
		};
		
		detailView.saveTravellerEdits(callback);  
	}
	
	public void loadData() {
		GWT.log("TravellerView loaddata start", null);

		DSCallback loadCallback = new DSCallback() {

			@Override
			public void execute(DSResponse response, Object rawData, DSRequest request) {
				
				Record[] travellers = response.getData();
				GWT.log("TravellerView loadData.callback, travellers.length=" + travellers.length, null);
				
				if (travellers.length>0) {
					Record travRec = travellers[0];
					
					String travellerId = travRec.getAttributeAsString("id");
					GWT.log("TravellerView loadData.callback travellerId=" + travellerId.toString(), null);
					
					model.setTravellerId(travellerId);
					model.setTravellerRecord(travRec);
					
					GWT.log("TravellerView loadData.callback calling documentsview to fetchrelateddata", null);
					
					documentsView.loadData();
					detailView.loadEmplData();
					
//					itinerariesView.loadData();
					medicalView.loadData();
					insuranceView.loadData();
//					orientationsView.loadData();
					secProfileView.loadData();
					
				}
			}
			
		};
		
		GWT.log("TravellerView loaddata calling load on detailView with callback", null);
		
		detailView.loadTravellerData(loadCallback);  
		
		GWT.log("TravellerView loaddata done", null);
	}
	
}
