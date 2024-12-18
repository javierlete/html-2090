<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/vistas/includes/cabecera.jsp"%>

<form action="formulario" method="post">
	<input type="hidden" id="id" name="id" value="">
	<div>
		<label for="marca">Marca</label> <input id="marca" name="marca">
	</div>
	<div>
		<label for="modelo">Modelo</label> <input id="modelo" name="modelo">
	</div>
	<div>
		<label for="diagonal">Diagonal</label> <input id="diagonal"
			name="diagonal">
	</div>
	<div>
		<label for="ancho">Ancho</label> <input id="ancho" name="ancho">
	</div>
	<div>
		<label for="alto">Alto</label> <input id="alto" name="alto">
	</div>

	<div>
		<button>Guardar</button>
	</div>

</form>

<%@ include file="/vistas/includes/pie.jsp"%>