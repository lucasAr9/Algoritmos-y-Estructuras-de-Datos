package tp03.ejercicio3;

import tp02.ejercicio2.*;
import tp03.ejercicio1.ArbolBinario;

public class ContadorArbol {
    /*
    * contar los nodos del arbol
    * */
    public static int contarNodos(ArbolBinario<Integer> arbol) {
        int cantNodos = 0;

        if (arbol.tieneHijoIzquierdo())
            cantNodos = cantNodos + contarNodos(arbol.getHijoIzquierdo());

        if (arbol.tieneHijoDerecho())
            cantNodos = cantNodos + contarNodos(arbol.getHijoDerecho());

        return cantNodos + 1;
    }

    /*
    * la lista frontera del arbol, o sea, una lista con todas sus hojas
    * */
    public static ListaGenerica<Integer> frontera(ArbolBinario<Integer> arbol) {
        ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();
        fronteraRecur(lista, arbol);
        return lista;
    }

    private static void fronteraRecur(ListaGenerica<Integer> lis,
                                      ArbolBinario<Integer> arbol) {
        if (arbol.tieneHijoIzquierdo())
            fronteraRecur(lis, arbol.getHijoIzquierdo());

        if (arbol.esHoja())
            lis.agregarFinal(arbol.getDato());

        if (arbol.tieneHijoDerecho())
            fronteraRecur(lis, arbol.getHijoDerecho());
    }

    /*
    * @return lista con los numeros pares
    * */
    public static ListaGenerica<Integer> numerosPares(ArbolBinario<Integer> arbol) {
        ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();
        numerosParesRecur(lista, arbol);
        return lista;
    }

    private static void numerosParesRecur(ListaGenerica<Integer> lista,
                                          ArbolBinario<Integer> arbol) {
        if (arbol.tieneHijoIzquierdo())
            numerosParesRecur(lista, arbol.getHijoIzquierdo());

        if (arbol.getDato() % 2 == 0)
            lista.agregarFinal(arbol.getDato());

        if (arbol.tieneHijoDerecho())
            numerosParesRecur(lista, arbol.getHijoDerecho());
    }
}
