<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="id" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
</head>
<body>
	<h1>회원 탈퇴</h1>
	<form action="${ctx}/deleteUser.do" method="post">
		<table class="table table-bordered">
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="id" readonly />
				</td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td>
					<input type="password" name="pw" required />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="회원탈퇴" onclick="deleteCheck(form)"/>
				</td>
			</tr>
		</table>
	</form>
</body>
<script>
function deleteCheck(form) {
	if(form.pw.value != ${pw}){
		alert("비밀번호가 틀렸습니다");
		form.pw.value = "";
		return false
	}
	fetch("deleteCheck.do", {
		method: "POST",
		headers: {
			"Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
		}
	
	})
	form.submit();
}
</script>
</html>