package com.skyquill.minder.client.config;

import com.google.gwt.user.client.History;
import com.google.gwt.user.client.HistoryListener;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.client.widgets.tree.events.LeafClickEvent;
import com.smartgwt.client.widgets.tree.events.LeafClickHandler;

public class ConfigView extends VLayout implements HistoryListener {

    private TabSet mainTabSet;
    private SideNavTree sideNav;
	
	public ConfigView()  {

		setWidth100();
		setHeight100();
		setMembersMargin(0);
		setLayoutMargin(0);

		
        HLayout hLayout = new HLayout();
        hLayout.setWidth100();
        hLayout.setHeight100();

        VLayout sideNavLayout = new VLayout();
        sideNavLayout.setHeight100();
        sideNavLayout.setWidth(290);
        sideNavLayout.setShowResizeBar(true);

        sideNav = new SideNavTree();


        sideNav.addLeafClickHandler(new LeafClickHandler() {
			@Override
			public void onLeafClick(LeafClickEvent event) {
                TreeNode node = event.getLeaf();
                showSample(node);
			}
        });

        sideNavLayout.addMember(sideNav);
        hLayout.addMember(sideNavLayout);

        mainTabSet = new TabSet();
        mainTabSet.setWidth100();
        mainTabSet.setHeight100();
		

        Canvas canvas = new Canvas();
        canvas.setBackgroundImage("[SKIN]/shared/background.gif");
        canvas.setWidth100();
        canvas.setHeight100();
        canvas.addChild(mainTabSet);

        hLayout.addMember(canvas);
        addMember(hLayout);
        
        // Add history listener
        History.addHistoryListener(this);
        
		
//		final TabSet adminTabSet = new TabSet();  
//		adminTabSet.setTabBarPosition(Side.TOP);  
//		adminTabSet.setTabBarAlign(Side.LEFT);  
//		adminTabSet.setWidth(VH.TRAVELLERS_TABSET_WIDTH);
//		adminTabSet.setHeight(VH.TRAVELLERS_TABSET_HEIGHT);
//
//		adminTabSet.addTab(drawWorldAreasTab());  
//		adminTabSet.addTab(drawCurrenciesTab());  
//		adminTabSet.addTab(drawCountriesTab());  
//		adminTabSet.addTab(drawAirlinesTab());
//		adminTabSet.addTab(drawStatesTab());  
//		adminTabSet.addTab(drawCitiesTab());  
//		adminTabSet.addTab(drawAirportsTab());
//		adminTabSet.addTab(drawHotelsTab());
//		adminTabSet.addTab(drawSupervisorsTab());
//		adminTabSet.addTab(drawAdminsTab());  
//
//		Tab typesTab = new Tab("Other Types");
//		adminTabSet.addTab(typesTab);
//
//		addMember(adminTabSet);
		
		
	}

    private void showSample(TreeNode node) {

            ExplorerTreeNode explorerTreeNode = (ExplorerTreeNode) node;
            PanelFactory factory = explorerTreeNode.getFactory();
            if (factory != null) {
                String panelID = factory.getID();
                Tab tab = null;
                if (panelID != null) {
                    String tabID = panelID + "_tab";
                    tab = mainTabSet.getTab(tabID);
                }
                if (tab == null) {
                    Canvas panel = factory.create();
                    tab = new Tab();
                    tab.setID(factory.getID() + "_tab");
                    String sampleName = explorerTreeNode.getName();


                    String icon = explorerTreeNode.getIcon();
                    if (icon == null) {
                        icon = "silk/plugin.png";
                    }
                    String imgHTML = Canvas.imgHTML(icon);
                    tab.setTitle("<span>" + imgHTML + "&nbsp;" + sampleName + "</span>");
                    tab.setPane(panel);
                    tab.setCanClose(true);
                    mainTabSet.addTab(tab);
                    mainTabSet.selectTab(tab);
                    if (!SC.isIE()) {
                        if (mainTabSet.getNumTabs() == 10) {
                            mainTabSet.removeTabs(new int[]{1});
                        }
                    }
                    History.newItem(explorerTreeNode.getNodeID(), false);
                } else {
                    mainTabSet.selectTab(tab);
                }
            }
    }
	
    public void onHistoryChanged(String historyToken) {
        if (historyToken == null || historyToken.equals("")) {
            mainTabSet.selectTab(0);
        } else {
            ExplorerTreeNode[] showcaseData = sideNav.getShowcaseData();
            for (ExplorerTreeNode explorerTreeNode : showcaseData) {
                if (explorerTreeNode.getNodeID().equals(historyToken)) {
                    showSample(explorerTreeNode);
                    sideNav.selectRecord(explorerTreeNode);
                    Tree tree = sideNav.getData();
                    TreeNode categoryNode = tree.getParent(explorerTreeNode);
                    
                    while (categoryNode != null && !"/".equals(tree.getName(categoryNode))) {
                        tree.openFolder(categoryNode);
                        categoryNode = tree.getParent(categoryNode);
                    }
                }
            }
        }
    }
    
//	private Tab drawAirlinesTab() {
//		Tab airlinesTab = new Tab("Airlines");
//		airlinesTab.setPane(new AirlinesView());
//		return airlinesTab;
//	}
//
//	private Tab drawWorldAreasTab() {
//		Tab worldAreasTab = new Tab("World Areas");
//		worldAreasTab.setPane(new WorldAreasView());
//		return worldAreasTab;
//	}
//
//	private Tab drawCurrenciesTab() {
//		Tab currenciesTab = new Tab("Currencies");
//		currenciesTab.setPane(new CurrenciesView());
//		return currenciesTab;
//	}
//
//	private Tab drawCountriesTab() {
//		Tab countriesTab = new Tab("Countries");
//		countriesTab.setPane(new CountriesView());
//		return countriesTab;
//	}
//
//	private Tab drawStatesTab() {
//		Tab statesTab = new Tab("States/Provinces");
//		statesTab.setPane(new StatesView());
//		return statesTab;
//	}
//
//	private Tab drawCitiesTab() {
//		Tab citiesTab = new Tab("Cities");
//		citiesTab.setPane(new CitiesView());
//		return citiesTab;
//	}
//	private Tab drawAirportsTab() {
//		Tab airportsTab = new Tab("Airports");
//		airportsTab.setPane(new AirportsView());
//		return airportsTab;
//	}
//	private Tab drawHotelsTab() {
//		Tab hotelsTab = new Tab("Hotels");
//		hotelsTab.setPane(new HotelsView());
//		return hotelsTab;
//	}
//
//	private Tab drawSupervisorsTab() {
//		Tab supvTab = new Tab("Supervisors");
//		supvTab.setPane(new SupervisorsView());
//		return supvTab;
//	}
//	private Tab drawAdminsTab() {
//		Tab adminsTab = new Tab("Admins");
//		adminsTab.setPane(new AdminsView());
//		return adminsTab;
//	}
	
}
