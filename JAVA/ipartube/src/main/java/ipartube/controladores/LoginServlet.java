package ipartube.controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import ipartube.modelos.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// RECOGER DATOS DE PETICIÓN
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		String patron = "SELECT * FROM usuarios WHERE email='%s' AND password='%s'";
		String sql = String.format(patron, email, password);

		Usuario usuario;
		try (Connection con = BaseDeDatos.conectar();
				ResultSet rs = BaseDeDatos.consultar(con, sql)) {
			usuario = null;

			if (rs.next()) {
				usuario = new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("email"),
						rs.getString("password"), rs.getString("rol"));
			}

			if (usuario != null) {
				HttpSession session = request.getSession();

				session.setAttribute("usuario", usuario);

				// PASAR A LA VISUALIZACIÓN
				response.sendRedirect("admin-videos");
			} else {
				// ENVIAR OBJETOS PARA VISUALIZACIÓN
				request.setAttribute("error", "El usuario o la contraseña son incorrectos");

				// PASAR A LA VISUALIZACIÓN
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
