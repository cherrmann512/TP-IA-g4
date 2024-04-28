package LEMonitor_otro;

public class Escritor implements Runnable {
	private LEMonitorOtro  mon = new LEMonitorOtro();
	private int id;
	
	public Escritor (LEMonitorOtro m, int i) {
		mon = m;
		id = i;
		}
	
	public void run() {
		while (true) {
			mon.IniEscribir(id);
			Principal.randomDelay(10,50);
			mon.FinEscribir(id);
			Principal.randomDelay(10,50);
	}
		}

}