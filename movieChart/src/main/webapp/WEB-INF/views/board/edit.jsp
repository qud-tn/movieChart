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
</head>
<body>
	<h1>글쓰기</h1>
	<form action="" method="post">
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
		</table>
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
		<input type="hidden" name="username" value='<sec:authentication property="principal.udto.username" />'>
		<input type="submit" value="글 수정하기">
	</form>
</body>
</html>