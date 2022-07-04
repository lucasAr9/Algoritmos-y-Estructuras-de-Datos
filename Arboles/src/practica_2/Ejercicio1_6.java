package practica_2;

import tp02.ejercicio1.*;

public class Ejercicio1_6 {

	public static ListaDeEnterosEnlazada lista;

	public static ListaDeEnterosEnlazada calcularSucesion(int n) {
		lista.agregarFinal(n);
		if (n != 1) {
			if ((n % 2) == 0) {
				n = n / 2;
			} else {
				n = (3 * n) + 1;
			}
			Ejercicio1_6.calcularSucesion(n);
		}

		return lista;
	}

	public static void main(String[] args) {

		int unNumero = 6;
		lista = new ListaDeEnterosEnlazada();
		ListaDeEnterosEnlazada lis = Ejercicio1_6.calcularSucesion(unNumero);
		lista = new ListaDeEnterosEnlazada();
		ListaDeEnterosEnlazada lis2 = Ejercicio1_6.calcularSucesion(unNumero);

		lis.comenzar();
		System.out.println("lista 1");
		for (int i = 1; i < lis.tamanio() + 1; i++) {
			System.out.print(lis.elemento(i) + ", ");
		}
		System.out.println("");
		System.out.println("");
		System.out.println("lista 2");
		for (int i = 1; i < lis2.tamanio() + 1; i++) {
			System.out.print(lis2.elemento(i) + ", ");
		}
	}

}
