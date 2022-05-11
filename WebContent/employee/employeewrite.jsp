<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/main.css" rel="stylesheet">
<script type="text/javascript"src="js/main.js"></script>
</head>
<body>
<div id="wrap" align="center">
<h1>정보등록</h1>
<form method="post" name="frm" action="employee">
<input type="hidden" name="command" value="employee_write">
<table style="width":600px">
<tr>
<th>아이디</th>
<td><input type="text" name="id" size="60"></td>
</tr>
<tr>
<th>비밀번호</th>
<td><input type="password" name="pass" size="60"></td>
</tr>
<tr>
<th>이름</th>
<td><input type="text" name="name" size="60"></td>
</tr>
<tr>
<th>권한</th>
<td>
<select name="lev">
<option value="A">관리자</option>
<option value="B">일반사원</option>
</select>
</td>
</tr>
<th>성별</th>
<td>
<select name="gender">
<option value="1">남자</option>
<option value="2">여자</option>
</select>
</td>
</tr>
<tr>
<th>전화번호</th>
<td><input type="text" name="phone"></td>
</tr>
</table>
<br>
<input type="submit" value="확인" onclick="return employeeCheck()">
<input type="reset" value="초기화">
<input type="button" value="목록으로" onclick="location.href='employee?command=employees_list'">
</form>

</div>
</body>
</html>