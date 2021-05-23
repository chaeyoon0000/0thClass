package com.example.repository.mapper;

import java.util.List;
import java.util.Map;

import com.example.model.WishList;

public interface WishlistMapper {
	
	List<WishList> selectProductListFromWish(String uNum);
	
	Integer insertWishlist(WishList wish);
	
	Integer deleteFromWishlist(Map<String, Object> map);

	WishList selectOneFromWish(Map<String, Object> map);
	
	WishList selectOneFromWish2(Map<String, Object> map);
	
	Integer deleteAuctionFromWish(Map<String, Object> map);

	Integer insertAuctionToWish(WishList wish);

	WishList selectOneAuctionFromWish(Map<String, Object> map);
	

}
