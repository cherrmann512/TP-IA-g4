package semaforos.ejercicio9;

import java.util.concurrent.Semaphore;

public class App {
	
	static Semaphore semGenerador = new Semaphore(0, false);
	static Semaphore semBolsa = new Semaphore(0);
	static int bolitas=0;
	
	public static void main(String[] args) {
		Thread g1 = new Thread(new Generador(1));
		Thread g2 = new Thread(new Generador(2));
		Thread g3 = new Thread(new Generador(3));
		Thread c1 = new Thread(new Consumidor(1));
		Thread c2 = new Thread(new Consumidor(2));
		
		g1.start();
		g2.start();
		g3.start();
		c1.start();
		c2.start();
		
		
	}
}
