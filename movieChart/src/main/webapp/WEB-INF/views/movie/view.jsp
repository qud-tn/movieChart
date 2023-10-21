<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<h1><a href="/main">${movie.title }</a></h1>
	<tr>
		<td colspan="3"><img src="${movie.image }">
		</td>
	</tr>
	<tr>
		<td>제목 : ${movie.title }</td>
		<td>감독 : ${movie.director }</td>
		<td>제작연도 : ${movie.prod_year }</td>
	</tr>
	<tr>
		<td colspan="3"><fieldset>
		<legend>시놉시스</legend>
		${movie.synopsis }
		</fieldset>
		</td>
	</tr>
</table>
</body>
</html>