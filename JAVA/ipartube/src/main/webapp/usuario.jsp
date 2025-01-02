<%@page import="ipartube.modelos.Video"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/includes/cabecera.jsp"%>
<%
Usuario usuarioSeleccionado = (Usuario) request.getAttribute("usuarioSeleccionado");

@SuppressWarnings("unchecked")
ArrayList<Video> videos = (ArrayList<Video>) request.getAttribute("videos");
%>
<main class="container">
	<h1><%= usuarioSeleccionado.getNombre() %></h1>
	
	<div class="row row-cols-1 row-cols-md-3 g-4">
		<%
		for (Video video : videos) {
		%>
		<div class="col">
			<div class="card h-100">
				<div class="card-body">
					<h5 class="card-title d-flex">
						<a href="detalle?id=<%=video.getId()%>"><%=video.getTitulo()%></a>
						<a class="ms-auto btn btn-danger" href="borrar?id=<%=video.getId() %>">X</a>
					</h5>
					<div class="card-text">
						<div class="ratio ratio-16x9">
							<iframe src="<%=video.getUrl()%>" title="YouTube video player"
								allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
								referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
						</div>
					</div>
					<p class="card-text"><%=video.getDescripcion()%></p>
				</div>
			</div>
		</div>
		<% } %>
	</div>
</main>

<%@ include file="/includes/pie.jsp"%>
