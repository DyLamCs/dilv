package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.model.Student;
import com.web.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	
	// CREATE 
	public Student createStudent(Student stu) {
	    return studentRepository.save(stu);
	}

	// READ
	public List<Student> getStudent() {
	    return studentRepository.findAll();
	}

	// DELETE
	public void deleteStudent(Integer stuId) {
	    studentRepository.deleteById(stuId);
	}
	
	// UPDATE
	public Student updateStudent(Integer stuId, Student studentDetails) {
		
	        Student student = studentRepository.findById(stuId).get();
	        student.setId(studentDetails.getId());
	        student.setName(studentDetails.getName());
	        student.setAge(studentDetails.getAge());
	        student.setAddress(studentDetails.getAddress());
	        
	        return studentRepository.save(student);                                
	}
}
