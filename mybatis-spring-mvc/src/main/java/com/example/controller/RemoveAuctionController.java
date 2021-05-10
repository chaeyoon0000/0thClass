package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import com.example.model.Auction;
import com.example.model.Category;
import com.example.model.User;
import com.example.repository.mapper.OrderMapper;
import com.example.service.AuctionService;
import com.example.service.BidService;
import com.example.service.CategoryService;
import com.example.service.WishlistService;

@Controller
public class RemoveAuctionController implements ApplicationContextAware{
	private WebApplicationContext context;	
	private String uploadDir;
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Override
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
	
	@Autowired
	private BidService bidService;
	public void setBidervice(BidService bidService) {
		this.bidService = bidService;
	}
	
	@Autowired
	private WishlistService wishService;
	public void setWishlistService(WishlistService wishService) {
		this.wishService = wishService;
	}

	@RequestMapping("auction/deleteAuction.do/{aNum}")
	public String deleteAuction(HttpSession session, @PathVariable("aNum") String aNum, Model model) {
		User sessionUser = (User)session.getAttribute("user");
		
		bidService.deleteBid(aNum);
		auctionService.deleteAuction(aNum);
		orderMapper.deleteAuctionOrder(aNum);
		wishService.deleteFromWishlist(sessionUser.getuNum(), aNum);
		
		
		List<Auction> auctionList = auctionService.getAuctionList();
		List<Category> categoryList = categoryService.getCategoryList();
		
		
		model.addAttribute("auctionList", auctionList);
		model.addAttribute("categoryList", categoryList);
		
		return "/auction/auctionList";
	}
}
