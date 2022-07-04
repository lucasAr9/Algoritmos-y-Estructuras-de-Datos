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
public class Bhaskara {
    
    Fraction f = new Fraction();

    public Bhaskara() {
    }
    
    public String calculateBhaskara(int a, int b, int c) {
        String aux = "";
        
        /* calculate the determinant to find out if it is greater than or equal to zero */
        double determinant = Math.pow(b, 2) - (4 * a * c);
        
        /* if the determinant is greater than 0, calculate both results */
        if (determinant >= 0) {
            double x1 = ((b * (-1)) + Math.sqrt(determinant)) / (2 * a);
            double x2 = ((b * (-1)) - Math.sqrt(determinant)) / (2 * a);
            aux = aux + "x1 = " + x1 + "; x2 = " + x2 + ";\n";
            aux = aux + "x1 = " + f.calculateFraccion(x1);
            aux = aux + "x2 = " + f.calculateFraccion(x2);
        } else {
            aux = aux + "the determinant is negative and the operation cannot be calculated.";
        }
        return aux;
    }
}
