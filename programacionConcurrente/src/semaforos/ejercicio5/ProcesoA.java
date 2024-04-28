package semaforos.ejercicio5;

import java.util.Random;

public class ProcesoA implements Runnable{

	@Override
	public void run() {
		while (true) {
			Principal1.semA.acquireUninterruptibly();
			System.out.println("A");
			Principal1.semB.release();
			try {
				Thread.sleep(new Random().nextInt(1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
