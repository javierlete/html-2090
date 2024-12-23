package ipartube.controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ipartube.modelos.Video;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/buscar")
public class BuscarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Recoger información de la petición
		String texto = request.getParameter("texto");

//	Convertir información recibida
//	Empaquetar en modelo
//	Ejecutar código de negocio
		String url = "jdbc:sqlite:/Users/javierlete/git/html-2090/JAVA/ipartube/bdd/ipartube.db";
		String sql = "SELECT * FROM videos WHERE titulo LIKE '%" + texto + "%'";

		// SELECT * FROM videos WHERE titulo LIKE '%owner%'

		try {
			// Cargar el driver
			Class.forName("org.sqlite.JDBC");
			try (// Conectar
					Connection con = DriverManager.getConnection(url);
					// Crear sentencia
					Statement st = con.createStatement();
					// Consulta
					ResultSet rs = st.executeQuery(sql)) {
				// Si es más de un resultado
				ArrayList<Video> videos = new ArrayList<Video>();
				Video video = null;

				while (rs.next()) {
					video = new Video(rs.getInt("id"), rs.getString("titulo"), rs.getString("descripcion"),
							rs.getString("url"));
					// Si es más de un resultado
					videos.add(video);
				}
				// Botón derecho desde Connection / Surround With / try-with-resources
				// Empaquetar información para la siguiente vista
				request.setAttribute("videos", videos);

				// Pasar a la siguiente vista
				request.getRequestDispatcher("index.jsp").forward(request, response);
				// response.sendRedirect("rutaControlador")
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
