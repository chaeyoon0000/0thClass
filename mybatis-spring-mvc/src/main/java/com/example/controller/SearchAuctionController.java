package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import com.example.model.Auction;
import com.example.model.Category;
import com.example.model.User;
import com.example.service.AuctionService;
import com.example.service.CategoryService;

@Controller
public class SearchAuctionController {
	private static final int countPerPage = 6;
	
	private WebApplicationContext context;	
	private String uploadDir;
	
	public void setApplicationContext(ApplicationContext appContext)
		throws BeansException {
		this.context = (WebApplicationContext) appContext;
		this.uploadDir = context.getServletContext().getRealPath("/upload/");
	}
	
	@Autowired
	private AuctionService auctionService;
	public void setAuctionservice(AuctionService auctionService) {
		this.auctionService = auctionService;
	}
	
	@Autowired
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@RequestMapping("/auction/searchAuctionByState.do/{state}")
	public String searchAuctionByState(HttpSession session, @RequestParam("page") String pageStr, @PathVariable("state") String state, Model model) {
//		List<Auction> auctionList = auctionService.searchAuctionByState(state);
		List<Category> categoryList = categoryService.getCategoryList();
		
		int page = Integer.parseInt(pageStr);
		List<Auction> totalAuctionList = auctionService.searchAuctionByState(state);
		int start = page;
		int countPage = countPerPage;
		List<Auction> pagedAuctionList = new ArrayList<Auction>();

		for(Auction a : totalAuctionList) {
			if(start == 1) {
				pagedAuctionList.add(a);
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
		
		int totalPage = totalAuctionList.size() / countPerPage;
		
		if(totalAuctionList.size() % countPerPage > 0)
			totalPage++;
		
		model.addAttribute("auctionList", pagedAuctionList);
		model.addAttribute("categoryList", categoryList);
		
		return "auction/auctionList";
	}
	
	
	
	@RequestMapping("/auction/searchByKeyword.do")
	public String searchByKeyword(@RequestParam("select") String select, @RequestParam("keyword") String keyword, Model model) {
		List<Auction> auctionList = auctionService.searchAuctionByKeyword(select, keyword);
		List<Category> categoryList = categoryService.getCategoryList();
		
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("auctionList", auctionList);
		
		return "auction/auctionList";
	}
	
//	@RequestMapping("/auction/searchByKeyword")
//	public String searchByKeyword(@RequestParam("category") String category, @RequestParam("keyword") String keyword, Model model) {
//		List<Auction> auctionList = AuctionService.searchAuctionByKeyword(category, keyword);
//		List<Category> categoryList = categoryService.getCategoryList();
//		model.addAttribute("categoryList", categoryList);
//		model.addAttribute("auctionList", auctionList);
//		return "review/reviewList";
//	}
}
