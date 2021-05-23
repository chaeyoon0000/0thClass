package com.example.repository.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.Category;
import com.example.model.Review;

@Repository
public class CategoryMapperRepository {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Category> selectCategories() {
		return sqlSession.getMapper(CategoryMapper.class).selectCategories();
	}

	public Category selectCatTitleByCatNum(String catNum) {
		return sqlSession.getMapper(CategoryMapper.class).selectCatTitleByCatNum(catNum);
	}
	
	public String selectCategoryByPrimaryKey(String cat_num) {
		return sqlSession.getMapper(CategoryMapper.class).selectCategoryByPrimaryKey(cat_num);
	}
	
	public Category selectCatTitleById(String catNum) {
		return sqlSession.getMapper(CategoryMapper.class). selectCatTitleById(catNum);
	}

	public Category selectCatTitle(String catNum) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(CategoryMapper.class).selectCatTitle(catNum);
	}
}