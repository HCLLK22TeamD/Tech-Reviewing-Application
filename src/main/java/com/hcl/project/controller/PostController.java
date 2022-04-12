package com.hcl.project.controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.project.dao.CommentDAO;
import com.hcl.project.dao.PostDAO;
import com.hcl.project.dao.UserDAO;
import com.hcl.project.exceptions.PostValidationException;
import com.hcl.project.model.Comment;
import com.hcl.project.model.Post;
import com.hcl.project.model.User;
import com.hcl.project.model.UserPost;

@Controller
@RequestMapping("/posts")
public class PostController {
	
//	private static final String COVER_UPLOAD_DIRECTORY ="/images"; 
	
	@Autowired
	private PostDAO postDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private CommentDAO commentDAO;
	
	@Autowired
	ServletContext servletContext;
	

	@GetMapping("/new-post")
	public ModelAndView showCreatePost(ModelAndView model, HttpSession session) {
		
		if(session.getAttribute("user") != null && (int) session.getAttribute("user_role") == 1) {
			model.setViewName("createPost");
			model.addObject("post", new Post());
		}else {
			model.setViewName("login");
			model.addObject("errorMsg", "please login with a publisher account.");
		}	
		return model;
	}

	
	@PostMapping("/new-post")
	public ModelAndView createPost(@ModelAttribute("post") Post post, ModelAndView model, HttpSession session) throws Exception {
		System.out.println("create post fired!");    
		
		MultipartFile imageFile = post.getCoverImage();
		
		System.out.println("file:"+imageFile+","+imageFile.isEmpty());
		
		if(imageFile != null && !imageFile.isEmpty()) {
			String imagePath = servletContext.getRealPath("/")
					+"WEB-INF"+File.separator+"resources"+File.separator+"post_covers"+File.separator+"post_"+ imageFile.getOriginalFilename();
		    System.out.println("image path:"+imagePath);
			imageFile.transferTo(new File(imagePath));
			post.setCover("post_"+ imageFile.getOriginalFilename());
		}
		System.out.println("post: " + post);
		
		try {
			User currentUser = (User) session.getAttribute("user");
			post.setAuthor(currentUser.getId());
			Boolean result = postDAO.createPost(post);
			if (result) {
				model.addObject("result", "success");
			} else {
				model.addObject("result", "failed");
			}
			
		} catch (PostValidationException e) {
			System.out.println("VALIDATION ERROR: "+e.getMessage());
			model.addObject("errorMsg", e.getMessage());

		}catch (DataAccessException e) {
			System.out.println(">> JDBC ERROR: "+e.getMessage());
			model.addObject("errorMsg", e.getMostSpecificCause());
			model.addObject("result", "failed");
			
		}catch (Exception e) {
			System.out.println(">> ERROR: "+e.getMessage());
			model.addObject("errorMsg", "Post creation failed due to internal error");
		}
		
		model.setViewName("createPost");
		return model;	
	}
	
	
	@RequestMapping("/view")
	public ModelAndView showPost(@RequestParam int id, ModelAndView model, HttpSession session) {
		System.out.println("post id:"+id);
		User currentUser = (User) session.getAttribute("user");
		model.setViewName("post");
		try {
			Post post = postDAO.getPostById(id);
			try {
				User author = userDAO.getUserById(post.getAuthor());
				model.addObject("author",author.getFirstName()+" "+author.getLastName());
				
				List<Comment> commentList = commentDAO.getAllComments(id);
				model.addObject("commentList", commentList);
				
				try {
					UserPost userPost = postDAO.getUserPost(id, currentUser.getId());
					model.addObject("isLike", userPost.getIsLike());
					model.addObject("isFavorite", userPost.getIsFavorite());

				}catch (EmptyResultDataAccessException e) {
					model.addObject("isLike", false);
					model.addObject("isFavorite", false);
					
				}catch (Exception e) {
					System.out.println(">> USER-POST JDBC ERROR: "+e.getMessage());
					model.addObject("errorMsg", "please, login first before add like or comment ot this post.");
				}
				
			}catch (DataAccessException e) {
				System.out.println(">> JDBC ERROR: "+e.getMessage());
				model.addObject("errorMsg", "the author of the post no longer available.");
			}
			model.addObject("post", post);
			
		}catch (DataAccessException e) {
			System.out.println(">> JDBC ERROR: "+e.getMessage());
			model.addObject("errorMsg", "this tech post has been deleted or moved.");
		}
		
		model.addObject("comment", new Comment());
		return model;
	}
	
	
	@RequestMapping("/view/{id}/like")
	public ModelAndView addLike(@PathVariable int id, @RequestParam("v") int views,  ModelAndView model, HttpSession session) {
		User currentUser = (User) session.getAttribute("user");
		try {
			postDAO.changeLike(id, currentUser.getId(), views);
		}catch (Exception e) {
			model.addObject("errorMsg", "login is required to add like to this post.");
		}
		model.setViewName("redirect:/posts/view?id="+id);
		return model;
	}
	
	@RequestMapping("/view/{id}/favorite")
	public ModelAndView addFavorite(@PathVariable int id, ModelAndView model, HttpSession session) {
		User currentUser = (User) session.getAttribute("user");
		try {
			postDAO.changeFavorite(id, currentUser.getId());
		}catch (Exception e) {
			model.addObject("errorMsg", "login is required to add favorite this post.");
		}
		model.setViewName("redirect:/posts/view?id="+id);
		return model;
	}
	
		
	@RequestMapping("/manage")
	public ModelAndView managePost(ModelAndView model, HttpSession session) {
		
		model.setViewName("managePost");
		System.out.println("message: "+servletContext.getAttribute("message"));
		try {		
			User currentUser = (User) session.getAttribute("user");
			if(currentUser != null) {
				List<Post> postList = postDAO.getAllPosts(currentUser.getId());
				System.out.println("post list: "+ postList);
				model.addObject("postList", postList);
				
			}else {
				model.setViewName("login");
				model.addObject("errorMsg", "session out, please login again.");
			}	
			
		}catch (DataAccessException e) {
			System.out.println(">> JDBC ERROR: "+e.getMessage());
			model.addObject("errorMsg", "Sorry..unable to fetch the post data.");
		}
		return model;
	}
	
	
	@RequestMapping("/update")
	public ModelAndView updatePost(@RequestParam int id, ModelAndView model) {
		
		Post updatePost = postDAO.getPostById(id);
		if(updatePost != null) {
			model.addObject("post", updatePost);
			model.setViewName("createPost");
		}else {
			model.addObject("errorMsg", "Post id not found.");
			model.setViewName("managePost");
		}
		return model;
	}
	
	@PostMapping("/update")
	public ModelAndView createPost(@ModelAttribute("post") Post post, ModelAndView model) {
		System.out.println("update post fired!"+post);

		boolean success;
		try {
			success = postDAO.updatePost(post);
			if(success) {
				model.setViewName("redirect:/posts/manage");
				model.addObject("successMsg", "Post Successfully updated.");
			}else {
				model.setViewName("redirect:/posts/update?id="+post.getId());
				model.addObject("errorMsg", "post updating failed.");
			}
			
		} catch (Exception e) {
			System.out.println(">> ERROR: "+e.getMessage());
			model.setViewName("redirect:/posts/update?id="+post.getId());
			model.addObject("errorMsg", e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("/delete")
	public ModelAndView deletePost(@RequestParam int id, ModelAndView model) {
		boolean success = postDAO.deletePost(id);
		if(success) {
			model.addObject("successMsg", "Post successfully deleted.");
		}else{
			model.addObject("errorMsg", "Post deleing failed.");
		}
		model.setViewName("redirect:/posts/manage");
		return model;
	}
	

}
