package com.hcl.project.dao;

import java.util.List;

import com.hcl.project.model.Comment;

public interface CommentDAO {
	
	boolean addComment(Comment comment);

	List<Comment> getAllComments(int postId);
}
