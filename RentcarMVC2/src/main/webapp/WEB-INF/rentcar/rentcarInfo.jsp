<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>렌트카 정보</title>
<style>
table{
	margin : auto;
}
</style>
</head>
<body>
	<table border=1>
		<tr>
			<td rowspan = "8">
				<img src="image/${rc.img}" alt="이미지" width = 300 height = 300/>
			</td>
		</tr>
		<tr>
			<th>차량이름</th>
			<td>${rc.name}</td>
		</tr>
		<tr>
			<th>차량 종류</th>
			<td>${rc.category}</td>
		</tr>
		<tr>
			<th>랜트가격</th>
			<td>${rc.price}</td>
		</tr>
		<tr>
			<th>승차인원</th>
			<td>${rc.usepeople}</td>
		</tr>
		<tr>
			<th>랜트카 총 수량</th>
			<td>${rc.totalQty}</td>
		</tr>
		<tr>
			<th>차량 회사 정보</th>
			<td>${rc.company}</td>
		</tr>
		<tr>
			<th>차량 정보</th>
			<td>${rc.info}</td>
		</tr>
		<tr>
			<td colspan=3>
				<button onclick="logincheck('${log}','${rc.no}', '${rc.totalQty}')">예약하기</button>
			</td>
		</tr>
	</table>
</body>
<script>
let contextPath = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

function logincheck(log, no, qty){
	if(log == ""){
		alert("로그인을 해야 합니다");
		location.href = contextPath + "/loginUser.do";
	}else if(qty == "0"){
		alert("랜트 가능한 차량이 없습니다");
		location.href = contextPath + "/carList.do";
	}else{
		location.href = contextPath + "/selectCarOption.do?no="+no;
	}
}
</script>
</html>