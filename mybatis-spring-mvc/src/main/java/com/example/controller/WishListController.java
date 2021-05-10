package com.example.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.model.Product;
import com.example.model.User;
import com.example.model.WishList;
import com.example.service.ProductService;
import com.example.service.WishlistService;

@Controller
@RequestMapping("/wishlist/*")
public class WishListController {
	
	@Autowired
	private WishlistService wishService;
	public void setWishlistService(WishlistService wishService) {
		this.wishService = wishService;
	}
	
	@Autowired
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	
	@RequestMapping("listWishs.do")
	public String viewWishlist(HttpSession session, Model model) throws Exception {
		User user = (User) session.getAttribute("user");
		String uNum = user.getuNum();
		
		List<WishList> pList = wishService.getProductWishlist(uNum);
		
		model.addAttribute("pList", pList);
	
		return "user/wishlist";
	}
	
	@RequestMapping("addAuctionToWish.do/{aNum}")
	public RedirectView handleAuction(@PathVariable("aNum") String aNum,
			HttpServletResponse response) throws Exception {
		System.out.println("addProduct~ 들어옴");
		//User session에서 User 찾기
		User user = new User();
		user.setuNum("909");
		
		WishList wish = new WishList();
		wish.setOwner(user);
//		wish.setMember(user);
		wish.setItem(aNum);
		wish.setKind("3");
		
		Integer rslt = wishService.addAuctionToWish(wish);
		System.out.println("insert wishlist 완료");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('위시리스트에 추가되었습니다.'); history.go(-1);</script>");
		out.flush();

		RedirectView rv = new RedirectView();
        rv.setContextRelative(true);
        rv.setUrl("/auction/auctionDetail.do/{aNum}");
        return rv;
		
		//return ("redirect:/product/productDetail.do", pNum);
	}
	
	@RequestMapping("deleteAuctionFromWish.do")
	public String handleDeleting (
			@RequestParam(value="checkedProduct",required=true) List<String> value,
//			@RequestParam(value="price",required=true) List<String> price,
			HttpServletResponse response) throws Exception {
		
		//user session에서 uNum..
		User owner = new User();
		String uNum = "609";
		
		System.out.println("wishListController 시작");
				
		int i = 0;
		for(String val : value) {
			
			Integer rslt = wishService.deleteFromWishlist(uNum, val);
			System.out.println("insertOrder " + (i+1) + "번 됨!");
			
			i++;
		}
		System.out.println("orderController 끝");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
//		out.println("<script>alert('구매하였습니다.'); history.go(-1);</script>");
		out.println("<script>alert('구매하였습니다.'); document.location.href = '/mybatis-spring-mvc/wishlist/listWishs.do'; </script>");
		out.flush();

		return "redirect:listWishs.do";
	}
	
	@RequestMapping("addProductToWish.do/{pNum}")
	public RedirectView handleProduct(@PathVariable("pNum") String pNum, HttpSession session,
			HttpServletResponse response) throws Exception {
		User user = (User) session.getAttribute("user");
		
		WishList wish = new WishList();
		wish.setOwner(user);
		wish.setItem(pNum);
		wish.setKind("2");
		
		wishService.addProductToWish(wish);
		
		response.setContentType("text/html; charset=UTF-8");
		//PrintWriter out = response.getWriter();
		//out.println("<script>alert('위시리스트에 추가되었습니다.'); history.go(-1);</script>");
		//out.flush();

		RedirectView rv = new RedirectView();
        rv.setContextRelative(true);
        rv.setUrl("/product/productDetail.do/{pNum}");
        return rv;
		
		//return ("redirect:/product/productDetail.do", pNum);
	}
	
//	@RequestMapping("addProductToWish.do/{pNum}")
//	public String handleProduct(@PathVariable("pNum") String pNum, Model model) throws Exception {
//		System.out.println("addProduct~ 들어옴");
//		//User session에서 User 찾기
//		User user = new User();
//		user.setuNum("609");
//		
//		WishList wish = new WishList();
//		wish.setOwner(user);
//		wish.setItem(pNum);
//		wish.setKind("2");
//		
//		Integer rslt = wishService.addProductToWish(wish);
//		System.out.println("insert wishlist 완료");
//		
//
//		model.addAttribute("msg", "위시리스트에 추가되었습니다."); 
//		model.addAttribute("url", "/product/productDetail.jsp"); 
//
//		return "redirect"; 
//
////		RedirectView rv = new RedirectView();
////        rv.setContextRelative(true);
////        rv.setUrl("/product/productDetail.do/{pNum}");
////        return rv;
//		
//		//return ("redirect:/product/productDetail.do", pNum);
//	}

	//위시에서 삭제 부분 구현 필요
//	@RequestMapping("deleteProductFromWish.do")
//	public String handleDeleteing() {
//			deleteFromWishlist
//	}
	
	@RequestMapping("deleteProductFromWish.do")
	public String handleDeleting (
			@RequestParam(value="checkedProduct",required=true) List<String> value,
			@RequestParam(value="wNum",required=true) List<String> wNum,
//			@RequestParam(value="price",required=true) List<String> price,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		User owner = (User) session.getAttribute("user");
		String uNum = owner.getuNum();
			
		int i = 0;
		for(String val : value) {
			System.out.println("wNum is" + wNum.get(i));
			wishService.deleteProductFromWish(uNum, wNum.get(i));
			
			i++;
		}
		
//		response.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.println("<script>alert('구매하였습니다.'); history.go(-1);</script>");
//		out.println("<script>alert('구매하였습니다.'); document.location.href = '/mybatis-spring-mvc/wishlist/listWishs.do'; </script>");
//		out.flush();

		return "redirect:listWishs.do";
	}

}
