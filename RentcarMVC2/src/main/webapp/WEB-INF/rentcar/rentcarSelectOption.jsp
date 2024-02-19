<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>
<link rel="stylesheet" href="${ctx }/css/rentcarSelectOption.css">

<main>
	<form action="${ctx}/rentcarReservation.do" method="post">
		<input type="hidden" name="no" value="${rc.no }">
		<table>
			<tr>
				<td rowspan=9>
					<img src="img/${rc.img}" alt="${rc.name}" width=300 height=300 />
				</td>
			</tr>
			<tr>
				<th>차량이름</th>
				<td>${rc.name}</td>
			</tr>
			<tr>
				<th>랜트 수량</th>
				<td>
					<select name="qty" id="qty">
						<c:forEach var="i" begin="1" end="${rc.totalQty}">
							<option value="${i}">${i}대</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>대여기간</th>
				<td>
					<input type="number" name="dday" id="dday" min=1 max=10 />일
				</td>
			</tr>
			<tr>
				<th>대여일</th>
				<td>
					<input type="date" name="rday" id="rday" value="${value}" min="${min}" max="${max}">
				</td>
			</tr>
			<tr>
				<th>운전자 보험</th>
				<td>
					<select name="usein" name="usein">
						<option value="1">적용</option>
						<option value="0">비적용</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>인터넷</th>
				<td>
					<select name="usewifi" id="usewifi">
						<option value="1">적용</option>
						<option value="0">비적용</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>네비게이션</th>
				<td>
					<select name="usenavi" id="usenavi">
						<option value="1">적용</option>
						<option value="0">비적용</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>베이비시트</th>
				<td>
					<select name="useseat" id="useseat">
						<option value="1">적용</option>
						<option value="0">비적용</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan=3>
					<input id="loginBtn" type="button" value="예약하기" onclick="reservationCheck(form)">
				</td>
			</tr>
		</table>
	</form>
</main>
<script type="text/javascript">
function reservationCheck(form) {
	if(!form.qty.value.trim()){
		alert("랜트 수량을 선택해 주세요");
		form.qty.focus();
		return false;
	}
	if(!form.dday.value.trim()){
		alert("대여 기간을 선택해 주세요");
		form.dday.focus();
		return false;
	}else{
		if(form.dday.value.trim() < 1 || form.dday.value.trim() > 99){
			alert("1 ~ 99 일 사이만 가능합니다");
			form.dday.focus();
			return false;
		}
	}
	if(!form.rday.value.trim()){
		alert("대여일을 선택해 주세요");
		form.rday.focus();
		return false;
	}
	if(!form.usein.value.trim()){
		alert("운전자 보험을 선택해 주세요");
		form.usein.focus();
		return false;
	}	
	if(!form.usewifi.value.trim()){
		alert("인터넷 유무를 선택해 주세요");
		form.usewifi.focus();
		return false;
	}	
	if(!form.usenavi.value.trim()){
		alert("네비게이션을 선택해 주세요");
		form.usenavi.focus();
		return false;
	}	
	if(!form.useseat.value.trim()){
		alert("베이비시트를 선택해 주세요");
		form.useseat.focus();
		return false;
	}
	form.submit();
}
</script>
<%@ include file="../parts/footer.jsp"%>