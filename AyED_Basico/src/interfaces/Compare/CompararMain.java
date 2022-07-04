package interfaces.Compare;

import java.util.Arrays;

public class CompararMain {

	public static void main(String[] args) {

//		ordenamiento de vectores con la clase Arrays
		String[] vec = new String[20];
		for (int i = 0; i < vec.length; i++) {
			vec[i] = "un String";
		}
		Arrays.sort(vec);
		
//		como los objetos no se sabe como comparar para ordenar,
//		se implementa la interface Comparable<T>
		Persona[] per = new Persona[4];
		
		per[0]= new Persona("Paula", "Gomez", 16);
		per[1]= new Persona("Ana", "Rios", 7);
		per[2]= new Persona("Maria", "Ferrer", 55);
		per[3]= new Persona("Juana", "Araoz", 34);
		for (int i = 0; i < 4; i++) {
			System.out.println(i + ":" + per[i]);
		}
		if (per[1].compareTo(per[2]) > 0)
			System.out.println(per[1].getNombre() + " es mayor que: " + per[2].getNombre());
		else
			System.out.println(per[2].getNombre() + " es mayor que: " + per[1].getNombre());
	}

}
