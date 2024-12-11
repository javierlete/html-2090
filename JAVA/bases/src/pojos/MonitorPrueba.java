package pojos;

import java.util.ArrayList;

public class MonitorPrueba {
	public static void main(String[] args) {
		Monitor m = new Monitor();
		
		m.setMarca("Packard Bell");
		m.setModelo("A1234");
		m.setDiagonalPulgadas(21);
		m.setAnchoPixels(1920);
		m.setAltoPixels(1080);
		
		System.out.println(m.getMarca());
		
		Monitor hp = new Monitor("Hewlett Packard", "HP1234", 25, 3000, 1500);
		
		System.out.println(hp.getMarca());
		System.out.println(hp.getModelo());
		System.out.println(hp.getDiagonalPulgadas());
		System.out.println(hp.getAnchoPixels());
		System.out.println(hp.getAltoPixels());
		
//		String texto = hp.toString();
//
//		System.out.println(texto);
//		
//		System.out.println(hp.toString());
		
		System.out.println(hp);
		
		ArrayList<Monitor> monitores = new ArrayList<>();
		
		monitores.add(m);
		monitores.add(hp);
		monitores.add(new Monitor());
		monitores.add(new Monitor("Compaq", "Q1234", 32, 1920, 1080));
		
		int total = 0;
		
		for(Monitor monitor: monitores) {
			System.out.println(monitor);
			
			total = total + monitor.getDiagonalPulgadas(); 
		}
		
		double media = total / monitores.size();
		
		System.out.println("La media de pulgadas es " + media);
		
		Monitor m1 = new Monitor();
		Monitor m2 = new Monitor(m1);
		
		m2.setMarca("CAMBIADA");
		
		System.out.println(m1);
		System.out.println(m2);
	}
	
}
