package com.hcl.project.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hcl.project.model.UserPost;

public class UserPostMapper implements RowMapper<UserPost>{

	@Override
	public UserPost mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return new UserPost(
				rs.getInt("user_id"),
				rs.getInt("post_id"),
				rs.getBoolean("is_like"),
				rs.getBoolean("is_favorite"));
	}

}
