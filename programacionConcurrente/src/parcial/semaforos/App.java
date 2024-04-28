package parcial.semaforos;

import java.util.concurrent.Semaphore;

public class App {
	static final int requerido = 5;
	static Semaphore barrera = new Semaphore(0);
	static Semaphore mutex = new Semaphore(1);
	static int hilosEsperando = 0;
	static Barrera barr =  new Barrera(requerido);
	
	
	public static void main(String[] args) {
		for(int i=0; i<requerido*2; i++) {
			new Thread(new Hilo(i+1)).start();
		}
	}

}
