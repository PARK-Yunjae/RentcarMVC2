<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:if test="${empty center}">
	<c:set var="center" value="./parts/center.jsp" />
</c:if>
<c:if test="${!empty center}">
	<c:set var="center" value="${center}" />
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<table>
			<%-- top 부분 --%>
			<tr height="120" align="center">
				<td align="center" width="1000">
					<jsp:include page="./parts/header.jsp" />
				</td>
			</tr>
			<%-- center 부분 --%>
			<tr align="center">
				<td align="center" width="1000">
					<jsp:include page="${center}" />
				</td>
			</tr>
			<%-- bottom 부분 --%>
			<tr height="100" align="center">
				<td align="center" width="1000">
					<jsp:include page="./parts/footer.jsp" />
				</td>
			</tr>
		</table>
	</div>
</body>
</html>