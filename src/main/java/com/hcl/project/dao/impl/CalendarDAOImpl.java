package com.hcl.project.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.hcl.project.dao.CalendarDAO;
import com.hcl.project.mapper.CalendarMapper;
import com.hcl.project.mapper.PostMapper;
import com.hcl.project.model.CalendarItem;
import com.hcl.project.model.Post;

public class CalendarDAOImpl implements CalendarDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public CalendarDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<CalendarItem> getAirDateList() {
		String query = "SELECT * FROM posts WHERE has_airdate = 1 ORDER BY airdate ASC";
		return jdbcTemplate.query(query, new CalendarMapper());	
	}


}
