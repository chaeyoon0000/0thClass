package com.example.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Auction;
import com.example.model.Bid;
import com.example.model.User;
import com.example.model.WishList;
import com.example.repository.mapper.AuctionMapperRepository;
import com.example.repository.mapper.BidMapperRepository;
import com.example.repository.mapper.OrderMapper;
import com.example.repository.mapper.OrderMapperRepository;
import com.example.repository.mapper.UserMapper;
import com.example.repository.mapper.UserMapperRepository;
import com.example.repository.mapper.WishlistMapper;

@Service
@Transactional
public class AuctionService {
	@Autowired
	private AuctionMapperRepository auctionRepository;
	
	@Autowired
	private BidMapperRepository bidRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	public WishlistMapper wishMapper;

	public List<Auction> getAuctionList() {
		return auctionRepository.selectAuctions();
	}

	public Integer insertAuction(Auction auction) {
		return auctionRepository.insertAuction(auction);
	}

	public Integer updateAuction(Auction auction) {
		return auctionRepository.updateAuction(auction);
	}

	public Integer deleteAuction(String aNum) {
		return auctionRepository.deleteAuction(aNum);
	}

	public Auction selectAuctionById(String aNum) {
		return auctionRepository.selectAuctionById(aNum);
	}

	public List<Auction> searchAuctionByCategory(String category) {
		return auctionRepository.searchAuctionByCategory(category) ;
	}

	public Integer updateBidAuctionState() {
		return auctionRepository.updateBidAuctionState();
	}
	
	public List<Auction> getAuctionStateList(String state) {
		return auctionRepository.selectAuctionsByState(state);
	}
	
//	@Autowired
//	private Auction eventDao;
	
	@Autowired		// applicationContext.xml에 정의된 scheduler 객체를 주입 받음
	private ThreadPoolTaskScheduler scheduler;
	
	public void testScheduler(Date closingTime, String aNum, String uNum) {
		
		Runnable updateTableRunner = new Runnable() {	
			// anonymous class 정의
			@Override
			public void run() {	
				Date curTime = new Date();
				System.out.println("scheduler 실행");
				//경매 상태 Closed로 업데이트
				auctionRepository.closeAuctionBid(curTime);
				
				//마감일이 되면 경매 진행 상태 테이블인 bid에서 낙찰가(가장 먼저 높은 가격을 제시한 것) 구함
				Bid bid = bidRepository.selectBidMaxPrice(aNum);
				bid.setAuc(auctionRepository.selectAuctionById(aNum));
				bid.setParticipant(userMapper.selectUserById(uNum));
				
				//낙찰가를 제외한 해당 게시글에 올라온 경매는 모두 삭제 (->목적: db의 불필요한 데이터 삭제)
				bidRepository.deleteExceptWinBid(bid);				
				
				//오더테이블에 해당 경매 insert
				System.out.println("orderService insertProduct"); System.out.println("orderService 끝");
				
				if(auctionRepository.selectAuctionById(aNum).getState().equals("2")) {
					orderMapper.insertAuctionOrder(bid);
				}
				
				User user = userMapper.selectUserById(bid.getParticipant().getuNum());
				
				String total = Integer.toString((Integer.parseInt(user.getPoint())-Integer.parseInt(bid.getPrice())));
				user.setPoint(total);
				
				
				//게시글 업로더에게는 경매 낙찰가에 해당하는 포인트 지급
				Map<String, Object> pointMap = new HashMap<String, Object>();
				pointMap.put("uNum", auctionRepository.selectAuctionById(aNum).getSeller().getuNum());
				pointMap.put("point", Integer.parseInt(bid.getPrice()));
				userMapper.addPoint(pointMap);
				
				System.out.println("updateTableRunner is executed at " + curTime);
			}
		};
		
//		HashMap<String, Date> hashMap = new HashMap<String, Date>();
//		hashMap.put("curTime", new Date());			// 현재 시각: PK 값으로 사용
//		hashMap.put("closingTime", closingTime);	// 미래의 종료 시각
//		auctionRepository.insertNewBid(hashMap);	// EVENTS 테이블에 레코드 삽입
//
//		// 스케줄 생성: closingTime에 updateTableRunner.run() 메소드 실행
		
//		Bid bid = new Bid();
//		bid.setAuction(auctionRepository.);
//		bid.setBidDate(closingTime);
//		bid.setParticipant(participant);
//		bid.setPrice("0");
//		
//		bidRepository.insertInitBid(bid);
		
		scheduler.schedule(updateTableRunner, closingTime);  
		
		System.out.println("updateTableRunner has been scheduled to execute at " + closingTime);
	}

	public List<Auction> searchAuctionByKeyword(String select, String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("select", select);
		map.put("keyword", keyword);
		return auctionRepository.selectAuctionByCondition(map);
	}

	public List<Auction> searchAuctionByState(String state) {
		return auctionRepository.searchAuctionByState(state);
	}
	
	

//	public static List<Auction> searchAuctionByKeyword(String category, String keyword) {
//		return auctionRepository.searchAuctionByKeyword(category, keyword);
//	}
}
