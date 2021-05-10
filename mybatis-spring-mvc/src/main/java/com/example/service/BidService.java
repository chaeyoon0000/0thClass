package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Bid;
import com.example.repository.mapper.BidMapperRepository;

@Service
@Transactional
public class BidService {
	@Autowired
	private BidMapperRepository bidRepository;

	public Integer insertBidAuction(Bid bid) {
		return bidRepository.insertBidAuction(bid);
	}

	public Bid selectBidMaxPrice(String aNum) {
		return bidRepository.selectBidMaxPrice(aNum);
	}

	public Integer insertInitBid(Bid bid) {
		return bidRepository.insertInitBid(bid);
	}

	public Integer deleteBid(String aNum) {
		return bidRepository.deleteBid(aNum);
	}
}
