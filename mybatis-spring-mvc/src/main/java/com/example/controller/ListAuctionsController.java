package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Auction;
import com.example.model.Category;
import com.example.model.User;
import com.example.service.AuctionService;
import com.example.service.CategoryService;

@Controller
@SessionAttributes("sesstionAuction")
public class ListAuctionsController implements ApplicationContextAware{
	private static final int countPerPage = 6;
	
	private WebApplicationContext context;	
	
	@Override
	public void setApplicationContext(ApplicationContext appContext)
		throws BeansException {
		this.context = (WebApplicationContext) appContext;
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
	
	@ModelAttribute("sessionAuction")
	public Auction createAuction(HttpSession session) {
		Auction auction = (Auction)session.getAttribute("sessionAuction");
		if(auction == null) auction = new Auction();
		
		return auction;
	}
	
	@RequestMapping("/auction/auctionList.do")//@RequestParam("page") String pageStr,
	public String listAuctions(HttpSession session, @RequestParam("page") String pageStr, Model model) {
		User sessionUser = (User)session.getAttribute("user");
		
		if(sessionUser == null) {
			return "user/login";
		}
		
		int page = Integer.parseInt(pageStr);
		List<Auction> totalAuctionList = auctionService.getAuctionList();
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
		
		List<Category> categoryList = categoryService.getCategoryList();
//		List<Auction> auctionList = auctionService.getAuctionList();
		
		model.addAttribute("categoryList", categoryList);
//		model.addAttribute("auctionList", auctionList);
		
		model.addAttribute("auctionList", pagedAuctionList);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("page", page);
		
		return "auction/auctionList";
	}
	
//	@RequestMapping("/auction/searchAuctions.do")
//	public ModelAndView handleRequest(HttpServletRequest request,
//			@RequestParam(value="keyword", required=false) String keyword,
//			@RequestParam(value="page", required=false) String page) throws Exception{
//		if(keyword != null) {
//			if(!StringUtils.hasLength(keyword)) {
//				return new ModelAndView("Error", "message", 
//						"Please enter a keyword to search for, then press the search button");
//			}
//			
//			PagedListHolder<Auction> auctionList = 
//					new PagedListHolder<Auction>(this.auctionService.searchAuctionByKeyword(keyword.toLowerCase()));
//			
//			auctionList.setPageSize(6);
//			request.getSession().setAttribute("SearchAuctionsController_auctionList", auctionList);
//			
//			return new ModelAndView("auctionList", "auctionList", auctionList);
//		}else {
//			@SuppressWarnings("unchecked")
//			PagedListHolder<Auction> auctionList = 
//					(PagedListHolder<Auction>)request.getSession().getAttribute("SearchAuctionsController_auctionList");
//			
//			if(auctionList == null) {
//				return new ModelAndView("Error", "message", 
//						"Your Session has timed out. Please start over again");
//			}
//			if("next".equals(page)) auctionList.nextPage();
//			else if("previous".equals(page)) auctionList.previousPage();
//			
//			return new ModelAndView("auctionList", "auctionList", auctionList);
//		}
//	}
	
}
