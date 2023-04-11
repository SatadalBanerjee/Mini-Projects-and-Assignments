package com.company.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.exception.CompanyException;
import com.company.model.Company;
import com.company.repo.CompanyDao;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyDao companyDao;

	@Override
	public Company registerCompany(Company company) throws CompanyException {
		// TODO Auto-generated method stub
		return companyDao.save(company);
	}

	@Override
	public Company getCompanyByCompanyName(String name) throws CompanyException {
		
		Optional<Company> opt= companyDao.findByCompanyname(name);
		
		if(opt.isPresent()) {
			
			Company com= opt.get();
			
			return com;
		}
		else {
			throw new CompanyException("There is no Company present with name :" + name);
		}
	}
	
	
	
}
