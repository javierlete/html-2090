<%@page import="ipartube.modelos.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Usuario usuario = (Usuario) session.getAttribute("usuario");
%>
<!DOCTYPE html>
<html lang="es">
<head>
<title>Ipartube</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>

	<nav class="mb-4 sticky-top navbar navbar-expand-lg bg-dark"
		data-bs-theme="dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="index">Ipartube</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="index">Principal</a></li>
				</ul>
				<form action="buscar" class="d-flex" role="search">
					<input class="form-control me-2" type="search" placeholder="Buscar"
						aria-label="Buscar" name="texto">
					<button class="btn btn-outline-light" type="submit">Buscar</button>
				</form>
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<%
					if (usuario == null) {
					%>
					<li class="nav-item"><a class="nav-link" href="login">Inicio
							sesión</a></li>
					<%
					} else {
					if ("ADMIN".equals(usuario.getRol())) {
					%>
					<li class="nav-item"><a class="nav-link" href="admin-videos">Administración</a></li>
					<%
					}
					%>
					<li class="nav-item">
						<a class="nav-link" href="usuario?id=<%=usuario.getId() %>">
							<%=usuario.getNombre()%>
						</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="logout">Cerrar
							sesión</a></li>
					<%
					}
					%>
				</ul>
			</div>
		</div>
	</nav>