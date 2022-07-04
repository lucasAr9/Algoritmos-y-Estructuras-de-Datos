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
public class Bipartition {

    private final double epsilon = 0.0;
    private double left;
    private double right;
    private double calc;

    public Bipartition() {
    }

    public double bipartitionGradeOne(int y, int x, int c, double a, double b) {
        left = a;
        right = b;

        while ((right - left) > 2 * epsilon) {
            calc = (right + left) / 2;
            if (((((x * right) + c) / y) * (((x * calc) + c) / y)) < 0) {
                left = calc;
            } else {
                right = calc;
            }
        }
        return calc;
    }

    public double bipartitionGradeTwo(int y, int x2, int x, int c, double a, double b) {
        left = a;
        right = b;

        while ((right - left) > 2 * epsilon) {
            calc = (right + left) / 2;
            if (((((x2 * right) + (x * right) + c) / y)
                    * (((x2 * calc) + (x * calc) + c) / y)) < 0) {
                left = calc;
            } else {
                right = calc;
            }
        }
        return calc;
    }

    public double getEpsilon() {
        return epsilon;
    }
}
