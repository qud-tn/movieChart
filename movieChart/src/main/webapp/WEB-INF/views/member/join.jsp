<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOcTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.0/dist/jquery.min.js"></script>
<title>회원가입</title>
<script type="text/javascript">
	$(function() {
		var password = $("#password").val();
		function checkPasswordLength() {
			if (password.length < 8) {
				$("#checkPasswordLength").html("비밀번호는 8자리 이상이여야 합니다");
			} else {
				$("#checkPasswordLength").html("");
			}
		}

		$("#password").on("input", checkPasswordLength);

		function checkPassword() {
			var passwordchk = $("#passwordchk").val();

			if (password !== passwordchk) {
				$("#checkPasswordResult").html("비밀번호가 일치하지 않습니다.");
			} else {
				$("#checkPasswordResult").html("");
			}
		}

		$("#passwordchk").on("change", checkPassword);

		function checkUsername() {
			var username = document.getElementById("username").value;
			$.ajax({
				url : "/member/username/" + username,
				method : "GET",
				success : function(data) {
					if (data) {
						$("#checkUsernameResult").html("이미 사용 중인 아이디 입니다");
					} else {
						$("#checkUsernameResult").html("사용하실 수 있는 아이디 입니다");
					}
				},
				error : function(xhr, status, error) {
					console.error("AJAX 오류: " + status, error);
				}
			});
		}

		$("#usernamechk").on("click", checkUsername);

		function checkNickname() {
			var nickname = document.getElementById("nickname").value;
			$.ajax({
				url : "/member/nickname/" + nickname,
				method : "GET",
				success : function(data) {
					if (data) {
						$("#checkNicknameResult").html(
								"이미 사용 중인 닉네임 입니다 닉네임은 추후에 바꿀 수 있습니다");
					} else {
						$("#checkNicknameResult").html(
								"사용하실 수 있는 닉네임 입니다 닉네임은 추후에 바꿀 수 있습니다");
					}
				},
				error : function(xhr, status, error) {
					console.error("AJAX 오류: " + status, error);
				}
			});
		}

		$("#nicknamechk").on("click", checkNickname);

		function checkform() {
			var passwordchk = document.getElementById("checkPasswordResult").innerText;
			var nicknamechk = document.getElementById("checkNicknameResult").innerText;
			var usernamechk = document.getElementById("checkUsernameResult").innerText;

			if (!nicknamechk.includes("하실") || !usernamechk.includes("하실")
					|| passwordchk !== "") {
				alert("비밀번호 확인 및 중복 체크 오류");
				event.preventDefault();
			}
		}

		$("#submitForm").on("submit", checkform);

		function checkEmail() {
			var email = document.getElementById("email").value;
			$.ajax({
				url : "/member/email/" + email,
				method : "GET",
				success : function(data) {
					if (data) {
						$("#checkEmailResult").html(
								"이미 등록된 이메일 입니다 사용하실 수 없습니다");
					} else {
						$("#checkEmailResult").html("등록하실 수 있는 이메일 입니다");
					}
				},
				error : function(xhr, status, error) {
					console.error("AJAX 오류: " + status, error);
				}
			});
		}

		$("#emailchk").on("click", checkEmail);

	});
</script>
</head>
<body>
	<h1>회원가입</h1>
	<form action="" method="post" id="submitForm">
		<table>
			<tr>
				<td>아이디:</td>
				<td><input type="text" name="username" id="username"
					required="required"> <input type="button" id="usernamechk"
					value="중복 조회"></td>
				<td><span id="checkUsernameResult" style="color: red;"></span></td>
			</tr>
			<tr>
				<td>비밀번호:</td>
				<td><input type="password" id="password" required="required"></td>
				<td><span id="checkPasswordLength" style="color: red;"></span></td>
			</tr>
			<tr>
				<td>비밀번호 확인:</td>
				<td><input type="password" name="password" id="passwordchk"
					required="required"></td>
				<td><span id="checkPasswordResult" style="color: red;"></span></td>
			</tr>
			<tr>
				<td>닉네임:</td>
				<td><input type="text" name="nickname" id="nickname"
					required="required"> <input type="button" id="nicknamechk"
					value="닉네임 중복 조회"></td>
				<td><span id="checkNicknameResult" style="color: red;"></span></td>
			</tr>
			<tr>
				<td>이메일:</td>
				<td><input type="email" name="email" required="required">
					<input type="button" id="emailchk" value="이메일 중복 조회"></td>
				<td><span id="checkEmailResult" style="color: red;"></span></td>
			</tr>
		</table>
		<input type="submit" value="회원가입"> <input type="hidden"
			name="${_csrf.parameterName }" value="${_csrf.token }">
	</form>


</body>
</html>