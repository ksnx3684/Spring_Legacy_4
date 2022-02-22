<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JOIN</title>
<c:import url="../template/header_css.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<c:import url="../template/form_css.jsp"></c:import>
	
	<form class="frm" action="./join" method="post">

        <fieldset>
            <legend>ID</legend>
            <input type="text" placeholder="ID" name="id">
        </fieldset>
        <fieldset>
            <legend>PW</legend>
            <input type="password" placeholder="PW" name="pw">
        </fieldset>
        <fieldset>
        	<legend>이름</legend>
        	<input type="text" placeholder="이름" name="name">
        </fieldset>
        <fieldset>
        	<legend>전화번호</legend>
        	<input type="text" placeholder="전화번호" name="phone">
        </fieldset>
        <fieldset>
        	<legend>이메일</legend>
        	<input type="text" placeholder="이메일" name="email">
        </fieldset>
        <fieldset>
        	<button type="submit">JOIN</button>
        </fieldset>
        
    </form>
    
</body>
</html>