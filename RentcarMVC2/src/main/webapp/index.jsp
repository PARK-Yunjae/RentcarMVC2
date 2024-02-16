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

궁금해서 찾아본 질문

https://www.egovframe.go.kr/home/qainfo/qainfoRead.do?pagerOffset=20&searchKey=&searchValue=&menuNo=69&qaId=QA_00000000000021849

표준프레임워크에서 multipart에 대한 parsing을 처리하기 위해서는 
egovframework.com.cmm.web.EgovMultipartResolver 클래스를 
context-common.xml에 MultiCommonsMultipartResolver로 등록해야 할 필요가 있습니다.

제공하는 링크에서 전자정부 프레임워크에서의 파일 업로드 기능에 대한 설명을 참조 가능하며
https://www.egovframe.go.kr/wiki/doku.php?id=egovframework:%ED%8C%8C%EC%9D%BC%EA%B4%80%EB%A6%AC

controller에서 MultopartHttpServletRequest 인터페이스에서 제공하는

MultipartFile getfile(String name) 또는 
List<MultipartFile> getFiles(String name) 등의 메서드를 활용하여 파일 정보가 정확히 전달되는지를 확인해 보시기 바랍니다.
-->