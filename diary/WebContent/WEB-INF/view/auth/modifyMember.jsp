<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modifyMember</title>
</head>
<body>
	<h1>modifyMember</h1>
	<form method="post" action="${pageContext.request.contextPath}/auth/modifyMember">
		<div>
			<input type="password" name="memberPw">
		</div>
		<div>
			<button type="submit">비밀번호 수정</button>
		</div>
	</form>
</body>
</html>