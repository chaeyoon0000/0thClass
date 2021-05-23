package com.example.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.User;
import com.example.repository.mapper.UserMapperRepository;

@Service
public class UserService {
	
	@Autowired
	private UserMapperRepository userRepository;
	
	public User selectUserById(String id) {
		return userRepository.selectUserById(id);
	}
	
	@Transactional
	public Integer insertUser(User user) {
		return userRepository.insertUser(user);
	}

	@Transactional
	public Integer editUser(User user) {
		return userRepository.editUser(user);
	}

	@Transactional
	public Integer addPoint(String uNum, int i) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uNum", uNum);
		map.put("point", i);
		return userRepository.addPoint(map);
	}
	
	@Transactional
	public Integer usePoint(String uNum, int i) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uNum", uNum);
		map.put("point", i);
		return userRepository.usePoint(map);
	}

	public Integer searchForId(String id) {
		
		return userRepository.searchForId(id);
	}
}
