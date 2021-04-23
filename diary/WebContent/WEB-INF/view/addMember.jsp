<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addMember</title>
</head>
<body>
	<h1>addMember</h1>
	<form method="post" action="${pageContext.request.contextPath}/addMember">
		<div>memberId: <input type="text" name="memberId"></div>
		<div>memberPw: <input type="password" name="memberPw"></div>
		<div><button type="submit">회원가입</button></div>
	</form>
</body>
</html>