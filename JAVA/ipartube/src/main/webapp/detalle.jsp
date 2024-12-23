<%@page import="ipartube.modelos.Video"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/includes/cabecera.jsp"%>
<%
Video video = (Video) request.getAttribute("video");
%>
<main class="container">
	<div class="card">
		<div class="ratio ratio-16x9 card-img-top">
			<iframe src="<%=video.getUrl()%>" title="YouTube video player"
				allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
				referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
		</div>
		<div class="card-body">
			<h5 class="card-title"><%=video.getTitulo()%></h5>
			<p class="card-text"><%=video.getDescripcion()%></p>
		</div>
	</div>
</main>

<%@ include file="/includes/pie.jsp"%>
