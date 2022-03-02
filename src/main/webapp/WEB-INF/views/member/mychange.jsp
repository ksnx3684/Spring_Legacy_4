<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>my change</title>
<c:import url="../template/header_css.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<c:import url="../template/form_css.jsp"></c:import>
	
		<form class="frm" action="./mychange" method="POST">

	        <fieldset>
	        	<input type="hidden" name="id" readonly="readonly" value="${dto.id}">
	        	<input type="hidden" name="pw" readonly="readonly" value="${dto.pw}">
	        	<input type="hidden" name="name" readonly="readonly" value="${dto.name}">
	        	<legend>전화번호</legend>
	        	<input type="text" placeholder="전화번호" name="phone">
	        </fieldset>
	        <fieldset>
	        	<legend>이메일</legend>
	        	<input type="text" placeholder="이메일" name="email">
	        </fieldset>
	        <fieldset>
	        	<button type="submit">수정</button>
	        </fieldset>
        
    	</form>
	

</body>
</html>