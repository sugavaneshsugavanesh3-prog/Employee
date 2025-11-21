package com.employee.GlobalExceptionHandler;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExperienceExceptionController {
	@ExceptionHandler(ExperienceNotFoundException.class)
	public ResponseEntity<Object>getexcept(	ExperienceNotFoundException ee){
		return new ResponseEntity<Object>(ee.getMessage(),HttpStatus.ALREADY_REPORTED);
		
	}

}
