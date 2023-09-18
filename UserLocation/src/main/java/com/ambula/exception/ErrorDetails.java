package com.ambula.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
	
	//Shows the message we set for error
    private String message;
    
    //Shows us the description of error 
    private String description;
    
    // Shows us the time error occurred 
    private LocalDateTime localDateTime;

}
