package monitores.ejercicio2;

public class Principal {

	public static void main(String[] args) {
		SecuenciadorTernario monitor = new SecuenciadorTernario();
		
		Thread h1 = new Thread(new Hilo(monitor, 1, 1));
		Thread h2 = new Thread(new Hilo(monitor, 1, 2));
		Thread h3 = new Thread(new Hilo(monitor, 2, 3));
		Thread h4 = new Thread(new Hilo(monitor, 3, 4));
		Thread h5 = new Thread(new Hilo(monitor, 3, 5));
		Thread h6 = new Thread(new Hilo(monitor, 2, 6));
		Thread h7 = new Thread(new Hilo(monitor, 1, 7));
		Thread h8 = new Thread(new Hilo(monitor, 3, 8));
		Thread h9 = new Thread(new Hilo(monitor, 1, 9));
		Thread h10 = new Thread(new Hilo(monitor, 2, 10));
		Thread h11 = new Thread(new Hilo(monitor, 1, 11));
		
		h1.start();
		h3.start();
		h5.start();
		h2.start();
		h6.start();
		h4.start();
		h7.start();
		h9.start();
		h10.start();
		h11.start();
		h8.start();
		
	}
}
