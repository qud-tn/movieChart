<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<td>
	<input type="text" name="title" placeholder="제목을 입력하세요"><br>
	</td>
	</tr>
	<tr>
	<td>
	<textarea rows="10" cols="50" name="content"></textarea><br>
	</td>
	</tr>
	</table>
	<input type="submit" value="글쓰기">
	</form>
</body>
</html>