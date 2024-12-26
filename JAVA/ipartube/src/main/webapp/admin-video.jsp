<%@page import="ipartube.modelos.Video"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/includes/cabecera.jsp"%>
<%
Video video = (Video)request.getAttribute("video");
%>

<main class="container">

	<p><%=video %></p>

	<form action="admin-video" method="post">
		<div class="row mb-3">
			<label for="titulo" class="col-sm-2 col-form-label">Título</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="titulo" name="titulo" value="<%=video != null ? video.getTitulo() : "" %>">
			</div>
		</div>

		<div class="row mb-3">
			<label for="url" class="col-sm-2 col-form-label">Url</label>
			<div class="col-sm-10">
				<input type="url" class="form-control" id="url" name="url" value="<%=video != null ? video.getUrl() : ""%>">
			</div>
		</div>

		<div class="row mb-3">
			<label for="descripcion" class="col-sm-2 col-form-label">Descripción</label>
			<div class="col-sm-10">
				<textarea rows="5" class="form-control" id="descripcion" name="descripcion"><%=video != null ? video.getDescripcion() : "" %></textarea>
			</div>
		</div>

		<button type="submit" class="btn btn-primary">Guardar</button>
	</form>
</main>

<%@ include file="/includes/pie.jsp"%>
