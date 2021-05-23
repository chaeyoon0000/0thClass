package com.example.repository.session;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.Auction;

public class AuctionSessionRepository {
	@Autowired
	private SqlSessionTemplate sqlSession;

	private final String namespace = "com.example.repository.mapper.AuctionMapper";
	
	public List<Auction> selectAuctions() {
		return sqlSession.selectList(namespace + ".selectAuctions");
	}
}
