package com.example.repository.session;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.Product;
import com.example.model.Review;
import com.example.repository.mapper.ProductMapper;

@Repository
public class ProductSessionRepository { //mapper.xml에서 쿼리문 작성한 것만 여기에..
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String namespace = "com.example.repository.mapper.ProductMapper";
	
	public List<Product> selectProductList()  {
		return sqlSession.selectList(namespace + ".selectProductList");
	}
	
	public Product selectProduct(String pNum)  {
	    return sqlSession.selectOne(namespace + ".selectProduct", pNum);
	}
	
	public int insertProduct(Product product) {
		int result = sqlSession.insert(namespace + ".insertProduct", product);
		return result;
	}	

	public int updateProduct(Product product) {
		int result = sqlSession.update(namespace + ".updateProduct", product);
		return result;
	}
	
//	public Product selectProductByName(String name) {
//		return sqlSession.selectOne(namespace + ".selectProductByName", name);
//	}
//	
//	public List<Product> searchProductList(String keyword) {
//	    return sqlSession.selectList(namespace + ".searchProductList", "%" + keyword.toLowerCase() + "%");
//	}
//
//	public List<Product> selectProductListByCategory(String catNum) {
//	    return sqlSession.selectList(namespace + ".selectProductListByCategory", catNum);
//	}
	
	public List<Review> selectProductByCondition(Map<String, Object> condition) {
		return sqlSession.selectList(namespace + ".selectProductByCondition", condition);
	}

}