package com.college.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.exception.CourseException;
import com.college.exception.StudentException;
import com.college.model.Course;
import com.college.model.Student;
import com.college.repository.CourseDao;
import com.college.repository.StudentDao;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao sDao;
	
	@Autowired
	private CourseDao cDao;
	
	@Override
	public Student registeredStudentInCourse(String cName, Student student) throws StudentException,CourseException{
		// TODO Auto-generated method stub
		
		Course course= cDao.findByCourseName(cName);
		
		if(course != null) {
			
			course.getStudents().add(student);
			student.getCourses().add(course);
			
			return sDao.save(student);
		}
		else {
			throw new CourseException("Course Not Found");
		}
		
//		return null;
	}

}
