package com.skyquill.minder.client.config;

import com.smartgwt.client.types.SortArrow;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;

public class AdminSideNavTree extends TreeGrid {
	private String idSuffix = "";

	private ExplorerTreeNode[] configData = getNodes();

	public AdminSideNavTree() {
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
		field.setTitle("<b>Administration Menu</b>");
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

	public ExplorerTreeNode[] getConfigData() {
		return configData;
	}

	private ExplorerTreeNode[] getNodes() {

		ExplorerTreeNode[] data = new ExplorerTreeNode[] {

		new ExplorerTreeNode("Travel Configuration", "config", "root", null, null, true, idSuffix),
		new ExplorerTreeNode("World Areas", "worldaras", "config", null, 	new WorldAreasView.Factory(), true,	idSuffix),
		new ExplorerTreeNode("Currencies", "currencies", "config", null, 	new CurrenciesView.Factory(), true,	idSuffix),
		new ExplorerTreeNode("Countries", "countries", "config", null, 		new CountriesView.Factory(), true,	idSuffix),
		new ExplorerTreeNode("States", "states", "config", null, 			new StatesView.Factory(), true,	idSuffix),
		new ExplorerTreeNode("Cities", "cities", "config", null, 			new CitiesView.Factory(), true,	idSuffix),
		new ExplorerTreeNode("Airports", "airports", "config", null, 		new AirportsView.Factory(), true,	idSuffix),
		new ExplorerTreeNode("Airlines", "airlines", "config", null, 		new AirlinesView.Factory(), true,	idSuffix),
		new ExplorerTreeNode("Hotels", "hotels", "config", null, 			new HotelsView.Factory(), true,	idSuffix),
		new ExplorerTreeNode("Supervisors", "Supervisors", "config", null, 	new SupervisorsView.Factory(), true,	idSuffix),
		new ExplorerTreeNode("Admins", "admins", "config", null, 			new AdminsView.Factory(), true,	idSuffix),

		new ExplorerTreeNode("System Types", "codes", "root", null,				null, true, idSuffix),
		new ExplorerTreeNode("Blood", "blood", "codes", null, 		new BloodTypeView.Factory(), true,	idSuffix),
		new ExplorerTreeNode("Insurance", "ins", "codes", null, 		new InsuranceTypeView.Factory(), true,	idSuffix),
		new ExplorerTreeNode("Medical Assessment", "med", "codes", null, 		new MedicalAssessmentTypeView.Factory(), true,	idSuffix),
		new ExplorerTreeNode("Other Documents", "oth", "codes", null, 		new OtherDocTypeView.Factory(), true,	idSuffix),
		new ExplorerTreeNode("Reserve System", "resv", "codes", null, 		new ReserveSystemTypeView.Factory(), true,	idSuffix),
		new ExplorerTreeNode("Orientation", "orient", "codes", null, 		new SecurityOrientationTypeView.Factory(), true,	idSuffix),
		new ExplorerTreeNode("SOS Card", "sos", "codes", null, 		new SOSCardTypeView.Factory(), true,	idSuffix),
		new ExplorerTreeNode("Vaccination", "vac", "codes", null, 		new VaccinationTypeView.Factory(), true,	idSuffix),
		new ExplorerTreeNode("Vehicle", "veh", "codes", null, 		new VehicleTypeView.Factory(), true,	idSuffix),
		new ExplorerTreeNode("Visa", "visa", "codes", null, 		new VisaTypeView.Factory(), true,	idSuffix),
		
		new ExplorerTreeNode("Application Security", "security", "root", null,			null, true, idSuffix),
		new ExplorerTreeNode("Users", "users", "security", null, 			null, true,	idSuffix),
		
		};
		return data;
	}
}
