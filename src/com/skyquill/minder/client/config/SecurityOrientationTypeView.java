package com.skyquill.minder.client.config;

import com.skyquill.minder.client.Cache;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;

public class SecurityOrientationTypeView extends ConfigurationAbstractView {

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
        	SecurityOrientationTypeView panel = new SecurityOrientationTypeView();
            id = panel.getID();
            return panel;
        }

        public String getID() {
            return id;
        }

    }

	public SecurityOrientationTypeView() {
	}

	@Override
	public Canvas getViewPanel() {

		VLayout vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		
		listGrid.setDataSource(Cache.getSecOrientTypeDataSource());

		ListGridField code = new ListGridField("code", "Code");  
		code.setWidth(100);
		
		ListGridField desc = new ListGridField("desc", "Description");  
		desc.setWidth(170);

		listGrid.setFields(code, desc);  

		vLayout.addMember(listGrid); 
		
		return vLayout;
	}

}
