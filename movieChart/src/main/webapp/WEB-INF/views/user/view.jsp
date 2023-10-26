<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<html>
<head>
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.0/dist/jquery.min.js"></script>
<meta charset="UTF-8">
<title>마이페이지</title>
<script type="text/javascript">
	$(function() {
		function checkPasswordLength() {
			var password = $("#password").val();
			if (password.length < 8) {
				$("#checkPasswordLength").html("비밀번호는 8자리 이상이여야 합니다");
			} else {
				$("#checkPasswordLength").html("");
			}
		}

		$("#password").on("change", checkPasswordLength);

		function checkPassword() {
			var password = $("#password").val();
			var passwordchk = $("#passwordchk").val();

			if (password !== passwordchk) {
				$("#checkPasswordResult").html("비밀번호가 일치하지 않습니다.");
			} else {
				$("#checkPasswordResult").html("");
			}
		}

		$("#passwordchk").on("change", checkPassword);

		function checkNickname() {
			var nickname = document.getElementById("nickname").value;
			$.ajax({
				url : "/user/nickname/" + nickname,
				method : "GET",
				success : function(data) {
					if (data) {
						$("#checkNicknameResult").html("이미 사용 중인 닉네임 입니다 ");
					} else {
						$("#checkNicknameResult").html("사용하실 수 있는 닉네임 입니다 ");
					}
				},
				error : function(xhr, status, error) {
					console.error("AJAX 오류: " + status, error);
				}
			});
		}

		$("#nicknamechk").on("click", checkNickname);

		$("#submitForm").on("submit", checkform);

		function checkEmail() {
			var email = document.getElementById("email").value;
			$.ajax({
				url : "/user/email/" + email,
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

		function checkform(event) {
			var passwordchk = $("#checkPasswordResult").text();
		    var nicknamechk = $("#checkNicknameResult").text();
		    var emailchk = $("#checkEmailResult").text();

		    var passwordInput = $("#password");
		    var nicknameInput = $("#nickname");
		    var emailInput = $("#email");

		    if ((!nicknamechk.includes("하실") || (nicknameInput.val() === ""))
		    	&&passwordchk !== ""
		    	&&(!emailchk.includes("하실") || (emailInput.val() === ""))) {
		    	alert("비밀번호 확인 및 중복 체크 오류");
		    	event.preventDefault();
		  	}else if(nicknameInput.val() === "" && passwordInput.val() === "" && emailInput.val() === ""){
		  		alert("정보 변경 없음");
		    	event.preventDefault();
		  	}
		}

		$("#submitForm").on("submit", checkform);
	});
</script>
</head>
<body>
	<form action="" method="post" id="submitForm">
		<table>
			<tr>
				<td>아이디 : <sec:authentication
						property="principal.udto.username" /> <input type="hidden"
					name="username"
					value="<sec:authentication
						property="principal.udto.username" />">
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" id="password"></td>
				<td><span id="checkPasswordLength" style="color: red;"></span></td>
			</tr>
			<tr>
				<td>비밀번호 확인:</td>
				<td><input type="password" name="password" id="passwordchk"></td>
				<td><span id="checkPasswordResult" style="color: red;"></span></td>
			</tr>
			<tr>
				<td>닉네임:</td>
				<td><input type="text" name="nickname" id="nickname"> <input
					type="button" id="nicknamechk" value="닉네임 중복 조회"></td>
				<td><span id="checkNicknameResult" style="color: red;"></span></td>
			</tr>
			<tr>
				<td>이메일:</td>
				<td><input type="email" name="email" id="email"> <input
					type="button" id="emailchk" value="이메일 중복 조회"></td>
				<td><span id="checkEmailResult" style="color: red;"></span></td>
			</tr>
		</table>
		<input type="submit" value="정보 저장"> <input type="reset"
			value="취소하기"> <input type="hidden"
			name="${_csrf.parameterName }" value="${_csrf.token }"> <input
			type="button" value="뒤로가기" onclick="location.href='/main'">
	</form>
</body>
</html>