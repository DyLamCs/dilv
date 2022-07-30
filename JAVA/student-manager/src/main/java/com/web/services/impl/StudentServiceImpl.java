package com.web.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.model.Student;
import com.web.repositories.IStudentRepository;
import com.web.services.IStudentService;

/**
 *  @Service annotation để chỉ ra rằng nó thuộc về tầng service nắm giữ code xử
 * 	lý business trong đó
 * 
 */
@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentRepository studentRepository;

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Optional<Student> findById(Integer id) {
		return studentRepository.findById(id);
	}

	@Override
	public Student create(Student student) {
		return studentRepository.create(student);
	}

	@Override
	public Student update(Student student) {
		return studentRepository.update(student);
	}

	@Override
	public void delete(Integer id) {
		Optional<Student> studentOptional = studentRepository.findById(id);
		Student student = studentOptional.get();
		if (student != null) {
			studentRepository.delete(student);
		}

	}

}
