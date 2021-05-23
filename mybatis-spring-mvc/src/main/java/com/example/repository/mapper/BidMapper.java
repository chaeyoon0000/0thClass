package com.example.repository.mapper;

import java.util.Date;

import com.example.model.Bid;

public interface BidMapper {

	Integer insertBidAuction(Bid bid);

	Bid selectBidMaxPrice(String aNum);

	Integer deleteExceptWinBid(Bid bid);

	Integer insertInitBid(Bid bid);

	Integer deleteBid(String aNum);

}
