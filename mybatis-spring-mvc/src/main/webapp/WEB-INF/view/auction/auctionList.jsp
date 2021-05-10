<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
								<a href="../mainPage.do" class="font-weight-bold">Zero
									Class</a>
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

										<li class=""><a href="../team/teamList.jsp">Team</a></li>
										<li class="has-children active"><a href="../product/productList.jsp">Market</a>
											<ul class="dropdown arrow-top">
												<li><a href="../product/productList.jsp">Product</a></li>
												<li><a href="<%=request.getContextPath()%>/auction/auctionList.do">Auction</a></li>
											</ul></li>
										<li><a href="../review/reviewList.jsp">Review</a></li>
										<li class="has-children"><a href="../user/myPage.jsp">My Page</a>
											<ul class="dropdown arrow-top">
												<li><a href="../user/myPage.jsp">My Information</a></li>
												<li><a href="../user/order.jsp">Order</a></li>
											</ul>
										<li class="active"><a>${sessionScope.user.id}</a></li>
										<li class="active"><a>0p</a></li>
										<li><a href="<%=request.getContextPath()%>/wishlist/listWishs.do"><img
												src="<%=request.getContextPath()%>/resources/cart.png" /></a></li>
									</ul>
								</div>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="site-blocks-cover inner-page overlay"
			style="background-image: url(<%=request.getContextPath()%>/bootstraps/images/hero_bg_1.jpg);"
			data-aos="fade" data-stellar-background-ratio="0.5">
			<div class="row align-items-center justify-content-center">
				<div class="col-md-7 text-center" data-aos="fade">
					<h1 class="text-uppercase">Market</h1>
					<span class="caption d-block text-white">product | auction</span>
				</div>
			</div>
		</div>
		<div class="site-section">
			<div class="container">
				<%-- <div class="row">
					<div class="col-10">
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<select class="form-control" id="category">
									<c:forEach var="category" items="${categoryList}">
											<option value="${category.catNum}">${category.catTitle}</option>
									</c:forEach>
								</select>
							</div>
							<input type="text" class="form-control">
						</div>
					</div>
					<div class="col-2">
					<input type="submit" value="search"
						class="btn btn-primary text-white px-4 py-2">
				</div>
				</div> --%>
				
				<%-- <form action="<%=request.getContextPath()%>/auction/searchByKeyword.do">
				<div class="row">
					<div class="col-10">
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<select class="form-control" id="select" name="select">
									<option value="title" selected>Title</option>
									<option value="content">Content</option>
								</select>
							</div>
							<input type="text" class="form-control" name="keyword">
						</div>
					</div>
					<div class="col-2">
						<input type="submit" value="search"
							class="btn btn-primary text-white px-4 py-2">
					</div>
				</div>
				</form> --%>
			
			<form action="<%=request.getContextPath()%>/auction/searchByKeyword.do">
				<div class="row">
					<div class="col-10">
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<select class="form-control" id="select" name="select">
									<option value="title" selected>Title</option>
									<option value="content">Content</option>
								</select>
							</div>
							<input type="text" class="form-control" name="keyword">
						</div>
					</div>
					<div class="col-2">
						<input type="submit" value="search"
							class="btn btn-primary text-white px-4 py-2">
					</div>
					</div>
				</form>
				
				<br /> <br /> <br />
			</div>
			<div class="container">
<!-- 				<div class="btn-group btn-group-toggle active" data-toggle="buttons">
					<label class="btn btn-primary text-white">
					<input type="radio" name="state" value="P">
						Open
					</label>
					<label class="btn btn-primary text-white">
					<input type="radio" name="state" value="P">
						Bidding
					</label>
					<label class="btn btn-primary text-white">
					<input type="radio" name="state" value="G">
						Closed
					</label>
				</div> -->
				
				<div class="container">
				<div class="btn-group">
				  <!-- <a href = "auctionStateList.do"><button type="button" class="btn btn-primary" id = "state" name="state" value = "0">Open</button></a> -->
				  <a href = "<%=request.getContextPath()%>/auction/auctionList.do?page=1"><button type="button" class="btn btn-primary">All</button></a>
				  <a href = "<%=request.getContextPath()%>/auction/searchAuctionByState.do/1?page=1"><button type="button" class="btn btn-primary" id ="state" name="state" value = "1">Bidding</button></a>
				  <a href = "<%=request.getContextPath()%>/auction/searchAuctionByState.do/2?page=1"><button type="button" class="btn btn-primary" id ="state" name="state" value = "2">Closed</button></a>
				  
				</div>
				</div>
				
				<br /> <br />
				<div class="row">	
					<c:if test="${!empty auctionList}">
						<c:forEach var="auction" items="${auctionList}" varStatus="stat">
							<div class="col-md-4 text-center mb-4">
								<div class="border text-with-icon">
									<div class="media-image">
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
										
										<div class="media-image-body">
											<h2 class="font-secondary text-uppercase">${auction.name}</h2>
											<p>${auction.category.title}<br/>
											<h2 class="font-secondary text-uppercase">Auction Point: </h2>${auction.low}p ~ ${auction.high}p<br/>
											<h2 class="font-secondary text-uppercase">End Auction: </h2>
											<fmt:formatDate value="${auction.endAuc}" pattern="yyyy-MM-dd a HH:mm:ss"/>	
											</p>  
											<p>
												<a class="btn btn-outline-primary px-4"
												onClick="location.href='/mybatis-spring-mvc/auction/auctionDetail.do/${auction.aNum}'" style="cursor:pointer;">
												<span class="caption">More</span></a>
											</p>
										</div>
									</div>
								</div>
							</div>
							</c:forEach>
						</c:if>
				</div>
				<div style="text-align:right;">
				<a class="btn btn-primary text-white px-4 py-2" href="<%=request.getContextPath()%>/auction/newAuction.do" role="button">Write Auction</a>
				</div>
					<div class="row">
						<c:if test="${!empty page}">
							<div class="col-12 text-center">
								<div class="custom-pagination">

									<c:forEach var="i" begin="1" end="${totalPage}" step="1">
										<c:if test="${page eq i}">
											<span class="current">${i}</span>
										</c:if>
										<c:if test="${page ne i}">
											<a
												href="<%=request.getContextPath()%>/auction/auctionList.do?page=${i}">${i}</a>
										</c:if>
									</c:forEach>
								</div>
							</div>
						</c:if>

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