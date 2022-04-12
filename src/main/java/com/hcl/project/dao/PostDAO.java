package com.hcl.project.dao;

import java.util.List;

import com.hcl.project.model.Post;
import com.hcl.project.model.UserPost;

public interface PostDAO {
	
	Post getPostById(int id);
	
	List<Post> getAllPosts();
	
	List<Post> getAllPosts(int author);
	
	Boolean createPost(Post post) throws Exception;
	
	Boolean updatePost(Post post) throws Exception;
	
	Boolean deletePost(int id);
	
	Boolean changeLike(int id, int userId, int views);
	Boolean changeFavorite(int id, int userId);
	Boolean calcViews(int id, int views);
	
	UserPost getUserPost(int id, int userId);
}
