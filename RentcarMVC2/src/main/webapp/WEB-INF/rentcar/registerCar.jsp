<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>렌트카 등록 - 관리자</title>
</head>
<body>
	<form action="${ctx}/insertCar.do" method="post" enctype="multipart/form-data"
	onsubmit="registerCarCheck(this)">
		<table border=1>
			<tr>
				<td rowspan=10>
					<img id="preview" width=300 height=300>
				</td>
			</tr>
			<tr>
				<th>차량 이름</th>
				<td><input type="text" name="name" id="name" autofocus /></td>
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
				<td><input type="number" name="price" id="price" /></td>
			</tr>
			<tr>
				<th>승차 인원</th>
				<td><input type="number" name="usepeople" id="usepeople" /></td>
			</tr>
			<tr>
				<th>랜트카 총 수량</th>
				<td><input type="number" name="totalQty" id="totalQty" /></td>
			</tr>
			<tr>
				<th>차량 회사 정보</th>
				<td><input type="text" name="company" id="company" /></td>
			</tr>
			<tr>
				<th>이미지</th>
				<td><input type="file" name="img" id="img" accept="image/*" onchange="readURL(this)" /></td>
			</tr>
			<tr>
				<th>차량 정보</th>
				<td>
					<textarea name="info" id="info"></textarea>
				</td>
			</tr>
			<tr>
				<td id="btn" colspan="2">
					<input type="submit" value="랜트카 등록" />				
				</td>
			</tr>
		</table>
	</form>
</body>
<script>
// 이미지 미리보기
function readURL(input){
	if(input.files && input.files[0]){
		let reader = new FileReader();
		reader.onload = function(e){
			document.getElementById("preview").src = e.target.result;
		};
		reader.readAsDataURL(input.files[0]);
	}else{
		document.getElementById('preview').src="";
	}
}
// 넘기기전 체크
function registerCarCheck(form){
let imgCheck = document.getElementById("img").value;
	if(!form.name.value.trim()){
		alert("차량 이름을 입력해 주세요")
		form.name.focus();
		return false;
	}
	if(!form.category.value.trim()){
		alert("차량 종류를 선택해 주세요")
		form.category.focus();
		return false;
	}
	if(!form.price.value.trim()){
		alert("랜트 가격을 입력해 주세요")
		form.price.focus();
		return false;
	}
	if(!form.usepeople.value.trim()){
		alert("승차 인원을 입력해 주세요")
		form.usepeople.focus();
		return false;
	}
	if(!form.totalQty.value.trim()){
		alert("랜트카 총 수량을 입력해 주세요")
		form.totalQty.focus();
		return false;
	}
	if(!form.company.value.trim()){
		alert("차량 회사 정보를 입력해 주세요")
		form.company.focus();
		return false;
	}
	if(!imgCheck){
		alert("차량 이미지를 첨부해 주세요")
		return false;
	}
	if(!form.info.value.trim()){
		alert("차량 정보를 입력해 주세요")
		form.info.focus();
		return false;
	}
}
</script>
</html>