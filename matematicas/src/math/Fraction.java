/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

/**
 *
 * @author Lucas Arrigoni
 */
public class Fraction {

    private double a, b;
    private double res;
    private double num;

    public Fraction() {
    }

    /* convert a decimal number to fraction */
    public String calculateFraccion(double number) {
        String aux = "";
        a = 1;
        b = 1;
        res = 1;
        num = number;

        /* see if the number is negative */
        if (num < 0) {
            num = num * (-1);
        }

        /* calculate the fraction by looking for a and b */
        while (res != num) {
            res = a / b;
            if (res < num) {
                a++;
            } else if (res > num) {
                a--;
                b++;
            }
        }

        /* pass numbers a and b to integers */
        int a1 = (int) a;
        int b1 = (int) b;

        /* create a String with the integers */
        if (number < 0) {
            aux = aux + "-" + a1 + "/" + b1;
        } else {
            aux = aux + a1 + "/" + b1;
        }
        return aux;
    }
}
