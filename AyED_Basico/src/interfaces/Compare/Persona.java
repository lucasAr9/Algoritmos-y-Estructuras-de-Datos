package interfaces.Compare;

public class Persona implements Comparable<Persona> {

	private String nombre;
	private String apellido;
	private int edad;
	
	public Persona(String nombre, String ape, int edad) {
		this.nombre = nombre;
		this.apellido = ape;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido
				+ ", edad=" + edad + "]";
	}

	@Override
	public int compareTo(Persona o) {
//		Este método retorna:
//		=0: si el objeto receptor es igual al pasado en el argumento.
//		>0: si el objeto receptor es mayor que el pasado como parámetro.
//		<0: si el objeto receptor es menor que el pasado como parámetro.
//		return this.edad - o.edad;
		return Integer.compare(this.edad, o.edad);
	}
}
