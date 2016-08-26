package com.skyquill.minder.client.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.skyquill.minder.client.Cache;
import com.skyquill.minder.client.TravellerModel;
import com.skyquill.minder.client.UserSession;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.AnimationEffect;
import com.smartgwt.client.types.DateDisplayFormat;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.Visibility;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;

public class VH {

	public static int TABSET1WIDTH = 1015; 
	public static int TABSET1HEIGHT = 520; 
	public static int TRAVELLERS_TABSET_WIDTH = 945; 
	public static int TRAVELLERS_TABSET_HEIGHT = 485; 
	public static int TRAVELLER_TABSET_WIDTH = 925; 
	public static int TRAVELLER_TABSET_HEIGHT = 420; 
	public static int TABSET4WIDTH = 240; 
	public static int TABSET4HEIGHT = 125; 
	public static int EMPL_TABSET_WIDTH = 600; 
	public static int EMPL_TABSET_HEIGHT = 380; 
	public static Label status = new Label();
//	private static int id = -999;
	
	public static void showStatus (String backgroundColor, String message) {
		status.setWidth(600);
		status.setBackgroundColor(backgroundColor);
		status.setVisibility(Visibility.HIDDEN);
		status.setAlign(Alignment.CENTER);
		status.setContents(message);
		status.animateShow(AnimationEffect.WIPE);  
	}
	
	public static ListGridField createAuditDateTimeField() {
		ListGridField auditDateTime = new ListGridField("auditDateTime", "Last Changed");
		auditDateTime.setType(ListGridFieldType.DATE);  		
		auditDateTime.setCanEdit(false);
		auditDateTime.setWidth(120);
		auditDateTime.setAlign(Alignment.LEFT);	
		auditDateTime.setCellFormatter(getYmdHmsFormatter());  	
		return auditDateTime;
	}

	public static TextItem drawCostField() {
		TextItem cost = new TextItem("cost");
		cost.setTitle("Cost");
		return cost;
	}
	public static TextItem drawCostCenterField() {
		TextItem costCenter = new TextItem("costCenter");
		costCenter.setTitle("Cost Center");
		return costCenter;
	}
	public static TextItem drawPurposeField() {
		TextItem purpose = new TextItem("purpose");
		purpose.setTitle("Purpose");
		return purpose;
	}
	public static TextAreaItem drawCommentsField() {
		TextAreaItem comments = new TextAreaItem("comments");
		comments.setTitle("Comments");
		comments.setWidth(200);
		comments.setHeight(50);
		return comments;
	}
	public static SelectItem drawCurrencySelect() {
		SelectItem currencySelect = new SelectItem("currencyId", "Currency");
		currencySelect.setOptionDataSource(Cache.getCurrenciesDataSource());
		currencySelect.setValueField("id");
		currencySelect.setDisplayField("currencyCode");
		currencySelect.setWidth(90);
		return currencySelect;
	}
	public static SelectItem drawCitySelect() {
		SelectItem citySelect = new SelectItem("cityId", "City");
		citySelect.setOptionDataSource(Cache.getCitiesDataSource());
		citySelect.setValueField("id");
		citySelect.setDisplayField("name");
		citySelect.setWidth(150);
		return citySelect;
	}
	public static SelectItem drawAirlineSelect() {
		SelectItem airlineSelect = new SelectItem("carrierId", "Airline");
		airlineSelect.setOptionDataSource(Cache.getAirlinesDataSource());
		airlineSelect.setValueField("id");
		airlineSelect.setDisplayField("name");
		airlineSelect.setWidth(150);
		return airlineSelect;
	}
	public static SelectItem drawOriginAirportSelect() {
		SelectItem airportSelect = new SelectItem("originAirportId", "Origin Airport");
		airportSelect.setOptionDataSource(Cache.getAirportsDataSource());
		airportSelect.setValueField("id");
		airportSelect.setDisplayField("iataCode");
		airportSelect.setWidth(150);
		return airportSelect;
	}
	public static SelectItem drawDestAirportSelect() {
		SelectItem airportSelect = new SelectItem("destAirportId", "Destination Airport");
		airportSelect.setOptionDataSource(Cache.getAirportsDataSource());
		airportSelect.setValueField("id");
		airportSelect.setDisplayField("iataCode");
		airportSelect.setWidth(150);
		return airportSelect;
	}
	public static SelectItem drawHotelSelect() {
		SelectItem hotelSelect = new SelectItem("hotelId", "Hotel");
		hotelSelect.setOptionDataSource(Cache.getHotelsDataSource());
		hotelSelect.setValueField("id");
		hotelSelect.setDisplayField("name");
		hotelSelect.setWidth(150);
		return hotelSelect;
	}
	public static CheckboxItem drawFollowUpField() {
		CheckboxItem followup = new CheckboxItem("needsFollowUp");
		followup.setTitle("Flag for later followup");
		return followup;
	}
	
	public static TextItem drawAuditDateTimeField() {
		TextItem auditDateTime = new TextItem("auditDateTime", "Last Changed");
		auditDateTime.setDisabled(true);
		auditDateTime.setWidth(120);
		auditDateTime.setAlign(Alignment.LEFT);	
		auditDateTime.setDateFormatter(getYmdHmsDisplayFormat());  	
		auditDateTime.setStartRow(true);
		return auditDateTime;
	}

	public static TextItem drawAuditUserIdField() {
		TextItem auditUserId = new TextItem("auditUserId", "Last Changed By");
		auditUserId.setDisabled(true);
		auditUserId.setWidth(120);
		auditUserId.setAlign(Alignment.LEFT);	
		return auditUserId;
	}
	
	public static CellFormatter getYmdFormatter() {
		
		return new CellFormatter() {  
			public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
				if (value!=null) {
					Date dt = (Date)value;
					return getYmdFormat().format(dt);
				} else
					return "";
			}  
		};  	
		
	}
	public static CellFormatter getYmdHmsFormatter() {
		
		return new CellFormatter() {  
			public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
				if (value!=null) {
					Date dt = (Date)value;
					return getYmdHmsFormat().format(dt);
				} else
					return "";
			}  
		};  	
		
	}
	public static ListGridField createAuditUserIdField() {
		ListGridField auditUserId = new ListGridField("auditUserId", "By");  
		auditUserId.setType(ListGridFieldType.TEXT);  		
		auditUserId.setCanEdit(false);
		auditUserId.setWidth(70);
		auditUserId.setAlign(Alignment.LEFT);	
		return auditUserId;
	}

	public static String getUserId() {
		return UserSession.getUserName();
	}
	
	public static DateTimeFormat getYmdFormat() {
		DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy-MM-dd");
		return fmt;
		
	}

	public static DateTimeFormat getYmdHmsFormat() {
		DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss");
		return fmt;
		
	}
	public static DateDisplayFormat getYmdDisplayFormat() {
		DateDisplayFormat fmt = DateDisplayFormat.TOJAPANSHORTDATE;
		return fmt;
	}
	public static DateDisplayFormat getYmdHmsDisplayFormat() {
		DateDisplayFormat fmt = DateDisplayFormat.TOSERIALIZEABLEDATE;
		return fmt;
	}
	
	public static Map<String, Object> getNewRecMap() {
		Map<String, Object> defaultValues = new HashMap<String, Object>();
//		defaultValues.put("id", id);
//		id++;
		defaultValues.put("isNew", true);
		defaultValues.put("auditDateTime", new Date());
		defaultValues.put("auditUserId", getUserId());
		return defaultValues;
	}
	
	public static Map<String, String> getFKMap(TravellerModel model) {
		Map<String, String> newVals = new HashMap<String, String>();
		newVals.put("travellerId", model.getTravellerId());
		return newVals;
	}
	
	public static ListGridField createDeleteField(final ListGrid gridToDeleteFrom) {
		
		ListGridField delete = new ListGridField("isDeleted");
		delete.setTitle("Delete");
		delete.setWidth(36);
		delete.setCanEdit(false);
		delete.setType(ListGridFieldType.ICON);
		delete.setCellIcon("[SKIN]actions/remove.png");
		delete.addRecordClickHandler(new RecordClickHandler() {

			@Override
			public void onRecordClick(RecordClickEvent event) {
				int row = event.getRecordNum();
				Record rec = gridToDeleteFrom.getEditedRecord(row);
				boolean isNew = rec.getAttributeAsBoolean("isNew");

				if (isNew) {
					gridToDeleteFrom.discardEdits(row, 1);
				} else {
					ListGridRecord delRec = gridToDeleteFrom.getRecord(row);
					gridToDeleteFrom.setEditValue(row, "isDeleted", true);
					delRec.setCustomStyle("deletedRecord");
					gridToDeleteFrom.refreshRow(row);
				}

				event.cancel();
			}
			
		});
		
		return delete;
	}
}
