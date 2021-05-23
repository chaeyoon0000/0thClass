package com.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Comment;
import com.example.model.Review;
import com.example.repository.mapper.ReviewMapperRepository;

@Service
public class ReviewService {
	@Autowired
	private ReviewMapperRepository reviewRepository;

	public Review selectReview(String r_num) {
		return reviewRepository.selectReviewByPrimaryKey(r_num);
	}
	
	public List<Review> getReviewList() {
		return reviewRepository.selectReviews();
	}
	
	public List<Review> getNoticeList() {
		return reviewRepository.selectNotices();
	}
	
	public List<Comment> getCommentsByrNum(String r_num) {
		return reviewRepository.selectCommentsByrNum(r_num);
	}
	
	public List<Review> searchReviewByUserId(String writer) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("writer", writer);
		return reviewRepository.selectReviewByCondition(map);
	}
	
	public List<Review> searchReviewByKeyword(String select, String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("select", select);
		map.put("keyword", keyword);
		return reviewRepository.selectReviewByCondition(map);
	}
	
	public List<Review> searchReviewByCategory(String kind, String category) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("category", category);
		map.put("kind", kind);
		return reviewRepository.selectReviewByCondition(map);
	}
	
	public List<Review> searchReviewByCategory(String category) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("category", category);
		return reviewRepository.selectReviewByCondition(map);
	}
	
	public List<Review> searchReviewByKind(String kind) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("kind", kind);
		return reviewRepository.selectReviewByCondition(map);
	}
	
	public List<Review> searchReviewByKeyword(String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyword", keyword);
		return reviewRepository.selectReviewByCondition(map);
	}
	
	@Transactional
	public Integer insertReview(Review review) {
		return reviewRepository.insertReview(review);
	}
	
	@Transactional
	public Integer insertNotice(Review review) {
		return reviewRepository.insertNotice(review);
	}
	
	@Transactional
	public Integer insertComment(Comment comment) {
		return reviewRepository.insertComment(comment);
	}

	@Transactional
	public Integer updateReview(Review review) {
		return reviewRepository.updateReview(review);
	}

	@Transactional
	public Integer deleteReview(String r_num) {
		return reviewRepository.deleteReview(r_num);
	}
	
	@Transactional
	public Integer deleteCommentByrNum(String r_num) {
		return reviewRepository.deleteCommentByrNum(r_num);
	}
	
	@Transactional
	public Integer deleteComment(String c_num) {
		return reviewRepository.deleteComment(c_num);
	}
}