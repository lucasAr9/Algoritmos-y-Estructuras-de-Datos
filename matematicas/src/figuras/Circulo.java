/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuras;

public class Circulo extends Figura {
    
    private double radio;

    public Circulo(double radio, String unColorR, String unColorL) {
        super(unColorR, unColorL);
        this.radio = radio;
    }
    
    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
    
    @Override
    public double calcularArea() {
        return (Math.PI * radio * radio);
    }
    
    @Override
    public double calcularPerimetro() {
        return ((2 * Math.PI) * radio);
    }

    @Override
    public String toString() {
        String aux = "Circulo{ " + super.toString() + " Radio: " + getRadio() + "}";
        return aux;
    }
    
}
