/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

import java.util.Scanner;

/**
 *
 * @author Lucas Arrigoni
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner e = new Scanner(System.in);
        int y, x2, x, c, function;
        double a1, b1, c1, n;

        int option;
        do {
            System.out.println("------------------Choose the option to calculate------------------\n");
            System.out.println("1. For bhaskara.");
            System.out.println("2. Pass decimal to fraction.");
            System.out.println("3. For the bipartition method.");
            System.out.println("4. For...");
            System.out.println("5. For...");
            System.out.println("0. Get out.");
            System.out.println("");

            option = e.nextInt();

            switch (option) {
                case 0:
                    System.out.println("\nTHE END.\n");
                    break;

                case 1:
                    Bhaskara bhaskara = new Bhaskara();
                    System.out.print("Value x^2: ");
                    x2 = e.nextInt();
                    System.out.print("Value x: ");
                    x = e.nextInt();
                    System.out.print("Value c: ");
                    c = e.nextInt();
                    System.out.println(bhaskara.calculateBhaskara(x2, x, c) + "\n");
                    break;

                case 2:
                    Fraction fraction = new Fraction();
                    System.out.print("Decimal number to pass to fraction: ");
                    n = e.nextDouble();
                    System.out.println(fraction.calculateFraccion(n) + "\n");
                    break;

                case 3:
                    Bipartition bipartition = new Bipartition();
                    System.out.print("end of interval a: ");
                    a1 = e.nextDouble();
                    System.out.print("end of interval b: ");
                    b1 = e.nextDouble();

                    System.out.println("Function grade? ");
                    function = e.nextInt();
                    switch (function) {
                        case 1:
                            System.out.println("y = x + c");
                            System.out.print("y: ");
                            y = e.nextInt();
                            System.out.print("x: ");
                            x = e.nextInt();
                            System.out.print("c: ");
                            c = e.nextInt();
                            System.out.println("With allowed error of: "
                                    + bipartition.getEpsilon() + " result: "
                                    + bipartition.bipartitionGradeOne(y, x, c, a1, b1));
                            break;
                        case 2:
                            System.out.println("y = x^2 + x + c");
                            System.out.print("y: ");
                            y = e.nextInt();
                            System.out.print("x^2: ");
                            x2 = e.nextInt();
                            System.out.print("x: ");
                            x = e.nextInt();
                            System.out.print("c: ");
                            c = e.nextInt();
                            System.out.println("With allowed error of: "
                                    + bipartition.getEpsilon() + " result: "
                                    + bipartition.bipartitionGradeTwo(y, x2, x, c, a1, b1));
                            break;
                        default:
                            System.out.println("Not found.");
                            break;
                    }
                    break;

                default:
                    System.out.println("Error. Come back with the options.\n");
            }
        } while (option != 0);
    }

}
