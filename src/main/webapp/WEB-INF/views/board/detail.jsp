<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
	<h1>${board} Detail Page</h1>
	
	<h2>NUM : ${dto.num}</h2>
	<h2>TITLE : ${dto.title}</h2>
	<h2>CONTENTS : ${dto.contents}</h2>
	<h2>WRITER : ${dto.writer}</h2>
	<h2>REGDATE : ${dto.regDate}</h2>
	<h2>HIT : ${dto.hit}</h2>
	
	<a href="./list">LIST</a>
	<a href="./update?num=${dto.num}">수정</a>
	<a href="./delete?num=${dto.num}">삭제</a>
	<c:if test="${board ne 'Notice'}">
		<a href="./reply?num=${dto.num}">Reply</a>
	</c:if>
	
</body>
</html>