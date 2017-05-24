<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="//code.jquery.com/jquery.min.js"></script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 쓰기</title>
</head>
<body>

<form role="form" action="insert" method="post">
 		
 <h3>글 쓰기</h3>		
 		
<table style = "border: 2px solid black; text-align: center;">
	<tr >
		<th>제목</th>
		<th>글쓴이</th>
		<th>비밀번호</th>
	</tr>
	<tr>
	
	<form role="form" action="update" method="post">	
		<td><input type="text" name="b_title" size="50"/></td>
		<td><input type="text" name="b_writer_name"/></td>
		<td><input type="text" name="b_password"/></td>
	</tr>
	<tr>
		<th>내용</th>
	</tr>
	<tr>		
		<td><textarea name="b_content" 		
         rows="20" cols="70"></textarea>
         <td/>
	</tr>
	
    </form>
    
</table>
    

  <div class="box-footer">
	<button type="submit" class="btn write">글쓰기</button>
	<button type="submit" class="btn no_write">글 쓰지 않기</button>
  </div>

</body>

	<script>
		$(document)
		.ready(
				function() {

					var formObj = $("form[role='form']");

					console.log(formObj);

					$(".no_write")
							.on(
									"click",
									function() {
										self.location = "/index";
									});

					$(".write").on("click",
							function() {
								formObj.submit();
							});

				});
	</script>


</html>