package com.example.controller;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.model.Auction;
import com.example.model.Bid;
import com.example.model.User;
import com.example.service.AuctionService;
import com.example.service.BidService;
import com.example.service.CategoryService;
import com.example.service.OrderService;
import com.example.service.UserService;

@Controller
public class ViewAuctionController implements ApplicationContextAware {
	private WebApplicationContext context;	
	private String uploadDir;
	
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
	private BidService bidService;
	public void setBidservice(BidService bidService) {
		this.bidService = bidService;
	}
	
	@Autowired
	private UserService userService;
	public void setUserservice(UserService userService) {
		this.userService = userService;
	}
	
	@Autowired
	private OrderService orderService;
	public void setOrderservice(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@Autowired
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@RequestMapping(value = "/auction/auctionDetail.do/{aNum}", method = RequestMethod.GET)
	public String selectByAuctionNo(HttpSession session, @PathVariable("aNum") String aNum, Model model) {		
		User user = (User)session.getAttribute("user");
		Auction auction = auctionService.selectAuctionById(aNum);
		Bid bid = bidService.selectBidMaxPrice(aNum);

		model.addAttribute("sessionUser", user);
		model.addAttribute("bid", bid);
		model.addAttribute("auction", auction);
		
		session.setAttribute("user", user);

		return "auction/auctionDetail";
	}

	@RequestMapping(value = "/auction/bidAuction.do/{aNum}", method = {RequestMethod.GET, RequestMethod.POST})
	public String selectByBidAuctionNo(HttpSession session, @RequestParam("price") String price, @PathVariable("aNum") String aNum, Model model) {
		Auction auction = auctionService.selectAuctionById(aNum);
		User user = (User)session.getAttribute("user");
		
//		int totalPrice = Integer.parseInt(price);
//		
//		System.out.println("totalPrice: " + totalPrice);
//		System.out.println("price" + Integer.parseInt(user.getPoint()));
//		
//		if(totalPrice > Integer.parseInt(user.getPoint())) {
//			return "alert/pointErr";
//		}
	
		if(!price.equals(auction.getHigh())) {
			auctionService.testScheduler(auction.getEndAuc(), aNum, user.getuNum());
		}else {
			auctionService.updateBidAuctionState();
			auctionService.testScheduler(new Date(), aNum, user.getuNum());
		}
		
		Bid b = new Bid();
		b.setAuc(auction);
		b.setParticipant(user);
		b.setPrice(price);
		b.setBidDate(new Date());
		
		orderService.insertOrder(b);
		int result = bidService.insertBidAuction(b);
		
		Bid bid = bidService.selectBidMaxPrice(aNum);
		
		//point 추가
		userService.addPoint(user.getuNum(), 50);
		
		model.addAttribute("sessionUser", user);
		model.addAttribute("bid", bid);
		model.addAttribute("result", result);
		model.addAttribute("auction", auction);
		
		session.setAttribute("user", user);
		
		return "auction/auctionDetail";
	}
	
}