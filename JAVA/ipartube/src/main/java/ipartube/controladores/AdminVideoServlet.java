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
		}
		
		String sqlUsuarios = "SELECT * FROM usuarios";
		
		ArrayList<Usuario> usuarios;
		try (Connection con = BaseDeDatos.conectar();
				ResultSet rs = BaseDeDatos.consultar(con, sqlUsuarios)) {
			usuarios = new ArrayList<Usuario>();
			Usuario usuario = null;
			
			while(rs.next()) {
				usuario = new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("email"), rs.getString("password"), rs.getString("rol"));
				
				usuarios.add(usuario);
			}
			
			request.setAttribute("usuarios", usuarios);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("admin-video.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(!Autorizacion.autorizar(request, response)) {
			return;
		}
		
		String sId = request.getParameter("id");
		String titulo = request.getParameter("titulo");
		String url = request.getParameter("url");
		String descripcion = request.getParameter("descripcion");
		String sIdUsuario = request.getParameter("usuario");

		Integer id = sId.isBlank() ? null : Integer.parseInt(sId);
		Integer idUsuario = sIdUsuario.isBlank() ? null : Integer.parseInt(sIdUsuario);

		String sql;

		if (id == null) {
			String patron = "INSERT INTO videos (titulo, descripcion, url, id_usuario) VALUES ('%s', '%s', '%s', %s)";
			sql = String.format(patron, titulo, descripcion, url, idUsuario);
		} else {
			String patron = "UPDATE videos SET titulo='%s', descripcion='%s', url='%s', id_usuario=%s WHERE id=%s";
			sql = String.format(patron, titulo, descripcion, url, idUsuario, id);
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
