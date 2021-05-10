package com.example.repository.mapper;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.User;

@Repository
public class UserMapperRepository {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public User selectUserById(String id) {
		return sqlSession.getMapper(UserMapper.class).selectUserById(id);
	}
	
	public Integer insertUser(User user) {
		Integer result = sqlSession.getMapper(UserMapper.class).insertUser(user);
		return result;
	}

	public Integer editUser(User user) {
		Integer result = sqlSession.getMapper(UserMapper.class).editUser(user);
		return result;
	}

	public Integer addPoint(Map<String, Object> paramMap) {
		Integer result = sqlSession.getMapper(UserMapper.class).addPoint(paramMap);
		return result;
	}
	
	public Integer usePoint(Map<String, Object> paramMap) {
		Integer result = sqlSession.getMapper(UserMapper.class).usePoint(paramMap);
		return result;
	}

	public Integer searchForId(String id) {
		Integer result = sqlSession.getMapper(UserMapper.class).searchForId(id);
		return result;
	}
}
