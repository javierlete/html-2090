<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="cabecera.jsp" %>
<%
String nombre = request.getParameter("nombre");
%>

<form method="post">
	<input name="nombre" placeholder="Dime tu nombre" value="<%=nombre%>">
	
	<!-- Comentario de HTML -->
	<%-- Comentario de JSP --%>
	
	<button>Saludar</button>
</form>

<h1>Hola <%=nombre %></h1>

<%@ include file="pie.jsp" %>