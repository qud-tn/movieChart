<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta id="_csrf" name="_csrf" content="${_csrf.token}"/>
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"/>
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.0/dist/jquery.min.js"></script>
<title>비밀번호 변경</title>
<script type="text/javascript">
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");

$.ajaxSetup({
    beforeSend: function(xhr) {
        xhr.setRequestHeader(header, token);
    }
});

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
});

function checkEmailandID() {
    var email = $("#email").val();
    var username = $("#username").val();

    $.ajax({
        url: '/user/checkingIDForPassword',
        type: 'GET',
        dataType : 'json',
        data: {
            email: email,
            username: username
        },
        success: function(response) {
            if (response) {
                $("#password").prop("disabled", false);
                $("#passwordchk").prop("disabled", false);
                $("#result").html("<input type='button' value='비밀번호 변경' onclick='updatePassword();'>");
            } else {
                $("#result").html("확인된 아이디가 없습니다");
            }
        },
        error: function(error) {
            console.error(error);
        }
    });
}
function updatePassword() {
	var password = $("#password").val();
    var passwordConfirm = $("#passwordchk").val();
    var username = $("#username").val();
    
    if (password.length < 8) {
        alert("비밀번호는 최소 8자리 이상이어야 합니다.");
        return;
    }
    
    if (password !== passwordConfirm) {
        alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
        return;
    }
    
    $.ajax({
        url: '/user/changingPassword', 
        type: 'PUT', 
        data: JSON.stringify({
            password: password,
            username: username
        }),
        contentType: 'application/json',
        success: function(response) {
			if(response){
				alert("비밀번호 변경 완료 다시 로그인 해보세요");
				// 부모 창을 다른 페이지로 이동시키기
				window.opener.location.href = "/main";
		        window.close();

			}
        },
        error: function(error) {
            console.error(error);
        }
    });
}
</script>
</head>
<body>
	<h1>비밀번호 변경</h1>
	<table>
		<tr>
			<td>아이디 :<input type="text" name="email" id="username">
			</td>
		</tr>
		<tr>
			<td>이메일 :<input type="text" name="email" id="email">
			</td>
		</tr>
	</table>
	<input type="button" value="확인" onclick="checkEmailandID();">
	<hr>
	<table>
		<tr>
			<td>비밀번호:</td>
			<td><input type="password" id="password" required="required" disabled="disabled"></td>
			<td><span id="checkPasswordLength" style="color: red;"></span></td>
		</tr>
		<tr>
			<td>비밀번호 확인:</td>
			<td><input type="password" name="password" id="passwordchk"
				required="required" disabled="disabled"></td>
			<td><span id="checkPasswordResult" style="color: red;"></span></td>
		</tr>
	</table>
	<div id="result"></div>
	<br>
	<input type="button" value="창닫기" onclick="window.close();">
</body>
</html>