<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
   <head>
    <title>Zero Class</title>
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
	function openMessenger(){
		  var popupW = 800;
		  var popupH = 700;
		  var left = Math.ceil((window.screen.width - popupW)/2);
		  var top = Math.ceil((window.screen.height - popupH)/2);
		  window.open('<%=request.getContextPath()%>/messenger/listMessengers.do','messenger','width='+popupW+',height='+popupH+',left='+left+',top='+top+',scrollbars=auto,resizable=no,toolbar=no,titlebar=no,menubar=no,location=no')			
		 }
	</script>
  </head>
  <body style="background-image: url('<%=request.getContextPath()%>/bootstraps/images/bg.jpg');">
  
  <div class="site-wrap">
    <div class="site-mobile-menu">
      <div class="site-mobile-menu-header">
        <div class="site-mobile-menu-close mt-3">
          <span class="icon-close2 js-menu-toggle"></span>
        </div>
      </div>
      <div class="site-mobile-menu-body">
      </div>
    </div>
    <div class="site-navbar-wrap js-site-navbar bg-white">
      <div class="container">
        <div class="site-navbar bg-light">
          <div class="row align-items-center">
            <div class="col-2">
              <h2 class="mb-0 site-logo">
              	<a href="<%=request.getContextPath()%>/mainPage.do" class="font-weight-bold">
              		Zero Class
              	</a>
              </h2>
            </div>
            <div class="col-10">
              <nav class="site-navigation text-right" role="navigation">
                <div class="container">
                  <div class="d-inline-block d-lg-none ml-md-0 mr-auto py-3">
                  	<a href="#" class="site-menu-toggle js-menu-toggle text-black">
                  		<span class="icon-menu h3">
                  		</span>
                  	</a>
                  </div>
                  <ul class="site-menu js-clone-nav d-none d-lg-block">
                    <li>
                    	<a href="<%=request.getContextPath()%>/team/teamList.do">
                    		Team
                    	</a>
                    </li>
                    <li class="has-children">
                      <a href="<%=request.getContextPath()%>/product/listProducts.do?page=1">
                      	Market
                      </a>
                      <ul class="dropdown arrow-top">
                        <li>
                        	<a href="<%=request.getContextPath()%>/product/listProducts.do?page=1">
                        		Product
                        	</a>
                        </li>
                        <li>
                        	<a href="<%=request.getContextPath()%>/auction/auctionList.do?page=1">
                        		Auction
                        	</a>
                        </li>
                      </ul>
                    </li>
                    <li>
                    	<a href="<%=request.getContextPath()%>/review/reviewList.do?page=1">
                    		Review
                    	</a>
                    </li>
                   	<li class="has-children">
                      	<a href="<%=request.getContextPath()%>/user/myPage.do">
                      		My Page
                      	</a>
                      <ul class="dropdown arrow-top">
                        <li><a href="<%=request.getContextPath()%>/user/myPage.do">My Information</a></li>
                        <li><a href="<%=request.getContextPath()%>/user/myOrder.do">Order</a></li>
                      </ul>
                    </li>
                    <c:if test="${empty sessionScope.user}">
                    	<li class="active">
                    		<a href="<%=request.getContextPath()%>/login/login.do">
                    			Login
                    		</a>
                   	 	</li>
                    </c:if>
                    <c:if test="${! empty sessionScope.user}">
                    	<li class="active"><a>${sessionScope.user.id}</a></li>
						<li class="active"><a>${sessionScope.user.point}p</a></li>
						<li><a href="<%=request.getContextPath()%>/wishlist/listWishs.do">
							<img src="<%=request.getContextPath()%>/resources/cart.png"/></a></li>
						<li><a style="cursor:pointer" onClick="openMessenger();return flase;">
							<img src="<%=request.getContextPath()%>/resources/envelope.png" /></a></li>
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
    
        <div class="slide-one-item home-slider owl-carousel">
      
      <div class="site-blocks-cover inner-page overlay" style="background-image: url(<%=request.getContextPath()%>/bootstraps/images/hero_bg_1.jpg);" data-aos="fade" data-stellar-background-ratio="0.5">
        <div class="container">
          <div class="row align-items-center">
            <div class="col-md-6" data-aos="fade">
              <h1 class="font-secondary font-weight-bold text-uppercase">MEET</h1>
              <span class="caption d-block text-white">10대부터 60대까지 혹은 그 이상이라도, 성별에 상관없이 <br>누구나 원한다면 여러 사람들과 직접 만남을 통해 <br>다양한 재능을 공유할 수 있습니다</span>
            </div>
          </div>
        </div>
      </div>  

      <div class="site-blocks-cover inner-page overlay" style="background-image: url(<%=request.getContextPath()%>/bootstraps/images/hero_bg_2.jpg);" data-aos="fade" data-stellar-background-ratio="0.5">
        <div class="container">
          <div class="row align-items-center justify-content-center">
            <div class="col-md-7 text-center" data-aos="fade">
              <h1 class="font-secondary font-weight-bold text-uppercase">TALENT</h1>
              <span class="caption d-block text-white">재능기부 봉사자들은 자신의 경력, 노하우 등을 발휘하여 봉사하며<br> 자존감을 높이고, 재능기부 수혜자들은 자신의 상황에 맞는 <br> 맞춤형 혜택을 받을 수 있습니다.
					</span>
            </div>
          </div>
        </div>
      </div> 
      
      <div class="site-blocks-cover inner-page overlay" style="background-image: url(<%=request.getContextPath()%>/bootstraps/images/hero_bg_1.jpg);" data-aos="fade" data-stellar-background-ratio="0.5">
        <div class="container">
          <div class="row align-items-center justify-content-center">
            <div class="col-md-7 text-center" data-aos="fade">
              <h1 class="font-secondary font-weight-bold text-uppercase">CHOICE</h1>
              <span class="caption d-block text-white">한눈에 들어오는 PPT 디자인 제작, A+ 받을 수 있는 레포트 작성법, 다양한 프로젝트 경험 등 다양한 카테고리
								안에서 나에게 필요한 재능을 선택할 수 있는 폭넓은 교실을 제공합니다.
					</span>
            </div>
          </div>
        </div>
      </div> 
    </div>

    <div class="site-section">
      <div class="container">
        <div class="row mb-5">
          <div class="col-md-12 text-center">
            <span class="caption d-block mb-2 font-secondary font-weight-bold">0교시</span>
            <h2 class="site-section-heading text-uppercase text-center font-secondary">Zero Class</h2>
          </div>
        </div>
        <div class="row border-responsive">
          <div class="col-md-6 col-lg-3 mb-4 mb-lg-0 border-right">
            <div class="text-center">
              <span class="flaticon-customer-service display-4 d-block mb-3 text-primary"></span>
              <h3 class="text-uppercase h4 mb-3"> 모임용 재능기부 </h3>
              <p>모임을 결성하여 <br> 팀장은 팀원들에게 재능 기부</p>
            </div>
          </div>
          <div class="col-md-6 col-lg-3 mb-4 mb-lg-0 border-right">
            <div class="text-center">
              <span class="flaticon-group display-4 d-block mb-3 text-primary"></span>
              <h3 class="text-uppercase h4 mb-3">Mini Home</h3>
              <p>팀 결성 후, 팀원들만 <br> 공유할 수 있는 커뮤니티인  <br> Mini Home 제공</p>
            </div>
          </div>
          <div class="col-md-6 col-lg-3 mb-4 mb-lg-0 border-right">
            <div class="text-center">
              <span class="flaticon-medal display-4 d-block mb-3 text-primary"></span>
              <h3 class="text-uppercase h4 mb-3">거래용 재능기부</h3>
              <p>포인트를 이용하여 재능을 거래</p>
            </div>
          </div>
          <div class="col-md-6 col-lg-3 mb-4 mb-lg-0">
            <div class="text-center">
              <span class="flaticon-agreement display-4 d-block mb-3 text-primary"></span>
              <h3 class="text-uppercase h4 mb-3">재능기부 - 경매</h3>
              <p>제한 시간 내에 <br> 포인트를 가장 높이 부르는 사람과 거래</p>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="site-section">
      <div class="container">
        <div class="row">
          <div class="col-lg-6">
            <p class="mb-5"><img src="<%=request.getContextPath()%>/bootstraps/images/zeroclass.png" alt="Image" class="img-fluid"></p>
          </div>
          <div class="col-lg-5 ml-auto">
            <h2 class="site-section-heading mb-3 font-secondary text-uppercase">0교시란?</h2>
            <p class="mb-5">바쁜 현대인에게 정규 수업 같은 일상에서 벗어나 ‘0교시’에서는 재능 기부 및 거래를 통한 자유로운 배움터를 제공합니다.</p>
            <p><a href="<%=request.getContextPath()%>/user/register.do" class="btn btn-outline-primary py-2 px-4">Join With Me!</a></p>
          </div>
        </div>
      </div>
    </div>

    <footer class="site-footer">
      <div class="container">
        

        <div class="row">
          <div class="col-md-4">
            <h3 class="footer-heading mb-4 text-white">About</h3>
            <p>바쁜 현대인에게 정규 수업같은 일상에서 벗어나 '0교시'에서는 재능 기부 및 거래를 통한 자유로운 배움터를 제공합니다.</p>
          </div>
          <div class="col-md-5 ml-auto">
            <div class="row">
              <div class="col-md-6">
                <h3 class="footer-heading mb-4 text-white">Quick Menu</h3>
                  <ul class="list-unstyled">
                    <li><a href="mainPage.jsp">Home</a></li>
                    <li><a href="team/teamList.jsp">Team</a></li>
                    <li><a href="product/productList.jsp">Product</a></li>
                    <li><a href="auction/auctionList.jsp">Auction</a></li>
                    <li><a href="review/reviewList.jsp">Review</a></li>
                  </ul>
              </div>
              <div class="col-md-6">
                <h3 class="footer-heading mb-4 text-white">My Page</h3>
                  <ul class="list-unstyled">
                    <li><a href="user/myPage.jsp">Information</a></li>
                    <li><a href="user/order.jsp">Order</a></li>
                  </ul>
              </div>
            </div>
          </div>

          
          <div class="col-md-2">
            <div class="col-md-12"><h3 class="footer-heading mb-4 text-white">Social Icons</h3></div>
              <div class="col-md-12">
                <p>
                  <a href="#" class="pb-2 pr-2 pl-0"><span class="icon-facebook"></span></a>
                  <a href="#" class="p-2"><span class="icon-twitter"></span></a>
                  <a href="#" class="p-2"><span class="icon-instagram"></span></a>
                  <a href="#" class="p-2"><span class="icon-vimeo"></span></a>

                </p>
              </div>
          </div>
        </div>
        <div class="row pt-5 mt-5 text-center">
          <div class="col-md-12">
            <p>
            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            Copyright &copy; <script>document.write(new Date().getFullYear());</script> All Rights Reserved | This template is made with <i class="icon-heart text-danger" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank" >Colorlib</a>
            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            </p>
          </div>
          
        </div>
      </div>
    </footer>
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
