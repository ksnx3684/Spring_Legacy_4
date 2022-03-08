<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
<link rel="stylesheet" href="../resources/css/joinCheck.css">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

	<div class="rule-container">
		<div class="rule">
			전체동의<input type="checkbox" id="checkAll">
		</div>
		<div class="rule">
			<fieldset>
				<legend>동의1</legend>
					<input type="checkbox" class="check">
			</fieldset>
			<div></div>
		</div>
		<div class="rule">
			<fieldset>
				<legend>동의2</legend>
					<input type="checkbox" class="check">
			</fieldset>
			<div></div>
		</div>
		<div class="rule">
			<fieldset>
				<legend>동의3</legend>
					<input type="checkbox" class="check">
			</fieldset>
			<div></div>
		</div>
		<div class="rule">
			<fieldset>
				<legend>동의4</legend>
					<input type="checkbox" class="check">
			</fieldset>
			<div></div>
		</div>
		<div class="rule">
        	<button id="btn">JOIN</button> 
        	<!-- 동의가 다 눌러져있는 상태에서 join을 누르면 join 폼으로 이동, 아니면 경고창 -->
    	</div>
	</div>

    
	
	<script src="../resources/js/joinCheck.js"></script>
	
	
</body>
</html>