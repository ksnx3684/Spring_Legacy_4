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
	
	<h1>Bankbook Add Page</h1>
	
	<form action="./add" method="POST">
		이름<input type="text" placeholder="이름" name="bookName">
		내용<textarea name="bookContents" rows="10" cols="10"></textarea>
		이자율<input type="text" placeholder="이자율" name="bookRate">
		<div>
			판매<input type="radio" name="bookSale" value="1">
			판매중지<input type="radio" name="bookSale" value="0">
		</div>
				
		<button type="submit">입력</button>
	</form>
</body>
</html>