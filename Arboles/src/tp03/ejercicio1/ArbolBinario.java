package tp03.ejercicio1;

import tp02.ejercicio2.*;
import tp02.ejercicio3.*;

public class ArbolBinario<T extends Comparable<T>> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;
	private ArbolBinario<T> hijoDerecho;

	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	/*
	 * agregar al arbol
	 * */
	public void agregarOrdenado(T elem) {
		if (getDato() == null)
			setDato(elem);
		else
			this.agregar(elem, this);
	}

	private void agregar(T elem, ArbolBinario<T> abb) {
		if (elem.compareTo(abb.getDato()) < 0) {
			if (!abb.tieneHijoIzquierdo())
				abb.agregarHijoIzquierdo(new ArbolBinario<>(elem));
			else
				this.agregar(elem, abb.getHijoIzquierdo());
			
		} else if (elem.compareTo(abb.getDato()) > 0) {
			if (!abb.tieneHijoDerecho())
				abb.agregarHijoDerecho(new ArbolBinario<>(elem));
			else
				this.agregar(elem, abb.getHijoDerecho());
		}
	}
	
	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	/*
	 * preguntar si tiene hijos
	 * */
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo != null;
	}
	
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho != null;
	}
	
	/*
	 * Preguntar si tiene hijos antes de invocar si getHijoIzquierdo()
	 * */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;
	}

	/*
	 * eliminar un hijo del arbol
	 * */
	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	/*
	 * preguntar si es vacio el arbol o si estamos posicionados en una hoja
	 * */
	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());
	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	/*
	 * recorridos del arbol
	 * */
	public void preOrden() {
		System.out.print(getDato() + ", ");

		if (tieneHijoIzquierdo())
			getHijoIzquierdo().preOrden();

		if (tieneHijoDerecho())
			getHijoDerecho().preOrden();
	}
	
	public void inOrden() {
		if (tieneHijoIzquierdo())
			getHijoIzquierdo().inOrden();
		
		System.out.print(getDato() + ", ");
		
		if (tieneHijoDerecho())
			getHijoDerecho().inOrden();
	}
	
	public void postOrden() {
		if (tieneHijoIzquierdo())
			getHijoIzquierdo().postOrden();
		
		if (tieneHijoDerecho())
			getHijoDerecho().postOrden();
			
		System.out.print(getDato() + ", ");
	}
	
	public void recorridoPorNiveles() {
		ArbolBinario<T> arbolNivel;
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<>(new ListaEnlazadaGenerica<>());
		
		cola.encolar(this);
		cola.encolar(null);
		int nroNivel = 0;
		System.out.print("Nivel nro: " + nroNivel + " --> ");
		
		while (!cola.esVacia()) {
			arbolNivel = cola.desencolar();

			if (arbolNivel != null) {
				System.out.print(arbolNivel.getDato() + ", ");

				if (arbolNivel.tieneHijoIzquierdo())
					cola.encolar(arbolNivel.getHijoIzquierdo());
				if (arbolNivel.tieneHijoDerecho())
					cola.encolar(arbolNivel.getHijoDerecho());
				
			} else if (!cola.esVacia()) {
				System.out.println();
				cola.encolar(null);
				nroNivel++;
				System.out.print("Nivel nro: " + nroNivel + " --> ");
			}
		}
	}
	
	/*
	 * entre niveles
	 * */
	public void entreNiveles(int n, int m) {
		ArbolBinario<T> arbolNivel;
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<>(new ListaEnlazadaGenerica<>());

		cola.encolar(this);
		cola.encolar(null);
		int nroNivel = 0;
		
		while (!cola.esVacia() && nroNivel <= m) {
			arbolNivel = cola.desencolar();
			
			if (arbolNivel != null) {
				if (nroNivel >= n)
					System.out.print(arbolNivel.getDato() + ", ");

				if (arbolNivel.tieneHijoIzquierdo())
					cola.encolar(arbolNivel.getHijoIzquierdo());
				if (arbolNivel.tieneHijoDerecho())
					cola.encolar(arbolNivel.getHijoDerecho());
				
			} else if (!cola.esVacia()) {
				System.out.println();
				cola.encolar(null);
				nroNivel++;
			}
		}
	}
	
	/*
	 * altura del arbol
	 * */
	public int altura() {
		if (this.esVacio())
			return -1;
		
		int alto = -1;
		
		if (this.esHoja()) {
			return 0;
		} else {
			if (this.tieneHijoIzquierdo())
				alto = Math.max(alto, this.getHijoIzquierdo().altura());
			
			if (this.tieneHijoDerecho())
				alto = Math.max(alto, this.getHijoDerecho().altura());
		}
		return alto + 1;
	}
	
	/*
	 * contar las hojas del arbol
	 * */
	public int contarHojas() {
		int cant = 0;
		
		if (esHoja()) {
			cant = 1;
		} else {
			if (this.tieneHijoIzquierdo())
				cant = cant + this.getHijoIzquierdo().contarHojas();
			if (this.tieneHijoDerecho())
				cant = cant + this.getHijoDerecho().contarHojas();
		}
		return cant;
	}
	
	/*
	 * invertir el orden del arbol
	 * */
	public ArbolBinario<T> espejo() {
		ArbolBinario<T> abbEspejo = new ArbolBinario<>(this.getDato());
		
		if (this.tieneHijoIzquierdo())
			abbEspejo.agregarHijoDerecho(this.getHijoIzquierdo().espejo());
		
		if (this.tieneHijoDerecho())
			abbEspejo.agregarHijoIzquierdo(this.getHijoDerecho().espejo());
		
		return abbEspejo;
	}

	/*
	* saber si el arbol binario es lleno
	* */
	public boolean lleno() {
		ArbolBinario<T> arbol;
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<>(new ListaEnlazadaGenerica<>());
		boolean lleno = true;

		cola.encolar(this);
		int cant_nodos = 0;
		cola.encolar(null);
		int nivel = 0;

		while (!cola.esVacia() && lleno) {
			arbol = cola.desencolar();
			if (arbol != null) {
				System.out.println(arbol.getDato());
				if (arbol.tieneHijoIzquierdo()) {
					cola.encolar(arbol.getHijoIzquierdo());
					cant_nodos++;
				}
				if (arbol.tieneHijoDerecho()) {
					cola.encolar(arbol.getHijoDerecho());
					cant_nodos++;
				}
			} else if (!cola.esVacia()) {
				if (cant_nodos == Math.pow(2, ++nivel)) {
					cola.encolar(null);
					cant_nodos = 0;
					System.out.println();
				} else lleno = false;
			}
		}
		return lleno;
	}
}
