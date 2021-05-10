<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>Zero Class</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/school.ico">
<link rel="icon" href="<%=request.getContextPath()%>/resources/school.ico">

<link href="https://fonts.googleapis.com/css?family=Oswald:400,700|Work+Sans:300,400,700" rel="stylesheet">
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstraps/fonts/icomoon/style.css">

<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstraps/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstraps/css/magnific-popup.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstraps/css/jquery-ui.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstraps/css/owl.carousel.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstraps/css/owl.theme.default.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstraps/css/bootstrap-datepicker.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstraps/css/animate.css">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/mediaelement@4.2.7/build/mediaelementplayer.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstraps/fonts/flaticon/font/flaticon.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstraps/css/aos.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstraps/css/style.css">
<script>
function pointErr(){
	var totalPoint = productForm.price.value;
	var myPoint = productForm.userPoint.value;
	if(totalPoint>myPoint){
		alert("보유 포인트가 부족합니다.");
		return false;
	}
	
}
	function openMessenger(){
		  var popupW = 800;
		  var popupH = 700;
		  var left = Math.ceil((window.screen.width - popupW)/2);
		  var top = Math.ceil((window.screen.height - popupH)/2);
		  window.open('<%=request.getContextPath()%>/messenger/listMessengers.do','messenger','width='+popupW+',height='+popupH+',left='+left+',top='+top+',scrollbars=auto,resizable=no,toolbar=no,titlebar=no,menubar=no,location=no')			
		 }
		function writeMessenger(){
			  var popupW = 800;
			  var popupH = 700;
			  var left = Math.ceil((window.screen.width - popupW)/2);
			  var top = Math.ceil((window.screen.height - popupH)/2);
			  window.open('<%=request.getContextPath()%>/messenger/newMessenger.do/${product.seller.id}','messenger','width='+popupW+',height='+popupH+',left='+left+',top='+top+',scrollbars=auto,resizable=no,toolbar=no,titlebar=no,menubar=no,location=no')			
			 }
</script>
</head>
<body style="background-image: url('<%=request.getContextPath()%>/bootstraps/images/bg.jpg');">
	<div class="site-wrap">
		<div class="site-mobile-menu">
			<div class="site-mobile-menu-header">
				<div class="site-mobile-menu-close mt-3">
					<span class="icon-close2 js-menu-toggle"></span>
				</div>
			</div>
			<div class="site-mobile-menu-body"></div>
		</div>
		<div class="site-navbar-wrap js-site-navbar bg-white">
			<div class="container">
				<div class="site-navbar bg-light">
					<div class="row align-items-center">
						<div class="col-2">
							<h2 class="mb-0 site-logo">
								<a href="<%=request.getContextPath()%>/mainPage.do" class="font-weight-bold">Zero Class</a>
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
                    <li>
                    	<a href="team/teamList.jsp">
                    		Team
                    	</a>
                    </li>
                    <li class="has-children active">
                      <a href="<%=request.getContextPath()%>/product/listProducts.do?page=1">
                      	Market
                      </a>
                      <ul class="dropdown arrow-top">
                        <li class="active">
                        	<a href="<%=request.getContextPath()%>/product/listProducts.do?page=1">
                        		Product
                        	</a>
                        </li>
                        <li>
                        	<a href="auction/auctionList.jsp">
                        		Auction
                        	</a>
                        </li>
                      </ul>
                    </li>
                    <li>
                    	<a href="<%=request.getContextPath()%>/review/reviewList.do?page=1">
                    		Review
                    	</a>
                    </li>
                   	<li class="has-children">
                      	<a href="<%=request.getContextPath()%>/user/myPage.do">
                      		My Page
                      	</a>
                      <ul class="dropdown arrow-top">
                        <li><a href="<%=request.getContextPath()%>/user/myPage.do">My Information</a></li>
                        <li><a href="<%=request.getContextPath()%>/user/myOrder.do">Order</a></li>
                      </ul>
                    </li>
                    <c:if test="${empty sessionScope.user}">
                    	<li class="active">
                    		<a href="<%=request.getContextPath()%>/login/login.do">
                    			Login
                    		</a>
                   	 	</li>
                    </c:if>
                    <c:if test="${! empty sessionScope.user}">
                    	<li class="active"><a>${sessionScope.user.id}</a></li>
						<li class="active"><a>${sessionScope.user.point}p</a></li>
						<li><a href="<%=request.getContextPath()%>/wishlist/listWishs.do">
						<img src="<%=request.getContextPath()%>/resources/cart.png"/></a></li>
						<li><a style="cursor:pointer" onClick="openMessenger();return flase;">
							<img src="<%=request.getContextPath()%>/resources/envelope.png" /></a></li>
						<li><a href="<%=request.getContextPath()%>/logout.do">logout</a></li>
                    </c:if>
									</ul>
								</div>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
<!-- 네비게이션 바 끝 -->
		
<!-- 입력 form 시작 -->
		<div class="py-5 bg-light">
			<div class="container">
				<div class="row">
					<div class="col-lg-2"></div>
					<div class="col-md-12 col-lg-8 mb-5">
						<form name="productForm" action="#" class="p-5 bg-white">
							<p class="h5 text-black mb-3">Product Information</p>
							<input type="hidden" name="price" value="${product.price}"/>
							<input type="hidden" name="userPoint" value="${sessionScope.user.point}"/>
							<c:if test="${product.isSale eq '1'}">
								<p class="h6 text-primary mb-3">판매중</p>
							</c:if>
							<c:if test="${product.isSale eq '0'}">
								<p class="h6 text-primary mb-3">판매중지</p>
							</c:if>
							<c:if test="${!empty product.image}">
								<img src="<%=request.getContextPath()%>/upload/${product.image}" alt="Image" class="img-fluid">
							</c:if>
							<c:if test="${empty product.image}">
								<img src="<%=request.getContextPath()%>/bootstraps/images/review_default.jpg" alt="Image" class="img-fluid">
							</c:if>
							<br/><br/>
							
							<div class="row">
								<div class="col-4">
									<p class="mb-0 font-weight-bold">Product Name</p>
								</div>
								<div class="col-8">
									<p class="mb-4">${product.name}</p>
								</div>
							</div>
							<div class="row">
								<div class="col-4">
									<p class="mb-0 font-weight-bold">Seller</p>
								</div>
								<div class="col-3">
									<p class="mb-4">${product.seller.id}</p>
								</div>
								<div class="col-1">
									<c:if test="${sessionScope.user.id ne product.seller.id}">
									<a style="cursor:pointer" onClick="writeMessenger();return flase;">
									<img src="<%=request.getContextPath()%>/resources/envelope.png" /></a>
									</c:if>
								</div>
							</div>
							
							<div class="row">
								<div class="col-4">
									<p class="mb-0 font-weight-bold">Category</p>
								</div>
								<div class="col-8">
									<p class="mb-4">${product.cate.catTitle}</p>
								</div>
							</div>

							<div class="row">
								<div class="col-4">
									<p class="mb-0 font-weight-bold">Point</p>
								</div>
								<div class="col-8">
									<p class="mb-4">${product.price}</p>
								</div>
							</div>
							
							<div class="row">
								<div class="col-4">
									<p class="mb-0 font-weight-bold">Contents</p>
								</div>
								<div class="col-8">
									<p class="mb-4">${product.content}</p>
								</div>
							</div>
							
							<div class="row form-group" style="text-align: right">
								<div class="col-md-12">
									<a class="btn btn-outline-primary px-4 py-2" href="/mybatis-spring-mvc/product/listProducts.do?page=1" role="button">
										목록으로
									</a>
									<c:if test="${sessionScope.user.id ne product.seller.id}">
									<!-- 작성자가 아닐 시 ****** 여기부터 ********-->
									<c:if test="${product.isSale eq '1'}">
										<a class="btn btn-primary text-white px-4 py-2" href="/mybatis-spring-mvc/wishlist/addProductToWish.do/${product.pNum}" role = "button">
	<!-- 										 role="button" data-toggle="modal" data-target="#wishModal"> -->
											찜하기
										</a>
									</c:if>
<%-- 									<a class="btn btn-primary text-white px-4 py-2" href="/mybatis-spring-mvc/wishlist/addProductToWish.do/${product.pNum}"  --%>
<!-- 										 role="button" data-toggle="modal" data-target="#wishModal"> -->
<!-- 										찜하기 -->
<!-- 									</a> -->
<!-- 									<div class="modal fade" id="wishModal" tabindex="-1" role="dialog" aria-labelledby="wishModalLabel" aria-hidden="true"> -->
<!-- 										<div class="modal-dialog" role="document"> -->
<!-- 											<div class="modal-content"> -->
<!-- 												<div class="modal-header"> -->
<!-- 													<h5 class="modal-title" id="exampleModalLabel">Inform</h5> -->
<!-- 													<button type="button" class="close" data-dismiss="modal" aria-label="Close"> -->
<!-- 														<span aria-hidden="true">&times;</span> -->
<!-- 													</button> -->
<!-- 												</div> -->
<!-- 												<div class="modal-body" style="text-align: center">위시리스트에 정상적으로 담겼습니다.</div> -->
<!-- 												<div class="modal-footer"> -->
<%-- 													<button type="button" href="/mybatis-spring-mvc/wishlist/addProductToWish.do/${product.pNum}" --%>
<!-- 														 class="btn btn-outline-primary" data-dismiss="modal">확인</button> -->
<!-- 													<a class="btn btn-primary text-white" href="/mybatis-spring-mvc/wishlist/listWishs.do" role="button">위시리스트 보러 가기</a> -->
<!-- 												</div> -->
<!-- 											</div> -->
<!-- 										</div> -->
<!-- 									</div> -->
									<c:if test="${product.isSale eq '1'}">
										<a class="btn btn-primary text-white px-4 py-2" href="/mybatis-spring-mvc/product/newOrder.do/${product.pNum}/${product.price}" role="button">
	<!-- 										 data-toggle="modal" data-target="#joinModal"> -->
											 구매
										</a>
									</c:if>
<!-- 모달부분 -->
<!-- 										<div class="modal fade" id="joinModal" tabindex="-1" role="dialog" aria-labelledby="joinModalLabel" aria-hidden="true"> -->
<!-- 											<div class="modal-dialog" role="document"> -->
<!-- 												<div class="modal-content"> -->
<!-- 													<div class="modal-header"> -->
<!-- 														<h5 class="modal-title" id="exampleModalLabel">Inform</h5> -->
<!-- 														<button type="button" class="close" data-dismiss="modal" aria-label="Close"> -->
<!-- 															<span aria-hidden="true">&times;</span> -->
<!-- 														</button> -->
<!-- 													</div> -->
<!-- 													<div class="modal-body" style="text-align: left">결제 완료되었습니다.</div> -->
<!-- 													<div class="modal-footer"> -->
<!-- 														<button type="button" class="btn btn-outline-primary" data-dismiss="modal">확인</button> -->
<!-- 														<a class="btn btn-primary text-white" href="../user/order.jsp" role="button">결제 내역 보러 가기</a> -->
<!-- 													</div> -->
<!-- 												</div> -->
<!-- 											</div> -->
<!-- 										</div> -->

<!-- 원래코드 -->
<!-- 									<a class="btn btn-primary text-white px-4 py-2" role="button" data-toggle="modal" data-target="#joinModal">결제</a> -->
<!-- 									<div class="modal fade" id="joinModal" tabindex="-1" role="dialog" aria-labelledby="joinModalLabel" aria-hidden="true"> -->
<!-- 										<div class="modal-dialog" role="document"> -->
<!-- 											<div class="modal-content"> -->
<!-- 												<div class="modal-header"> -->
<!-- 													<h5 class="modal-title" id="exampleModalLabel">Inform</h5> -->
<!-- 													<button type="button" class="close" data-dismiss="modal" aria-label="Close"> -->
<!-- 														<span aria-hidden="true">&times;</span> -->
<!-- 													</button> -->
<!-- 												</div> -->
<!-- 												<div class="modal-body" style="text-align: left">결제 완료되었습니다.</div> -->
<!-- 												<div class="modal-footer"> -->
<!-- 													<button type="button" class="btn btn-outline-primary" data-dismiss="modal">확인</button> -->
<!-- 													<a class="btn btn-primary text-white" href="../user/order.jsp" role="button">결제 내역 보러 가기</a> -->
<!-- 												</div> -->
<!-- 											</div> -->
<!-- 										</div> -->
<!-- 									</div> -->
									<!-- 작성자가 아닐 시 ***** 여기까지 사용 ********** -->
									</c:if>
						<c:if test="${sessionScope.user.id eq product.seller.id}">
									<!-- 작성자일 경우 여기부터 -->
									<a class="btn btn-outline-primary px-4 py-2" href="/mybatis-spring-mvc/product/editProduct.do/${product.pNum}" role="button">
										수정
									</a>
<!-- 									<a class="btn btn-outline-primary px-4 py-2" href="productList.jsp" role="button"> -->
<!-- 										삭제 -->
<!-- 									</a> -->
									<!-- 여기까지 사용 -->
									</c:if>
								</div>
							</div>
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
</html>
