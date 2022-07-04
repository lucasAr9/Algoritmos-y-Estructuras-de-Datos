package practica_3;

import tp03.ejercicio1.ArbolBinario;
import tp03.ejercicio1.ArbolDeExpresion;

public class TestArbolDeExpresion {

    public static void main(String[] args) {
        Character nodo0 = '*';
        Character nodo1 = '+';
        Character nodo2 = '-';
        Character nodo3 = '9';
        Character nodo4 = '2';
        Character nodo5 = '1';
        Character nodo6 = '5';
        ArbolBinario<Character> arbol = new ArbolBinario<>(nodo0);
        ArbolBinario<Character> a1 = new ArbolBinario<>(nodo1);
        ArbolBinario<Character> a2 = new ArbolBinario<>(nodo2);
        arbol.agregarHijoIzquierdo(a1);
        arbol.agregarHijoDerecho(a2);
        ArbolBinario<Character> a3 = new ArbolBinario<>(nodo3);
        ArbolBinario<Character> a4 = new ArbolBinario<>(nodo4);
        a1.agregarHijoIzquierdo(a3);
        a1.agregarHijoDerecho(a4);
        ArbolBinario<Character> a5 = new ArbolBinario<>(nodo5);
        ArbolBinario<Character> a6 = new ArbolBinario<>(nodo6);
        a2.agregarHijoIzquierdo(a5);
        a2.agregarHijoDerecho(a6);

        ArbolDeExpresion arbolDeExp = new ArbolDeExpresion();

        // pre-fija
        System.out.println('\n');
        StringBuffer prefija = new StringBuffer("*+I+JK-C*AB ");
        ArbolBinario<Character> arbol2;
        arbol2 = arbolDeExp.convertirPrefija(prefija);
        arbol2.preOrden();
        System.out.println();
        arbol2.inOrden();
        System.out.println();
        arbol2.postOrden();
        System.out.println();
        arbol2.recorridoPorNiveles();

        // post-fija
        System.out.println('\n');
        StringBuffer postfija = new StringBuffer("abc*d-ef/g/-*");
        ArbolBinario<Character> arbol1;
        arbol1 = arbolDeExp.convertirPostfija(postfija);
        arbol1.preOrden();
        System.out.println();
        arbol1.inOrden();
        System.out.println();
        arbol1.postOrden();
        System.out.println();
        arbol1.recorridoPorNiveles();

        // evaluar
        System.out.println('\n');
        System.out.println("el resultado del arbol de expresion " + arbolDeExp.evaluar(arbol));
    }
}
