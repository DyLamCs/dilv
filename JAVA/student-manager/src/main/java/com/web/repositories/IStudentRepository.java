package com.web.repositories;

import java.util.List;
import java.util.Optional;

import com.web.model.Student;

/**
 * interface IStudentRepository.java trong pakeage com.web.repositories, nơi
 * chứa những method để thao tác với table student.
 *
 */
public interface IStudentRepository {
	List<Student> findAll();

	Optional<Student> findById(Integer id);

	Student create(Student student);

	Student update(Student student);

	Student delete(Student student);

}
