package monitores.ejercicio8;

public class Principal {

	public static void main(String[] args) {
		Bar monitor = new Bar(5,6);
	
		for(int i=0; i<10; i++) {
			Thread c = new Thread(new Cliente(monitor));
			c.start();
		}
		
	}

}