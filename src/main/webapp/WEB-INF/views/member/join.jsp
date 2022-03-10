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
	
	<form class="frm" action="./join" method="post" id="frm" enctype="multipart/form-data">

        <fieldset>
            <legend>ID</legend>
            <input type="text" placeholder="ID" name="id" id="id">
            <div id="idResult"></div>
        </fieldset>
        <fieldset>
            <legend>PW</legend>
            <input type="password" placeholder="PW : 8글자 이상 12글자 이하" name="pw" id="pw">
            <div id=pwResult></div>
        </fieldset>
        <fieldset>
            <legend>PW 확인</legend>
            <input type="password" placeholder="PW : 8글자 이상 12글자 이하" name="pw2" id="pw2">
            <div id="pwResultCheck"></div>
        </fieldset>
        <fieldset>
        	<legend>이름</legend>
        	<input type="text" placeholder="이름" name="name" id="name">
        </fieldset>
        <fieldset>
        	<legend>전화번호</legend>
        	<input type="text" placeholder="전화번호" name="phone" id="phone">
        </fieldset>
        <fieldset>
        	<legend>이메일</legend>
        	<input type="text" placeholder="이메일" name="email" id="email">
        </fieldset>
        <fieldset>
        	<legend>사진(최대 10MB)</legend>
        	<input type="file" name="photo" id="photo">
        </fieldset>
        <fieldset>
        	<button type="submit" id="btn">JOIN</button>
        	<!-- <button type="button" id="btn">JOIN</button> -->
        </fieldset>
        
    </form>
    
    <!-- <script type="text/javascript" src="../resources/js/join2.js"></script> -->
    
</body>
</html>