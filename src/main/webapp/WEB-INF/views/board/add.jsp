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
	
	<form class="frm" action="./add" method="POST" id="frm" enctype="multipart/form-data">
		제목<input type="text" placeholder="제목" name="title" id="title">
		작성자<input type="text" name="writer" id="writer" readonly="readonly" value="${member.id}">
		내용<textarea rows="20" cols="40" name="contents" id="contents"></textarea>
		
		<div id="fileresult">
			
			<!-- <div>
				<input type="file" name="files"><button type="button">DEL</button>
			</div>

			<input type="file" name="files">
			<input type="file" name="files"> -->
		</div>

		<div>
			<button type="button" id="fileAdd">FileAdd</button>
			<button type="button" class="del">Sample DEL</button>
		</div>
		
		<button type="button" id="btn">작성</button>
	</form>
	
	<script src="../resources/js/addCheck.js"></script>
	<script src="../resources/js/file.js"></script>
	
</body>
</html>