package bases;

import java.util.Arrays;

public class ArraysEjemplo {
	public static void main(String[] args) {
		int tamano = 5;
		
		Integer[] arreglo = new Integer[tamano];
		
		arreglo[0] = 10;
		arreglo[1] = 20;
		arreglo[2] = 30;
		
		System.out.println(Arrays.toString(arreglo));
		
		System.out.println(arreglo[1]);
		
		System.out.println(arreglo.length);
		
		for(int i = 0; i < arreglo.length; i++) {
			Integer dato = arreglo[i];
			
			System.out.println(dato);
			
			if(dato != null && dato > 10) {
				System.out.println("ESTE ES MAYOR QUE 10");
			}
		}
		
		// "foreach"
		for(Integer dato: arreglo) {
			System.out.println(dato);
			
			if(dato != null && dato > 10) {
				System.out.println("ESTE ES MAYOR QUE 10");
			}
		}
		
		String texto = "asdf,sdfg,fgh,qer,sdfg";
		
		String[] partes = texto.split(",");
		
		System.out.println(Arrays.toString(partes));
	}
}
