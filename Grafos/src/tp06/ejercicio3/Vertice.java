package tp06.ejercicio3;

/**
 * Representa una Vertice de un {@link Grafo}.
 */
public interface Vertice<T> {
    public T getDato();

    public void setDato(T dato);

    public int getPosicion();

    public void setPosicion(int pos);
}
