package ipartube.controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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

		String sql = "SELECT * FROM videos WHERE id=" + id;

		Video video = null;

		try (Connection con = BaseDeDatos.conectar(); ResultSet rs = BaseDeDatos.consultar(con, sql)) {
			if (rs.next()) {
				video = new Video(rs.getInt("id"), rs.getString("titulo"), rs.getString("descripcion"),
						rs.getString("url"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}

		request.setAttribute("video", video);
		request.getRequestDispatcher("detalle.jsp").forward(request, response);
	}
}
