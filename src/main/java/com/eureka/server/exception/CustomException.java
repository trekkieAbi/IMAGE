package com.eureka.server.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {
	
	private String message;
	private HttpStatus httpStatus;
	public CustomException(String message, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
	}
	
	

}
