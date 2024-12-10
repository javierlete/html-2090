package bases;

import java.util.ArrayList;

public class Colecciones {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<>();
		
		al.add("Uno");
		al.add("Tres");
		al.add("Tges");
		al.add("Cuato");
		
		al.add(1, "Dos");
		al.remove("Tges");
		al.set(3, "Cuatro");
		
		System.out.println(al);
		
		System.out.println(al.size());
		
		System.out.println(al.get(2));
		
		for(String dato: al) {
			System.out.println(dato);
		}
	}
}
