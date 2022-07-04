/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuras;

public abstract class Figura {

    private String colorRelleno;
    private String colorLinea;

    public Figura(String colorRelleno, String colorLinea) {
        this.colorRelleno = colorRelleno;
        this.colorLinea = colorLinea;
    }

    public String getColorRelleno() {
        return colorRelleno;
    }

    public String getColorLinea() {
        return colorLinea;
    }
    
    public void setColorRelleno(String unColor) {
        colorRelleno = unColor;
    }

    public void setColorLinea(String unColor) {
        colorLinea = unColor;
    }

    public abstract double calcularArea();

    public abstract double calcularPerimetro();
    
    @Override
    public String toString() {
        String aux = "Area: " + this.calcularArea()
                + " Perimetro: " + this.calcularPerimetro()
                + " color del relleno: " + getColorRelleno()
                + " color de las lineas: " + getColorLinea();
        return aux;
    }
    
}
