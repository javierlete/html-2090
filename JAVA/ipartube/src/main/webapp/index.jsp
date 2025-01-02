<%@page import="ipartube.modelos.Video"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/includes/cabecera.jsp"%>
<%
@SuppressWarnings("unchecked")
ArrayList<Video> videos = (ArrayList<Video>) request.getAttribute("videos");
%>
<main class="container">
	<div class="row row-cols-1 row-cols-md-3 g-4">
		<%
		for (Video video : videos) {
		%>
		<div class="col">
			<div class="card h-100">
				<div class="card-body">
					<h5 class="card-title">
						<a href="detalle?id=<%=video.getId()%>"><%=video.getTitulo()%></a>
					</h5>
					<p class="card-text"><%=video.getUsuario().getNombre()%></p>
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
		<%
		}
		%>
		<%
		if (usuario != null) {
		%>
		<div class="col">
			<div class="card h-100">
				<form action="index" method="post" class="card-body">
					<h5 class="card-title">
						<input class="form-control" name="titulo"
							placeholder="Título para el nuevo vídeo">
					</h5>
					<p class="card-text"><%=usuario.getNombre()%></p>
					<div class="card-text">
						<input class="form-control" name="url"
							placeholder="URL del nuevo video">
					</div>
					<p class="card-text">
						<textarea class="form-control" name="descripcion"
							placeholder="Descripción del nuevo video"></textarea>
					</p>
					<button class="btn btn-secondary">Guardar</button>
				</form>
			</div>
		</div>
		<%
		}
		%>
	</div>
</main>

<%@ include file="/includes/pie.jsp"%>
