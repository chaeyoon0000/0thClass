package com.example.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.model.Category;

import com.example.repository.mapper.CategoryMapperRepository;


@Service
public class CategoryService {
	@Autowired
	private CategoryMapperRepository categoryRepository;
	
	public Category getCatTitleByCatNum(String catNum) {
		return categoryRepository.selectCatTitleByCatNum(catNum);
	}
	
	public List<Category> getCategoryList() {
		return categoryRepository.selectCategories();
	}
	
	public String selectCategoryByPrimaryKey(String cat_num) {
		return categoryRepository.selectCategoryByPrimaryKey(cat_num);
	}
	
	public Category selectCatTitleById(String catNum) {
		return categoryRepository.selectCatTitleById(catNum);
	}
	public Category catTitleByCatNum(String catNum) {
		// TODO Auto-generated method stub
		return categoryRepository.selectCatTitle(catNum);
	}
}