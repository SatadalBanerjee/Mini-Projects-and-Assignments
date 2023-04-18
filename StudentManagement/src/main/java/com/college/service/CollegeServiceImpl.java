package com.college.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.exception.CollegeException;
import com.college.model.College;
import com.college.repo.CollegeDao;
import com.college.repo.StudentDao;

@Service
public class CollegeServiceImpl implements CollegeService{

	@Autowired
	private CollegeDao collegeDao; 
	
	@Autowired
	private StudentDao studentDao;
	
	
	@Override
	public College registerCollege(College college) throws CollegeException {
		// TODO Auto-generated method stub
		
//		studentDao.save(college.getStudent());
		
		return collegeDao.save(college);
	}


	@Override
	public College getCollegeByCollegeName(String name) throws CollegeException {
		// TODO Auto-generated method stub
		Optional<College> opt= collegeDao.findByClgname(name);
		
		if(opt.isPresent()) {
			College clg= opt.get();
			
			return clg;
		}
		else {
			throw new CollegeException("There is no college present with name :" + name);
		}
	}
	
}
