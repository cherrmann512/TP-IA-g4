package semaforos.ejercicio5;

import java.util.concurrent.Semaphore;

public class Principal1 {

	static Semaphore semA = new Semaphore(1);
	static Semaphore semB = new Semaphore(1);
	
	public static void main(String[] args) {
		new Thread(new ProcesoA()).start();
		new Thread(new ProcesoB()).start();
		
		
	}

}
