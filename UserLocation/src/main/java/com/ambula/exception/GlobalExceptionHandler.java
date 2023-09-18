package com.ambula.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ValidationException;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserLocationException.class)
    public ResponseEntity<ErrorDetails> atmApplicationExceptions(UserLocationException exception, WebRequest request){

        ErrorDetails errorDetails = new ErrorDetails(exception.getMessage(), request.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> atmApplicationExceptions(Exception exception, WebRequest request){

        ErrorDetails errorDetails = new ErrorDetails(exception.getMessage(), request.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorDetails> atmApplicationExceptions(ValidationException exception, WebRequest request){

        ErrorDetails errorDetails = new ErrorDetails(exception.getMessage(), request.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

    }


    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDetails> atmApplicationExceptions(NullPointerException exception, WebRequest request){

        ErrorDetails errorDetails = new ErrorDetails(exception.getMessage(), request.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDetails> atmApplicationExceptions(IllegalArgumentException exception, WebRequest request){

        ErrorDetails errorDetails = new ErrorDetails(exception.getMessage(), request.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

    }

}
