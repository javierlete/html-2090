package ipartube.controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("org.sqlite.JDBC");
			
			ArrayList<Video> videos;
			try (Connection con = DriverManager.getConnection("jdbc:sqlite:/Users/javierlete/git/html-2090/JAVA/ipartube/bdd/ipartube.db");
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("SELECT * FROM videos")) {
				videos = new ArrayList<Video>();
				Video video;
				
				while(rs.next()) {
					video = new Video(rs.getInt("id"), rs.getString("titulo"), rs.getString("descripcion"), rs.getString("url"));
					videos.add(video);
				}
				
				request.setAttribute("videos", videos);
			}
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
