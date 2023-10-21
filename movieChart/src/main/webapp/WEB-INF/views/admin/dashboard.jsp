<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta id="_csrf" name="_csrf" content="${_csrf.token}" />
<meta id="_csrf_header" name="_csrf_header"
	content="${_csrf.headerName}" />
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.0/dist/jquery.min.js"></script>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<script type="text/javascript">
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	$.ajaxSetup({
		beforeSend : function(xhr) {
			xhr.setRequestHeader(header, token);
		}
	});

	function crawlMovieInfo() {
		$.ajax({
			url : '/movie/crawling',
			type : 'POST',
			success : function(response) {
				alert("크롤링 성공! db에 " + response + "개 저장");
				crawlingInfo();
			},
			error : function(error) {
				console.error('크롤링 실패:', error);
				alert('크롤링 실패');
			}
		})
	}
	
	function crawlingInfo(){
		$.ajax({
			url : '/movie/crawlingInfo',
			type : 'GET',
			success : function(response) {
				data = JSON.parse(response); 
				$("#checkResult").html("마지막 크롤링 : "+data.maxDt+" 총 "+data.countMovie+"개 크롤링 됨.");
				console.log('크롤링 정보 조회 성공:', response);
			},
			error : function(error) {
				console.error('크롤링 실패:', error);
				$("#checkResult").html("크롤링 정보 조회 오류");
			}
		})
	}

	$(function() {
		crawlingInfo();
	});
</script>
</head>
<body>
	<h1>관리자 페이지</h1>
	<table>
		<tr>
			<td><input type="button" onclick="crawlMovieInfo()"
				value="크롤링하기"></td>
			<td><span id="checkResult" style="color: red;"></span></td>
		</tr>
	</table>
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
</body>
</html>