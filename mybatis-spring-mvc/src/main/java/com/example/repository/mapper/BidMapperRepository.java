package com.example.repository.mapper;

import java.util.Date;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.Bid;

@Repository
public class BidMapperRepository {
	@Autowired
	private SqlSessionTemplate sqlSession;

	public Integer insertBidAuction(Bid bid) {
		return sqlSession.getMapper(BidMapper.class).insertBidAuction(bid);
	}

	public Bid selectBidMaxPrice(String aNum) {
		return sqlSession.getMapper(BidMapper.class).selectBidMaxPrice(aNum);
	}

	public Integer deleteExceptWinBid(Bid bid) {
		return sqlSession.getMapper(BidMapper.class).deleteExceptWinBid(bid);
	}

	public Integer insertInitBid(Bid bid) {
		return sqlSession.getMapper(BidMapper.class).insertInitBid(bid);
	}

	public Integer deleteBid(String aNum) {
		return sqlSession.getMapper(BidMapper.class).deleteBid(aNum);
	}
}
