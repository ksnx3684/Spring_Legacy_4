<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>
</head>
<body>

	<h1>아이디 : ${dto.id}</h1>
	<h1>이름 : ${dto.name}</h1>
	<h1>전화번호 ${dto.phone}</h1>
	<h1>이메일 : ${dto.email}</h1>
	<a href="./mychange">개인정보 수정</a>

</body>
</html>