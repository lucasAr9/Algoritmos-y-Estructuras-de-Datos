package punto_2;

import java.util.Scanner;

public class Main {

	public static int[] f(int num) {
		int[] arreglo = new int[num];

		for (int i = 0; i < arreglo.length; i++) {
			arreglo[i] = num * (i + 1);
		}
		return arreglo;
	}
	
	public static void main(String[] args) {
		
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Un numero para encontrar sus multiplos: ");
			
			int num = input.nextInt();
			
			System.out.println("Imprimir directamente con el metodo static");
			for (int elem : Main.f(num)) {
				System.out.print(elem + ", ");
			}
			
			System.out.println(" ");
			System.out.println("Imprimir desp de almacenar en otra variable");
			int[] a = Main.f(num);
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i] + ", ");
			}
			
		} catch (Exception e) {
			System.out.println("Error " + e + " solo ingresar numeros.");
		}
	}
	
}
