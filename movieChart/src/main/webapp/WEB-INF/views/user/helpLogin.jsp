<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기 /비밀번호 변경</title>
<script type="text/javascript">
	function openFindId() {
			// 새 창을 열기 위한 URL
			var popupUrl = '/user/findID';
			// 새 창 열기
			window.open(popupUrl, '_blank',
					'width=500,height=600,resizable=yes');
	}
	function openChangePassword() {
			var popupUrl = '/user/changePassword';
			window.open(popupUrl, '_blank',
					'width=500,height=600,resizable=yes');
	}
</script>
</head>
<body>
	<h1>아이디 찾기/ 비밀번호 변경</h1>
	<h3>
		<a href="javascript:void(0);"  onclick="openFindId()">아이디 찾기</a>
	</h3>
	<h3>
		<a href="javascript:void(0);"  onclick="openChangePassword()">비밀번호 변경</a>
	</h3>
</body>
</html>