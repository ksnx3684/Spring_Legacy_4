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
	
	<h1> Notice List Page</h1>
	<div>
		<form action="./list" method=get>
			<fieldset>
				<select name="kind">
					<option value="col1">제목</option>
					<option value="col2">내용</option>
					<option value="col3">작성자</option>
				</select>
				<input type="text" name="search" value="${page.search}">
				<button type="submit">검색</button>
			</fieldset>
		</form>
	</div>
	
	<table class="table-basic">
		<tr>
			<th>Num</th><th>Title</th><th>Contents</th><th>Writer</th><th>RegDate</th><th>Hit</th><th><a href="./add">ADD</a></th>
		</tr>
		<c:forEach items="${list}" var="notice">
		<tr>
			<td>${notice.num}</td>
			<td><a href="./detail?num=${notice.num}">${notice.title}</a></td>
			<td>${notice.contents}</td>
			<td>${notice.writer}</td>
			<td>${notice.regDate}</td>
			<td>${notice.hit}</td>	
		</tr>
		</c:forEach>
		
		<div>
			<c:if test="${pager.pre}">
				<a href="./list?page=${pager.startNum - 1}&kind=${pager.kind}&search=${pager.search}">PREV</a>
			</c:if>
			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
				<a href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a>
			</c:forEach>
			<c:if test="${pager.next}">
				<a href="./list?page=${pager.lastNum + 1}&kind=${pager.kind}&search=${pager.search}">NEXT</a>
			</c:if>
		</div>
	</table>
	<div>
		<c:if test="${pager.pre}">
			<a href="./list?page=${pager.startNum - 1}">PREV</a>
		</c:if>
		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			<a href="./list?page=${i}">${i}</a>
		</c:forEach>
		<c:if test="${pager.next}">
			<a href="./list?page=${pager.lastNum + 1}">NEXT</a>
		</c:if>
	</div>
</body>
</html>