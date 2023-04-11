package com.company.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.model.Company;

@Repository
public interface CompanyDao extends JpaRepository<Company, Integer>{
	
	public Optional<Company> findByCompanyname(String companyname);
}
