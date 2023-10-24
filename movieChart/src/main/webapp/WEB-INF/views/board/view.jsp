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
	                var usernameCell = $("<td>").text("작성자 : "+data.nickname);
	                var replyCell = $("<td>").text(data.reply);
	                var dateCell = $("<td>").text("작성 일자 : "+data.reply_dt);
	                var insertDeleteButton = $("<td>").append($("<input>").attr("type", "button").val("삭제").click(function() {
	                    deleteConfirm(board_id, data.reply_id);
	                }));

	                listItem.append(usernameCell);
	                listItem.append(dateCell);
// 	                listItem.append("<td><input type='button' value='수정' onclick='appendTextarea("+data.reply_id+","+data.reply+")'></td>");
// 	                listItem.append("<td><div id='updateReply'></div></td>");
	                if('${pageContext.request.userPrincipal.name}'=== data.username){
	                listItem.append(insertDeleteButton);
	                }
	                repliesList.append(listItem);
	                
	                var replyTr=$("<tr>").append($("<td>").attr("colspan", "4").append(replyCell));
					repliesList.append(replyTr);
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
			success : function(response) {
				console.log('답글 작성 성공:', response);
				$('#replyContent').val('');
				getBoardReply(board_id);
			},
			error : function(error) {
				console.error('답글 작성 실패:', error);
				getBoardReply(board_id);
			}
		});
	}

// 	function putBoardReply(board_id, reply_id, content) {
// 		$.ajax({
// 			url : board_id+'/reply/'+reply_id,
// 			type : 'PUT',
// 			data : {
// 				board_id : board_id,
// 				reply_id : reply_id,
// 				reply : content
// 			},
// 			success : function(response) {
// 				console.log('답글 수정 성공:', response);
// 				getBoardReply(board_id);
// 			},
// 			error : function(error) {
// 				console.error('답글 수정 실패:', error);
// 				getBoardReply(board_id);
// 			}
// 		});
// 	}

	function softDeleteBoardReply(board_id, reply_id) {
		$.ajax({
			url : board_id+'/reply/'+reply_id,
			type : 'DELETE',
			success : function(response) {
				console.log('답글 삭제 성공:', response);
				alert("답글 삭제 완료");
				getBoardReply(board_id);
			},
			error : function(error) {
				console.error('답글 삭제 실패:', error);
				getBoardReply(board_id);
			}
		});
	}
	
	function deleteConfirm(board_id, reply_id){
		if(confirm("답글을 삭제하시겠습니까?")){
			softDeleteBoardReply(board_id, reply_id);
		}
	}
	
// 	function insertTextArea(replyId, replyContent) {
// 	    var textArea = $("<textarea>")
// 	        .attr("id", "updateTextarea_" + replyId)
// 	        .val(replyContent);
	        
// 	    var updateButton = $("<input>")
// 	        .attr("type", "button")
// 	        .val("수정 완료")
// 	        .click(function() {
// 	            var updatedContent = $("#" + textArea.attr("id")).val();
// 	        });

// 	    $("#updateReply").empty(); 
// 	    $("#updateReply").append(textArea);
// 	    $("#updateReply").append(updateButton);
// 	}
	
		function deleteBoard(boardId){		        
		        $.ajax({
		            type: "DELETE",
		            url: "/board/" + boardId, 
		            success: function(response) {
		            	if(response){
		               		alert("게시물이 성공적으로 삭제되었습니다.");
		            		location.href="/board/list";
		            	}
		            },
		            error: function(error) {
		                console.error("게시물 삭제에 실패하였습니다.");
		            }
		        });
		}
	$(function(){
		getBoardReply('${boardContent.board_id }');
		
	});
</script>
</head>
<body>
	<table border="1">
		<thead>
		<sec:authorize access="isAuthenticated() && authentication.principal.username == '${boardContent.username}'">
		<tr>
			<td><input type="button" value="글 수정" onclick="location.href='edit/${boardContent.board_id}'"></td>
			<td><input type="button" value="글 삭제" onclick="deleteBoard(${boardContent.board_id})"></td>
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
			<td colspan="6">
			<c:forEach var="file" items="${boardFileList}">
    			<img src="../..${file}" alt="이미지" width="200" height="150"><br>
			</c:forEach>
			${boardContent.content }</td>
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
	<input type="button" value="목록으로" onclick="location.href='/board/list';">
</body>
</html>