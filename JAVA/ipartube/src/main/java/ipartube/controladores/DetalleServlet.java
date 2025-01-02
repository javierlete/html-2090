package ipartube.controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import ipartube.modelos.Usuario;
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
		String sId = request.getParameter("id");

		Integer id = Integer.parseInt(sId);

		String sql = "SELECT * FROM videos v JOIN usuarios u ON v.id_usuario = u.id WHERE v.id=" + id;

		Video video = null;
		Usuario usuario = null;
		
		try (Connection con = BaseDeDatos.conectar(); ResultSet rs = BaseDeDatos.consultar(con, sql)) {
			if (rs.next()) {
				usuario = new Usuario(rs.getInt("id_usuario"), rs.getString("nombre"), rs.getString("email"), rs.getString("password"), rs.getString("rol"));
				
				video = new Video(rs.getInt("id"), rs.getString("titulo"), rs.getString("descripcion"),
						rs.getString("url"));
				
				video.setUsuario(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}

		request.setAttribute("video", video);
		request.getRequestDispatcher("detalle.jsp").forward(request, response);
	}
}
