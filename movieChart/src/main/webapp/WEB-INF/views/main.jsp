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
	$(function() {
		var parsed_dBox = JSON.parse('${dailyBoxOffice}');
		console.log(parsed_dBox);
		var dailyBoxOfficeList = $("#dailyBoxOfficeList");
		var range = parsed_dBox.showRange;
		function dateFMT(range){
		        var dateArray = range.split("~");
		        var startDate = dateArray[0];
		        var endDate = dateArray[1];

		    if (startDate!=endDate) {
		        var formattedStartDate = startDate.slice(0, 4) + "년 " + startDate.slice(4, 6) + "월 " + startDate.slice(6) + "일";
		        var formattedEndDate = endDate.slice(0, 4) + "년 " + endDate.slice(4, 6) + "월 " + endDate.slice(6) + "일";

		        return formattedStartDate + "~" + formattedEndDate;
		    } else {
		        return startDate.slice(0, 4) + "년 " + startDate.slice(4, 6) + "월 " + startDate.slice(6) + "일";
		    }
		}
			$("#historyOfBoxOffice").html(dateFMT(range) + "자 박스오피스 순위");
		
		for (var i = 0; i < parsed_dBox.dailyBoxOfficeList.length; i++) {
			var dbox = parsed_dBox.dailyBoxOfficeList[i];
			var row = $("<tr>");
			row.append("<td>" + dbox.rank + "</td>");
			row.append("<td>" + dbox.movieNm + "</td>");
			dailyBoxOfficeList.append(row);
		}
		
		 $("#boxOfficeForm").submit(function (event) {
             event.preventDefault(); // 기본 폼 제출 동작을 막음

             // 폼 데이터를 가져와서 객체로 변환
             var formData = {
                 targetDt: $("#todayDate").val(),
                 multiMovieYn: $("select[name='multiMovieYn']").val(),
                 repNationCd: $("select[name='repNationCd']").val()
             };

             // AJAX 요청을 보냄
             $.ajax({
                 type: "GET",
                 url: "/getBoxOffice",
                 data: formData,
                 dataType: "json",
                 success: function (data) {
                     // 서버로부터 받은 데이터를 처리
                     var resultHtml = "<h2>박스 오피스 조회 결과</h2>";
                     resultHtml += "<p>날짜: " + data.date + "</p>";
                     resultHtml += "<p>영화 타입: " + data.multiMovieYn + "</p>";
                     resultHtml += "<p>국내외 여부: " + data.repNationCd + "</p>";
                     // 이 부분을 실제 데이터에 맞게 수정

                     $("#boxOfficeResult").html(resultHtml);
                 },
                 error: function (xhr, status, error) {
                     // 오류 처리
                     console.error(error);
                     $("#boxOfficeResult").html("<p>오류 발생</p>");
                 }
             });
         });
	});
</script>
</head>
<body>
	<h1>무비차트</h1>

	<div>
		<sec:authorize access="isAuthenticated()">
			<sec:authentication property="principal.udto.nickname" />
(<sec:authentication property="principal.udto.username" />)
 님 환영합니다.<br>
			<input type="button" value="로그아웃" onclick="">
			<br>
		</sec:authorize>
		<sec:authorize access="isAnonymous()">
			<input type="button" value="회원가입" onclick="location.href='/join'">
			<br>
			<input type="button" value="로그인" onclick="location.href='/login'">
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
		<form action="/getBoxOffice" method="get">
			날짜 : <input type="date" name="targetDt" id="todayDate"><br>
			영화 타입 : <select name="multiMovieYn">
				<option value="">전체</option>
				<option value="Y">다양성 영화</option>
				<option value="N">상업 영화</option>
			</select><br> 
			국내외 여부 : <select name="repNationCd">
				<option value="">전체</option>
				<option value="K">한국 영화</option>
				<option value="F">외국 영화</option>
			</select><br>
			<input type="submit" value="상세 검색">
		</form>
	</div>
</body>
</html>
