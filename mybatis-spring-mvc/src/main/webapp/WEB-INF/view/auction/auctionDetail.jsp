<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%

	request.setCharacterEncoding("UTF-8");

	session = request.getSession(true); 

	String id = request.getParameter("id"); 

	request.getSession().setAttribute("id", id); 

%>

<html>
<head>
<title>Funder &mdash; Colorlib Website Template</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/resources/school.ico">
<link rel="icon"
	href="<%=request.getContextPath()%>/resources/school.ico">

<link
	href="https://fonts.googleapis.com/css?family=Oswald:400,700|Work+Sans:300,400,700"
	rel="stylesheet">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstraps/fonts/icomoon/style.css">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstraps/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstraps/css/magnific-popup.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstraps/css/jquery-ui.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstraps/css/owl.carousel.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstraps/css/owl.theme.default.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstraps/css/bootstrap-datepicker.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstraps/css/animate.css">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/mediaelement@4.2.7/build/mediaelementplayer.min.css">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstraps/fonts/flaticon/font/flaticon.css">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstraps/css/aos.css">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstraps/css/style.css">
</head>
<body
	style="background-image: url('<%=request.getContextPath()%>/bootstraps/images/bg.jpg');">

	<div class="site-wrap">

		<div class="site-mobile-menu">
			<div class="site-mobile-menu-header">
				<div class="site-mobile-menu-close mt-3">
					<span class="icon-close2 js-menu-toggle"></span>
				</div>
			</div>
			<div class="site-mobile-menu-body"></div>
		</div>
		<!-- .site-mobile-menu -->


		<div class="site-navbar-wrap js-site-navbar bg-white">

			<div class="container">
				<div class="site-navbar bg-light">
					<div class="row align-items-center">
						<div class="col-2">
							<h2 class="mb-0 site-logo">
								<a href="../mainPage.jsp" class="font-weight-bold">Zero Class</a>
							</h2>
						</div>
						<div class="col-10">
							<nav class="site-navigation text-right" role="navigation">
								<div class="container">
									<div class="d-inline-block d-lg-none ml-md-0 mr-auto py-3">
										<a href="#" class="site-menu-toggle js-menu-toggle text-black"><span
											class="icon-menu h3"></span></a>
									</div>

									<ul class="site-menu js-clone-nav d-none d-lg-block">
										
										<li class="active"><a href="../team/teamList.jsp">Team</a></li>
										<li class="has-children"><a href="productList.jsp">Market</a>
											<ul class="dropdown arrow-top">
												<li><a href="productList.jsp">Product</a></li>
												<li><a href="#">Auction</a></li>
											</ul></li>
										<li><a href="blog.html">Review</a></li>
										<li class="has-children"><a href="../user/myPage.jsp">My Page</a>
											<ul class="dropdown arrow-top">
												<li><a href="../user/myPage.jsp">My Information</a></li>
												<li><a href="../user/order.jsp">Order</a></li>
											</ul>
										<li class="active"><a>somsom</a></li>
										<li class="active"><a>0p</a></li>
										<li><a href="../user/wishlist.jsp"><img src="<%=request.getContextPath()%>/resources/cart.png"/></a></li>
									</ul>
								</div>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>

			<div class="py-5 bg-light">
			<div class="container">
				<div class="row">
					<div class="col-lg-2"></div>
					<div class="col-md-12 col-lg-8 mb-5">
						<form action="<%=request.getContextPath()%>/auction/bidAuction.do/${aNum}" class="p-5 bg-white">
							<p class="h5 text-black mb-3">Auction Information</p>
							<c:if test="${auction.state == 0}"> <!-- open -->
								<p class="h6 text-primary mb-3">Open</p>
							</c:if>
							<c:if test="${auction.state == 1}"> <!-- bid -->
								<p class="h6 text-primary mb-3">Bidding</p>
							</c:if>
							<c:if test="${auction.state == 2}"> <!-- close -->
								<p class="h6 text-primary mb-3">Closed</p>
							</c:if>				
							
							
							<%-- <c:if test="${!empty bid && (bid.aNum == auction.aNum)}"> --%>
								<c:if test="${auction.state == '1'}"> <!-- 수정필요 -->
									<p class="h6 text-primary mb-3">현재 경매 최고가: 
									<c:if test="${!bid.price gt '0'}">${bid.price}</c:if>
									<c:if test="${bid.price eq '0'}">0</c:if>
									</p>
								</c:if>
								<c:if test="${auction.state == '2'}">
										<p class="h6 text-primary mb-3">경매 낙찰가: 
											<c:if test="${!empty bid.price}">${bid.price}</c:if>
											<c:if test="${empty bid.price}">0</c:if>
										</p>
								</c:if>
							 <%-- </c:if> --%>
									<c:if test="${!empty auction.image}">
										<img
										src="<%=request.getContextPath()%>/resources/${auction.image}"
										alt="Image" class="img-fluid">
									</c:if>
									<c:if test="${empty auction.image}">
										<img
										src="<%=request.getContextPath()%>/bootstraps/images/review_default.jpg"
										alt="Image" class="img-fluid">
									</c:if>
<%-- 							<img
									src="<%=request.getContextPath()%>/bootstraps/images/img_1.jpg"
									alt="Image" class="img-fluid">
									<br/><br/> --%>
							<div class="row">
								<div class="col-9">
									</br></br><p class="mb-0 font-weight-bold"><c:out value="<${auction.name}>" /></p></br>
								</div>
								<div class="col-2" style="text-align: right;">
									<p class="mb-4"><c:out value="${auction.seller.name}"/></p>
								</div>
								<div class="col-1">
									<a href="../user/wishlist.jsp"><img
										src="<%=request.getContextPath()%>/resources/envelope.png" /></a>
								</div>
							</div>
							<div class="row">
								<div class="col-2">
									<p class="mb-0 font-weight-bold">Category</p>
								</div>
								<div class="col-10">
									<p class="mb-4">${category.catTitle}</p>
								</div>
							</div>

							<div class="row">
								<div class="col-2">
									<p class="mb-0 font-weight-bold">Low</p>
								</div>
								<div class="col-4">
									<p class="mb-4">${auction.low}</p>
								</div>
								<div class="col-2">
									<p class="mb-0 font-weight-bold">High</p>
								</div>
								<div class="col-4">
									<p class="mb-4">${auction.high}</p>
								</div>
							</div>
							
							<div class="row">
								<div class="col-2">
									<p class="mb-0 font-weight-bold">Start</p>
								</div>
								<div class="col-4">
									<fmt:formatDate value="${auction.startAuc}" pattern="yyyy-MM-dd a HH:mm:ss"/>	
								</div>
								<div class="col-2">
									<p class="mb-0 font-weight-bold">End</p>
								</div>
								<div class="col-4">
									<fmt:formatDate value="${auction.endAuc}" pattern="yyyy-MM-dd a HH:mm:ss"/>	
								</div>
							</div>
							
							<p class="mb-0 font-weight-bold">Content</p>
							<br />
							<p class="mb-4">${auction.content}</p>
							
							<div class="col-2">
								<p class="mb-0 font-weight-bold">File: </p>
							</div>
							<div class="col-4">
								<p class="mb-4">${auction.filePath}</p>
							</div>
							
							
									<a href="<c:url value='/re/fileDownload?reCode=${reward.reCode}'/>">${reward.reDocument}</a>
									<a class="btn btn-primary text-white px-4 py-2" role="button">
												파일 다운로드
											</a>
											<br/>
											<br/>
							
							<div class="row form-group" style="text-align: right">
								<div class="col-md-12">
									<c:if test="${!empty page}">
									<a class="btn btn-outline-primary px-4 py-2" href="<%=request.getContextPath()%>/auction/auctionList.do?page=${page}" role="button">
										 </c:if>
										 <c:if test="${empty page}">
									<a class="btn btn-outline-primary px-4 py-2" href="<%=request.getContextPath()%>/auction/auctionList.do?page=1" role="button">
										 </c:if>
										목록으로
									</a>
									<!-- 작성자가 아닐 시 ****** 여기부터 ********-->
									<c:if test="${auction.state eq '1'}">
										<c:if test="${sessionScope.user.id ne auction.seller.id}">
											<a class="btn btn-primary text-white px-4 py-2" href="/mybatis-spring-mvc/wishlist/addAuctionToWish.do/${auction.aNum}" role = "button">
												찜하기
											</a>
										</c:if>
									</c:if>
									<!-- <div class="modal fade" id="wishModal" tabindex="-1"
										role="dialog" aria-labelledby="wishModalLabel"
										aria-hidden="true">
										<div class="modal-dialog" role="document">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title" id="exampleModalLabel">Inform</h5>
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
												</div>
												<div class="modal-body" style="text-align: left">위시리스트에
													정상적으로 담겼습니다.</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-outline-primary"
														data-dismiss="modal">확인</button>
													<a class="btn btn-primary text-white"
														href="../user/wishlist.jsp" role="button">위시리스트 보러 가기</a>
												</div>
											</div>
										</div>
									</div> -->
									
									<c:if test="${auction.state == 1}">
										<c:if test="${sessionScope.user.id ne auction.seller.id}">
											<a class="btn btn-primary text-white px-4 py-2" role="button" data-toggle="modal" data-target="#joinModal">경매참여</a>
										</c:if>
									</c:if>
									<div class="modal fade" id="joinModal" tabindex="-1"
										role="dialog" aria-labelledby="joinModalLabel"
										aria-hidden="true">
										<div class="modal-dialog" role="document">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title" id="exampleModalLabel">Inform</h5>
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
												</div>
												
												<div class="modal-body" style="text-align: left">경매에 참여하시겠습니까?</div>
												<input type="text" class="form-control" id="price" name="price" placeholder="경매 제시가 입력"/>
												<div class="modal-footer">
													<button type="button" class="btn btn-outline-primary"
														data-dismiss="modal">Cancel</button>
													<input type="submit" onclick="redirect()" class="btn btn-primary text-white" value="OK">
												</div>
											</div>
										</div>
									</div>
									<!-- 작성자가 아닐 시 ***** 여기까지 사용 ********** -->
									<!-- 작성자일 경우 여기부터 -->									
 									<%-- <c:if test="${(sessionScope.user.id eq auction.seller. id)}"> --%>
										<c:if test="${auction.state == '1'}">
											<a class="btn btn-outline-primary px-4 py-2" href="<%=request.getContextPath()%>/auction/editAuction.do/${auction.aNum}" role="button">
												수정
											</a>
											<c:if test="${empty bid}">
												<a class="btn btn-outline-primary px-4 py-2" href="<%=request.getContextPath()%>/auction/deleteAuction.do/${auction.aNum}" role="button">
													삭제
												</a>
											</c:if>
										</c:if>
									<%-- </c:if> --%>
<%-- 												<a class="btn btn-outline-primary px-4 py-2" href="<%=request.getContextPath()%>/auction/editAuction.do/${auction.aNum}" role="button">
													수정
												</a>
	
												<a class="btn btn-outline-primary px-4 py-2" href="<%=request.getContextPath()%>/auction/deleteAuction.do/${auction.aNum}" role="button">
													삭제
												</a> --%>
									<!-- 여기까지 사용 -->
								</div>
							</div>		
							
							<%-- <!-- 경매는 마감일이 현재 시간보다 클 경우(미래의 시간인 경우)만 입력 가능 -->
						<c:if test="${auction.state eq '1'}">
								<jsp:useBean id="now" class="java.util.Date" />
								<c:if test="${auction.endAuc ge now}">
								<div class="form-group col-5">
								<input type="text" class="form-control" id="price" name="price" placeholder="경매 제시가 입력"/>
										<input type="submit" class="btn btn-primary text-white" value="전송">
								</div>
								</c:if>
						</c:if> --%>
						</form>
						
						
					</div>

					<div class="col-lg-2">
					</div>
				</div>

		</div>
		</div>
		<footer class="site-footer">
			<div class="container">


				<div class="row">
					<div class="col-md-4">
						<h3 class="footer-heading mb-4 text-white">About</h3>
						<p>바쁜 현대인에게 정규 수업같은 일상에서 벗어나 '0교시'에서는 재능 기부 및 거래를 통한 자유로운 배움터를
							제공합니다.</p>
					</div>
					<div class="col-md-5 ml-auto">
						<div class="row">
							<div class="col-md-6">
								<h3 class="footer-heading mb-4 text-white">Quick Menu</h3>
								<ul class="list-unstyled">
									<li><a href="#">Home</a></li>
									<li><a href="#">Team</a></li>
									<li><a href="#">Product</a></li>
									<li><a href="#">Auction</a></li>
									<li><a href="#">Review</a></li>
								</ul>
							</div>
							<div class="col-md-6">
								<h3 class="footer-heading mb-4 text-white">My Page</h3>
								<ul class="list-unstyled">
									<li><a href="#">Information</a></li>
									<li><a href="#">Order</a></li>
								</ul>
							</div>
						</div>
					</div>


					<div class="col-md-2">
						<div class="col-md-12">
							<h3 class="footer-heading mb-4 text-white">Social Icons</h3>
						</div>
						<div class="col-md-12">
							<p>
								<a href="#" class="pb-2 pr-2 pl-0"><span
									class="icon-facebook"></span></a> <a href="#" class="p-2"><span
									class="icon-twitter"></span></a> <a href="#" class="p-2"><span
									class="icon-instagram"></span></a> <a href="#" class="p-2"><span
									class="icon-vimeo"></span></a>

							</p>
						</div>
					</div>
				</div>
				<div class="row pt-5 mt-5 text-center">
					<div class="col-md-12">
						<p>
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							Copyright &copy;
							<script>
								document.write(new Date().getFullYear());
							</script>
							All Rights Reserved | This template is made with <i
								class="icon-heart text-danger" aria-hidden="true"></i> by <a
								href="https://colorlib.com" target="_blank">Colorlib</a>
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						</p>
					</div>

				</div>
			</div>
		</footer>
	</div>

	<script
		src="<%=request.getContextPath()%>/bootstraps/js/jquery-3.3.1.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/bootstraps/js/jquery-migrate-3.0.1.min.js"></script>
	<script src="<%=request.getContextPath()%>/bootstraps/js/jquery-ui.js"></script>
	<script src="<%=request.getContextPath()%>/bootstraps/js/popper.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/bootstraps/js/bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/bootstraps/js/owl.carousel.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/bootstraps/js/jquery.stellar.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/bootstraps/js/jquery.countdown.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/bootstraps/js/jquery.magnific-popup.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/bootstraps/js/bootstrap-datepicker.min.js"></script>
	<script src="<%=request.getContextPath()%>/bootstraps/js/aos.js"></script>

	<script src="<%=request.getContextPath()%>/bootstraps/js/main.js"></script>

</body>

<script>
console.log("session user", sessionScope.user.id); 
</script>



<script>
	function ajax(){
		var aNum = $("#aNum").val();
	     
	    $.ajax({
	        url:"auction/auctionDetail.do",
	        type:'GET',
	        data: aNum,
	        success:function(data){
	            window.opener.location.reload();
	            self.close();
	        },
	        error:function(jqXHR, textStatus, errorThrown){
	            alert("에러 발생\n" + textStatus + " : " + errorThrown);
	            self.close();
	        }
	    });
	}
</script>

</html>
