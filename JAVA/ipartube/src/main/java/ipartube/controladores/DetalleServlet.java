package ipartube.controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ipartube.modelos.Video;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/detalle")
public class DetalleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Recoger información de la petición
		String sId = request.getParameter("id");

//		Convertir información recibida
		Integer id = Integer.parseInt(sId);

//		Empaquetar en modelo
//	    Video video = new Video(id, null, null, null);

		try {
			// Ejecutar código de negocio
			// Cargar el driver
			Class.forName("org.sqlite.JDBC");

			String url = "jdbc:sqlite:/Users/javierlete/git/html-2090/JAVA/ipartube/bdd/ipartube.db";
			String sql = "SELECT * FROM videos WHERE id=" + id;

			try (// Conectar
					Connection con = DriverManager.getConnection(url);
					// Crear sentencia
					Statement st = con.createStatement();
					// Cambio
					// st.executeUpdate(sql)
					// Consulta
					ResultSet rs = st.executeQuery(sql)) {
				// Si es más de un resultado
				// ArrayList<Clase> clases = new ArrayList<Clase>()
				Video video = null;
				while (rs.next()) {
					video = new Video(rs.getInt("id"), rs.getString("titulo"), rs.getString("descripcion"),
							rs.getString("url"));
					// Si es más de un resultado
					// clases.add(objeto)
				}
				// Botón derecho desde Connection / Surround With / try-with-resources
				// Empaquetar información para la siguiente vista
				request.setAttribute("video", video);
				
				// Pasar a la siguiente vista
				request.getRequestDispatcher("detalle.jsp").forward(request, response);
				// response.sendRedirect("rutaControlador")
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
