<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무비차트:${boardContent.category}-${boardContent.title }</title>
</head>
<body>
	<table border="1">
		<thead>
		<sec:authorize access="isAuthenticated() && authentication.principal.username == '${boardContent.username}'">
		<tr>
			<td>글 수정</td>
			<td>글 삭제</td>
		</tr>
		</sec:authorize>
		</thead>
		<tbody>
		<tr>
			<td>${boardContent.title }</td>
		</tr>
		<tr>
			<td>${boardContent.category }</td>
		</tr>
		<tr>
			<td>${boardContent.content }</td>
		</tr>
		</tbody>
		<tfoot>
		<c:forEach var="board" items="${boardAround}" varStatus="loopStatus">
				<tr>
			<c:if test="${loopStatus.index == 0}">
					<td>이전글</td>
			</c:if>
			<c:if test="${loopStatus.index == 1}">
					<td>다음글</td>
			</c:if>					
					<td>${board.category}</td>
					<td><a href="${board.board_id}">${board.title}</a></td>
					<td>${board.nickname}</td>
					<td>${board.write_date}</td>
					<td>${board.write_date}</td>
				</tr>
		</c:forEach>
		</tfoot>
	</table>
</body>
</html>