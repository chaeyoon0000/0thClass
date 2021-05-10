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
    
    	<link href='<%=request.getContextPath()%>/fullcalendar/core/main.css' rel='stylesheet' />
    <link href='<%=request.getContextPath()%>/fullcalendar/daygrid/main.css' rel='stylesheet' />
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    
    
    <script src='<%=request.getContextPath()%>/fullcalendar/core/main.js'></script>
    <script src='<%=request.getContextPath()%>/fullcalendar/daygrid/main.js'></script>
    <script src='<%=request.getContextPath()%>/fullcalendar/interaction/main.js'></script>
    
	<script>
		document.addEventListener('DOMContentLoaded', function() {
			var calendarEl = document.getElementById('calendar');
			var dataset = [
			    <c:forEach var="schedule" items="${scheduleList}" varStatus="status">
			        <c:if test="${schedule.schDate != ''}">
			            {"id":'<c:out value="${schedule.sNum}" />'
			            ,"title":'<c:out value="${schedule.title}" />'
			            ,"start":"<c:out value="${schedule.schDate}" />"
			            <c:if test="${schedule.schWrite != ''}">
			                ,"end":"<c:out value="${schedule.schWrite}" />"
			            </c:if>
			            ,"url":"/mybatis-spring-mvc/miniHome/scheduleDetail.do/${schedule.sNum}"
			            } <c:if test="${!status.last}">,</c:if>
			        </c:if>
			    </c:forEach>
			    
			    
			];

			
			
			var calendar = new FullCalendar.Calendar(calendarEl, {
				plugins : ['interaction', 'dayGrid' ],
				selectable: true,
				select: function(info) {
					window.open('/mybatis-spring-mvc/miniHome/newActivitySchedule.do/${team.tNum}', '_self', '');
			      },
				eventClick: function(info) {
			        var eventObj = info.event;

			        if (eventObj.url) {
			          
			          window.open(eventObj.url, '_self', '');

			          info.jsEvent.preventDefault(); // prevents browser from following link in current tab.
			        } else {
			          alert('Clicked ' + eventObj.title);
			        }
			      },
			      eventLimit: true,
			      events: dataset
// 				events: [
// 				    {
// 				    	id	: '11',
// 				      title  : 'schedule1',
// 				      start  : '2019-05-01',
// 				      textColor : 'white',
// 				    	  url : 'scheduleDetail.jsp'
// 				    },
// 				    {
// 				    	id	: '21',
// 				      title  : 'schedule2',
// 				      start  : '2019-05-05',
// 				      end    : '2019-05-07',
// 				      textColor : 'white',
// 				    	  url : 'scheduleDetail.jsp'
// 				    },
// 				    {
// 				    	id	: '31',
// 				      title  : 'schedule3',
// 				      start  : '2019-05-09T12:30:00',
// 				      textColor : 'white',
// 				      url : 'scheduleDetail.jsp',
// 				      allDay : false // will make the time show
// 				    },
// 				    {
// 				    	id	: '12',
// 						title  : 'activity1',
// 						start  : '2019-05-09',
// 						color  : 'purple',
// 						textColor : 'white',
// 						url : 'activityDetail.jsp'
// 					}
// 				  ],	      
			});

			calendar.render();
		});
	</script>
	
	<style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
      
      #calendar {
      max-width: 900px;
      margin: 40px auto;
    }
    
    </style>
  </head>
  <body style="background-image: url('<%=request.getContextPath()%>/bootstraps/images/bg.jpg');">
  
  <div class="site-wrap">
<h2 class="mb-0 site-logo">
								<a href="<%=request.getContextPath()%>/mainPage.do" class="font-weight-bold">
								Zero Class</a>
							</h2>
  
  <!-- <div class="site-blocks-cover inner-page overlay" style="background-image: url(<%=request.getContextPath()%>/bootstraps/images/hero_bg_1.jpg);" data-aos="fade" data-stellar-background-ratio="0.5">
      <div class="row align-items-center justify-content-center">
					<div class="col-md-7 text-center" data-aos="fade">
						<h1 class="text-uppercase">Team Name</h1>
						<span class="caption d-block text-white">mentoring by somsom</span>
					</div>
				</div>
				</div>-->
		<div class="site-section">
			<div class="container">
				<div class="row align-items-center justify-content-center">
					<div class="col-md-7 text-center" data-aos="fade">
						<h1 class="text-uppercase"><c:out value="${scheduleTname}" /></h1>
						<span class="caption d-block">mentoring by <c:out value="${scheduleMentorName}" /></span>
					</div>
				</div>
				<br/><br/>
			</div>
			<div class="container">


				<div id='calendar'></div>
			</div>
		</div>
		<div class="slide-one-item home-slider owl-carousel">
<c:if test="${!empty activityList}"> 
	<c:forEach var="activity" items="${activityList}" varStatus="stat">
      <div class="site-blocks-cover inner-page overlay" style="background-image: 
      url(<%=request.getContextPath()%>/upload/${activity.image});" 
      onClick="location.href='/mybatis-spring-mvc/miniHome/activityDetail.do/${activity.aNum}'" style="cursor:pointer;"
      data-aos="fade" data-stellar-background-ratio="0.5">
        <div class="container">
          <div class="row align-items-center">
            <div class="col-md-6" data-aos="fade">
              <h1 class="font-secondary font-weight-bold text-uppercase"><c:out value="${activity.title}" /></h1>
              <span class="caption d-block text-white"><c:out value="${activity.aContent}" /></span>
            </div>
          </div>
        </div>
      </div>  
   </c:forEach>
</c:if> 		
<c:if test="${empty activityList}"> 
      <div class="site-blocks-cover inner-page overlay" style="background-image: 
      url(<%=request.getContextPath()%>/bootstraps/images/hero_bg_1.jpg);" data-aos="fade" data-stellar-background-ratio="0.5">
        <div class="container">
          <div class="row align-items-center">
            <div class="col-md-6" data-aos="fade">
              <h1 class="font-secondary font-weight-bold text-uppercase">Small Business Insurance Agency</h1>
              <span class="caption d-block text-white">An Insurance Company</span>
            </div>
          </div>
        </div>
      </div>  

      <div class="site-blocks-cover inner-page overlay" style="background-image: 
      url(<%=request.getContextPath()%>/bootstraps/images/hero_bg_2.jpg);" data-aos="fade" data-stellar-background-ratio="0.5">
        <div class="container">
          <div class="row align-items-center justify-content-center">
            <div class="col-md-7 text-center" data-aos="fade">
              <h1 class="font-secondary font-weight-bold text-uppercase">Insurance Coverage To Meet Your Needs</h1>
              <span class="caption d-block text-white">You Will Love Our Services</span>
            </div>
          </div>
        </div>
      </div> 
    </div>
</c:if> 	
    

    <div class="site-section">
      <div class="container">
        <div class="row mb-5">
          <div class="col-md-12 text-center">
            <span class="caption d-block mb-2 font-secondary font-weight-bold">Outstanding Services</span>
            <h2 class="site-section-heading text-uppercase text-center font-secondary">Why Choose Us</h2>
          </div>
        </div>
        <div class="row border-responsive">
          <div class="col-md-6 col-lg-3 mb-4 mb-lg-0 border-right">
            <div class="text-center">
              <span class="flaticon-customer-service display-4 d-block mb-3 text-primary"></span>
              <h3 class="text-uppercase h4 mb-3">24/7 Support</h3>
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eaque, nobis?</p>
            </div>
          </div>
          <div class="col-md-6 col-lg-3 mb-4 mb-lg-0 border-right">
            <div class="text-center">
              <span class="flaticon-group display-4 d-block mb-3 text-primary"></span>
              <h3 class="text-uppercase h4 mb-3">Trusted People</h3>
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eaque, nobis?</p>
            </div>
          </div>
          <div class="col-md-6 col-lg-3 mb-4 mb-lg-0 border-right">
            <div class="text-center">
              <span class="flaticon-medal display-4 d-block mb-3 text-primary"></span>
              <h3 class="text-uppercase h4 mb-3">12 Years Experience</h3>
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eaque, nobis?</p>
            </div>
          </div>
          <div class="col-md-6 col-lg-3 mb-4 mb-lg-0">
            <div class="text-center">
              <span class="flaticon-agreement display-4 d-block mb-3 text-primary"></span>
              <h3 class="text-uppercase h4 mb-3">Join With Us</h3>
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eaque, nobis?</p>
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
