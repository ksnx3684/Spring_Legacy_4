<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
	<c:import url="./template/header_css.jsp"></c:import>
	
</head>
<body>

	<c:import url="./template/header.jsp"></c:import>
	<div>
		<img alt="" src="./resources/images/kellen-riggin-K3iBw8t3JFU-unsplash.jpg">
	</div>
	
	<h1>Index Page</h1>
	<h3><span class="material-icons">login</span></h3>
	<c:if test="${not empty member}">
		<h3>${member.name} 님 환영합니다
		</h3>
	</c:if>
	
	<div>
		<c:if test="${not empty member}">
			<a href="./member/mypage">MyPage</a>
			<a href="./member/logout">Logout</a>
		</c:if>
		<c:if test="${empty member}">
			<a href="./member/login">Login</a>
			<a href="./member/join">Join</a>
		</c:if>
		
	</div>
	<img alt="" src="./resources/upload/member/5d6e4679-5eec-4bbe-9d5a-65c87c093821_bom.png">

</body>
</html>