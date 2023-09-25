<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
			<tr>
				<td>
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
</body>
</html>