package com.skyquill.minder.client.config;

import com.skyquill.minder.client.Cache;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;

public class SOSCardTypeView extends ConfigurationAbstractView {

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
        	SOSCardTypeView panel = new SOSCardTypeView();
            id = panel.getID();
            return panel;
        }

        public String getID() {
            return id;
        }

    }

	public SOSCardTypeView() {
	}

	@Override
	public Canvas getViewPanel() {

		VLayout vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		
		listGrid.setDataSource(Cache.getSosCardTypeDataSource());

		ListGridField code = new ListGridField("code", "Code");  
		code.setWidth(100);
		
		ListGridField desc = new ListGridField("desc", "Description");  
		desc.setWidth(170);

		listGrid.setFields(code, desc);  

		vLayout.addMember(listGrid); 
		
		return vLayout;
	}

}
