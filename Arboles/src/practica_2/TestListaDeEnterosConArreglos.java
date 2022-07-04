package practica_2;

import java.util.Random;

import tp02.ejercicio1.*;

public class TestListaDeEnterosConArreglos {

	public static void alReves(ListaDeEnterosConArreglos lis, int i) {
		if (lis.elemento(i) != null) {
			System.out.print(lis.elemento(i) + ", ");
			i--;
			TestListaDeEnterosConArreglos.alReves(lis, i);
		}
	}

	public static void imprimirInverso(ListaDeEnterosConArreglos l) {
		if (!l.fin()) {
			int valor = l.proximo();
			imprimirInverso(l);
			System.out.print(valor + ", ");
		} else
			return;
	}

	public static void main(String[] args) {

		Random r = new Random();

		ListaDeEnterosConArreglos lis1 = new ListaDeEnterosConArreglos();
		ListaDeEnterosConArreglos lis2 = new ListaDeEnterosConArreglos();
		for (int i = 0; i < 20; i++) {
			lis1.agregarFinal(r.nextInt(20));
			lis2.agregarEn(i, i);
		}

		// recorrer con el for llamando al metodo proximo()
		System.out.println("");
		System.out.println("Imprimir con el metodo proximo() <---------------");
		System.out.println("lista 1 con los elementos ingresados random");
		lis1.comenzar();
		for (int i = 0; i < lis1.tamanio(); i++) {
			System.out.print(lis1.proximo() + ", ");
		}
		System.out.println("");
		System.out.println("lista 2 con los elementos ingresados con i");
		lis2.comenzar();
		for (int i = 0; i < lis2.tamanio(); i++) {
			System.out.print(lis2.proximo() + ", ");
		}

		// recorrer con el for llamando al metodo elemento()
		System.out.println("");
		System.out.println("");
		System.out.println("Imprimir con el metodo elemento() <--------------");
		System.out.println("lista 1 con los elementos ingresados random");
		for (int i = 1; i < lis1.tamanio() + 1; i++) {
			System.out.print(lis1.elemento(i) + ", ");
		}
		System.out.println("");
		System.out.println("lista 2 con los elementos ingresados i");
		for (int i = 1; i < lis2.tamanio() + 1; i++) {
			System.out.print(lis2.elemento(i) + ", ");
		}

		System.out.println("");
		System.out.println("");
		System.out.println("Imprimir al inverso <----------------------------");
		System.out.println("lista 1");
		int i = lis1.tamanio();
		TestListaDeEnterosConArreglos.alReves(lis1, i);
		System.out.println("");
		System.out.println("lista 2");
		int i2 = lis2.tamanio();
		TestListaDeEnterosConArreglos.alReves(lis2, i2);

		System.out.println("");
		System.out.println("");
		System.out.println("Otro imprimir inverso <--------------------------");
		System.out.println("lista 1");
		lis1.comenzar();
		TestListaDeEnterosConArreglos.imprimirInverso(lis1);
		System.out.println("");
		System.out.println("lista 2");
		lis2.comenzar();
		TestListaDeEnterosConArreglos.imprimirInverso(lis2);
	}

}
