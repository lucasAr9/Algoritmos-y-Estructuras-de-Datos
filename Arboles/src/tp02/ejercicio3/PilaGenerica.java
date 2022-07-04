package tp02.ejercicio3;

import tp02.ejercicio2.*;

public class PilaGenerica<T> {

	private ListaGenerica<T> lista;

	public PilaGenerica(ListaGenerica<T> lista) {
		this.lista = lista;
	}

	public PilaGenerica() {

	}

	public void apilar(T elem) {
		lista.agregarInicio(elem);
	}

	public T desapilar() {
		T elem = lista.elemento(1);
		lista.eliminarEn(1);
		return elem;
	}

	public T tope() {
		return lista.elemento(1);
	}

	public boolean esVacia() {
		return lista.esVacia();
	}

}
