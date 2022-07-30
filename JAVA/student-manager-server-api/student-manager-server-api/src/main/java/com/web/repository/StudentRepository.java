package com.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.model.Student;

/**
 * Lớp @Repository chỉ ra rằng lớp là một kho lưu trữ dữ liệu sẽ chứa các
 * hoạt động CRUD. CRUD là từ viết tắt của bốn hoạt động cơ bản của 
 * cơ sở dữ liệu - C reate, R ead, U pdate, D elete.
 *
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
