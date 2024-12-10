package bases;

public class ArgsEjemplo {
	public static void main(String[] args) {
		if(args.length == 0) {
			System.out.println("No hay argumentos");
		}
		
		for (String dato : args) {
			System.out.println(dato);
		}
	}
}
