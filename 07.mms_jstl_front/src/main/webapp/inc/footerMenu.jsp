<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jstl config -->
<%@ tablib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!-- 조각페이지 : footerMenu.jsp -->
<div class="footer_menu">	
<!-- 요청객체로 부터 parameter year 있으면 year 정보로 출력하고 없으면 2021년으로 조각페이지 구성변경 -->

<c:choose>
	<c:when test="${empty param.year}">
		&copy; 2021 work.com
	</c:when>
	<c:otherwise>
		&copy; ${param.year} work.com
	</c:otherwise>
</c:choose>

<c:if test="${empty param.year}">
	&copy; 2021 work.com
</c:if>

<c:if test="${not empty param.year}">
	&copy; ${param.year} work.com
</c:if>

<%
	if (request.getParameter("year") == null) {
%>
	&copy; 2021 work.com
<%
	} else {
%>
	&copy; <%= request.getParameter("year") %> work.com
<%		
	}
%>
</div>