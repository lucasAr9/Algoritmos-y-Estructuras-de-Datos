package pasajeDeParametros;

public class pasajes {
	
	public static int variableGlo;
	public static int variableGlo2;
	
	// sin return
	public static void pasarPrimitivo(int num) {
		num = 3;
	}
	
	public static void pasarWrapper(Integer otroN) {
		otroN = 3;
	}
	
	public static void pasarObjeto(ObjetoCualquiera obje) {
		obje.setNumero(3);
	}
	
	public static void pasarVariablesGlobales(int numGlo) {
		numGlo = 3;
	}
	
	// con return
	public static int pasarPrimitivoConReturn(int num) {
		num = 3;
		return num;
	}
	
	public static Integer pasarWrapperConReturn(Integer otroN) {
		otroN = 3;
		return otroN;
	}
	
	public static ObjetoCualquiera pasarObjetoConReturn(ObjetoCualquiera obje) {
		obje.setNumero(3);
		return obje;
	}
	
	public static int pasarVariablesGlobalesConReturn(int numGlo) {
		numGlo = 3;
		return numGlo;
	}

	public static void main(String[] args) {

		/* sin return */
		System.out.println(" ");
		System.out.println("****Pasajes de parametro sin return");
		// pasaje de parametro de variable de tipo primitivo
		int numero = 2;
		pasajes.pasarPrimitivo(numero);
		System.out.println("El resultado de pasar una **variable de tipo"
					+ " PRIMITIVO** numero = 2 y despues hacerle"
					+ " numero = 3 en el metodo static es: " + numero);
		
		// pasaje de parametro de variavle de tipo wrapper int
		Integer otroNum = 2;
		pasajes.pasarWrapper(otroNum);
		System.out.println("El resultado de pasar una **variable de tipo"
					+ " WRAPPER** numero = 2 y despues hacerle"
					+ " numero = 3 en el metodo static es: " + otroNum);
		
		// pasaje de parametro de un objeto
		ObjetoCualquiera oCual = new ObjetoCualquiera();
		oCual.setNumero(2);
		pasajes.pasarObjeto(oCual);
		System.out.println("El resultado de pasar un **OBJETO con v.i. int**"
					+ " numero = 2 y despues hacerle numero = 3"
					+ " en el metodo static es: " + oCual.getNumero());
		
		// pasaje de parametro de una variable de tipo primitiva global
		variableGlo = 2;
		pasajes.pasarVariablesGlobales(variableGlo);
		System.out.println("El resultado de pasar una **variable de tipo"
				+ " PRIMITIVO GLOBAL** numero = 2 y despues hacerle"
				+ " numero = 3 en el metodo static es: " + variableGlo);
		
		/* con return */
		System.out.println(" ");
		System.out.println("****Pasaje de parametro con return");
		// pasaje de parametro de variable de tipo primitivo con return
		int numero2 = 2;
		int numeroReturn = pasajes.pasarPrimitivoConReturn(numero2);
		System.out.println("El resultado de pasar una **variable de tipo"
					+ " PRIMITIVO con RETURN** numero = 2 y despues hacerle"
					+ " numero = 3 en el metodo static es: " + numeroReturn);
		
		// pasaje de parametro de variable de tipo wrapper int con return
		Integer otroNum2 = 2;
		Integer otroNumReturn = pasajes.pasarWrapperConReturn(otroNum2);
		System.out.println("El resultado de pasar una **variable de tipo"
					+ " WRAPPER con RETURN** numero = 2 y despues hacerle"
					+ " numero = 3 en el metodo static es: " + otroNumReturn);
		
		// pasaje de parametro de un objeto con return de un objeto
		ObjetoCualquiera oCual2 = new ObjetoCualquiera();
		oCual2.setNumero(2);
		ObjetoCualquiera oCualReturn = new ObjetoCualquiera();
		oCualReturn = pasajes.pasarObjetoConReturn(oCual2);
		System.out.println("El resultado de pasar un **OBJETO con v.i. int"
					+ " con RETURN** numero = 2 y despues hacerle numero = 3"
					+ " en el metodo static es: " + oCualReturn.getNumero());
		
		// pasaje de parametro de una variable de tipo primit global con return
		variableGlo2 = 2;
		int variable = pasajes.pasarVariablesGlobalesConReturn(variableGlo2);
		System.out.println("El resultado de pasar una **variable de tipo"
				+ " PRIMITIVO GLOBAL con RETURN** numero = 2 y despues hacerle"
				+ " numero = 3 en el metodo static es: " + variable);
	}
	
}
