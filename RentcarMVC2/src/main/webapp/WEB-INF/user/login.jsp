<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>
<link rel="stylesheet" href="${ctx }/css/login.css">
<main>
	<form action="${ctx}/userLogin.do" method="post">
		<table>
			<tr>
				<td colspan="2" id="title">
					로그인
				</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="id" id="id" autofocus required />
				</td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td>
					<input type="password" name="pw" id="pw" required />
				</td>
			</tr>
			<tr>
				<td colspan="2" id=button>
					<input type="button" id="loginCheck" value="로그인" />
				</td>
			</tr>
		</table>
	</form>
</main>
<script>
let contextPath = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
let loginCheck = document.getElementById("loginCheck");

loginCheck.addEventListener("click", () =>{
	let id = document.getElementById("id").value.trim();
	let pw = document.getElementById("pw").value.trim();
	
	fetch("validateLogin.do", {
		method: "POST",
		headers: {
			"Content-Type" : "application/x-www-form-urlencoded; charset=UTF-8"
		},
		body: "id=" + id + "&pw=" + pw
	})
	.then(response => response.text())
	.then(data =>{
		if(data === "성공"){
			alert("로그인 성공");
			location.href = contextPath + "/userLogin.do?id="+id+"&pw="+pw;
		}else{
			alert("로그인 실패");
		}
	})
})
</script>
<%@ include file="../parts/footer.jsp"%>