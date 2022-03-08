<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Header 시작 -->
<header class="header">
	<nav class="nav_menu">
		<ul>
			<li><a href="/s1/">HOME</a></li>
			<li><a href="/s1/bankbook/list">Product</a></li>
			<li><a href="/s1/qna/list">Q&A</a></li>
			<li><a href="/s1/notice/list">공지사항</a></li>
		</ul>	
	</nav>
	<nav class="nav_login">
		<ul>
			<c:choose>
				<c:when test="${not empty member}">
					<li><a href="/s1/member/mypage"><span class="material-icons">account_circle</span></a></li>
					<li><a href="/s1/member/logout"><span class="material-icons">logout</span></a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/s1/member/login"><span class="material-icons">login</span></a></li>
					<li><a href="/s1/member/joinCheck"><span class="material-icons">person_add</span></a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</nav>
</header>
<!-- Header 끝 -->