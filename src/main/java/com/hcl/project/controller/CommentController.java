package com.hcl.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.project.dao.CommentDAO;
import com.hcl.project.model.Comment;
import com.hcl.project.model.User;

@Controller
@RequestMapping("/posts")
public class CommentController {
	
	@Autowired
	private CommentDAO commentDAO;

	
	@PostMapping("/view")
	public ModelAndView addComment(@RequestParam int id, @ModelAttribute("comment") Comment comment, HttpSession session, ModelAndView model) {
		System.out.println("comment:"+comment);
		
		model.setViewName("redirect:/posts/view?id="+comment.getPostId());
		
		if(session.getAttribute("user") != null) {
			User currentUser = (User) session.getAttribute("user");
			comment.setUser(currentUser.getFirstName()+" "+currentUser.getLastName());
			
			boolean success = commentDAO.addComment(comment);
			System.out.println("comment success:"+success);
			
		}else {
			model.addObject("commnetErrorMsg", "login is required to add comments.");
		}
		
		return model;
	}

}
