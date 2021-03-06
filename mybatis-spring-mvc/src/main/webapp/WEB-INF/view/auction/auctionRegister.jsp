<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<script>
    $(function() {
        $("#startAuc, #endAuc").datepicker({
            dateFormat: 'yy.mm.dd'
        });
    });
</script>


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
										<a href="#" class="site-menu-toggle js-menu-toggle text-black">
											<span class="icon-menu h3"></span>
										</a>
									</div>
									<ul class="site-menu js-clone-nav d-none d-lg-block">
										
										<li><a href="teamList.jsp">Team</a></li>
										<li class="has-children"><a href="insurance.html">Market</a>
											<ul class="dropdown arrow-top">
												<li><a href="#">Product</a></li>
												<li class="active"><a href="auctionList.jsp">Auction</a></li>
											</ul></li>
										<li><a href="blog.html">Review</a></li>
										<li class="has-children"><a href="../user/myPage.jsp">My Page</a>
											<ul class="dropdown arrow-top">
												<li><a href="../user/myPage.jsp">My Information</a></li>
												<li><a href="../user/myPage.jsp">Order</a></li>
											</ul>
										<li><a href="blog.html">Review</a></li>
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
					<div class="col-lg-1"></div>
					<div class="col-md-12 col-lg-10 mb-5">
						<c:if test="${!empty auction}">
							<form action="../insertEditAuction.do/${auction.aNum}" class="p-5 bg-white" method="post" enctype="multipart/form-data">
						</c:if>
						<c:if test="${empty auction}">
							<form action="insertNewAuction.do" class="p-5 bg-white" method="post" enctype="multipart/form-data">
						</c:if>
							<div class="row form-group">
								<div class="col-md-12 mb-3 mb-md-0">
									<label class="font-weight-bold" for="name">Auction Name</label> 
									<c:if test="${!empty auction}">
										<input type="text" id="name" name="name" class="form-control"
											value="${auction.name}">
									</c:if>
									<c:if test="${empty auction}">
										<input type="text" id="name" name="name" class="form-control"
											placeholder="Auction Name">
									</c:if>
								</div>
							</div>
							<div class="row form-group">
								<div class="col-md-12 mb-3 mb-md-0">
									<label class="font-weight-bold" for="category">Category</label>
									<select class="form-control" id="catNum" name="catNum">
										<c:if test="${!empty categoryList}">
											<c:forEach var="category" items="${categoryList}">
												<c:if test="${category.catNum eq category.catNum}">
													<option value="${category.catNum}" selected>${category.catTitle}</option>
												</c:if>
												<c:if test="${category.catNum ne category.catNum}">
													<option value="${category.catNum}">${category.catTitle}</option>
												</c:if>
											</c:forEach>
											<c:if test="${category.catNum ne category.catNum}">
												<option selected>Category</option>
											</c:if>
										</c:if>
									</select>

								</div>
							</div>
							<div class="row form-group">
								
								<div class="col-md-9 mb-3 mb-md-0">
									<p class="font-weight-bold">End Date</p>
									<div class="form-row">
										<div class="form-group col-5">
										<%-- <input type="text" id="startAuc" name="startAuc" class="form-control"
													value="${auction.startAuc}">
											<c:if test="${!empty auction}">
												<input type="text" id="startAuc" name="startAuc" class="form-control"
													value="${auction.startAuc}">
											</c:if>
											<c:if test="${empty auction}">
												<input type="text" id="startAuc" name="startAuc" class="form-control"
													placeholder="startAuc">
											</c:if>	 --%>
											
											
											

											<c:if test="${!empty auction}">
												<input type="text" id="endAuc" name="endAuc" class="form-control"
													value="${auction.endAuc}">
											</c:if>
											<c:if test="${empty auction}">
												<input type="text" id="endAuc" name="endAuc" class="form-control"
													placeholder="endAuc">
											</c:if>
											
											
										</div>
										<div class="form-group col-2">
											<p class="font-weight-bold" style="text-align:center;">Limit Time: </p>
										</div>
										<div class="form-group col-5">
											<c:if test="${!empty auction}">
												  <input type='time' id='currentTime' name = "time" value="${auction.endAuc.getTime()}"/>
											</c:if>
											<c:if test="${empty auction}">
												 <input type='time' id='currentTime' name = "time"/>
											</c:if>
										</div>
									</div>
								</div>
							</div>
							<div class="row form-group">
								<div class="col-md-3 mb-3 mb-md-0">
									<p class="font-weight-bold">Point</p>
									<div class="btn-group btn-group-toggle active" data-toggle="buttons">
										<label class="btn btn-primary text-white"><input
											type="checkbox" name="prop" value="P">Low</label> <label
											class="btn btn-primary text-white"><input
											type="checkbox" name="prop" value="G">High</label>
									</div>
								</div>
								<div class="col-md-9 mb-3 mb-md-0">
									<p class="font-weight-bold">&nbsp;</p>
									<div class="form-row">
									<div class="form-group col-5">
											<c:if test="${!empty auction}">
												<input type="text" class="form-control" id="low" name="low" placeholder="low" value="${auction.low}"/>
											</c:if>
											<c:if test="${empty auction}">
												<input type="text" class="form-control" id="low" name="low" placeholder="low"/>
											</c:if>
										</div>
										<div class="form-group col-2">
											<p class="font-weight-bold" style="text-align:center;"> ~ </p>
										</div>
										<div class="form-group col-5">
											<c:if test="${!empty auction}">
												<input type="text" class="form-control" id="high" name="high" placeholder="high" value="${auction.high}"/>
											</c:if>
											<c:if test="${empty auction}">
												<input type="text" class="form-control" id="high" name="high" placeholder="high"/>
											</c:if>
										</div>
									</div>
								</div>
							</div>
							<div class="row form-group">
								<div class="col-md-12 mb-3 mb-md-0">
									<label class="font-weight-bold" for="content">Contents</label> 
									<c:if test="${!empty auction}">
										<textarea id="content" name="content" class="form-control" rows="5">
											${auction.content}</textarea>
									</c:if>
									<c:if test="${empty auction}">
										<textarea id="content" name="content" class="form-control" rows="5"></textarea>
									</c:if>
								</div>
							</div>
							<div class="row form-group">
								<div class="col-md-12 mb-3 mb-md-0">
									    <label class="font-weight-bold" for="img">Image</label></br>
									    <%-- <c:if test="${!empty auction}">
    										<input type="file" class="form-control-file" 
    										id="filePath" value = "${auction.image}">
    									</c:if>
    									<c:if test="${empty auction}">
    										<input type="file" class="form-control-file" id="image">
    									</c:if> --%>
    									<c:if test="${!empty auction}">
											<input type="file" name="image" value="auction.image"/>
										</c:if>
										<c:if test="${empty auction}">
											<input type="file" name="image" />
										</c:if>
								</div>
							</div>
						<form class="form-horizontal" method="post" action="/auction/insertEditAuction.do/${aNum}" enctype="multipart/form-data">
							<div class="row form-group">
								<div class="col-md-12 mb-3 mb-md-0">
									    <label class="font-weight-bold" for="file">File</label>
										<c:if test="${!empty auction}">
    										<input type="file" class="form-control-file" 
    										id="filePath" name="filePath" value = "${auction.filePath}">
    									</c:if>
    									<c:if test="${empty auction}">
    										<input type="file" class="form-control-file" 
    										id="filePath" name="filePath">
    									</c:if>
    									
<%--     									<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>
											<form:form enctype="multipart/form-data" modelAttribute="uploadFile">
											<c:if test="${!empty auction}">
												<input type="file" name="filePath"  value="${auction.filePath}">
												<form:errors path="file" cssStyle="color:red" />
											</c:if>
											<c:if test="${empty auction}">
												<input type="file" name="filePath">
												<form:errors path="file" cssStyle="color:red" />
											</c:if>
												<div class="row form-group" style="text-align: right">
													<div class="col-md-12">
														<a class="btn btn-outline-primary px-4 py-2" href="auctionList.jsp"
															role="button">cancel</a> <input type="submit" value="upload"
															class="btn btn-primary text-white px-4 py-2">
													</div>
												</div>
											</form:form> --%>
						
											<!-- <div class="row form-group" style="text-align: right">
													<div class="col-md-12">
														<a class="btn btn-outline-primary px-4 py-2" href="../auctionList.do"
															role="button">cancel</a> 
														<input type="submit" value="upload" class="btn btn-primary text-white px-4 py-2">
													</div>
												</div> -->	
												
												<div class="row form-group" style="text-align: right">
													<div class="col-md-12">
														<a class="btn btn-outline-primary px-4 py-2" href="javascript:history.back()" role="button">cancel</a> 
														<input type="submit" value="upload" class="btn btn-primary text-white px-4 py-2">
													</div>
												</div>
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

