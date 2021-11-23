<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${contentsTitle}</title>
</head>
<body>
	<h3>${contentsTitle}</h3>
	<c:choose>
		<c:when test="${not empty dto}">
			<form action="controller?action=memberUpdate" method="post">
				<table>
					<tr>
						<td>아이디</td>
						<td><input type="text" name="memberId"
							value="${dto.memberId}" readonly="readonly"></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="memberPw"
							value="${dto.memberPw}"></td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input type="text" name="name" value="${dto.name}"></td>
					</tr>
					<tr>
						<td>휴대폰</td>
						<td><input type="text" name="mobile" value="${dto.mobile}"></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><input type="text" name="email" value="${dto.email}"></td>
					</tr>
					<tr>
						<td>가입일</td>
						<td><input type="text" name="entryDate"
							value="${dto.entryDate}" readonly="readonly"></td>
					</tr>
					<tr>
						<td>등급</td>
						<td><input type="text" name="grade" value="${dto.grade}"
							readonly="readonly"></td>
					</tr>
					<tr>
						<td>마일리지</td>
						<td><input type="text" name="mileage" value="${dto.mileage}"
							readonly="readonly"></td>
					</tr>
					<tr>
						<td>담당자</td>
						<td><input type="text" name="manager" value="${dto.manager}"
							readonly="readonly"></td>
					</tr>
				</table>
				<input type="submit" value="입력">
			</form>
		</c:when>
	</c:choose>

	<c:choose>
		<c:when test="${not empty dto}">
			<ul>
				<li>아이디: ${dto.memberId}</li>
				<li>비밀번호: ${dto.memberPw}</li>
				<li>이름: ${dto.name}</li>
				<li>휴대폰: ${dto.mobile}</li>
				<li>이메일: ${dto.email}</li>
				<li>가입일: ${dto.entryDate}</li>
				<li>등급: ${dto.grade} <c:choose>
						<c:when test="${dto.grade == 'G'}">[일반회원]</c:when>
						<c:when test="${dto.grade == 'S'}">[우수회원]</c:when>
						<c:when test="${dto.grade == 'A'}">[관리자]</c:when>
					</c:choose>
				</li>
				<li>마일리지: ${dto.mileage}</li>
				<li>담당자: ${dto.manager}</li>
			</ul>
		</c:when>
	</c:choose>
	<c:otherwise>
		<h3>해당 회원의 정보가 존재하지 않습니다.</h3>
	</c:otherwise>


</body>
</html>