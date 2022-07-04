package practica_2;

import tp02.ejercicio2.*;

import java.util.Random;

public class TestListaEnlazadaGenerica {

	public static String nombresRandom() {
		Random r = new Random();
		String nombre;
		int num = r.nextInt(6);

		nombre = switch (num) {
			case 1 -> "Mica";
			case 2 -> "Juan";
			case 3 -> "Hernan";
			case 4 -> "Jose";
			default -> "Ricardo";
		};
		return nombre;
	}

	public static String apellidoRandom() {
		Random r = new Random();
		String nombre;
		int num = r.nextInt(6);

		nombre = switch (num) {
			case 1 -> "Perez";
			case 2 -> "Garmendia";
			case 3 -> "Gonzales";
			case 4 -> "Vivaldi";
			default -> "Ford";
		};
		return nombre;
	}

	public static void main(String[] args) {

		Random r = new Random();

		// crear los estudiantes y acregarlos a la lista con agregarFinal();
		ListaEnlazadaGenerica<Estudiante> estu = new ListaEnlazadaGenerica<Estudiante>();
		for (int i = 0; i < 10; i++) {
			String nombre = TestListaEnlazadaGenerica.nombresRandom();
			String ape = TestListaEnlazadaGenerica.apellidoRandom();
			String email = nombre + ape + "@gmail.com";
			int comision = r.nextInt(8);
			String direc = "una calle de LP";

			Estudiante e = new Estudiante(nombre, ape, email, comision, direc);
			estu.agregarFinal(e);
		}
		// imprime la lista con los estudiantes
		estu.comenzar();
		for (int i = 1; i < estu.tamanio(); i++) {
			System.out.println(estu.elemento(i).toString());
		}

		System.out.println("");

		// crear un arreglo para usar el metodo de agregarArray(T[] elem);
		Estudiante[] estuArre = new Estudiante[10];
		for (int i = 0; i < 10; i++) {
			String nombre = TestListaEnlazadaGenerica.nombresRandom();
			String ape = TestListaEnlazadaGenerica.apellidoRandom();
			String email = nombre + ape + "@gmail.com";
			int comision = r.nextInt(8);
			String direc = "una calle de LP";

			Estudiante e = new Estudiante(nombre, ape, email, comision, direc);
			estuArre[i] = e;
		}
		// agrego un estudiante por fuera del arreglo a la lista
		String nombre = TestListaEnlazadaGenerica.nombresRandom();
		String ape = TestListaEnlazadaGenerica.apellidoRandom();
		String email = nombre + ape + "@gmail.com";
		int comision = r.nextInt(8);
		String direc = "una calle de LP";
		Estudiante e = new Estudiante(nombre, ape, email, comision, direc);

		// pasar el arreglo como parametro al metodo que lo agrega a la lista
		ListaEnlazadaGenerica<Estudiante> estu2 = new ListaEnlazadaGenerica<Estudiante>();
		estu2.agregarInicio(e);
		estu2.agregarArray(estuArre);

		// imprime el arreglo
		System.out.println("");
		System.out.println("Imprime el arreglo");
		for (Estudiante estudiante : estuArre) {
			System.out.println(estudiante);
		}

		// imprime la lista con los elementos de arreglo agregado
		System.out.println("");
		System.out.println("Imprime la lista con los elementos de arreglo");
		estu2.comenzar();
		while (!estu2.fin()) {
			System.out.println(estu2.proximo().toString());
		}
	}

}
