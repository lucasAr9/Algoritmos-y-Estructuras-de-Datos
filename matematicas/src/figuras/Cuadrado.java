/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuras;

public class Cuadrado extends Figura {

    private double lado;

    public Cuadrado(double lado, String unColorR, String unColorL) {
        super(unColorR, unColorL);
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double unLado) {
        lado = unLado;
    }

    @Override
    public double calcularArea() {
        return (getLado() * getLado());
    }

    @Override
    public double calcularPerimetro() {
        return (getLado() * 4);
    }

    @Override
    public String toString() {
        String aux = "Cuadrado{ " + super.toString() + " Lado: " + getLado() + "}";
        return aux;
    }
    
}
