package com.masai.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@NotNull
	@Pattern(regexp = "^[a-zA-Z]+$", message = "First name must not contain numbers or special characters")
	private String firstName;
	
	@NotNull
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Last name must not contain numbers or special characters")
	private String lastName;
	
	@NotNull
	@Email(message = "Please check the entered email")
	private String email;
	
	@NotNull
	private Integer age;
	@NotNull
	private String gender;
	
	@NotNull
	@Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must have 10 digits")
	private String mobileNumber;
	
	@NotNull
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{6,12}$",
			message = "Password must be alphanumeric and must contain 6-12 characters having at least one special character, one upper case, one lowercase, and one digit.")
	private String password;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Blog> blogs;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Comment> comments;
	
	
	
}
