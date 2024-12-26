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

	<h1>MANTENIMIENTO VIDEOS</h1>

	<%-- <p><%=videos%></p> --%>

	<table class="table table-bordered table-striped table-hover">
		<thead class="table-dark">
			<tr>
				<th>Id</th>
				<th>Título</th>
				<th>Url</th>
				<th>OPCIONES</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Video video : videos) {
			%>
			<tr>
				<td><%=video.getId()%></td>
				<td><%=video.getTitulo()%></td>
				<td><a target="_blank" href="<%=video.getUrl()%>"><%=video.getUrl()%></a>
				</td>
				<td><a href="admin-video?id=<%=video.getId() %>" class="btn btn-sm btn-primary">Editar</a> <a
					href="admin-borrar?id=<%=video.getId() %>" class="btn btn-sm btn-danger">Borrar</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
		<tfoot class="table-dark">
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="admin-video" class="btn btn-sm btn-primary">Añadir</a></td>
			</tr>
		</tfoot>
	</table>

</main>

<%@ include file="/includes/pie.jsp"%>
