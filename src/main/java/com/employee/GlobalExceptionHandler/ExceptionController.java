package com.employee.GlobalExceptionHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController   {
	
@ExceptionHandler(NameNotFoundException.class)
public ResponseEntity <Object> getExcept(NameNotFoundException ne){
	return new ResponseEntity<Object>(ne.getMessage(),HttpStatus.ALREADY_REPORTED);
}
}

