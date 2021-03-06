<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 수정하기</title>


<script src="../../common/js/jquery-3.2.1.min.js"></script>
<script src="../../common/ckeditor/ckeditor.js"></script>

</head>
<body>

<form role="form" action="list" method="post">    
    <input type='hidden' name='b_idx' value ="${list.b_idx}"> 
    <input type='hidden' name='page' value ="${prevPage}"> 
</form>   
 		
 <h3>글 수정</h3> 		
	
<form role="form2" action="update" method="post">

<table style = "border: 2px solid black; text-align: center;">
	<tr >
		<th style="width: 60px">글번호</th>
		<th>제목</th>
		<th>글쓴이</th>
		<th>등록일</th>
		<th>수정일</th>
		<th style="width: 60px">조회수</th>
	</tr>
	<tr>
		<td><input type="text" name="b_idx" value="${list.b_idx}" readonly="readonly"/></td>
		<td><input type="text" name="b_title" value="${list.b_title}" size="50"/></td>
		<td><c:out value="${list.b_writer_name}"/></td>
		<td><c:out value="${list.b_write_date}"/></td>
		<td><c:out value="${list.b_modify_date}"/></td>		
		<td><span class="badge bg-red"><c:out value="${list.b_view_hit}"/></span></td>
	</tr>
	<tr>
		<th colspan="3">내용</th>
		<td>
		첨부파일 <input type="file" name="file" id="file">
		</td>
	</tr>
	<tr>		
		<td colspan="6"><textarea name="b_content" id="b_content"	
         rows="20" cols="70" >
         ${list.b_content} 
         </textarea>
         <script>
			CKEDITOR.replace( "b_content", {
			});
		</script>
		</td>
	</tr>
    
</table>
	
</form>

  <div class="box-footer">
	<button type="submit" class="btn update">수정하기</button>
	<button type="submit" class="btn no_update">수정 안하기</button>
  </div>

</body>
	<script>
		$(document).ready(
			function() {

				var formObj = $("form[role='form']");
				var f = $("form[role='form2']");

				var file = $('input[type="file"]').val().trim();

				$(".no_update")
						.on(
								"click",
								function() {
									self.location = "listPage?page=${cri.page}";
								});

				$(".update").on("click",
						function() {
					
					
					if(!document.getElementById("file").files.length == 0){
					console.log("file upload");
						
					f.attr("enctype", "multipart/form-data");
					f.attr("method", "post");
					f.attr("action", "/fileUpdate");
					f.submit();
					
					}else{
						f.attr("method", "post");
						f.attr("action", "/update");
						f.submit();								
					}
			});		
	});		
	</script>
</html>