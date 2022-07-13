package tp06.caminosDeCiudad;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;

public class CaminosDeCiudad {

    private GrafoImplListAdy<String> mapaCiudades;

    public CaminosDeCiudad(GrafoImplListAdy<String> mapaCiudades) {
        this.mapaCiudades = mapaCiudades;
    }

    /**
     * Calcular el camino de ciudad1 a ciudad2.
     *
     * @param ciudad1 la ciudad donde se parte el recorrido
     * @param ciudad2 la ciudad de destino
     * @return lista de vertices desde ciudad1 hasta ciudad2
     */
    public ListaGenerica<Vertice<String>> devolverCamino(String ciudad1, String ciudad2) {
        ListaGenerica<Vertice<String>> lista = new ListaEnlazadaGenerica<>();
        ListaGenerica<Vertice<String>> recorrido = new ListaEnlazadaGenerica<>();
        boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
        Vertice<String> vertice = null;

        boolean ok = false;
        int i = 1;
        while ((i <= mapaCiudades.listaDeVertices().tamanio()) && (!ok)) {
            vertice = mapaCiudades.vertice(i);
            if (vertice.getDato().equals(ciudad1)) ok = true;
            else i++;
        }

        if (ok) {
            lista.agregarFinal(vertice);
            dfsEntreCiudades(lista, i, marca, ciudad2, recorrido);
        } else {
            System.out.println("No se encontro la ciudad " + ciudad1);
        }
        return recorrido;
    }

    public void dfsEntreCiudades(ListaGenerica<Vertice<String>> lista, int i, boolean[] marca,
                                 String ciudad2, ListaGenerica<Vertice<String>> recorrido) {
        marca[i] = true;
        Vertice<String> vertice_actual = mapaCiudades.vertice(i);

        if (vertice_actual.getDato().equals(ciudad2)) {
            clonar(lista, recorrido);
        }

        if (recorrido.esVacia()) {
            ListaGenerica<Arista<String>> adyacentes = mapaCiudades.listaDeAdyacentes(vertice_actual);
            adyacentes.comenzar();

            while ((!adyacentes.fin()) && (recorrido.esVacia())) {
                Vertice<String> prox_vertice = adyacentes.proximo().verticeDestino();
                int pos = prox_vertice.getPosicion();

                if (!marca[pos]) {
                    lista.agregarFinal(prox_vertice);
                    dfsEntreCiudades(lista, pos, marca, ciudad2, recorrido);
                    lista.eliminarEn(lista.tamanio());
                }
            }
        }
    }

    /**
     * Calcular el camino de ciudad1 a ciudad2 sin pasar por las ciudades noPasar.
     *
     * @param ciudad1 la ciudad donde se parte el recorrido
     * @param ciudad2 la ciudad de destino
     * @param noPasar lista con las ciudades que no pueden estar en la lista del camino entre ciudad1 y 2
     * @return lista de vertices desde ciudad1 hasta ciudad2
     */
    public ListaGenerica<Vertice<String>> devolverCaminoExceptuando(String ciudad1, String ciudad2,
                                                                    ListaGenerica<String> noPasar) {
        ListaGenerica<Vertice<String>> lista = new ListaEnlazadaGenerica<>();
        ListaGenerica<Vertice<String>> recorrido = new ListaEnlazadaGenerica<>();
        boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
        Vertice<String> vertice = null;

        boolean ciudadesOK = !noPasar.incluye(ciudad1) && !noPasar.incluye(ciudad2);

        if (ciudadesOK) {
            boolean ok = false;
            int i = 1;

            while ((i <= mapaCiudades.listaDeVertices().tamanio()) && (!ok)) {
                vertice = mapaCiudades.vertice(i);
                if (vertice.getDato().equals(ciudad1)) ok = true;
                else i++;
            }
            if (ok) {
                lista.agregarFinal(vertice);
                dfsCaminoExceptuando(lista, i, marca, ciudad2, recorrido, noPasar);
            } else {
                System.out.println("No se encontro la ciudad " + ciudad1);
            }
        } else {
            System.out.println("En la lista de ciudades para no pasar esta o ciudad de salida o de destino.");
        }
        return recorrido;
    }

    public void dfsCaminoExceptuando(ListaGenerica<Vertice<String>> lista, int i, boolean[] marca, String ciudad2,
                                     ListaGenerica<Vertice<String>> recorrido, ListaGenerica<String> noPasar) {
        marca[i] = true;
        Vertice<String> vertice = mapaCiudades.vertice(i);

        if (vertice.getDato().equals(ciudad2)) {
            clonar(lista, recorrido);
        }

        if (recorrido.esVacia()) {
            ListaGenerica<Arista<String>> adyacentes = mapaCiudades.listaDeAdyacentes(vertice);
            adyacentes.comenzar();

            while ((!adyacentes.fin()) && (recorrido.esVacia())) {
                Vertice<String> prox_vertice = adyacentes.proximo().verticeDestino();
                int pos = prox_vertice.getPosicion();

                boolean verificar_ciudades = !noPasar.incluye(prox_vertice.getDato());

                if ((!marca[pos]) && (verificar_ciudades)) {
                    lista.agregarFinal(prox_vertice);
                    dfsCaminoExceptuando(lista, pos, marca, ciudad2, recorrido, noPasar);
                    lista.eliminarEn(lista.tamanio());
                }
            }
        }
    }

    /**
     * Calcular el camino de ciudad1 a ciudad2 mas corto.
     *
     * @param ciudad1 la ciudad donde se parte el recorrido
     * @param ciudad2 la ciudad de destino
     * @return lista de vertices desde ciudad1 hasta ciudad2 con camino mas corto
     */
    public ListaGenerica<Vertice<String>> caminoMasCorto(String ciudad1, String ciudad2) {
        ListaGenerica<Vertice<String>> recorrido = new ListaEnlazadaGenerica<>();
        Vertice<String> vertice;

        boolean ok = false;
        int i = 1;
        while ((i <= mapaCiudades.listaDeVertices().tamanio()) && (!ok)) {
            vertice = mapaCiudades.vertice(i);
            if (vertice.getDato().equals(ciudad1)) ok = true;
            else i++;
        }

        if (ok) {
            dijkstra(mapaCiudades.listaDeVertices());
        } else {
            System.out.println("No se encontro la ciudad " + ciudad1);
        }
        return recorrido;
    }

    public void dijkstra(ListaGenerica<Vertice<String>> vertices) {

    }

    /**
     * Clonar las listas pasadas por parametro.
     *
     * @param lista1 lista a clonar en lista2
     * @param lista2 lista en la que se va a clonar lista1
     */
    public void clonar(ListaGenerica<Vertice<String>> lista1, ListaGenerica<Vertice<String>> lista2) {
        lista1.comenzar();
        while (!lista1.fin()) {
            lista2.agregarFinal(lista1.proximo());
        }
    }
}
