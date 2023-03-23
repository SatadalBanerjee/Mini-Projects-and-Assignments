package com.app.fir.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Pattern(regexp = "^[A-Za-z ]+$", message = "No numbers and special charracters")
    private String firstName;
    
    @Pattern(regexp = "^[A-Za-z ]+$", message = "No numbers and special charracters")
    private String lastName;
   
    @Size(min = 10, max = 10, message = "number must have 10 digits")
    private String mobileNumber;
   
    @Min(value = 13, message = "Age must be above 12 years")
    private Integer age;

    @Pattern(regexp = "^(male|female)$", message = "Gender must be either male or female")
    private String gender;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,12}$",
            message = "Password should be alphanumeric and must contain 6-12 characters having at least one special character, one upper case, one lowercase, and one digit")
    private String password;
    @NotBlank
    private String address;

}

