package semaforos.ejercicio7;

public class Transbordador implements Runnable{
	
	int n=2;
	
	@Override
	public void run() {
		while(true) { 
			System.out.println("SUBIENDO");
			Principal.semSilla.release(n);
			Principal.semSalir.acquireUninterruptibly(n);
			System.out.println("CRUZANDO");
			System.out.println("BAJANDO");
			Principal.semLlegar.release(n);
			Principal.semBajar.acquireUninterruptibly(n);
		}
		
	}

}
