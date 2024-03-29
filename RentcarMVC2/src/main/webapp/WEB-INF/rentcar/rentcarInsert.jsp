<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>
<style>
/* 전체를 감싸고 있는 메인 */
main {
	margin: 0 auto;
	width: 80%;
	height: 100%;
	display: flex;
	flex: 1;
}

form{
	margin: 0 auto;
}	

#btn{
	text-align: center;
}

input[type='button']{
	margin: 0 auto;
	padding: 10px 40px 10px;
	color: white;
	font-size: 20px;
	background: rgba(0, 0, 0, 0.7);
	border-radius: 10px;
}
</style>
<main>
	<form action="${ctx}/rentcarInsert.do" method="post" enctype="multipart/form-data" onsubmit="registerCarCheck(this)">
		<table border=1>
			<tr>
				<td rowspan=9>
					<img id="preview" width=300 height=300>
				</td>
			</tr>
			<tr>
				<th>차량 이름</th>
				<td>
					<input type="text" name="name" id="name" autofocus />
				</td>
			</tr>
			<tr>
				<th>차량 종류</th>
				<td>
					<select name="category">
						<option value="1">대형</option>
						<option value="2">중형</option>
						<option value="3">소형</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>랜트 가격</th>
				<td>
					<input type="number" name="price" id="price" />
				</td>
			</tr>
			<tr>
				<th>승차 인원</th>
				<td>
					<input type="number" name="usepeople" id="usepeople" />
				</td>
			</tr>
			<tr>
				<th>랜트카 총 수량</th>
				<td>
					<input type="number" name="totalQty" id="totalQty" />
				</td>
			</tr>
			<tr>
				<th>차량 회사 정보</th>
				<td>
					<input type="text" name="company" id="company" />
				</td>
			</tr>
			<tr>
				<th>이미지</th>
				<td>
					<input type="file" name="img" id="img" onchange="readURL(this)" />
				</td>
			</tr>
			<tr>
				<th>차량 정보</th>
				<td>
					<textarea name="info" id="info"></textarea>
				</td>
			</tr>
			<tr>
				<td id="btn" colspan="3">
					<input type="button" value="랜트카 등록" onclick="registerCarCheck(form)"/>
				</td>
			</tr>
		</table>
	</form>
</main>
<script>
	// 이미지 미리보기
	function readURL(input) {
		if (input.files && input.files[0]) {
			let reader = new FileReader();
			reader.onload = function(e) {
				document.getElementById("preview").src = e.target.result;
			};
			reader.readAsDataURL(input.files[0]);
		} else {
			document.getElementById('preview').src = "";
		}
	}
	// 넘기기전 체크
	function registerCarCheck(form) {
		let imgCheck = document.getElementById("img").value;
		if (!form.name.value.trim()) {
			alert("차량 이름을 입력해 주세요")
			form.name.focus();
			return false;
		}
		if (!form.category.value.trim()) {
			alert("차량 종류를 선택해 주세요")
			form.category.focus();
			return false;
		}
		if (!form.price.value.trim()) {
			alert("랜트 가격을 입력해 주세요")
			form.price.focus();
			return false;
		}
		if (!form.usepeople.value.trim()) {
			alert("승차 인원을 입력해 주세요")
			form.usepeople.focus();
			return false;
		}
		if (!form.totalQty.value.trim()) {
			alert("랜트카 총 수량을 입력해 주세요")
			form.totalQty.focus();
			return false;
		}
		if (!form.company.value.trim()) {
			alert("차량 회사 정보를 입력해 주세요")
			form.company.focus();
			return false;
		}
		if (!imgCheck) {
			alert("차량 이미지를 첨부해 주세요")
			return false;
		}
		if (!form.info.value.trim()) {
			alert("차량 정보를 입력해 주세요")
			form.info.focus();
			return false;
		}
		form.submit();
	}
</script>
<%@ include file="../parts/footer.jsp"%>