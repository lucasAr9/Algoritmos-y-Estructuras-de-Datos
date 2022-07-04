package tp06.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

/**
 * Implementacion del grafo con lista de adyacentes
 */
public class GrafoImplListAdy<T> implements Grafo<T> {
    ListaGenerica<Vertice<T>> vertices = new ListaEnlazadaGenerica<>();

    /**
     * Agregar o eliminar vertice.
     */
    @Override
    public void agregarVertice(Vertice<T> v) {
        if (!vertices.incluye(v)) {
            vertices.agregarFinal(v);
            v.setPosicion(vertices.tamanio());
        }
    }

    @Override
    public void eliminarVertice(Vertice<T> v) {
        int indice = v.getPosicion();

        if (indice >= 0) {
            Vertice<T> vert;
            vertices.comenzar();
            while (!vertices.fin()) {
                vert = vertices.proximo();
                desConectar(vert, v);
            }

            boolean salir = false;
            vertices.comenzar();
            while (!vertices.fin() && !salir) {
                vert = vertices.proximo();
                if (vert.equals(v)) {
                    vertices.eliminar(vert);
                    salir = true;
                }
            }

            for (; indice < vertices.tamanio(); indice++) {
                vert = vertices.elemento(indice);
                vert.setPosicion(vert.getPosicion() - 1);
            }
        }
    }

    /**
     * Conectar y desconectar vertices.
     */
    @Override
    public void conectar(Vertice<T> origen, Vertice<T> destino) {
        ((VerticeImplListAdy<T>) origen).conectar(destino);
    }

    @Override
    public void conectar(Vertice<T> origen, Vertice<T> destino, int peso) {
        ((VerticeImplListAdy<T>) origen).conectar(destino, peso);
    }

    @Override
    public void desConectar(Vertice<T> origen, Vertice<T> destino) {
        ((VerticeImplListAdy<T>) origen).desconectar(destino);
    }

    /**
     * Obtener vertice.
     */
    @Override
    public Vertice<T> vertice(int posicion) {
        return vertices.elemento(posicion);
    }

    @Override
    public boolean esAdyacente(Vertice<T> origen, Vertice<T> destino) {
        return ((VerticeImplListAdy<T>) origen).esAdyacente(destino);
    }

    /**
     * Lista de vertices y de adyacentes.
     */
    @Override
    public ListaGenerica<Vertice<T>> listaDeVertices() {
        return vertices;
    }

    @Override
    public ListaGenerica<Arista<T>> listaDeAdyacentes(Vertice<T> v) {
        return ((VerticeImplListAdy<T>) v).obtenerAdyacentes();
    }

    /**
     * Comprobar si es Grafo vacio.
     */
    @Override
    public boolean esVacio() {
        return vertices.esVacia();
    }

    /**
     * Peso entre vertices.
     */
    @Override
    public int peso(Vertice<T> origen, Vertice<T> destino) {
        return ((VerticeImplListAdy<T>) origen).peso(destino);
    }

}
