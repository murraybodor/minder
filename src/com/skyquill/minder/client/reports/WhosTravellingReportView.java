package com.skyquill.minder.client.reports;

import com.skyquill.minder.client.config.PanelFactory;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.VLayout;

public class WhosTravellingReportView extends ReportAbstractView {

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
        	WhosTravellingReportView panel = new WhosTravellingReportView();
            id = panel.getID();
            return panel;
        }

        public String getID() {
            return id;
        }

    }

	public WhosTravellingReportView() {
	}

	@Override
	public Canvas getViewPanel() {

		VLayout vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		
		Label parmLabel1 = new Label("Whos Travelling Report Parm 1");
		vLayout.addMember(parmLabel1);
		
//		listGrid.setDataSource(Cache.getAirportsDataSource());
//
//		ListGridField iataCode = new ListGridField("iataCode", "Code");  
//		iataCode.setWidth(50);
//		
//		ListGridField name = new ListGridField("name", "Airport Name");  
//		name.setWidth(160);
//		
//		ListGridField city = new ListGridField("cityId", "City");
//		city.setOptionDataSource(Cache.getCitiesDataSource());
//		city.setValueField("id");
//		city.setDisplayField("name");
//		city.setWidth(110);
//		
//		ListGridField description = new ListGridField("description", "Description");  
//		description.setWidth(200);
//
//		ListGridField latitude = new ListGridField("latitude", "Latitude");  
//		latitude.setWidth(75);
//
//		ListGridField longitude = new ListGridField("longitude", "Longitude");  
//		longitude.setWidth(75);
//
//		ListGridField auditDatetime = VH.createAuditDateTimeField();
//		ListGridField auditUserid = VH.createAuditUserIdField();
//
//		listGrid.setFields(iataCode, name, city, description, latitude, longitude, auditDatetime, auditUserid);  
//
//		vLayout.addMember(listGrid); 
		
		
		return vLayout;
		
	}

	@Override
	protected boolean validateParms() {
		// TODO Auto-generated method stub
		return false;
	}

}
