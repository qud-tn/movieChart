<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.0/dist/jquery.min.js"></script>
<title>회원가입</title>
<script type="text/javascript">
	$(function() {
		function checkPassword(){
			 var password = document.getElementById("password").value;
		     var passwordChk = document.getElementById("passwordChk").value;
		     var errorLabel = document.getElementById("passwordError");
		
		     if (password === passwordChk) {
		         // 비밀번호와 비밀번호 확인이 일치할 때
		         errorLabel.innerHTML = "";
		     } else {
		         // 비밀번호와 비밀번호 확인이 일치하지 않을 때
		         errorLabel.innerHTML = "비밀번호가 일치하지 않습니다.";
		     }
		}
		
		$("#passwordChk").on("input", checkPassword);
		
		function checkUsername() {
		    var username = document.getElementById("username").value;
		    $("#CheckUsernameResult").empty();
		    $.ajax({
		        url: "/member/" + username,
		        method: "GET",
		        success: function (data) {
		            if (data) {
		                $("#CheckUsernameResult").html("이미 사용 중인 아이디 입니다");
		            } else {
		                $("#CheckUsernameResult").html("사용하실 수 있는 아이디 입니다");
		            }
		        },
		        error: function (xhr, status, error) {
		            console.error("AJAX 오류: " + status, error);
		        }
		    });
		}
		
		$("#usernameChk").on("click", checkUsername);
	});
</script>
</head>
<body>
	<h1>회원가입</h1>
	<form action="" method="post">
		<table>
			<tr>
				<td>아이디:</td>
				<td><input type="text" name="username" id="username">
				<input type="button" id="usernameChk" value="중복 조회"> </td>
				<td><span id="CheckUsernameResult" style="color: red;"></span></td>
			</tr>
			<tr>
				<td>비밀번호:</td>
				<td><input type="password" id="password"></td>
			</tr>
			<tr>
				<td>비밀번호 확인:</td>
				<td><input type="password" name="password" id="passwordChk"></td>
				<td><span id="passwordError" style="color: red;"></span></td>
			</tr>
			<tr>
				<td>닉네임:</td>
				<td><input type="text" name="nickname"></td>
			</tr>
			<tr>
				<td>이메일:</td>
				<td><input type="email" name="email"></td>
			</tr>
		</table>
		<input type="submit" value="회원가입"> <input type="hidden"
			name="${_csrf.parameterName }" value="${_csrf.token }">
	</form>


</body>
</html>