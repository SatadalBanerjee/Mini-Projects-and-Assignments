package com.masai.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {

	@Id
	private String email;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	@NotNull
	@NotBlank
	@Pattern(regexp = "[A-Za-z]{1,120}",message = "Name should contain only character")
	private String first_name;
	
	@Pattern(regexp = "[A-Za-z]{1,120}",message = "Name should contain only character")
	private String last_name;
	
	@Pattern(regexp = "[6789]{1}[0-9]{9}", message = "Enter a 10 digit mobile number")
	@Size(min = 10, max = 10)
	private String mobilenumber;
	
	
	@NotNull(message="Password cannot be null!")
	@NotBlank(message= "Password cannot be blank!")
	@Pattern(regexp = "[A-Za-z0-9!@#$%^&*_]{6,12}", message = "Password must be 6 to 12 characters in length and can include alphanumerics and special characters")	
	private String password;
	
	@Past
	private LocalDate dateofbirth;
	
	@JsonIgnore
	@OneToMany
	private List<Email> emailSent=new ArrayList<>();
	@JsonIgnore
	@OneToMany
	private List<Email> emailReceived=new ArrayList<>();
}
