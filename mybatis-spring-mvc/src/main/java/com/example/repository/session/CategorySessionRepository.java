package com.example.repository.session;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.Category;
import com.example.model.Review;

@Repository
public class CategorySessionRepository {
	@Autowired
	private SqlSessionTemplate sqlSession;

	private final String namespace = "com.example.repository.mapper.CategoryMapper";
	
	public List<Category> selectCategories() {
		return sqlSession.selectList(namespace + ".selectCategorys");
	}

	public Review selectReviewByPrimaryKey(String rNum) {
		return (Review)sqlSession.selectOne(namespace + ".selectReviewByPrimaryKey", rNum);
	}

	public List<Review> selectCommentByCondition(Map<String, Object> condition) {
		return sqlSession.selectList(namespace + ".selectCommentByCondition", condition);
	}

	public Integer insertComment(Review comment) {
		int result = sqlSession.insert(namespace + ".insertComment", comment);
		return result;
	}

	public Integer updateComment(Review comment) {
		int result = sqlSession.update(namespace + ".updateComment", comment);
		return result;
	}
	
	public Integer deleteComment(Long commentNo) {
		int result = sqlSession.delete(namespace + ".deleteComment", commentNo);
		return result;
	}
}
