package com.example.repository.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.Comment;
import com.example.model.Review;

@Repository
public class ReviewMapperRepository {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Review> selectReviews() {
		return sqlSession.getMapper(ReviewMapper.class).selectReviews();
	}
	
	public List<Review> selectNotices() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("admin", "admin");
		return sqlSession.getMapper(ReviewMapper.class).selectNotices(map);
	}
	
	public List<Comment> selectCommentsByrNum(String r_num) {
		return sqlSession.getMapper(ReviewMapper.class).selectCommentsByrNum(r_num);
	}

	public Review selectReviewByPrimaryKey(String r_num) {
		return sqlSession.getMapper(ReviewMapper.class).selectReviewByPrimaryKey(r_num);
	}

	public List<Review> selectReviewByCondition(Map<String, Object> condition) {
		return sqlSession.getMapper(ReviewMapper.class).selectReviewByCondition(condition);
	}
	
	public Integer insertReview(Review review) {
		Integer result = sqlSession.getMapper(ReviewMapper.class).insertReview(review);
		return result;
	}
	
	public Integer insertNotice(Review review) {
		Integer result = sqlSession.getMapper(ReviewMapper.class).insertNotice(review);
		return result;
	}
	
	public Integer insertComment(Comment comment) {
		System.out.println("RMR's insertComment start!");
		Integer result = sqlSession.getMapper(ReviewMapper.class).insertComment(comment);
		return result;
	}
	
	public Integer updateReview(Review review) {
		Integer result = sqlSession.getMapper(ReviewMapper.class).updateReview(review);
		return result;
	}

	public Integer deleteReview(String r_num) {
		Integer result = sqlSession.getMapper(ReviewMapper.class).deleteReview(r_num);
		return result;
	}
	
	public Integer deleteCommentByrNum(String r_num) {
		Integer result = sqlSession.getMapper(ReviewMapper.class).deleteCommentByrNum(r_num);
		return result;
	}
	
	public Integer deleteComment(String c_num) {
		Integer result = sqlSession.getMapper(ReviewMapper.class).deleteComment(c_num);
		return result;
	}
}