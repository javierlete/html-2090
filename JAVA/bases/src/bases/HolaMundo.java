package bases;

public class HolaMundo {
	public static void main(String[] args) {
		System.out.println("Hola a todos");
		
		int numero = 6;
		
		System.out.println(numero * 4);
		
		double decimal = 5.6;
		
		System.out.println(decimal * 2);
		
		boolean esLogico = true;
		
		System.out.println(esLogico);
		
		String nombre = "Javier";
		
		System.out.println("Hola " + nombre.toUpperCase());
		
		// Mostrar los tres primeros caracteres de 'nombre'
		System.out.println("Los tres primeros caracteres de 'nombre' son: " + nombre.substring(0, 3));
	}
}
