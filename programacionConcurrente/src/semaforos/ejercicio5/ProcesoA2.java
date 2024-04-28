package semaforos.ejercicio5;

import java.util.Random;

public class ProcesoA2 implements Runnable{

	@Override
	public void run() {
		while(true) {
			Principal2.semA.acquireUninterruptibly();
			System.out.println("A");
			Principal2.semB.release();
			try {
				Thread.sleep(new Random().nextInt(1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
