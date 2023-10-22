<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta id="_csrf" name="_csrf" content="${_csrf.token}" />
<meta id="_csrf_header" name="_csrf_header"
	content="${_csrf.headerName}" />
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.0/dist/jquery.min.js"></script>
<title>${movie.title }</title>
<script type="text/javascript">
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	$.ajaxSetup({
		beforeSend : function(xhr) {
			xhr.setRequestHeader(header, token);
		}
	});

	function getReview(code_no) {
		$
				.ajax({
					url : '/movie/' + code_no + '/reviews',
					type : 'GET',
					dataType : 'json',
					success : function(response) {
						console.log('리뷰 조회 성공:', response);

						var reviewList = $("#reviewResponse");

						reviewList.empty();

						response.forEach(function(data) {
							
							var listItem = $("<tr>");
							var usernameCell = $("<td>").text("작성자 : " + data.nickname);
							var scoreCell = $("<td>").text("점수 : "+data.score);
							var reviewCell = $("<td>").text(data.review);
							var dateCell = $("<td>").text("작성 일자 : " + data.review_dt);
							var insertDeleteButton = $("<td>").append($("<input>").attr("type","button").val("삭제")
									.click(
											function() {
												deleteConfirm(code_no,data.review_id);
									}));
							listItem.append(usernameCell);
							listItem.append(scoreCell);
							listItem.append(reviewCell);
							listItem.append(dateCell);
							
							var reviewTr=$("<tr>").append($("<td>").attr("colspan", "4").append(reviewCell));
							
							if ('${pageContext.request.userPrincipal.name}' === data.username) {
								listItem.append(insertDeleteButton);
							}
							reviewList.append(listItem);
							reviewList.append(reviewTr);
						});
					},
					error : function(error) {
						console.error('리뷰 조회 실패:', error);
					}
				});
	}

	function postReview(code_no, content,score) {
		$.ajax({
			url : '/movie/' + code_no + '/reviews',
			type : 'POST',
			data : {
				code_no : code_no,
				review : content,
				score : score,
				username : '${pageContext.request.userPrincipal.name}'
			},
			success : function(response) {
				console.log('리뷰 작성 성공:', response);
				$('#reviewContent').val('');
				getReview(code_no);
			},
			error : function(error) {
				console.error('리뷰 작성 실패:', error);
				getReview(code_no);
			}
		});
	}

	function softDeleteReview(review_id) {
		$.ajax({
			url : code_no + '/review/' + review_id,
			type : 'DELETE',
			success : function(response) {
				console.log('리뷰 삭제 성공:', response);
				alert("리뷰 삭제 완료");
				getReview(code_no);
			},
			error : function(error) {
				console.error('리뷰 삭제 실패:', error);
				getReview(code_no);
			}
		});
	}

	function deleteConfirm(review_id) {
		if (confirm("리뷰를 삭제하시겠습니까?")) {
			softDeleteReview(review_id);
		}
	}

	$(function() {
		getReview('${movie.code_no }');

	});
</script>
</head>
<body>
	<h1>
		<a href="/main">${movie.title }</a>
	</h1>
	<table>
		<tr>
			<td colspan="3"><img src="${movie.image }"></td>
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
				</fieldset></td>
		</tr>
	</table>
	<div>
		<table>
			<tbody id="reviewResponse">
			</tbody>
			<sec:authorize access="isAuthenticated()">
				<tr>
					<td>점수 : <select id="scoreSelect">
							<option value="1">★</option>
							<option value="2">★★</option>
							<option value="3">★★★</option>
							<option value="4">★★★★</option>
							<option value="5">★★★★★</option>
					</select><br> 
					<textarea rows="5" cols="50" id="reviewContent"></textarea>
						<input type="button" value="리뷰작성"
						onclick="postReview('${movie.code_no}', $('#reviewContent').val(), $('#scoreSelect' ).val())">
					</td>
				</tr>
			</sec:authorize>
		</table>
	</div>
</body>
</html>