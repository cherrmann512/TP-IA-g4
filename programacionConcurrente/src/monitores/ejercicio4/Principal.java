package monitores.ejercicio4;

public class Principal {

	public static void main(String[] args) {
		Atrapador monitor = new Atrapador();
		Thread h1 = new Thread(new Hilo(1,monitor,1,1));
		Thread h2 = new Thread(new Hilo(2,monitor,1,2));
		Thread h3 = new Thread(new Hilo(3,monitor,1,1));
		Thread h4 = new Thread(new Hilo(4,monitor,1,2));
		Thread h5 = new Thread(new Hilo(5,monitor,2,2));
		Thread h6 = new Thread(new Hilo(6,monitor,1,1));
		Thread h7 = new Thread(new Hilo(7,monitor,1,1));
		Thread h8 = new Thread(new Hilo(8,monitor,2,2));
		
		h1.start();
		h2.start();
		h3.start();
		h4.start();
		h5.start();
		h6.start();
		h7.start();
		h8.start();
	}

}
