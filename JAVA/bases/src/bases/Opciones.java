package bases;

import java.util.Scanner;

public class Opciones {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("¿Qué opción quieres? ");
		int opcion = sc.nextInt();

		switch (opcion) {
		case 1:
			System.out.println("UNO");
			break;
		case 2:
			System.out.println("DOS");
			break;
		case 3:
			System.out.println("TRES");
			break;
		default:
			System.out.println("No conozco esa opción");
		}
		
		sc.close();
	}
}
