<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>
<link rel="stylesheet" href="${ctx }/css/userInfomation.css">
<main>
	
	<form action="${ctx}/userUpdate.do" method="post">
		<table>
			<caption>회원 수정</caption>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="id" id="id" class="inputText" value="${u.id}" readonly />
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="pw" id="pw" class="inputText"/>
				</td>
			</tr>
			<tr>
				<th>나이</th>
				<td>
					<input type="number" name="age" id="age" class="inputText" value="${u.age}" />
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>
					<input type="email" name="email" id="email" class="inputText" value="${u.email}"/>
				</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>
					<input type="tel" name="tel" id="tel" class="inputText" value="${u.tel}"/>
				</td>
			</tr>
			<tr>
				<th>취미</th>
				<td>
					<input type="text" name="hobby" id="hobby" class="inputText" value="${u.hobby}"/>
				</td>
			</tr>
			<tr>
				<th>직업</th>
				<td>
					<input type="text" name="job" id="job" class="inputText" value="${u.job}"/>
				</td>
			</tr>
			<tr>
				<th>정보</th>
				<td>
					<textarea name="info" id="info" class="inputText">${u.info}</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" id="btns">
					<input type="button" id="infoBtn" value="수정" onclick="validCheck(form)" /> 
					<input type="reset" id="infoBtn" value="취소" />
				</td>
			</tr>
		</table>
	</form>
</main>
<script type="text/javascript">
let check = 0;
function validCheck(form){
	if(!form.id.value.trim()){
		alert("아이디를 입력해주세요");
		form.id.focus();
		return false;
	}	
	if(!form.pw.value.trim()){
		alert("비밀번호를 입력해주세요");
		form.pw.focus();
		return false;
	}
	if(form.pw.value != ${u.pw}){
		alert("비밀번호가 틀렸습니다");
		form.pw.focus();
		return false;
	}
	if(!form.age.value.trim()){
		alert("나이를 입력해주세요");
		form.age.focus();
		return false;
	}else{
		if(Number(form.age.value.trim()) < 10 || Number(form.age.value.trim()) > 99 ){
			alert("나이 값(10-99)을 정확하게 입력하세요");
			form.age.focus();
			return false;
		}
	}
	/*
	@ 앞에는 영어소문자,숫자 . _ % + - 만 허용
	@ 골뱅이 필수.
	@ 뒤 . 앞에는 영어소문자,숫자 . - 만 허용
	. 점 필수
	. 뒤에는 영어소문자 2자리 이상
	*/
	if(!form.email.value.trim()){
		alert("이메일을 입력해주세요");
		form.email.focus();
		return false;
	}	
	if(!form.email.value.match(/[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$/)){
		alert("이메일 형식이 다릅니다");
		form.email.value="test@test.com";
		form.email.focus();
		return false;
	}
	if(!form.tel.value.trim()){
		alert("전화번호를 입력해주세요");
		form.tel.focus();
		return false;
	}	
	if(!form.tel.value.match(/010-\d{3,4}-\d{4}/)){
		alert("전화번호 형식이 다릅니다");
		form.tel.value="010-1234-1234";
		form.tel.focus();
		return false;
	}
	
	form.submit();
}

</script>
<%@ include file="../parts/footer.jsp"%>