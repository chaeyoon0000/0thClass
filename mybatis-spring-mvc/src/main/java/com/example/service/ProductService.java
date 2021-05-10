package com.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.controller.rest.ProductItem;
import com.example.model.Product;
import com.example.model.User;
import com.example.repository.mapper.ProductMapperRepository;

@Service
public class ProductService {
	@Autowired
	private ProductMapperRepository productRepository;
//	private CommentSessionRepository commentRepository;
//	private CommentMapperRepository2 commentRepository;
	
	public List<Product> getProductList() {
		return productRepository.selectProductList();
	}
	
	public Product getProduct(String pNum) {
		return productRepository.selectProduct(pNum);
	}
	
	//
//	public List<Product> getProductList(Map<String, Object> condition) {
//		return productRepository.searchProductList(keyword);
//	}
	
	@Transactional
	public int insertProduct(Product product) {
		System.out.println("service");
		return productRepository.insertProduct(product);
	}

	@Transactional
	public int updateProduct(Product product) {
		return productRepository.updateProduct(product);
	}
	
	public List<Product> searchProductListByKeyword(String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyword", keyword);
		return productRepository.selectProductByCondition(map);
	}

	public List<Product> searchProductListByCatAndKey(String category, String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("category", category);
		map.put("keyword", keyword);
		return productRepository.selectProductByCondition(map);
	}

	public List<Product> searchProductListByCondition(String category, String keyword, String prop) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("category", category);
		map.put("keyword", keyword);
		map.put("prop", prop);
		return productRepository.selectProductByCondition(map);
	}
	
	public List<Product> searchProductListByCondAndKey(String prop, String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyword", keyword);
		map.put("prop", prop);
		return productRepository.selectProductByCondition(map);
	}

	public List<Product> searchProductBySaleCondition(String prop) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("prop", prop);
		return productRepository.selectRestProductByCondition(map);
	}

	public User getSellerBypNum(String pNum) {
		// TODO Auto-generated method stub
		return productRepository.selectUserBypNum(pNum);
	}

//	public Product getProductByName(String name) {
//		return productRepository.selectProductByName(name);
//	}
	
}
