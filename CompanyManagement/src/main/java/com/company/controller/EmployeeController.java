package com.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.exception.EmployeeException;
import com.company.model.Employee;
import com.company.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService eService;
	
	@PutMapping("/employee")
	public ResponseEntity<Employee> registerEmployeeHandler(@RequestBody Employee employee) throws EmployeeException{
		
		Employee emp= eService.registerEmployee(employee);
		
		return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployeeHandler() throws EmployeeException{
		
		List<Employee> list= eService.getAllEmployee();
		
		return new ResponseEntity<List<Employee>>(list,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> updateEmployeeHandler(@RequestBody Employee employee) throws EmployeeException{
		
		Employee emp= eService.updateEmployeeDetails(employee);
		
		return new ResponseEntity<Employee>(emp,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Employee> deleteUserByIdHandler(@PathVariable("id") Integer id) throws EmployeeException{
		
		Employee emp= eService.deletEmployeeById(id);	
		
		return new ResponseEntity<Employee>(emp,HttpStatus.ACCEPTED);
	}
}
