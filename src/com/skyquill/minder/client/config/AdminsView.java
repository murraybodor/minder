package com.skyquill.minder.client.config;

import com.skyquill.minder.client.Cache;
import com.skyquill.minder.client.util.VH;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;

public class AdminsView extends ConfigurationAbstractView {

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
        	AdminsView panel = new AdminsView();
            id = panel.getID();
            return panel;
        }

        public String getID() {
            return id;
        }

    }

	public AdminsView() {
	}

	@Override
	public Canvas getViewPanel() {

		VLayout vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		
		listGrid.setDataSource(Cache.getAdminsDataSource());

		ListGridField firstName = new ListGridField("firstName", "First Name");  
		firstName.setWidth(100);
		
		ListGridField lastName = new ListGridField("lastName", "Last Name");  
		lastName.setWidth(100);

		ListGridField email = new ListGridField("emailAddress", "Email");  
		email.setWidth(170);

		ListGridField officePhone = new ListGridField("officePhone", "Office Phone");  
		officePhone.setWidth(100);

		ListGridField cellPhone = new ListGridField("cellPhone", "Cell Phone");  
		cellPhone.setWidth(100);
		
		ListGridField auditDatetime = VH.createAuditDateTimeField();
		ListGridField auditUserid = VH.createAuditUserIdField();

		listGrid.setFields(firstName, lastName, email, officePhone, cellPhone, auditDatetime, auditUserid);  

		vLayout.addMember(listGrid); 
		
		return vLayout;
	}

}
