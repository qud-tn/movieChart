<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="" method="post">
	아이디:<input type="text" name="username"><br>
	비밀번호:<input type="password" name="password"><br>
<!-- 	비밀번호 확인:<input type="password" id="password"><br> -->
	닉네임:<input type="text" name="nickname"><br>
	email:<input type="email" name="email"><br>
	<input type="submit" value="회원가입">
	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
	</form>
	
	
</body>
</html>