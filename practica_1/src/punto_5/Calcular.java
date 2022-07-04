package punto_5;

import java.util.Random;

public class Calcular {
	
	public static MinMaxPro calc3;

	// 1. retornar un objeto
	public static MinMaxPro calcularReturn(int[] arreglo) {
		MinMaxPro calc1 = new MinMaxPro();
		double suma = 0;
		
		for (int i = 0; i < arreglo.length; i++) {
			if (calc1.getMinimo() > arreglo[i]) {
				calc1.setMinimo(arreglo[i]);
			}
			if (calc1.getMaximo() < arreglo[i]) {
				calc1.setMaximo(arreglo[i]);
			}
			suma = suma + arreglo[i];
		}
		calc1.setPromedio(suma / arreglo.length);
		return calc1;
	}
	
	// 2. modificar directamente en el objeto
	public static void calcularObjetos(MinMaxPro calc2, int[] arreglo) {
		double suma = 0;
		
		for (int i = 0; i < arreglo.length; i++) {
			if (calc2.getMinimo() > arreglo[i]) {
				calc2.setMinimo(arreglo[i]);
			}
			if (calc2.getMaximo() < arreglo[i]) {
				calc2.setMaximo(arreglo[i]);
			}
			suma = suma + arreglo[i];
		}
		calc2.setPromedio(suma / arreglo.length);		
	}
	
	// 3. modificar una variable global que es un objeto
	public static void calcularVariableGlobal(int[] arreglo) {
		double suma = 0;
		
		for (int i = 0; i < arreglo.length; i++) {
			if (calc3.getMinimo() > arreglo[i]) {
				calc3.setMinimo(arreglo[i]);
			}
			if (calc3.getMaximo() < arreglo[i]) {
				calc3.setMaximo(arreglo[i]);
			}
			suma = suma + arreglo[i];
		}
		calc3.setPromedio(suma / arreglo.length);	
	}
	
	public static void main(String[] args) {

		Random r = new Random();
		
		int[] arreglo = new int[10];
		for (int i = 0; i < arreglo.length; i++) {
			arreglo[i] = r.nextInt(50);
		}
		
		// 1. pasar el arreglo y el metodo static retorna un objeto
		MinMaxPro calc1 = new MinMaxPro();
		calc1 = Calcular.calcularReturn(arreglo);
		
		// 2. pasar arreglo y el objeto que sea como parametro por referencia
		MinMaxPro calc2 = new MinMaxPro();
		Calcular.calcularObjetos(calc2, arreglo);
		
		// 3. pasar la variable global y el arreglo
		calc3 = new MinMaxPro();
		Calcular.calcularVariableGlobal(arreglo);
		
		// imprimir
		for (int i = 0; i < arreglo.length; i++) {
			System.out.print(arreglo[i] + ", ");
		}
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(calc1.toString());
		System.out.println(" ");
		System.out.println(calc2.toString());
		System.out.println(" ");
		System.out.println(calc3.toString());
	}

}
