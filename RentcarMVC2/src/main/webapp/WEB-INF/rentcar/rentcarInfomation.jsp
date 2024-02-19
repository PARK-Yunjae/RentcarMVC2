<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>
<link rel="stylesheet" href="${ctx }/css/rentcarInfomation.css">

<main>
	<table>
		<tr>
			<td class="imgTd" rowspan="8">
				<img src="img/${rc.img}" alt="이미지"/>
			</td>
		</tr>
		<tr>
			<th>차량이름</th>
			<td>${rc.name}</td>
		</tr>
		<tr>
			<th>차량 종류</th>
			<td>
				<c:if test="${rc.category eq 1}">대형</c:if>
				<c:if test="${rc.category eq 2}">중형</c:if>
				<c:if test="${rc.category eq 3}">소형</c:if>
			</td>
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
				<button id="loginBtn" onclick="logincheck('${log}','${rc.no}', '${rc.totalQty}')">예약하기</button>
			</td>
		</tr>
	</table>
</main>
<script>
let contextPath = window.location.pathname.substring(0,window.location.pathname.indexOf("/", 2));

function logincheck(log, no, qty) {
	if (log == "") {
		alert("로그인을 해야 합니다");
		location.href = contextPath + "/userLogin.do";
	} else if (qty == "0") {
		alert("렌트 가능한 차량이 없습니다");
		location.href = contextPath + "/rentcarList.do";
	} else {
		location.href = contextPath + "/rentcarSelectOption.do?no=" + no;
	}
}
</script>
<%@ include file="../parts/footer.jsp"%>