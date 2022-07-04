package ejercicio_adicional;

public class Personaje {
    private String clase;
    private String nombre;

    public Personaje(String nombre, String clase) {
        this.clase = clase;
        this.nombre = nombre;
    }

    public String getClase() {
        return clase;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean esDragon() {
        return this.getClase().equals("Dragon");
    }

    public boolean esPrincesa() {
        return this.getClase().equals("Princesa");
    }

    @Override
    public String toString() {
        return "Personaje{" + "clase='" + clase + '\'' + ", nombre='" + nombre + '\'' + '}';
    }
}
