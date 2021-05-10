package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ParameterizableViewController {

	@RequestMapping("/mainPage.do")
	public String enterPage() {
		return "mainPage";
	}
}
