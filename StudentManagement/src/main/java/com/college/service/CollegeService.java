package com.college.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.college.exception.CollegeException;
import com.college.model.College;

public interface CollegeService {

	public College registerCollege(College college) throws CollegeException;
	
	public College getCollegeByCollegeName(String name) throws CollegeException;
}
