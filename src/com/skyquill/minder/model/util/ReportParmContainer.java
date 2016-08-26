package com.skyquill.minder.model.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ReportParmContainer implements Serializable {

	private static final long serialVersionUID = 7526472295622774187L;
	
	private Map<String, String> parmStringMap = new LinkedHashMap<String, String>();
	private Map<String, Date> parmDateMap = new LinkedHashMap<String, Date>();
	private List<String> columns = new ArrayList<String>();
	
	public ReportParmContainer() {
	}
	
	public Map<String, Date> getParmDateMap() {
		return parmDateMap;
	}

	public Date getDateParm(String key) {
		if (parmDateMap.containsKey(key))
			return parmDateMap.get(key);
		else
			return null;
	}
	public String getStringParm(String key) {
		if (parmStringMap.containsKey(key))
			return parmStringMap.get(key);
		else
			return null;
	}
	public void setParmDateMap(Map<String, Date> parmDateMap) {
		this.parmDateMap = parmDateMap;
	}
	
	public Map<String, String> getParmStringMap() {
		return parmStringMap;
	}

	public void setParmStringMap(Map<String, String> parmStringMap) {
		this.parmStringMap = parmStringMap;
	}
	
	public void addDateParm(String key, Date value) {
		this.parmDateMap.put(key, value);
	}
	public void addStringParm(String key, String value) {
		this.parmStringMap.put(key, value);
	}

	public List<String> getColumns() {
		return columns;
	}

	public void setColumns(List<String> columns) {
		this.columns = columns;
	}
	
	public void addColumn(String colName) {
		this.columns.add(colName);
	}

}
