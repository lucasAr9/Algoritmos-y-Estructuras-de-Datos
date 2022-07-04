package recorridos;

import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.VerticeImplListAdy;

public class recorridos {

    public static void main(String[] args) {

        GrafoImplListAdy<Integer> grafo = new GrafoImplListAdy<>();
        //    (1)------(2)
        //     |  10    | \30
        //   20|      15| (5)
        //     |  5     | /2
        //    (4)------(3)

        VerticeImplListAdy<Integer> vertice_1 = new VerticeImplListAdy<>(1);
        VerticeImplListAdy<Integer> vertice_2 = new VerticeImplListAdy<>(2);
        VerticeImplListAdy<Integer> vertice_3 = new VerticeImplListAdy<>(3);
        VerticeImplListAdy<Integer> vertice_4 = new VerticeImplListAdy<>(4);
        VerticeImplListAdy<Integer> vertice_5 = new VerticeImplListAdy<>(5);

        grafo.agregarVertice(vertice_1);
        grafo.agregarVertice(vertice_2);
        grafo.agregarVertice(vertice_3);
        grafo.agregarVertice(vertice_4);
        grafo.agregarVertice(vertice_5);

        grafo.conectar(vertice_1, vertice_2, 10);
        grafo.conectar(vertice_1, vertice_4, 20);

        grafo.conectar(vertice_2, vertice_1, 10);
        grafo.conectar(vertice_2, vertice_3, 15);
        grafo.conectar(vertice_2, vertice_5, 30);

        grafo.conectar(vertice_3, vertice_2, 15);
        grafo.conectar(vertice_3, vertice_4, 5);
        grafo.conectar(vertice_3, vertice_5, 2);

        grafo.conectar(vertice_4, vertice_1, 20);
        grafo.conectar(vertice_4, vertice_3, 5);

        grafo.conectar(vertice_5, vertice_2, 30);
        grafo.conectar(vertice_5, vertice_3, 2);

        System.out.println(grafo.vertice(1));
    }
}
