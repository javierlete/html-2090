package pojos;

public class AlmacenPrueba {
	public static void main(String[] args) {
		Almacen bilbao = new Almacen("Bilbao");
		
		bilbao.getMonitores().add(new Monitor());
		bilbao.guardarMonitor(new Monitor("HP", "HP12", 19, 1280, 1024));
		
		System.out.println(bilbao);
		
		bilbao.listadoMonitores();
		
		System.out.println(bilbao.cuantosMonitores());
		
		System.out.println(bilbao.mediaPulgadas());
	}
}
