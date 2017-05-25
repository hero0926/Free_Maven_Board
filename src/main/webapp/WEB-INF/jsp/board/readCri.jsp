<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글읽기</title>
</head>

<script src="../../common/js/jquery-3.2.1.min.js"></script>

<body>

<form role="form" action="update" method="post">    
    <input type='hidden' name='b_idx' value ="${list.b_idx}">
    <input type='hidden' name='page' value ="${prevPage}">  
 </form>

 		
 <h3>글 읽기</h3>		
 
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
		<td><c:out value="${list.b_idx}"/></td>
		<td><c:out value="${list.title}"/></td>
		<td><c:out value="${list.b_writer_name}"/></td>
		<td><c:out value="${list.b_write_date}"/></td>
		<td><c:out value="${list.b_modify_date}"/></td>		
		<td><span class="badge bg-red"><c:out value="${list.b_view_hit}"/></span></td>
	</tr>
	<tr>
		<th>내용</th>		
		<td><textarea name='content'		
         readonly="readonly" rows="20" cols="100">
         ${list.b_content} 
         </textarea>
         <td/>
	</tr>
</table>
    

  <div class="box-footer" style="padding-left : 250px;">
    <button type="submit" class="btn update">수정하기</button>
    <button type="submit" class="btn delete">글 지우기</button>
    <button type="submit" class="btn list">목록 보기 </button>
  </div>

</body>

<script>
$(document).ready(function(){
	
	var formObj = $("form[role='form']");
	
	console.log(formObj);
	
	$(".update").on("click", function(){
		formObj.attr("action", "/updateView");
		formObj.attr("method", "get");		
		formObj.submit();
	});
	
	$(".delete").on("click", function(){
		formObj.attr("action", "/delete");
		formObj.attr("method", "get");		
		formObj.submit();
	});
	
	$(".list").on("click", function(){
		formObj.attr("method", "get");
		formObj.attr("action", "/listPage");
		formObj.submit();
	});
	
});
</script>
</html>