<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.0/dist/jquery.min.js"></script>
<title>글쓰기</title>
<script type="text/javascript">

</script>
</head>
<body>
	<h1>글쓰기</h1>
	<form action="" method="post">
		<table>
			<tr>
				<td><input type="text" name="title" id="title"
					value=${boardContent.title } placeholder="제목을 입력하세요"><br>
				</td>
				<td><select name="category" id="category">
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<option ${boardContent.category == '공지사항' ? 'selected' : ''}>공지사항</option>
							<option ${boardContent.category == '이벤트' ? 'selected' : ''}>이벤트</option>
						</sec:authorize>
						<option ${boardContent.category == '잡담' ? 'selected' : ''}>잡담</option>
						<option ${boardContent.category == '리뷰/감상문' ? 'selected' : ''}>리뷰/감상문</option>
						<option ${boardContent.category == '질문' ? 'selected' : ''}>질문</option>
				</select></td>
			</tr>
			<tr>
				<td><textarea rows="10" cols="50" name="content" id="content">${boardContent.content }</textarea><br>
				</td>
			</tr>
		</table>
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
		<input type="hidden" name="username" value='<sec:authentication property="principal.udto.username" />'>
		<input type="submit" value="글 수정하기">
		<input type="button" value="취소하기" onclick="location.href='/board/${boardContent.board_id}';">
	</form>
</body>
</html>