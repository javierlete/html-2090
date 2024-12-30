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

@WebServlet("/admin-video")
public class AdminVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(!Autorizacion.autorizar(request, response)) {
			return;
		}
		

		String sId = request.getParameter("id");

		if (sId != null) {
			Integer id = Integer.parseInt(sId);

			String sql = "SELECT * FROM videos WHERE id=" + id;

			Video fila = null;

			try (Connection con = BaseDeDatos.conectar(); ResultSet rs = BaseDeDatos.consultar(con, sql);) {
				if (rs.next()) {
					fila = new Video(rs.getInt("id"), rs.getString("titulo"), rs.getString("descripcion"),
							rs.getString("url"));
				}

			} catch (SQLException e) {
				e.printStackTrace();
				return;
			}

			request.setAttribute("video", fila);
		}
		request.getRequestDispatcher("admin-video.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sId = request.getParameter("id");
		String titulo = request.getParameter("titulo");
		String url = request.getParameter("url");
		String descripcion = request.getParameter("descripcion");

		Integer id = sId.isBlank() ? null : Integer.parseInt(sId);

		String sql;

		if (id == null) {
			String patron = "INSERT INTO videos (titulo, descripcion, url) VALUES ('%s', '%s', '%s')";
			sql = String.format(patron, titulo, descripcion, url);
		} else {
			String patron = "UPDATE videos SET titulo='%s', descripcion='%s', url='%s' WHERE id=%s";
			sql = String.format(patron, titulo, descripcion, url, id);
		}

		try (Connection con = BaseDeDatos.conectar();) {
			BaseDeDatos.cambiar(con, sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}

		response.sendRedirect("admin-videos");
	}
}
