package com.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Messenger;
import com.example.repository.mapper.MessengerMapperRepository;

@Service
public class MessengerService {

	@Autowired
	public MessengerMapperRepository messengerRepository;

	public List<Messenger> getMessengerList(String uNum) {
		return messengerRepository.selectMessengerList(uNum);
	}
	
	public Messenger getMessenger(String uNum, String mNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uNum", uNum);
		map.put("mNum", mNum);
		return messengerRepository.selectMessenger(map);
	}

	@Transactional
	public Integer insertMessage(Messenger messenger) {
		return messengerRepository.insertMessenger(messenger);
	}

	public List<Messenger> getMessengerListBySender(String uNum) {
		return messengerRepository.selectMessengerListBySender(uNum);
	}

	public List<Messenger> getMessengerListByReceiver(String uNum) {
		return messengerRepository.selectMessengerListByReceiver(uNum);
	}
	
}
