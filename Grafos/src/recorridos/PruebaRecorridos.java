package recorridos;

import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.VerticeImplListAdy;
import tp06.recorridos.RecorridosListaAdy;

public class PruebaRecorridos {

    public static void main(String[] args) {

        RecorridosListaAdy<Character> recorridos = new RecorridosListaAdy<>();

        GrafoImplListAdy<Character> grafo = new GrafoImplListAdy<>();
        //    (a)------(b)
        //     |  10    | \30
        //   20|      15| (e)
        //     |  5     | /2
        //    (d)------(c)

        VerticeImplListAdy<Character> vertice_1 = new VerticeImplListAdy<>('a');
        VerticeImplListAdy<Character> vertice_2 = new VerticeImplListAdy<>('b');
        VerticeImplListAdy<Character> vertice_3 = new VerticeImplListAdy<>('c');
        VerticeImplListAdy<Character> vertice_4 = new VerticeImplListAdy<>('d');
        VerticeImplListAdy<Character> vertice_5 = new VerticeImplListAdy<>('e');

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

        System.out.println("\nPeso entre b y e");
        System.out.println(vertice_2.peso(vertice_5));

        System.out.println("\nRecorrido DFS");
        System.out.println(recorridos.dfs_lista(grafo));

        System.out.println("\nRecorrido BFS");
        System.out.println(recorridos.bfs_lista(grafo));
    }
}
