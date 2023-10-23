<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.0/dist/jquery.min.js"></script>
<title>로그인</title>
</head>
<body>
<h1>로그인</h1>
<form action="/login" method="post">
아이디 : <input type="text" name="username"><br>
비밀번호 : <input type="password" name="password"><br>
<input type="submit" value="로그인"><br>
<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
</form>
<input type="button" value="id 찾기/비밀번호 변경" onclick="location.href='/user/helpLogin'"><br>
<input type="button" value="회원가입" onclick="location.href='/user/join';"><br>
<input type="button" value="메인으로" onclick="location.href='/main';"><br>
</body>
</html>