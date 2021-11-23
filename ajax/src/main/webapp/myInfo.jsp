<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.work.dto.Member" %>
<!-- jstl config -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 | 회원관리</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
<%@ include file="inc/logoMenu.jsp" %>
<%@ include file="inc/afterTopMenu.jsp" %>

<!-- 로그인 회원의 전용 서비스 페이지 -->
<c:choose>
	<c:when test="${empty memberId || empty grade}">
		<jsp:forward page="result.jsp">
			<jsp:param name="message" value="[오류] 회원전용 서비스입니다. 로그인 후 이용하시기 바랍니다." />
		</jsp:forward>
	</c:when>
	
	<c:otherwise>
		로그인회원: ${memberId}
		<c:choose>
			<c:when test="${grade == 'G'}">[${grade}: 일반회원]</c:when>
			<c:when test="${grade == 'S'}">[${grade}: 우수회원]</c:when>
			<c:when test="${grade == 'A'}">[${grade}: 관리자]</c:when>
		</c:choose>
	</c:otherwise>
</c:choose>

<c:if test="${not empty dto}">
	<h3>내정보</h3>
	<form action="controller?action=myInfoUpdate" method="post">
		<div>아이디</div>
		<input type="text" name="memberId" value="${dto.memberId}" 
			readonly="readonly">
		
		<div>비밀번호</div>
		<input type="password" name="memberPw" value="${dto.memberPw}">
		
		<div>이름</div>
		<input type="text" name="name" value="${dto.name}">
		
		<div>휴대폰</div>
		<input type="text" name="mobile" value="${dto.mobile}">
		
		<div>이메일</div>
		<input type="text" name="email" value="${dto.email}">
		
		<div>가입일</div>
		<input type="text" name="entryDate" value="${dto.entryDate}" readonly="readonly">
		
		<div>등급</div>
		<input type="text" name="grade" value="${dto.grade}" readonly="readonly">
		
		<div>마일리지</div>
		<input type="text" name="mileage" value="${dto.mileage}" readonly="readonly">
		
		<div>담당자</div>
		<input type="text" name="manager" value="${dto.manager}" readonly="readonly">
		
		<div class="btn both">
			<input type="submit" value="내정보변경">
			<input type="reset" value="취소">
		</div>
	</form>
	<hr>
</c:if>

<c:if test="${empty dto}">
	<jsp:forward page="main.jsp">
		<jsp:param value="message" name="내정보 조회 서비스를 먼저 요청하시기 바랍니다."/>
	</jsp:forward>
</c:if>

<%@ include file="inc/footerMenu.jsp" %>
</body>
</html>
