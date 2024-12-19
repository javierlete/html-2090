<%@page import="ipartube.modelos.Video"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/includes/cabecera.jsp"%>
<%
@SuppressWarnings("unchecked")
ArrayList<Video> videos = (ArrayList<Video>) request.getAttribute("videos");
%>
<div class="row row-cols-1 row-cols-md-3 g-4">
	<%
	for (Video video : videos) {
	%>
	<div class="col">
		<div class="card h-100">
			<div class="card-body">
				<h5 class="card-title"><%=video.getTitulo() %></h5>
				<div class="card-text">
					<div class="ratio ratio-16x9">
						<iframe
							src="<%=video.getUrl()%>"
							title="YouTube video player"
							allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
							referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
					</div>
				</div>
				<p class="card-text"><%=video.getDescripcion() %></p>
			</div>
		</div>
	</div>
	<%
	}
	%>
</div>

<%@ include file="/includes/pie.jsp"%>
