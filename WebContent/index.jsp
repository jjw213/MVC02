<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% response.sendRedirect("employee?command=employees_list"); %>
<%--employee=>서블릿요청경로
commend=>파라미터
emplyees_list=>파라미터의값
요청경로 뒤에?가 붙으면 주소에 파라미터를 담아서 보낼수 있음.
--%>