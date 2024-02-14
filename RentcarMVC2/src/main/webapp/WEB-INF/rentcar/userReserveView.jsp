<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="total" value="${(jcv.usein + jcv.usewifi + jcv.usenavi + jcv.useseat)}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 예약 페이지</title>
</head>
<body>
	<table border = 1>
		<tr>
			<td rowspan=5>
				<img src="image/${jcv.img}" alt="${rc.name}" width = 300 height = 300/>
			</td>
		</tr>
		<tr>
			<th>차량 예약일</th>
			<td colspan=2>${jcv.no}</td>
		</tr>
		<tr>
			<th>랜트 수량</th>
			<td colspan=2>${jcv.qty}</td>
		</tr>
		<tr>
			<th>유료 옵션</th>
			<td colspan=2>${total}</td>
		</tr>
		<tr>
			<th>금액</th>
			<td colspan=2>${(total*5)}</td>
		</tr>
	</table>
</body>
</html>