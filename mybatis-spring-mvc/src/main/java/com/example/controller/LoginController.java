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
public class LoginController {
	
	@Autowired
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/login/login.do", method=RequestMethod.GET)
	public String toLogin() {//id, pw 입력 창으로 이동
		return "user/login";
	}
	
	@RequestMapping(value="/login/login.do", method=RequestMethod.POST)
	public String login(LoginCommand loginCommand, HttpSession session, Model model) {//로그인
		
		User user = userService.selectUserById(loginCommand.getId());
		
		if(user == null) {
			model.addAttribute("error", "noSuchIdError");
			model.addAttribute("id", loginCommand.getId());
			model.addAttribute("password", loginCommand.getPassword());
			return "user/login";
		} else if(!user.getPasswd().equals(loginCommand.getPassword())) {
			model.addAttribute("error", "pwError");
			model.addAttribute("id", loginCommand.getId());
			model.addAttribute("password", loginCommand.getPassword());
			return "user/login";
		}
		
		session.setAttribute("user", user);
		
		return "mainPage";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {//로그아웃
		session.setAttribute("user", null);
		return "mainPage";
	}

}
