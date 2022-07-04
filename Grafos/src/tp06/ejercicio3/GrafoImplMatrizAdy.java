package tp06.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

/**
 * Implementacion del grafo con matriz de adyacentes
 */
public class GrafoImplMatrizAdy<T> implements Grafo<T> {
    private final int maxVertices;
    ListaGenerica<Vertice<T>> vertices;
    int[][] matrizAdy;

    public GrafoImplMatrizAdy(int maxVert) {
        // Para ser compatible con la lista, la matriz comienza en 1
        maxVertices = maxVert;
        vertices = new ListaEnlazadaGenerica<>();
        matrizAdy = new int[maxVertices + 1][maxVertices + 1];

        for (int i = 1; i <= maxVertices; i++) {
            for (int j = 0; j < maxVertices; j++) {
                matrizAdy[i][j] = 0;
            }
        }
    }

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
        int index = v.getPosicion();
        // Elimino la fila
        for (int fila = index; fila <= vertices.tamanio(); fila++) {
            matrizAdy[fila] = matrizAdy[fila + 1];
        }
        // Elimino la columna
        for (int fila = 0; fila <= vertices.tamanio(); fila++) {
            for (int col = index; col < vertices.tamanio(); col++) {
                matrizAdy[fila][col] = matrizAdy[fila][col + 1];
            }
        }
        vertices.eliminar(v);
    }

    /**
     * Conectar y desconectar vertices.
     */
    @Override
    public void conectar(Vertice<T> origen, Vertice<T> destino) {
        conectar(origen, destino, 1);
    }

    @Override
    public void conectar(Vertice<T> origen, Vertice<T> destino, int peso) {
        matrizAdy[origen.getPosicion()][destino.getPosicion()] = peso;
    }

    @Override
    public void desConectar(Vertice<T> origen, Vertice<T> destino) {
        matrizAdy[origen.getPosicion()][destino.getPosicion()] = 0;
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
        return matrizAdy[origen.getPosicion()][destino.getPosicion()] > 0;
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
        ListaGenerica<Arista<T>> ady = new ListaEnlazadaGenerica<>();
        int veticePos = v.getPosicion();
        Arista<T> arista;

        for (int i = 1; i <= vertices.tamanio(); i++) {
            if (matrizAdy[veticePos][i] > 0) {
                arista = new AristaImpl<>(vertices.elemento(i), matrizAdy[veticePos][i]);
                ady.agregarFinal(arista);
            }
        }
        return ady;
    }

    /**
     * Comprobar si es Grafo vacio.
     */
    @Override
    public boolean esVacio() {
        return vertices.esVacia();
    }

    /**
     * Peso de la arista entre vertice origen al destino.
     */
    @Override
    public int peso(Vertice<T> origen, Vertice<T> destino) {
        return matrizAdy[origen.getPosicion()][destino.getPosicion()];
    }
}
