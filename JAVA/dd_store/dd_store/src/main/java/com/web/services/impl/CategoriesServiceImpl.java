package com.web.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entities.Category;
import com.web.repositories.CategoriesRepository;
import com.web.services.ICategoriesService;

@Service
public class CategoriesServiceImpl implements ICategoriesService {
	@Autowired
	CategoriesRepository categoriesRepository;

	@Override
	public List<Category> findAll() {
		return categoriesRepository.findAll();
	}

	@Override
	public Optional <Category> findById(Integer id) {
		return categoriesRepository.findById(id);
	}

	@Override
	public Category create(Category category) {
		return categoriesRepository.save(category);
	}

	@Override
	public Category update(Category categoryDetails, Integer id) {
		Category category = categoriesRepository.findById(id).get();
		
		category.setCtgName(categoryDetails.getCtgName());
		
		return categoriesRepository.save(category);
	}

	@Override
	public void delete(Integer id) {
		categoriesRepository.deleteById(id);
		
	}

	

}
