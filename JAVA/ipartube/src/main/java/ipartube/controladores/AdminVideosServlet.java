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
import jakarta.servlet.http.HttpSession;

@WebServlet("/admin-videos")
public class AdminVideosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Usuario usuario = (Usuario) session.getAttribute("usuario");

		if (usuario == null || !"ADMIN".equals(usuario.getRol())) {
			request.setAttribute("error", "Tienes que loguearte para acceder a administración");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		String sql = "SELECT * FROM videos";

		ArrayList<Video> videos = new ArrayList<Video>();

		try (Connection con = BaseDeDatos.conectar(); ResultSet rs = BaseDeDatos.consultar(con, sql)) {

			Video video;

			while (rs.next()) {
				video = new Video(rs.getInt("id"), rs.getString("titulo"), rs.getString("descripcion"),
						rs.getString("url"));
				videos.add(video);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}

		request.setAttribute("videos", videos);
		request.getRequestDispatcher("admin-videos.jsp").forward(request, response);
	}
}
