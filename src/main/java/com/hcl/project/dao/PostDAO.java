package com.hcl.project.dao;

import java.util.List;

import com.hcl.project.model.Post;

public interface PostDAO {
	
	Post getPostById(int id);
	
	List<Post> getAllPosts();
	
	List<Post> getAllPosts(int author);
	
	Boolean createPost(Post post) throws Exception;
	
	Boolean updatePost(Post post) throws Exception;
	
	Boolean deletePost(int id);

}
