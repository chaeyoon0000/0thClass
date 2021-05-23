package com.example.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.Comment;
import com.example.model.Review;

public interface ReviewMapper {

	Review selectReviewByPrimaryKey(String r_num);
	
	List<Review> selectReviews();
	
	List<Review> selectNotices(Map<String, Object> admin);
	
	List<Comment> selectCommentsByrNum(String r_num);

	List<Review> selectReviewByCondition(Map<String, Object> condition);
	
	List<Review> selectReviewById(Map<String, Object> condition);
	
	List<Review> selectReviewByTitle(Map<String, Object> condition);
	
	List<Review> selectReviewByContent(Map<String, Object> condition);

	Integer insertReview(Review review);
	
	Integer insertNotice(Review review);
	
	Integer insertComment(Comment comment);

	Integer updateReview(Review review);

	Integer deleteReview(String r_num);
	
	Integer deleteComment(String r_num);
	
	Integer deleteCommentByrNum(String r_num);
}
