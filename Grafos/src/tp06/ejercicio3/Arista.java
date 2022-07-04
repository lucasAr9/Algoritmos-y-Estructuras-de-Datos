package tp06.ejercicio3;

/**
 * Representa una Arista de un {@link Grafo}
 */
public interface Arista<T> {
    public Vertice<T> verticeDestino();

    public int peso();
}
