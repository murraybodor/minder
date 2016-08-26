package com.skyquill.minder.client;

import com.google.gwt.core.client.GWT;
import com.skyquill.minder.client.util.VH;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.Side;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.events.ItemChangedEvent;
import com.smartgwt.client.widgets.form.events.ItemChangedHandler;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

public class ItineraryView extends HLayout {

	private TravellerModel model;
//	private ListGrid itinGrid;  
	private ListGrid resvGrid;  

//	private VLayout formArea;
	private DynamicForm flightResForm;
	private DynamicForm hotelResForm;
	private DynamicForm vehicleResForm;
	private DynamicForm otherResForm;
	final TabSet tabSet = new TabSet();  
	private Tab flightTab;  
	private Tab vehicleTab;  
	private Tab hotelTab;  
	private Tab otherTab;  
	
	public ItineraryView(TravellerModel aModel) {

		GWT.log("ItineraryView init ", null);

		setWidth100();
		setHeight100();
		setMembersMargin(10);
		setLayoutMargin(5);

		this.model = aModel;
		
		drawResvGrid();
		
		
		addMember(resvGrid);
		
		drawFlightResForm();
		drawHotelResForm();
		drawVehicleResForm();
		drawOtherResForm();

		tabSet.setTabBarPosition(Side.TOP);  
		tabSet.setTabBarThickness(25);  
		tabSet.setTabBarAlign(Side.LEFT);  
		tabSet.setWidth(400);  
		tabSet.setHeight(150);  

		flightTab = new Tab("Flight");  
		flightTab.setID("FLIGHT");
		flightTab.setPane(flightResForm);  
		tabSet.addTab(flightTab);  
		
		vehicleTab = new Tab("Vehicle");  
		vehicleTab.setID("VEHICLE");
		vehicleTab.setPane(vehicleResForm);  
		tabSet.addTab(vehicleTab);  

		hotelTab = new Tab("Hotel");  
		hotelTab.setID("HOTEL");
		hotelTab.setPane(hotelResForm);  
		tabSet.addTab(hotelTab);  

		otherTab = new Tab("Other");  
		otherTab.setID("OTHER");
		otherTab.setPane(otherResForm);  
		tabSet.addTab(otherTab);  
		
		addMember(tabSet);
		
		GWT.log("ItineraryView init done", null);

	}

	private void drawFlightResForm() {
		flightResForm = new DynamicForm();
		flightResForm.setDataSource(model.getReservationDataSource());
		
		TextItem flightDepartureId = new TextItem("flightDepartureId");
		flightDepartureId.setTitle("Departure ID");
		
		flightResForm.setFields(flightDepartureId, VH.drawCostField(), VH.drawCurrencySelect(), VH.drawCostCenterField(), VH.drawPurposeField(), VH.drawCommentsField());
		
	}
	
	private void drawHotelResForm() {
		hotelResForm = new DynamicForm();
		hotelResForm.setDataSource(model.getReservationDataSource());
		hotelResForm.setAutoFetchData(false);
		
		TextItem otherHotel = new TextItem("otherHotel");
		otherHotel.setTitle("Other Hotel");
		
		hotelResForm.setFields(otherHotel, VH.drawCostField(), VH.drawCurrencySelect(), VH.drawCostCenterField(), VH.drawPurposeField(), VH.drawCommentsField());
		
		hotelResForm.addItemChangedHandler(new ItemChangedHandler() {

			@Override
			public void onItemChanged(ItemChangedEvent event) {
				// TODO Auto-generated method stub
				ListGridRecord rec = resvGrid.getSelectedRecord();
//				String source = (String)event.getSource();
				String field = event.getItem().getFieldName();
				Object newVal = event.getNewValue();
				
				GWT.log("hotelform.hasitemchanged firing, src=" + field + " newval=" + newVal.toString(), null);
//				hotelResForm.saveData();
//				hotelResForm.getDataSource().
				rec.setAttribute(field, newVal);
			}
			
		});
	}
		
	private void drawVehicleResForm() {
		vehicleResForm = new DynamicForm();
		vehicleResForm.setDataSource(model.getReservationDataSource());
		
		TextItem rentalAgency = new TextItem("rentalAgency");
		rentalAgency.setTitle("Rental Agency");
		
		vehicleResForm.setFields(rentalAgency, VH.drawCostField(), VH.drawCurrencySelect(), VH.drawCostCenterField(), VH.drawPurposeField(), VH.drawCommentsField());
		
	}

	private void drawOtherResForm() {
		otherResForm = new DynamicForm();
		otherResForm.setDataSource(model.getReservationDataSource());
		
		DateItem resvDate = new DateItem("resvDate");
		resvDate.setTitle("Date");
		
		otherResForm.setFields(resvDate, VH.drawCostField(), VH.drawCurrencySelect(), VH.drawCostCenterField(), VH.drawPurposeField(), VH.drawCommentsField());
		
	}
	
	private void drawResvGrid() {
		
		resvGrid = new ListGrid();
        resvGrid.setWidth(300);
        resvGrid.setHeight(360);
        resvGrid.setCellHeight(22);
        resvGrid.setDataSource(model.getReservationDataSource());
        resvGrid.setAutoSaveEdits(false);  
        resvGrid.setAutoFetchData(false);
        
        resvGrid.addRecordClickHandler(new RecordClickHandler() {  
        	public void onRecordClick(RecordClickEvent event) {  	
        		Record record = event.getRecord();  
//        		int recNum = event.getRecordNum();
        		String resType = record.getAttribute("resType");
        		
        		
        		GWT.log("ItineraryView resvGrid: " + resType + " was selected", null);
        		tabSet.selectTab(resType);
        		if (resType.equals("FLIGHT")) {
        			flightResForm.reset();  
        			flightResForm.editSelectedData(resvGrid);  
        		} else if (resType.equals("HOTEL")) {
            		hotelResForm.reset();  
            		hotelResForm.editSelectedData(resvGrid);  
        		} else if (resType.equals("VEHICLE")) {
        			vehicleResForm.reset();  
        			vehicleResForm.editSelectedData(resvGrid);  
        		} else if (resType.equals("OTHER")) {
        			otherResForm.reset();  
        			otherResForm.editSelectedData(resvGrid);  
        		}        	   
        	}  
        });


//        resvGrid.addSelectionChangedHandler(new SelectionChangedHandler() {
//        	public void onSelectionChanged(SelectionEvent event) {  
//        		boolean state = event.getState();
//        		Record record = event.getRecord();  
//        		String resType = record.getAttribute("resType");
////        		GWT.log("ItineraryView resvGrid select change: " + resType + " was " + (state?"selected":"unselected"), null);
//        		
//        		if (state) {
//            		GWT.log("ItineraryView resvGrid: " + resType + " was selected", null);
//            		tabSet.selectTab(resType);
//            		if (resType.equals("FLIGHT")) {
//            			flightResForm.editRecord(record); 
//            		} else if (resType.equals("HOTEL")) {
//            			hotelResForm.editRecord(record);  
//            		} else if (resType.equals("VEHICLE")) {
//                		String otherHotel = record.getAttribute("otherHotel");
//                		GWT.log("ItineraryView selected " + resType + ", otherhotel=" + otherHotel, null);
//            			vehicleResForm.editRecord(record);  
//            		} else if (resType.equals("OTHER")) {
//            			otherResForm.editRecord(record);  
//            		}        	   
//        		} else {
//            		GWT.log("ItineraryView resvGrid: " + resType + " was unselected", null);
//        			
//        		}
//        	}  
//        });
         
         
		ListGridField order = new ListGridField("order", "Order");
		order.setType(ListGridFieldType.TEXT);  
		order.setAlign(Alignment.CENTER);
		order.setWidth(40);
		
		ListGridField resType = new ListGridField("resType", "Type");
		resType.setType(ListGridFieldType.TEXT);  
		resType.setAlign(Alignment.LEFT);
		resType.setWidth(100);
		
		ListGridField resvAuditDateTime = VH.createAuditDateTimeField();
		ListGridField resvAuditUserId = VH.createAuditUserIdField();
		
		resvGrid.setFields(order, resType, resvAuditDateTime, resvAuditUserId);
        
		
//		final DynamicForm resvForm = new DynamicForm();
//		resvForm.setDataSource(model.getReservationDataSource());
//
//		TextItem otherHotel = new TextItem("otherHotel");  
//		otherHotel.setTitle("Other Hotel");  
//
//		TextItem conf = new TextItem("conf");  
//		conf.setTitle("Confirmation Number");  
//
//		DateItem arrivalDateItem = new DateItem();  
//		arrivalDateItem.setName("arrivalDate");  
//		arrivalDateItem.setTitle("Arrival Date");  
//
//		resvForm.setFields(otherHotel, conf, arrivalDateItem); 		
        
//		itinGrid = new ListGrid() {
//
//			@Override
//			protected Canvas getExpansionComponent(ListGridRecord record) {
//				GWT.log("ItineraryView itinGrid getExpansionComponent", null);
//
//				HLayout layout = new HLayout(5);
//				layout.setPadding(5);
//
//				JavaScriptObject itemsJS = record.getAttributeAsJavaScriptObject("reservations");
//				Record[] items = Record.convertToRecordArray(itemsJS);
//				resvGrid.setData(items);
////				resvGrid.addSelectionChangedHandler(new SelectionChangedHandler() {
////
////					@Override
////					public void onSelectionChanged(SelectionEvent event) {
////						// TODO Auto-generated method stub
////						Record rec = event.getRecord();
////						resvForm.editRecord(rec);
////
////					}
////
////				});
//				resvGrid.redraw();
//
//				layout.addMember(resvGrid);
////				layout.addMember(resvForm);
//
//				GWT.log("ItineraryView itinGrid getExpansionComponent done", null);
//				return layout;
//			}
//
//		};  
//		itinGrid.setHeight(360);  
//		itinGrid.setAutoFetchData(false);
//		itinGrid.setAlternateRecordStyles(true);  
//		itinGrid.setCanEdit(true);  
//		itinGrid.setCanExpandRecords(true);
//		itinGrid.setEditEvent(ListGridEditEvent.CLICK);  
//		itinGrid.setDataSource(model.getItineraryDataSource());
//		
//		ListGridField departDate = new ListGridField("departDate", "Depart Date");
//		departDate.setAlign(Alignment.LEFT);
//		departDate.setType(ListGridFieldType.DATE);  
//		departDate.setWidth(90);
//		
//		ListGridField pnrLocator = new ListGridField("pnrLocator", "PNR Locator");
//		pnrLocator.setType(ListGridFieldType.TEXT);  
//		pnrLocator.setAlign(Alignment.LEFT);
//		pnrLocator.setWidth(100);
//
//		ListGridField purpose = new ListGridField("purpose", "Purpose");
//		purpose.setType(ListGridFieldType.TEXT);  
//		purpose.setAlign(Alignment.LEFT);
//		purpose.setWidth(100);
//
//		ListGridField returnDate = new ListGridField("returnDate", "Return Date");
//		returnDate.setType(ListGridFieldType.DATE);  
//		returnDate.setAlign(Alignment.LEFT);
//		returnDate.setWidth(90);
//
//		ListGridField flightCost = new ListGridField("flightCost", "Flight Cost");
//		flightCost.setType(ListGridFieldType.FLOAT);  
//		flightCost.setAlign(Alignment.RIGHT);
//		flightCost.setWidth(100);
//		
//		ListGridField comments = new ListGridField("comments", "Comments");
//		comments.setAlign(Alignment.LEFT);
//		comments.setType(ListGridFieldType.TEXT);  
//		comments.setWidth(300);
//
//		ListGridField auditDateTime = VH.createAuditDateTimeField();
//		ListGridField auditUserId = VH.createAuditUserIdField();
//		
//		itinGrid.setFields(departDate, pnrLocator, purpose, returnDate, flightCost, comments, auditDateTime, auditUserId);
//		
//		addMember(itinGrid);
		
	}	
	
//	private void draw2Grids() {
//		
//		itinGrid = new ListGrid();  
//		itinGrid.setHeight(180);  
//		itinGrid.setAutoFetchData(false);
//		itinGrid.setAlternateRecordStyles(true);  
//		itinGrid.setCanEdit(true);  
//		itinGrid.setEditEvent(ListGridEditEvent.CLICK);  
//		itinGrid.setDataSource(model.getItineraryDataSource());
//		
//		resvGrid = new ListGrid();  
//		resvGrid.setHeight(180);  
//		resvGrid.setAutoFetchData(false);
//		resvGrid.setAlternateRecordStyles(true);  
//		resvGrid.setCanEdit(true);  
//		resvGrid.setEditEvent(ListGridEditEvent.CLICK);  
//		resvGrid.setDataSource(model.getReservationDataSource());
//		resvGrid.setUseAllDataSourceFields(true);
//		
//		resvGrid.setSaveByCell(true);
//		resvGrid.setSaveLocally(true);
//		
//		ListGridField departDate = new ListGridField("departDate", "Depart Date");
//		departDate.setAlign(Alignment.LEFT);
//		departDate.setType(ListGridFieldType.DATE);  
//		departDate.setWidth(90);
//		
//		ListGridField pnrLocator = new ListGridField("pnrLocator", "PNR Locator");
//		pnrLocator.setType(ListGridFieldType.TEXT);  
//		pnrLocator.setAlign(Alignment.LEFT);
//		pnrLocator.setWidth(100);
//
//		ListGridField purpose = new ListGridField("purpose", "Purpose");
//		purpose.setType(ListGridFieldType.TEXT);  
//		purpose.setAlign(Alignment.LEFT);
//		purpose.setWidth(100);
//
//		ListGridField returnDate = new ListGridField("returnDate", "Return Date");
//		returnDate.setType(ListGridFieldType.DATE);  
//		returnDate.setAlign(Alignment.LEFT);
//		returnDate.setWidth(90);
//
//		ListGridField flightCost = new ListGridField("flightCost", "Flight Cost");
//		flightCost.setType(ListGridFieldType.FLOAT);  
//		flightCost.setAlign(Alignment.RIGHT);
//		flightCost.setWidth(100);
//		
//		ListGridField comments = new ListGridField("comments", "Comments");
//		comments.setAlign(Alignment.LEFT);
//		comments.setType(ListGridFieldType.TEXT);  
//		comments.setWidth(300);
//
//		ListGridField auditDateTime = VH.createAuditDateTimeField();
//		ListGridField auditUserId = VH.createAuditUserIdField();
//		
//		itinGrid.setFields(departDate, pnrLocator, purpose, returnDate, flightCost, comments, auditDateTime, auditUserId);
//		
//		
//		itinGrid.addSelectionChangedHandler(new SelectionChangedHandler() {
//            public void onSelectionChanged(SelectionEvent event) {
//                Record record = event.getRecord();
//                if (record!=null) {
//                    JavaScriptObject itemsJS = record.getAttributeAsJavaScriptObject("reservations");
//                    Record[] items = Record.convertToRecordArray(itemsJS);
//                    resvGrid.setData(items);
//                    resvGrid.redraw();
//                }
//            }
//        });		
//		addMember(itinGrid);
//
//		addMember(resvGrid);
//	}

	public void loadData(Long itineraryId) {

		if (model.getTravellerId()!=null) {
			GWT.log("ItineraryView fetching iinerary " + itineraryId.toString() + " for traveller " + model.getTravellerId().toString(), null);
//			Criteria travCrit = new Criteria("travellerId", model.getTravellerId().toString());
			Criteria itinCrit = new Criteria("itineraryId", itineraryId.toString());
//			travCrit.addCriteria(itinCrit);
			resvGrid.fetchData(itinCrit);
			
			GWT.log("ItineraryView done fetching reservations for itinerary " + itineraryId.toString() + " for traveller " + model.getTravellerId().toString(), null);
		}
	}

	public void saveAllEdits() {

		// update records for travellerid from model
		
//		int[] ppRows = ppGrid.getAllEditRows();
//		for (int i = 0; i < ppRows.length; i++) {
//			ListGridRecord rec = ppGrid.getRecord(i);
//			ppGrid.setEditValue(i, "travellerId", model.getTravellerId());
//			GWT.log("ItineraryView saveAllEdits added travId to pp rec " + i, null);
//		}
//		
//		ppGrid.saveAllEdits();
//
//		int[] visaRows = visaGrid.getAllEditRows();
//		for (int i = 0; i < visaRows.length; i++) {
//			ListGridRecord rec = visaGrid.getRecord(i);
//			visaGrid.setEditValue(i, "travellerId", model.getTravellerId());
//			GWT.log("ItineraryView saveAllEdits added travId to visa rec " + i, null);
//		}
//		
//		visaGrid.saveAllEdits();
		
	}
	
////ppGrid.setCanRemoveRecords(true);
////itinGrid.setUseAllDataSourceFields(true);
//itinGrid.setAutoFetchData(false);
//itinGrid.setAutoSaveEdits(false);
//itinGrid.setOverflow(Overflow.HIDDEN);	
//itinGrid.setCanExpandRecords(true);
//itinGrid.setExpansionCanEdit(true);

//itinGrid.addDataArrivedHandler(new DataArrivedHandler() {  
//	public void onDataArrived(DataArrivedEvent event) {  
////		itinGrid.getData().openAll();
// 		GWT.log("ItineraryView data arrived, start= " + event.getStartRow() + " end=" + event.getEndRow(), null);
//// 		itinGrid.
//	}  
//});
//
//
	
}
