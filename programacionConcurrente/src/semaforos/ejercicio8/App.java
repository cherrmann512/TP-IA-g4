package semaforos.ejercicio8;

import java.util.concurrent.Semaphore;

public class App {
	static Semaphore ap = new Semaphore(4);
	static Semaphore discos = new Semaphore(50);
	static Semaphore turno = new Semaphore(1,true); //se encontraria caso de Inanizcion si el semaforo fuera debil
	
	public static void main(String[] args) {
		
		for (int i=1; i<=10; i++) {
			new Thread(new Persona(i,
					(int)( 4 *Math.random()+1),
					(int)(50 *Math.random()+1))).start();
		}
	}

}
