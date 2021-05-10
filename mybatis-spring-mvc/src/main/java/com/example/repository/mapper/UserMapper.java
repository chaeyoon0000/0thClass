package com.example.repository.mapper;

import java.util.Map;

import com.example.model.User;

public interface UserMapper {
	User selectUserById(String id);
	Integer insertUser(User user);
	Integer editUser(User user);
	Integer addPoint(Map<String, Object> paramMap);
	Integer usePoint(Map<String, Object> paramMap);
	Integer searchForId(String id);
}
