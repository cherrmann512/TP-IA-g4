package semaforos.ejercicio5;

import java.util.Random;

public class ProcesoB2 implements Runnable{

	@Override
	public void run() {
		while(true) {
			Principal2.semB.acquireUninterruptibly();
			System.out.println("B");
			Principal2.semA.release();
			try {
				Thread.sleep(new Random().nextInt(1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
