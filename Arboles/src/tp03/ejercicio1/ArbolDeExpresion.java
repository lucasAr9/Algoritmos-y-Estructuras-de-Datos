package tp03.ejercicio1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio3.PilaGenerica;

public class ArbolDeExpresion {

    /*
    * convertir de pre-fija a arbol
    * */
    public ArbolBinario<Character> convertirPrefija(StringBuffer exp) {
        char c = exp.charAt(0);
        ArbolBinario<Character> result = new ArbolBinario<>(c);

        if ((c == '+') || (c == '-') || (c == '/') || c == '*') {
            // es operador
            result.agregarHijoIzquierdo(this.convertirPrefija(exp.delete(0, 1)));
            result.agregarHijoDerecho(this.convertirPrefija(exp.delete(0, 1)));
        }
        // es operando
        return result;
    }

    /*
    * convertir de post-fija a arbol
    * */
    public ArbolBinario<Character> convertirPostfija(StringBuffer exp) {
        char c;
        ArbolBinario<Character> result;
        PilaGenerica<ArbolBinario<Character>> p = new PilaGenerica<>(new ListaEnlazadaGenerica<>());

        for (int i = 0; i < exp.length(); i++) {
            c = exp.charAt(i);
            result = new ArbolBinario<>(c);
            if ((c == '+') || (c == '-') || (c == '/') || (c == '*')) {
                // Es operador
                result.agregarHijoDerecho(p.desapilar());
                result.agregarHijoIzquierdo(p.desapilar());
            }
            p.apilar(result);
        }
        return p.desapilar();
    }

    /*
    * dado un arbol de expresion con operadores y operandos, retorna el resultado de la cuenta
    * */
    public Integer evaluar(ArbolBinario<Character> arbol) {
        Character c = arbol.getDato();
        if ((c == '+') || (c == '-') || (c == '/') || c == '*') {
            // es operador
            int operador_1 = evaluar(arbol.getHijoIzquierdo());
            int operador_2 = evaluar(arbol.getHijoDerecho());
            switch (c) {
                case '+':
                    return operador_1 + operador_2;
                case '-':
                    return operador_1 - operador_2;
                case '*':
                    return operador_1 * operador_2;
                case '/':
                    return operador_1 / operador_2;
            }
        }
        // es operando
        return Integer.parseInt(c.toString());
    }
}
