package com.hcl.project.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hcl.project.model.Comment;

public class CommentMapper implements RowMapper<Comment>{

	@Override
	public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {

		return new Comment(
				rs.getString("message"),
				rs.getInt("post_id"),
				rs.getString("commenter"));
	}

}
