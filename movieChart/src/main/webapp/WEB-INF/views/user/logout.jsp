<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>
	<script type="text/javascript">
	window.onload = function() {
	    var urlParams = new URLSearchParams(window.location.search);
	    var message = urlParams.get('message');
	    if (message === 'updateInfoOk') {
	        document.getElementById("logoutForm").submit();
	    }
	    if (message === 'passwordChanged') {
	        document.getElementById("logoutForm").submit();
	    }
	}
	</script>
	<h1>로그아웃</h1>
	<form id="logoutForm" action="/user/logout" method="post">
		<input type="hidden" name="${_csrf.parameterName }"value="${_csrf.token }"> 
		<input type="submit" value="로그아웃"><br>
	</form>
	<input type="button" value="메인으로" onclick="location.href='/main';">
</body>
</html>