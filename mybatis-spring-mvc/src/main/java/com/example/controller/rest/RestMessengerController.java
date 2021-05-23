package com.example.controller.rest;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.MessengerController;
import com.example.controller.ProductForm;
import com.example.model.Messenger;
import com.example.service.MessengerService;

@Controller	@ResponseBody
public class RestMessengerController {

	//private static Logger logger = LoggerFactory.getLogger(MessengerController.class);
	@Autowired
	private MessengerService messengerService;
	public void setMessengerService(MessengerService messengerService) {
		this.messengerService = messengerService;
	}
	
	@RequestMapping(value = "/messenger/getMessengerAll.do/{uNum}", method = RequestMethod.GET, 
            produces = "application/json")
	@ResponseBody
	public MessengerList getMessengersAll(@PathVariable("uNum") String uNum, HttpServletResponse response)
			throws IOException {
		System.out.println("/messenger/getMessengerAll.do/{uNum} request accepted: {uNum} = " + uNum);
		List<Messenger> messengerList = this.messengerService.getMessengerList(uNum);
		if (messengerList == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		System.out.println("/messenger/getMessengerAll.do/{uNum} request return 직전");
		return new MessengerList(messengerList);  // convert list of products to JSON text in response body
	}

	@RequestMapping(value = "/messenger/getMessengerBySender.do/{uNum}", method = RequestMethod.GET, 
            produces = "application/json")
	@ResponseBody
	public MessengerList getMessengersBySender(@PathVariable("uNum") String uNum, HttpServletResponse response)
			throws IOException {
		System.out.println("/messenger/getMessengerBySender.do/{uNum} request accepted: {uNum} = " + uNum);
		List<Messenger> messengerList = this.messengerService.getMessengerListBySender(uNum);
		if (messengerList == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		System.out.println("/messenger/getMessengerBySender.do/{uNum} request return 직전");
		return new MessengerList(messengerList);  // convert list of products to JSON text in response body
	}
	
	@RequestMapping(value = "/messenger/getMessengerByReceiver.do/{uNum}", method = RequestMethod.GET, 
            produces = "application/json")
	@ResponseBody
	public MessengerList getMessengersByReceiver(@PathVariable("uNum") String uNum, HttpServletResponse response)
			throws IOException {
		System.out.println("/messenger/getMessengerByReceiver.do/{uNum} request accepted: {uNum} = " + uNum);
		List<Messenger> messengerList = this.messengerService.getMessengerListByReceiver(uNum);
		if (messengerList == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		System.out.println("/messenger/getMessengerByReceiver.do/{uNum} request return 직전");		
		return new MessengerList(messengerList);  // convert list of products to JSON text in response body
	}
	
}
	
	
