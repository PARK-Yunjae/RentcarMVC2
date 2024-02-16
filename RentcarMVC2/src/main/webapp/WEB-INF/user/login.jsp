<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>
<main>
	<h1>로그인</h1>
	<form action="${ctx}/userLogin.do" method="post">
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
				<td colspan="2">
					<input type="submit" value="로그인" />
				</td>
			</tr>
		</table>
	</form>
</main>
<%@ include file="../parts/footer.jsp"%>