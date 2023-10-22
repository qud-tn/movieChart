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
	src="https://cdn.jsdelivr.net/npage/jquery@3.7.0/dist/jquery.min.js"></script>
<title>자유게시판</title>
</head>
<body>
	<h1><a href="/main">자유게시판</a></h1>
	<form action="">
		게시물 검색:<input type="text" name="syntax" id="syntax" placeholder="내용, 제목">
		<br>
		유저 검색:<input type="text" name="nickname" placeholder="닉네임">
		<br>
		카테고리 구분:<select name="category">
							<option></option>
							<option>공지사항</option>
							<option>이벤트</option>
							<option>잡담</option>
							<option>리뷰/감상문</option>
							<option>질문</option>
				</select>
		<input type="submit" value="게시물 검색">
	</form>
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
					<td>${boardlist.view_cnt }</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	
				<div>
						<c:if test="${page.prev }">						
							<li><a href="/board/list?page=${page.startPage-1 }">«</a></li>
						</c:if>
						<c:forEach begin="${page.startPage }" end="${page.endPage}" step="1" var="idx">						
							
								<a href="/board/list?page=${idx }">${idx }</a>
							
						</c:forEach>
						<c:if test="${page.next && page.endPage > 0 }">
							<li><a href="/board/list?page=${page.endPage + 1}">»</a></li>
						</c:if>
				</div>
	
	<sec:authorize access="isAuthenticated()">
		<a href="/board/write">글쓰기</a>
	</sec:authorize>
</body>
</html>