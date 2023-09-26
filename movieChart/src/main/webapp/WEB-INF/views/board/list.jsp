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
<title>자유게시판</title>
</head>
<body>
	<h1>자유게시판</h1>
	<table border="1">
		<thead>
			<tr>
				<td>#</td>
				<td>카테고리</td>
				<td>제목</td>
				<td>글쓴이</td>
				<td>날짜</td>
				<td>조회수</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="boardlist" items="${boardList}">
				<tr>
					<td>${boardlist.board_id }</td>
					<td>${boardlist.category }</td>
					<td><a href="${boardlist.board_id}">${boardlist.title }</a></td>
					<td>${boardlist.nickname }</td>
					<td>${boardlist.write_date }</td>
					<td>${boardlist.write_date }</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<sec:authorize access="isAuthenticated()">
		<a href="/board/write">글쓰기</a>
	</sec:authorize>
</body>
</html>