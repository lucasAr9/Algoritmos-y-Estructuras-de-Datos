package tp06.recorridos;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;

public class RecorridosListaAdy<T> {

    /**
     * Recorrido DFS de lista de adyacencias (recorrido en profundidad)
     */
    public ListaGenerica<Vertice<T>> dfs_lista(GrafoImplListAdy<T> grafo) {
        ListaGenerica<Vertice<T>> listaVertices = new ListaEnlazadaGenerica<>();
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio() + 1];

        for (int i = 1; i <= grafo.listaDeVertices().tamanio(); i++) {
            if (!marca[i]) {
                dfs_lista(grafo, listaVertices, i, marca);
            }
        }
        return listaVertices;
    }

    public void dfs_lista(GrafoImplListAdy<T> grafo, ListaGenerica<Vertice<T>> lista, int i, boolean[] marca) {
        marca[i] = true;
        Vertice<T> vertice_actual = grafo.vertice(i);
        lista.agregarFinal(vertice_actual);

        ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(vertice_actual);
        adyacentes.comenzar();

        while (!adyacentes.fin()) {
            int pos = adyacentes.proximo().verticeDestino().getPosicion();
            if (!marca[pos]) {
                dfs_lista(grafo, lista, pos, marca);
            }
        }
    }

    /**
     * Recorrido BFS de lista de adyacencias (recorrido en amplitud)
     */
    public ListaGenerica<Vertice<T>> bfs_lista(GrafoImplListAdy<T> grafo) {
        ListaGenerica<Vertice<T>> listaVertices = new ListaEnlazadaGenerica<>();
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio() + 1];

        for (int i = 1; i <= grafo.listaDeVertices().tamanio(); i++) {
            if (!marca[i]) {
                bfs_lista(grafo, listaVertices, i, marca);
            }
        }
        return listaVertices;
    }

    public void bfs_lista(GrafoImplListAdy<T> grafo, ListaGenerica<Vertice<T>> lista, int i, boolean[] marca) {
        ColaGenerica<Vertice<T>> cola = new ColaGenerica<>(new ListaEnlazadaGenerica<>());
        ListaGenerica<Arista<T>> adyacentes;

        cola.encolar(grafo.vertice(i));
        marca[i] = true;

        while (!cola.esVacia()) {
            Vertice<T> vertice_actual = cola.desencolar();
            lista.agregarFinal(vertice_actual);
            adyacentes = grafo.listaDeAdyacentes(vertice_actual);
            adyacentes.comenzar();

            while (!adyacentes.fin()) {
                Arista<T> arista = adyacentes.proximo();
                int pos = arista.verticeDestino().getPosicion();

                if (!marca[pos]) {
                    marca[pos] = true;
                    cola.encolar(arista.verticeDestino());
                }
            }
        }
    }
}
