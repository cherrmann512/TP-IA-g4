package semaforos.ejercicio5;

import java.util.Random;

public class ProcesoB implements Runnable{

	@Override
	public void run() {
		while(true) {
			Principal1.semB.acquireUninterruptibly();
			System.out.println("B ");
			Principal1.semA.release();
			try {
				Thread.sleep(new Random().nextInt(1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
