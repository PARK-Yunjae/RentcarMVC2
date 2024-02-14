<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>랜트카 예약하기</title>
</head>
<body>
	<form action="${ctx}/reservationCar.do" method="post">
		<input type="hidden" name="no" value="${rc.no }">
		<table border=1>
			<tr>
				<td rowspan=9>
					<img src="image/${rc.img}" alt="${rc.name}" width = 300 height = 300/>
				</td>
			</tr>
			<tr>
				<th>차량이름</th>
				<td>${rc.name}</td> 
			</tr>
			<tr>
				<th>랜트 수량</th>
				<td>
					<select name="qty" >
						<c:forEach var="i" begin="1" end="${rc.totalQty}" >
							<option value="${i}">${i}</option>
						</c:forEach>
					</select>
				</td> 
			</tr>
			<tr>
				<th>대여기간</th>
				<td><input type="number" name="dday" min=1 max=10>일</td>
			</tr>
			<tr>
				<th>대여일</th>
				<td><input type="date" name="rday" id="rday"></td>
			</tr>
			<tr>
				<th>운전자 보험</th>
				<td>
					<select name="usein" >
						<option value="1">적용</option>
						<option value="0">비적용</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>인터넷</th>
				<td>
					<select name="usewifi" >
						<option value="1">적용</option>
						<option value="0">비적용</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>네비게이션</th>
				<td>
					<input type="radio" name="usenavi" id="usenavi1" value="1" checked>
					<label for="usenavi1">예</label>
					<input type="radio" name="usenavi" id="usenavi0" value="0">
					<label for="usenavi0">아니오</label>
				</td>
			</tr>
			<tr>
				<th>베이비시트</th>
				<td>
					<select name="useseat" >
						<option value="1">적용</option>
						<option value="0">비적용</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan=3>
					<input type="submit" value="예약하기">
				</td>
			</tr>
		</table>
	</form>

</body>
<script>
/* let min = new Date('yyyy-MM-dd');
console.log(min);
let max = min.getDate() + 7;
console.log(max);
let rday = document.getElementById("rday");
//오늘 날짜로 기본값 주기
rday.value = min.toISOString().substring(0,10);
rday.setAttribute("min", min.getDate().substring(0,10));
rday.setAttribute("max", max.getDate().substring(0,10)); */
</script>
</html>