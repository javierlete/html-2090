<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="cabecera.jsp" %>

<%@ page import="java.time.LocalDate"%>
	<%=LocalDate.now()%>

	<%
	for (int i = 1; i <= 5; i++) {
	%>
	<h1>
		Ejemplo
		<%=i%></h1>
	<%
	}
	%>

<%@ include file="pie.jsp" %>