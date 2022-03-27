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
	
	<h1>${board} Update Page</h1>
	
	<form action="./update" method="POST">
		<input type="hidden" name="num" readonly="readonly" value="${dto.num}">
		제목<input type="text" placeholder="제목" name="title" value="${dto.title}">
		작성자<input type="text" name="writer" readonly="readonly" value="${dto.writer}" disabled>
		내용<textarea rows="20" cols="40" name="contents">${dto.contents}</textarea>
		<input type="hidden" name="regDate" value="${dto.regDate}">
		<input type="hidden" name="hit" value="${dto.hit}">
		
		<div id="files">
			<c:forEach items="${dto.fileDTOs}" var="f">
				<div>
					${f.oriName}<button type="button" data-fileNum="${f.fileNum}" class="fileDeleteBtn">X</button>
				</div>
			</c:forEach>
		</div>
		
		<div id="fileResult">
			
		</div>

		<div>
			<button type="button" id="fileAdd">FileAdd</button>
		</div>
		
		
		<button type="submit">작성</button>
	</form>
	<script type="text/javascript" src="../resources/js/file.js"></script>
</body>
</html>