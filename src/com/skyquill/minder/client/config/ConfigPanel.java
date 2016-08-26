package com.skyquill.minder.client.config;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.VLayout;

public abstract class ConfigPanel extends VLayout {

	public ConfigPanel() {

		setWidth100();
		setHeight100();

		Layout layout = new HLayout();

		layout.setWidth100();
		layout.setMargin(10);
		layout.setMembersMargin(10);

		Canvas panel = getViewPanel();
		HLayout wrapper = new HLayout();
		wrapper.setWidth100();
		wrapper.addMember(panel);

		layout.addMember(wrapper);
		addMember(layout);
	}

	public abstract Canvas getViewPanel();

}
