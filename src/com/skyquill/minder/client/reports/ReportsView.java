package com.skyquill.minder.client.reports;

import com.google.gwt.user.client.History;
import com.skyquill.minder.client.config.ExplorerTreeNode;
import com.skyquill.minder.client.config.PanelFactory;
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

public class ReportsView extends VLayout {

    private TabSet mainTabSet;
    private ReportsSideNavTree sideNav;
	
	public ReportsView()  {

		setWidth100();
		setHeight100();
		setMembersMargin(0);
		setLayoutMargin(0);

		
        HLayout hLayout = new HLayout();
        hLayout.setWidth100();
        hLayout.setHeight100();

        VLayout sideNavLayout = new VLayout();
        sideNavLayout.setHeight100();
        sideNavLayout.setWidth(220);
        sideNavLayout.setShowResizeBar(false);

        sideNav = new ReportsSideNavTree();


        sideNav.addLeafClickHandler(new LeafClickHandler() {
			@Override
			public void onLeafClick(LeafClickEvent event) {
                TreeNode node = event.getLeaf();
                showPanel(node);
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
//        History.addHistoryListener(this);
	}

    private void showPanel(TreeNode node) {

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
                    String panelName = explorerTreeNode.getName();


                    String icon = explorerTreeNode.getIcon();
                    if (icon == null) {
                        icon = "silk/plugin.png";
                    }
//                    String imgHTML = Canvas.imgHTML(icon);
//                    tab.setTitle("<span>" + imgHTML + "&nbsp;" + sampleName + "</span>");
                    tab.setTitle("<span>" + panelName + "</span>");
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
                    showPanel(explorerTreeNode);
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
}
