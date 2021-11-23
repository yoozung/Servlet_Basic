<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jstl config -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!-- 조각페이지 : afterTopMenu.jsp : 로그인 후 메뉴 -->
<hr>
<a href="controller?action=myInfo">내정보조회</a>
<a href="controller?action=logout">로그아웃</a>

<!-- 관리자이면 전체회원조회 링크 제공 -->
<c:if test="${grade == 'A'}">
	<span>[관리자 메뉴]</span>
	<a href="controller?action=memberList">전체회원조회</a>
</c:if>