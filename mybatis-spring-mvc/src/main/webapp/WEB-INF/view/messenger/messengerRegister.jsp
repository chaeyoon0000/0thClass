<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>Zero Class &mdash; Messenger</title>
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
</head>
<body style="background-image: url('<%=request.getContextPath()%>/bootstraps/images/bg.jpg');">
	<div class="site-wrap">
		<div class="site-section">
		<div class="container">
				<div class="row align-items-center justify-content-center">
					<div class="col-md-7 text-center" data-aos="fade">
						<h1 class="text-uppercase">Write message</h1>
						<span class="caption d-block">new message</span>
					</div>
				</div>
				<br/><br/>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-lg-1"></div>
					<div class="col-md-12 col-lg-10 mb-5">
						<form:form commandName="messengerForm" class="p-5 bg-white">
							<p class="h5 text-black mb-3">Message</p>
							<div class="row form-group">
								<div class="col-md-12 mb-3 mb-md-0"> 
<%-- 								에러나면 여기 부분 ${error} 2개 삭제 --%>
									<form:label class="font-weight-bold" path="receiver.id">Receiver</form:label> 
									<c:if test="${empty receiver_id}">
										<form:input path="receiver.id" class="form-control" placeholder="receiver's id" /> ${error}
									</c:if>
									<c:if test="${!empty receiver_id}">
										<p class="mb-4">${receiver_id}</p> ${error}
<%-- 										<form:input path="receiver.id" class="form-control" placeholder="receiver's id" /> --%>
									</c:if>
								</div>
							</div>
							<div class="row form-group">
								<div class="col-md-12 mb-3 mb-md-0">
<!-- 								에러나면 if문 다 삭제, 두번째 if문에 해당하는 내용 삭제 -->
									<c:if test="${empty messenger}">
										<form:label class="font-weight-bold" path="title">Message title</form:label> 
										<form:input path="title" class="form-control" placeholder="messsage title" />
									</c:if>
									<c:if test="${!empty messenger}">
										<form:label class="font-weight-bold" path="title">Message title</form:label> 
										<form:input path="title" class="form-control" value="${messenger.title}" />
									</c:if>
								</div>
							</div>
							<div class="row form-group">
								<div class="col-md-12 mb-3 mb-md-0">
									<form:label class="font-weight-bold" path="content">Contents</form:label>
									<form:textarea path="content" class="form-control" rows="5" />
								</div>
							</div>
							<div class="row form-group" style="text-align: right">
								<div class="col-md-12">
									<a class="btn btn-outline-primary px-4 py-2" href="javascript:history.back()" role="button" data-toggle="modal" data-target="#cancleModal">
										cancel
									</a>
									<div class="modal fade" id="cancleModal" tabindex="-1" role="dialog" aria-labelledby="cancleModalLabel" aria-hidden="true">
										<div class="modal-dialog" role="document">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title" id="cancleModalLabel">
														Inform
													</h5>
													<button type="button" class="close" data-dismiss="modal" aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
												</div>
												<div class="modal-body" style="text-align: center">
													현재 창을 닫습니다.
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-outline-primary" data-dismiss="modal">
														Cancel
													</button>
<!-- 													<a class="btn btn-primary" href="/mybatis-spring-mvc/messenger/listMessengers.do" role="button"> -->
														<a class="btn btn-primary" href="javascript:window.close()" role="button">
														OK
													</a>
												</div>
											</div>
										</div>
									</div>
									<input type="submit" value="send" class="btn btn-primary text-white px-4 py-2">
								</div>
							</div>
						</form:form>
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
