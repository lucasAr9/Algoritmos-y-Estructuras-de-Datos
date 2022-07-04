package punto_3;

import java.util.Random;

public class Test {

	public static String nombresRandom() {
		Random r = new Random();
		String nombre;
		int num = r.nextInt(6);
		
		switch (num) {
		case 1:
			nombre = "Lucas";
			break;
		case 2:
			nombre = "Juan";
			break;
		case 3:
			nombre = "Hernan";
			break;
		case 4:
			nombre = "Jose";
			break;
			
		default:
			nombre = "Ricardo";
			break;
		}
		return nombre;
	}
	
	public static String apellidoRandom() {
		Random r = new Random();
		String nombre;
		int num = r.nextInt(6);
		
		switch (num) {
		case 1:
			nombre = "Perez";
			break;
		case 2:
			nombre = "Garmendia";
			break;
		case 3:
			nombre = "Gonzales";
			break;
		case 4:
			nombre = "Vivaldi";
			break;

		default:
			nombre = "Ford";
			break;
		}
		return nombre;
	}
	
	public static void main(String[] args) {
		
		Random r = new Random();
		
		Estudiante[] estudiantes = new Estudiante[2];
		Profesor[] profesores = new Profesor[3];
		
		for (int i = 0; i < 2; i++) {
			String nombre = Test.nombresRandom();
			String ape = Test.apellidoRandom();
			String email = nombre + ape + "@gmail.com";
			int comision = r.nextInt(8);
			String direc = "una calle de LP";
			
			Estudiante e = new Estudiante(nombre, ape, email, comision, direc);
			estudiantes[i] = e;
		}
		
		for (int i = 0; i < 3; i++) {
			String nombre = Test.nombresRandom();
			String ape = Test.apellidoRandom();
			String email = nombre + ape + "@gmail.com";
			String cate = "AyED";
			String facu = "Informatica";
			
			Profesor p = new Profesor(nombre, ape, email, cate, facu);
			profesores[i] = p;
		}
		
		for (int i = 0; i < 2; i++) {			
			System.out.println(estudiantes[i].toString());
		}
		for (int i = 0; i < 3; i++) {			
			System.out.println(profesores[i].toString());
		}
	}
	
}
