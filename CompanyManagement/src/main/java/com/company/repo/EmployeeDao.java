package com.company.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.model.Company;
import com.company.model.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>{

}
