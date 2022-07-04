/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuras;

import java.util.Scanner;

public class MainDeFiguras {

    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        
        //figus puede contener objetos instancia de cualquier subclase de Figura.
        Figura[] figus = new Figura[3];
        figus[0] = new Cuadrado(10, "Violeta", "Rosa");      //posición 0 tiene un cuadrado   
        figus[1] = new Rectangulo(20, 10, "Azul", "Celeste");//posición 1 tiene un rectangulo
        figus[2] = new Cuadrado(30, "Rojo", "Naranja");      //posición 2 tiene un cuadrado
        
        double tot = 0;
        int i;
        //calculo el area total
        for (i = 0; i < 3; i++) {
            tot = tot + figus[i].calcularArea();
        //Polimorfismo: los cuadrados, rectángulos, círculos, etc responden
        //al mensaje "calcularArea" pero de diferente manera.
        //Binding dinámico: antes de la ejecución no se conoce qué tipo de objeto habrá
        //en cada posición de figus. El código para responder al mensaje "calcularArea"
        //se determina en tiempo de ejecución.
        }
        System.out.println("Area total: " + tot);

        
        /* pedir datos de un Triangulo */
        System.out.println("lados del triangulo.");
        System.out.print("a: ");
        double a = entrada.nextDouble();
        System.out.print("b: ");
        double b = entrada.nextDouble();
        System.out.print("c: ");
        double c = entrada.nextDouble();
        
        String cr = "rosa";
        System.out.println("color Relleno " + cr);
        String cl = "azul";
        System.out.println("color Linea " + cl);
        
        Triangulo calcularT = new Triangulo(a, b, c, cr, cl);
        
        System.out.println("el Area es: " + calcularT.calcularArea());
        System.out.println("el Perimetro es: " + calcularT.calcularPerimetro());

        
        /* pedir datos de un Circulo */
        System.out.println("radio: ");
        double radio = entrada.nextDouble();
        cr = "rosa";
        System.out.println("color Relleno " + cr);
        cl = "azul";
        System.out.println("color Linea " + cl);
        
        Circulo calcularC = new Circulo(radio, cr, cl);
        
        System.out.println("el Area es: " + calcularC.calcularArea());
        System.out.println("el Perimetro es: " + calcularC.calcularPerimetro());
        
        
        Cuadrado c1 = new Cuadrado(10, "Violeta", "Rosa");
        Rectangulo r = new Rectangulo(20, 10, "Azul", "Celeste");
        
        Figura f1 = new Cuadrado(10, "Violeta", "Rosa");
        Figura f2 = (Figura) c1;
        
        System.out.println(f1.toString());
        System.out.println(f2.toString());
    }
    
}
