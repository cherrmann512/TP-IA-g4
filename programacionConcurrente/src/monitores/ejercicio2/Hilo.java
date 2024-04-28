package monitores.ejercicio2;

public class Hilo implements Runnable{
	private SecuenciadorTernario monitor;
	private int id;
	private int numProceso;
	
	
	public Hilo(SecuenciadorTernario monitor, int numProceso, int id) {
		this.monitor = monitor;
		this.numProceso = numProceso;
		this.id = id;
	}


	@Override
	public void run() {
		switch (numProceso) {
		case 1: {
			monitor.primero(id);
			break;
			}	
		case 2: {
			monitor.segundo(id);
			break;
			}	
		case 3: {
			monitor.tercero(id);
			break;
			}
		}
	}
	
}
