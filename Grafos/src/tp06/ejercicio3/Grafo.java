package tp06.ejercicio3;

import tp02.ejercicio2.ListaGenerica;

public interface Grafo<T> {

    /**
     * Agrega un vertice al Grafo.
     * Verifica que el vertice no exista en el Grafo.
     *
     * @param v el vertice para agregar al grafo
     */
    public void agregarVertice(Vertice<T> v);

    /**
     * Elimina el vertice del Grafo.
     * En caso que el vertice tenga conexiones con otros vertices, se eliminan todas sus conexiones.
     *
     * @param v el vertice a eliminar del grafo
     */
    public void eliminarVertice(Vertice<T> v);

    /**
     * Conecta el vertice origen con el vertice destino.
     * Verifica que ambos vertices existan, caso contrario no realiza ninguna conexion.
     *
     * @param origen desde que vertice va la direccion de conexion
     * @param destino hasta que vertice se conecta
     */
    public void conectar(Vertice<T> origen, Vertice<T> destino);

    /**
     * Conecta el vertice origen con el destino con peso.
     * Verifica que ambos vertices existan, caso contrario no realiza ninguna conexion.
     *
     * @param origen desde que vertice va la direccion de conexion
     * @param destino hasta que vertice se conecta
     * @param peso el peso de la arista que conecta los vertices
     */
    public void conectar(Vertice<T> origen, Vertice<T> destino, int peso);

    /**
     * Desconecta el vertice origen con el destino.
     * Verifica que ambos vertices existan, caso contrario no realiza ninguna desconexion
     * En caso de existir la conexion destino-->origen, esta permanece sin cambios.
     *
     * @param origen desde que vertice va la direccion de des-conexion
     * @param destino hasta que vertice
     */
    public void desConectar(Vertice<T> origen, Vertice<T> destino);

    /**
     * Obtiene un vertice dado su posicion.
     *
     * @param posicion posicion del vertice
     * @return el vertice
     */
    public Vertice<T> vertice(int posicion);

    /**
     * Retorna true si origen es adyacente a destino. False en caso contrario.
     *
     * @param origen vertice a evaluar su adyacente
     * @param destino adyacente del origen
     * @return true si es adyacente, false si no
     */
    public boolean esAdyacente(Vertice<T> origen, Vertice<T> destino);

    /**
     * Lista de vertices del grafo.
     *
     * @return la lista de vertices
     */
    public ListaGenerica<Vertice<T>> listaDeVertices();

    /**
     * Lista de adyacentes de un vertice.
     *
     * @param v vertice a encontrar sus adyacentes
     * @return la lista de adyacentes de un vertice
     */
    public ListaGenerica<Arista<T>> listaDeAdyacentes(Vertice<T> v);

    /**
     * Retorna true en caso que el grafo no contenga ningun vertice. False en caso contrario.
     *
     * @return true si es vacio, false si tiene al menos un vertice
     */
    public boolean esVacio();

    /**
     * Retorna el peso entre dos vertices.
     * En caso de no ser un grafo pesa es conveniete el uso el metodo esAdyacente.
     *
     * @param origen desde que vertice va la direccion de la arista
     * @param destino hasta que vertice
     * @return el peso de la arista
     */
    public int peso(Vertice<T> origen, Vertice<T> destino);

}
