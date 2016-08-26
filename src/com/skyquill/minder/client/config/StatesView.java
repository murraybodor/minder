package com.skyquill.minder.client.config;

import com.skyquill.minder.client.Cache;
import com.skyquill.minder.client.util.VH;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;

public class StatesView extends ConfigurationAbstractView {

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
        	StatesView panel = new StatesView();
            id = panel.getID();
            return panel;
        }

        public String getID() {
            return id;
        }

    }

	public StatesView() {
	}

	@Override
	public Canvas getViewPanel() {

		VLayout vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		
		listGrid.setDataSource(Cache.getStatesDataSource());

		ListGridField abbrev = new ListGridField("abbrev", "Abbrev");  
		abbrev.setWidth(50);
		
		ListGridField name = new ListGridField("name", "Name");  
		name.setWidth(120);

		ListGridField country = new ListGridField("countryId", "Country");
		country.setOptionDataSource(Cache.getCountriesDataSource());
		country.setValueField("id");
		country.setDisplayField("name");
		country.setWidth(90);
		
		ListGridField auditDatetime = VH.createAuditDateTimeField();
		ListGridField auditUserid = VH.createAuditUserIdField();

		listGrid.setFields(abbrev, name, country, auditDatetime, auditUserid);  

		vLayout.addMember(listGrid); 
		
		return vLayout;
	}

}
