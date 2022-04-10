package com.hcl.project.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hcl.project.model.CalendarItem;

public class CalendarMapper implements RowMapper<CalendarItem>{

	@Override
	public CalendarItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return new CalendarItem(
				rs.getString("title"),
				rs.getString("category"), 
				rs.getString("sub_category"), 
				rs.getString("author"),
				rs.getInt("post_id"),
				rs.getDate("airdate"));
	}

}
