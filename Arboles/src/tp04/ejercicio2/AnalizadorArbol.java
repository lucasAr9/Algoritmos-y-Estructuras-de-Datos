package tp04.ejercicio2;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class AnalizadorArbol {
    /**
     * buscar el camino hasta la hoja mas lejana
     */
    public static ListaGenerica<Integer> caminoMasLejano(ArbolGeneral<Integer> a) {
        ListaGenerica<Integer> camAct = new ListaEnlazadaGenerica<>();
        ListaGenerica<Integer> camMasLargo = new ListaEnlazadaGenerica<>();
        if (!a.esVacio())
            caminoMasLejanoRecu(a, camAct, camMasLargo);
        return camMasLargo;
    }

    private static void caminoMasLejanoRecu(ArbolGeneral<Integer> a,
                                            ListaGenerica<Integer> camAct,
                                            ListaGenerica<Integer> camMasLargo) {
        camAct.agregarFinal(a.getDato());

        if (a.esHoja()) {
            if (camAct.tamanio() > camMasLargo.tamanio()) {
                // vaciamos el camino mas largo que teniamos hallado
                camMasLargo.comenzar();
                while (!camMasLargo.fin())
                    camMasLargo.eliminar(camMasLargo.proximo());
                // guardar el camino actual en el camino mas largo
                camAct.comenzar();
                while (!camAct.fin())
                    camMasLargo.agregarFinal(camAct.proximo());
            }
        } else {
            ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
            hijos.comenzar();
            while (!hijos.fin()) {
                caminoMasLejanoRecu(hijos.proximo(), camAct, camMasLargo);
                camAct.eliminarEn(camAct.tamanio());
            }
        }
    }

    /**
     * buscar el nivel con mayor promedio
     */
    public static void devolverMaximoPromedio(ArbolGeneral<Integer> a) {
        ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<>(new ListaEnlazadaGenerica<>());
        ArbolGeneral<Integer> arbolAux;

        cola.encolar(a);
        cola.encolar(null);
        int nroNivel = 0;
        int cantNodos = 0;
        double sumarNodos = 0.0;

        while (!cola.esVacia()) {
            arbolAux = cola.desencolar();

            if (arbolAux != null) {
                sumarNodos += arbolAux.getDato();
                cantNodos++;

                if (arbolAux.tieneHijos()) {
                    ListaGenerica<ArbolGeneral<Integer>> hijos = arbolAux.getHijos();
                    hijos.comenzar();
                    while (!hijos.fin()) {
                        cola.encolar(hijos.proximo());
                    }
                }
            } else if (!cola.esVacia()) {
                cola.encolar(null);
                nroNivel++;
                System.out.println("el nivel: " + nroNivel + " con promedio: " + sumarNodos / cantNodos);
                cantNodos = 0;
                sumarNodos = 0.0;
            }
        }
        System.out.println("el nivel: " + nroNivel + " con promedio: " + sumarNodos / cantNodos);
    }
}
