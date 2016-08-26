package com.skyquill.minder.client.config;

import com.skyquill.minder.client.Cache;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;

public class BloodTypeView extends ConfigurationAbstractView {

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
        	BloodTypeView panel = new BloodTypeView();
            id = panel.getID();
            return panel;
        }

        public String getID() {
            return id;
        }

    }

	public BloodTypeView() {
	}

	@Override
	public Canvas getViewPanel() {

		VLayout vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		
		listGrid.setDataSource(Cache.getBloodTypeDataSource());

		ListGridField code = new ListGridField("code", "Code");  
		code.setWidth(100);
		
		ListGridField desc = new ListGridField("desc", "Description");  
		desc.setWidth(170);

		listGrid.setFields(code, desc);  

		vLayout.addMember(listGrid); 
		
		return vLayout;
	}

}
