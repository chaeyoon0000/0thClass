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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script>
// 	function openMessage(){
// 		  var popupW = 900;
// 		  var popupH = 500;
// 		  var left = Math.ceil((window.screen.width - popupW)/2);
// 		  var top = Math.ceil((window.screen.height - popupH)/2);
// 		  window.open('messengerDetail.do','message','width='+popupW+',height='+popupH+',left='+left+',top='+top+',scrollbars=auto,resizable=no,toolbar=no,titlebar=no,menubar=no,location=no')			
// 		 }
// 	function writeMessage(){
// 		  var popupW = 1000;
// 		  var popupH = 700;
// 		  var left = Math.ceil((window.screen.width - popupW)/2);
// 		  var top = Math.ceil((window.screen.height - popupH)/2);
// 		  window.open('newMessenger.do','message','width='+popupW+',height='+popupH+',left='+left+',top='+top+',scrollbars=auto,resizable=no,toolbar=no,titlebar=no,menubar=no,location=no')			
// 		 }


// function getAllMessengers(str) {
	
// 	$.ajax({
// 		type: "get",
// 		url: "messenger/" + str,
// 		processData: false,
// 		success: function(responseJson){	// object parsed from JSON text	
//             //alert("JSON response: " + "\n" + JSON.stringify(responseJson));
// 			$("#result3").html("Response Body: <div><div>");
// 			$("#result3 > div").text(JSON.stringify(responseJson));
// 		   	var contentStr = "<br>데이터 사용:<br>";
// 	        if (responseJson.length) {
// 				$(responseJson).each(function(i, address){
// 	            	contentStr += "주소" + (i+1) + 
//             			"<br>우편번호: "+ address.zipNo + 
//           				"<br>도로명 주소: " + address.lnmAdres + 
//                         "<br>지번 주소: " + address.rnAdres + "<br><br>";
// 	            });
// 			}
// 			else contentStr = "No result!";	         
// 			$("#result3").append(contentStr);
// 		},
// 		error: function(){
// 			alert("ERROR", arguments);
// 		}
// 	});
// }


function getReceivedMessengers(str) {
	
	$.ajax({
		type: "get",
		url: "/mybatis-spring-mvc/messenger/getMessengerBySender.do/" + str,
		processData: false,
		success: function(responseJson){	// object parsed from JSON text	
            alert("JSON response: " + "\n" + JSON.stringify(responseJson));
// 			$("#result3").html("<tbody>");
// 			$("#result3 tbody").text(JSON.stringify(responseJson));

			//connsole.log("JSON response: " + "\n" + JSON.stringify(responsJson));
// 			$("#result3").empty();
			console.log(JSON.stringify(responseJson));
			$('#result3 > tbody').empty();
	
		//   	var contentStr = "<br>데이터 사용:<br>";
	        if (responseJson.messengers.length > 0) {			
// 				$(responseJson).each(function(i, messenger){
// 					//$("#result3").html("<tbody>");
// 					var json = JSON.stringify(responseJson);
// 					$("#result3").append("<tr><th>" + (i+1) + "</th>");
// 					$("#result3").append("<td>");
// 					var url = "/mybatis-spring-mvc/messenger/messengerDetail.do/" + messenger.mNum;
// 					$("#result3").attr("href", url);
// 					$("#result3").append("</td>");
// 					$("#result3").append("<td>" + messenger.receiver.id + "</td>");
// 					$("#result3").append("<td>" + messenger.date + "</td></tr>");
// 	            });
				//alert("for문 전");alert("url=" + $("url").val());

				$("#result3").append(document.createElement("tbody")); 
				for(var i = 0; i < responseJson.messengers.length; i++) {
					var messenger = responseJson.messengers[i]; //alert(messenger.mNum);
				
					$("#result3 > tbody:last").append("<tr><td>" + (i+1) + "</td>");
// 					$("#result3 > td:last").append("<td>");
// 					var url = "/mybatis-spring-mvc/messenger/messengerDetail.do/" + messenger.mNum;
// 					$("#result3 > tbody:last").attr("href", url);
					var url = document.createElement("td");
					url.innerHTML = "<a href='/mybatis-spring-mvc/messenger/messengerDetail.do/" + messenger.mNum + "'>"
									+ messenger.title + "</a>"
					$("#result3 > tr:last").append(url);
// 					$("#result3 > tbody:last").append(messenger.title + "</td>");
					$("#result3 > tr:last").append("<td>" + messenger.receiver.id + "</td>");
					$("#result3 > tr:last").append("<td>" + messenger.date + "</td></tr>");
				}
			}
// 			else {
// 				$('#result3 > tbody:last > tr:last').remove();
// 				$("#result3").append(document.createElement("tbody"));
// 				$('#result3 > tbody:last').append("No result!");
// 			}
		},
		error: function(){
			alert("ERROR!", arguments);
		}
	});
}

function getSendMessengers(str) {
	
	$.ajax({
		type: "get",
		url: "/mybatis-spring-mvc/messenger/getMessengerByReceiver.do/" + str,
		processData: false,
		success: function(responseJson){	// object parsed from JSON text	
	    	//alert("JSON response: " + "\n" + JSON.stringify(responseJson));
//	 			$("#result3").html("<tbody>");
//	 			$("#result3 tbody").text(JSON.stringify(responseJson));
// 			$("#result3").empty();
			console.log(JSON.stringify(responseJson));
			$( '#result3 > tbody').empty();
				
		    if (responseJson.messengers.length) {				
// 				$(responseJson).each(function(i, messenger){
// 					//$("#result3").html("<tbody>");
// 					var json = JSON.stringify(responseJson);
// 					$("#result3").append("<tr><th>" + (i+1) + "</th>");
// 					$("#result3").append("<td>");
// 					var url = "/mybatis-spring-mvc/messenger/messengerDetail.do/" + messenger.mNum;
// 					$("#result3").attr("href", url);
// 					$("#result3").append("</td>");
// 					$("#result3").append("<td>" + messenger.receiver.id + "</td>");
// 					$("#result3").append("<td>" + messenger.date + "</td></tr>");
// 			    });

				for(var i = 0; i < responseJson.messengers.length; i++) {
					var messenger = messengers[i];
					$("#result3").append(document.createElement("tbody"));
					$("#result3").append("<tr><th>" + (i+1) + "</th>");
					$("#result3").append("<td>");
					var url = "/mybatis-spring-mvc/messenger/messengerDetail.do/" + messenger.mNum;
					$("#result3").attr("href", url);
					$("#result3").append("</td>");
					$("#result3").append("<td>" + messenger.receiver.id + "</td>");
					$("#result3").append("<td>" + messenger.date + "</td></tr>");
				}
			}
			//else {

// 				$('#result3 > tbody:last > tr:last').remove();
// 				$("#result3").append(document.createElement("tbody"));
// 				$('#result3 > tbody:last').append("No result!");
// 			}
		},
		error: function(){
				alert("ERROR", arguments);
			}
		});
	}
</script>
</head>
  <body style="background-image: url('<%=request.getContextPath()%>/bootstraps/images/bg.jpg');">

	<div class="site-wrap">
		<div class="site-section">
			<div class="container">
			<div class="row align-items-center justify-content-center">
					<div class="col-md-7 text-center" data-aos="fade">
						<h1 class="text-uppercase">all messages</h1>
						<span class="caption d-block">write messages</span>
					</div>
				</div>
				<br/><br/>
				<ul class="nav nav-tabs">
					<li class="nav-item"><a class="nav-link active" href="/mybatis-spring-mvc/messenger/listMessengers.do/">All</a></li>
<!-- 					<li class="nav-item"><a class="nav-link" href="receivedList.jsp">Received</a></li> -->
<!-- 					<li class="nav-item"><a class="nav-link" href="sentList.jsp">Sent</a></li> -->
<!-- 					<li class="nav-item"><label class="btn btn-primary text-white"> -->
<!-- 						<input type="radio" id="uNum" name="uNum" value="0"  onClick="getAllMessengers(609);"> -->
<%-- 							${checkStatusList[0]}</label></li> --%>
					<li class="nav-item"><label class="btn btn-primary text-white">
						<input type="radio" id="uNum" name="uNum" value="1"  onClick="getReceivedMessengers(609);">
							${checkStatusList[1]}</label></li>
					<li class="nav-item"><label class="btn btn-primary text-white">
						<input type="radio" id="uNum" name="uNum" value="2"  onClick="getSendMessengers(609);">
							${checkStatusList[2]}</label></li>		
				</ul><br/>
				<div class="row">
					<span class="caption d-block mb-2 font-secondary font-weight-bold">messenger</span>
					<table class="table" style="text-align: center;" id="result3">
						<thead>
							<tr>
								<th scope="col">No</th>
								<th scope="col">Title</th>
								<th scope="col">Sender</th>
								<th scope="col">Date</th>
							</tr>
						</thead>
						<c:if test="${!empty messengerList}">
							<c:forEach var="messenger" items="${messengerList}" varStatus="stat">
<!-- 							<div id="result3"> -->
								<tbody>
									<tr> <!-- onKeypress="this.onClick;" style="cursor:pointer;"> --><!-- onClick="openMessage();return false;" -->
										<th>${stat.count}</th>
										<td><a href="/mybatis-spring-mvc/messenger/messengerDetail.do/${messenger.mNum}">
											${messenger.title}</a></td>
										<td>${messenger.receiver.id}</td>
										<td>${messenger.date}</td>
									</tr>
								</tbody>
<!-- 							</div> -->
							</c:forEach>
						</c:if>
					</table>
				</div>
				<div style="text-align: right;">
					<a class="btn btn-outline-primary px-4 py-2" href="/mybatis-spring-mvc/messenger/newMessenger.do" 
						onKeypress="this.onClick;" style="cursor:pointer;" role="button">New Message</a><!-- onClick="writeMessage();return false;" -->
				</div>
				<div class="row">

					<div class="col-12 text-center">
						<div class="custom-pagination">
<!-- 							<span class="current">1</span> <a href="#">2</a> <a href="#">3</a> -->
<!-- 							<a href="#">4</a> <a href="#">5</a> <span>...</span> <a href="#">14</a> -->
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
