package com.hcl.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.project.dao.PostDAO;
import com.hcl.project.model.Post;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private PostDAO postDAO;
	
	@RequestMapping("")
	public ModelAndView getAllPosts(ModelAndView model) {
		try {
			List<Post> postList = postDAO.getAllPosts();
			System.out.println("post list: "+ postList);
			model.addObject("postList", postList);
			
		}catch (DataAccessException e) {
			System.out.println(">> JDBC ERROR: "+e.getMessage());
			model.addObject("errorMsg", "Sorry..unable to fetch the post data.");
		}
		
		model.setViewName("home");
		return model;
	}
}
