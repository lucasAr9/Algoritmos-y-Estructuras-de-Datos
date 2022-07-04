package mergeSort;

public class mergeSort {

	public static void main(String[] args) {

		// probar el merge sort con un arreglo
	}

	// merge sort
	public static void merge(int[] a, int izq, int m, int der) {
		int i, j, k;
		int[] b = new int[a.length]; // array auxiliar
		
		for (i = izq; i <= der; i++) { // copia ambas mitades en el array auxiliar
			b[i] = a[i];
		}
		
		i = izq;
		j = m + 1;
		k = izq;
		
		while (i <= m && j <= der) { // copia el siguiente elemento mas grande
			if (b[i] <= b[j])
				a[k++] = b[i++];
			else
				a[k++] = b[j++];
		}
		while (i <= m) { // copia los elementos que quedan de la
			a[k++] = b[i++]; // primera mitad (si los hay)
		}
	}
}
