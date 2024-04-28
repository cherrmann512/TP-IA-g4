package semaforos.ejercicio6;

public class Proceso1 implements Runnable{
	@Override
	public void run() {
		while(Principal.n>0) {
			Principal.sem1.acquireUninterruptibly();
			Principal.n--;
			if(Principal.n>0) {
				Principal.sem2.release();
			}
		}
		System.out.println(Principal.n2);
	}

}
