package ipartube.controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ipartube.modelos.Video;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
