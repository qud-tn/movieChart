<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<html>
<head>
	<title>무비차트</title>
	<script>
	 // 오늘 날짜를 가져와서 yyyy-MM-dd 형식으로 변환
    var today = new Date();
	var yyyy = today.getFullYear();
    var mm = String(today.getMonth() + 1).padStart(2, '0'); // 0부터 시작하므로 +1 필요
    var dd = String(today.getDate()).padStart(2, '0');
    var formattedDate = yyyy + '-' + mm + '-' + dd;

    if(document.getElementById("todayDate").value){
    document.getElementById("todayDate").value = formattedDate;
    }
</script>
</head>
<body>
<h1>
	무비차트  
</h1>
<div>
<sec:authorize access="isAuthenticated()">
<sec:authentication property="principal.udto.nickname"/>
(<sec:authentication property="principal.udto.username"/>)
 님 환영합니다.<br>
<input type="button" value="로그아웃" onclick=""><br>
</sec:authorize>
<sec:authorize access="isAnonymous()">
<input type="button" value="회원가입" onclick="location.href='/join'"><br>
<input type="button" value="로그인" onclick="location.href='/login'"><br>
</sec:authorize>
</div>
<div>
${dailyBoxOffice }
<form action="" method="post">
<input type="date" name="targetDt" id="todayDate">
<select name="multiMovieYn">
	<option value="">전체</option>
	<option value="Y">다양성 영화</option>
	<option value="N">상업 영화</option>
</select> 
<select name="repNationCd">
	<option value="">전체</option>
	<option value="K">한국 영화</option>
	<option value="F">외국 영화</option>
</select> 
</form>
</div>
</body>
</html>
