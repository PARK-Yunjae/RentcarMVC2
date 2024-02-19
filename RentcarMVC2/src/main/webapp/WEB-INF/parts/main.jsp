<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css" />
<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<script type="text/javascript" src="${ctx }/js/main.js" defer></script>
<link rel="stylesheet" href="${ctx }/css/main.css">
<main>
	<div class="myslider">
		<c:forEach var="list" items="${list}"> 
			<div class="card">
				<div class="image">
					<img src="img/${list.img }" alt="이미지">
				</div>
				<div class="cover">
						${list.name }<br>${list.price }
				</div>
			</div>
		</c:forEach>
	</div>
</main>
<%@ include file="../parts/footer.jsp"%>