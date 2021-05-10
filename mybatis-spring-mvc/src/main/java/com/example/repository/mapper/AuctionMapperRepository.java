package com.example.repository.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.Auction;
import com.example.model.User;

@Repository
public class AuctionMapperRepository {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Auction> selectAuctions() {
		return sqlSession.getMapper(AuctionMapper.class).selectAuctions();
	}

	public Auction selectAuctionById(String aNum) {
		return sqlSession.getMapper(AuctionMapper.class).selectAuctionById(aNum);
	}

	public Integer insertAuction(Auction auction) {
		return sqlSession.getMapper(AuctionMapper.class).insertAuction(auction);
	}

	public Integer updateAuction(Auction auction) {
		return sqlSession.getMapper(AuctionMapper.class).updateAuction(auction);
	}

	public Integer deleteAuction(String aNum) {
		return sqlSession.getMapper(AuctionMapper.class).deleteAuction(aNum);
	}

	public List<Auction> searchAuctionByCategory(String category) {
		return sqlSession.getMapper(AuctionMapper.class).searchAuctionByCategory(category);
	}

	public List<Auction> searchAuctionByKeyword(String category, String keyword) {
		return sqlSession.getMapper(AuctionMapper.class).searchAuctionByKeyword(category, keyword);
	}

	public Integer updateBidAuctionState() {
		return sqlSession.getMapper(AuctionMapper.class).updateBidAuctionState();
	}

	public List<Auction> selectAuctionsByState(String state) {
		return sqlSession.getMapper(AuctionMapper.class).selectAuctionsByState(state);
	}

	public Integer closeAuctionBid(Date curTime) {
		return sqlSession.getMapper(AuctionMapper.class).closeAuctionBid(curTime);
	}

	public List<Auction> selectAuctionByCondition(Map<String, Object> condition) {
		return sqlSession.getMapper(AuctionMapper.class).selectAuctionByCondition(condition);
	}

	public List<Auction> searchAuctionByState(String state) {
		return sqlSession.getMapper(AuctionMapper.class).searchAuctionByState(state);
	}
}
