package semaforos.parcial;

public class Colaborador implements Runnable {
	int id;
	
	public Colaborador(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true) {
				App.visitantes.acquireUninterruptibly();
				App.mutex.acquireUninterruptibly();
				if(App.velas>=2) {
					System.out.println("Colaborador "+ id + " retira dos velas" );
					App.velas -=2;
					App.colaboraciones++;
				}
				App.mutex.release();
				App.colaboradores.release();
				Thread.sleep(2000); //simula tiempo que tarda un colaborador en retirar velas
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
