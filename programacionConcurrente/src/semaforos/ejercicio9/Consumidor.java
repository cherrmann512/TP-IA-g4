package semaforos.ejercicio9;

import java.util.Random;

public class Consumidor implements Runnable{
	private int id;
	
	public Consumidor(int id) {
		this.id = id;
	}
	@Override
	public void run() {
		while(true) {
			// consumir de a 2
			App.semBolsa.acquireUninterruptibly();
			System.out.println("Consumidor " +this.id + " consume");
			App.semGenerador.release();
			App.semBolsa.acquireUninterruptibly(); //si aca consume seria la segunda bolita
			App.semGenerador.release();
			System.out.println("Consumidor ID "+this.id +"suma punto");
			try {
				Thread.sleep(new Random().nextInt(1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
