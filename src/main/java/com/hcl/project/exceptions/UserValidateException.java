package com.hcl.project.exceptions;

import java.sql.SQLException;

public class UserValidateException extends SQLException{
	
	public UserValidateException(String mesage) {
		super(mesage);
	}

}
