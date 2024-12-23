package ipartube.controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDeDatos {
	public static final String DRIVER = "org.sqlite.JDBC";
	public static final String URL = "jdbc:sqlite:/Users/javierlete/git/html-2090/JAVA/ipartube/bdd/ipartube.db";
	public static final String USER = "";
	public static final String PASS = "";
	
	public static Connection conectar() throws SQLException {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
		return DriverManager.getConnection(URL, USER, PASS);
	}
	
	public static ResultSet consultar(Connection con, String sql) {
		try {
			Statement st = con.createStatement();
			return st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static int cambiar(Connection con, String sql) {
		try {
			Statement st = con.createStatement();
			return st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
