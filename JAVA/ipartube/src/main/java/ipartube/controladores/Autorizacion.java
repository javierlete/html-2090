package ipartube.controladores;

import java.io.IOException;

import ipartube.modelos.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Autorizacion {
	public static boolean autorizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		Usuario usuario = (Usuario) session.getAttribute("usuario");

		if (usuario == null || !"ADMIN".equals(usuario.getRol())) {
			request.setAttribute("error", "Tienes que loguearte para acceder a administración");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return false;
		}
		
		return true;
	}
}
