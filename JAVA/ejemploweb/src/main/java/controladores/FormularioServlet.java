package controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Recoger información de la petición
//	    Convertir información recibida
//	    Empaquetar en modelo
//	    Ejecutar código de negocio
//	    Empaquetar información para la siguiente vista
//	    Pasar a la siguiente vista
	    request.getRequestDispatcher("vistas/formulario.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			Class.forName("org.sqlite.JDBC");

			String url = "jdbc:sqlite:/Users/javierlete/git/html-2090/JAVA/bases/bdd/almacen.db";

			String sqlInsert = "INSERT INTO monitores (marca, modelo, diagonal, anchoPixels, altoPixels) VALUES ('%s', '%s', %s, %s, %s)";
			String sqlUpdate = "UPDATE monitores SET marca='%s',modelo='%s',diagonal=%s,anchoPixels=%s,altoPixels=%s WHERE id=%s";

			Connection con = DriverManager.getConnection(url);
			Statement st = con.createStatement();

			String sql;
			
			if(monitor.getId() == null) {
				sql = String.format(sqlInsert, monitor.getMarca(), monitor.getModelo(), monitor.getDiagonalPulgadas(), monitor.getAnchoPixels(), monitor.getAltoPixels());
				st.executeUpdate(sql);
			} else {
				sql = String.format(sqlUpdate, monitor.getMarca(), monitor.getModelo(), monitor.getDiagonalPulgadas(), monitor.getAnchoPixels(), monitor.getAltoPixels(), monitor.getId());
				st.executeUpdate(sql);
			}
			
//	    	Empaquetar información para la siguiente vista

//	    	Pasar a la siguiente vista
			response.sendRedirect("listado");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
