package interfaces;

import interfaces.interfacePackage.Volador;

// con coma y agregando mas Interfaces se puede implementar varias Interfaces
public class Pajaro extends Animal implements Volador {

	private String nombre;
	
	// el constructor de la clase Pajaro
	public Pajaro(String nom) {
		this.nombre = nom;
	}
	
	// metodos de la superclace abstracta Animal
	@Override
	public void comer() {
	}

	// metodos de la Interface Volador
	@Override
	public void despegar() {
	}

	@Override
	public String aterrizar() {
		return null;
	}

	@Override
	public Boolean volar() {
		return null;
	}

	/**
	 * getters y setters
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
