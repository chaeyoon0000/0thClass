package com.example.controller.rest;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Category;
import com.example.service.CategoryService;
import com.example.service.ProductService;

@Controller
public class RestSearchProductController {
	@Autowired
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(value = "/product/searchProductBySaleCondition.do/{prop}", method = RequestMethod.GET, 
            produces = "application/json")
	@ResponseBody         
	public ProductList searchBySaleCondition(@PathVariable("prop") String prop, HttpServletResponse response)
			throws IOException {
		System.out.println("/product/searchProductBySaleCondition.do/{prop} request accepted: {prop} = " + prop);
		List<ProductItem> productList = this.productService.searchProductBySaleCondition(prop);
		if (productList == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return new ProductList(productList);  // convert list of products to JSON text in response body
	}
	
}
