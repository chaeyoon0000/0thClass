package com.example.repository.mapper;

import java.util.List;
import java.util.Map;

import com.example.model.Messenger;
import com.example.model.Product;

public interface MessengerMapper {
	
	List<Messenger> selectMessengerList(String uNum);
	
	Messenger selectMessenger(Map<String, Object> num);

	Integer insertMessenger(Messenger messenger);

	List<Messenger> selectMessengerListBySender(String uNum);

	List<Messenger> selectMessengerListByReceiver(String uNum);


}
