<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>
<main>
	<table>
		<tr>
			<td rowspan=5>
				<img src="image/${jcv.img}" alt="${rc.name}" width=300 height=300 />
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
</main>
<%@ include file="../parts/footer.jsp"%>