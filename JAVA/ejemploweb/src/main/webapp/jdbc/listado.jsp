<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/cabecera.jsp"%>

<%
String borrar = request.getParameter("borrar");

if (borrar != null) {
	st.executeUpdate(sqlDelete + borrar);
}

rs = st.executeQuery(sqlSelect);
%>

<a href="formulario.jsp">Añadir</a>

<%
while (rs.next()) {
%>
<dl>
	<dt>Marca</dt>
	<dd><%=rs.getString("marca")%></dd>
	<dt>Modelo</dt>
	<dd><%=rs.getString("modelo")%></dd>
	<dt>Diagonal</dt>
	<dd><%=rs.getString("diagonal")%></dd>
	<dt>Ancho en pixels</dt>
	<dd><%=rs.getString("anchoPixels")%></dd>
	<dt>Alto en pixels</dt>
	<dd><%=rs.getString("altoPixels")%></dd>
	<dt>OPCIONES</dt>
	<dd>
		<a href="formulario.jsp?editar=<%=rs.getInt("id")%>">Editar</a> <a
			href="listado.jsp?borrar=<%=rs.getInt("id")%>">Borrar</a>
	</dd>
</dl>
<%
}
%>

<%@ include file="/pie.jsp"%>