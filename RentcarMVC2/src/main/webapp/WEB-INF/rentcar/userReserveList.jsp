<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 예약 리스트</title>
<style>
img{
	width : 100px;
	height : 100px;
}
</style>
</head>
<body>
	<c:if test="${empty list }">
		<h1>예약 리스트가 없습니다</h1>
	</c:if>
	<c:if test="${!empty list }">
	<table border=1>
		<tr>
			<th>예약번호</th>
			<th>이미지</th>
			<th>차량이름</th>
			<th>랜트수량</th>
			<th>대여기간</th>
			<th>대여일</th>
			<th>운전자보험</th>
			<th>인터넷여부</th>
			<th>네비게이션</th>
			<th>베이비시트</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="list" items="${list }">
		<tr>
			<td>${list.reserveSeq}</td>
			<td><img src="image/${list.img }"></td>
			<td><a href="${ctx }/userReserveView.do?reserveSeq=${list.reserveSeq}">${list.name }</a></td>
			<td>${list.qty }</td>
			<td>${list.dday }</td>
			<td>${list.rday }</td>
			<td>${list.usein }</td>
			<td>${list.usewifi }</td>
			<td>${list.usenavi }</td>
			<td>${list.useseat }</td>
			<td><button onclick="location.href='${ctx}/deleteResercation.do?reserveSeq=${list.reserveSeq}&no=${list.no}&qty=${list.qty}'">예약 취소</button></td>
		</tr>
		</c:forEach>
	</table>
	</c:if>
</body>
<script>
console.log(아);
</script>
</html>