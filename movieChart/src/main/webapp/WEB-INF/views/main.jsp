<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<html>
<head>
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.0/dist/jquery.min.js"></script>
<title>무비차트</title>
<script>
	function dateFMT(range) {
		var dateArray = range.split("~");
		var startDate = dateArray[0];

		return startDate.slice(0, 4) + "년 " + startDate.slice(4, 6) + "월 "
				+ startDate.slice(6) + "일";

	}

	function updateMovieList(boxOfficeResult) {
		var dailyBoxOfficeList = $("#dailyBoxOfficeList");
		dailyBoxOfficeList.empty();

		$.each(boxOfficeResult.dailyBoxOfficeList, function(index, dbox) {
			var row = $("<tr>");
			row.append("<td>" + dbox.rank + "</td>");
			row.append("<td>" + dbox.movieNm + "</td>");
			dailyBoxOfficeList.append(row);
		});
	}

	$(function() {
		var parsed_dBox = JSON.parse('${dailyBoxOffice}');
		var range = parsed_dBox.showRange;

		$("#historyOfBoxOffice").html(dateFMT(range) + "자 박스오피스 순위");

		updateMovieList(parsed_dBox);
	});

	function submitForm() {
		var formData = $('#boxOfficeForm').serialize();
		$.ajax({
			url : '/boxOffice',
			type : 'GET',
			data : formData,
			dataType : 'json',
			success : function(response) {
				var range = response.showRange;

				$("#historyOfBoxOffice").html(dateFMT(range) + "자 박스오피스 순위");

				updateMovieList(response);
			},
			error : function(error) {
				console.error(error);
			}
		});
	}
</script>
</head>
<body>
	<h1>무비차트</h1>
	<div>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<input type="button" value="관리자 페이지로"
				onclick="location.href='admin/dashboard'">
		</sec:authorize>
	</div>
	<div>
		<sec:authorize access="isAuthenticated()">
			<sec:authentication property="principal.udto.nickname" />
(<sec:authentication property="principal.udto.username" />)
 님 환영합니다.<br>
			<input type="button" value="로그아웃" onclick="">
			<br>
		</sec:authorize>
		<sec:authorize access="isAnonymous()">
			<input type="button" value="회원가입"
				onclick="location.href='/member/join'">
			<br>
			<input type="button" value="로그인"
				onclick="location.href='/member/login'">
			<br>
		</sec:authorize>
	</div>
	<div>
		<table border="1">
			<thead>
				<tr>
					<td colspan="2" id="historyOfBoxOffice"></td>
				</tr>
				<tr>
					<td>순위</td>
					<td>제목</td>
			</thead>
			<tbody id="dailyBoxOfficeList"></tbody>
		</table>
		<form id="boxOfficeForm">
			날짜 : <input type="date" name="targetDt" id="targetDt"><br>
			영화 타입 : <select name="multiMovieYn" id="multiMovieYn">
				<option value="">전체</option>
				<option value="Y">다양성 영화</option>
				<option value="N">상업 영화</option>
			</select> <br> 국내외 여부 : <select name="repNationCd" id="repNationCd">
				<option value="">전체</option>
				<option value="K">한국 영화</option>
				<option value="F">외국 영화</option>
			</select> <br> <input type="button" value="상세 검색" onclick="submitForm()">
		</form>
	</div>
	<a href="board/list">자유게시판</a>
</body>
</html>
