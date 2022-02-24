<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
<c:import url="../template/detail_css.jsp"></c:import>
</head>
<body>

	<c:import url="../template/header.jsp"></c:import>
	
	<div class="title">
		<h1>Bankbook List Page</h1>
		<div class="contents">
			<table border ="1" width="100%" height=100 bgcolor=#55a5eb bordercolor="white" cellspacing="5">
				<tr align="center" bgcolor="white">
					<th>상품명</th><th>이자율</th><th>판매</th>
				</tr>
				<c:forEach items="${list}" var="book">
				<tr align="center" bgcolor="white">
					<td><a href="./detail?bookNumber=${book.bookNumber}">${book.bookName}</a></td>
					<td>${book.bookRate}</td>
					<td>${book.bookSale}</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<a href="./add">ADD</a>
	</div>
	
</body>
</html>