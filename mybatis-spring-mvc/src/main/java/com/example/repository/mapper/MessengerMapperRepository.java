package com.example.repository.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.Messenger;

@Repository
public class MessengerMapperRepository {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Messenger> selectMessengerList(String uNum)  {
		return sqlSession.getMapper(MessengerMapper.class).selectMessengerList(uNum);
	}

	public Messenger selectMessenger(Map<String, Object> num) {
		return sqlSession.getMapper(MessengerMapper.class).selectMessenger(num);
	}

	public Integer insertMessenger(Messenger messenger) {
		return sqlSession.getMapper(MessengerMapper.class).insertMessenger(messenger);
	}

	public List<Messenger> selectMessengerListBySender(String uNum) {
		return sqlSession.getMapper(MessengerMapper.class).selectMessengerListBySender(uNum);
	}

	public List<Messenger> selectMessengerListByReceiver(String uNum) {
		return sqlSession.getMapper(MessengerMapper.class).selectMessengerListByReceiver(uNum);
	}


}
