package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Category;
import com.example.model.Product;
import com.example.model.Review;
import com.example.model.User;
import com.example.service.CategoryService;
import com.example.service.ProductService;

@Controller
public class ProductController {
	
	private static final int countPerPage = 6;
	
	@Autowired
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Autowired
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@ModelAttribute("categories")
	public List<Category> referenceSearchCategoryList() {
		List<Category> categoryList = categoryService.getCategoryList();
		return categoryList;
	} 
	
	@ModelAttribute("checkConditionList")
	public String[] referenceSearchMenuList() {
		return new String[] { "End of Sale", "On Sale", "All" }; 
	}
	
	@RequestMapping("/product/listProducts.do")
	public String viewProductList(HttpSession session, @RequestParam("page") String pageStr, Model model) throws Exception {
		
		if(session.getAttribute("user") == null)
			return "user/login";
		
		int page = Integer.parseInt(pageStr);
		List<Product> totalProductList = productService.getProductList();
		int start = page;
		int countPage = countPerPage;
		List<Product> pagedProductList = new ArrayList<Product>();
		
		for(Product p : totalProductList) {
			if(start == 1) {
				pagedProductList.add(p);
				countPage--;
				if(countPage == 0)
					break;
			}
			else {
				countPage--;
				if(countPage == 0) {
					countPage = countPerPage;
					start--;
				}	
			}
		}
		
		int totalPage = totalProductList.size() / countPerPage;
		
		if(totalProductList.size() % countPerPage > 0)
			totalPage++;
		
		List<Category> categoryList = categoryService.getCategoryList();
		model.addAttribute("productList", pagedProductList);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("page", page);
		model.addAttribute("categoryList", categoryList);
		
		return "product/productList";
	}
	
	@RequestMapping("/product/productDetail.do/{pNum}")
	public ModelAndView viewProduct(@PathVariable("pNum") String pNum) throws Exception {
		return new ModelAndView("product/productDetail", "product", productService.getProduct(pNum));
	}
	
	@RequestMapping("/product/searchProduct.do")
	public String searchProduct(HttpServletRequest request, @RequestParam("page") String pageStr,
			@RequestParam("category") String category,
			@RequestParam(value="keyword", required=false) String keyword, Model model) throws Exception {
			
		if (keyword != null && !keyword.equals("")) {
			List<Product> productList;
			if(!category.equals("Category")) {
				productList = productService.searchProductListByCatAndKey(category, keyword);
				model.addAttribute("selectedcategory", category);
			}
			else {
				productList = productService.searchProductListByKeyword(keyword);
			}
			model.addAttribute("keyword", keyword);
			
			int page = Integer.parseInt(pageStr);
			List<Product> totalProductList = productList;
			int start = page;
			int countPage = countPerPage;
			List<Product> pagedProductList = new ArrayList<Product>();
			
			for(Product p : totalProductList) {
				if(start == 1) {
					pagedProductList.add(p);
					countPage--;
					if(countPage == 0)
						break;
				}
				else {
					countPage--;
					if(countPage == 0) {
						countPage = countPerPage;
						start--;
					}	
				}
			}
			
			int totalPage = totalProductList.size() / countPerPage;
			
			if(totalProductList.size() % countPerPage > 0)
				totalPage++;
			
			List<Category> categoryList = categoryService.getCategoryList();
			model.addAttribute("productList", pagedProductList);
			model.addAttribute("totalPage", totalPage);
			model.addAttribute("page", page);
			model.addAttribute("categoryList", categoryList);
		}
		else {
			int page = Integer.parseInt(pageStr);
			List<Product> totalProductList = productService.getProductList();
			int start = page;
			int countPage = countPerPage;
			List<Product> pagedProductList = new ArrayList<Product>();
			
			for(Product p : totalProductList) {
				if(start == 1) {
					pagedProductList.add(p);
					countPage--;
					if(countPage == 0)
						break;
				}
				else {
					countPage--;
					if(countPage == 0) {
						countPage = countPerPage;
						start--;
					}	
				}
			}
			
			int totalPage = totalProductList.size() / countPerPage;
			
			if(totalProductList.size() % countPerPage > 0)
				totalPage++;
			
			List<Category> categoryList = categoryService.getCategoryList();
			model.addAttribute("productList", pagedProductList);
			model.addAttribute("totalPage", totalPage);
			model.addAttribute("page", page);
			model.addAttribute("categoryList", categoryList);
				model.addAttribute("selectedcategory", category);
				model.addAttribute("error", "Please enter a keyword to search for, then press the search button.");
		}
		return "product/productList";
	}
	
	@RequestMapping("/product/searchProductBySaleCondition.do")
	public String searchBySaleCondition(@RequestParam("prop") String prop, @RequestParam("page") String pageStr, Model model) {

		int page = Integer.parseInt(pageStr);
		List<Product> totalProductList = productService.searchProductBySaleCondition(prop);
		int start = page;
		int countPage = countPerPage;
		List<Product> pagedProductList = new ArrayList<Product>();
		
		for(Product p : totalProductList) {
			if(start == 1) {
				pagedProductList.add(p);
				countPage--;
				if(countPage == 0)
					break;
			}
			else {
				countPage--;
				if(countPage == 0) {
					countPage = countPerPage;
					start--;
				}	
			}
		}
		
		int totalPage = totalProductList.size() / countPerPage;
		
		if(totalProductList.size() % countPerPage > 0)
			totalPage++;
		
		List<Category> categoryList = categoryService.getCategoryList();
		model.addAttribute("productList", pagedProductList);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("page", page);
		model.addAttribute("prop", prop);
		model.addAttribute("categoryList", categoryList);
		return "product/productList";
	}

}
