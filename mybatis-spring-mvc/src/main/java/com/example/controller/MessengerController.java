package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.User;
import com.example.service.MessengerService;

@Controller
public class MessengerController {
	
	@Autowired
	private MessengerService messengerService;
	public void setMessengerService(MessengerService messengerService) {
		this.messengerService = messengerService;
	}

	@ModelAttribute("checkStatusList")
	public String[] referenceStatusList() {
		return new String[] {"모든 쪽지", "받은 쪽지", "보낸 쪽지"};
	}
	
	@RequestMapping("/messenger/listMessengers.do")
	public ModelAndView viewList(HttpSession session) throws Exception {
		User user = (User) session.getAttribute("user");
		String uNum = user.getuNum();
		return new ModelAndView("messenger/messengerList", "messengerList", messengerService.getMessengerList(uNum));
	}
	
	@RequestMapping("/messenger/messengerDetail.do/{mNum}")
	public ModelAndView viewMessenger(@PathVariable String mNum, HttpSession session) throws Exception {
		User user = (User) session.getAttribute("user");
		String uNum = user.getuNum();
		return new ModelAndView("messenger/messengerDetail", "messenger", messengerService.getMessenger(uNum, mNum));
	}
}
