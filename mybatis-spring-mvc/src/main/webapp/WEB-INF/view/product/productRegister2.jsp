<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<title>Zero Class</title>
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
<script>
	function openMessenger(){
		  var popupW = 800;
		  var popupH = 700;
		  var left = Math.ceil((window.screen.width - popupW)/2);
		  var top = Math.ceil((window.screen.height - popupH)/2);
		  window.open('<%=request.getContextPath()%>/messenger/listMessengers.do','messenger','width='+popupW+',height='+popupH+',left='+left+',top='+top+',scrollbars=auto,resizable=no,toolbar=no,titlebar=no,menubar=no,location=no')			
		 }
	</script>
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

<!-- ??????????????? ??? ?????? -->
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
										<a href="#" class="site-menu-toggle js-menu-toggle text-black">
											<span class="icon-menu h3"></span>
										</a>
									</div>
									<ul class="site-menu js-clone-nav d-none d-lg-block">
										<li><a href="team/teamList.jsp"> Team </a></li>
										<li class="has-children"><a
											href="<%=request.getContextPath()%>/product/listProducts.do">
												Market </a>
											<ul class="dropdown arrow-top">
												<li class="active"><a
													href="<%=request.getContextPath()%>/product/listProducts.do">
														Product </a></li>
												<li><a href="auction/auctionList.jsp"> Auction </a></li>
											</ul></li>
										<li><a
											href="<%=request.getContextPath()%>/review/reviewList.do">
												Review </a></li>
										<li class="has-children"><a
											href="<%=request.getContextPath()%>/user/myPage.do"> My
												Page </a>
											<ul class="dropdown arrow-top">
												<li><a
													href="<%=request.getContextPath()%>/user/myPage.do">My
														Information</a></li>
												<li><a href="user/order.jsp">Order</a></li>
											</ul></li>
										<c:if test="${empty sessionScope.user}">
											<li class="active"><a
												href="<%=request.getContextPath()%>/login/login.do">
													Login </a></li>
										</c:if>
										<c:if test="${! empty sessionScope.user}">
											<li class="active"><a>${sessionScope.user.id}</a></li>
											<li class="active"><a>${sessionScope.user.point}p</a></li>
											<li><a
												href="<%=request.getContextPath()%>/wishlist/listWishs.do">
													<img src="<%=request.getContextPath()%>/resources/cart.png" />
											</a></li>
											<li><a style="cursor: pointer"
												onClick="openMessenger();return flase;"> <img
													src="<%=request.getContextPath()%>/resources/envelope.png" /></a></li>
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
<!-- ??????????????? ??? ??? -->
		
<!-- ?????? form ?????? -->
		<div class="py-5 bg-light">
			<div class="container">
				<div class="row">
					<div class="col-lg-1"></div>
					<div class="col-md-12 col-lg-10 mb-5">
						<form action="#" class="p-5 bg-white">
							<div class="row form-group">
								<div class="col-md-12 mb-3 mb-md-0">
									<label class="font-weight-bold" for="name">Product Name</label> <input
										type="text" id="name" class="form-control"
										placeholder="product name">
								</div>
							</div>
							<div class="row form-group">
								<div class="col-md-12 mb-3 mb-md-0">
									<label class="font-weight-bold" for="category">Category</label>
									<select class="form-control" id="category">
										<option>1</option>
										<option>2</option>
										<option>3</option>
										<option>4</option>
										<option>5</option>
									</select>
								</div>
							</div>
							<div class="row form-group">
								<div class="col-md-12 mb-3 mb-md-0">
									<label class="font-weight-bold" for="point">Points</label> <input
										type="text" id="point" class="form-control" placeholder="points">
								</div>
							</div>
							<div class="row form-group">
								<div class="col-md-12 mb-3 mb-md-0">
									<label class="font-weight-bold" for="content">Contents</label> <textarea
										id="content" class="form-control" rows="5"></textarea>
								</div>
							</div>
							<div class="row form-group">
								<div class="col-md-12 mb-3 mb-md-0">
									    <label class="font-weight-bold" for="img">Image</label>
    <input type="file" class="form-control-file" id="img">
								</div>
							</div>
							
							<div class="row form-group">
								<div class="col-md-12 mb-3 mb-md-0">
									    <label class="font-weight-bold" for="file">File</label>
    <input type="file" class="form-control-file" id="file">
								</div>
							</div>
							<div class="row form-group" style="text-align: right">
								<div class="col-md-12">
									<a class="btn btn-outline-primary px-4 py-2" href="teamList.jsp"
										role="button">cancel</a> <input type="submit" value="upload"
										class="btn btn-primary text-white px-4 py-2">
								</div>
							</div>
						</form>
					</div>

					<div class="col-lg-1"></div>
				</div>
			</div>
		</div>
		<footer class="site-footer">
			<div class="container">


				<div class="row">
					<div class="col-md-4">
						<h3 class="footer-heading mb-4 text-white">About</h3>
						<p>?????? ??????????????? ?????? ???????????? ???????????? ????????? '0??????'????????? ?????? ?????? ??? ????????? ?????? ???????????? ????????????
							???????????????.</p>
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
