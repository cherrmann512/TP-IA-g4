package parcial.semaforos;

public class Barrera {
	int requerido;
	
	
	
	public Barrera(int requerido) {
		this.requerido = requerido;
	}

	public void espera() {
		try {
			App.mutex.acquireUninterruptibly();
			App.hilosEsperando++;
			App.mutex.release();
			if(App.hilosEsperando == requerido-1) {

				System.out.println("falta un proceso (el actual) y se levanta la barrera");
				App.barrera.release(requerido);
			}
			App.barrera.acquireUninterruptibly();
			App.mutex.acquireUninterruptibly();
			App.hilosEsperando--;
			App.mutex.release();
			if (App.hilosEsperando<=0) {
				App.barrera.release(requerido); //abre la barrera para los hilos adicionales
				System.out.println("Barrera Levantada");
				App.hilosEsperando--; //lo decremento para que no muestre el mensaje cada vez que llega un nuevo hilo y ya la barrera esta levantada
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
