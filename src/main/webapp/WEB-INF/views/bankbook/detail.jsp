<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
<c:import url="../template/detail_css.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>

	<div class="title">
		<h1>Bankbook Detail Page</h1>
		<div class="contents">
			<table border ="1" width="100%" height=100 bgcolor=#55a5eb bordercolor="white" cellspacing="5">
                <tr align="center" bgcolor="white">
                    <td>Name</td>
                    <td>Contents</td>
                    <td>Rate</td>
                </tr>
               		<tr align="center" bgcolor="white">
						<td>${dto.bookName}</td>
                		<td>${dto.bookContents}</td>
                		<td>${dto.bookRate}</td>
					</tr>
			</table>
		</div>
		<div class="menu">
			<a href="./list">LIST</a>
			<a href="./update?bookNumber=${dto.bookNumber}">Update</a>
			<a href="./delete?bookNumber=${dto.bookNumber}">DELETE</a>
		</div>
	</div>
</body>
</html>