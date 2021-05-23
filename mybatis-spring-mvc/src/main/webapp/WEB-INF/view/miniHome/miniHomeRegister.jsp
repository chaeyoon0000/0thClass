<!DOCTYPE html>

 

<%@ page language="java" contentType="text/html; charset=UTF-8"

	pageEncoding="UTF-8"%>

 

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

 

<!-- <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"> -->

<!-- <script src="//code.jquery.com/jquery.min.js"></script> -->

<!-- <script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script> -->

    

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>

<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>    

    

<script>

$(function() {

  $( "#schDate" ).datepicker({

    dateFormat: 'yy.mm.dd'

  });

});

 

$(function() {

	  $( "#actDate" ).datepicker({

	    dateFormat: 'yy.mm.dd'

	  });

	});

 

function yesnoCheck() {

    if (document.getElementById('yesCheck').checked) {

        document.getElementById('ifYes').style.display ="";

        document.getElementById('ifNo').style.display ="none";

    } else {

        document.getElementById('ifYes').style.display ="none";

        document.getElementById('ifNo').style.display ="";

    }

//     if (document.getElementById('yesCheck').checked) {

//         document.getElementById('ifYes').style.visibility = 'visible';

//         document.getElementById('ifNo').style.visibility = 'hidden';

//     } else {

//         document.getElementById('ifYes').style.visibility = 'hidden';

//         document.getElementById('ifNo').style.visibility = 'visible';

//     }

 

}

 

 

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

		<div class="site-section">

		<div class="container">

				<div class="row align-items-center justify-content-center">

					<div class="col-md-7 text-center" data-aos="fade">

						<h1 class="text-uppercase">Team Name</h1>

						<span class="caption d-block">mentoring by somsom</span>

					</div>

				</div>

				<br/><br/>

			</div>

			<div class="container">

				<div class="row">

					<div class="col-lg-1"></div>

					<div class="col-md-12 col-lg-10 mb-5">

<!-- 						<form action="#" class="p-5 bg-white"> -->

 

<input type="radio" onclick="javascript:yesnoCheck();" name="yesno" id="yesCheck"/>Schedule

<input type="radio" onclick="javascript:yesnoCheck();" name="yesno" id="noCheck"/>Activity

 

<div id="ifYes" style="display:none;">

							<form action="../insertNewActivitySchedule.do/${team.tNum}" class="p-5 bg-white" method="post" enctype="multipart/form-data">

							<p class="h5 text-black mb-3">Schedule</p>

							<div class="row form-group">

								<div class="col-md-12 mb-3 mb-md-0">

									<label class="font-weight-bold" for="title">Schedule

										title</label> <input type="text" id="title" name="title" class="form-control"

										placeholder="schedule title">

								</div>

							</div>

							<div class="row form-group">

								<div class="col-md-12 mb-3 mb-md-0">

									<label class="font-weight-bold" for="date">Date</label> <input

										type="text" id="schDate" name="schDate" class="form-control"

										placeholder="YYYY-MM-DD">

								</div>

							</div>

							<div class="row form-group">

								<div class="col-md-12 mb-3 mb-md-0">

									<label class="font-weight-bold" for="address">Address</label> <input

										type="text" id="schAddr" name="schAddr" class="form-control"

										placeholder="address">

								</div>

							</div>

							<div class="row form-group">

								<div class="col-md-12 mb-3 mb-md-0">

									<label class="font-weight-bold" for="content">Contents</label>

									<textarea id="schContent" name="schContent"class="form-control" rows="5"></textarea>

								</div>

							</div>

<!-- 							<div class="row form-group"> -->

<!-- 								<div class="col-md-12 mb-3 mb-md-0"> -->

<!-- 									<label class="font-weight-bold" for="file">File</label> <input -->

<!-- 										type="file" class="form-control-file" id="file"> -->

<!-- 								</div> -->

<!-- 							</div> -->

 

							<input type="hidden" name="tNum" value="${team.tNum}" /> 

							<input type="hidden" name="uNum" value="${mentor.uNum}" />

							<div class="row form-group" style="text-align: right">

								<div class="col-md-12">

									<a class="btn btn-outline-primary px-4 py-2" href="miniHome.jsp" role="button" data-toggle="modal" data-target="#cancleModal">

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

												<div class="modal-body" style="text-align: left">

													홈으로 돌아갑니다.

												</div>

												<div class="modal-footer">

													<button type="button" class="btn btn-outline-primary" data-dismiss="modal">

														취소

													</button>

													<a class="btn btn-primary" href="miniHome.jsp" role="button">

														확인

													</a>

												</div>

											</div>

										</div>

									</div>

									<input type="submit" value="upload" class="btn btn-primary text-white px-4 py-2">

								</div>

							</div>

						</form>

					</div>

<div id="ifNo" style="display:none;">

							<form action="../insertNewActivity.do/${team.tNum}" class="p-5 bg-white" method="post" enctype="multipart/form-data">

							<p class="h5 text-black mb-3">Activity</p>

							<div class="row form-group">

								<div class="col-md-12 mb-3 mb-md-0">

									<label class="font-weight-bold" for="title">Activity

										title</label> <input type="text" id="title" name="title" class="form-control"

										placeholder="schedule title">

								</div>

							</div>

							<div class="row form-group">

								<div class="col-md-12 mb-3 mb-md-0">

									<label class="font-weight-bold" for="date">Activity Date</label> <input

										type="text" id="actDate" name="actDate" class="form-control"

										placeholder="YYYY-MM-DD">

								</div>

							</div>

							<div class="row form-group">

								<div class="col-md-12 mb-3 mb-md-0">

									<label class="font-weight-bold" for="address">Activity Address</label> <input

										type="text" id="actAddress" name="actAddress" class="form-control"

										placeholder="address">

								</div>

							</div>

							<div class="row form-group">

								<div class="col-md-12 mb-3 mb-md-0">

									<label class="font-weight-bold" for="content">Contents</label>

									<textarea id="aContent" name="aContent" class="form-control" rows="5"></textarea>

								</div>

							</div>

							<div class="row form-group">

								<div class="col-md-12 mb-3 mb-md-0">

									<label class="font-weight-bold" for="Image">Image</label> <input

										type="file" class="form-control-file" id="image" name="image">

								</div>

							</div>

 

							<input type="hidden" name="tNum" value="${team.tNum}" /> 

							<input type="hidden" name="uNum" value="${mentor.uNum}" />

							<div class="row form-group" style="text-align: right">

								<div class="col-md-12">

									<a class="btn btn-outline-primary px-4 py-2" href="miniHome.jsp" role="button" data-toggle="modal" data-target="#cancleModal">

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

												<div class="modal-body" style="text-align: left">

													홈으로 돌아갑니다.

												</div>

												<div class="modal-footer">

													<button type="button" class="btn btn-outline-primary" data-dismiss="modal">

														취소

													</button>

													<a class="btn btn-primary" href="miniHome.jsp" role="button">

														확인

													</a>

												</div>

											</div>

										</div>

									</div>

									<input type="submit" value="upload" class="btn btn-primary text-white px-4 py-2">

								</div>

							</div>

						</form>

					</div>

					

					

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

