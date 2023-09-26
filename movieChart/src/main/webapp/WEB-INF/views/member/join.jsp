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
		function passwordChk(){
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
		
		$("#passwordChk").on("input", passwordChk);
	});
</script>
</head>
<body>
	<h1>회원가입</h1>
	<form action="" method="post">
		<table>
			<tr>
				<td>아이디:</td>
				<td><input type="text" name="username"></td>
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