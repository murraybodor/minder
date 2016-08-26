package com.skyquill.minder.client.config;

import com.skyquill.minder.client.Cache;
import com.skyquill.minder.client.util.VH;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;

public class CountriesView extends ConfigurationAbstractView {

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
        	CountriesView panel = new CountriesView();
            id = panel.getID();
            return panel;
        }

        public String getID() {
            return id;
        }

    }
	
	public CountriesView() {
	}

	@Override
	public Canvas getViewPanel() {

		VLayout vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		
		listGrid.setDataSource(Cache.getCountriesDataSource());  

		ListGridField countryName = new ListGridField("name", "Name");  
		countryName.setWidth(120);
		
		ListGridField countryCurrency = new ListGridField("currencyId", "Currency");
		countryCurrency.setOptionDataSource(Cache.getCurrenciesDataSource());
		countryCurrency.setValueField("id");
		countryCurrency.setDisplayField("currencyCode");
		countryCurrency.setWidth(90);

		ListGridField worldArea = new ListGridField("worldAreaId", "World Area");  
		worldArea.setOptionDataSource(Cache.getWorldAreasDataSource());
		worldArea.setValueField("id");
		worldArea.setDisplayField("name");
		worldArea.setWidth(100);

		ListGridField auditDatetime = VH.createAuditDateTimeField();
		ListGridField auditUserid = VH.createAuditUserIdField();

		listGrid.setFields(countryName, countryCurrency, worldArea, auditDatetime, auditUserid);  

		vLayout.addMember(listGrid); 
		
		return vLayout;
	}

}
