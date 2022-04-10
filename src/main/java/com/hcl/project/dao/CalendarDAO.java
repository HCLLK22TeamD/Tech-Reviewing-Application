package com.hcl.project.dao;

import java.util.List;

import com.hcl.project.model.CalendarItem;

public interface CalendarDAO {
	
	List<CalendarItem> getAirDateList();

}
