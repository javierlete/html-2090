package ipartube.controladores;

import java.io.IOException;

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

		// Hardcoded
		if("javier@email.net".equals(email) && "javier".equals(password)) {
			HttpSession session = request.getSession();
			
			session.setAttribute("email", email);
			
			// PASAR A LA VISUALIZACIÓN
			response.sendRedirect("admin-videos");
		} else {
			// ENVIAR OBJETOS PARA VISUALIZACIÓN
			request.setAttribute("error", "El usuario o la contraseña son incorrectos");
			
			// PASAR A LA VISUALIZACIÓN
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}



	}

}
