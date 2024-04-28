	package semaforos.ejercicio8;

import java.util.Random;

public class Persona implements Runnable{
	private int id;
	private int aparato;
	private int cantDiscos;

	public Persona (int id, int aparato, int cantDiscos) {
		this.id = id;
		this.aparato = aparato;
		this.cantDiscos = cantDiscos;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		App.ap.acquireUninterruptibly();
		App.turno.acquireUninterruptibly();
//		for(int i = 0; i<cantDiscos; i++) {
//			App.discos.acquireUninterruptibly();
//		}
		App.discos.acquireUninterruptibly(cantDiscos);
		App.turno.release();
		try {
			Thread.sleep(new Random().nextInt(1000));
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("persona: "+this.id +" haciendo ejercicio " + this.aparato);
		for(int i = 0; i<cantDiscos; i++) {
			App.discos.release();
		}
		App.ap.release();
		
	}
}