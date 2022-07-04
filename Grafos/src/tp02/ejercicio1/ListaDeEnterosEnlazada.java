package tp02.ejercicio1;

public class ListaDeEnterosEnlazada extends ListaDeEnteros {

	private NodoEntero inicio;
	private NodoEntero actual;
	private NodoEntero fin;

	private int tamanio = 0;

	@Override
	public void comenzar() {
		actual = inicio;
	}

	@Override
	public Integer proximo() {
		Integer elto = actual.getDato();
		actual = actual.getSiguiente();
		return elto;
	}

	@Override
	public boolean fin() {
		return (actual == null);
	}

	@Override
	public Integer elemento(int pos) {
		if (pos < 1 || pos > this.tamanio())
			return null;

		NodoEntero n = this.inicio;
		while (pos-- > 1)
			n = n.getSiguiente();

		return n.getDato();
	}

	@Override
	public boolean agregarEn(Integer elem, int pos) {
		if (pos < 1 || pos > this.tamanio() + 1)
			return false;

		this.tamanio++;
		NodoEntero nuevo = new NodoEntero();
		nuevo.setDato(elem);
		if (pos == 1) {
			nuevo.setSiguiente(inicio);
			inicio = nuevo;
			// si es el primer elemento acomodo fin
			if (tamanio == 1) {
				fin = inicio;
			}
		} else {
			NodoEntero anterior = null;
			NodoEntero n = this.inicio;
			int posActual = 1;
			while (!(n == null) && (posActual < pos)) {
				anterior = n;
				n = n.getSiguiente();
				posActual++;
			}
			anterior.setSiguiente(nuevo);
			nuevo.setSiguiente(n);
			// si el nuevo es null porque actual es null seteo el fin
			// por el nuevo
			if (nuevo.getSiguiente() == null)
				fin = nuevo;
		}
		return true;
	}

	@Override
	public boolean agregarInicio(Integer elem) {
		this.agregarEn(elem, 1);
		return true;
	}

	@Override
	public boolean agregarFinal(Integer elem) {
		NodoEntero nuevo = new NodoEntero();
		nuevo.setDato(elem);
		if (inicio == null) {
			inicio = nuevo;
			fin = nuevo;
		} else {
			fin.setSiguiente(nuevo);
			fin = nuevo;
		}
		tamanio++;
		return true;
	}

	@Override
	public boolean eliminar(Integer elem) {
		NodoEntero anterior = null;
		NodoEntero n = this.inicio;

		while ((n != null) && (!n.getDato().equals(elem))) {
			anterior = n;
			n = n.getSiguiente();
		}
		if (n == null)
			return false;
		else {
			if (anterior == null)
				this.inicio = this.inicio.getSiguiente();
			else
				anterior.setSiguiente(n.getSiguiente());

			this.tamanio--;

			return true;
		}
	}

	@Override
	public boolean eliminarEn(int pos) {
		if (pos < 1 || pos > this.tamanio())
			return false;

		this.tamanio--;
		if (pos == 1) {
			inicio = inicio.getSiguiente();
			return true;
		}
		NodoEntero anterior = null;
		NodoEntero actual = this.inicio;
		while (!(actual == null) && (pos > 1)) {
			pos--;
			anterior = actual;
			actual = actual.getSiguiente();
		}
		anterior.setSiguiente(actual.getSiguiente());
		// si anterior es null seteo el fin por el anterior
		if (anterior.getSiguiente() == null)
			fin = anterior;
		return true;
	}

	@Override
	public boolean incluye(Integer elem) {
		NodoEntero n = this.inicio;
		while (!(n == null) && !(n.getDato().equals(elem)))
			n = n.getSiguiente();

		return !(n == null);
	}

	@Override
	public boolean esVacia() {
		return (inicio == null);
	}

	@Override
	public int tamanio() {
		return tamanio;
	}

}
