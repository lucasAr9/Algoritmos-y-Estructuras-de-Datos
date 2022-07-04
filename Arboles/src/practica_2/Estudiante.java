package practica_2;

public class Estudiante {

	private int comision;
	private String direccion;
	private String nombre;
	private String apellido;
	private String email;

	public Estudiante(String nombre, String apellido, String email, int comision, String direccion) {
		this.comision = comision;
		this.direccion = direccion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getComision() {
		return comision;
	}

	public void setComision(int comision) {
		this.comision = comision;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Estudiante [Nombre: " + getNombre() + ", Apellido: " + getApellido() + ", Email: " + getEmail()
				+ " Comision: " + getComision() + ", Direccion: " + getDireccion() + "]";
	}
}
