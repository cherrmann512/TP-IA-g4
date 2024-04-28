package parcial.semaforos;

public class Hilo implements Runnable{

	int id;
	
	
	
	public Hilo(int id) {
		this.id = id;
	}


	@Override
	public void run() {
		if(App.hilosEsperando < App.requerido) {
			System.out.println("hilo id: "+ id + " llega a la barrera" );
		}
		App.barr.espera();
		System.out.println("hilo id: "+ id + " Cruzo la barrera" );
		
	}

}
