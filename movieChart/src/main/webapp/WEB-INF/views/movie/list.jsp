<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.0/dist/jquery.min.js"></script>
<script type="text/javascript">
	
</script>
<title>영화 목록 <c:if test="${syntax ne null and syntax ne ''}">검색어 : ${syntax }</c:if></title>
</head>
<body>
	<h1>
		<a href="/main">영화 목록</a>
	</h1>
	<form action="">
		영화 검색:<input type="text" name="syntax" id="syntax" value="${syntax }"
			placeholder="제목, 감독, 제작년도, 시놉시스, 장르"> <input type="submit"
			value="영화 검색">
	</form>

	<table>
		<c:forEach items="${movieList}" var="list">
			<tr>
				<td colspan="3"><img src="${list.image }" width="30"
					height="50"></td>
			</tr>
			<tr>
				<td>제목 : <a href="/movie/${list.code_no }">${list.title }</a></td>
				<td>감독 : ${list.director }</td>
				<td>제작연도 : ${list.prod_year }</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<c:if test="${page.prev }">
			<a href="/movie/list?page=${page.startPage-1 }&syntax=${syntax } ">«</a>
		</c:if>
		<c:forEach begin="${page.startPage }" end="${page.endPage}" step="1"
			var="idx">

			<a href="/movie/list?page=${idx }&syntax=${syntax }">${idx }</a>

		</c:forEach>
		<c:if test="${page.next && page.endPage > 0 }">
			<a href="/movie/list?page=${page.endPage + 1}&syntax=${syntax }">»</a>
		</c:if>
	</div>
</body>
</html>