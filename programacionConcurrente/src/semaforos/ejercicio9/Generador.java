package semaforos.ejercicio9;

import java.util.Random;

public class Generador implements Runnable{
	private int id;
	
	public Generador(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		App.semGenerador.release();
		while(true) {
			//producir y guardar en bolsa si puede
				App.semGenerador.acquireUninterruptibly();
				App.semBolsa.release();
				System.out.println("Generador ID: "+this.id +" agrega una bolita");
				App.semGenerador.release();
			try {
				Thread.sleep(new Random().nextInt(1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
		
	}

}
