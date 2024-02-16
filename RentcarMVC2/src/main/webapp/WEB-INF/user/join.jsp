<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>
<main>
	<h1>회원 가입</h1>
	<form action="${ctx}/userJoin.do" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" id="id" autofocus /> <input
					type="button" value="중복체크" id="checkId"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw" id="pw" /></td>
			</tr>
			<tr>
				<th>나이</th>
				<td><input type="number" name="age" id="age" /></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="email" id="email" /></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="tel" name="tel" id="tel" /></td>
			</tr>
			<tr>
				<th>취미</th>
				<td><input type="text" name="hobby" id="hobby" /></td>
			</tr>
			<tr>
				<th>직업</th>
				<td><input type="text" name="job" id="job" /></td>
			</tr>
			<tr>
				<th>정보</th>
				<td><textarea rows="10" cols="20" name="info" id="info"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" id="btns"><input type="button" value="가입"
					onclick="validCheck(form)" /> <input type="reset" value="취소" /></td>
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
	
	if(check == 0){
		alert('id 중복체크 해주세요');
		return false;
	} else if(check == -1){
		alert('id 중복체크 다시하세요');
		return false;
	}
	form.submit();
}

document.getElementById("checkId").addEventListener("click" , ()=> {
	let id = document.getElementById("id").value.trim();
	
	if (id.length === 0) {
		alert("id 값을 입력해주세요");
	    document.getElementById("id").focus();
	    document.getElementById("id").style.border = "";
	    return;
	}
  
	fetch("validateId.do", {
		method: "POST",
		headers: {
			"Content-Type": "application/x-www-form-urlencoded; charset=UTF-8",
		},
		body: "id=" + id,
	})
	.then(response => response.text())
	.then(getResult)
	.catch(() => alert("error"));
});

function getResult(data) {
	if (data === "valid") {
		alert("이 아이디는 사용가능 합니다  ");
		document.getElementById("pw").focus();
		document.getElementById("id").style.border = "3px blue solid";
		check = 1;
	}else if (data === "notValid") {
		alert("이 아이디는 사용 불가능 합니다");
    	document.getElementById("id").value = "";
		document.getElementById("id").focus();
		document.getElementById("id").style.border = "3px red solid";
		check = -1;
	}
}

document.getElementById("id").addEventListener("keyup", (e)=> {
    if (e.keyCode === 8) {
    	check = 0;
    }
    document.getElementById("id").style.border = "";
});
</script>
<%@ include file="../parts/footer.jsp"%>