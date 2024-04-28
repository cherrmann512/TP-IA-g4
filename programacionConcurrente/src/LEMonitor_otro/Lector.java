package LEMonitor_otro;

public class Lector implements Runnable {
	private LEMonitorOtro  mon = new LEMonitorOtro();
	private int id;
	
	public Lector (LEMonitorOtro m, int i) {
		mon = m;
		id = i;
		}
	
	public void run() {
		while (true) {
			mon.IniLeer(id);
			Principal.randomDelay(5,30);
			mon.FinLeer(id);
		}
		}

}
