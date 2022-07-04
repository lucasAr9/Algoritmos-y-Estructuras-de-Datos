package punto_1;

public class DesdeHasta {

	public static void conFor(int a, int b) {
		for (int i = a; i <= b; i++) {
			System.out.print(i + ", ");
		}
		System.out.println("");
	}

	public static void conWhile(int a, int b) {
		while (a <= b) {
			System.out.print(a + ", ");
			a++;
		}
		System.out.println("");
	}
	
	public static void sinNinguno(int a, int b) {
		if (a <= b) {
			System.out.print(a + ", ");
			a++;
			DesdeHasta.sinNinguno(a, b);
		}
		System.out.println("");
	}
}
