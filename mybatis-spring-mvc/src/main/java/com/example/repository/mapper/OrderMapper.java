package com.example.repository.mapper;

import java.util.List;
import java.util.Map;

import com.example.model.Bid;
import com.example.model.Order;
import com.example.model.Product;
import com.example.model.WishList;

public interface OrderMapper {

	Integer insertProductOrder(WishList order);
	
	List<Product> selectProductOrderByuNum(Map<String, Object> map);

	List<Product> selectSellProductOrderByuNum(Map<String, Object> map);
	
	List<Order> selectOrders();

	Integer insertOrder(String aNum);

	Integer insertAuctionOrder(Bid bid);

	void deleteAuctionOrder(String aNum);
}
