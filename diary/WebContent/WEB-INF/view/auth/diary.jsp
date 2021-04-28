<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>diary</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="${pageContext.request.contextPath}/assets/img/favicon.png" rel="icon">
  <link href="${pageContext.request.contextPath}/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="${pageContext.request.contextPath}/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/assets/vendor/icofont/icofont.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/assets/vendor/venobox/venobox.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/assets/vendor/aos/aos.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet">
</head>
<body>
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
	
	<!-- dday 코드 추가 -->
	<h1>DDAY List</h1>
	<div>
		<table border="1">
			<tr><th>todoDate</th><th>todoTitle</th><th>dday</th></tr>
			<c:forEach var="m" items="${diaryMap.ddayList}">
				<tr>
					<td>${m.todoDate}</td>
					<td><a href="${pageContext.request.contextPath}/auth/todoOne?todoNo=${m.todoNo}">${m.todoTitle}</a></td>
					<td>-${m.dday}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<!-- dday 코드 끝 -->

	<a href="${pageContext.request.contextPath}/login">Home</a>
	
	<c:set var="totalCell" value="${diaryMap.startBlank + diaryMap.endDay + diaryMap.endBlank}"></c:set>
	<div>totalCell: ${totalCell}</div>
		
	<h1>
		<a href="${pageContext.request.contextPath}/auth/diary?targetYear=${diaryMap.targetYear}&targetMonth=${diaryMap.targetMonth-1}">이전달</a>
		${diaryMap.targetYear}년 ${diaryMap.targetMonth +1}월
		<a href="${pageContext.request.contextPath}/auth/diary?targetYear=${diaryMap.targetYear}&targetMonth=${diaryMap.targetMonth+1}">다음달</a>
	</h1>
	<table border="1" width="90%">
		<tr>
			<c:forEach var="i" begin="1" end="${totalCell}" step="1">
				<c:set var="num" value="${i-diaryMap.startBlank}"></c:set>
				<td>
					<c:if test="${num > 0 && num <= diaryMap.endDay}">
						<a href="${pageContext.request.contextPath}/auth/addTodo?year=${diaryMap.targetYear}&month=${diaryMap.targetMonth +1}&day=${num}">
							${num}
							<div>
								<c:forEach var="todo" items="${diaryMap.todoList}">
									<c:if test="${todo.todoDate == num}">
										<div style="background-color:${todo.todoFontColor}">
											<a href="${pageContext.request.contextPath}/auth/todoOne?todoNo=${todo.todoNo}">${todo.todoTitle}...</a>
											<!--  todoOne 상세정보 - 수정 - 삭제 -->
										</div>
									</c:if>
								</c:forEach>
							</div>
						</a>
					</c:if>
					<c:if test="${num <= 0 || num > diaryMap.endDay}">
						&nbsp;
					</c:if>
				</td>
				
				<c:if test="${i%7 == 0}">
					</tr><tr>
				</c:if>
			</c:forEach>
		</tr>
	</table>
</body>
</html>