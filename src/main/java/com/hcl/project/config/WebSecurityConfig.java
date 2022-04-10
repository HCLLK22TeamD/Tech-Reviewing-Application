package com.hcl.project.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
//	@Autowired
//	private DataSource dataSource;

//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auBuilder) throws Exception {
//		
//		auBuilder.jdbcAuthentication().dataSource(dataSource)
//		.usersByUsernameQuery("SELECT email, password, user_role FROM users WHERE email = ?")
//		.authoritiesByUsernameQuery("SELECT username, type from user_roles WHERE username = ?");
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		http.authorizeRequests().antMatchers("/home").access("hasRole('ROLE_USER')")
//				.and()
//				.formLogin().loginPage("/loginPage")
//				.defaultSuccessUrl("/home").failureUrl("/loginPage?error").usernameParameter("username")
//				.passwordParameter("password").and().logout().logoutSuccessUrl("/loginPage?logout");
//	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
}
