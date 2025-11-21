package com.employee.GlobalExceptionHandler;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SalaryExceptionController {
@ExceptionHandler(SalaryNotFoundException.class)
public ResponseEntity<Object>getExcept(SalaryNotFoundException se){
	return new ResponseEntity<Object>(se.getMessage(),HttpStatus.ALREADY_REPORTED);
	
}

}
