<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글읽기</title>

<script src="../../common/js/jquery-3.2.1.min.js"></script>


<style>
.content{ 
  text-align: center;
  display: block;
  margin: auto;
}

.row{
  text-align: center;
  display: block;
  margin: auto;
  border: 2px solid black;
}


table{
  text-align: center;
  margin-left : 430px;
  padding : 20px;
}

</style>

<script>
$(document).ready(function(){
	
	var formObj = $("form[role='form']");
	
	$(".excel").on("click", function(){
		formObj.attr("method", "get");
		formObj.attr("action", "/excel");
		formObj.submit();
	});
	
	$(".insert").on("click", function(){
		formObj.attr("action", "/insertView");
		formObj.submit();
	});
	
});
</script>
				

</head>

<body>

<form role="form" action="update" method="post">
    <input type='hidden' name='page' value ="${prevPage}">  
</form>   

<section class="content">

	<div class = "row">
		<div class="col-md-8">
			<h3 class="box-title">게시판</h3>
		</div>
		
		 <div class="box-footer" style="padding-left : 250px;">
    	<button type="submit" class="btn excel">excel 다운</button>
    	<button type="submit" class="btn insert">글쓰기</button>
  		</div>


		<table>
			<tr >
				<th style="width: 60px">글번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>등록일</th>
				<th>수정일</th>
				<th style="width: 60px">조회수</th>
			</tr>
			
			
			<c:forEach items="${list}" var="list">
				<tr>
					<td>${list.b_idx}<c:out value="${list.bIdx}"/></td>
					<td><a href='/readPage?b_idx=<c:out value="${list.bIdx}"/>'><c:out value="${list.bTitle}"/></a></td>
					<td><c:out value="${list.bWriterName}"/></td>
					<td><c:out value="${list.bWriteDate}"/></td>
					<td><c:out value="${list.bModifyDate}"/></td>		
					<td><span class="badge bg-red"><c:out value="${list.bViewHit}"/></span></td>
				</tr>

			</c:forEach>
			
		</table>
		
	</div>


	<div>
		<c:if test="${pageMaker.prev}">
				<a href=listPage?page=${pageMaker.startPage - 1}>&laquo;</a>
		</c:if>

		<c:forEach begin="${pageMaker.startPage }"	end="${pageMaker.endPage }" var="idx">					
			<c:out value=" ${pageMaker.cri.page == idx?'(현)':''}" />						
			<a href=listPage?page=${idx}>${idx}페이지</a>&nbsp;					
		</c:forEach>

		<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
			<a href=listPage?page=${pageMaker.endPage +1}>&raquo;</a>
		</c:if>

	</div>
				
	</div>
	
</section>

</body>
</html>