<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css">
<title>RentcarMVC2</title>

</head>

<body>
	<header>
		<div class="menu" onclick="location.href='${ctx}/main.do'">메인으로</div>
		<c:if test="${empty log}">
			<div class="menu" onclick="location.href='${ctx}/rentcarList.do'">예약하기</div>
			<div class="menu" onclick="location.href='${ctx}/userJoin.do'">회원가입</div>
			<div class="menu" onclick="location.href='${ctx}/userLogin.do'">로그인</div>
		</c:if>
		<c:if test="${!empty log && loginId ne 'admin'}">
			<div class="menu" onclick="location.href='${ctx}/rentcarList.do'">예약하기</div>
			<div class="menu" onclick="location.href='${ctx}/userInfomation.do?log=${log}'">내정보</div>
			<div class="menu" onclick="location.href='${ctx}/userReservationList.do'">예약확인</div>
			<div class="menu" onclick="location.href='${ctx}/userDelete.do'">회원탈퇴</div>
			<div class="menu" onclick="location.href='${ctx}/userLogout.do'">로그아웃</div>
		</c:if>
		<c:if test="${!empty log && loginId eq 'admin'}">
			<div class="menu" onclick="location.href='${ctx}/userInfomation.do?log=${log}'">회원목록</div>
			<div class="menu" onclick="location.href='${ctx}/rentcarInsert.do'">렌트카 추가</div>
			<div class="menu" onclick="location.href='${ctx}/userLogout.do'">로그아웃</div>
		</c:if>
	</header>
	<hr>