package interfaces.interfacePackage;

// Una interface puede extender multiples interfaces.
// Hay herencia multiple de interfaces.
// Una interface hereda todas las constantes y metodos de sus SuperInterfaces.
public interface Volador {
	// Esta interface Volador establece que debe hacer la clase que la
	// implementa, sin especificar el como.
	
	// Declaracion de constantes: implicitamente, public, static y final
	public static final long UN_SEGUNDO=1000;
	public static final long UN_MINUTO=60000;
	
	// Declaracion de metodos: implicitamente, public y abstract
	public abstract void despegar();
	public abstract String aterrizar();
	public abstract Boolean volar();
	
}
