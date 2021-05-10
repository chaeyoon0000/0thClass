# 0thClass
README.md of Software System Development in DongDuk.W.Univ by Chaeyoon Kim.

## OutLine
*0교시란?*
바쁜 현대인에게 정규 수업 같은 일상에서 벗어나 ‘0교시’에서는 재능 기부 및 거래를 통한 자유로운 배움터를 제공합니다.

1. Meet
10대부터 60대까지 혹은 그 이상이라도, 성별에 상관없이 누구나 원한다면 여러 사람들과 직접 만남을 통해 다양한 재능을 공유할 수 있습니다.

2. Talent
재능기부 봉사자들은 자신의 경력, 노하우 등을 발휘하여 봉사하며 자존감을 높이고, 재능기부 수혜자들은 자신의 상황에 맞는 맞춤형 혜택을 받을 수 있습니다.

3. Choice
한눈에 들어오는 PPT 디자인 제작, A+ 받을 수 있는 레포트 작성법, 다양한 프로젝트 경험 등 다양한 카테고리 안에서 나에게 필요한 재능을 선택할 수 있는 폭넓은 교실을 제공합니다.

## Main Features
* 모임용 재능기부
모임을 결성하여 팀장은 팀원들에게 재능을 기부

* 거래용 재능기부
포인트를 이용하여 재능을 거래

* 경매
제한 시간 내에 포인트를 가장 높이 부르는 사람에게 파는 일

* ChatBot
사용자의 입력 값(키워드)를 통해 알맞은 모임 추천

* Mini Home
팀 결성 후, 팀원들만 공유할 수 있는 커뮤니티인 Mini Home 제공

* 위시리스트
참여 혹은 구매를 원하는 재능기부 항목에 대해 위시리스트에 보관

## Use Case Diagram
#### 모임용 재능 기부 관리
<img src="https://user-images.githubusercontent.com/79551041/117673135-76947500-b1e5-11eb-8bbb-56be9b01c958.png" width="700" height="370">

#### 1:1 거래용 재능 기부 관리
<img src="https://user-images.githubusercontent.com/79551041/117673518-d1c66780-b1e5-11eb-8511-d754e8234f33.png" width="700" height="370">

#### 경매용 재능 기부 관리
<img src="https://user-images.githubusercontent.com/79551041/117673584-e0ad1a00-b1e5-11eb-9613-82261ddb5a29.png" width="700" height="370">

#### 위시리스트 관리
<img src="https://user-images.githubusercontent.com/79551041/117673682-f3bfea00-b1e5-11eb-86e4-2cd0bb9b1ea0.png" width="700" height="370">

#### 마이페이지 관리
<img src="https://user-images.githubusercontent.com/79551041/117673793-105c2200-b1e6-11eb-9d76-97033e748d40.png" width="700" height="370">

## E-R Diagram
<img src="https://user-images.githubusercontent.com/79551041/117673891-2bc72d00-b1e6-11eb-91c3-cf768902c289.png" width="700" height="370">
* Category테이블을 참조하여 아이템의 성격 분류
* 시퀀스 하위 두 자리를 통해 각 아이템을 구별
* CHEK조건 사용으로 wishlist와 order의 item에는 product, auction, team의 기본키만 들어갈 수 있도록 지정
* Apply와 membership으로 테이블을 따로 관리하여 모집중인 팀과 모집 완료된 팀을 구분 할 수 있음

### Code Line
* 경매 기능(Auction, Bid)
```swift
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
		scheduler.schedule(updateTableRunner, closingTime);  	
		System.out.println("updateTableRunner has been scheduled to execute at " + closingTime);
	}
```

* Message(RESTful)
```
@RequestMapping(value = "/messenger/getMessengerBySender.do/{uNum}", method = RequestMethod.GET, 
            produces = "application/json")
	@ResponseBody
	public MessengerList getMessengersBySender(@PathVariable("uNum") String uNum, HttpServletResponse response)
			throws IOException {
		System.out.println("/messenger/getMessengerBySender.do/{uNum} request accepted: {uNum} = " + uNum);
		List<Messenger> messengerList = this.messengerService.getMessengerListBySender(uNum);
		if (messengerList == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		System.out.println("/messenger/getMessengerBySender.do/{uNum} request return 직전");
		return new MessengerList(messengerList);  // convert list of products to JSON text in response body
	}
	
	@RequestMapping(value = "/messenger/getMessengerByReceiver.do/{uNum}", method = RequestMethod.GET, 
            produces = "application/json")
	@ResponseBody
	public MessengerList getMessengersByReceiver(@PathVariable("uNum") String uNum, HttpServletResponse response)
			throws IOException {
		System.out.println("/messenger/getMessengerByReceiver.do/{uNum} request accepted: {uNum} = " + uNum);
		List<Messenger> messengerList = this.messengerService.getMessengerListByReceiver(uNum);
		if (messengerList == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		System.out.println("/messenger/getMessengerByReceiver.do/{uNum} request return 직전");		
		return new MessengerList(messengerList);  // convert list of products to JSON text in response body
	}
  ```
  
### Human Resources
|||
|:---|:---:|---:| 
|개발 투입 인력|4인| 
|개발 기간|2019.03~2019.06|
|담당 역할|풀스택 개발|

<br>






# 1. 제목(글머리) 작성
# H1 제목  
## H2 부제목
### H3 소제목
#### H4 제목4
##### H5 제목5
###### H6 제목6


# 2. 번호 없는 리스트 작성
* 리스트1
  - 리스트2
    + 리스트3
    
# 3. 번호 있는 리스트 작성
1. 리스트1
2. 리스트2
3. 리스트3 

# 4. 이텔릭체(기울어진 글씨) 작성
*텍스트*

# 5. 굵은 글씨 작성
**텍스트**

# 6. 인용
> 인용1

> 인용2
>> 인용안의 인용

# 7. 수평선 넣기

---
  
# 8. 링크 달기
(1) 인라인 링크  

[블로그 주소](https://lsh424.tistory.com/)

(2) 참조 링크  

[블로그 주소][blog]

[blog]: https://lsh424.tistory.com/

# 9. 이미지 추가하기
![이탈리아 포지타노](https://user-images.githubusercontent.com/31477658/85016059-f962aa80-b1a3-11ea-8c91-dacba2666b78.jpeg)

### 이미지 사이즈 조절
<img src="https://user-images.githubusercontent.com/31477658/85016059-f962aa80-b1a3-11ea-8c91-dacba2666b78.jpeg"  width="700" height="370">

### 이미지 파일로 추가하기
<img src="Capri_Island.jpeg" width="700">

# 10. 코드블럭 추가하기

```swift
public struct CGSize {
  public var width: CGFloat
  public var heigth: CGFloat
  ...
}
```

# etc

**텍스트 굵게**  
~~텍스트 취소선~~

### [개행]  

스페이스바를 통한 문장개행  
스페이스바를 통한 문장개행  

br태그를 사용한 문장개행
<br>
<br>
br태그를 사용한 문장개행


### [체크박스]

다음과 같이 체크박스를 표현 할 수 있습니다. 
* [x] 체크박스
* [ ] 빈 체크박스
* [ ] 빈 체크박스

### [이모지 넣기]
❤️💜💙🤍

### [표 넣기]
|왼쪽 정렬|가운데 정렬|오른쪽 정렬| 
|:---|:---:|---:| 
|내용1|내용2|내용3| 
|내용1|내용2|내용3| 

<br>

### 정리내용
[정리 내용 보기](https://lsh424.tistory.com/37)
