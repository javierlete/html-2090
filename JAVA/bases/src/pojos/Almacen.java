package pojos;

import java.util.ArrayList;

// Clase
public class Almacen {
	// Variables de instancia
	private String nombre;
	
	private ArrayList<Monitor> monitores = new ArrayList<>();

	// Constructores
	public Almacen(String nombre) {
		super();
		this.nombre = nombre;
	}

	// Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Monitor> getMonitores() {
		return monitores;
	}

	public void setMonitores(ArrayList<Monitor> monitores) {
		this.monitores = monitores;
	}

	// Métodos de instancia
	public void guardarMonitor(Monitor monitor) {
		if(monitor == null) {
			throw new IllegalArgumentException("No se admiten monitores nulos");
		}
		
		monitores.add(monitor);
	}
	
	public void listadoMonitores() {
		for(Monitor m: monitores) {
			System.out.println(m);
		}
	}
	
	public int cuantosMonitores() {
		return monitores.size();
	}
	
	public double mediaPulgadas() {
		int total = 0;
		
		for(Monitor m: monitores) {
			total += m.getDiagonalPulgadas();
		}
		
		return total / cuantosMonitores();
	}
	
	// toString
	@Override
	public String toString() {
		return "Almacen [nombre=" + nombre + ", monitores=" + monitores + "]";
	}
}
