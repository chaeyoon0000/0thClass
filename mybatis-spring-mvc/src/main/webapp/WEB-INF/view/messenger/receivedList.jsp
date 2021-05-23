<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <title>Funder &mdash; Colorlib Website Template</title>
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
	function openMessage(){
		  var popupW = 900;
		  var popupH = 500;
		  var left = Math.ceil((window.screen.width - popupW)/2);
		  var top = Math.ceil((window.screen.height - popupH)/2);
		  window.open('messengerDetail.jsp','message','width='+popupW+',height='+popupH+',left='+left+',top='+top+',scrollbars=auto,resizable=no,toolbar=no,titlebar=no,menubar=no,location=no')			
		 }
	</script>
  </head>
  <body style="background-image: url('<%=request.getContextPath()%>/bootstraps/images/bg.jpg');">

	<div class="site-wrap">
		<div class="site-section">
			<div class="container">
			<div class="row align-items-center justify-content-center">
					<div class="col-md-7 text-center" data-aos="fade">
						<h1 class="text-uppercase">received</h1>
						<span class="caption d-block">write messages</span>
					</div>
				</div>
				<br/><br/>
				<ul class="nav nav-tabs">
			<li class="nav-item"><a class="nav-link" href="messengerList.jsp">All</a>
			</li>
			<li class="nav-item"><a class="nav-link active" href="receivedList.jsp">Received</a></li>
			<li class="nav-item"><a class="nav-link" href="sentList.jsp">Sent</a></li>
		</ul><br/>
				<div class="row">
					<span class="caption d-block mb-2 font-secondary font-weight-bold">messenger</span>
					<table class="table" style="text-align: center;">
						<thead>
							<tr>
								<th scope="col">No</th>
								<th scope="col">Title</th>
								<th scope="col">Sender</th>
								<th scope="col">Date</th>
							</tr>
						</thead>
						<tbody>
							<tr onClick="openMessage();return flase;" onKeypress="this.onClick;" style="cursor:pointer;">
								<th>1</th>
								<td>안녕하세요</td>
								<td>솜솜이</td>
								<td>19/05/20</td>
							</tr>
							<tr onClick="openMessage();return flase;" onKeypress="this.onClick;" style="cursor:pointer;">
								<th>2</th>
								<td>안녕하세요</td>
								<td>솜솜이</td>
								<td>19/05/20</td>
							</tr>
							<tr onClick="openMessage();return flase;" onKeypress="this.onClick;" style="cursor:pointer;">
								<th>3</th>
								<td>안녕하세요</td>
								<td>솜솜이</td>
								<td>19/05/20</td>
							</tr>
							<tr onClick="openMessage();return flase;" onKeypress="this.onClick;" style="cursor:pointer;">
								<th>4</th>
								<td>안녕하세요</td>
								<td>솜솜이</td>
								<td>19/05/20</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="row">

					<div class="col-12 text-center">
						<div class="custom-pagination">
							<span class="current">1</span> <a href="#">2</a> <a href="#">3</a>
							<a href="#">4</a> <a href="#">5</a> <span>...</span> <a href="#">14</a>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>

	<script src="<%=request.getContextPath()%>/bootstraps/js/jquery-3.3.1.min.js"></script>
  <script src="<%=request.getContextPath()%>/bootstraps/js/jquery-migrate-3.0.1.min.js"></script>
  <script src="<%=request.getContextPath()%>/bootstraps/js/jquery-ui.js"></script>
  <script src="<%=request.getContextPath()%>/bootstraps/js/popper.min.js"></script>
  <script src="<%=request.getContextPath()%>/bootstraps/js/bootstrap.min.js"></script>
  <script src="<%=request.getContextPath()%>/bootstraps/js/owl.carousel.min.js"></script>
  <script src="<%=request.getContextPath()%>/bootstraps/js/jquery.stellar.min.js"></script>
  <script src="<%=request.getContextPath()%>/bootstraps/js/jquery.countdown.min.js"></script>
  <script src="<%=request.getContextPath()%>/bootstraps/js/jquery.magnific-popup.min.js"></script>
  <script src="<%=request.getContextPath()%>/bootstraps/js/bootstrap-datepicker.min.js"></script>
  <script src="<%=request.getContextPath()%>/bootstraps/js/aos.js"></script>

  <script src="<%=request.getContextPath()%>/bootstraps/js/main.js"></script>

  </body>
</html>
