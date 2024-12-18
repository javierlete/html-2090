<%@page import="modelos.Monitor"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/vistas/includes/cabecera.jsp"%>

<%
@SuppressWarnings("unchecked")
ArrayList<Monitor> monitores = (ArrayList<Monitor>) request.getAttribute("monitores");
%>

<table>
	<thead>
		<tr>
			<th>Id</th>
			<th>Marca</th>
			<th>Modelo</th>
			<th>Diagonal</th>
			<th>Ancho en pixels</th>
			<th>Alto en pixels</th>
		</tr>
	</thead>
	<tbody>
		<% for(Monitor monitor: monitores) { %>
			<tr>
				<td><%=monitor.getId() %></td>
				<td><%=monitor.getMarca() %></td>
				<td><%=monitor.getModelo() %></td>
				<td><%=monitor.getDiagonalPulgadas() %></td>
				<td><%=monitor.getAnchoPixels() %></td>
				<td><%=monitor.getAltoPixels() %></td>
			</tr>
		<% } %>
	</tbody>
</table>

<%@ include file="/vistas/includes/pie.jsp"%>