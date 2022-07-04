package tp04.ejercicio1;

import tp02.ejercicio2.*;
import tp02.ejercicio3.*;

public class ArbolGeneral<T> {
    private T dato;
    private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<>();

    public ArbolGeneral(T dato) {
        this.dato = dato;
    }

    public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
        this(dato);
        if (hijos == null)
            this.hijos = new ListaEnlazadaGenerica<>();
        else
            this.hijos = hijos;
    }

    /**
     * getters y setters
     */
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public ListaGenerica<ArbolGeneral<T>> getHijos() {
        return this.hijos;
    }

    public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
        if (hijos == null)
            this.hijos = new ListaEnlazadaGenerica<>();
        else
            this.hijos = hijos;
    }

    /**
     * agregar una hoja
     */
    public void agregarHijo(ArbolGeneral<T> unHijo) {
        this.getHijos().agregarFinal(unHijo);
    }

    /**
     * si el nodo actual tiene hojas, si es hoja o si es arbol vacio
     */
    public boolean tieneHijos() {
        return this.hijos != null && !this.hijos.esVacia();
    }

    public boolean esHoja() {
        return !this.tieneHijos();
    }

    public boolean esVacio() {
        return this.dato == null && !this.tieneHijos();
    }

    /**
     * eliminar un hijo
     */
    public void eliminarHijo(ArbolGeneral<T> hijo) {
        if (this.tieneHijos()) {
            ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
            if (hijos.incluye(hijo))
                hijos.eliminar(hijo);
        }
    }

    /**
     * recorridos del arbol
     */
    public ListaGenerica<T> preOrden() {
        ListaGenerica<T> lista = new ListaEnlazadaGenerica<>();
        this.preOrden(lista);
        return lista;
    }

    private void preOrden(ListaGenerica<T> lis) {
        lis.agregarFinal(this.getDato());
        ListaGenerica<ArbolGeneral<T>> listaHijos = this.getHijos();
        listaHijos.comenzar();
        while (!listaHijos.fin()) {
            listaHijos.proximo().preOrden(lis);
        }
    }

    public ListaGenerica<T> inOrden() {
        ListaGenerica<T> lista = new ListaEnlazadaGenerica<>();
        this.inOrden(lista);
        return lista;
    }

    private void inOrden(ListaGenerica<T> lis) {
        ListaGenerica<ArbolGeneral<T>> listaHijos = this.getHijos();
        listaHijos.comenzar();
        if (this.tieneHijos()) {
            listaHijos.proximo().inOrden(lis);
        }
        lis.agregarFinal(this.getDato());
        while (!listaHijos.fin()) {
            listaHijos.proximo().inOrden(lis);
        }
    }

    public ListaGenerica<T> postOrden() {
        ListaGenerica<T> lista = new ListaEnlazadaGenerica<>();
        this.postOrden(lista);
        return lista;
    }

    private void postOrden(ListaGenerica<T> lis) {
        ListaGenerica<ArbolGeneral<T>> listaHijos = this.getHijos();
        listaHijos.comenzar();
        while (!listaHijos.fin()) {
            listaHijos.proximo().postOrden(lis);
        }
        lis.agregarFinal(this.getDato());
    }

    public void porNiveles() {
        ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>(new ListaEnlazadaGenerica<>());
        ArbolGeneral<T> arbolAux;

        cola.encolar(this);
        cola.encolar(null);
        int nroNivel = 0;
        System.out.print("Nivel nro: " + nroNivel + " --> ");

        while (!cola.esVacia()) {
            arbolAux = cola.desencolar();

            if (arbolAux != null) {
                System.out.print(arbolAux.getDato() + ", ");

                if (arbolAux.tieneHijos()) {
                    ListaGenerica<ArbolGeneral<T>> hijos = arbolAux.getHijos();
                    hijos.comenzar();
                    while (!hijos.fin()) {
                        cola.encolar(hijos.proximo());
                    }
                }
            } else if (!cola.esVacia()) {
                System.out.println();
                cola.encolar(null);
                nroNivel++;
                System.out.print("Nivel nro: " + nroNivel + " --> ");
            }
        }
    }

    /**
     * altura del arbol
     */
    public Integer altura() {
        if (this.esVacio())
            return -1;

        int alto = -1;

        if (this.esHoja()) {
            return 0;
        } else if (this.tieneHijos()) {
            ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
            hijos.comenzar();
            while (!hijos.fin())
                alto = Math.max(alto, hijos.proximo().altura());
        }
        return alto + 1;
    }

    /**
     * profundidad del dato pasado por parametro
     */
    public Integer profundidadDelDato(T dato) {
        ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>(new ListaEnlazadaGenerica<>());
        ArbolGeneral<T> arbolAux;

        cola.encolar(this);
        cola.encolar(null);
        int nroNivel = 1;

        while (!cola.esVacia()) {
            arbolAux = cola.desencolar();

            if (arbolAux != null) {
                if (arbolAux.getDato() == dato)
                    return nroNivel;

                if (arbolAux.tieneHijos()) {
                    ListaGenerica<ArbolGeneral<T>> hijos = arbolAux.getHijos();
                    hijos.comenzar();
                    while (!hijos.fin()) {
                        cola.encolar(hijos.proximo());
                    }
                }
            } else if (!cola.esVacia()) {
                cola.encolar(null);
                nroNivel++;
            }
        }
        return -1;
    }

    /**
     * ancho del arbol
     */
    public Integer ancho() {
        ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>(new ListaEnlazadaGenerica<>());
        ArbolGeneral<T> arbolAux;

        cola.encolar(this);
        cola.encolar(null);
        int cantNodos = 0;
        int cantNodosNivel = 0;

        while (!cola.esVacia()) {
            arbolAux = cola.desencolar();

            if (arbolAux != null) {

                if (arbolAux.tieneHijos()) {
                    ListaGenerica<ArbolGeneral<T>> hijos = arbolAux.getHijos();
                    hijos.comenzar();
                    while (!hijos.fin()) {
                        cola.encolar(hijos.proximo());
                        cantNodosNivel++;
                    }
                }
            } else if (!cola.esVacia()) {
                cola.encolar(null);
                if (cantNodos < cantNodosNivel) {
                    cantNodos = cantNodosNivel;
                }
                cantNodosNivel = 0;
            }
        }
        return cantNodos;
    }

    /**
     * cantidad de nodos del arbol
     */
    public Integer cantidadDeNodos() {
        ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>(new ListaEnlazadaGenerica<>());
        ArbolGeneral<T> arbolAux;

        cola.encolar(this);
        cola.encolar(null);
        int cantNodos = 0;

        while (!cola.esVacia()) {
            arbolAux = cola.desencolar();

            if (arbolAux != null) {
                if (arbolAux.tieneHijos()) {
                    ListaGenerica<ArbolGeneral<T>> hijos = arbolAux.getHijos();
                    hijos.comenzar();
                    while (!hijos.fin()) {
                        cola.encolar(hijos.proximo());
                    }
                }
                cantNodos++;
            } else if (!cola.esVacia()) {
                cola.encolar(null);
            }
        }
        return cantNodos;
    }

    /**
     * cantidad de hojas del arbol
     */
    public Integer cantidadDeHojas() {
        ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>(new ListaEnlazadaGenerica<>());
        ArbolGeneral<T> arbolAux;

        cola.encolar(this);
        cola.encolar(null);
        int cantHojas = 0;

        while (!cola.esVacia()) {
            arbolAux = cola.desencolar();

            if (arbolAux != null) {
                if (arbolAux.tieneHijos()) {
                    ListaGenerica<ArbolGeneral<T>> hijos = arbolAux.getHijos();
                    hijos.comenzar();
                    while (!hijos.fin()) {
                        cola.encolar(hijos.proximo());
                    }
                } else {
                    cantHojas++;
                }
            } else if (!cola.esVacia()) {
                cola.encolar(null);
            }
        }
        return cantHojas;
    }

    /**
    * Un nodo n es ancestro de un nodo m si existe un camino desde n a m.
    * */
    public boolean esAncestro(T a, T b) {
        if (this.esVacio() || this.getDato() == b) {
            return false;
        }
        ListaGenerica<T> lista = new ListaEnlazadaGenerica<>();

        lista.agregarFinal(this.getDato());
        ListaGenerica<ArbolGeneral<T>> listaHijos = this.getHijos();
        listaHijos.comenzar();
        while (!listaHijos.fin()) {
            listaHijos.proximo().esAncestro(a, b);
        }
        return false;
    }
}
