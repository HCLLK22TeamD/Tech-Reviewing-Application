package com.hcl.project.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.hcl.project.dao.CalendarDAO;
import com.hcl.project.dao.CommentDAO;
import com.hcl.project.dao.PostDAO;
import com.hcl.project.dao.UserDAO;
import com.hcl.project.dao.impl.CalendarDAOImpl;
import com.hcl.project.dao.impl.CommentDAOImpl;
import com.hcl.project.dao.impl.PostDAOImpl;
import com.hcl.project.dao.impl.UserDAOImpl;

@Configuration
@EnableWebMvc
@ComponentScan( basePackages = "com.hcl.project")
public class WebMvcConfig implements WebMvcConfigurer{
	
	@Autowired
	DataSource dataSource;
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
		.addResourceLocations("/WEB-INF/views/assets/");
	}
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("system");
		ds.setPassword("oracle123");
		
		return ds;
	}
	
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
	    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	    multipartResolver.setMaxUploadSize(100000);
	    return multipartResolver;
	}
	
	
	@Bean
	public UserDAO getUserDAO() {
		return new UserDAOImpl(dataSource);
	}
	@Bean
	public PostDAO getPostDAO() {
		return new PostDAOImpl(dataSource);
	}
	@Bean
	public CalendarDAO getCalendarDAO() {
		return new CalendarDAOImpl(dataSource);
	}
	@Bean
	public CommentDAO getCommentDAO() {
		return new CommentDAOImpl(dataSource);
	}

}
