package interfaces;

import interfaces.interfacePackage.Volador;

public class InterfacesMain {

	public static void main(String[] args) {

//		El mecanismo de upcasting no tiene 
//		en cuenta si Volador es una clase 
//		concreta, abstracta o una interface. 
//		Funciona de la misma manera.
		Volador[] m = new Volador[3];
		m[0] = new Pajaro("unNombre");
//		m[1] = new Helicoptero();
//		m[2] = new Avion();

		for (Volador volador : m) {
//			Polimorfismo: el método despegar()
//			es polimórfico, se comportará de
//			acuerdo al tipo del objeto receptor
			volador.despegar();
		}
	}

}
