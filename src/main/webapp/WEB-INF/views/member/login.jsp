<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
<c:import url="../template/header_css.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<c:import url="../template/form_css.jsp"></c:import>
	
	<form class="frm" action="./login" method="post">

        <fieldset>
            <legend>ID</legend>
            <input type="text" placeholder="ID" name="id" value="${cookie.remember.value}">
        </fieldset>
        <fieldset>
            <legend>PW</legend>
            <input type="password" placeholder="PW" name="pw">
        </fieldset>
        <fieldset>
        	<legend>Remember me</legend>
        	<input type="checkbox" name="remember" value="1">
        </fieldset>
        <fieldset>
            <button type="sumbit">로그인</button>
        </fieldset>
        
	</form>

</body>
</html>