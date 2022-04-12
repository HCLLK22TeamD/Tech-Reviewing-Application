package com.hcl.project.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.hcl.project.dao.PostDAO;
import com.hcl.project.mapper.PostMapper;
import com.hcl.project.mapper.UserPostMapper;
import com.hcl.project.model.Post;
import com.hcl.project.model.UserPost;

public class PostDAOImpl implements PostDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public PostDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Post getPostById(int id) throws DataAccessException {
		String query = "SELECT * FROM posts WHERE post_id = ?";
		return jdbcTemplate.queryForObject(query, new PostMapper(), id);
	}

	@Override
	public List<Post> getAllPosts() {
		String query = "SELECT * FROM posts";
		return jdbcTemplate.query(query, new PostMapper());	
	}

	@Override
	public List<Post> getAllPosts(int author) {
		String query = "SELECT * FROM posts WHERE author = ?";
		return jdbcTemplate.query(query, new PostMapper(), author);	
	}

	@Override
	public Boolean createPost(Post post) throws Exception {
		String query = "INSERT INTO posts (title, content, category, sub_category, cover, author, has_airdate, airdate, created_at ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
			String postCreated = dateFormat.format(post.getCreatedAt());
			Object postAirDate = null;
			if(post.getAirDate() != null) {
				postAirDate = dateFormat.format(post.getAirDate());
				postAirDate = dateFormat.parse((String)postAirDate);
			}

			Object[] params = new Object[] {
				post.getTitle(),
				post.getContent(),
				post.getCategory(),
				post.getSubCategory(),
				post.getCover(),
				post.getAuthor(),
				post.isHasAirDate(),
				postAirDate,
				dateFormat.parse(postCreated)
				};
		
			int result = jdbcTemplate.update(query, params);
			
			System.out.println("post created success:"+result);
			return true;
			
		} catch (ParseException e) {
			System.out.println(">> ERROR: "+e.getMessage());
			return false;
		}
	}

	@Override
	public Boolean updatePost(Post post) throws Exception {
		String query = "UPDATE posts SET title = ?, content = ?, category = ?, sub_category = ?, cover = ?, has_airdate = ?, airdate = ? WHERE post_id = ?";
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		Object postAirDate = null;
		if(post.getAirDate() != null) {
			postAirDate = dateFormat.format(post.getAirDate());
			postAirDate = dateFormat.parse((String)postAirDate);
		}
		Object[] params = new Object[] {
				post.getTitle(),
				post.getContent(),
				post.getCategory(),
				post.getSubCategory(),
				post.getCover(),
				post.isHasAirDate(),
				postAirDate,
				post.getId()
				};
		
		int result = jdbcTemplate.update(query, params);
		
		if(result > 0) {
			return true;
		}else {
			return true;
		}
	}

	@Override
	public Boolean deletePost(int id) {
		String query = "DELETE FROM posts WHERE post_id = ?";
		int result = jdbcTemplate.update(query, id);
		if(result > 0) {
			return true;
		}else {
			return false;
		}
	}

	
//	handle likes , favorite, views
	
	@Override
	public Boolean changeLike(int id, int userId, int views) {
		
		String queryFind = "SELECT * FROM user_post where user_id = ? and post_id = ?";
		String queryUpdate = "UPDATE user_post set is_like = ? where user_id = ? and post_id = ?";
		String queryInsert = "INSERT INTO user_post (user_id, post_id, is_like, is_favorite) VALUES (?, ?, ?, ?)";
		
		try {
			UserPost userPost = (UserPost) jdbcTemplate.queryForObject(queryFind, new UserPostMapper(), userId, id);
			
			Object[] params = new Object[] {!userPost.getIsLike(), userId, id};
			int result = jdbcTemplate.update(queryUpdate, params);
			
			if(result > 0) {
				if(userPost.getIsLike()) {
					views++;
				}else {
					views--;
				}
				calcViews(id, views);
				return true;
			}else {
				return false;
			}
			
		}catch (EmptyResultDataAccessException e) {
			Object[] params = new Object[] {userId, id, true, false};
			int result = jdbcTemplate.update(queryInsert, params);
			if(result > 0) {
				views++;
				calcViews(id, views);
				return true;
			}else {
				return false;
			}
			
		}catch (DataAccessException e) {
			System.out.println(">> JDBC ERROR: "+e.getMostSpecificCause());
			return false;
		}
	}
	
	
	public Boolean calcViews(int id, int views) {
		String query = "UPDATE posts SET likes = ?, views = ? WHERE post_id = ?";
		Object[] params = new Object[] {views, views, id};
		int result = jdbcTemplate.update(query, params);
		if(result > 0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Boolean changeFavorite(int id, int userId) {
		String queryFind = "SELECT * FROM user_post where user_id = ? and post_id = ?";
		String queryUpdate = "UPDATE user_post set is_favorite = ? where user_id = ? and post_id = ?";
		String queryInsert = "INSERT INTO user_post (user_id, post_id, is_like, is_favorite) VALUES (?, ?, ?, ?)";
		
		try {
			UserPost userPost = (UserPost) jdbcTemplate.queryForObject(queryFind, new UserPostMapper(), userId, id);
			
			Object[] params = new Object[] {!userPost.getIsFavorite(), userId, id};
			int result = jdbcTemplate.update(queryUpdate, params);
			if(result > 0) {
				return true;
			}else {
				return false;
			}
			
		}catch (EmptyResultDataAccessException e) {
			Object[] params = new Object[] {userId, id, false, true};
			int result = jdbcTemplate.update(queryInsert, params);
			if(result > 0) {
				return true;
			}else {
				return false;
			}
			
		}catch (DataAccessException e) {
			System.out.println(">> JDBC ERROR: "+e.getMostSpecificCause());
			return false;
		}
	}

	@Override
	public UserPost getUserPost(int id, int userId) {
		String query = "SELECT * FROM user_post WHERE user_id = ? and post_id = ?";
		Object[] params = new Object[] {userId, id};
		return jdbcTemplate.queryForObject(query, new UserPostMapper(), params);
	}
	
	

}
