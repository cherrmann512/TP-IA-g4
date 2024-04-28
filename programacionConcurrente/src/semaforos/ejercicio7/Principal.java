package semaforos.ejercicio7;

import java.util.concurrent.Semaphore;

public class Principal {
	
	static Semaphore semSilla = new Semaphore(0,true);
	static Semaphore semSalir = new Semaphore(0,true);
	static Semaphore semBajar = new Semaphore(0,true);
	static Semaphore semLlegar = new Semaphore(0,true);
	
	public static void main(String[] args) {
		new Thread(new Transbordador()).start();
		for(int i=0; i<10; i++) {
			new Thread(new Persona(i)).start();
		}
	}

}
