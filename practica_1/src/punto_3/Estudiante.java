package punto_3;

public class Estudiante extends Persona {

	private int comision;
	private String direccion;
	
	public Estudiante(String nombre, String apellido, String email,
									int comision, String direccion) {
		super(nombre, apellido, email);
		this.comision = comision;
		this.direccion = direccion;
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
		return "Estudiante [" + super.toString() + " Comision: " + getComision()
				+ ", Direccion: " + getDireccion() + "]";
	}
}
