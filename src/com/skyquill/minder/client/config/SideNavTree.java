package com.skyquill.minder.client.config;

import com.smartgwt.client.types.SortArrow;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;

public class SideNavTree extends TreeGrid {
	private String idSuffix = "";

	private ExplorerTreeNode[] showcaseData = getNodes();

	public SideNavTree() {
		setWidth100();
		setHeight100();
		setCustomIconProperty("icon");
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
		field.setTitle("<b>Configuration Menu</b>");
		setFields(field);

		Tree tree = new Tree();
		tree.setModelType(TreeModelType.PARENT);
		tree.setNameProperty("name");
		tree.setOpenProperty("isOpen");
		tree.setIdField("nodeID");
		tree.setParentIdField("parentNodeID");
		tree.setRootValue("root" + idSuffix);

		tree.setData(showcaseData);

		setData(tree);
	}

	public ExplorerTreeNode[] getShowcaseData() {
		return showcaseData;
	}

	private ExplorerTreeNode[] getNodes() {

		ExplorerTreeNode[] data = new ExplorerTreeNode[] {

		new ExplorerTreeNode("Administration Menu", "config", "root", "silk/book_open.png", null, true, idSuffix),
		new ExplorerTreeNode("World Areas", "worldaras", "config", "silk/book_open.png", 	new WorldAreasView.Factory(), true,	idSuffix),
		new ExplorerTreeNode("Currencies", "currencies", "config", "silk/book_open.png", 	new CurrenciesView.Factory(), true,	idSuffix),
		new ExplorerTreeNode("Countries", "countries", "config", "silk/book_open.png", 		new CountriesView.Factory(), true,	idSuffix),
		new ExplorerTreeNode("States", "states", "config", "silk/book_open.png", 			new StatesView.Factory(), true,	idSuffix),
		new ExplorerTreeNode("Cities", "cities", "config", "silk/book_open.png", 			new CitiesView.Factory(), true,	idSuffix),
		new ExplorerTreeNode("Airports", "airports", "config", "silk/book_open.png", 		new AirportsView.Factory(), true,	idSuffix),
		new ExplorerTreeNode("Airlines", "airlines", "config", "silk/book_open.png", 		new AirlinesView.Factory(), true,	idSuffix),
		new ExplorerTreeNode("Hotels", "hotels", "config", "silk/book_open.png", 			new HotelsView.Factory(), true,	idSuffix),
		new ExplorerTreeNode("Supervisors", "Supervisors", "config", "silk/book_open.png", 	new SupervisorsView.Factory(), true,	idSuffix),
		new ExplorerTreeNode("Admins", "admins", "config", "silk/book_open.png", 			new AdminsView.Factory(), true,	idSuffix),

		new ExplorerTreeNode("Security", "security", "root", "silk/book_open.png",			null, true, idSuffix),
		new ExplorerTreeNode("Users", "users", "security", "silk/book_open.png", 			null, true,	idSuffix),
		
		};
		return data;
	}
}
