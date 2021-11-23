<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL/JSTL</title>
</head>
<body>
<h3>EL/JSTL</h3>
<!-- 서버구동시에 loadOnStartup = 1 설정된 서블릿의 컨텍스트패스 정보가져와서 사용하기 -->
<h3>컨텍스트패스 : ${CONTEXT_PATH}</h3>
<!-- <a href="list">회원전체조회</a> -->
<a href="controller?action=list">회원전체조회</a>

</body>
</html>