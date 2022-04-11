package com.hcl.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.project.dao.UserDAO;
import com.hcl.project.exceptions.UserValidateException;
import com.hcl.project.model.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDAO userDAO;
	

	@GetMapping("/register")
	public ModelAndView showRegisterPage(User user, ModelAndView model) {
		model.addObject("user", user);
		model.setViewName("register");
		return model;
	}

	@PostMapping("/register")
	public ModelAndView registerUser(@ModelAttribute("user") User user, ModelAndView model) {
		
		model.setViewName("register");
		try {
			Boolean result = userDAO.createUser(user);
			if (result) {
				model.addObject("successMsg", "You have successfully registerd with us.");
			}
			
		} catch (UserValidateException e) {
			System.out.println(">> VALIDATION ERROR: "+e.getMessage());
			model.addObject("errorMsg", e.getMessage());
			
		}catch (DataAccessException e) {
			System.out.println(">> JDBC ERROR: "+e.getMessage());
			String error = e.getMostSpecificCause().toString();
			
			if(error.contains("java.sql.SQLIntegrityConstraintViolationException") && error.contains("USERS_EMAIL_UK")) {
				model.addObject("errorMsg", "your email is already exists.");
				
			}else if(error.contains("java.sql.SQLIntegrityConstraintViolationException") && error.contains("USERS_MOBILE_UK")) {
				model.addObject("errorMsg", "your mobile is already exists.");
			}
			else {
				model.addObject("errorMsg", e.getMostSpecificCause());
			}
			
		}catch (Exception e) {
			System.out.println(">> ERROR: "+e.getMessage());
			model.addObject("errorMsg", e.getLocalizedMessage());
		}
		return model;	
	}

	@GetMapping("/login")
	public ModelAndView showLoginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, ModelAndView model) {
	
		System.out.println("login fired!");

		if (error != null) {
			model.addObject("error", "Invalid Credentials provided.");
		}

		if (logout != null) {
			model.addObject("successMsg", "Logged out successfully.");
		}
		model.setViewName("login");

		return model;
	}

	@PostMapping("/login")
	public ModelAndView userLogin(@RequestParam("username") String username, @RequestParam("password") String password, ModelAndView model, HttpSession session) {
		model.setViewName("login");
		try {
			User user= userDAO.verifyUser(username, password);
			System.out.println("matched user:"+user);
			
			if(user != null) {
				if(user.getRole() == 1 || user.getRole() == 2) {
					session.setAttribute("username", user.getEmail());
					session.setAttribute("user_role", user.getRole());
					session.setAttribute("user", user);
	
					model.setViewName("redirect:/home");
				}
			}else {
				model.addObject("errorMsg", "User not found.");
			}
			
		}catch (EmptyResultDataAccessException e) {
			model.addObject("errorMsg", "email or password cannot be empty.");

		}catch (DataAccessException e) {
			model.addObject("errorMsg", "Cannot login due to database error.");
		}
		catch (Exception e) {
			model.addObject("errorMsg", e.getLocalizedMessage());
		}
		return model;
	}
	
	@RequestMapping("/logout")
	public String userLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/user/login";
	}

	
	@GetMapping("/profile")
	public ModelAndView showProfile(ModelAndView model, HttpSession session) {
		model.setViewName("profile");
		
		User currentUser = (User) session.getAttribute("user");
		if(currentUser != null) {
			model.addObject("user", currentUser);
		}else {
			model.setViewName("login");
			model.addObject("errorMsg", "Session out, please login again.");
		}	
		return model;
	}
	
	@PostMapping("/profile")
	public ModelAndView updateProfile(@ModelAttribute("user") User user, ModelAndView model) {
		model.setViewName("profile");
		
		try {
			boolean success = userDAO.updateUser(user);
			if(success) {
				model.addObject("successMsg", "Your profile successfully updated.");
			}else {
				model.addObject("errorMsg", "profile updating failed.");
			}
			
		} catch (Exception e) {
			System.out.println(">> ERROR: "+e.getMessage());
			model.addObject("errorMsg", e.getLocalizedMessage());
		}
		return model;
	}
	
	@RequestMapping("/profile/delete")
	public ModelAndView deleteProfile(@RequestParam int id, ModelAndView model, HttpSession session) {
		try {
			userDAO.deleteUser(id);
			session.invalidate();
			model.setViewName("login");
			
		}catch (Exception e) {
			model.setViewName("redirect:/user/profile");
			model.addObject("errorMsg", "Account deleting failed. "+e.getLocalizedMessage());
		}
		return model;
	}
}
