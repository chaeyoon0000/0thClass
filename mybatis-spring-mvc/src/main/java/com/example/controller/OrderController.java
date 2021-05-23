package com.example.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.example.model.Order;
import com.example.model.Product;
import com.example.model.User;
import com.example.model.WishList;
import com.example.service.OrderService;
import com.example.service.ProductService;
import com.example.service.UserService;
import com.example.service.WishlistService;

@Controller
public class OrderController {
	
	@Autowired
	private WishlistService wishService;
	public void setWishlistService(WishlistService wishService) {
		this.wishService = wishService;
	}

	@Autowired
	private OrderService orderService;
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@Autowired
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Autowired
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping("/user/myOrder.do")
	public String myOrder(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		String uNum = user.getuNum();
		
		List<Product> productList = orderService.getProductOrderList(uNum);
		List<Product> sellproductList = orderService.getSellProductOrderList(uNum);
		
		model.addAttribute("pList", productList);
		model.addAttribute("sellpList", sellproductList);

		return "user/order";
	}
	
	@RequestMapping("/wishlist/newOrder.do/{pNum}/{price}/{wNum}")
	public String order(@PathVariable("pNum") String pNum, @PathVariable("price") String price, @PathVariable("wNum") String wNum,
			HttpSession session, HttpServletResponse response) throws Exception {
		User owner = (User) session.getAttribute("user");
		String uNum = owner.getuNum();
		owner.setuNum(uNum);
		
		WishList order = new WishList();
		order.setOwner(owner);
		order.setItem(pNum);
		order.setwNum(wNum);
		order.setKind("2");
		order.setPrice(price);
		
		int totalPrice = Integer.parseInt(price);
		
		if(totalPrice > Integer.parseInt(owner.getPoint())) {
			return "alert/pointErr";
		}
		
		orderService.insertOrder(order);
		wishService.deleteProductFromWish(uNum, order.getwNum());

		int usePoint = Integer.parseInt(price);
		userService.usePoint(owner.getuNum(), usePoint);
		User seller = productService.getSellerBypNum(pNum);
		userService.addPoint(seller.getuNum(), usePoint);
		int nowPointIs = Integer.parseInt(owner.getPoint()) - usePoint;
		owner.setPoint(Integer.toString(nowPointIs));
		
		session.setAttribute("user", owner);
		//response.setContentType("text/html; charset=UTF-8");
		//PrintWriter out = response.getWriter();
		//out.println("<script>alert('구매하였습니다.'); history.go(-1);</script>");
		//out.flush();

		return "redirect:/wishlist/listWishs.do";
	}
	
	@RequestMapping("/product/newOrder.do/{pNum}/{price}")
	public String order2(@PathVariable("pNum") String pNum, @PathVariable("price") String price,
			HttpSession session, HttpServletResponse response) throws Exception {
		
		User owner = (User) session.getAttribute("user");
		String uNum = owner.getuNum();
		owner.setuNum(uNum);
		
		WishList order = new WishList();
		order.setOwner(owner);
		order.setItem(pNum);
		order.setKind("2");
		order.setPrice(price);
		
		int totalPrice = Integer.parseInt(price);
		
		if(totalPrice > Integer.parseInt(owner.getPoint())) {
			
			return "alert/pointErr";
		}
		
		orderService.insertOrder2(order);
		
		
		int usePoint = Integer.parseInt(price);
		userService.usePoint(owner.getuNum(), usePoint);
		User seller = productService.getSellerBypNum(pNum);
		userService.addPoint(seller.getuNum(), usePoint);
		int nowPointIs = Integer.parseInt(owner.getPoint()) - usePoint;
		owner.setPoint(Integer.toString(nowPointIs));
		
		session.setAttribute("user", owner);
		
		//response.setContentType("text/html; charset=UTF-8");
		//PrintWriter out = response.getWriter();
		//out.println("<script>alert('구매하였습니다.'); history.go(-1);</script>");
		//out.flush();


        return "redirect:/product/productDetail.do/{pNum}";
	}
	
	@RequestMapping("/wishlist/newOrder.do")
	public String productListOrder(
			@RequestParam(value="checkedProduct",required=true) List<String> value,
			@RequestParam(value="price",required=true) List<String> price,
			@RequestParam(value="wNum",required=true) List<String> wNum,
			HttpSession session, HttpServletResponse response, Model model) throws Exception {
		
		User owner = (User)session.getAttribute("user");
		String uNum = owner.getuNum();
		owner.setuNum(uNum);
		
		int totalPrice = 0;
		for(String p : price) {
			totalPrice += Integer.parseInt(p);
		}
		
		if(totalPrice > Integer.parseInt(owner.getPoint())) {
			return "alert/pointErr";
		}
				
		int i = 0;
		for(String val : value) {
			WishList order = new WishList();
			order.setOwner(owner);
			order.setItem(val);
			order.setKind("2");
			order.setPrice(price.get(i));
			order.setwNum(wNum.get(i));
			
			orderService.insertOrder(order);
			wishService.deleteProductFromWish(uNum, order.getwNum());
			
			int usePoint = Integer.parseInt(price.get(i));
			userService.usePoint(owner.getuNum(), usePoint);
			User seller = productService.getSellerBypNum(val);
			userService.addPoint(seller.getuNum(), usePoint);
			int nowPointIs = Integer.parseInt(owner.getPoint()) - usePoint;
			owner.setPoint(Integer.toString(nowPointIs));
			
			session.setAttribute("user", owner);
			
			i++;
		}
		
		//response.setContentType("text/html; charset=UTF-8");
		//PrintWriter out = response.getWriter();
//		out.println("<script>alert('구매하였습니다.'); history.go(-1);</script>");
		//out.println("<script>alert('구매하였습니다.'); document.location.href = '/mybatis-spring-mvc/wishlist/listWishs.do'; </script>");
		//out.flush();

		return "redirect:/wishlist/listWishs.do";
	}


}
