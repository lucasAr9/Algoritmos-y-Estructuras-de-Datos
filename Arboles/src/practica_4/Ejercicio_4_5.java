package practica_4;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;
import tp04.ejercicio2.AnalizadorArbol;

public class Ejercicio_4_5 {

    public static void main(String[] args) {
        // armado del arbol general
        Integer nodo0 = 10;
        Integer nodo1 = 7;
        Integer nodo2 = 8;
        Integer nodo3 = 21;
        Integer nodo4 = 15;
        Integer nodo5 = 20;
        Integer nodo6 = 12;
        Integer nodo7 = 9;
        Integer nodo8 = 16;
        Integer nodo9 = 23;
        Integer nodo10 = 39;
        Integer nodo11 = 35;
        Integer nodo12 = 30;

        ArbolGeneral<Integer> a2_1 = new ArbolGeneral<>(nodo4);
        ArbolGeneral<Integer> a2_2 = new ArbolGeneral<>(nodo5);
        ArbolGeneral<Integer> a2_3 = new ArbolGeneral<>(nodo6);
        ListaGenerica<ArbolGeneral<Integer>> hijos_a2 = new ListaEnlazadaGenerica<>();
        hijos_a2.agregarFinal(a2_1);
        hijos_a2.agregarFinal(a2_2);
        hijos_a2.agregarFinal(a2_3);
        ArbolGeneral<Integer> a1_1 = new ArbolGeneral<>(nodo1, hijos_a2);

        ArbolGeneral<Integer> a3_1 = new ArbolGeneral<>(nodo7);
        ArbolGeneral<Integer> a3_2 = new ArbolGeneral<>(nodo8);
        ListaGenerica<ArbolGeneral<Integer>> hijos_a3 = new ListaEnlazadaGenerica<>();
        hijos_a3.agregarFinal(a3_1);
        hijos_a3.agregarFinal(a3_2);
        ArbolGeneral<Integer> a1_2 = new ArbolGeneral<>(nodo2, hijos_a3);

        ArbolGeneral<Integer> a5_1 = new ArbolGeneral<>(nodo10);
        ArbolGeneral<Integer> a5_2 = new ArbolGeneral<>(nodo11);
        ArbolGeneral<Integer> a5_3 = new ArbolGeneral<>(nodo12);
        ListaGenerica<ArbolGeneral<Integer>> hijos_a5 = new ListaEnlazadaGenerica<>();
        hijos_a5.agregarFinal(a5_1);
        hijos_a5.agregarFinal(a5_2);
        hijos_a5.agregarFinal(a5_3);
        ArbolGeneral<Integer> a4_0 = new ArbolGeneral<>(nodo9, hijos_a5);

        ListaGenerica<ArbolGeneral<Integer>> hijo_a4 = new ListaEnlazadaGenerica<>();
        hijo_a4.agregarFinal(a4_0);
        ArbolGeneral<Integer> a1_3 = new ArbolGeneral<>(nodo3, hijo_a4);

        // raiz
        ListaGenerica<ArbolGeneral<Integer>> hijos_a1 = new ListaEnlazadaGenerica<>();
        hijos_a1.agregarFinal(a1_1);
        hijos_a1.agregarFinal(a1_2);
        hijos_a1.agregarFinal(a1_3);
        ArbolGeneral<Integer> arbol = new ArbolGeneral<>(nodo0, hijos_a1);

        // ArbolGeneral (ejercicio 4)
        arbol.porNiveles(); // mostrar el arbol
        System.out.println('\n');
        System.out.println("la altura del arbol es: " + arbol.altura());
        System.out.println();
        System.out.println("la profundidad de 12 es: " + arbol.profundidadDelDato(12));
        System.out.println();
        System.out.println("la cant de nodos en el nivel mas ancho: " + arbol.ancho());
        System.out.println();
        System.out.println("la cantidad de nodos del arbol es: " + arbol.cantidadDeNodos());
        System.out.println();
        System.out.println("la cantidad de hojas del arbol es: " + arbol.cantidadDeHojas());

        // AnalizadorArbol
        System.out.println();
        System.out.println("El camino mas largo.");
        System.out.println(AnalizadorArbol.caminoMasLejano(arbol));

        // AnalizadorArbol (ejercicio 5)
        System.out.println();
        System.out.println("el promedio mas alto por niveles");
        AnalizadorArbol.devolverMaximoPromedio(arbol);
    }
}
