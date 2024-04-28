package monitores.ejercicio1;

public class AntesyDespues implements Runnable {
	private MonitorM monitor;
	private int id;
	public AntesyDespues(MonitorM monitor, int id) {
		this.monitor = monitor;
		this.id = id;
		
	}
	public void run() {
		while(true) {
			monitor.antesydespues(id);
			Principal.randomDelay(1,10);
		}
	}

}
