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
	 
	/** 
	 * CREATE 
	 * @param stu
	 * @return Student
	 */
	public Student createStudent(Student stu) {
	    return studentRepository.save(stu);
	}

	
	/**
	 * READ (tìm tất cả các đối tượng SV trong DB)
	 * @return List<Student>
	 */
	public List<Student> findAllStudent() {
	    return studentRepository.findAll();
	}
	
	/**
	 * READ BY ID (Tìm đối tượng sv qua Id)
	 * @param stuId
	 * @return Student
	 */
	public Student findByIdStudent (Integer stuId) {
		Student student = studentRepository.findById(stuId).get();
		return student;
		
	}
	

	
	/** DELETE đối tượng SV ra khỏi DB thông qua id
	 * @param stuId là id của đối tượng DV cần xóa
	 */
	public void deleteStudent(Integer stuId) {
	    studentRepository.deleteById(stuId);
	}

	/**
	 * UPDATE - cập nhật lại thông tin của một đối tượng sv thông qua id vào DB
	 * @param stuId là id cúa sv cần update
	 * @param studentDetails các thông tin chi tiết của sv
	 * @return Student
	 */
	public Student updateStudent(Integer stuId, Student studentDetails) {
		
	        Student student = studentRepository.findById(stuId).get();
	        student.setId(studentDetails.getId());
	        student.setName(studentDetails.getName());
	        student.setAge(studentDetails.getAge());
	        student.setAddress(studentDetails.getAddress());
	        
	        return studentRepository.save(student);                                
	}
}
