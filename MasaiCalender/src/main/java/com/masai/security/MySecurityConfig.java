package com.masai.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

public class MySecurityConfig {
	
	@Bean
	public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests(
				(auth) -> auth.antMatchers("/addEvents/{uuid}").authenticated()
				.antMatchers("/updateEvents/{uuid}","/deleteEvents/{uuid}","/registerUser","/updateUser","/listOfEvents").hasAuthority("USER")
				.antMatchers("/LoginUSer").permitAll()
		).csrf().disable().httpBasic();
		
		return http.build();
	}
	
	@Bean
	public PasswordEncoder encodePassword() {
		//return NoOpPasswordEncoder.getInstance(); //Not recommended
		return new BCryptPasswordEncoder();
	}
}
