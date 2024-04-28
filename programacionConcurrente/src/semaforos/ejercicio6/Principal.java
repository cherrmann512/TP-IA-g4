package semaforos.ejercicio6;

import java.util.concurrent.Semaphore;

public class Principal {
	static int n = 3;
	static int n2 = 0;
	static Semaphore sem1 = new Semaphore(0);
	static Semaphore sem2 = new Semaphore(1);

	public static void main(String[] args) {
		new Thread(new Proceso1()).start();
		new Thread(new Proceso2()).start();
		
	}
}
