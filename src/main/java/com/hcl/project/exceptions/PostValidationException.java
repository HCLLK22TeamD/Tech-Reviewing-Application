package com.hcl.project.exceptions;

import java.sql.SQLException;

public class PostValidationException extends SQLException{

	public PostValidationException(String message) {
		super(message);
	}
	
}
