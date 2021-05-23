package com.example.controller.rest;

import java.util.List;

import com.example.model.Messenger;

public class MessengerList {

private List<Messenger> messengers;
	
	public MessengerList() {
		
	}
	
	public MessengerList(List<Messenger> messengers) {
		this.messengers = messengers;
	}

	public List<Messenger> getMessengers() {
		return messengers;
	}

	public void setMessengers(List<Messenger> messengers) {
		this.messengers = messengers;
	}
}
