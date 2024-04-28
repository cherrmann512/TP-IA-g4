package semaforos.parcial;

public class Visitante implements Runnable{
	int id;
	

	public Visitante(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true) {
				App.mutex.acquireUninterruptibly();
				App.visitas++;
				if(App.velas < App.visitas) {
					System.out.println("Visitante "+ id + " coloca una vela" );
					Thread.sleep(1000); // Simula tiempo que tarda un visitante en llegar
					App.velas++;
					System.out.println("velas en total: "+ App.velas);
					App.visitantes.release();
				}
				App.mutex.release();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
