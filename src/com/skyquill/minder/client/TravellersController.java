package com.skyquill.minder.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.skyquill.minder.client.util.VH;
import com.smartgwt.client.types.Side;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.widgets.tab.events.CloseClickHandler;
import com.smartgwt.client.widgets.tab.events.TabCloseClickEvent;

public class TravellersController {

	private TabSet travellersTabSet;  
	private int newTravellerCount = 1;
	private List<TravellerView> travellerViews = new ArrayList<TravellerView>();
//	private Map<Long, TravellerView> travellerViewMap = new HashMap<Long, TravellerView>();
	
	public TravellersController() {
	}

	public Tab drawMainTab() {

		Tab travellersTab = new Tab("Travellers");  

		travellersTabSet = new TabSet();  
		travellersTabSet.setTabBarPosition(Side.TOP);  
		travellersTabSet.setTabBarAlign(Side.LEFT);  
		travellersTabSet.setWidth100();
//		travellersTabSet.setWidth(VH.TRAVELLERS_TABSET_WIDTH);
		travellersTabSet.setHeight(VH.TRAVELLERS_TABSET_HEIGHT);
		travellersTabSet.addCloseClickHandler(new CloseClickHandler() {  
			public void onCloseClick(TabCloseClickEvent event) {  
				Tab tab = event.getTab();  
				GWT.log("tab closed " + tab.getID(), null);  
				VH.showStatus("#ffffd0", "Tab closed");
//				status.animateShow(AnimationEffect.WIPE);  
			}
		});  	

		Tab searchTab = drawSearchTab(travellersTabSet);  
		travellersTabSet.addTab(searchTab);  

		travellersTab.setPane(travellersTabSet);
		
		return travellersTab;
	}

	public Tab drawSearchTab(TabSet travellersTabSet) {

		Tab searchTab = new Tab("Search");  

		SearchView searchView = new SearchView();
		searchView.setController(this);
		searchTab.setPane(searchView);
		return searchTab;
	}

//	public void search(String lastName, String firstName, DataSource results) {

//		String searchText = firstName + " " + lastName;
//		GWT.log("searchText: " + searchText, null);  
//		VH.showStatus("#ffffd0", "Search by name: " + searchText);
//
//		Criteria crit1 = new Criteria("firstName", firstName);
//		
//		resultsGrid.fetchData(crit1);
//
////		results.
		
//	}
	
	public void searchByFlight(String lastName, String firstName) {
		
		String searchText = firstName + " " + lastName;
		GWT.log("searchText: " + searchText, null);
		
		VH.showStatus("#ffffd0", "Search By Flight: " + searchText);
		
		
	}
	
	public void openTraveller(String travellerId, String tabTitle) {

		boolean isOpen = false;
		Tab[] openTabs = travellersTabSet.getTabs();
		
		for (int i = 0; i < openTabs.length; i++) {
			String tabId = openTabs[i].getID();
			if (tabId.equals(tabTitle)) {
				isOpen = true;
				travellersTabSet.selectTab(openTabs[i]);
			}
		}
		if (!isOpen) {
			Tab newTab = drawTravellerTab(travellerId, tabTitle);
			travellersTabSet.addTab(newTab);
			travellersTabSet.selectTab(newTab);
		}
		
		
	}
	
	public void createNewTraveller() {
		String tabTitle = "New traveller " + newTravellerCount;
		newTravellerCount++;
		Tab newTab = drawTravellerTab(null, tabTitle);
		travellersTabSet.addTab(newTab);
		travellersTabSet.selectTab(newTab);
	}

	private Tab drawTravellerTab(String travellerId, String id) {

		Tab travellerTab = new Tab(id);
		travellerTab.setID(id);
		travellerTab.setCanClose(true);

		TravellerView travellerView = new TravellerView(travellerId);  

		travellerView.loadData();
		
		travellerViews.add(travellerView);
		
		travellerTab.setPane(travellerView);
		return travellerTab;
	}
	
	
}
