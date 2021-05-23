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

										

										<li class="active"><a href="<%=request.getContextPath()%>/team/teamList.do">Team</a></li>

										<li class="has-children"><a href="../product/productList.jsp">Market</a>

											<ul class="dropdown arrow-top">

												<li><a href="../product/productList.jsp">Product</a></li>

												<li><a href="../auction/auctionList.jsp">Auction</a></li>

											</ul></li>

										<li><a href="blog.html">Review</a></li>

										<li class="has-children"><a href="../user/myPage.jsp">My Page</a>

											<ul class="dropdown arrow-top">

												<li><a href="../user/myPage.jsp">My Information</a></li>

												<li><a href="../user/order.jsp">Order</a></li>

											</ul>

										<li class="active"><a>somsom</a></li>

										<li class="active"><a>0p</a></li>

										<li><a href="<%=request.getContextPath()%>/wishlist/listWishs.do"><img src="<%=request.getContextPath()%>/resources/cart.png"/></a></li>

									</ul>

								</div>

							</nav>

						</div>

					</div>

				</div>

			</div>

		</div>

		<div class="site-blocks-cover inner-page overlay" style="background-image: url(<%=request.getContextPath()%>/bootstraps/images/hero_bg_1.jpg);" data-aos="fade" data-stellar-background-ratio="0.5">

      <div class="row align-items-center justify-content-center">

        <div class="col-md-7 text-center" data-aos="fade">

          <h1 class="text-uppercase">Team</h1>

          <span class="caption d-block text-white">join new team</span>

        </div>

      </div>

    </div>

    <div class="site-section">

			<div class="container">

			<form action="/mybatis-spring-mvc/team/searchByCondition.do">

			<div class="row">

				<div class="col-10">

					<div class="input-group mb-3">

						<div class="input-group-prepend">

								<select class="form-control" name="category" id="category">

									<option selected>Category</option>

									<c:if test="${!empty categoryList}">

										<c:forEach var="category" items="${categoryList}">

											<option value="${category.catNum}">${category.catTitle}</option>

										</c:forEach>

									</c:if>

								</select>

						

						

<!-- 							<select class="form-control" id="category"> -->

<!-- 								<option selected>Category</option> -->

<!-- 								<option value="1">One</option> -->

<!-- 								<option value="2">Two</option> -->

<!-- 								<option value="3">Three</option> -->

<!-- 							</select> -->

						</div>

						<input type="text" class="form-control">

					</div>

				</div>

				<div class="col-2">

					<input type="submit" value="search"

						class="btn btn-primary text-white px-4 py-2">

				</div>

			</div>

			</form>

			<br/><br/><br/>

</div>

			<div class="container">

			

				<div class="row">

					

					<table class="table" style="text-align: center;">

						<thead>

							<tr>

								<th scope="col">No</th>

								<th scope="col">Name</th>

								<th scope="col">Category</th>

								<th scope="col">Date</th>

								<th scope="col">Term</th>

								<th scope="col">Now</th>

							</tr>

						</thead>

						<tbody>

						<c:if test="${!empty teamList}">

						<c:forEach var="team" items="${teamList}" varStatus="stat">

							<tr onClick="location.href='/mybatis-spring-mvc/team/teamDetail.do/${team.tNum}'" style="cursor:pointer;">

								<th><c:out value="${team.tNum}" /></th>

								<td><c:out value="${team.tName}"/></td>

								<td><c:out value="${team.category.catTitle}" /></td>

								<td>

									<fmt:formatDate value="${team.tStart}" pattern="yyyy/MM/dd hh:mm:ss" />

								</td>

								<td>

									<c:choose>

										<c:when test="${team.tTerm == 1}">

											장기

										</c:when>

										<c:otherwise>

											단기

										</c:otherwise>

									</c:choose>

								</td>

								<td>

									<c:choose>

										<c:when test="${team.recruit == 1}">

											<c:out value="${team.tLimit}" />

										</c:when>

										<c:otherwise>

											<c:out value="${team.count}" />

										</c:otherwise>

									</c:choose>

									/

									<c:out value="${team.tLimit}" />

								</td>

							</tr>

							</c:forEach>

						</c:if>

<!-- 							<tr onClick="location.href='teamDetail.jsp'" style="cursor:pointer;"> -->

<!-- 								<th>2</th> -->

<!-- 								<td>발음교정</td> -->

<!-- 								<td>외국어</td> -->

<!-- 								<td>19/05/20</td> -->

<!-- 								<td>장기</td> -->

<!-- 								<td>0/5</td> -->

<!-- 							</tr> -->

<!-- 							<tr onClick="location.href='teamDetail.jsp'" style="cursor:pointer;"> -->

<!-- 								<th>3</th> -->

<!-- 								<td>발음교정</td> -->

<!-- 								<td>외국어</td> -->

<!-- 								<td>19/05/20</td> -->

<!-- 								<td>장기</td> -->

<!-- 								<td>0/5</td> -->

<!-- 							</tr> -->

						</tbody>

					</table>

				</div>

				<div style="text-align:right;">

				<a class="btn btn-primary text-white px-4 py-2" href="newTeam.do" role="button">New Team</a>

				</div>

				<div class="row">

				

          <div class="col-12 text-center">

            <div class="custom-pagination">

              <span class="current">1</span>

              <a href="#">2</a>

              <a href="#">3</a>

              <a href="#">4</a>

              <a href="#">5</a>

              <span>...</span>

              <a href="#">14</a>

            </div>

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