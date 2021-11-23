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
	<!-- 로그인회원의 전용 서비스 페이지-->
	<!-- 로그인 사용자 인증 검증-->
	<%
	if (session.getAttribute("memberId") == null || session.getAttribute("grade") == null) {
		request.setAttribute("message", "[오류] 회원전용 서비스입니다. 로그인 후 이용하시기 바랍니다.");
		request.getRequestDispatcher("result.jsp").forward(request, response);
		return;
	}
	%>
	
	로그인회원: <%=session.getAttribute("memberId")%>[ <%=session.getAttribute("grade")%> ]
	<hr>
	<a href="myInfo">내정보조회</a>
	<a href="logout">로그아웃</a>
</body>
</html>