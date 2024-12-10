package bases;

import java.util.Scanner;

public class Prueba {
	public static void main(String[] args) {
		/*
		 * Este programa demuestra las capacidades básicas de Java
		 */

		String nombre = "Javier"; // Declaramos la variable nombre de tipo String y la inicializamos al texto
									// Javier

		System.out.println(nombre.toUpperCase().substring(3, nombre.length()));

		int longitudTexto = nombre.length(); // Extraemos la longitud de texto que hay en nombre

		String nombreMayusculas = nombre.toUpperCase(); // Obtenemos el nombre en mayúsculas

		String nombreParcialMayusculas = nombreMayusculas.substring(3, longitudTexto);

		System.out.println(nombreParcialMayusculas);

		int x = 5;
		int y = 5;

		System.out.println(x == y);

		Scanner sc = new Scanner(System.in);

		System.out.print("Dime a: ");
		String a = sc.nextLine();

		System.out.print("Dime b: ");
		String b = sc.nextLine();

		System.out.println(a == b); // Compara si SON EL MISMO OBJETO (Una persona que se llama Francisco Javier)
		System.out.println(a.equals(b)); // Compara si EL CONTENIDO ES EL MISMO (Gemelos que se llaman Francisco y
											// Javier)

//		a = b;
		
		if (a == b) {
			System.out.println("Son el mismo objeto");
		} else {
			System.out.println("NO son el mismo objeto");
		}

		if (a.equals(b)) {
			System.out.println("Son dos objetos idénticos");
		} else {
			System.out.println("NO son dos objetos idénticos");
		}

		sc.close();
	}
}
