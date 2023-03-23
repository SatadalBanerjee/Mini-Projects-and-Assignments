package com.app.fir.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.xml.bind.ValidationException;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(FIRException.class)
    public ResponseEntity<ErrorDetails> FIRException(FIRException exception,WebRequest request){

        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(LoginException.class)
    public ResponseEntity<ErrorDetails> mywalletExceptionHandler(LoginException loginException, WebRequest request){

        ErrorDetails err=new ErrorDetails(LocalDateTime.now(), loginException.getMessage(), request.getDescription(false));
        return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);


    }

    @ExceptionHandler(PoliceException.class)
    public ResponseEntity<ErrorDetails> PoliceException(PoliceException exception,WebRequest request){

        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(PoliceStationException.class)
    public ResponseEntity<ErrorDetails> PoliceStationException(PoliceStationException exception,WebRequest request){

        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorDetails> UserException(UserException exception,WebRequest request){

        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDetails> NullPointerException(NullPointerException exception,WebRequest request){

        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);

    }

}
