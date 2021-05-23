package com.example.repository.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import com.example.repository.mapper.ProductMapper;
import com.example.controller.rest.ProductItem;
import com.example.model.Product;
import com.example.model.Review;
import com.example.model.User;

import org.springframework.stereotype.Repository;

@Repository
public class ProductMapperRepository { //interface 방식일 때 쓰는 repository = dao
	@Autowired
	private SqlSessionTemplate sqlSession;
	//private ProductMapper productMapper;
	
	public List<Product> selectProductList()  {
		return sqlSession.getMapper(ProductMapper.class).selectProductList();
	}
	
	public Product selectProduct(String pNum)  {
	    return sqlSession.getMapper(ProductMapper.class).selectProduct(pNum);
	}
	
	public int insertProduct(Product product) {	System.out.println("mapperRepository");
		Integer result = sqlSession.getMapper(ProductMapper.class).insertProduct(product);
		return result;
	}	

	public int updateProduct(Product product) {
		Integer result = sqlSession.getMapper(ProductMapper.class).updateProduct(product);
		return result;
	}
	
	/*
	 * public Product selectProductByName(String name) { return
	 * sqlSession.getMapper(ProductMapper.class).selectProductByName(name); }
	 */
	
	public List<Product> selectProductByCondition(Map<String, Object> condition) {
		return sqlSession.getMapper(ProductMapper.class).selectProductByCondition(condition);
	}

	public List<Product> selectRestProductByCondition(Map<String, Object> map) {
		return sqlSession.getMapper(ProductMapper.class).selectRestProductByCondition(map);
	}

	public User selectUserBypNum(String pNum) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(ProductMapper.class).selectUserBypNum(pNum);
	}
	
//	public List<Product> searchProductList(String keyword) {
//	    return sqlSession.getMapper(ProductMapper.class).searchProductList(
//	    	"%" + keyword.toLowerCase() + "%");
//	}
//
//	public List<Product> selectProductListByCategory(String catNum) {
//	    return sqlSession.getMapper(ProductMapper.class).selectProductListByCategory(catNum);
//	}
	
	
	
	/* Inner Classes */
//	public static class ProductSearch {
//
//		private List<String> keywordList = new ArrayList<String>();
//
//		public ProductSearch(String keywords) {
//			StringTokenizer splitter = new StringTokenizer(keywords," ",false);
//			while (splitter.hasMoreTokens()) {
//				this.keywordList.add("%" + splitter.nextToken() + "%");
//			}
//		}
//		public List<String> getKeywordList() {
//			return keywordList;
//		}
//	}
}
