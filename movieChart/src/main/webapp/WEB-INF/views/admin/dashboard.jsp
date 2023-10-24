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
				alert("개발 환경에서는 잘 되었는데 배포 후 이상이 있습니다. 수정 중입니다.");
			}
		});
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

	function makeAdmin(){
		var username = $("#username").val();
		var data = {
		        username: username,
		        authority: 'ROLE_ADMIN'
		    };

		$.ajax({
			url : '/admin/changingAuth',
			type : 'PUT',
			contentType: 'application/json',
			data: JSON.stringify(data),
			success : function(response) {
				if(response){
					alert(username+" : 운영자 권한 부여 성공");
				}else{
					alert(username+" : 운영자 관한 부여 실패");
				}
			},
			error : function(error) {
				console.error(error);
			}
		});
	}

	function revokeAdmin(){
		var username = $("#username").val();
		var data = {
		        username: username,
		        authority: 'ROLE_ADMIN'
		    };

		$.ajax({
			url : '/admin/changingAuth',
			type : 'PUT',
			contentType : 'application/json',
			data : JSON.stringify(data),
			success : function(response) {
				if(response){
					alert(username+" : 운영자 권한 취소 성공");
				}else{
					alert(username+" : 운영자 관한 취소 실패");
				}
			},
			error : function(error) {
				console.error(error);
			}
		});
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
		<tr>
			<td><input type="text" name="username" id="username" placeholder="아이디를 적으세요">
			</td>
			<td>
			<input type="button" value="운영자 권한 부여" onclick="makeAdmin();">
			<input type="button" value="운영자 권한 취소" onclick="revokeAdmin();">
			</td>
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
			<c:forEach var="boardlist" items="${boardlist}">
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
			<a href="/admin/dashboard?page=${page.startPage-1 }">«</a>
		</c:if>
		<c:forEach begin="${page.startPage }" end="${page.endPage}" step="1" var="idx">						
			<a href="/admin/dashboard?page=${idx }">${idx }</a>
		</c:forEach>
		<c:if test="${page.next && page.endPage > 0 }">
			<a href="/admin/dashboard?page=${page.endPage + 1}">»</a>
		</c:if>
	</div>
</body>
</html>