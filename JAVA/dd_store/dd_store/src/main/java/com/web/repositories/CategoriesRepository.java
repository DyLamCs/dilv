package com.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.entities.Category;
@Repository
public interface CategoriesRepository extends JpaRepository<Category, Integer> {

}
