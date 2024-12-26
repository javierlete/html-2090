<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/includes/cabecera.jsp"%>
<%
String error = request.getAttribute("error") != null ? (String) request.getAttribute("error") : "";
%>

<main class="container">
	<form action="login" method="post">
		<div class="row mb-3">
			<label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
			<div class="col-sm-10">
				<input type="email" class="form-control" id="inputEmail3"
					name="email">
			</div>
		</div>
		<div class="row mb-3">
			<label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="inputPassword3"
					name="password">
			</div>
		</div>
		<button type="submit" class="btn btn-primary">Iniciar sesión</button>
		<p class="text-danger"><%=error %></p>
	</form>
</main>

<%@ include file="/includes/pie.jsp"%>
