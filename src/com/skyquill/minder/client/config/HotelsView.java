package com.skyquill.minder.client.config;

import com.skyquill.minder.client.Cache;
import com.skyquill.minder.client.util.VH;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;

public class HotelsView extends ConfigurationAbstractView {

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
        	HotelsView panel = new HotelsView();
            id = panel.getID();
            return panel;
        }

        public String getID() {
            return id;
        }

    }

	public HotelsView() {
	}

	@Override
	public Canvas getViewPanel() {

		VLayout vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		
		listGrid.setDataSource(Cache.getHotelsDataSource());

		ListGridField name = new ListGridField("name", "Hotel Name");  
		name.setWidth(120);

		ListGridField city = new ListGridField("cityId", "City");
		city.setOptionDataSource(Cache.getCitiesDataSource());
		city.setValueField("id");
		city.setDisplayField("name");
		city.setWidth(100);
		
		ListGridField closestAirport = new ListGridField("closestAirportId", "Closest Airport");
		closestAirport.setOptionDataSource(Cache.getAirportsDataSource());
		closestAirport.setValueField("id");
		closestAirport.setDisplayField("iataCode");
		closestAirport.setWidth(100);

		ListGridField address = new ListGridField("address", "Address");  
		address.setWidth(150);
		
		ListGridField phone = new ListGridField("phone", "Phone");  
		phone.setWidth(100);

		ListGridField fax = new ListGridField("fax", "Fax");  
		fax.setWidth(120);

		ListGridField url = new ListGridField("url", "URL");  
		url.setWidth(200);
		
		ListGridField comments = new ListGridField("comments", "Comments");  
		comments.setWidth(200);
		
		ListGridField latitude = new ListGridField("latitude", "Latitude");  
		latitude.setWidth(75);

		ListGridField longitude = new ListGridField("longitude", "Longitude");  
		longitude.setWidth(75);
		
		ListGridField auditDatetime = VH.createAuditDateTimeField();
		ListGridField auditUserid = VH.createAuditUserIdField();

		listGrid.setFields(name, city, closestAirport, address, phone, fax, url, comments, latitude, longitude, auditDatetime, auditUserid);  

		vLayout.addMember(listGrid); 
		
		return vLayout;
	}

}
