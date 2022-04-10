package com.hcl.project.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hcl.project.model.User;

public class UserMapper implements RowMapper<User>{

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		return new User(
				rs.getInt("id"),
				rs.getString("first_name"), 
				rs.getString("last_name"), 
				rs.getString("gender"), 
				rs.getString("email"), 
				rs.getString("mobile"), 
				rs.getString("password"),
				rs.getInt("user_role"));

	}
	

}
