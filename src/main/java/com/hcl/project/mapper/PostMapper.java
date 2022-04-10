package com.hcl.project.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hcl.project.model.Post;

public class PostMapper implements RowMapper<Post>{

	@Override
	public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return new Post(
				rs.getInt("post_id"), 
				rs.getString("title"), 
				rs.getString("content"), 
				rs.getString("category"), 
				rs.getString("sub_category"), 
				rs.getString("cover"),
				rs.getInt("author"),
				rs.getInt("likes"), 
				rs.getInt("views"), 
				rs.getBoolean("has_airdate"),
				rs.getDate("airdate"),
				rs.getDate("created_at"));
	}

}
