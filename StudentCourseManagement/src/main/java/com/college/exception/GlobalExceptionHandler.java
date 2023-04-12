package com.college.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CourseException.class)
	public ResponseEntity<MyErrorDetails> companyException(CourseException e, WebRequest req) {

		MyErrorDetails myErrorDetails = new MyErrorDetails(LocalDate.now(), e.getMessage(), req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(StudentException.class)
	public ResponseEntity<MyErrorDetails> EmployeeExceptionException(StudentException  e, WebRequest req) {

		MyErrorDetails myErrorDetails = new MyErrorDetails(LocalDate.now(), e.getMessage(), req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> myMANVExceptionHandler(MethodArgumentNotValidException me,WebRequest req) {
		
		
		MyErrorDetails myErrorDetails = new MyErrorDetails(LocalDate.now(), me.getBindingResult().getFieldError().getDefaultMessage(),req.getDescription(false));
		return new ResponseEntity<>(myErrorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> parent_Exception(Exception e, WebRequest req) {

		MyErrorDetails myErrorDetails = new MyErrorDetails(LocalDate.now(), e.getMessage(), req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.BAD_REQUEST);
	}

}
