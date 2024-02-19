<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>
<link rel="stylesheet" href="${ctx }/css/rentcarList.css">
<main>
	<div class="listBar">
		<input type="button" value="최신" id=recent>
		<input type="button" value="대형" id=large>
		<input type="button" value="중형" id=medium>
		<input type="button" value="소형" id=small>
	</div>
	<div class="container">
		<c:forEach var="r" items="${list}">
			<div class="rentcar">
				<div class="image">
					<a href="${ctx}/rentcarInfomation.do?no=${r.no}"> 
						<img src="img/${r.img}" alt="이미지" />
						<Strong class="cover">${r.name}</Strong>
					</a>
				</div>
			</div>
		</c:forEach>
	</div>
</main>
<script>
let contextPath = window.location.pathname.substring(0,window.location.pathname.indexOf("/", 2));
		
let recent = document.getElementById("recent");
let large = document.getElementById("large");
let medium = document.getElementById("medium");
let small = document.getElementById("small");

recent.addEventListener("click",  () =>{
	location.href = contextPath + "/rentcarList.do?category=0";
})
large.addEventListener("click",  () =>{
	location.href = contextPath + "/rentcarList.do?category=1";
})
medium.addEventListener("click",  () =>{
	location.href = contextPath + "/rentcarList.do?category=2";
})
small.addEventListener("click",  () =>{
	location.href = contextPath + "/rentcarList.do?category=3";
})
</script>
<%@ include file="../parts/footer.jsp"%>