<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.work.dto.Member"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 조회</title>
</head>
<body>
<div class="logo_menu">
	<a href="index.jsp"><img src="img/logo.png"></a>
</div>
	로그인회원: <%=session.getAttribute("memberId")%>[ <%=session.getAttribute("grade")%> ]
	<hr>
	<a href="myinfo.jsp">내정보조회</a>
	<a href="logout.jsp">로그아웃</a>
<p>	

<h3>내 정보 조회</h3>
<!-- Controller에서 내정보조회 응답결과 설정 -->
<%
	Member dto1 = new Member("user01", "password01", "홍길동", "ㅁㅁ", "ㅁㅁ", "ㅁㅁ", "G", 1000, null);
	request.setAttribute("dto", dto1);
%>

<!-- Controller에서 설정한 응답결과를 jsp에서 사용하기 -->
<%
	Member dto = (Member)request.getAttribute("dto");
%>
<form action="#" method="post">
	아이디 : <input type="text" name="memberId" readonly="readonly" value="<%= dto.getMemberId()%>"><br>
	비밀번호 : <input type="text" name="memberPw"  value="<%= dto.getMemberPw()%>"><br>
	이름 : <input type="text" name="name"  value="<%= dto.getName()%>"><br>
	
</form>
</body>
</html>