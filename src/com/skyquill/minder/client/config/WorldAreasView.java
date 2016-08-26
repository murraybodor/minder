package com.skyquill.minder.client.config;

import com.skyquill.minder.client.Cache;
import com.skyquill.minder.client.util.VH;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;

public class WorldAreasView extends ConfigurationAbstractView {

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
        	WorldAreasView panel = new WorldAreasView();
            id = panel.getID();
            return panel;
        }

        public String getID() {
            return id;
        }

    }

    public WorldAreasView() {
	}

	@Override
	public Canvas getViewPanel() {

		VLayout vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		
		listGrid.setDataSource(Cache.getWorldAreasDataSource());  

		ListGridField name = new ListGridField("name", "World Area");  
		name.setWidth(150);

		ListGridField auditDatetime = VH.createAuditDateTimeField();
		ListGridField auditUserid = VH.createAuditUserIdField();

		listGrid.setFields(name, auditDatetime, auditUserid);  

		vLayout.addMember(listGrid); 
		
		return vLayout;
		
	}

}
