package punto_5;

public class MinMaxPro {

	private int minimo = 999;
	private int maximo = -1;
	private double promedio = 0;

	public int getMinimo() {
		return minimo;
	}

	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}

	public int getMaximo() {
		return maximo;
	}

	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}

	public double getPromedio() {
		return promedio;
	}

	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}

	@Override
	public String toString() {
		return "minimo= " + minimo + ", maximo= " + maximo
				+ ", promedio= " + promedio;
	}
}
