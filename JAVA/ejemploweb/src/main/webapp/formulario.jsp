<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="cabecera.jsp"%>
<%
if (request.getMethod().equals("POST")) {
	String marca = request.getParameter("marca");
	String modelo = request.getParameter("modelo");
	int diagonal = Integer.parseInt(request.getParameter("diagonal"));
	int ancho = Integer.parseInt(request.getParameter("ancho"));
	int alto = Integer.parseInt(request.getParameter("alto"));

	almacen.guardarMonitor(new Monitor(marca, modelo, diagonal, ancho, alto));
	
	response.sendRedirect("listado.jsp");
	return;
}
%>


<form method="post">
	<input name="marca" placeholder="Marca"> <input name="modelo"
		placeholder="Modelo"> <input name="diagonal"
		placeholder="Diagonal"> <input name="ancho"
		placeholder="Ancho"> <input name="alto" placeholder="Alto">
	<button>Guardar</button>
</form>

<%@ include file="pie.jsp"%>