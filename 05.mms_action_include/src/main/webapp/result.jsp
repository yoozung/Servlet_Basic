<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 사용한 클래스에 대한 지시어 태그 import 선언 -->	
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "java.util.HashMap" %>
<%@ page import = "java.util.Map" %>
<%@ page import = "java.util.Iterator" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과메세지</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
<%@ include file="inc/logoMenu.jsp" %>
<%@ include file="inc/beforeTopMenu.jsp" %>
	<h3>결과메세지</h3>
	<!-- 7. 응답페이지 응답 결과 보여주기 : jsp -->
	<%
	if (request.getParameter("message") != null) {
		// post 요청에 대해서만 한글 인코딩이 수행됨		
		request.setCharacterEncoding("utf-8");
		
		// get 요청시에 한글에 대한 인코딩 설정방법? 다음주에..
	%>
	<%=request.getParameter("message")%>
	<%
		}
	%>
	<%
	if (request.getAttribute("message") != null) {
	%>
	
	<%=request.getAttribute("message")%>
	<%
		}
	%>

	<%
	if (request.getAttribute("errorList") != null) {
		ArrayList<String> errorList = (ArrayList<String>)request.getAttribute("errorList");
	%>
	<hr>
	<h3>오류메세지 목록</h3>
	<ul>
		<%
			// errorList 크기만큼 반복하면서 에러메세지 가져와서 목록데이터로 출력
			for (int index = 0; index < errorList.size(); index++) {
		%>
			<li><%= errorList.get(index) %></li>
		<%
			}
		%>
	</ul>
	<%
	}
	%>

<!-- 실습: 순서있는 목록 출력, key = value 형식으로 출력
	m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=jooda99&logNo=220736715527
	entrySet은 key, value 모두 필요할 때 사용-->
	<%
	if (request.getAttribute("errorMap") != null) {
		HashMap<String, String> errorMap = (HashMap<String, String>)(request.getAttribute("errorMap"));

		%>
	<hr>
	<h3>오류메세지 목록</h3>
	<ol>
		<%
		for(Map.Entry<String,String> map : errorMap.entrySet()){
		%>
		<li><%=map.getKey() %> = <%=map.getValue() %></li>
		<%
			}
		%>
	</ol>
	<%
	}
	%>
<%@ include file="inc/footerMenu.jsp" %>	

</body>
</html>