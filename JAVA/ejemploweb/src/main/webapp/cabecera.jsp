<%@ page
	import="java.sql.*,pojos.Almacen,pojos.Monitor,pojos.Globales"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!ResultSet rs;

	String valor(String campo) {
		try {
			if (rs != null) {
				return rs.getString(campo);
			} else {
				return "";
			}
		} catch (SQLException e) {
			return null;
		}
	}%>
<%
Almacen almacen = Globales.almacen;

Class.forName("org.sqlite.JDBC");

String url = "jdbc:sqlite:/Users/javierlete/git/html-2090/JAVA/bases/bdd/almacen.db";
String user = "";
String pass = "";

String sqlSelect = "SELECT * FROM monitores";
String sqlSelectId = sqlSelect + " WHERE id=";
String sqlInsert = "INSERT INTO monitores (marca, modelo, diagonal, anchoPixels, altoPixels) VALUES ('%s', '%s', %s, %s, %s);";
String sqlUpdate = "UPDATE monitores SET marca='%s',modelo='%s',diagonal=%s,anchoPixels=%s,altoPixels=%s WHERE id=%s";
String sqlDelete = "DELETE FROM monitores WHERE id=";

Connection con = DriverManager.getConnection(url, user, pass);
Statement st = con.createStatement();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejemplo Web</title>
</head>
<body>
	<header>
		<h1>Ejemplos de JSP</h1>
	</header>