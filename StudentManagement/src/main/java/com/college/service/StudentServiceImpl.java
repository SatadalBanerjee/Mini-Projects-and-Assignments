package com.college.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.exception.StudentException;
import com.college.model.Student;
import com.college.repo.CollegeDao;
import com.college.repo.StudentDao;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private CollegeDao collegeDao; 
	
	@Autowired
	private StudentDao studentDao;
	
	@Override
	public Student registerStudent(Student student) throws StudentException {
		
//		collegeDao.save(student.getCollege());
		
		return studentDao.save(student);
	}

	@Override
	public List<Student> getAllStudent() throws StudentException {
		 
		List<Student> li= studentDao.findAll();
		
		if(li.isEmpty()) {
			throw new StudentException("There is no student present");
		}
		else{
			return li;
		}
	}

	@Override
	public Student updateStudentDetails(Student student) throws StudentException {
		// TODO Auto-generated method stub
		Optional<Student> opt = studentDao.findById(student.getId());
		
		if(opt.isPresent()) {
			
			collegeDao.save(opt.get().getCollege());
			
			return studentDao.save(student);
		}
		throw new StudentException("There is no Student present with id : " + student.getId());
	}

	@Override
	public Student deletStudentById(Integer Id) throws StudentException {
		// TODO Auto-generated method stub
		Optional<Student> opt = studentDao.findById(Id);
		
		if(opt.isPresent()) {
			
			Student st= opt.get();
			
			studentDao.delete(st);
			
			return st;
		}
		throw new StudentException("There is no student present with id :" + Id);
	}

}
