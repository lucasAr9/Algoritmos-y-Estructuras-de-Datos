package pruebas;

public class pru {

	public static void main(String[] args) {

		Long suma = (long) 0;
		long antes = System.currentTimeMillis();
		System.out.println(antes);
		for (int i = 0; i < Integer.MAX_VALUE; i++){
		 suma += i; 
		}
		long despues = System.currentTimeMillis();
		System.out.println(despues);
		
		long suma2 = 0;
		long antes2 = System.currentTimeMillis();
		System.out.println(antes2);
		for (int i = 0; i < Integer.MAX_VALUE; i++){
		 suma2 += i; 
		}
		long despues2= System.currentTimeMillis();
		System.out.println(despues2);
	}

}
