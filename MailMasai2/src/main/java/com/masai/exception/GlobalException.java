package com.masai.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalException {

	
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorDetails> userException(UserException em,WebRequest request){
		
		MyErrorDetails err=new MyErrorDetails(em.getMessage(), LocalDate.now(), request.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(EmailException.class)
	public ResponseEntity<MyErrorDetails> emailException(EmailException em,WebRequest req){
		
		MyErrorDetails err=new MyErrorDetails(em.getMessage(), LocalDate.now(), req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> nohandllerException(NoHandlerFoundException em,WebRequest req){
		
		MyErrorDetails err=new MyErrorDetails(em.getMessage(), LocalDate.now(), req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> methodException(MethodArgumentNotValidException em){
		
		MyErrorDetails err=new MyErrorDetails(em.getBindingResult().getFieldError().getDefaultMessage(), LocalDate.now(), "validation failed");
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	
}