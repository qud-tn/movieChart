<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<script type="text/javascript">

	function checkFiles(data) {
		var files = data.files;
		var arrayExt = [ ".gif", ".jpg", ".png" ];
		var maxSize = 10 * 1024 * 1024; // 10MB

		for (var i = 0; i < files.length; i++) {
			var file = files[i];
			var fileSize = file.size;
			var fileName = file.name;
			var fileExt = fileName.substring(fileName.lastIndexOf('.'))
					.toLowerCase();

			if (fileSize > maxSize) {
				alert('파일 크기가 10MB를 초과합니다: ' + fileName);
				file.value = '';
				return false;
			}

			var isAllowedExtension = false;
			for (var j = 0; j < arrayExt.length; j++) {
				if (fileExt === arrayExt[j]) {
					isAllowedExtension = true;
					break;
				}
			}

			if (!isAllowedExtension) {
				alert('허용되지 않는 확장자입니다: ' + fileName);
				file.value = '';
				return false;
			}
		}
		return true;
	}
</script>
</head>
<body>
	<h1>글쓰기</h1>
	<form action="" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td><input type="text" name="title" placeholder="제목을 입력하세요"><br>
				</td>
				<td><select name="category">
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<option>공지사항</option>
							<option>이벤트</option>
						</sec:authorize>
							<option>잡담</option>
							<option>리뷰/감상문</option>
							<option>질문</option>
				</select></td>
			</tr>
			<tr>
				<td><textarea rows="10" cols="50" name="content"></textarea><br>
				</td>
			</tr>
			<tr>
				<td><input type="file" name="file" multiple="multiple" onchange="checkFiles(this)" 
				accept='image/jpeg,image/gif,image/png'>
			</tr>
		</table>
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
		<input type="hidden" name="username" value='<sec:authentication property="principal.udto.username" />'>
		<input type="submit" value="글쓰기">
		<input type="button" value="취소하기" onclick="href='/board/list'">
	</form>
</body>
</html>