package com.web.repositories.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.web.model.Student;
import com.web.repositories.AbstractRepository;
import com.web.repositories.IStudentRepository;

/**
 * StudentRepositoryImpl.java trong pakeage com.web.repositories.impl , để
 * implement interface IStudentRepository và extends AbstractRepository
 * 
 * @Repository là để áp dụng trên các DAO(Data Access Object) class dùng để
 * thao tác với database.
 *
 */
@Repository
public class StudentRepositoryImpl extends AbstractRepository<Student> implements IStudentRepository {

	@Override
	public List<Student> findAll() {
		return super.findAll(Student.class);
	}

	@Override
	public Optional<Student> findById(Integer id) {
		return super.findById(Student.class, id);
	}

}
