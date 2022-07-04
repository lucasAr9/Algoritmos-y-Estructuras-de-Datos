/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package porcentajes;

import java.util.Scanner;

/**
 *
 * @author Lucas Arrigoni
 */
public class Porcentajes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner e = new Scanner(System.in);

        /**
         * un menu para probar los porcentajes.
         */
        int numero;
        System.out.println("************************programa para calcular porcentajes************************");
        System.out.println("1: sacar el monto total de un porcentaje, devuelve un monto.");
        System.out.println("2: calcular el porcentaje de un monto en otro, devuelve un porcentaje.");
        System.out.println("3: aplicar un descuento a un precio, devuelve un monto.");
        System.out.println("4: calcular el aumento de un precio, devuelve un porcentaje.");
        System.out.println("5: aplicar un aumento progrecivo, devuelve sus montos.");
        System.out.println("**********************************************************************************");
        numero = e.nextInt();

        /**
         * segun el numero ingresado de teclado, se aplica un porcentaje u otro.
         */
        double monto1;
        double monto2;
        double porcentaje;

        switch (numero) {

            case 1:
                System.out.print("porcentaje aplicado: ");
                porcentaje = e.nextDouble();
                System.out.print("en el monto? ");
                monto1 = e.nextDouble();
                System.out.print("el " + porcentaje + " porciento de " + monto1 + " es: ");
                System.out.printf("%1.2f", (monto1 * porcentaje) / 100);
                System.out.println("");
                break;

            case 2:
                System.out.print("monto a saber su porcentaje: ");
                monto1 = e.nextDouble();
                System.out.print("en que monto? ");
                monto2 = e.nextDouble();
                System.out.print(monto1 + " es el ");
                System.out.printf("%1.2f", (monto1 * 100) / monto2);
                System.out.println(" porciento de " + monto2);
                System.out.println("");
                break;

            case 3:
                System.out.print("precio a aplicar descuento: ");
                monto1 = e.nextDouble();
                System.out.print("descuento para aplicar: ");
                porcentaje = e.nextDouble();
                System.out.print("el " + porcentaje + " porciento de descuento de " + monto1 + " es: ");
                System.out.printf("%1.2f", (porcentaje / 100) * monto1);
                System.out.print(" el total entonces es: ");
                System.out.printf("%1.2f", monto1 - (porcentaje / 100) * monto1);
                System.out.println("");
                break;
                
            case 4:
                System.out.print("precio anterior: ");
                monto1 = e.nextDouble();
                System.out.print("precio actual: ");
                monto2 = e.nextDouble();
                System.out.print("de " + monto1 + " a " + monto2 + " hubo un aumento de: ");
                System.out.printf("%1.2f", ((monto2 - monto1) * 100) / monto1);
                System.out.println(" porciento");
                break;
                
            /**
             * aplicar un porcentaje de aumento a un sueldo a lo largo de un año en una
             * matriz que aplica 6 porcentajes distintos sobre el mismo sueldo en 4 años
             */
            case 5:
                int fil = 5, col = 6;
                double[][] sueldos = new double[fil][col];
                
                System.out.print("precio: ");
                monto2 = e.nextDouble();
                System.out.print("porcentaje de aumento: ");
                porcentaje = e.nextDouble();
                porcentaje = porcentaje / 100;

                int i, j;
                for (j = 0; j < col; j++) {
                    sueldos[0][j] = monto2;
                    monto1 = monto2;
                    for (i = 1; i < fil; i++) {
                        monto1 = monto1 + (monto1 * porcentaje);
                        sueldos[i][j] = monto1;
                    }
                    porcentaje = porcentaje + 0.01;
                }

                for (i = 0; i < fil; i++) {
                    for (j = 0; j < col; j++) {
                        System.out.printf("%1.2f", sueldos[i][j]);
                        System.out.print("   ");
                    }
                    System.out.println("");
                }
                break;
        }
    }

}
