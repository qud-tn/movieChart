<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta id="_csrf" name="_csrf" content="${_csrf.token}"/>
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"/>
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.0/dist/jquery.min.js"></script>
<title>비밀번호 확인</title>
<script type="text/javascript">
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");

$.ajaxSetup({
    beforeSend: function(xhr) {
        xhr.setRequestHeader(header, token);
    }
});

function checkPassword() {
	var password= $("#password").val();
	var username='${pageContext.request.userPrincipal.name}';
	$.ajax({
		url : '/user/checkingPassword',
		type : 'GET',
		data : {
			password : password,
			username : username
		},
		success : function(response) {
			if(response){
				location.href="/user/info";				
			}else{
				alert("비밀번호가 틀립니다");				
			}
		},
		error : function(error) {
			alert("비밀번호 체크 오류");
		}
	});
}
</script>
</head>
<body>
	<h1>비밀번호 확인</h1>
	<input type="password" name="password" id="password">
	<input type="button" onclick="checkPassword()" value="비밀번호 확인">
</body>
</html>