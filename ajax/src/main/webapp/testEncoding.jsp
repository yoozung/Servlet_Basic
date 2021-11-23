<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.work.util.Utility" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테스트페이지</title>
</head>
<body>
<h3>테스트 한글 인코딩 페이지</h3>
<%
	String httpMethod = request.getMethod();
	if (httpMethod.equals("GET")) {
		String data = request.getParameter("data");
		String convertData = Utility.toKor(data);
		
		System.out.println("GET 입력데이터 : " + data);
		System.out.println("GET 변환데이터 : " + data);
		
		String data2 = request.getParameter("data2");
		System.out.println("GET 입력데이터 : " + data2);
	}
	
	if (httpMethod.equals("POST")) {
		request.setCharacterEncoding("UTF-8");
		String data = request.getParameter("data");
		
		System.out.println("POST 입력데이터 : " + data);
		
		String data2 = request.getParameter("data2");
		System.out.println("POST 입력데이터 : " + data2);
	}
%>
</body>
</html>