<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Index</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/icofont/icofont.min.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/venobox/venobox.css" rel="stylesheet">
  <link href="assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">
</head>
<body>
	<!-- 로그인 전 -->
	<c:if test="${sessionMember == null}">
		<h1>login</h1>
		<form method="post" action="${pageContext.request.contextPath}/login">
			<div>
				<div>ID: </div>
				<div><input type="text" name="memberId" value="goodee@gdu.co.kr"></div>
				<div>PW: </div>
				<div><input type="password" name="memberPw" value="1234"></div>
				<div>
					<button type="submit">로그인</button>
					<a href="${pageContext.request.contextPath}/addMember">회원가입</a>
				</div>
			</div>
		</form>
	</c:if>
	<!-- 로그인 후 -->
	<c:if test="${sessionMember != null}">
		<!-- ======= Mobile nav toggle button ======= -->
		<button type="button" class="mobile-nav-toggle d-xl-none"><i class="icofont-navigation-menu"></i></button>
		
		<!-- ======= Header ======= -->
		<header id="header">
		  <div class="d-flex flex-column">
		
		    <div class="profile">
		      <img src="assets/img/profile-img.jpg" alt="" class="img-fluid rounded-circle">
		      <h1 class="text-light"><a href="index.html">Seohee Kim</a></h1>
		      <div class="social-links mt-3 text-center">
		        <a href="#" class="twitter"><i class="bx bxl-twitter"></i></a>
		        <a href="#" class="facebook"><i class="bx bxl-facebook"></i></a>
		        <a href="#" class="instagram"><i class="bx bxl-instagram"></i></a>
		        <a href="#" class="google-plus"><i class="bx bxl-skype"></i></a>
		        <a href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
		      </div>
		    </div>
		
		    <nav class="nav-menu">
		      <ul>
		        <li class="active"><a href="${pageContext.request.contextPath}/login"><i class="bx bx-home"></i> <span>Home</span></a></li>
		        <li><a href="${pageContext.request.contextPath}/auth/diary"><i class="bx bx-user"></i> <span>diary</span></a></li>
		        <li><a href="#resume"><i class="bx bx-file-blank"></i> <span>Resume</span></a></li>
		        <li><a href="#portfolio"><i class="bx bx-book-content"></i> Portfolio</a></li>
		        <li><a href="#services"><i class="bx bx-server"></i> Services</a></li>
		        <li><a href="#contact"><i class="bx bx-envelope"></i> Contact</a></li>
		
		      </ul>
		    </nav><!-- .nav-menu -->
		    <button type="button" class="mobile-nav-toggle d-xl-none"><i class="icofont-navigation-menu"></i></button>
		
		  </div>
		</header><!-- End Header -->
		
		<div>${sessionMember.memberId} 님 반갑습니다.</div>
		<div>
			<a href="${pageContext.request.contextPath}/auth/logout">로그아웃</a>
			<a href="${pageContext.request.contextPath}/auth/modifyMember">회원정보수정</a>
			<a href="${pageContext.request.contextPath}/auth/removeMember">회원탈퇴</a>
		</div>
	</c:if>
</body>
</html>