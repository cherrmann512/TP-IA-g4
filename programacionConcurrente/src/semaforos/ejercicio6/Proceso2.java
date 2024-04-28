package semaforos.ejercicio6;

public class Proceso2 implements Runnable{
	
	@Override
	public void run() {
		while(true) {
			Principal.sem2.acquireUninterruptibly();
			Principal.n2 = Principal.n2 + 2*Principal.n-1;
			Principal.sem1.release();
		}
		
	}

}
