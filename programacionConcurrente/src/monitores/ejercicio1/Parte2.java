package monitores.ejercicio1;

public class Parte2 implements Runnable{
	private MonitorM monitor;
	private int id;
	
	public Parte2(MonitorM monitor, int id) {
		this.monitor = monitor;
		this.id = id;
	}
	public void run() {
		monitor.parte2(id);
	}
		
}
