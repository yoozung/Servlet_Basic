<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="com.work.dto.Member" %>   
 <!-- jstl config -->
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원전체조회</title>
<style type="text/css">
 table, tr, th, td {
 	padding: 2px;
 	color: maroon;
 	border-color: lime;
 }
</style>
</head>
<body>
<h3>컨텍스트패스 : ${CONTEXT_PATH}</h3>

<h3>회원전체조회 : Scriptlet tag로 작성</h3>
<!--<%
	ArrayList<Member> listMember = (ArrayList<Member>)request.getAttribute("listMember");
	if (listMember != null) {
	for (int index=0; index < listMember.size(); index++) {
		Member dto = listMember.get(index);
	
%>
<%= dto.getMemberId() %>
<%= dto.getName() %>

<% } } %>-->

<hr>
<h3>회원전체조회 : Scriptlet tag로 작성</h3> 

<c:if test="${not empty requestScope.listMember}">
	<table>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>휴대폰</th>
			<th>이메일</th>
			<th>가입일</th>
			<th>등급</th>
			<th>마일리지</th>
			<th>담당자</th>
		</tr>
		
		<c:forEach var="dto" items="${listMember}">
			<tr>
				<!-- dto참조변수명.멤버변수명으로 쓰면 자기가 알아서 dto.getter() 수행결과 출력 -->
				<!--<td><a href="detail?memberId=${dto.memberId}">${dto.memberId}</a></td>--> 
				<td><a href="controller?action=detail&memberId=${dto.memberId}">${dto.memberId}</a></td> 
				<td>${dto.memberPw}</td>
				<td>${dto.name}</td>
				<td>${dto.mobile}</td>
				<td>${dto.email}</td>
				<td>${dto.entryDate}</td>
				<td>${dto.grade}</td>
				<td>${dto.mileage}</td>
				<td>${dto.manager}</td>
			</tr>
		</c:forEach>
	
	</table>
</c:if>

<c:if test="${empty requestScope.listMember}">
	<h3>등록 회원이 없습니다</h3>
</c:if>


</body>
</html>