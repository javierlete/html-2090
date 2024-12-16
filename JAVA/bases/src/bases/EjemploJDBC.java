package bases;

import java.sql.*;

public class EjemploJDBC {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:sqlite:bdd/almacen.db";
		String user = "";
		String pass = "";

		String sql_select = "SELECT * FROM monitores";

		Connection con = DriverManager.getConnection(url, user, pass);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql_select);

		while (rs.next()) {
			System.out.printf("%3d %-20s %-20s %5d %5d %5d\n", rs.getInt("id"), rs.getString("marca"),
					rs.getString("modelo"), rs.getInt("diagonal"), rs.getInt("anchoPixels"), rs.getInt("altoPixels"));
		}
	}
}
