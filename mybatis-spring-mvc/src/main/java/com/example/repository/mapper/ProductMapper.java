package com.example.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Update;

import com.example.controller.rest.ProductItem;
import com.example.model.Product;
import com.example.model.Review;
import com.example.model.User;

public interface ProductMapper {
	
	List<Product> selectProductList();
	
	Product selectProduct(String pNum);
	
	Integer insertProduct(Product product);
	
	Integer updateProduct(Product product);
	
//	Product selectProductByName(String name);
	
//	List<Product> searchProductList(String keyword);
//	
//	List<Product> selectProductListByCategory(String catNum);
	
	List<Product> selectProductByCondition(Map<String, Object> condition);

	List<Product> selectRestProductByCondition(Map<String, Object> map);

	User selectUserBypNum(String pNum); 
}
