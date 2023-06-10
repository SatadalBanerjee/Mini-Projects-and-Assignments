package com.RealIt.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobelException {
	@ExceptionHandler(userException.class)
public ResponseEntity<MyError> userException(userException userEx,WebRequest web){
		
		MyError error = new MyError(LocalDateTime.now(),userEx.getMessage(), web.getDescription(false));
		
		return new ResponseEntity<MyError>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
public ResponseEntity<MyError> allException(Exception Ex,WebRequest web){
		
		MyError error = new MyError(LocalDateTime.now(),Ex.getMessage(), web.getDescription(false));
		
		return new ResponseEntity<MyError>(error,HttpStatus.BAD_REQUEST);
	}
}
