package com.eureka.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.eureka.server.response.ApiResponse;

@RestControllerAdvice
public class ErrorController {
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ApiResponse> handleCustomException(CustomException customException){
		ApiResponse apiResponse=new ApiResponse();
		apiResponse.setData(customException.getMessage());
		apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		apiResponse.setSuccess(false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse> handleOtherException(Exception exception){
		ApiResponse apiResponse=new ApiResponse();
		apiResponse.setData(exception.getMessage());
		apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		apiResponse.setSuccess(false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
