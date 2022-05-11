<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원관리 페이지</title>
<link href="css/main.css" rel="stylesheet">
</head>
<body>
	<div id="wrap" align="center">
		<h1>employees list</h1>
		<table class="list">
		<tr>
		<td colspan="6" style="border:white; text-align:right">
		<a href="employee?command=employees_write_form">사원등록</a>
		</td>
		</tr>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>권한</th>
				<th>성별</th>
				<th>전화번호</th>
			</tr>
			<c:forEach items="${elist }" var="employee">
				<tr class="record">
					<td>${employee.id }</td>
					<td><a href="employee?command=employees_view&id=${employee.id }">${employee.name }</a></td>
					
					<td>
					<c:choose>
					<c:when test="${employee.lev=='A' }">
					관리자
					</c:when>
					<c:otherwise>
					일반사원
					</c:otherwise>
					</c:choose></td>
					<td>${employee.gender }</td>
					<td>${employee.phone }</td>
				</tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>