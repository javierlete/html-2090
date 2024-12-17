<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/cabecera.jsp"%>

<%
ResultSet rs = st.executeQuery(sqlSelect);

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
</dl>
<%
}
%>

<%@ include file="/pie.jsp"%>