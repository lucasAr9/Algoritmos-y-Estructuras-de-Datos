package tp03.ejercicio4;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class RedBinariaLlena {
    public static int rama = 1;

    /*
    * calcular el retardo maximo desde la raiz hasta la ultima hoja
    * con post-orden
    * */
    public static int retardoReenvio(ArbolBinario<Integer> arbol) {
        int retardoIzquierdo = 0;
        int retardoDerecho = 0;

        if (arbol.tieneHijoIzquierdo()) {
            retardoIzquierdo = retardoReenvio(arbol.getHijoIzquierdo());
        }
        if (arbol.tieneHijoDerecho()) {
            retardoDerecho = retardoReenvio(arbol.getHijoDerecho());
        }
        int max = Math.max(retardoIzquierdo, retardoDerecho);
        return arbol.getDato() + max;
    }

    public static int sumaElementosTotal(ArbolBinario<Integer> arbol) {
        int suma = 0;

        if (arbol.tieneHijoIzquierdo()) {
            suma = suma + sumaElementosTotal(arbol.getHijoIzquierdo());
        }
        if (arbol.tieneHijoDerecho()) {
            suma = suma + sumaElementosTotal(arbol.getHijoDerecho());
        }
        return suma + arbol.getDato();
    }

    /*
    * calcular el total de todos los nodos en profundidad
    * con pre-orden
    * */
    public static void sumaElementosProfundidas(ArbolBinario<Integer> arbol) {
        int total = 0;
        sumaElementosProfundidas2(arbol, total);
    }

    private static void sumaElementosProfundidas2(ArbolBinario<Integer> arbol, int total) {
        total = total + arbol.getDato();

        if (arbol.tieneHijoIzquierdo()) {
            sumaElementosProfundidas2(arbol.getHijoIzquierdo(), total);
        }
        if (arbol.tieneHijoDerecho()) {
            sumaElementosProfundidas2(arbol.getHijoDerecho(), total);
        }
        if (arbol.esHoja()) {
            System.out.println("total de la rama " + rama + " = " + total);
            rama++;
        }
    }
}
