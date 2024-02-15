<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
</head>
<body>
	<h1>회원 탈퇴</h1>
	<form action="${ctx}/deleteUser.do" method="post" id="deleteUser">
		<table>
			<tr>
				<td>패스워드</td>
				<td>
					<input type="password" name="pw" id="pw" required />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" id="deleteBtn" value="회원탈퇴"/>
				</td>
			</tr>
		</table>
	</form>
</body>
<script>
let deleteBtn = document.getElementById("deleteBtn");
let contextPath = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

deleteBtn.addEventListener("click" , ()=> {
	let pw = document.getElementById("pw").value.trim();
	if (pw.length === 0) {
		alert("pw 값을 입력해주세요");
	    document.getElementById("pw").focus();
	    document.getElementById("pw").style.border = "";
	    return;
	}
	if (pw != ${pw}) {
		alert("비밀번호가 틀렸습니다");
	    document.getElementById("pw").focus();
	    document.getElementById("pw").style.border = "";
	    return;
	}
	fetch("deleteUserCheck.do", {
		method: "POST",
		headers: {
			"Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
		},
		body: "id=" + "${id}"
	})
	.then(response => response.text())
	.then(data => {
		if(data == 0){
			alert("회원 탈퇴 완료");
			location.href = contextPath + "/deleteUser.do?pw="+${pw};
		}else{
			alert("예약 목록이 없어야 탈퇴가 가능합니다");
		}
	})
	.catch(() => alert("error"));
});
</script>
</html>