package com.example.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Auction;
import com.example.model.Bid;
import com.example.model.Category;
import com.example.model.User;
import com.example.service.AuctionService;
import com.example.service.BidService;
import com.example.service.CategoryService;
import com.example.service.UserService;

@Controller
public class AuctionFormController implements ApplicationContextAware {
	private WebApplicationContext context;	
	private String uploadDir;
	
	@Override
	public void setApplicationContext(ApplicationContext appContext)
		throws BeansException {
		this.context = (WebApplicationContext) appContext;
		this.uploadDir = context.getServletContext().getRealPath("/resources/");
		// /WEB-INF/upload/ 경로는 맞으나 jsp에서 현재 경로 얻어오면 file not found error
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
	public void setBidService(BidService bidService) {
		this.bidService = bidService;
	}
	
	@Autowired
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/auction/newAuction.do")
	public String showNewAuctionForm(HttpSession session, Model model) {
		User sessionUser = (User)session.getAttribute("user");
		
		if(sessionUser == null) {
			return "user/login";
		}
		
		List<Category> categoryList = categoryService.getCategoryList();
		
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("user", sessionUser);
		
		return "auction/auctionRegister";
	}
	
	@RequestMapping(value = "/auction/editAuction.do/{aNum}", method=RequestMethod.GET)
	public String showEditAuctionForm(HttpSession session, @PathVariable("aNum") String aNum, Model model) {
		User sessionUser = (User)session.getAttribute("user");
		
		if(sessionUser == null) {
			return "user/login";
		}
		
		Auction auction = auctionService.selectAuctionById(aNum);
		List<Category> categoryList = categoryService.getCategoryList();
		
		model.addAttribute("auction", auction);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("user", sessionUser);
		
		return "auction/auctionRegister2";
	}
	
	@RequestMapping(value = "/auction/insertNewAuction.do", method = RequestMethod.POST)
	public String insertNewAuction(HttpSession session, AuctionCommand auctionCommand, 
			 @RequestParam("time") String time, MultipartHttpServletRequest request, Model model) {	
		Auction auction = new Auction();
		Category category = new Category();
		
		Date startAuc = new Date();
		
		Date date = auctionCommand.getEndAuc();

		int hour = Integer.parseInt(time.substring(0, 2));
		date.setHours(hour);
		System.out.println(hour);
		
		int minutes = Integer.parseInt(time.substring(3, 5));
		date.setMinutes(minutes);
		System.out.println(minutes);
		
		auctionCommand.setEndAuc(date);
		
		MultipartFile image = auctionCommand.getImage();
		uploadFile(image);
		String uploadedPath = image.getOriginalFilename();
		
		MultipartFile filePath = auctionCommand.getFilePath();
		uploadFile(filePath);
		String uploadedFilePath = filePath.getOriginalFilename();
		
		User user = (User)session.getAttribute("user");
		user.setPoint(user.getPoint()+100);
		
		Category catTitle = categoryService.selectCatTitleById(auctionCommand.getCatNum());
		category.setCatNum(auctionCommand.getCatNum());
		category.setCatTitle(catTitle.getCatTitle());
		
		auction.setaNum(auctionCommand.getaNum());
		auction.setName(auctionCommand.getName());
		auction.setSeller(user);
		auction.setCategory(category);
		auction.setLow(auctionCommand.getLow());
		auction.setHigh(auctionCommand.getHigh());
		auction.setContent(auctionCommand.getContent());	
		auction.setEndAuc(auctionCommand.getEndAuc());
		auction.setStartAuc(startAuc);
		auction.setState("1");
		auction.setImage(uploadedPath);          
        auction.setFilePath(uploadedFilePath);
        
//        Bid bid = new Bid();
//        
//        bid.setAuction(auctionService.selectAuctionById(auctionCommand.getaNum()));
//        bid.setBidDate(null);
//        bid.setParticipant(user);
//        bid.setPrice("0");
//         
//        int initBid = bidService.insertInitBid(bid);	
        
		int result = auctionService.insertAuction(auction);
		
		//작업스케쥴러 발생
		auctionService.testScheduler(auction.getEndAuc(), auctionCommand.getaNum(), user.getuNum());
		
		
//		model.addAttribute("initBid", initBid);
		model.addAttribute("result", result);
		model.addAttribute("auction", auction);
		model.addAttribute("category", catTitle);
		
		session.setAttribute("user", user);

		return "auction/auctionDetail";
	}

	@RequestMapping(value = "/auction/insertEditAuction.do/{aNum}", method = RequestMethod.POST)
	public String insertEditAuction(HttpSession session, @PathVariable("aNum") String aNum, @RequestParam("state") String state,
			AuctionCommand auctionCommand, Model model, MultipartHttpServletRequest request) {
		
		Auction auction = new Auction();
		Category category = new Category();
		
		Category catTitle = categoryService.selectCatTitleById(auctionCommand.getCatNum());
		
		category.setCatNum(auctionCommand.getCatNum());
		category.setCatTitle(catTitle.getCatTitle());
		
		User sessionUser = (User)session.getAttribute("user");
		userService.addPoint(sessionUser.getuNum(), 100);
		
		auction.setaNum(auctionCommand.getaNum());
		auction.setName(auctionCommand.getName());
		auction.setSeller(sessionUser);
		auction.setCategory(category);
		auction.setLow(auctionCommand.getLow());
		auction.setHigh(auctionCommand.getHigh());
		auction.setContent(auctionCommand.getContent());
		auction.setEndAuc(auctionCommand.getEndAuc());
		auction.setStartAuc(auctionCommand.getStartAuc());
		auction.setState(state);
		
		User user = (User)session.getAttribute("user");
		if(state.equals("2"))
			auctionService.testScheduler(new Date(), auctionCommand.getaNum(), user.getuNum());

		int result = auctionService.updateAuction(auction);

		model.addAttribute("result", result);
		model.addAttribute("auction", auction);

		return "auction/auctionDetail";
	}

	private void uploadFile(MultipartFile filePath) {
		System.out.println("업로드 한 파일: "
				+ filePath.getOriginalFilename());
		File file = new File(this.uploadDir + filePath.getOriginalFilename());//this.uploadDir
		try {
			filePath.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
	}	
}