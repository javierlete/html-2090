package ipartube.controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/admin-borrar")
public class AdminVideoBorrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String email = (String) session.getAttribute("email");

		if (email == null) {
			request.setAttribute("error", "Tienes que loguearte para acceder a administración");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		String sId = request.getParameter("id");

		Integer id = Integer.parseInt(sId);

		String sql = "DELETE FROM videos WHERE id=" + id;

		try (Connection con = BaseDeDatos.conectar()) {
			BaseDeDatos.cambiar(con, sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}

		response.sendRedirect("admin-videos");
	}
}
