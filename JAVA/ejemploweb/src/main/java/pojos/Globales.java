package pojos;

public class Globales {
	public static final Almacen almacen = new Almacen("Pruebas");
	
	static {
		almacen.guardarMonitor(new Monitor());
		almacen.guardarMonitor(new Monitor("HP", "5", 21, 1920, 1080));
	}
}
