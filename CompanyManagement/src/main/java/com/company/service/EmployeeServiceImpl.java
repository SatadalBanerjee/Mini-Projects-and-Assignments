package com.company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.exception.EmployeeException;
import com.company.model.Employee;
import com.company.repo.CompanyDao;
import com.company.repo.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private CompanyDao companyDao; 
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public Employee registerEmployee(Employee employee) throws EmployeeException {
		// TODO Auto-generated method stub
		return employeeDao.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() throws EmployeeException {
		
		List<Employee> li= employeeDao.findAll();
		
		if(li.isEmpty()) {
			throw new EmployeeException("There is no employee present");
		}
		else{
			return li;
		}
	}

	@Override
	public Employee updateEmployeeDetails(Employee employee) throws EmployeeException {
		
		Optional<Employee> opt = employeeDao.findById(employee.getId());
		
		if(opt.isPresent()) {
			
			companyDao.save(opt.get().getCompany());
			
			return employeeDao.save(employee);
		}
		
		throw new EmployeeException("There is no Employee present with id : " + employee.getId());
	}

	@Override
	public Employee deletEmployeeById(Integer Id) throws EmployeeException {
		
		Optional<Employee> opt = employeeDao.findById(Id);
		
		if(opt.isPresent()) {
			
			Employee emp= opt.get();
			
			employeeDao.delete(emp);
			
			return emp;
		}
		throw new EmployeeException("There is no Employee present with id :" + Id);
	}

}
