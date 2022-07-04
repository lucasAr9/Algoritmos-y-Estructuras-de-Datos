package practica_2;

import java.util.Random;

import tp02.ejercicio1.*;

public class TestListaDeEnterosEnlazada {

	public static void alReves(ListaDeEnterosEnlazada lis, int i) {
		if (lis.elemento(i) != null) {
			System.out.print(lis.elemento(i) + ", ");
			i--;
			TestListaDeEnterosEnlazada.alReves(lis, i);
		}
	}

	public static void imprimirInverso(ListaDeEnterosEnlazada l) {
		if (!l.fin()) {
			int valor = l.proximo();
			imprimirInverso(l);
			System.out.print(valor + ", ");
		} else
			return;
	}

	public static void main(String[] args) {

		Random r = new Random();

		ListaDeEnterosEnlazada lista1 = new ListaDeEnterosEnlazada();
		ListaDeEnterosEnlazada lista2 = new ListaDeEnterosEnlazada();
		for (int i = 0; i < 20; i++) {
			lista1.agregarFinal(r.nextInt(20));
			lista2.agregarEn(i, i);
		}

		// recorrer con el for llamando el metodo proximo()
		System.out.println("");
		System.out.println("Imprimir con el metodo proximo() <---------------");
		System.out.println("lista con los elementos ingresados random");
		lista1.comenzar();
		while (!lista1.fin()) {
			System.out.print(lista1.proximo() + ", ");
		}
		System.out.println("");
		System.out.println("lista con los elementos ingresados con i");
		lista2.comenzar();
		while (!lista2.fin()) {
			System.out.print(lista2.proximo() + ", ");
		}

		// recorrer con el for llamando el metodo elemento()
		System.out.println("");
		System.out.println("");
		System.out.println("Imprimir con el metodo elemento() <--------------");
		System.out.println("lista con los elementos ingresados random");
		for (int i = 1; i < lista1.tamanio() + 1; i++) {
			System.out.print(lista1.elemento(i) + ", ");
		}
		System.out.println("");
		System.out.println("lista con los elementos ingresados con i");
		for (int i = 1; i < lista2.tamanio() + 1; i++) {
			System.out.print(lista2.elemento(i) + ", ");
		}

		System.out.println("");
		System.out.println("");
		System.out.println("Impimir al inverso <-----------------------------");
		System.out.println("lista 1");
		int i = lista1.tamanio();
		TestListaDeEnterosEnlazada.alReves(lista1, i);
		System.out.println("");
		System.out.println("lista 2");
		int i2 = lista2.tamanio();
		TestListaDeEnterosEnlazada.alReves(lista2, i2);

		System.out.println("");
		System.out.println("");
		System.out.println("Otro imprimir inverso <--------------------------");
		System.out.println("lista 1");
		lista1.comenzar();
		TestListaDeEnterosEnlazada.imprimirInverso(lista1);
		System.out.println("");
		System.out.println("lista 2");
		lista2.comenzar();
		TestListaDeEnterosEnlazada.imprimirInverso(lista2);
	}

}
