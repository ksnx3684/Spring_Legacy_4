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
	
	<h1> Notice List Page</h1>
	
	<h3>
	<table>
		<tr>
			<th>Title</th><th>Contents</th><th>Writer</th><th>RegDate</th><th>Hit</th><th><a href="./add">ADD</a></th>
		</tr>
		<c:forEach items="${list}" var="notice">
		<tr>
			<td><a href="./detail?num=${notice.num}">${notice.title}</a></td>
			<td>${notice.contents}</td>
			<td>${notice.writer}</td>
			<td>${notice.regDate}</td>
			<td>${notice.hit}</td>	
		</tr>
		</c:forEach>
	</table>
	</h3>
</body>
</html>