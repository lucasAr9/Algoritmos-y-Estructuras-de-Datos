package ejercicio_adicional;

import tp02.ejercicio2.*;
import tp04.ejercicio1.ArbolGeneral;

public class EncontrarCaminoPrincesa {

    public static void main(String[] args) {
        Personaje p0 = new Personaje("Scooby", "Animal");

        Personaje p1 = new Personaje("Cenicienta", "Princesa");
        Personaje p2 = new Personaje("Rojo", "Dragon");
        Personaje p3 = new Personaje("Pluto", "Animal");

        Personaje p4 = new Personaje("Negro", "Dragon");

        Personaje p5 = new Personaje("La Bella", "Princesa");
        Personaje p6 = new Personaje("Tweety", "Animal");

        Personaje p7 = new Personaje("Cid", "Animal");

        Personaje p8 = new Personaje("Coyote", "Animal");

        // p0(a1) hijo de la raiz p8(a)
        ArbolGeneral<Personaje> a1 = new ArbolGeneral<>(p0);

        // p1(a21), p2(a22) y p3(a23) hijos de p4(a2) 
        ArbolGeneral<Personaje> a21 = new ArbolGeneral<>(p1);
        ArbolGeneral<Personaje> a22 = new ArbolGeneral<>(p2);
        ArbolGeneral<Personaje> a23 = new ArbolGeneral<>(p3);
        ListaGenerica<ArbolGeneral<Personaje>> hijosa2 = new ListaEnlazadaGenerica<>();
        hijosa2.agregarFinal(a21);
        hijosa2.agregarFinal(a22);
        hijosa2.agregarFinal(a23);
        ArbolGeneral<Personaje> a2 = new ArbolGeneral<>(p4, hijosa2);

        // p5(a31) y p6(a32) hijos de p7(a3)
        ArbolGeneral<Personaje> a31 = new ArbolGeneral<>(p5);
        ArbolGeneral<Personaje> a32 = new ArbolGeneral<>(p6);
        ListaGenerica<ArbolGeneral<Personaje>> hijosa3 = new ListaEnlazadaGenerica<>();
        hijosa3.agregarFinal(a31);
        hijosa3.agregarFinal(a32);
        ArbolGeneral<Personaje> a3 = new ArbolGeneral<>(p7, hijosa3);

        // p0(a1), p4(a2) y p7(a3) son hijos de p8(a)
        ListaGenerica<ArbolGeneral<Personaje>> hijos = new ListaEnlazadaGenerica<>();
        hijos.agregarFinal(a1);
        hijos.agregarFinal(a2);
        hijos.agregarFinal(a3);
        ArbolGeneral<Personaje> a = new ArbolGeneral<>(p8, hijos);

        // crear y llamar a la clase que evalua el camino
        Juego juego = new Juego();
        System.out.println(juego.encontrarCamino(a));
    }
}
