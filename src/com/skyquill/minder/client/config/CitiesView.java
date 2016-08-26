package com.skyquill.minder.client.config;

import com.skyquill.minder.client.Cache;
import com.skyquill.minder.client.util.VH;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;

public class CitiesView extends ConfigurationAbstractView {

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
        	CitiesView panel = new CitiesView();
            id = panel.getID();
            return panel;
        }

        public String getID() {
            return id;
        }

    }

	public CitiesView() {
	}

	@Override
	public Canvas getViewPanel() {

		VLayout vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		
		listGrid.setDataSource(Cache.getCitiesDataSource());

		ListGridField name = new ListGridField("name", "Name");  
		name.setWidth(120);

		ListGridField state = new ListGridField("stateId", "State/Province");
		state.setOptionDataSource(Cache.getStatesDataSource());
		state.setValueField("id");
		state.setDisplayField("abbrev");
		state.setWidth(90);

		ListGridField country = new ListGridField("countryId", "Country");
		country.setOptionDataSource(Cache.getCountriesDataSource());
		country.setValueField("id");
		country.setDisplayField("name");
		country.setWidth(90);
		
		ListGridField timeZone = new ListGridField("timeZone", "Time Zone");  
		timeZone.setWidth(75);

		ListGridField latitude = new ListGridField("latitude", "Latitude");  
		latitude.setWidth(75);

		ListGridField longitude = new ListGridField("longitude", "Longitude");  
		longitude.setWidth(75);
		
		ListGridField auditDatetime = VH.createAuditDateTimeField();
		ListGridField auditUserid = VH.createAuditUserIdField();

		listGrid.setFields(name, state, country, timeZone, latitude, longitude, auditDatetime, auditUserid);  

		vLayout.addMember(listGrid); 
		
		return vLayout;
		
	}

}
