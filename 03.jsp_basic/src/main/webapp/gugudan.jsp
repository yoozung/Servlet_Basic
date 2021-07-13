<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단</title>
<style type="text/css">
	table, tr, td, th {
		border: solid 1px blue;
		padding: 5px;
	}
</style>
</head>
<body>
<!-- 
	실습 : 테이블을 이용해서 시작단과 종료단을 Query String으로 입력받아서 구구단을 출력 
	url : http://localhost:8070/mms03/gugudan.jsp?startDan=2&endDan=9
	1. html  tag 그대로 사용
	2. 출력내용 expression tag 사용
	3. 제어코드 scriptlet tag 사용
-->	
	
	
<%
	//요청객체 전달 받은 데이터 가져오기
	String sDan = request.getParameter("startDan");
	String eDan = request.getParameter("endDan");
	System.out.println(sDan + ", " + eDan);
	
	// 사용자가 시작단과 종료단을 입력하지 않았을 경우, 오류처리하지 않고 기본 2단 ~ 9단까지 임의로 처리
	int startDan = 2;
	int endDan = 9;
	
	if (sDan != null && eDan != null && sDan.trim().length() > 0 && eDan.trim().length() > 0 ) {
		startDan = Integer.parseInt(sDan);	// NumberFormatException : null, "" 문자열을 숫자로 형변환시에 발생하는 예외
		endDan = Integer.parseInt(eDan);
	}
	
	//int startDan = Integer.parseInt(request.getParameter("startDan"));
	//int endDan = Integer.parseInt(request.getParameter("endDan"));
	System.out.println(startDan + ", " + endDan);	
%>
<h3>구구단</h3>
<table>
	<!-- 제목행 -->
	<tr>
		<%
			for(int dan = startDan; dan <= endDan; dan++) {
		%>
			<th><%= dan %>단</th>
		<% 
			}
		 %>
	</tr>
	
	<!-- 구구단 반복수행 -->
		<%
		for(int step = 1; step <= 9; step++) {
		%>
	<tr>
		<%
		for(int dan = startDan; dan <= endDan; dan++) {
		%>
		<td><%= dan %> * <%= step %> = <%= dan * step %></td>
		<%
			}
		 %>
	</tr>
		<%
			}
		 %>
	</table>
	
<h3>1~10까지 출력 및 누적합계</h3>
<ul>
	<%
		int total = 0;
		for (int index = 1; index <= 10; index++) {
			total += index;
	%>
	<li><%= index %></li>
	<%
		}
	%>
</ul>
<h3>total : <%= total %></h3>
</body>
</html>

















