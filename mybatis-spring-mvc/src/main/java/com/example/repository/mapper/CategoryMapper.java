package com.example.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.Category;
import com.example.model.Review;

public interface CategoryMapper {

	Category selectCatTitleByCatNum(String catNum);
	
	String selectCategoryByPrimaryKey(String cat_num);
	
	List<Category> selectCategories();
	
	Category selectCatTitleById(String catNum);

	Category selectCatTitle(String catNum);
}
