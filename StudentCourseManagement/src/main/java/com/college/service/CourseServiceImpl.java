package com.college.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.model.Course;
import com.college.repository.CourseDao;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseDao cDao;
	
	@Override
	public Course registerNewCourse(Course course) {
		// TODO Auto-generated method stub
		return null;
	}

}
