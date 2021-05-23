package com.example.repository.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.Order;
import com.example.model.Product;
import com.example.model.WishList;

@Repository
public class OrderMapperRepository {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public Integer insertProductOrder(WishList order) {
		return sqlSession.getMapper(OrderMapper.class).insertProductOrder(order);
	}
	
	public List<Product> selectProductOrderByuNum(Map<String, Object> map) {
		return sqlSession.getMapper(OrderMapper.class).selectProductOrderByuNum(map);
	}
	
	public List<Product> selectSellProductOrderByuNum(Map<String, Object> map) {
		return sqlSession.getMapper(OrderMapper.class).selectSellProductOrderByuNum(map);
	}
	
	public List<Order> selectOrders() {
		return sqlSession.getMapper(OrderMapper.class).selectOrders();
	}

	public Integer insertOrder(String aNum) {
		return sqlSession.getMapper(OrderMapper.class).insertOrder(aNum);
	}
}
