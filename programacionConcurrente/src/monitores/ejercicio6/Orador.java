package monitores.ejercicio6;

public class Orador implements Runnable{
	private Charla monitorCharla;
	
	public Orador(Charla monitorCharla) {
		this.monitorCharla = monitorCharla;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				monitorCharla.iniciarCharla();
				monitorCharla.terminarCharla();
				System.out.println("Descanso 5 minutos entre charla");
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	

}
