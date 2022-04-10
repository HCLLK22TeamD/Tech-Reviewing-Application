package com.hcl.project.dao.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.hcl.project.dao.UserDAO;
import com.hcl.project.exceptions.UserValidateException;
import com.hcl.project.mapper.LoginMapper;
import com.hcl.project.mapper.UserMapper;
import com.hcl.project.model.User;

public class UserDAOImpl implements UserDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public User getUserByUsername(String username) {
		String query = "SELECT email,password FROM users WHERE email = ?";
		return jdbcTemplate.queryForObject(query, new LoginMapper(), username);
	}
	
	@Override
	public User getUserById(int id) {
		String query = "SELECT * FROM users WHERE id = ?";
		return jdbcTemplate.queryForObject(query, new UserMapper(), id);
	}
	
	@Override
	public User verifyUser(String username, String password) throws EmptyResultDataAccessException{
		String query = "SELECT * FROM users WHERE email = ?";
		User u = jdbcTemplate.queryForObject(query, new UserMapper(), username);
		boolean validPassword = passwordEncoder.matches(password, u.getPassword());
		if(validPassword) {
			return u;
		}
		return null;
	}

	public List<User> getAllUsersByRole(int roleId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void validateUser(User user) throws UserValidateException{
		System.out.println("user validating...");
		String queryCheckEmail = "Select * FROM users WHERE email = ?";
//		String queryCheckMobile = "Select * FROM users WHERE mobile = ?";
		
		User validEmail = jdbcTemplate.queryForObject(queryCheckEmail, new UserMapper(),user.getEmail());	
		if(validEmail != null) {
			throw new UserValidateException("Email address is already exits.");
		}
//		User validMobile = jdbcTemplate.queryForObject(queryCheckMobile, new UserMapper(),user.getMobile());
//		if(validMobile != null) {
//			throw new UserValidateException("Mobile number is already exits.");
//		}
	}

	public Boolean createUser(User user) throws Exception {
		String query = "INSERT INTO users (first_name, last_name, email, mobile, gender, password, user_role, created_at ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//		String query_insert_role = "INSERT INTO user_roles (username, type) VALUES (?, ?)";
	
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		String currentDate = dateFormat.format(user.getCreatedAt());
		
//		validateUser(user);

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		Object[] params = new Object[] {
			user.getFirstName(),
			user.getLastName(),
			user.getEmail(),
			user.getMobile(),
			user.getGender(),
			user.getPassword(),
			user.getRole(),
			dateFormat.parse(currentDate)
			};
	
		int result = jdbcTemplate.update(query, params);
		
		if(result > 0) {
			return true;
		}else {
			return false;
		}	
	}

	public Boolean updateUser(User user) {
		String query = "UPDATE users SET first_name = ?, last_name = ?, email = ?, mobile = ?, gender = ?, password = ?, user_role = ? WHERE email = ?";

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		Object[] params = new Object[] {
				user.getFirstName(),
				user.getLastName(),
				user.getEmail(),
				user.getMobile(),
				user.getGender(),
				user.getPassword(),
				user.getRole(),
				user.getEmail(),
				};
		
		System.out.println("updateDAta:"+user);
		int result = jdbcTemplate.update(query, params);
		
		if(result > 0) {
			return true;
		}else {
			return true;
		}
	}

	
	public Boolean deleteUser(String username) {
		String query = "DELETE FROM users WHERE email = ?";
		int result = jdbcTemplate.update(query, username);
		if(result > 0) {
			return true;
		}else {
			return false;
		}
	}
	

	public List<String> getUserRoles(String username) {
		String query = "SELECT role.type FROM user_roles role WHERE role.username = ?";
		return (List<String>) jdbcTemplate.queryForList(query, String.class, username);
	}


}
