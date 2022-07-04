package ejercicio_adicional;

import tp02.ejercicio2.*;
import tp04.ejercicio1.ArbolGeneral;

public class Juego {

    public ListaGenerica<Personaje> encontrarCamino(ArbolGeneral<Personaje> arbol) {
        ListaGenerica<Personaje> lista = new ListaEnlazadaGenerica<>();

        if (arbol.getDato().esPrincesa() || arbol.getDato().esDragon() || arbol.esHoja()) {
            if (arbol.getDato().esPrincesa()) {
                Personaje p = arbol.getDato();
                lista.agregarInicio(p);
            }
            return lista;
        }

        ListaGenerica<ArbolGeneral<Personaje>> listaHijos = arbol.getHijos();

        listaHijos.comenzar();
        while (!listaHijos.fin() && lista.esVacia()) {
            lista = encontrarCamino(listaHijos.proximo());
            if (!lista.esVacia()) {
                lista.agregarInicio(arbol.getDato());
                //break; // o lista.esVacia() en el while
            }
        }
        return lista;
    }
}
