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
	
	<h1>${board} Detail Page</h1>
	
	<h2>NUM : ${dto.num}</h2>
	<h2>TITLE : ${dto.title}</h2>
	<h2>CONTENTS : ${dto.contents}</h2>
	<h2>WRITER : ${dto.writer}</h2>
	<h2>REGDATE : ${dto.regDate}</h2>
	<h2>HIT : ${dto.hit}</h2>
	<div>
		<c:forEach items="${dto.fileDTOs}" var="f"> <!-- 파일 미리보기 -->
			<a href="../resources/upload/${board}/${f.fileName}">${f.oriName}</a>
		</c:forEach>
	</div>
	<div>
		<c:forEach items="${dto.fileDTOs}" var="f"> <!-- 파일 다운로드 -->
			<a href="./photoDown?fileNum=${f.fileNum}">${f.oriName}</a>
		</c:forEach>
	</div>
	<a href="./list">LIST</a>
	<c:if test="${member.id eq dto.writer}">
		<a href="./update?num=${dto.num}">수정</a>
		<a href="./delete?num=${dto.num}">삭제</a>
	</c:if>
	<c:if test="${board ne 'notice'}">
		<a href="./reply?num=${dto.num}">Reply</a>
	</c:if>
	
</body>
</html>