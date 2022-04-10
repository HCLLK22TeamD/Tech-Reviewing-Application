package com.hcl.project.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.project.dao.CalendarDAO;
import com.hcl.project.model.CalendarItem;

@Controller
public class CalendarController {
	
	@Autowired
	private CalendarDAO calendarDAO;
	
	@RequestMapping("/calendar")
	public ModelAndView CalenderRequest(ModelAndView model) throws ParseException {
		System.out.println("Calendar view fired!");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		
		List<CalendarItem> airdates = calendarDAO.getAirDateList();
		
		for (CalendarItem item : airdates) {
			String date = dateFormat.format(item.getAirDate());
			LocalDate localDate = dateFormat.parse(date).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			item.setMonth(localDate.getMonth().toString());
			item.setYear(localDate.getYear());
			System.out.println("airdates "+ localDate.getMonth().toString()+" "+localDate.getYear());
		}
		
		Map<String, List<CalendarItem>> calendar = airdates.stream().collect(Collectors.groupingBy(c -> c.getMonth()+" "+c.getYear()));
		System.out.println("calendar: "+calendar);
		
		model.setViewName("calendar");
		model.addObject("calendar",calendar);
		return model;
	}
	
	

}
