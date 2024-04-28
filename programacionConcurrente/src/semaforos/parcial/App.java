package semaforos.parcial;

import java.util.concurrent.Semaphore;

public class App {
	static final int CANTIDAD_MAXIMA = 20;
	static Semaphore visitantes = new Semaphore(0);
	static Semaphore colaboradores = new Semaphore(0);
	static Semaphore mutex = new Semaphore(1); //sincroniza el acceso a la capilla
	static int visitas = 0;
	static int colaboraciones = 0;
	static int velas = 0;
	
	public static void main(String[] args) {

		for(int i = 0; i < 10; i++) {
			new Thread(new Visitante(i+1)).start();
		}
		
		for(int i = 0; i < 5; i++) {
			new Thread(new Colaborador(i+1)).start();
		}
		
	}
	
}
