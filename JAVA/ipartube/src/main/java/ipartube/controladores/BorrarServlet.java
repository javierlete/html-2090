package ipartube.controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import ipartube.modelos.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/borrar")
public class BorrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Usuario usuario = (Usuario)session.getAttribute("usuario");
		
		if(usuario == null) {
			response.sendRedirect("login");
			return;
		}
		
		String sId = request.getParameter("id");

		Integer id = Integer.parseInt(sId);

		String sql = "DELETE FROM videos WHERE id=" + id + " AND id_usuario = " + usuario.getId();

		try (Connection con = BaseDeDatos.conectar()) {
			BaseDeDatos.cambiar(con, sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}

		response.sendRedirect("usuario?id=" + usuario.getId());
	}
}
