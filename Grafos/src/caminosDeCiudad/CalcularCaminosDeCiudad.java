package caminosDeCiudad;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.caminosDeCiudad.CaminosDeCiudad;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.VerticeImplListAdy;

public class CalcularCaminosDeCiudad {

    public static void main(String[] args) {

        GrafoImplListAdy<String> ciudad = new GrafoImplListAdy<>();

        Vertice<String> v1 = new VerticeImplListAdy<>("Buenos Aires");
        Vertice<String> v2 = new VerticeImplListAdy<>("Santiago");
        Vertice<String> v3 = new VerticeImplListAdy<>("Lima");
        Vertice<String> v4 = new VerticeImplListAdy<>("Montevideo");
        Vertice<String> v5 = new VerticeImplListAdy<>("Asuncion");
        Vertice<String> v6 = new VerticeImplListAdy<>("Caracas");
        Vertice<String> v7 = new VerticeImplListAdy<>("La Habana");

        ciudad.agregarVertice(v1);
        ciudad.agregarVertice(v2);
        ciudad.agregarVertice(v3);
        ciudad.agregarVertice(v4);
        ciudad.agregarVertice(v5);
        ciudad.agregarVertice(v6);
        ciudad.agregarVertice(v7);

        ciudad.conectar(v1, v2, 3);
        ciudad.conectar(v1, v5, 10);
        ciudad.conectar(v1, v4, 4);
        ciudad.conectar(v1, v3, 2);

        ciudad.conectar(v2, v5, 500);
        ciudad.conectar(v2, v7, 4);

        ciudad.conectar(v3, v5, 4);

        ciudad.conectar(v4, v5, 6);

        ciudad.conectar(v6, v5, 11);
        ciudad.conectar(v6, v7, 10);

        CaminosDeCiudad mapa = new CaminosDeCiudad(ciudad);
        ListaGenerica<Vertice<String>> camino;

        System.out.println("\nCamino entre dos ciudades.");
        camino = mapa.devolverCamino("Buenos Aires", "Asuncion");
        System.out.println(camino);

        ListaGenerica<String> noPasar = new ListaEnlazadaGenerica<>();
        noPasar.agregarFinal("Santiago");
        noPasar.agregarFinal("La Plata");
//        noPasar.agregarFinal("Buenos Aires");
        System.out.println("\nCamino entre dos ciudades exceptuando una tercer ciudad.");
        camino = mapa.devolverCaminoExceptuando("Buenos Aires", "Asuncion", noPasar);
        System.out.println(camino);

        System.out.println("\nCamino mas corto entre dos ciudades.");
        camino = mapa.caminoMasCorto("Buenos Aires", "Asuncion");
        System.out.println(camino);
    }
}
