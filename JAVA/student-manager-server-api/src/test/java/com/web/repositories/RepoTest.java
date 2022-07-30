package com.web.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


import com.web.model.Student;
import com.web.repository.StudentRepository;

@TestMethodOrder(OrderAnnotation.class) // Cấu hình thứ tự thực thi cho các @Test
@SpringBootTest  //@SpringBootTest sẽ đi tìm kiếm class có gắn @SpringBootApplication và từ đó đi tìm toàn bộ Bean và nạp vào Context.
public class RepoTest {
	@Autowired
	private StudentRepository studentRepository;

	@Test
	@Order(1)
	public void testCreate() {
		Student student = new Student();
		student.setName("Ngô Kiến Huy");
		student.setAge(18);
		student.setAddress("Tp. HCM");
	}
	
	@Test
	@Order(2)
	public void testFindAll() {
		List<Student> studentList = studentRepository.findAll();
		assertThat(studentList).size().isGreaterThan(0);
	}
	
	
	@Test
	@Order(3)
	public void testFindById() {
		Student student = studentRepository.findById(8).get();
		assertEquals("Minh", student.getName());
	}
	
	@Test
	@Order(4)
	public void testUpdate() {
		Student student = studentRepository.findById(11).get();
		student.setName("An Nhien IVS");
		studentRepository.save(student);
	}

	public void testDelete() {
		Student student = studentRepository.findById(31).get();
		studentRepository.delete(student);
	}
	
	

}
