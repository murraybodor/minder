package com.skyquill.minder.client;

import com.google.gwt.core.client.GWT;
import com.skyquill.minder.client.util.VH;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.Side;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

public class SearchView extends VLayout {

	int newTravellerCount = 1;
	private ListGrid searchByNameResultGrid;
	private DataSource searchByNameResultDataSource;
	private ListGrid searchByFlightResultGrid;
	private DataSource searchByFlightResultDataSource;

	private TravellersController controller;

	public SearchView() {

		setWidth100();
		setHeight100();
		setMembersMargin(0);
		setLayoutMargin(00);

		VLayout vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight(340);
		vLayout.setMembersMargin(5);
		vLayout.setLayoutMargin(5);

		Label label1 = new Label("<b>Search for a traveller in the system by name or by flight.<br><ul><li>Enter your search criteria. Partial names are allowed, no wildcard characters (* or %) are required.</li><li>Click the Search button.</li><li>In the results pane, click on the traveller hyperlink to open the file.</li></ul></b>");
		vLayout.addMember(label1);

		HLayout searchTop = new HLayout();  
		searchTop.setWidth100();
		searchTop.setMembersMargin(5);  
		searchTop.setLayoutMargin(0);

		TabSet searchTabSet = new TabSet();  
		searchTabSet.setTabBarPosition(Side.TOP);  
		searchTabSet.setTabBarAlign(Side.LEFT);  
		searchTabSet.setWidth100();
		searchTabSet.setHeight(190);

		// search by name tab

		Tab searchByNameTab = drawSearchByNameTab();

		searchTabSet.addTab(searchByNameTab);  

		// search by flight tab


		Tab searchByFlightTab = drawSearchByFlightTab();

		searchTabSet.addTab(searchByFlightTab);  


		searchTop.addMember(searchTabSet);

		vLayout.addMember(searchTop);

		HLayout searchBottom = new HLayout();  
		searchBottom.setWidth100();
		searchBottom.setHeight(10);
		searchBottom.setMembersMargin(5);  
		searchBottom.setLayoutMargin(0);

		Label label2 = new Label("<b>Can't find the traveller in the system?</b>");  
		label2.setWrap(false);

		searchBottom.addMember(label2);

		IButton createButton = new IButton("Create A New Traveller");  
		createButton.setWidth(150);
		createButton.addClickHandler(new ClickHandler() {  
			public void onClick(ClickEvent event) {  
				controller.createNewTraveller();
			}  
		});  

		searchBottom.addMember(createButton);


		vLayout.addMember(searchBottom);
		addMember(vLayout);

	}

	private Tab drawSearchByNameTab() {

		DynamicForm searchByNameForm = new DynamicForm();  
		final TextItem firstNameTextItem = new TextItem();  
		firstNameTextItem.setTitle("First Name");  		
		firstNameTextItem.setWidth(150);  		
		firstNameTextItem.setWrapTitle(false);
		final TextItem lastNameTextItem = new TextItem();  
		lastNameTextItem.setTitle("Last Name");  		
		lastNameTextItem.setWidth(150);  		
		lastNameTextItem.setWrapTitle(false);
		searchByNameForm.setFields(firstNameTextItem, lastNameTextItem);  

		IButton searchByNameButton = new IButton("Search");  
		searchByNameButton.addClickHandler(new ClickHandler() {  
			public void onClick(ClickEvent event) {  

				GWT.log("searchByName click");  
				Criteria criteria = new Criteria();

				Object firstNameObj = firstNameTextItem.getValue();
				String firstName = "";
				if (firstNameObj!=null) {
					firstName = firstNameObj.toString();
					criteria.setAttribute("firstName", firstName);
				}

				Object lastNameObj = lastNameTextItem.getValue();
				String lastName = "";
				if (lastNameObj!=null) {
					lastName = lastNameObj.toString();
					criteria.setAttribute("lastName", lastName);

				}

				//				String searchText = firstName + " " + lastName;
				//				GWT.log("searchByName text: " + searchText);  
				VH.showStatus("#ffffd0", "Searching by name");

				GWT.log("searchByName 2 ");  
				//				Criteria critFirst = new Criteria("firstName", firstName);
				//				
				//				Criteria critLast = new Criteria("lastName", lastName);

				//				searchByNameResultGrid.fetchData(critFirst);
				searchByNameResultGrid.invalidateCache();
				searchByNameResultGrid.fetchData(criteria);

				GWT.log("searchByName 3 ");  

			}  
		});  

		IButton resetByNameButton = new IButton("Reset");  
		resetByNameButton.addClickHandler(new ClickHandler() {  
			public void onClick(ClickEvent event) {  

				firstNameTextItem.setValue("");
				lastNameTextItem.setValue("");
				searchByNameResultGrid.clear();
				GWT.log("resetByNameButton 3 ");  

			}  
		});  

		Tab searchByNameTab = new Tab("By Name");  

		HLayout tabLayout = new HLayout();  
		tabLayout.setMembersMargin(25);  
		tabLayout.setWidth100();
		tabLayout.setHeight(150);

		VLayout formLayout = new VLayout();  
		formLayout.setMembersMargin(15);  
		formLayout.setWidth(150);
		formLayout.setHeight(150);
		formLayout.addMember(searchByNameForm);  

		HLayout buttonLayout = new HLayout();  
		buttonLayout.setMembersMargin(5);  
		buttonLayout.setWidth(120);
		buttonLayout.setHeight(40);
		buttonLayout.addMember(searchByNameButton);  
		buttonLayout.addMember(resetByNameButton);  

		formLayout.addMember(buttonLayout);  

		tabLayout.addMember(formLayout);

		searchByNameResultDataSource = DataSource.get("travellers");

		searchByNameResultGrid = new ListGrid();
		searchByNameResultGrid.setWidth(550);
		searchByNameResultGrid.setHeight(155);
		searchByNameResultGrid.setAlternateRecordStyles(true);  
		searchByNameResultGrid.setCanEdit(false);  
		searchByNameResultGrid.setDataSource(searchByNameResultDataSource);
		searchByNameResultGrid.setAutoFetchData(false);
		searchByNameResultGrid.setAutoSaveEdits(false);
		searchByNameResultGrid.setOverflow(Overflow.HIDDEN);

		ListGridField lastName = new ListGridField("lastName", "Last Name");
		lastName.setType(ListGridFieldType.TEXT);  
		lastName.setAlign(Alignment.LEFT);
		lastName.setWidth(150);

		ListGridField firstName = new ListGridField("firstName", "First Name");
		firstName.setType(ListGridFieldType.TEXT);  
		firstName.setAlign(Alignment.LEFT);
		firstName.setWidth(150);

		ListGridField email = new ListGridField("email", "Email");
		email.setType(ListGridFieldType.TEXT);  
		email.setAlign(Alignment.LEFT);
		email.setWidth(150);

		searchByNameResultGrid.setFields(lastName, firstName, email);

		searchByNameResultGrid.addRecordDoubleClickHandler(new RecordDoubleClickHandler() {

			@Override
			public void onRecordDoubleClick(RecordDoubleClickEvent event) {
				GWT.log("SearchView lg doubleclick");
				Record travRec = event.getRecord();
				String travId = travRec.getAttributeAsString("id");
				String firstName = travRec.getAttributeAsString("firstName");
				String lastName = travRec.getAttributeAsString("lastName");
				GWT.log("SearchView lg doubleclick on id=" + travId + " lastname=" + lastName);
				controller.openTraveller(travId, firstName + " " + lastName);				
			}
		});

		SectionStack sectionStack = new SectionStack();  
		sectionStack.setWidth100();  
		sectionStack.setHeight(150);

		SectionStackSection resultsSection = new SectionStackSection("Search Results");  
		resultsSection.setExpanded(true);  
		resultsSection.setCanCollapse(false);  
		resultsSection.addItem(searchByNameResultGrid);  
		sectionStack.addSection(resultsSection);  

		tabLayout.addMember(sectionStack);

		searchByNameTab.setPane(tabLayout);
		return searchByNameTab;
	}	

	private Tab drawSearchByFlightTab() {

		DynamicForm searchByFlightForm = new DynamicForm();  
		final TextItem carrierTextItem = new TextItem();  
		carrierTextItem.setTitle("Airline");  	
		carrierTextItem.setWidth(150);  		
		carrierTextItem.setWrapTitle(false);
		final TextItem flightNumTextItem = new TextItem();  
		flightNumTextItem.setTitle("Flight Number");  		
		flightNumTextItem.setWrapTitle(false);
		flightNumTextItem.setWidth(150);  		
		searchByFlightForm.setFields(carrierTextItem, flightNumTextItem);  


		//		Tab searchByFlightTab = new Tab("By Flight");  
		//		VLayout vLayout2 = new VLayout();  
		//		vLayout2.setMembersMargin(10);  
		//		vLayout2.setWidth(400);
		//		vLayout2.setHeight(200);
		//		vLayout2.addMember(searchByFlightForm);  
		//		vLayout2.addMember(searchByFlightButton);  
		//		searchByFlightTab.setPane(vLayout2);

		//		IButton searchByFlightButton = new IButton("Get #1");  
		//		searchByFlightButton.addClickHandler(new ClickHandler() {  
		//			public void onClick(ClickEvent event) {  
		//				controller.searchByFlight("a", "b");
		//			}  
		//		});  


		IButton searchByFlightButton = new IButton("Search");  
		searchByFlightButton.addClickHandler(new ClickHandler() {  
			public void onClick(ClickEvent event) {  

				String carrier = carrierTextItem.getValue().toString();
				String flight = flightNumTextItem.getValue().toString();
				String searchText = carrier + " " + flight;
				GWT.log("searchByFlight text: " + searchText, null);  
				VH.showStatus("#ffffd0", "Search by flight: " + searchText);

				GWT.log("searchByFlight 2 ", null);  
//				Criteria critCarrier = new Criteria("carrier", carrier);
				Criteria critFlight = new Criteria("flight", flight);

				searchByNameResultGrid.fetchData(critFlight);
				GWT.log("searchByFlight 3 ", null);  

			}  
		});  

		IButton resetByFlightButton = new IButton("Reset");  
		resetByFlightButton.addClickHandler(new ClickHandler() {  
			public void onClick(ClickEvent event) {  

				carrierTextItem.setValue("");
				flightNumTextItem.setValue("");
				searchByNameResultGrid.clear();
				GWT.log("resetByNameButton 3 ", null);  

			}  
		});  

		Tab searchByFlightTab = new Tab("Search By Flight");  

		HLayout tabLayout = new HLayout();  
		tabLayout.setMembersMargin(25);  
		tabLayout.setWidth100();
		tabLayout.setHeight(150);

		VLayout formLayout = new VLayout();  
		formLayout.setMembersMargin(15);  
		formLayout.setWidth(150);
		formLayout.setHeight(150);
		formLayout.addMember(searchByFlightForm);  

		HLayout buttonLayout = new HLayout();  
		buttonLayout.setMembersMargin(5);  
		buttonLayout.setWidth(120);
		buttonLayout.setHeight(40);
		buttonLayout.addMember(searchByFlightButton);  
		buttonLayout.addMember(resetByFlightButton);  

		formLayout.addMember(buttonLayout);  

		tabLayout.addMember(formLayout);

		searchByFlightResultDataSource = DataSource.get("travellers");

		searchByFlightResultGrid = new ListGrid();
		searchByFlightResultGrid.setWidth(550);
		searchByFlightResultGrid.setHeight(155);
		searchByFlightResultGrid.setAlternateRecordStyles(true);  
		searchByFlightResultGrid.setCanEdit(false);  
		searchByFlightResultGrid.setDataSource(searchByFlightResultDataSource);
		searchByFlightResultGrid.setAutoFetchData(false);
		searchByFlightResultGrid.setAutoSaveEdits(false);
		searchByFlightResultGrid.setOverflow(Overflow.HIDDEN);

		ListGridField lastName = new ListGridField("lastName", "Last Name");
		lastName.setType(ListGridFieldType.TEXT);  
		lastName.setAlign(Alignment.LEFT);
		lastName.setWidth(150);

		ListGridField firstName = new ListGridField("firstName", "First Name");
		firstName.setType(ListGridFieldType.TEXT);  
		firstName.setAlign(Alignment.LEFT);
		firstName.setWidth(150);

		ListGridField email = new ListGridField("email", "Email");
		email.setType(ListGridFieldType.TEXT);  
		email.setAlign(Alignment.LEFT);
		email.setWidth(150);

		searchByFlightResultGrid.setFields(lastName, firstName, email);

		SectionStack sectionStack = new SectionStack();  
		sectionStack.setWidth100();  
		sectionStack.setHeight(150);

		SectionStackSection resultsSection = new SectionStackSection("Search Results");  
		resultsSection.setExpanded(true);  
		resultsSection.setCanCollapse(false);  
		resultsSection.addItem(searchByFlightResultGrid);  
		sectionStack.addSection(resultsSection);  

		tabLayout.addMember(sectionStack);

		searchByFlightTab.setPane(tabLayout);
		return searchByFlightTab;
	}	

	public TravellersController getController() {
		return controller;
	}

	public void setController(TravellersController controller) {
		this.controller = controller;
	}
}
