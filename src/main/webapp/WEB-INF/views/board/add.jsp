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
	
	<h1>${board} Add Page</h1>
	
	<form action="./add" method="POST">
		제목<input type="text" placeholder="제목" name="title" id="title">
		작성자<input type="text" placeholder="작성자" name="writer" id="writer">
		내용<textarea rows="20" cols="40" name="contents" id="contents"></textarea>
		
		<button type="button" id="btn">작성</button>
	</form>
	
	<script type="text/javascript" src="../resources/js/addCheck.js"></script>
</body>
</html>