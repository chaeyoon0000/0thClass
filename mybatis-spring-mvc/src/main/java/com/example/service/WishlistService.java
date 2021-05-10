package com.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Product;
import com.example.model.WishList;
import com.example.repository.mapper.WishlistMapper;

@Service
public class WishlistService {

	@Autowired
	public WishlistMapper wishMapper;

	
	public List<WishList> getProductWishlist(String uNum) {
		System.out.println("wishlistService getWishlist");
		return wishMapper.selectProductListFromWish(uNum);
	}
	
	public WishList getOneProductWishlist(String iNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("iNum", iNum);
		map.put("kind", "2");
		
		System.out.println("wishlistService getWishlist");
		return wishMapper.selectOneFromWish(map);
	}

	@Transactional
	public Integer addProductToWish(WishList wish) {
		System.out.println("wishlistService insertProduct");
		return wishMapper.insertWishlist(wish);
	}
	
	@Transactional
	public Integer deleteProductFromWish(String uNum, String iNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("iNum", iNum);
		map.put("uNum", uNum);
		
		System.out.println("wishlistService delete");
		return wishMapper.deleteFromWishlist(map);
	}
	
	@Transactional
	public Integer deleteFromWishlist(String uNum, String iNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("iNum", iNum);
		map.put("uNum", uNum);
		
		System.out.println("wishlistService delete");
		return wishMapper.deleteFromWishlist(map);
	}

	@Transactional
	public Integer addAuctionToWish(WishList wish) {
		return wishMapper.insertAuctionToWish(wish);
	}
}
