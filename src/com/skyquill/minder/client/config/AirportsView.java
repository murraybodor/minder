package com.skyquill.minder.client.config;

import com.skyquill.minder.client.Cache;
import com.skyquill.minder.client.util.VH;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;

public class AirportsView extends ConfigurationAbstractView {

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
        	AirportsView panel = new AirportsView();
            id = panel.getID();
            return panel;
        }

        public String getID() {
            return id;
        }

    }

	public AirportsView() {
	}

	@Override
	public Canvas getViewPanel() {

		VLayout vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		
		listGrid.setDataSource(Cache.getAirportsDataSource());

		ListGridField iataCode = new ListGridField("iataCode", "Code");  
		iataCode.setWidth(50);
		
		ListGridField name = new ListGridField("name", "Airport Name");  
		name.setWidth(160);
		
		ListGridField city = new ListGridField("cityId", "City");
		city.setOptionDataSource(Cache.getCitiesDataSource());
		city.setValueField("id");
		city.setDisplayField("name");
		city.setWidth(110);
		
		ListGridField description = new ListGridField("description", "Description");  
		description.setWidth(200);

		ListGridField latitude = new ListGridField("latitude", "Latitude");  
		latitude.setWidth(75);

		ListGridField longitude = new ListGridField("longitude", "Longitude");  
		longitude.setWidth(75);

		ListGridField auditDatetime = VH.createAuditDateTimeField();
		ListGridField auditUserid = VH.createAuditUserIdField();

		listGrid.setFields(iataCode, name, city, description, latitude, longitude, auditDatetime, auditUserid);  

		vLayout.addMember(listGrid); 
		
		return vLayout;
		
	}

}
