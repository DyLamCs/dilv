package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.Student;
import com.web.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	@Autowired
	StudentService studentService;

//	@GetMapping
//	public List<Student> getAll(){
//		return studentService.getStudent();
//		
//	}
	
	@RequestMapping(value="/student", method=RequestMethod.POST)
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public List<Student> readStudent(){
		return studentService.getStudent();
	}
	
	@RequestMapping(value ="/student/{studentId}", method = RequestMethod.PUT )
	public Student updateStudent (@PathVariable(value = "studentId") Integer Id, @RequestBody Student studentDetails) {
		return studentService.updateStudent(Id, studentDetails);
	}
	
	@RequestMapping(value = "/student/{studentId}", method = RequestMethod.DELETE)
	public void deleteStudent(@PathVariable(value = "studentId") Integer Id) {
		studentService.deleteStudent(Id);
	}
	
	
	
}
