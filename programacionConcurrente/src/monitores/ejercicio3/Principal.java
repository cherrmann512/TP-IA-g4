package monitores.ejercicio3;

public class Principal {

	public static void main(String[] args) {
		Barrera monitor = new Barrera(3);
		Thread h1 = new Thread(new Hilo('a', 1, monitor));
		Thread h2 = new Thread(new Hilo('b', 2, monitor));
		Thread h3 = new Thread(new Hilo('c', 3, monitor));
		h1.start();
		h2.start();
		h3.start();
	}
	
}
