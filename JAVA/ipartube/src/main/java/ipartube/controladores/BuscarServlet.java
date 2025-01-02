package ipartube.controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ipartube.modelos.Usuario;
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
		String texto = request.getParameter("texto");

		String sql = "SELECT * FROM videos v JOIN usuarios u ON v.id_usuario = u.id WHERE titulo LIKE '%" + texto
				+ "%'";

		ArrayList<Video> videos = new ArrayList<Video>();

		try (Connection con = BaseDeDatos.conectar(); ResultSet rs = BaseDeDatos.consultar(con, sql)) {
			Video video = null;
			Usuario usuario = null;

			while (rs.next()) {
				usuario = new Usuario(rs.getInt("id_usuario"), rs.getString("nombre"), rs.getString("email"),
						rs.getString("password"), rs.getString("rol"));

				video = new Video(rs.getInt("id"), rs.getString("titulo"), rs.getString("descripcion"),
						rs.getString("url"));
				
				video.setUsuario(usuario);

				videos.add(video);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}

		request.setAttribute("videos", videos);
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}
