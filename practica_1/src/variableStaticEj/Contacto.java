package variableStaticEj;

public class Contacto {

	private static int ultimoContacto = 1;

	private int id;
	private String nombre;
	private String estado;
	
	public Contacto() {
		this.id = ultimoContacto++;
	}

	public static int getUltimoContacto() {
		return ultimoContacto;
	}

	public int getId() {
		return id;
	}

	public void setId() {
		ultimoContacto++;
		this.id = ultimoContacto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
