<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta id="_csrf" name="_csrf" content="${_csrf.token}"/>
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"/>
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.0/dist/jquery.min.js"></script>
<title>무비차트:${boardContent.category}-${boardContent.title }</title>
<script type="text/javascript">
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	$.ajaxSetup({
	    beforeSend: function(xhr) {
	        xhr.setRequestHeader(header, token);
	    }
	});

	function getBoardReply(board_id) {
		$.ajax({
			url : '/board/'+board_id+'/replys',
			type : 'GET',
			dataType : 'json',
			success : function(response) {
				console.log('답글 조회 성공:', response);

				var repliesList = $("#replyResponse");

	            repliesList.empty();

	            response.forEach(function (data) {
	                var listItem = $("<tr>");
	                var usernameCell = $("<td>").text("작성자 : "+data.username);
	                var replyCell = $("<td>").text(data.reply);
	                var dateCell = $("<td>").text("작성 일자 : "+data.reply_dt);

	                listItem.append(usernameCell);
	                listItem.append(replyCell);
	                listItem.append(dateCell);
	                
	                repliesList.append(listItem);
	            });
			},
			error : function(error) {
				console.error('답글 조회 실패:', error);
			}
		});
	}

	function postBoardReply(board_id, content) {
		$.ajax({
			url : '/board/'+board_id+'/replys',
			type : 'POST',
			data : {
			        board_id: board_id,
			        reply: content,  
			        username: '${pageContext.request.userPrincipal.name}'
			    },
			dataType : 'json',
			success : function(response) {
				console.log('답글 작성 성공:', response);
				getBoardReply(board_id);
			},
			error : function(error) {
				console.error('답글 작성 실패:', error);
				getBoardReply(board_id);
			}
		});
	}

	function putBoardReply(board_id, reply_id, content) {
		$.ajax({
			url : board_id+'/reply/'+reply_id,
			type : 'PUT',
			data : {
				board_id : board_id,
				reply_id : reply_id,
				content : content
			},
			dataType : 'json',
			success : function(response) {
				console.log('답글 수정 성공:', response);
			},
			error : function(error) {
				console.error('답글 수정 실패:', error);
			}
		});
	}

	function softDeleteBoardReply(board_id, reply_id) {
		$.ajax({
			url : board_id+'/reply/'+reply_id,
			type : 'DELETE',
			dataType : 'json',
			success : function(response) {
				console.log('답글 삭제 성공:', response);
			},
			error : function(error) {
				console.error('답글 삭제 실패:', error);
			}
		});
	}
	
	$(function(){
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		
		$(document).ajaxSend(function(e, xhr, options) {
	         xhr.setRequestHeader(header,token);
	    });
		getBoardReply('${boardContent.board_id }');
	});
</script>
</head>
<body>
	<table border="1">
		<thead>
		<sec:authorize access="isAuthenticated() && authentication.principal.username == '${boardContent.username}'">
		<tr>
			<td><input type="button" value="글 수정" onclick="location.href='edit'"></td>
			<td>글 삭제</td>
		</tr>
		</sec:authorize>
		</thead>
		<tbody>
		<tr>
			<td>${boardContent.board_id }</td>
			<td colspan="2">${boardContent.title }</td>
			<td>조회수 : ${boardContent.view_cnt }</td>
			<td>${boardContent.category }</td>
		</tr>
		<tr>
			<td colspan="6">${boardContent.content }</td>
		</tr>
		</tbody>
		<tfoot>
		<c:forEach var="board" items="${boardContent.SurroundingList}">
				<tr>
			<c:if test="${board.board_id < boardContent.board_id}">
					<td>이전글
			</c:if>
			<c:if test="${board.board_id > boardContent.board_id}">
					<td>다음글
			</c:if>					
					<td>${board.category}</td>
					<td><a href="${board.board_id}">${board.title}</a></td>
					<td>${board.nickname}</td>
					<td>${board.write_date}</td>
				</tr>
		</c:forEach>
		</tfoot>
	</table>
	<div>
		<table>
			<tbody id="replyResponse">
			</tbody>
			<sec:authorize access="isAuthenticated()">
				<tr>
					<td><textarea rows="5" cols="50" id="replyContent"></textarea>
						<input type="button" value="답글작성" onclick="postBoardReply('${boardContent.board_id}', $('#replyContent').val())">
					</td>
				</tr>
			</sec:authorize>	
		</table>
	</div>
</body>
</html>