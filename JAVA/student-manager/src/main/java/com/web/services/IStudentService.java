package com.web.services;

import java.util.List;
import java.util.Optional;

import com.web.model.Student;

/**
 * - Là nơi chứa logic code
 *
 */
public interface IStudentService {
	List<Student> findAll();
	
	Optional<Student> findById(Integer id);
	
	Student create(Student student);
	Student update(Student student);
	void delete(Integer id);
}
