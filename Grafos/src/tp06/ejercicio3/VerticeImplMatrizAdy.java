package tp06.ejercicio3;

public class VerticeImplMatrizAdy<T> implements Vertice<T> {
    private T dato;
    private int posicion;

    public VerticeImplMatrizAdy(T d) {
        dato = d;
    }

    @Override
    public T getDato() {
        return this.dato;
    }

    @Override
    public void setDato(T dato) {
        this.dato = dato;
    }

    @Override
    public int getPosicion() {
        return posicion;
    }

    @Override
    public void setPosicion(int pos) {
        this.posicion = pos;
    }
}
