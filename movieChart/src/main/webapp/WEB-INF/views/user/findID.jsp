<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.0/dist/jquery.min.js"></script>
<title>아이디 찾기</title>
<script type="text/javascript">
	function checkEmail() {
		var email=$("#email").val();
		
		$.ajax({
			url : '/user/checkingEmail',
			type : 'GET',
			data : {
				email: email
			},
			success : function(response) {
				if(response){
					$("#result").html("아이디는 "+response+" 입니다");
				}else{
					$("#result").html("확인된 아이디가 없습니다");
				}
			},
			error : function(error) {
				console.error(error);
			}
		});
	}
</script>
</head>
<body>
	<h1>아이디 찾기</h1>
	이메일 : <input type="text" name="email" id="email"><br> 
	<input type="button" value="이메일로 찾기" onclick="checkEmail();">
	<hr>
	<div id="result"></div><br>
	<input type="button" value="창닫기" onclick="window.close();">
</body>
</html>