<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>결과메세지 : forward 이동 성공</h3>
<!-- 7. 응답페이지 응답 결과 보여주기 : jsp -->
<!-- 내장객체 리퀘스트이용 -->
<%= request.getAttribute("message") %>
<hr>
<%= request.getAttribute("errorList") %>
<hr>
<%= request.getAttribute("errorMap") %>

</body>
</html>