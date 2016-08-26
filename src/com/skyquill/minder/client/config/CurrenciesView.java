package com.skyquill.minder.client.config;

import com.skyquill.minder.client.Cache;
import com.skyquill.minder.client.util.VH;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;

public class CurrenciesView extends ConfigurationAbstractView {


    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
        	CurrenciesView panel = new CurrenciesView();
            id = panel.getID();
            return panel;
        }

        public String getID() {
            return id;
        }

    }
	
	public CurrenciesView() {
	}
	
	@Override
	public Canvas getViewPanel() {
		
		VLayout vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		
		listGrid.setDataSource(Cache.getCurrenciesDataSource());  

		ListGridField currencyCode = new ListGridField("currencyCode", "Code");  
		currencyCode.setWidth(100);
		ListGridField name = new ListGridField("name", "Name");  
		name.setWidth(125);
		ListGridField exchRate = new ListGridField("exchRateTo1Usd", "Exchange Rate");  
		exchRate.setWidth(100);

		ListGridField auditDatetime = VH.createAuditDateTimeField();
		ListGridField auditUserid = VH.createAuditUserIdField();

		listGrid.setFields(currencyCode, name, exchRate, auditDatetime, auditUserid);  

		vLayout.addMember(listGrid); 
		
		return vLayout;
	}
}
