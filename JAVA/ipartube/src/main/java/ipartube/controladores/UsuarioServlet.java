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

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sId = request.getParameter("id");

		Integer id = Integer.parseInt(sId);

		String sql = "SELECT * FROM usuarios WHERE id=" + id;

		Usuario usuarioSeleccionado = null;

		try (Connection con = BaseDeDatos.conectar(); ResultSet rs = BaseDeDatos.consultar(con, sql)) {
			if (rs.next()) {
				usuarioSeleccionado = new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("email"),
						rs.getString("password"), rs.getString("rol"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}

		request.setAttribute("usuarioSeleccionado", usuarioSeleccionado);

		String sqlVideos = "SELECT * FROM videos WHERE id_usuario=" + id;

		ArrayList<Video> videos = new ArrayList<Video>();

		try (Connection con = BaseDeDatos.conectar(); ResultSet rs = BaseDeDatos.consultar(con, sqlVideos)) {

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

		request.getRequestDispatcher("usuario.jsp").forward(request, response);
	}
}
