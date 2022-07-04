package practica_2;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio3.*;

public class TestPilaYColaGenerica {

	public static void main(String[] args) {

		int[] arre = new int[10];
		for (int i = 0; i < 10; i++) {
			arre[i] = i;
		}

		// probar la cola
		ColaGenerica<Integer> cola = new ColaGenerica<>(new ListaEnlazadaGenerica<>());
		System.out.println("1. Antes de cargar la cola esta vacia? " + cola.esVacia());
		for (int i : arre) {
			cola.encolar(arre[i]);
		}
		System.out.println("2. El tope de la cola antes de desencolar: " + cola.tope());
		System.out.println("3. Despues de cargar la cola esta vacia? " + cola.esVacia());
		System.out.print("4. Desencola toda la cola -> ");
		while (!cola.esVacia()) {
			System.out.print(cola.desencolar() + ", ");
		}
		System.out.println("");
		System.out.println("5. El tope de la cola desp de desencolar: " + cola.tope());
		System.out.println("6. Despues de desencolar esta vacia? " + cola.esVacia());

		System.out.println("");
		System.out.println("");

		// probar la pila
		PilaGenerica<Integer> pila = new PilaGenerica<>(new ListaEnlazadaGenerica<>());
		System.out.println("1. Antes de cargar la pila esta vacia? " + pila.esVacia());
		for (int i : arre) {
			pila.apilar(arre[i]);
		}
		System.out.println("2. El tope de la pila antes de desapilar: " + pila.tope());
		System.out.println("3. Despues de cargar la pila esta vacia? " + pila.esVacia());
		System.out.print("4. Desapilar toda la pila -> ");
		while (!pila.esVacia()) {
			System.out.print(pila.desapilar() + ", ");
		}
		System.out.println("");
		System.out.println("5. El tope de la pila desp de desapilar: " + pila.tope());
		System.out.println("6. Despues de desapilar esta vacia? " + pila.esVacia());
	}

}
