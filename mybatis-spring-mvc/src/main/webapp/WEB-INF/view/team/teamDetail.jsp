<!DOCTYPE html>

 

<%@ page language="java" contentType="text/html; charset=UTF-8"

	pageEncoding="UTF-8"%>

 

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

 

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

										<li class="has-children"><a href="insurance.html">Market</a>

											<ul class="dropdown arrow-top">

												<li><a href="#">Product</a></li>

												<li><a href="#">Auction</a></li>

											</ul></li>

										<li><a href="blog.html">Review</a></li>

										<li class="has-children"><a href="../user/myPage.jsp">My Page</a>

											<ul class="dropdown arrow-top">

												<li><a href="../user/myPage.jsp">My Information</a></li>

												<li><a href="../user/order.jsp">Order</a></li>

											</ul>

										<li><a href="blog.html">Review</a></li>

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

 

			<div class="py-5 bg-light">

			<div class="container">

				<div class="row">

					<div class="col-lg-2"></div>

					<div class="col-md-12 col-lg-8 mb-5">

						<form action="#" class="p-5 bg-white">

							<p class="h5 text-black mb-3">Team Information</p>



							<c:choose>

										<c:when test="${ApplyInclude == true}">

										</c:when>

										<c:when test="${MemberShipInclude == true}">


										</c:when>

										<c:when test="${MentorInclude == true}">


										</c:when>

										<c:when test="${TeamFull == false}">

										</c:when>

										<c:otherwise>

											<a class="btn btn-primary text-white px-4 py-2" 

												href="/mybatis-spring-mvc/miniHome/miniHome.do/${team.tNum}" 

													role="button" >미니홈 가기</a>
 

										</c:otherwise>

									</c:choose>
							
							

<!-- 							<p class="h6 text-primary mb-3">Open</p> -->

							<div class="row">

								

								<div class="col-9">

									<p class="mb-4"><c:out value="${team.tName}" /></p>

<!-- 									<p class="mb-4">발음 교정 교실</p> -->

								</div>

								<div class="col-2" style="text-align: right;">

									<p class="mb-4"><c:out value="${team.mentor.name}" /></p>

<!-- 									<p class="mb-4">김동덕</p> -->

								</div>

								<div class="col-1">

									<a href="../user/wishlist.jsp"><img

										src="<%=request.getContextPath()%>/resources/envelope.png" /></a>

								</div>

							</div>

							

							<div class="row">

								<div class="col-2">

									<p class="mb-0 font-weight-bold">tNumber</p>

								</div>

								<div class="col-10">

									<p class="mb-4"><c:out value="${team.tNum}" />회원번호</p>

<!-- 									<p class="mb-4">5</p> -->

								</div>

							</div>

							

							

							

							<div class="row">

								<div class="col-2">

									<p class="mb-0 font-weight-bold">Category</p>

								</div>

								<div class="col-10">

									<p class="mb-4"><c:out value="${team.category.catTitle}" /></p>

<!-- 									<p class="mb-4">Language</p> -->

								</div>

							</div>

 

							<div class="row">

								<div class="col-2">

									<p class="mb-0 font-weight-bold">Date</p>

								</div>

								<div class="col-10">

									<p class="mb-4"><c:out value="${team.tStart}" /> ~ <c:out value="${team.tEnd}" /></p>

<!-- 									<p class="mb-4">19/05/20</p> -->

								</div>

							</div>

 

							<div class="row">

								<div class="col-2">

									<p class="mb-0 font-weight-bold">Limit</p>

								</div>

								<div class="col-10">

									<p class="mb-4">

									<c:choose>

										<c:when test="${TeamFull == true}">

											<c:out value="${team.tLimit}"/> / <c:out value="${team.tLimit}" />명</p>

										</c:when>

										<c:when test="${ApplyDetailCheck == true}">

											<c:out value="${ApplyLimitCheck.tLimit}"/> / <c:out value="${team.tLimit}" />명</p>

										</c:when>

										<c:otherwise>

											0 / <c:out value="${team.tLimit}" />명</p>

										</c:otherwise>

									</c:choose>

									

									

<!-- 									<p class="mb-4">5</p> -->

								</div>

							</div>

 

							<div class="row">

								<div class="col-2">

									<p class="mb-0 font-weight-bold">Material Cost</p>

								</div>

								<div class="col-10">

									<p class="mb-4"><c:out value="${team.price}" /></p>

<!-- 									<p class="mb-4">5000</p> -->

								</div>

							</div>

 

							<p class="mb-0 font-weight-bold">Content</p>

							<br />

							<p class="mb-4"><c:out value="${team.tContent}" /></p>

<!-- 								<p class="mb-4">원어민 발음을 원하는 분들께 1:1로 돌아가면서 발음 교정 해드립니다. 발음 -->

<!-- 								교정, 회화 연습하러 오세요.</p> -->

 

							<div class="row form-group" style="text-align: right">

								<div class="col-md-12">

									<a class="btn btn-outline-primary px-4 py-2" href="/mybatis-spring-mvc/team/teamList.do" 

									 role="button">

										목록으로

									</a>

									<!-- 작성자가 아닐 시 ****** 여기부터 -->

									

									

<!-- 									<a class="btn btn-primary text-white px-4 py-2"  role="button" data-toggle="modal" data-target="#wishModal"> -->

<!-- 										찜하기 -->

<!-- 									</a> -->

									<c:choose>

										<c:when test="${ApplyInclude == true}">

											

										</c:when>

										<c:when test="${MemberShipInclude == true}">

											

										</c:when>

										<c:when test="${MentorInclude == true}">

											

										</c:when>

										<c:when test="${TeamFull == true}">

											

										</c:when>

										<c:otherwise>

											<a class="btn btn-primary text-white px-4 py-2" href="/mybatis-spring-mvc/wishlist/addTeamToWish.do/${team.tNum}" role = "button">

												찜하기

											</a>

 

										</c:otherwise>

									</c:choose>

<!-- 										<a class="btn btn-primary text-white px-4 py-2"  role="button" data-toggle="modal" data-target="#wishModal"> -->

<!-- 										찜하기 -->

<!-- 										</a> -->

									

									

									

									<div class="modal fade" id="wishModal" tabindex="-1"

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

									</div>

									<!--apply 멤버쉽에 속할 때 신청, 속하지 않다면 탈퇴. 멘토라면 신청 탈퇴 모두 안 보이도록. 모집완료되면 안 보이도록include는 팀에 있다면 true이고 없다면 false-->

									<c:choose>

										<c:when test="${MentorInclude == true}">

											

										</c:when>

										<c:when test="${ApplyInclude == true}">

											<a class="btn btn-primary text-white px-4 py-2" 

												href="/mybatis-spring-mvc/team/leaveTeam.do/${team.tNum}" 

													role="button" >신청 취소</a>

										</c:when>

										<c:when test="${MemberShipInclude == true}">

											<a class="btn btn-primary text-white px-4 py-2" 

												href="/mybatis-spring-mvc/team/leaveTeam.do/${team.tNum}" 

													role="button" >신청 취소</a>

										</c:when>

										

										<c:when test="${TeamFull == true}">

											

										</c:when>

										

										<c:otherwise>

											<a class="btn btn-primary text-white px-4 py-2" 

											role="button" data-toggle="modal" data-target="#joinModal">신청</a>

	

<!-- 											<a class="btn btn-primary text-white px-4 py-2"  -->

<%-- 												href="/mybatis-spring-mvc/team/teamRequest.do/${team.tNum}"  --%>

<!-- 													role="button" data-toggle="modal" data-target="#joinModal">신청</a>		 -->

										</c:otherwise>

									</c:choose>

									

<!-- 									<a class="btn btn-primary text-white px-4 py-2"  -->

<%-- 									href="/mybatis-spring-mvc/team/teamRequest.do/${team.tNum}"  --%>

<!-- 										role="button" >신청</a> -->

<!--  										data-toggle="modal" data-target="#joinModal">신청</a> --> 

 

 

 

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

												<div class="modal-body" style="text-align: left">신청 완료되었습니다.</div>

												<div class="modal-footer">

												

													<a class="btn btn-primary text-white"

														href="../teamRequest.do/${team.tNum}" role="button">확인</a>

												

<!-- 													<button type="button" class="btn btn-outline-primary" -->

<!-- 														data-dismiss="modal">확인</button> -->

													<a class="btn btn-primary text-white"

														href="/mybatis-spring-mvc/user/order.do" role="button">신청 내역 보러 가기</a>

												</div>

											</div>

										</div>

									</div>

									<!-- 작성자가 아닐 시 ***** 여기까지 사용 -->

									<!-- 작성자일 경우 여기부터 -->

									<c:choose>

										<c:when test="${MentorInclude == true}">

<!-- 											<a class="btn btn-outline-primary px-4 py-2"  -->

<%-- 												href="/mybatis-spring-mvc/team/editTeam.do/${team.tNum}" role="button"> --%>

<!-- 												수정 -->

<!-- 											</a> -->

											<a class="btn btn-outline-primary px-4 py-2" 

												href="/mybatis-spring-mvc/team/deleteTeam.do/${team.tNum}"

												role="button">

												삭제

											</a>

										</c:when>

										<c:otherwise>

											

										</c:otherwise>

									</c:choose>

									

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