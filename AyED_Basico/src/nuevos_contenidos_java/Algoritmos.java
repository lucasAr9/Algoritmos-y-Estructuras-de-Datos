package nuevos_contenidos_java;

public class Algoritmos {

	// un objeto pasado por valor que modifica la variable de instancia
	// como pasado por referencia, esto con tipos de datos primitivos no pasa.
	// con tipos de datos primitivos solo se puede pasar por valor.
	public static void cambiarNombre(Contacto c) {
		c.setNombre("Pilar");
	}
	
	public static void main(String[] args) {

		String[] items = { "item1", "item2", "item3", "item4", "item5" };

		// con length() sabemos el final del arreglo
		for (int i = 0; i < items.length; i++) {
			System.out.print(items[i] + ", ");
		}

		// un for each
		System.out.println("");
		for (String elem : items) {
			System.out.print(elem + ", ");
		}

		// en el caso de que sea una matriz
		System.out.println("");
		int[][] notas = { { 66, 78, 78, 89, 88, 90 },
						{ 76, 80, 80, 82, 90, 90 },
						{ 90, 92, 87, 83, 99, 94 } };

		for (int[] fila : notas) {
			for (int elem : fila) {
				System.out.print(elem + ", ");
			}
			System.out.println("");
		}

		// pasaje de parametros solo por valor
		Contacto c = new Contacto("Luis");

		Algoritmos.cambiarNombre(c);
		System.out.println(c.getNombre());
	}
	
	// manejo de excepciones
//	try () {
//		// codigo normal
//	} catch (Exception e) {
//		// comportamiento de las excepciones
//	}
	
	// manejo de excepciones con el finally
//	try () {
//		// codigo normal
//	} catch (Exception e) {
//		// comportamiento de las excepciones
//	} finally {
//		//siempre se va a ejecutar sin importar si pasa por try o catch
//	}
}
