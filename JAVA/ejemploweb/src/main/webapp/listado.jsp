<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="cabecera.jsp" %>

<%@page import="pojos.Almacen"%>
<%@page import="pojos.Monitor"%>

<%
Almacen almacen = new Almacen("Pruebas");

almacen.guardarMonitor(new Monitor());
almacen.guardarMonitor(new Monitor("HP", "5", 21, 1920, 1080));
%>

<% for(Monitor monitor: almacen.getMonitores()) { %>
<dl>
	<dt>Marca</dt>
	<dd><%=monitor.getMarca() %></dd>
	<dt>Modelo</dt>
	<dd><%=monitor.getModelo() %></dd>
	<dt>Diagonal</dt>
	<dd><%=monitor.getDiagonalPulgadas() %></dd>
	<dt>Ancho en pixels</dt>
	<dd><%=monitor.getAnchoPixels() %></dd>
	<dt>Alto en pixels</dt>
	<dd><%=monitor.getAltoPixels() %></dd> 
</dl>
<% } %>

<%@ include file="pie.jsp" %>