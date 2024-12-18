package controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/borrar")
public class BorrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Recoger información de la petición
		String sId = request.getParameter("id");

//	    Convertir información recibida
		Integer id = Integer.parseInt(sId);

//	    Empaquetar en modelo
//	    Ejecutar código de negocio

		try {
			Class.forName("org.sqlite.JDBC");

			String url = "jdbc:sqlite:/Users/javierlete/git/html-2090/JAVA/bases/bdd/almacen.db";

			String sqlDelete = "DELETE FROM monitores WHERE id=" + id;

			try (Connection con = DriverManager.getConnection(url); Statement st = con.createStatement();) {
				st.executeUpdate(sqlDelete);
			}

//		    Pasar a la siguiente vista
			response.sendRedirect("listado");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
