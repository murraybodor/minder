package com.skyquill.minder.client.reports;

import com.skyquill.minder.client.config.ExplorerTreeNode;
import com.smartgwt.client.types.SortArrow;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;

public class ReportsSideNavTree extends TreeGrid {
	private String idSuffix = "";

	private ExplorerTreeNode[] configData = getNodes();

	public ReportsSideNavTree() {
		setWidth100();
		setHeight100();
//		setCustomIconProperty("icon");
		setAnimateFolderTime(100);
		setAnimateFolders(true);
		setAnimateFolderSpeed(1000);
		setShowSortArrow(SortArrow.CORNER);
		setShowAllRecords(true);
		setLoadDataOnDemand(false);
		setCanSort(false);
		setLeaveScrollbarGap(false);

		TreeGridField field = new TreeGridField();
		field.setCanFilter(true);
		field.setName("name");
		field.setTitle("<b>Reports Menu</b>");
		setFields(field);

		Tree tree = new Tree();
		tree.setModelType(TreeModelType.PARENT);
		tree.setNameProperty("name");
		tree.setOpenProperty("isOpen");
		tree.setIdField("nodeID");
		tree.setParentIdField("parentNodeID");
		tree.setRootValue("root" + idSuffix);

		tree.setData(configData);

		setData(tree);
	}

	public ExplorerTreeNode[] getShowcaseData() {
		return configData;
	}

	private ExplorerTreeNode[] getNodes() {

		ExplorerTreeNode[] data = new ExplorerTreeNode[] {

		new ExplorerTreeNode("Reports", "reports", "root", null, null, true, idSuffix),
		new ExplorerTreeNode("Traveller", "trav", "reports", null, 	null, true,	idSuffix),
		new ExplorerTreeNode("Who's Travelling", "whos", "trav", null, 	new WhosTravellingReportView.Factory(), true,	idSuffix),
		new ExplorerTreeNode("Departures Manifest", "depman", "trav", null, 	new DeparturesManifestReportView.Factory(), true,	idSuffix),
		new ExplorerTreeNode("Arrivals Manifest", "arrman", "trav", null, 	new ArrivalsManifestReportView.Factory(), true,	idSuffix),
		new ExplorerTreeNode("Custom", "custom", "trav", null, 	new CustomReportView.Factory(), true,	idSuffix),
		new ExplorerTreeNode("Administration", "admin", "reports", null, 	null, true,	idSuffix),
		new ExplorerTreeNode("Admin Report 1", "admin1", "admin", null, 	new Admin1ReportView.Factory(), true,	idSuffix),
		
		
		};
		return data;
	}
}
