<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>랜트카 리스트</title>
<style>
.container{
	width : 100%;
	margin : auto;
	text-align: center;
}
a{
	display: flex;
	
}

img{
	width: 300px;
  	height: 150px;
	object-fit: cover;
}

.image{
    display:table-cell;
    vertical-align:middle;
}

.rentcar{
    text-align:center;
    display:table;
    border:1px solid #cecece;
    width:400px;
    height:250px;
}

</style>
</head>
<body>
	<div>
		<input type="button" value="최신" id=recent> 
		<input type="button" value="대형" id=large> 
		<input type="button" value="중형" id=medium> 
		<input type="button" value="소형" id=small>
	</div>
	<div class="container">
		<c:forEach var="r" items="${list}">
			<div class="rentcar">
				<div class="image">
					<a href="${ctx}/carInfo.do?no=${r.no}">
						<img src="image/${r.img}" alt="이미지"/>
						<h2>${r.name}</h2 >
					</a>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
<script>
let contextPath = window.location.pathname.substring(0,
		window.location.pathname.indexOf("/", 2));
		
let recent = document.getElementById("recent");
let large = document.getElementById("large");
let medium = document.getElementById("medium");
let small = document.getElementById("small");

recent.addEventListener("click",  () =>{
	location.href = contextPath + "/carList.do?category=0";
})
large.addEventListener("click",  () =>{
	location.href = contextPath + "/carList.do?category=1";
})
medium.addEventListener("click",  () =>{
	location.href = contextPath + "/carList.do?category=2";
})
small.addEventListener("click",  () =>{
	location.href = contextPath + "/carList.do?category=3";
})
</script>
</html>