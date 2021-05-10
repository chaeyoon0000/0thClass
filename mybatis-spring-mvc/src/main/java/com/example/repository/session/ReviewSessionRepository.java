package com.example.repository.session;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.Comment;
import com.example.model.Review;

@Repository
public class ReviewSessionRepository {
	@Autowired
	private SqlSessionTemplate sqlSession;

	private final String namespace = "com.example.repository.mapper.ReviewMapper";
	
	public List<Review> selectReviews() {
		return sqlSession.selectList(namespace + ".selectReviews");
	}
	
	public List<Review> selectNotices() {
		return sqlSession.selectList(namespace + ".selectNotices");
	}
	
	public List<Comment> selectCommentsByrNum() {
		return sqlSession.selectList(namespace + ".selectCommentsByrNum");
	}

	public Review selectReviewByPrimaryKey(String rNum) {
		return (Review)sqlSession.selectOne(namespace + ".selectReviewByPrimaryKey", rNum);
	}
	
	public Integer insertReview(Review review) {
		int result = sqlSession.insert(namespace + ".insertReview", review);
		return result;
	}
	
	public Integer deleteReview(String rNum) {
		int result = sqlSession.delete(namespace + ".deleteReview", rNum);
		return result;
	}
	
	public Integer insertComment(Comment comment) {
		int result = sqlSession.insert(namespace + ".insertComment", comment);
		return result;
	}
	
	public Integer deleteComment(String cNum) {
		int result = sqlSession.delete(namespace + ".deleteComment", cNum);
		return result;
	}
	
	public Integer updateReview(Review review) {
		int result = sqlSession.update(namespace + ".updateReview", review);
		return result;
	}

	public List<Review> selectReviewByCondition(Map<String, Object> condition) {
		return sqlSession.selectList(namespace + ".selectReviewByCondition", condition);
	}
}
