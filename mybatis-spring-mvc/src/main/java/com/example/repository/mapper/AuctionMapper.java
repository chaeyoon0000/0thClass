package com.example.repository.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.example.model.Auction;
import com.example.model.User;

public interface AuctionMapper {
	List<Auction> selectAuctions();

	Auction selectAuctionById(String aNum);

	Integer insertAuction(Auction auction);

	Integer updateAuction(Auction auction);

	Integer deleteAuction(String aNum);

	List<Auction> searchAuctionByCategory(String category);

	List<Auction> searchAuctionByKeyword(String category, String keyword);

	Integer updateBidAuctionState();

	List<Auction> selectAuctionsByState(String state);

	Integer closeAuctionBid(Date curTime);

	List<Auction> selectAuctionByCondition(Map<String, Object> condition);

	List<Auction> searchAuctionByState(String state);
} 