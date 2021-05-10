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
		<div class="site-section">
			<div class="container">
				<div class="row">
					<div class="col-lg-1"></div>
					<div class="col-md-12 col-lg-10 mb-5">
						<form action="#" class="p-5 bg-white">
							<p class="h5 text-black mb-3">Message</p>
							<div class="row">
								<div class="col-2">
									<p class="mb-0 font-weight-bold">Sender</p>
								</div>
								<div class="col-2">
									<p class="mb-4">${messenger.sender.id}</p>
								</div>
								<div class="col-2">
									<p class="mb-0 font-weight-bold">Receiver</p>
								</div>
								<div class="col-2">
									<p class="mb-4">${messenger.receiver.id}</p>
								</div>
								<div class="col-1">
									<p class="mb-0 font-weight-bold">Date</p>
								</div>
								<div class="col-3">
									<p class="mb-4">${messenger.date}</p>
								</div>
							</div>

							<div class="row">
								<div class="col-2">
									<p class="mb-0 font-weight-bold">Title</p>
								</div>
								<div class="col-10">
									<p class="mb-4">${messenger.title}</p>
								</div>
							</div>
							
							<p class="mb-0 font-weight-bold">Content</p>
							<br />
							<p class="mb-4">${messenger.content}</p>

							<div class="row form-group" style="text-align: right">
								<div class="col-md-12">
									<a class="btn btn-outline-primary px-4 py-2" href="listMessengers.do" role="button" data-toggle="modal" data-target="#cancleModal">
										Confirm
									</a>
									<div class="modal fade" id="cancleModal" tabindex="-1" role="dialog" aria-labelledby="cancleModalLabel" aria-hidden="true">
									<div class="modal-dialog" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="cancleModalLabel">창 닫기</h5>
												<button type="button" class="close" data-dismiss="modal" aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
											</div>
											<div class="modal-body" style="text-align: left">창을 닫습니다.</div>
											<div class="modal-footer">
<!-- 												<button type="button" class="btn btn-outline-primary" data-dismiss="modal">확인</button> -->
												<a class="btn btn-primary" href="javascript:history.back()" role="button">확인</a>
											</div>
										</div>
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