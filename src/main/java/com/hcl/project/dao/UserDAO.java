package com.hcl.project.dao;

import java.util.List;

import com.hcl.project.exceptions.UserValidateException;
import com.hcl.project.model.User;

public interface UserDAO  {
	
	User getUserByUsername(String username);
	
	User getUserById(int id);
	
	User verifyUser(String username, String password);
	
	List<User> getAllUsersByRole(int roleId);
	
	Boolean createUser(User user) throws Exception;
	
	Boolean updateUser(User user);
	
	Boolean deleteUser(String username);
	
	
	
	List<String> getUserRoles(String username);

}
