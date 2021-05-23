package com.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Bid;
import com.example.model.Order;
import com.example.model.Product;
import com.example.model.WishList;
import com.example.repository.mapper.AuctionMapper;
import com.example.repository.mapper.OrderMapper;
import com.example.repository.mapper.WishlistMapper;

@Service
public class OrderService {
	
	@Autowired
	public OrderMapper orderMapper;
	@Autowired
	public WishlistMapper wishMapper;
	@Autowired
	public AuctionMapper auctionMapper;
	
	@Transactional
	public Integer insertOrder(Bid bid) { System.out.println("orderService 시작");
		String kind = "3";
		String iNum = bid.getAuc().getaNum();
		String price = bid.getPrice();
		String owner = bid.getParticipant().getId();
		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("iNum", iNum);
//		map.put("kind", kind);
//		map.put("uNum", owner);
//		WishList wish = wishMapper.selectOneAuctionFromWish(map);
//		
//		if(wish != null) {
//			wishMapper.deleteFromWishlist(map);
//			System.out.println("deleteFromWishlist 성공");
//		}
		
		System.out.println("orderService insertProduct"); System.out.println("orderService 끝");
		return orderMapper.insertAuctionOrder(bid);
	}
	
	@Transactional
	public Integer insertOrder(WishList order) { System.out.println("orderService 시작");
		String kind = order.getKind();System.out.println("kind = " + kind);
		String iNum = order.getItem();System.out.println("item = " + iNum);
		String price = order.getPrice();System.out.println("price = " + price);
		String owner = order.getOwner().getuNum();
		System.out.println(order.getwNum());
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("iNum", iNum);
		map.put("kind", kind);
		map.put("uNum", owner);
		map.put("wNum", order.getwNum());
		WishList wish = wishMapper.selectOneFromWish(map);
		
		if(wish != null) {
			wishMapper.deleteFromWishlist(map);
			System.out.println("deleteFromWishlist 성공");
		}
		
		System.out.println("orderService insertProduct"); System.out.println("orderService 끝");
		return orderMapper.insertProductOrder(order);
	}
	
	@Transactional
	public Integer insertOrder2(WishList order) { System.out.println("orderService 시작");
		String kind = order.getKind();System.out.println("kind = " + kind);
		String iNum = order.getItem();System.out.println("item = " + iNum);
		String price = order.getPrice();System.out.println("price = " + price);
		String owner = order.getOwner().getuNum();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("iNum", iNum);
		map.put("kind", kind);
		map.put("uNum", owner);
		WishList wish = wishMapper.selectOneFromWish2(map);
		
		if(wish != null) {
			wishMapper.deleteFromWishlist(map);
			System.out.println("deleteFromWishlist 성공");
		}
		
		System.out.println("orderService insertProduct"); System.out.println("orderService 끝");
		return orderMapper.insertProductOrder(order);
	}

	public List<Product> getProductOrderList(String uNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uNum", uNum);
		return orderMapper.selectProductOrderByuNum(map);
	}
	
	public List<Product> getSellProductOrderList(String uNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uNum", uNum);
		return orderMapper.selectSellProductOrderByuNum(map);
	}
}
