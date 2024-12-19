package controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Monitor;

@WebServlet("/formulario")
public class FormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Recoger información de la petición
		String sId = request.getParameter("id");

//	    Convertir información recibida
		Integer id = sId == null ? null : Integer.parseInt(sId);

//	    Empaquetar en modelo
//	    Ejecutar código de negocio

		if (id != null) {
			try {
				Class.forName(Globales.DRIVER);
				
				try (Connection con = DriverManager.getConnection(Globales.URL);
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery(Globales.SQL_SELECT_ID + id)) {
					if (rs.next()) {
						Monitor monitor = new Monitor(rs.getInt("id"), rs.getString("marca"), rs.getString("modelo"),
								rs.getInt("diagonal"), rs.getInt("anchoPixels"), rs.getInt("altoPixels"));

//		    		Empaquetar información para la siguiente vista
						request.setAttribute("monitor", monitor);
					}
				}

			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

//	    Pasar a la siguiente vista
		request.getRequestDispatcher("vistas/formulario.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Recoger información de la petición
		String sId = request.getParameter("id");
		String marca = request.getParameter("marca");
		String modelo = request.getParameter("modelo");
		String sDiagonal = request.getParameter("diagonal");
		String sAncho = request.getParameter("ancho");
		String sAlto = request.getParameter("alto");

//	    Convertir información recibida
		Integer id = sId.isBlank() ? null : Integer.parseInt(sId);
		int diagonal = sDiagonal.isBlank() ? 0 : Integer.parseInt(sDiagonal);
		int ancho = sAncho.isBlank() ? 0 : Integer.parseInt(sAncho);
		int alto = sAlto.isBlank() ? 0 : Integer.parseInt(sAlto);

//	    Empaquetar en modelo
		Monitor monitor = new Monitor(id, marca, modelo, diagonal, ancho, alto);

//	    Ejecutar código de negocio
		try {
			Class.forName(Globales.DRIVER);
			
			try (Connection con = DriverManager.getConnection(Globales.URL); Statement st = con.createStatement()) {
				String sql;

				if (monitor.getId() == null) {
					sql = String.format(Globales.SQL_INSERT, monitor.getMarca(), monitor.getModelo(),
							monitor.getDiagonalPulgadas(), monitor.getAnchoPixels(), monitor.getAltoPixels());
					st.executeUpdate(sql);
				} else {
					sql = String.format(Globales.SQL_UPDATE, monitor.getMarca(), monitor.getModelo(),
							monitor.getDiagonalPulgadas(), monitor.getAnchoPixels(), monitor.getAltoPixels(),
							monitor.getId());
					st.executeUpdate(sql);
				}
			}

//	    	Empaquetar información para la siguiente vista

//	    	Pasar a la siguiente vista
			response.sendRedirect("listado");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
