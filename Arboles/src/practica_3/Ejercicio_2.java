package practica_3;

import java.util.Random;

import tp03.ejercicio1.ArbolBinario;

public class Ejercicio_2 {

	public static void main(String[] args) {
		Random r = new Random();
		ArbolBinario<Integer> abb = new ArbolBinario<>();
		
		for (int i = 0; i < 30; i++) {
			abb.agregarOrdenado(r.nextInt(100));
		}
		
		System.out.println("La raiz del arbol es: " + abb.toString() + ".");
		
		System.out.println(" ");
		System.out.println("El arbol en pre-orden.");
		abb.preOrden();
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("El arbol en in-orden.");
		abb.inOrden();
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("El arbol en post-orden.");
		abb.postOrden();
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("El arbol en recorrido por niveles");
		abb.recorridoPorNiveles();
		
		System.out.println(" ");
		System.out.println(" ");
		int n = 2, m = 4;
		System.out.println("El arbol entre " + n + " y " + m);
		abb.entreNiveles(n, m);
		
		System.out.println(" ");
		System.out.println("La altura del arbol es: " + abb.altura());

		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Cantidad de hojas del arbol.");
		System.out.println(abb.contarHojas());

		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Arbol en espejo imprimiendo in-orden");
		ArbolBinario<Integer> arbolEspejo = abb.espejo();
		arbolEspejo.inOrden();
	}

}
