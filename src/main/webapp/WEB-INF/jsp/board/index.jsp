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

<script>

</script>

<body>


<section class="content">
	<div class="row">
		<div class="col-md-12">

			<div class="box">
				<div class="col-md-8">
					<h3 class="box-title">페이징전(고통) &nbsp;&nbsp;&nbsp; <a href="/insertView">글쓰기</a></h3>
				</div></h3>
				</div>
								
<div class="box-body">
				
<table style = "border: 2px solid black; text-align: center;">
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
		<td><a href='/read?b_idx=<c:out value="${list.bIdx}"/>'><c:out value="${list.bTitle}"/></a></td>
		<td><c:out value="${list.bWriterName}"/></td>
		<td><c:out value="${list.bWriteDate}"/></td>
		<td><c:out value="${list.bModifyDate}"/></td>		
		<td><span class="badge bg-red"><c:out value="${list.bViewHit}"/></span></td>
	</tr>

</c:forEach>

</table>

				</div>
			</div>	
		</div>

	</div>
</section>

</body>
</html>