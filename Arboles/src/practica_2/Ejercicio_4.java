package practica_2;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio3.*;

public class Ejercicio_4 {

    // solucion a medias sin pila ni cola
//	public static boolean estaBalanceado(String cadena) {
//		int llaveA = 0;
//		int llaveC = 0;
//		int parentesisA = 0;
//		int parentesisC = 0;
//		int corcheteA = 0;
//		int corcheteC = 0;
//		
//		for (int i = 0; i < cadena.length(); i++) {
//			if (cadena.charAt(i) == '{')
//				llaveA++;
//			if (cadena.charAt(i) == '}')
//				llaveC++;
//			if (cadena.charAt(i) == '(')
//				parentesisA++;
//			if (cadena.charAt(i) == ')')
//				parentesisC++;
//			if (cadena.charAt(i) == '[')
//				corcheteA++;
//			if (cadena.charAt(i) == ']')
//				corcheteC++;
//		}
//		if ((llaveA == llaveC)
//				&& (parentesisA == parentesisC)
//				&& (corcheteA == corcheteC))
//			return true;
//		else
//			return false;
//	}
    // con pila
    public static boolean estaBalanceado(String cadena) {
        PilaGenerica<Character> pila = new PilaGenerica<>(new ListaEnlazadaGenerica<Character>());

        for (int i = 0; i < cadena.length(); i++) {

            if ((cadena.charAt(i) == '{')
                    || (cadena.charAt(i) == '(')
                    || (cadena.charAt(i) == '[')) {
                pila.apilar(cadena.charAt(i));

            } else if ((cadena.charAt(i) == '}')
                    || (cadena.charAt(i) == ')')
                    || (cadena.charAt(i) == ']')) {
                char elem = cadena.charAt(i);

                if ((pila.tope() == '{') && (elem == '}')) {
                    pila.desapilar();
                } else if ((pila.tope() == '(') && (elem == ')')) {
                    pila.desapilar();
                } else if ((pila.tope() == '[') && (elem == ']')) {
                    pila.desapilar();
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String cadena1 = "{()}"; // true
        String cadena2 = "{(])}"; // false
        String cadena3 = "{()]]}"; // false
        String cadena4 = "{()[]}"; // true
        String cadena5 = "{()][}"; // false
        String cadena6 = "{()[][]()}"; // true

        System.out.println("cadena 1 esta balance? " + estaBalanceado(cadena1));
        System.out.println("cadena 2 esta balance? " + estaBalanceado(cadena2));
        System.out.println("cadena 3 esta balance? " + estaBalanceado(cadena3));
        System.out.println("cadena 4 esta balance? " + estaBalanceado(cadena4));
        System.out.println("cadena 5 esta balance? " + estaBalanceado(cadena5));
        System.out.println("cadena 6 esta balance? " + estaBalanceado(cadena6));
    }

}
