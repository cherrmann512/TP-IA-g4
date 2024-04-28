package semaforos.ejercicio5;

import java.util.concurrent.Semaphore;

public class Principal2 {
	static Semaphore semA = new Semaphore(1);
	static Semaphore semB = new Semaphore(0);
	
	public static void main(String[] args) {
		new Thread(new ProcesoA2()).start();
		new Thread(new ProcesoB2()).start();
	}
}
