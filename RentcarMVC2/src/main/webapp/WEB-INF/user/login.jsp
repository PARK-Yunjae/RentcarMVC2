<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="${ctx}/loginUser.do" method="post">
		<table class="table table-bordered">
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="id" required />
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
					<input type="submit" value="로그인" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>