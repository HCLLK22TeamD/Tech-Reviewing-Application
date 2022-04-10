package com.hcl.project.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.hcl.project.dao.CommentDAO;
import com.hcl.project.mapper.CommentMapper;
import com.hcl.project.model.Comment;

public class CommentDAOImpl implements CommentDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public CommentDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean addComment(Comment comment) {
		String query = "INSERT INTO comments (message, post_id, commenter) VALUES (?, ?, ?)";

		Object[] params = new Object[] {
			comment.getMessage(),
			comment.getPostId(),
			comment.getUser(),
			};
	
		int result = jdbcTemplate.update(query, params);
		
		if(result > 0) {
			System.out.println("post created success:"+result);
			return true;
		}
		return false;
	}

	@Override
	public List<Comment> getAllComments(int postId) {
		String query = "SELECT * FROM comments WHERE post_id = ?";
		return jdbcTemplate.query(query, new CommentMapper(), postId);	
	}

}
