package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.User;
import com.example.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="user/register.do", method=RequestMethod.GET)
	public String registForm() {
		return "user/register";
	}

	@RequestMapping(value="user/register.do", method=RequestMethod.POST)
	public String registUser(UserCommand userCommand, Model model) {
		User user = new User();
		user.setId(userCommand.getId());
		user.setPasswd(userCommand.getPasswd());
		user.setName(userCommand.getName());
		user.setProp(userCommand.getProp());
		user.setAddress(userCommand.getAddress());
		user.setPhone(userCommand.getPhone());
		user.setEmail(userCommand.getEmail());
		user.setBlack("0");
		user.setPoint("0");
		
		int sameId = userService.searchForId(user.getId());

		if(sameId > 0) {
			model.addAttribute("user", user);
			model.addAttribute("err", "idError");
			return "user/register";
		}
		
		userService.insertUser(user);
		
		return "mainPage";
	}
	
	@RequestMapping("user/myPage.do")
	public String myPage(HttpSession session, Model model) {
		
		if(session.getAttribute("user") == null)
			return "user/login";
		
		User user = (User) session.getAttribute("user");
		
		model.addAttribute("user", user);
		
		return "user/myPage";
	}
	
	@RequestMapping(value="user/editUserInfo.do", method=RequestMethod.GET)
	public String editInfoForm(HttpSession session, Model model) {
		
		User user = (User) session.getAttribute("user");
		
		model.addAttribute("user", user);
		
		return "user/myPageUpdate";
	}
	
	@RequestMapping(value="user/editUserInfo.do", method=RequestMethod.POST)
	public String editInfo(HttpSession session, Model model, UserCommand userCommand) {
		User user = new User();
		user.setPasswd(userCommand.getPasswd());
		user.setName(userCommand.getName());
		user.setProp(userCommand.getProp());
		user.setAddress(userCommand.getAddress());
		user.setPhone(userCommand.getPhone());
		user.setEmail(userCommand.getEmail());
		
		User sessionUser = (User)session.getAttribute("user");
		user.setuNum(sessionUser.getuNum());
		userService.editUser(user);
		
		user = userService.selectUserById(sessionUser.getId());
		model.addAttribute("user", user);
		session.setAttribute("user", user);
		
		return "user/myPage";
	}
}
