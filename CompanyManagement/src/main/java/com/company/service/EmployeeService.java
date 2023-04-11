package com.company.service;

import java.util.List;

import com.company.exception.EmployeeException;
import com.company.model.Employee;

public interface EmployeeService {

public Employee registerEmployee(Employee employee) throws EmployeeException;
	
	public List<Employee> getAllEmployee() throws EmployeeException;
	
	public Employee updateEmployeeDetails(Employee employee) throws EmployeeException;
	
	public Employee deletEmployeeById(Integer Id) throws EmployeeException;
	
}
