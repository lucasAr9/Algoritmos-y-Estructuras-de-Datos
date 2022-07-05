package tp06.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class VerticeImplListAdy<T> implements Vertice<T> {
    private T dato;
    private int posicion;
    private ListaGenerica<Arista<T>> adyacentes;

    public VerticeImplListAdy(T d) {
        dato = d;
        adyacentes = new ListaEnlazadaGenerica<>();
    }

    @Override
    public T getDato() {
        return this.dato;
    }

    @Override
    public void setDato(T dato) {
        this.dato = dato;
    }

    /**
     * Posicion del vertice en la lista.
     */
    @Override
    public int getPosicion() {
        return posicion;
    }

    @Override
    public void setPosicion(int pos) {
        posicion = pos;
    }

    /**
     * Obtener una arista especifica o todos sus adyacentes.
     */
    private Arista<T> obtenerArista(Vertice<T> v) {
        Arista<T> arista = null;
        Arista<T> aristaAux;
        adyacentes.comenzar();

        while (!adyacentes.fin()) {
            aristaAux = adyacentes.proximo();
            if (aristaAux.verticeDestino() == v) {
                arista = aristaAux;
            }
        }
        return arista;
    }

    public ListaGenerica<Arista<T>> obtenerAdyacentes() {
        return adyacentes;
    }

    /**
     * Conectar y desconectar vertices.
     */
    public void conectar(Vertice<T> v) {
        conectar(v, 1);
    }

    public void conectar(Vertice<T> v, int peso) {
        Arista<T> arista = obtenerArista(v);

        if (arista == null) {
            Arista<T> a = new AristaImpl<>(v, peso);
            adyacentes.agregarFinal(a);
        }
    }

    public void desconectar(Vertice<T> v) {
        Arista<T> arista = obtenerArista(v);

        if (arista != null) {
            adyacentes.eliminar(arista);
        }
    }

    /**
     * Comprobar si un vertice es adyacente.
     */
    public boolean esAdyacente(Vertice<T> v) {
        Arista<T> arista = obtenerArista(v);
        return arista != null;
    }

    /**
     * Peso de la arista entre vertice origen al destino.
     */
    public int peso(Vertice<T> v) {
        Arista<T> arista = obtenerArista(v);
        int ret = 0;

        if (arista != null) {
            ret = arista.peso();
        }
        return ret;
    }

    /**
     * Mostrar el contenido del vertice en String.
     */
    public String toString() {
        String aux = "";
        aux = aux + this.getDato() + ", " + this.getPosicion();
        return aux;
    }
}
