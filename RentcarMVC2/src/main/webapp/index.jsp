<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	let contextPath = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	location.href=contextPath+"/main.do";	
</script>

<!-- 
파일 업로드시 server에 context.xml에 추가
<Context allowCasualMultipartParsing="true" path="/">
<Resources cachingAllowed="true" cacheMaxSize="100000" /> 

-->