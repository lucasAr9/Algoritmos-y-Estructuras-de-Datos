package practica_3;

import tp03.ejercicio1.ArbolBinario;
import tp03.ejercicio4.RedBinariaLlena;

public class Ejercicio_4 {

    public static void main(String[] args) {
        // crear el arbol binario lleno
        Integer nodo0 = 3;
        Integer nodo1 = 7;
        Integer nodo2 = 21;
        Integer nodo3 = 90;
        Integer nodo4 = 20;
        Integer nodo5 = 15;
        Integer nodo6 = 5;
        ArbolBinario<Integer> arbol = new ArbolBinario<>(nodo0);
        ArbolBinario<Integer> a1 = new ArbolBinario<>(nodo1);
        ArbolBinario<Integer> a2 = new ArbolBinario<>(nodo2);
        arbol.agregarHijoIzquierdo(a1);
        arbol.agregarHijoDerecho(a2);
        ArbolBinario<Integer> a3 = new ArbolBinario<>(nodo3);
        ArbolBinario<Integer> a4 = new ArbolBinario<>(nodo4);
        a1.agregarHijoIzquierdo(a3);
        a1.agregarHijoDerecho(a4);
        ArbolBinario<Integer> a5 = new ArbolBinario<>(nodo5);
        ArbolBinario<Integer> a6 = new ArbolBinario<>(nodo6);
        a2.agregarHijoIzquierdo(a5);
        a2.agregarHijoDerecho(a6);

        System.out.println(" ");
        System.out.println(" ");
        System.out.println(arbol.lleno());

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("el retardo maximo es: "
                + RedBinariaLlena.retardoReenvio(arbol));

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("la suma de todos los nodos: "
                + RedBinariaLlena.sumaElementosTotal(arbol));

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("la suma de los nodos en profundidad: ");
        RedBinariaLlena.sumaElementosProfundidas(arbol);
    }
}
