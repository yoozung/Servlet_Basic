<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jstl config -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테스트페이지</title>
</head>
<body>
<form action="testEncoding.jsp" method="get">
	<input type="text" name="data" placeholder="한글 데이터 입력하세요">
	<input type="text" name="data2" placeholder="한글 이름 입력하세요">
	<input type="submit" value="GET 요청">
</form>

<form action="testEncoding.jsp" method="post">
	<input type="text" name="data" placeholder="한글 데이터 입력하세요">
	<input type="text" name="data2" placeholder="한글 이름 입력하세요">
	<input type="submit" value="POST 요청">
</form>
</body>
</html>