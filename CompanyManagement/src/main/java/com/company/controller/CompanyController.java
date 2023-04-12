package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.exception.CompanyException;
import com.company.model.Company;
import com.company.service.CompanyService;

@RestController
public class CompanyController {

	@Autowired
	private CompanyService cService;
	
	@PutMapping("/company")
	public ResponseEntity<Company> registerCompanyHandler(@RequestBody Company company) throws CompanyException{
		
		Company cmp= cService.registerCompany(company);
		
		return new ResponseEntity<Company>(cmp,HttpStatus.CREATED);
	}
	
	@GetMapping("/company/{name}")
	public ResponseEntity<Company> getCompanyByNameHandler(@PathVariable("name") String name) throws CompanyException{
		
		Company cmp= cService.getCompanyByCompanyName(name);
		
		return new ResponseEntity<Company>(cmp,HttpStatus.FOUND);
	}
}
