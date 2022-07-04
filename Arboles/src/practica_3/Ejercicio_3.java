package practica_3;

import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;
import tp03.ejercicio3.ContadorArbol;

import java.util.Random;

public class Ejercicio_3 {

    public static void main(String[] args) {
        Random r = new Random();
        ArbolBinario<Integer> abb = new ArbolBinario<>();

        for (int i = 0; i < 30; i++) {
            abb.agregarOrdenado(r.nextInt(100));
        }

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("recorrido por niveles.");
        abb.recorridoPorNiveles();

        // pruebas con ArbolesGenerales
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("La frontera del arbol, o sea, sus hijos");
        ListaGenerica<Integer> lista = ContadorArbol.frontera(abb);
        lista.comenzar();
        while (!lista.fin())
            System.out.print(lista.proximo() + ", ");

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Lista con los numeros pares del arbol");
        ListaGenerica<Integer> lis = ContadorArbol.numerosPares(abb);
        lis.comenzar();
        while (!lis.fin())
            System.out.print(lis.proximo() + ", ");

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("La cantidad de Nodos del arbol es");
        System.out.println(ContadorArbol.contarNodos(abb));
    }

}
