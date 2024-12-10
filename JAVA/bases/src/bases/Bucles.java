package bases;

public class Bucles {
	public static void main(String[] args) {
		int c = 1;

		while (c <= 5) {
			System.out.print(c);

			c++;
		}

		c = 1;

		do {
			System.out.print(c);

			c++;
		} while (!(c > 5));

		for (c = 1; c <= 5; c++) {
			System.out.print(c);
		}
	}
}
