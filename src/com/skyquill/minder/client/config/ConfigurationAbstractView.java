package com.skyquill.minder.client.config;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.VLayout;

public abstract class ConfigurationAbstractView extends VLayout {

	ListGrid listGrid = new ListGrid();  
	
	public ConfigurationAbstractView() {

		setWidth100();
		setHeight100();

		Layout layout = new HLayout();

		layout.setWidth100();
		layout.setMargin(10);
		layout.setMembersMargin(10);

		listGrid.setHeight(300);
		listGrid.setAlternateRecordStyles(true);  
		listGrid.setCanEdit(true);  
		listGrid.setEditEvent(ListGridEditEvent.CLICK);  
		listGrid.setAutoFetchData(true);
		listGrid.setAutoSaveEdits(false);  
		listGrid.setModalEditing(true);
		
		Canvas panel = getViewPanel();
		
		HLayout wrapper = new HLayout();
		wrapper.setWidth100();
		wrapper.addMember(panel);

		layout.addMember(wrapper);
		addMember(layout);
		
		Canvas buttonPanel = getButtonPanel();
		addMember(buttonPanel);
		
	}

	public abstract Canvas getViewPanel();

	public Canvas getButtonPanel() {
		
		HLayout buttonLayout = new HLayout();
		buttonLayout.setWidth100();
		buttonLayout.setMargin(10);
		buttonLayout.setMembersMargin(20);
		buttonLayout.setAlign(Alignment.CENTER);
		
		IButton editButton = new IButton("Add New");  
		editButton.addClickHandler(new ClickHandler() {  
			public void onClick(ClickEvent event) {  
				listGrid.startEditingNew();  
			}  
		});  
		buttonLayout.addMember(editButton);  

		IButton saveButton = new IButton("Save");  
		saveButton.addClickHandler(new ClickHandler() {  
			public void onClick(ClickEvent event) {  
				listGrid.saveAllEdits();  
			}  
		});  
		buttonLayout.addMember(saveButton);  

		IButton discardButton = new IButton("Discard");  
		discardButton.addClickHandler(new ClickHandler() {  
			public void onClick(ClickEvent event) {  
				listGrid.discardAllEdits();  
			}  
		});  
		buttonLayout.addMember(discardButton); 

		return buttonLayout;
		
	}
}
