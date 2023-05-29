package com.masai.DTO;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class LoginDTO {

	@NotNull(message = "Enter a valid number")
	private String number;
	
	@NotNull(message="Enter a valid password")
	private String password;
}
