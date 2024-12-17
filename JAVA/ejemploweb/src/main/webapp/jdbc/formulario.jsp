<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/cabecera.jsp"%>
<%
if (request.getMethod().equals("POST")) {
	String marca = request.getParameter("marca");
	String modelo = request.getParameter("modelo");
	int diagonal = Integer.parseInt(request.getParameter("diagonal"));
	int ancho = Integer.parseInt(request.getParameter("ancho"));
	int alto = Integer.parseInt(request.getParameter("alto"));

	String sql = String.format(sqlInsert, marca, modelo, diagonal, ancho, alto);

	st.executeUpdate(sql);

	response.sendRedirect("listado.jsp");
	return;
}

String editar = request.getParameter("editar");

if (editar != null) {
	rs = st.executeQuery(sqlSelectId + editar);

	rs.next();
} else {
	rs = null;
}
%>


<form method="post">
	<input name="marca" placeholder="Marca"
		value="<%=valor("marca")%>"> <input
		name="modelo" placeholder="Modelo"
		value="<%=valor("modelo")%>"> <input
		name="diagonal" placeholder="Diagonal"
		value="<%=valor("diagonal")%>"> <input
		name="ancho" placeholder="Ancho"
		value="<%=valor("anchoPixels")%>"> <input
		name="alto" placeholder="Alto"
		value="<%=valor("altoPixels")%>">
	<button>Guardar</button>
</form>

<%@ include file="/pie.jsp"%>