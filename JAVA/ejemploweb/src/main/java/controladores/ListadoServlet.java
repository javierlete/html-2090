package controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Monitor;

@WebServlet("/listado")
public class ListadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Recoger información de la petición
//	    Convertir información recibida
//	    Empaquetar en modelo
//	    Ejecutar código de negocio
		ArrayList<Monitor> monitores = new ArrayList<Monitor>();

		try {
			Class.forName(Globales.DRIVER);
			
			try (Connection con = DriverManager.getConnection(Globales.URL);
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(Globales.SQL_SELECT)) {

				while (rs.next()) {
					Monitor monitor = new Monitor(rs.getInt("id"), rs.getString("marca"), rs.getString("modelo"),
							rs.getInt("diagonal"), rs.getInt("anchoPixels"), rs.getInt("altoPixels"));
					
					monitores.add(monitor);
				}

			}

//	    	Empaquetar información para la siguiente vista
			request.setAttribute("monitores", monitores);

//	    	Pasar a la siguiente vista
	    	request.getRequestDispatcher("vistas/listado.jsp").forward(request, response);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
