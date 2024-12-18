<%@page import="modelos.Monitor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/vistas/includes/cabecera.jsp"%>

<%
Monitor monitor = (Monitor) request.getAttribute("monitor");
%>

<p><%=monitor%></p>

<form action="formulario" method="post">
	<input type="text" id="id" name="id"
		value="<%=monitor != null ? monitor.getId() : ""%>">
	<div>
		<label for="marca">Marca</label> <input id="marca" name="marca" value="<%=monitor != null ? monitor.getMarca() : ""%>">
	</div>
	<div>
		<label for="modelo">Modelo</label> <input id="modelo" name="modelo" value="<%=monitor != null ? monitor.getModelo() : ""%>">
	</div>
	<div>
		<label for="diagonal">Diagonal</label> <input id="diagonal"
			name="diagonal" value="<%=monitor != null ? monitor.getDiagonalPulgadas() : ""%>">
	</div>
	<div>
		<label for="ancho">Ancho</label> <input id="ancho" name="ancho" value="<%=monitor != null ? monitor.getAnchoPixels() : ""%>">
	</div>
	<div>
		<label for="alto">Alto</label> <input id="alto" name="alto" value="<%=monitor != null ? monitor.getAltoPixels() : ""%>">
	</div>

	<div>
		<button>Guardar</button>
	</div>

</form>

<%@ include file="/vistas/includes/pie.jsp"%>