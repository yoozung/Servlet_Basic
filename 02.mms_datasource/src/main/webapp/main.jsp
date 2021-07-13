<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>메인페이지</h3>
<!-- 로그인성공하면 보여줄 서비스jsp -->
<!-- 내장객체 리퀘스트이용 -->
<%= request.getAttribute("message") %>
</body>
</html>