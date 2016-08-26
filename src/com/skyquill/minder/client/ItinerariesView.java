package com.skyquill.minder.client;

import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.skyquill.minder.client.util.VH;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.types.TimeFormatter;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.events.ItemChangedEvent;
import com.smartgwt.client.widgets.form.events.ItemChangedHandler;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.TimeItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;

public class ItinerariesView extends HLayout {

	private TravellerModel model;
	private DataSource itineraries;
	private DataSource reservations;
	private DynamicForm itinForm;
	private DynamicForm flightResForm;
	private DynamicForm hotelResForm;
	private DynamicForm vehicleResForm;
	private DynamicForm otherResForm;
	private SectionStack formStack;
	private Tree itinTree;  
	private TreeGrid itinTreeGrid;  
	private TreeNode rootNode;
	private static Long newItinId = new Long(99999999);
	private static Long newResvId = new Long(999999999);

	private ItemChangedHandler formItemChangedHandler = new ItemChangedHandler() {
		@Override
		public void onItemChanged(ItemChangedEvent event) {
			ListGridRecord rec = itinTreeGrid.getSelectedRecord();
			String field = event.getItem().getFieldName();
			Object newVal = event.getNewValue();
			rec.setAttribute(field, newVal);
			rec.setAttribute("dirty", true); // mark record as dirty
		}
	};
	
	public ItinerariesView(TravellerModel aModel) {

		GWT.log("ItinerariesView init starting", null);

		setWidth100();
		setHeight100();
		setMembersMargin(10);
		setLayoutMargin(5);

		this.model = aModel;

		
		drawItinerariesTree();

		ImgButton addItineraryButton = new ImgButton();  
		addItineraryButton.setSrc("[SKIN]actions/add.png");  
		addItineraryButton.setSize(16);  
		addItineraryButton.setTooltip("Add a new itinerary");
		addItineraryButton.setShowFocused(false);  
		addItineraryButton.setShowRollOver(false);  
		addItineraryButton.setShowDown(false);  
		addItineraryButton.addClickHandler(new ClickHandler() {  
			public void onClick(ClickEvent event) {  
				addItinerary();
			}  
		});  
		
		SectionStackSection treeSection = new SectionStackSection();  
		treeSection.setTitle("Itineraries");  
		treeSection.setItems(itinTreeGrid);  
		treeSection.setExpanded(true);
		treeSection.setCanCollapse(false);
		treeSection.setControls(addItineraryButton);  
		
		SectionStack treeGridStack = new SectionStack();
		treeGridStack.setSections(treeSection);  
		treeGridStack.setVisibilityMode(VisibilityMode.MUTEX);  
		treeGridStack.setAnimateSections(false);  
		treeGridStack.setHeight(370);  
		treeGridStack.setWidth(260);  
		treeGridStack.setOverflow(Overflow.HIDDEN);
		
		addMember(treeGridStack);
		
		drawItinForm();
		drawFlightResForm();
		drawHotelResForm();
		drawVehicleResForm();
		drawOtherResForm();

		VStack buttonStack = new VStack();
		buttonStack.setWidth(32);
		buttonStack.setHeight(200);
		buttonStack.setMembersMargin(5);
		buttonStack.setLayoutMargin(5);
		buttonStack.setLayoutAlign(Alignment.CENTER);
		
		ImgButton addFlightButton = new ImgButton();  
		addFlightButton.setSrc("[SKIN]actions/add.png");  
		addFlightButton.setSize(16);  
		addFlightButton.setTooltip("Add a new flight");
		addFlightButton.setShowFocused(false);  
		addFlightButton.setShowRollOver(false);  
		addFlightButton.setShowDown(false);  
		addFlightButton.addClickHandler(new ClickHandler() {  
			public void onClick(ClickEvent event) {  
				addResv("FLIGHT");
			}  
		});  

		ImgButton addHotelButton = new ImgButton();  
		addHotelButton.setSrc("[SKIN]actions/add.png");  
		addHotelButton.setSize(16);  
		addHotelButton.setTooltip("Add a new hotel");
		addHotelButton.setShowFocused(false);  
		addHotelButton.setShowRollOver(false);  
		addHotelButton.setShowDown(false);  
		addHotelButton.addClickHandler(new ClickHandler() {  
			public void onClick(ClickEvent event) {  
				addResv("HOTEL");
			}  
		});  

		ImgButton addVehicleButton = new ImgButton();  
		addVehicleButton.setSrc("[SKIN]actions/add.png");  
		addVehicleButton.setSize(16);  
		addVehicleButton.setTooltip("Add a new vehicle");
		addVehicleButton.setShowFocused(false);  
		addVehicleButton.setShowRollOver(false);  
		addVehicleButton.setShowDown(false);  
		addVehicleButton.addClickHandler(new ClickHandler() {  
			public void onClick(ClickEvent event) {  
				addResv("VEHICLE");
			}  
		});  

		ImgButton addOtherButton = new ImgButton();  
		addOtherButton.setSrc("[SKIN]actions/add.png");  
		addOtherButton.setSize(16);  
		addOtherButton.setTooltip("Add a new other");
		addOtherButton.setShowFocused(false);  
		addOtherButton.setShowRollOver(false);  
		addOtherButton.setShowDown(false);  
		addOtherButton.addClickHandler(new ClickHandler() {  
			public void onClick(ClickEvent event) {  
				addResv("OTHER");
			}  
		});  
		
		buttonStack.addMember(addFlightButton);
		buttonStack.addMember(addHotelButton);
		buttonStack.addMember(addVehicleButton);
		buttonStack.addMember(addOtherButton);
		
		addMember(buttonStack);
		
		SectionStackSection itinSection = new SectionStackSection();  
		itinSection.setID("ITIN");  
		itinSection.setTitle("Itinerary");  
		itinSection.setItems(itinForm);  
		itinSection.setExpanded(true);
		itinSection.setCanCollapse(false);
		itinSection.setHidden(true);
//		itinSection.setControls(addFlightButton);  

		SectionStackSection flightSection = new SectionStackSection();  
		flightSection.setID("FLIGHT");  
		flightSection.setTitle("Flight");  
		flightSection.setItems(flightResForm);  
		flightSection.setExpanded(true);
		flightSection.setCanCollapse(false);
		flightSection.setHidden(true);

		SectionStackSection hotelSection = new SectionStackSection();  
		hotelSection.setID("HOTEL");  
		hotelSection.setTitle("Hotel");  
		hotelSection.setItems(hotelResForm);  
		hotelSection.setExpanded(true);
		hotelSection.setCanCollapse(false);
		hotelSection.setHidden(true);

		SectionStackSection vehicleSection = new SectionStackSection();  
		vehicleSection.setID("VEHICLE");  
		vehicleSection.setTitle("Vehicle");  
		vehicleSection.setItems(vehicleResForm);  
		vehicleSection.setExpanded(true);
		vehicleSection.setCanCollapse(false);
		vehicleSection.setHidden(true);

		SectionStackSection otherSection = new SectionStackSection();  
		otherSection.setID("OTHER");  
		otherSection.setTitle("Other");  
		otherSection.setItems(otherResForm);  
		otherSection.setExpanded(true);
		otherSection.setCanCollapse(false);
		otherSection.setHidden(true);

		formStack = new SectionStack();
		formStack.setSections(itinSection, flightSection, hotelSection, vehicleSection, otherSection);  
		formStack.setVisibilityMode(VisibilityMode.MUTEX);  
		formStack.setAnimateSections(false);  
		formStack.setHeight(370);  
		formStack.setOverflow(Overflow.HIDDEN);

		addMember(formStack);

		GWT.log("ItinerariesView init done", null);
	}

	private void hideAllForms() {
		formStack.hideSection("ITIN");
		itinForm.clearValues();
		formStack.hideSection("FLIGHT");
		flightResForm.clearValues();
		formStack.hideSection("HOTEL");
		hotelResForm.clearValues();
		formStack.hideSection("VEHICLE");
		vehicleResForm.clearValues();
		formStack.hideSection("OTHER");
		otherResForm.clearValues();
	}

	private void drawItinForm() {
		itinForm = new DynamicForm();
		itinForm.setPadding(10);
		itinForm.setWrapItemTitles(false);
		itinForm.setNumCols(4);

		DateItem departDate = new DateItem("departDate");
		departDate.setTitle("Depart Date");
		
		DateItem returnDate = new DateItem("returnDate");
		returnDate.setTitle("Return Date");

		TextItem pnrLocator = new TextItem("pnrLocator");
		pnrLocator.setTitle("PNR Locator");
		pnrLocator.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {
				Object newValObj = event.getValue();
				String newPnr = newValObj.toString();
				GWT.log("ItinerariesView pnrLocator.onChange newpnr=" + newPnr, null);
				
			}
			
		});

		TextItem contact = new TextItem("contact");
		contact.setTitle("Contact");

		TextItem authorizationId = new TextItem("authorizationId");
		authorizationId.setTitle("Authorization ID");
		
		itinForm.setFields(departDate, returnDate, pnrLocator, contact, authorizationId, VH.drawCostField(), VH.drawCurrencySelect(), VH.drawCostCenterField(), VH.drawPurposeField(), VH.drawCommentsField(), VH.drawAuditDateTimeField(), VH.drawAuditUserIdField());
		itinForm.addItemChangedHandler(formItemChangedHandler);
	}

	private void drawFlightResForm() {
		flightResForm = new DynamicForm();
		flightResForm.setPadding(10);
		flightResForm.setWrapItemTitles(false);
		flightResForm.setNumCols(4);

		DateItem departDate = new DateTimeItem("resvBeginDate");
		departDate.setTitle("Departure Date");
		departDate.setUseTextField(false);
		
		TimeItem departTime = new TimeItem("resvBeginTime");
		departTime.setDisplayFormat(TimeFormatter.TOSHORTTIME);
		departTime.setWidth(70);
		departTime.setHint("HH:MM");
		departTime.setTitle("Departure Time");
		
		DateItem arrivalDate = new DateItem("resvEndDate");
		arrivalDate.setTitle("Arrival Date");

		TimeItem arrivalTime = new TimeItem("resvEndTime");
		arrivalTime.setDisplayFormat(TimeFormatter.TOSHORTTIME);
		arrivalTime.setWidth(70);
		arrivalTime.setHint("HH:MM");
		arrivalTime.setTitle("Arrival Time");
		
		TextItem flightNumber = new TextItem("flightNumber");
		flightNumber.setTitle("Flight Number");

		flightResForm.setFields(departDate, departTime, arrivalDate, arrivalTime, VH.drawAirlineSelect(), flightNumber, VH.drawOriginAirportSelect(), VH.drawDestAirportSelect(), VH.drawCostField(), VH.drawCurrencySelect(), VH.drawCostCenterField(), VH.drawPurposeField(), VH.drawCommentsField(), VH.drawFollowUpField(), VH.drawAuditDateTimeField(), VH.drawAuditUserIdField());
		flightResForm.addItemChangedHandler(formItemChangedHandler);
	}

	private void drawHotelResForm() {
		hotelResForm = new DynamicForm();
		hotelResForm.setPadding(10);
		hotelResForm.setWrapItemTitles(false);
		hotelResForm.setNumCols(4);

		DateItem checkinDate = new DateItem("resvBeginDate");
		checkinDate.setTitle("Check In Date");

		DateItem checkoutDate = new DateItem("resvEndDate");
		checkoutDate.setTitle("Check Out Date");

		TextItem otherHotel = new TextItem("otherHotel");
		otherHotel.setTitle("Other Hotel");

		TextItem roomType = new TextItem("roomType");
		roomType.setTitle("Room Type");
		
		hotelResForm.setFields(checkinDate, checkoutDate, VH.drawCitySelect(), VH.drawHotelSelect(), otherHotel, roomType, VH.drawCostField(), VH.drawCurrencySelect(), VH.drawCostCenterField(), VH.drawPurposeField(), VH.drawCommentsField(), VH.drawFollowUpField(), VH.drawAuditDateTimeField(), VH.drawAuditUserIdField());
		hotelResForm.addItemChangedHandler(formItemChangedHandler);
	}

	private void drawVehicleResForm() {
		vehicleResForm = new DynamicForm();
		vehicleResForm.setPadding(10);
		vehicleResForm.setWrapItemTitles(false);
		vehicleResForm.setNumCols(4);
		
		DateItem pickupDate = new DateItem("resvBeginDate");
		pickupDate.setTitle("Start Date");

		DateItem dropoffDate = new DateItem("resvEndDate");
		dropoffDate.setTitle("End Date");

		TextItem rentalAgency = new TextItem("rentalAgency");
		rentalAgency.setTitle("Service Company");

		TextItem vehicleType = new TextItem("vehicleType");
		vehicleType.setTitle("Vehicle Type");

		TextItem conf = new TextItem("conf");
		conf.setTitle("Confirmation #");
		
		vehicleResForm.setFields(pickupDate, dropoffDate, VH.drawCitySelect(), rentalAgency, vehicleType, conf, VH.drawCostField(), VH.drawCurrencySelect(), VH.drawCostCenterField(), VH.drawPurposeField(), VH.drawCommentsField(), VH.drawFollowUpField(), VH.drawAuditDateTimeField(), VH.drawAuditUserIdField());
		vehicleResForm.addItemChangedHandler(formItemChangedHandler);
	}

	private void drawOtherResForm() {
		otherResForm = new DynamicForm();
		otherResForm.setPadding(10);
		otherResForm.setWrapItemTitles(false);
		otherResForm.setNumCols(4);

		DateItem beginDate = new DateItem("resvBeginDate");
		beginDate.setTitle("Date");
		
		otherResForm.setFields(beginDate, VH.drawCitySelect(), VH.drawCostField(), VH.drawCurrencySelect(), VH.drawCostCenterField(), VH.drawPurposeField(), VH.drawCommentsField(), VH.drawFollowUpField(), VH.drawAuditDateTimeField(), VH.drawAuditUserIdField());
		otherResForm.addItemChangedHandler(formItemChangedHandler);
	}

	public void loadData() {

		if (model.getTravellerId()!=null) {

			GWT.log("ItinerariesView loadData fetching traveller " + model.getTravellerId().toString(), null);

			DSCallback itinCallback = new DSCallback() {

				@Override
				public void execute(DSResponse response, Object rawData,
						DSRequest request) {

					GWT.log("ItinerariesView.loadData itinCallback starting", null);

					Record[] itinRecs = response.getData();

					for (int i = 0; i < itinRecs.length; i++) {
						
						ItineraryTreeNode itinNode = new ItineraryTreeNode(itinRecs[i], "ITIN");
						itinTree.add(itinNode, rootNode);

						Record[] resvs = itinRecs[i].getAttributeAsRecordArray("reservations");

						for (int j = 0; j < resvs.length; j++) {
							Record record = resvs[j];
							String resType = record.getAttribute("resType");
							ItineraryTreeNode resvNode = new ItineraryTreeNode(record, resType);
							itinTree.add(resvNode, itinNode);
						}
					}

					itinTreeGrid.setData(itinTree);  

					GWT.log("ItinerariesView.loadData itinCallback done", null);
				}

			};

			Criteria travCrit = new Criteria("travellerId", model.getTravellerId().toString());
			itineraries.fetchData(travCrit, itinCallback);

			hideAllForms();
		}
	}

	public void saveAllEdits() {
		GWT.log("ItinerariesView.saveAllEdits starting", null);

		TreeNode[] nodes = itinTreeGrid.getTree().getAllNodes();
		
		for (int i = 0; i < nodes.length; i++) {
			GWT.log("ItinerariesView.saveAllEdits node " + i, null);
			final TreeNode treeNodeRec = nodes[i];
			boolean dirty = treeNodeRec.getAttributeAsBoolean("dirty");
			boolean added = treeNodeRec.getAttributeAsBoolean("added");
			
			GWT.log("ItinerariesView.saveAllEdits checking node " + i, null);
			
			if (dirty) {
				String resType=treeNodeRec.getAttribute("resType");
				GWT.log("ItinerariesView.saveAllEdits found dirty node=" + i + " type=" + resType, null);
				
				if (resType.equals("ITIN")) {
					GWT.log("ItinerariesView.saveAllEdits saving an itinerary", null);
					Record itinRec = new Record();
					String[] attrs = treeNodeRec.getAttributes();
					GWT.log("ItinerariesView.saveAllEdits saving an itinerary a", null);
					
					for (int j = 0; j < attrs.length; j++) {
						String attr = attrs[j];
						GWT.log("ItinerariesView.saveAllEdits itinerary rec attr=" + attr, null);
						if (attr.indexOf("DateTime")>=0 || (attr.indexOf("parentId")>=0) || attr.indexOf("title")>=0 || attr.indexOf("isFolder")>=0 || attr.indexOf("itineraryId")>=0 || attr.indexOf("resType")>=0) {
						} else if (attr.indexOf("reservations")>=0) {
						} else if (attr.indexOf("Date")>=0) {
							Date value = treeNodeRec.getAttributeAsDate(attr);
							if (value!=null) {
								itinRec.setAttribute(attr, value);
							}
						} else {
							String value = treeNodeRec.getAttribute(attr);
							itinRec.setAttribute(attr, value);
						}
					}
					String recItinId = treeNodeRec.getAttribute("itineraryId");
					GWT.log("ItinerariesView.saveAllEdits saving an itinerary id=" + recItinId, null);
					
					if (added) {
						Long id = null;
						itinRec.setAttribute("id", id);
					} else {
						itinRec.setAttribute("id", recItinId);
					}
					itinRec.setAttribute("auditDateTime", new Date());
					itinRec.setAttribute("auditUserId", VH.getUserId());
					
					DSCallback itinUpdateCallback = new DSCallback() {

						@Override
						public void execute(DSResponse response,
								Object rawData, DSRequest request) {
							GWT.log("ItinerariesView.saveAllEdits saving an itinerary callback", null);
							Record[] updatedRecs = response.getData();
							
							for (int j = 0; j < updatedRecs.length; j++) {
								Record updatedRec = updatedRecs[j];
//								String[] updatedRecAttrs = updatedRec.getAttributes();
//								for (int k = 0; k < updatedRecAttrs.length; k++) {
//									String attr = updatedRecAttrs[k];
//								}
								
								treeNodeRec.setAttribute("itineraryId", updatedRec.getAttribute("id"));
								treeNodeRec.setAttribute("auditDateTime", updatedRec.getAttribute("auditDateTime"));
								treeNodeRec.setAttribute("auditUserId", updatedRec.getAttribute("auditUserId"));
								treeNodeRec.setAttribute("dirty", false);
								// version?
							}
						}
					};
					
					if (added) {
						GWT.log("ItinerariesView.saveAllEdits calling add on ds", null);
						itineraries.addData(itinRec, itinUpdateCallback);
					} else {
						GWT.log("ItinerariesView.saveAllEdits calling update on ds", null);
						itineraries.updateData(itinRec, itinUpdateCallback);
					}
					
					
				} else {
					// reservation
					GWT.log("ItinerariesView.saveAllEdits saving a resv", null);
					Record resvRec = new Record();
					String[] attrs = treeNodeRec.getAttributes();
					
					for (int j = 0; j < attrs.length; j++) {
						String attr = attrs[j];
						if (attr.indexOf("auditDateTime")>=0 || (attr.indexOf("parentId")>=0) || attr.indexOf("title")>=0 || attr.indexOf("isFolder")>=0 || attr.indexOf("reservationId")>=0 || attr.indexOf("dirty")>=0) {
						} else if (attr.indexOf("Date")>=0) {
							Date value = treeNodeRec.getAttributeAsDate(attr);
							if (value!=null) {
								resvRec.setAttribute(attr, value);
							}
						} else {
							String value = treeNodeRec.getAttribute(attr);
							resvRec.setAttribute(attr, value);
						}
					}
					
					resvRec.setAttribute("id", treeNodeRec.getAttribute("reservationId"));
					resvRec.setAttribute("itineraryId", treeNodeRec.getAttribute("itineraryId"));
					resvRec.setAttribute("auditDateTime", new Date());
					resvRec.setAttribute("auditUserId", VH.getUserId());
					
					DSCallback resvUpdateCallback = new DSCallback() {

						@Override
						public void execute(DSResponse response,
								Object rawData, DSRequest request) {
							
							Record[] updatedRecs = response.getData();
							
							for (int j = 0; j < updatedRecs.length; j++) {
								Record updatedRec = updatedRecs[j];
//								String[] updatedRecAttrs = updatedRec.getAttributes();
//								for (int k = 0; k < updatedRecAttrs.length; k++) {
//									String attr = updatedRecAttrs[k];
//								}
								
								treeNodeRec.setAttribute("reservationId", updatedRec.getAttribute("id"));
								treeNodeRec.setAttribute("itineraryId", updatedRec.getAttribute("itineraryId"));
								treeNodeRec.setAttribute("auditDateTime", updatedRec.getAttribute("auditDateTime"));
								treeNodeRec.setAttribute("auditUserId", updatedRec.getAttribute("auditUserId"));
								treeNodeRec.setAttribute("dirty", false);
								// version?
							}
						}
					};
					reservations.updateData(resvRec, resvUpdateCallback);
				}
			}
		}
		
		GWT.log("ItinerariesView.saveAllEdits done", null);
	}

	public void addItinerary() {
		GWT.log("ItinerariesView.addItinerary starting", null);
		
		Record itinRec = new Record();
		String newItinId = getNewItinId();
		itinRec.setAttribute("id", newItinId);  
		itinRec.setAttribute("parentId", "root");
		itinRec.setAttribute("departDate", new Date());  
		itinRec.setAttribute("pnrLocator", "New");  
		itinRec.setAttribute("dirty", true);  
		itinRec.setAttribute("added", true);  
		ItineraryTreeNode newItinNode = new ItineraryTreeNode(itinRec, "ITIN");
		TreeNode addedNode = itinTree.add(newItinNode, rootNode, 0);
		itinTree.openFolder(newItinNode);
		itinTreeGrid.setData(itinTree);  
		itinTreeGrid.selectSingleRecord( (Record) addedNode);
		processRecordClick( (Record) addedNode);
		
		GWT.log("ItinerariesView.addItinerary done", null);
	}

	public void addResv(String type) {
		GWT.log("ItinerariesView.addResv starting", null);
		
		ListGridRecord selectedRec = itinTreeGrid.getSelectedRecord();
		String itinId = selectedRec.getAttribute("itineraryId");
		Record resvRec = new Record();
		String newResvId = getNewResvId();
		resvRec.setAttribute("id", newResvId);  
		resvRec.setAttribute("itineraryId", itinId);
		resvRec.setAttribute("dirty", true);  
		resvRec.setAttribute("added", true);  
		resvRec.setAttribute("resvBeginDate", new Date());
		ItineraryTreeNode newResvNode = new ItineraryTreeNode(resvRec, type);
		GWT.log("ItinerariesView.addResv b", null);
		TreeNode itinNode = getCurrentlySelectedItineraryNode(selectedRec);
		TreeNode addedNode = itinTree.add(newResvNode, itinNode);
		itinTree.openFolder(itinNode);
		itinTreeGrid.setData(itinTree);  
		itinTreeGrid.selectSingleRecord((Record)addedNode);
		processRecordClick((Record) addedNode);
		
		GWT.log("ItinerariesView.addResv done", null);
	}

	private TreeNode getCurrentlySelectedItineraryNode(ListGridRecord selectedRec) {
		
		TreeNode itinNode;
		
		String resType = selectedRec.getAttribute("resType");
		if (resType.equals("ITIN")) {
			String id = selectedRec.getAttribute("id");
			itinNode = itinTree.findById(id);
		} else {
			// a resv selected - get it's parent itinerary
			String parentId = selectedRec.getAttribute("parentId");
			itinNode = itinTree.findById(parentId);
		}
		return itinNode;
	}
	
	private void drawItinerariesTree() {

		GWT.log("ItinerariesView.drawItinTree starting", null);

		rootNode = new TreeNode();
		rootNode.setID("root");
		
		itinTree = new Tree();  
		itinTree.setModelType(TreeModelType.PARENT);  
		itinTree.setIdField("id");  
		itinTree.setParentIdField("parentId");  
		itinTree.setRoot(rootNode);
		
		itinTreeGrid = new TreeGrid();  
		itinTreeGrid.setAutoFetchData(false);  
		itinTreeGrid.setShowRoot(false);
		itinTreeGrid.setShowHeader(false);
		
		TreeGridField title = new TreeGridField("title", "Itineraries");
		title.setCanSort(false);
		itinTreeGrid.setFields(title);
		itinTreeGrid.setCanReorderRecords(true);  
		itinTreeGrid.setSelectionType(SelectionStyle.SINGLE);
		itinTreeGrid.setSelectionAppearance(SelectionAppearance.ROW_STYLE);
		itinTreeGrid.addRecordClickHandler(new RecordClickHandler() {  
			public void onRecordClick(RecordClickEvent event) {  	
				Record record = event.getRecord();  
				processRecordClick(record);
			}

		});

		itineraries = model.getItineraryDataSource();
		reservations = model.getReservationDataSource();

		GWT.log("ItinerariesView drawItinTree done", null);
	}

	private void processRecordClick(Record record) {
		String resType = record.getAttribute("resType");
		
		GWT.log("ItineraryView.drawItinTree a " + resType + " was clicked", null);

		hideAllForms();
		formStack.showSection(resType);

		if (resType.equals("ITIN")) {
			itinForm.editRecord(record);
		} else if (resType.equals("FLIGHT")) {
			flightResForm.editRecord(record);
		} else if (resType.equals("HOTEL")) {
			hotelResForm.editRecord(record);
		} else if (resType.equals("VEHICLE")) {
			vehicleResForm.editRecord(record);
		} else if (resType.equals("OTHER")) {
			otherResForm.editRecord(record);
		}
	}  
	
	public static class ItineraryTreeNode extends TreeNode {  
		public ItineraryTreeNode(Record rec, String resType) {  

			GWT.log("ItinerariesView creating new ItineraryTreeNode", null);
			
			String[] attrs = rec.getAttributes();
			for (int i = 0; i < attrs.length; i++) {
				String attr = attrs[i];
				
				if (attr.indexOf("Date")>0) {
					Date value = rec.getAttributeAsDate(attr);
					if (value!=null)
						setAttribute(attr, value);
				} else {
					String value = rec.getAttribute(attr);
					setAttribute(attr, value);
				}
			}
			
			
			if (resType.equals("ITIN")) {
				GWT.log("ItinerariesView creating new ItineraryTreeNode resType=ITIN", null);
				// itinerary - number nodes as xx00
				String itineraryId = rec.getAttribute("id");
				String treeNodeId = itineraryId.concat("00");
				String parentTreeNodeId = "root";
				
				setAttribute("id", treeNodeId);  
				setAttribute("parentId", parentTreeNodeId);
				setAttribute("itineraryId", itineraryId);  
				
				Date departDate = rec.getAttributeAsDate("departDate");
				String departDateStr;
				if (departDate==null) {
					departDateStr="";
				} else {
					departDateStr=VH.getYmdFormat().format(departDate);
				}
				String pnr = rec.getAttribute("pnrLocator");
				String title = departDateStr + " " + pnr;
				
				setAttribute("title", title);  
				GWT.log("ItinerariesView creating new ItineraryTreeNode resType=ITIN done", null);
				
			} else {
				// reservation - number nodes as xx00yy
				GWT.log("ItinerariesView creating new ItineraryTreeNode resType=res", null);
				String resvId = rec.getAttribute("id");
				String itineraryId = rec.getAttribute("itineraryId");
				String parentTreeNodeId = itineraryId.concat("00");
				String treeNodeId = parentTreeNodeId.concat(resvId);
				GWT.log("ItinerariesView creating new ItineraryTreeNode resType=res b", null);
				
				setAttribute("id", treeNodeId);  
				setAttribute("parentId", parentTreeNodeId);
				setAttribute("itineraryId", itineraryId);  
				setAttribute("reservationId", resvId);  
				
				Date resvBeginDate = rec.getAttributeAsDate("resvBeginDate");
				String resvBeginDateStr;
				if (resvBeginDate==null) {
					resvBeginDateStr="N/A";
				} else {
					resvBeginDateStr=VH.getYmdFormat().format(resvBeginDate);
				}
				
				String title = resvBeginDateStr + " " + resType;
				
				setAttribute("title", title);  
				GWT.log("ItinerariesView creating new ItineraryTreeNode resType=res done", null);
			}
			
			setAttribute("resType", resType);  
		}
	}

	public static String getNewItinId() {
		newItinId++;
		return "newitin" + newItinId.toString();
	}  
	public static String getNewResvId() {
		newResvId++;
		return "newresv" + newResvId.toString();
	}  
}
