package com.example.repository.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.WishList;

@Repository
public class WishlistMapperRepository {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<WishList> selectProductListFromWish(String uNum) {
		return sqlSession.getMapper(WishlistMapper.class).selectProductListFromWish(uNum);
	}
	
	public Integer insertWishlist(WishList wish) {
		return sqlSession.getMapper(WishlistMapper.class).insertWishlist(wish);
	}
	
	public Integer deleteFromWishlist(Map<String, Object> map) {
		return sqlSession.getMapper(WishlistMapper.class).deleteFromWishlist(map);
	}
	
	public WishList selectOneFromWish(Map<String, Object> map) {
		return sqlSession.getMapper(WishlistMapper.class).selectOneFromWish(map);
	}
	
	public WishList selectOneFromWish2(Map<String, Object> map) {
		return sqlSession.getMapper(WishlistMapper.class).selectOneFromWish2(map);
	}
}
