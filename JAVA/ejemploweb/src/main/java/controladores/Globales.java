package controladores;

public class Globales {
	public static final String DRIVER = "org.sqlite.JDBC";
	public static final String URL = "jdbc:sqlite:/Users/javierlete/git/html-2090/JAVA/bases/bdd/almacen.db";
	
	public static final String SQL_SELECT = "SELECT * FROM monitores";
	public static final String SQL_SELECT_ID = "SELECT * FROM monitores WHERE id=";

	public static final String SQL_INSERT = "INSERT INTO monitores (marca, modelo, diagonal, anchoPixels, altoPixels) VALUES ('%s', '%s', %s, %s, %s)";
	public static final String SQL_UPDATE = "UPDATE monitores SET marca='%s',modelo='%s',diagonal=%s,anchoPixels=%s,altoPixels=%s WHERE id=%s";
	public static final String SQL_DELETE = "DELETE FROM monitores WHERE id=";
}
