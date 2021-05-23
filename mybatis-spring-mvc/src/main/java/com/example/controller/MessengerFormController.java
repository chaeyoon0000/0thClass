package com.example.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.Category;
import com.example.model.Messenger;
import com.example.model.Product;
import com.example.model.User;
import com.example.service.MessengerService;
import com.example.service.UserService;

@Controller
//@RequestMapping({"/messenger/newMessenger.do"})//, "/messenger/newMessenger.do/{receiver_id}"})
public class MessengerFormController {
	
	@Value("messenger/messengerRegister")
	private String formViewName;
	
	@Autowired
	private MessengerService messengerService;
	public void setMessengerService(MessengerService messengerService) {
		this.messengerService = messengerService;
	}
	
	@Autowired
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@ModelAttribute("messengerForm")
	public Messenger formBackingObject(HttpSession session, HttpServletRequest request//,
			//@RequestParam("pNum") String pNum) 
			)throws Exception {		
//		if (pNum != null) {	// edit an existing account
//			return new ProductForm(productService.getProduct(pNum));
//		}
//		else
		{	// create a new account
			System.out.println("accessor method");
			Messenger messenger = new Messenger();
			User sender = (User) session.getAttribute("user");

			messenger.setSender(sender);
			
			return messenger;
		}
	}
	
	@RequestMapping(value="/messenger/newMessenger.do", method = RequestMethod.GET) // form 보여주기
	public String showMessengerForm() {
		System.out.println("newMessenger.do");
		System.out.println("get일 때");
		
		//model.addAttribute("sender", "609");//세션 대신
		return formViewName;
	}
	
	@RequestMapping(value="/messenger/newMessenger.do/{receiver_id}", method = RequestMethod.GET) // form 보여주기
	public String showMessengerForm2(@PathVariable("receiver_id") String receiverId, Model model) {
		System.out.println("newMessenger.do/{" + receiverId + "}");
		System.out.println("get일 때");
		System.out.println("receiver id = " + receiverId);
		model.addAttribute("receiver", receiverId);//세션 대신
		return formViewName;
	}
	
	@RequestMapping(value="/messenger/newMessenger.do", method = RequestMethod.POST) // form 제출하고 나서 신청인지 수정인지
	public String onSubmit(HttpServletRequest request, //HttpSession session,
			@ModelAttribute("messengerForm") Messenger messenger,
			BindingResult result, Model model//, SessionStatus status) throws Exception {
			) throws Exception {
		System.out.println("새 messenger");		
//		validator.validate(productForm, result);
//		System.out.println("에러 검증 전");
		//if (result.hasErrors()) return formViewName;
//		System.out.println("에러 없음");
		//try {
			User receiver = new User();
			//이부분 receiver id로 user db에서 찾기로 대체
			//String receiverId = messenger.getReceiver().getId();
			//User receiver = userService.getUserById(receiverId);
			if(receiver == null) {
				model.addAttribute("error", "Please enter a valid user ID value.");
				messenger.getReceiver().setId("");
				model.addAttribute("messenger", messenger);
				return "messenger/messengerList";
			}
			
			receiver = userService.selectUserById(messenger.getReceiver().getId());
			messenger.setReceiver(receiver);

			messenger.setDate(Calendar.getInstance().getTime());

			messengerService.insertMessage(messenger);
			//model.addAttribute("product", product);
				
			System.out.println("insert문 실행");
			System.out.println("mNum=" + messenger.getmNum());
		//	}
//			else {
//				int rslt = productService.updateProduct(product);
//			}
		//}
		//catch (DataIntegrityViolationException ex) {
		//	result.rejectValue("account.username", "USER_ID_ALREADY_EXISTS",
		//			"User ID already exists: choose a different ID.");
		//	return formViewName; 
		//}
		
//		UserSession userSession = new UserSession(
//			petStore.getAccount(accountForm.getAccount().getUsername()));
//		PagedListHolder<Product> myList = new PagedListHolder<Product>(
//			petStore.getProductListByCategory(accountForm.getAccount().getFavouriteCategoryId()));
//		myList.setPageSize(4);
//		userSession.setMyList(myList);
//		session.setAttribute("userSession", userSession);
	//	model.addAttribute("productForm", product);
	//	status.setComplete();
		return "redirect:listMessengers.do";
	}
	
	
}
