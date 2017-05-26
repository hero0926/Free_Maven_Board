<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 쓰기</title>
<script src="../../common/js/jquery-3.2.1.min.js"></script>
<script src="../../common/js/*"></script>
<script src="../../common/ckeditor/ckeditor.js"></script>

<style>
.fileUpload{

	width : 40%;
	float : center;
	height : 150px;
	border : 1px dotted black;
	text-align : center;
	padding : 30px;

}

</style>


</head>
<body>

 		
 <h3>글 쓰기</h3>
 
<form role="form" id="form" method="post">
 		
<table style = "border: 2px solid black; text-align: center;" >
	<tr >
		<th>제목</th>
		<th>글쓴이</th>
		<th>비밀번호</th>
	</tr>
	<tr>	
		<td><input type="text" name="b_title" id="b_title" size="50"/></td>
		<td><input type="text" name="b_writer_name" id="b_writer_name"/></td>
		<td><input type="password" name="b_password" id="b_password"/></td>
	</tr>
	<tr>
		<th >내용</th>
		
			
		
		<td>
		첨부파일 <input type="file" name="file" id="file">
		</td>
	</tr>
	<tr>	
		<Td colspan="3"><textarea name="b_content" id="b_content" rows="50" cols="10">              
		</textarea>
		<script>
			CKEDITOR.replace( "b_content", {
			});
		</script>
		</Td>	
	</tr>
</table>
</form>

  <div class="box-footer">
	<button type="submit" class="btn write">글쓰기</button>
	<button type="submit" class="btn no_write">목록으로</button>
  </div>

</body>

	<script>
	$(document)
	.ready(
			function() {

				var formObj = $("form[role='form']");
				var file = $('input[type="file"]').val().trim();
				
				$(".no_write")
					.on(
							"click",
							function() {
								self.location = "/listPage?page=1";
							});
				$(".write").on("click",
						function() {
					
					
							if(file){
							formObj.attr("enctype", "multipart/form-data");
							formObj.attr("method", "post");
							formObj.attr("action", "/fileUpload");
							formObj.submit();
							}else{
								formObj.attr("method", "post");
								formObj.attr("action", "/insert");
								formObj.submit();								
							}
							
						});
				
			});
	</script>
</html>