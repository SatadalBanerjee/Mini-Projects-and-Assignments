package com.company.service;

import com.company.exception.CompanyException;
import com.company.model.Company;

public interface CompanyService {

public Company registerCompany(Company Company) throws CompanyException;
	
	public Company getCompanyByCompanyName(String name) throws CompanyException;
}
