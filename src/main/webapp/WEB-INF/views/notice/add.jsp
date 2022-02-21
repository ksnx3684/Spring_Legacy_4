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
	
	<h1> Notice Add Page</h1>
	
	<form action="./add">
		제목<input type="text" placeholder="제목" name="title"><br>
		작성자<input type="text" placeholder="작성자" name="writer"><br>
		내용<textarea rows="20" cols="40" name="contents"></textarea><br>
	</form>
	<button type="submit">작성</button>
</body>
</html>