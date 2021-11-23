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
<%@ include file="inc/logoMenu.jsp" %>
<%@ include file="inc/afterTopMenu.jsp" %>
	로그인회원: <%=session.getAttribute("memberId")%>[ <%=session.getAttribute("grade")%> ]


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
<form action="myInfoUpdate" method="get">
	<div>아이디</div>
	<input type="text" name="memberId" value="<%= dto.getMemberId()%>" readonly="readonly">
	
	<div>비밀번호</div>
	<input type="password" name="memberPw" value="<%= dto.getMemberPw()%>">
	
	<div>이름</div>
	<input type="text" name="name" value="<%= dto.getName()%>">
	
	<div>휴대폰</div>
	<input type="text" name="mobile" value="<%= dto.getMobile()%>">
		
	<div>이메일</div>
	<input type="text" name="email" value="<%= dto.getEmail()%>">
		
	<div>가입일</div>
	<input type="text" name="entryDate" value="<%= dto.getEntryDate()%>" readonly="readonly">
		
	<div>등급</div>
	<input type="text" name="grade" value="<%= dto.getGrade()%>" readonly="readonly">
		
	<div>마일리지</div>
	<input type="text" name="mileage" value="<%= dto.getMileage()%>" readonly="readonly">
		
	<div>담당자</div>
	<input type="text" name="manager" value="<%= dto.getManager()%>" readonly="readonly">
	
	<input type="submit" name="updatebtn" value="내정보변경">
</form>
</body>
</html>