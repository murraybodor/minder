package com.skyquill.minder.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.skyquill.minder.client.config.AdministrationView;
import com.skyquill.minder.client.reports.ReportsView;
import com.skyquill.minder.client.util.VH;
import com.smartgwt.client.core.KeyIdentifier;
import com.smartgwt.client.rpc.RPCManager;
import com.smartgwt.client.types.Side;
import com.smartgwt.client.types.TabBarControls;
import com.smartgwt.client.util.KeyCallback;
import com.smartgwt.client.util.Page;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Minder2 implements EntryPoint {

//	Label status = new Label();
	
	private TravellersController travellersController;
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		if (!GWT.isScript()) { KeyIdentifier debugKey = new KeyIdentifier(); debugKey.setCtrlKey(true); debugKey.setKeyName("D"); Page.registerKey(debugKey, new KeyCallback() { public void execute(String keyName) { SC.showConsole(); } }); }		

		GWT.UncaughtExceptionHandler exHandler = new GWT.UncaughtExceptionHandler() {

			public void onUncaughtException(Throwable throwable) {

				String text = "Uncaught exception: ";
				while (throwable != null) {
					StackTraceElement[] stackTraceElements = throwable.getStackTrace();
					text += new String(throwable.toString() + "\r\n");
					for (int i = 0; i < stackTraceElements.length; i++) {
						text += "    at " + stackTraceElements[i] + "\r\n";
					}
					throwable = throwable.getCause();
					if (throwable != null) {
						text += "\r\nCaused by: ";
					}
				}

				SC.say(text);

			}
		};
		
		GWT.setUncaughtExceptionHandler(exHandler);
		
		
//		RPCManager.setActionURL(GWT.getModuleBaseURL() + "sc/IDACall/?tenant=demo");
		RPCManager.setActionURL(GWT.getModuleBaseURL() + "sc/IDACall/");

		Cache.init();

		travellersController = new TravellersController();
		
		VLayout layout = new VLayout();  
		layout.setWidth100();
		layout.setHeight100();
		layout.setMembersMargin(5);
		layout.setLayoutMargin(3);
		
		Label banner = new Label();
		banner.setWidth(VH.TABSET1WIDTH);
		banner.setHeight(25);
		banner.setBorder("1px solid #808080");
		banner.setBackgroundColor("#C3D9FF");
		
		layout.addMember(banner);

		layout.addMember(drawTopTabset());

		layout.draw();  
	}

	private TabSet drawTopTabset() {

		TabSet topTabSet = new TabSet();  
		topTabSet.setTabBarPosition(Side.TOP);  
		topTabSet.setTabBarAlign(Side.LEFT);
		topTabSet.setWidth(VH.TABSET1WIDTH);
		topTabSet.setHeight(VH.TABSET1HEIGHT);


		
//		Tab homeTab = drawTravellersTab();
		topTabSet.addTab(travellersController.drawMainTab());  
//		topTabSet.addTab(homeTab);  

		Tab reportsTab = drawReportsTab();
		topTabSet.addTab(reportsTab);  

		Tab adminTab = drawAdminTab();
		topTabSet.addTab(adminTab);  

//		Tab securityTab = new Tab("Security");
//		topTabSet.addTab(securityTab);

//		status.setShowEdges(true);
//		status.setWidth(600);
//		status.setBackgroundColor("#ffffd0");
//		status.setVisibility(Visibility.HIDDEN);
//		status.setAlign(Alignment.CENTER);
//		status.setContents("Tab closed");
		
        topTabSet.setTabBarControls(TabBarControls.TAB_SCROLLER, TabBarControls.TAB_PICKER, VH.status);  		

		return topTabSet;
	}

//	private Tab drawTravellersTab() {
//
//		Tab travellersTab = new Tab("Travellers");  
//
//		TabSet travellersTabSet = new TabSet();  
//		travellersTabSet.setTabBarPosition(Side.TOP);  
//		travellersTabSet.setTabBarAlign(Side.LEFT);  
//		travellersTabSet.setWidth(VH.TRAVELLERS_TABSET_WIDTH);
//		travellersTabSet.setHeight(VH.TRAVELLERS_TABSET_HEIGHT);
//		travellersTabSet.addCloseClickHandler(new CloseClickHandler() {  
//			public void onCloseClick(TabCloseClickEvent event) {  
//				Tab tab = event.getTab();  
//				GWT.log("tab closed " + tab.getID(), null);  
//				VH.showStatus("#ffffd0", "Tab closed");
////				status.animateShow(AnimationEffect.WIPE);  
//			}
//		});  	
//
//		Tab searchTab = drawSearchTab(travellersTabSet);  
//		travellersTabSet.addTab(searchTab);  
//
//		travellersTab.setPane(travellersTabSet);
//		return travellersTab;
//	}

//	private Tab drawSearchTab(TabSet travellersTabSet) {
//
//		Tab searchTab = new Tab("Search");  
//
////		SearchView searchView = new SearchView(travellersTabSet);
//		SearchView searchView = new SearchView();
//		searchTab.setPane(searchView);
//		return searchTab;
//	}

	private Tab drawAdminTab() {
		Tab adminTab = new Tab("Administration");  

		adminTab.setPane(new AdministrationView());
		return adminTab;
	}

	private Tab drawReportsTab() {
		Tab reportsTab = new Tab("Reports");  

		reportsTab.setPane(new ReportsView());
		return reportsTab;
	}

}