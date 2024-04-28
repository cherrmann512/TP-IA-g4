package LEMonitor_otro;

public class Principal {
	
	public static void main(String[] args) {
		LEMonitorOtro monitor = new LEMonitorOtro();
		
		for(int i=1; i<=20; i++) {
			Thread t = new Thread(new Lector(monitor,i));
			t.start();
		}
		for(int i=1; i<=7; i++) {
			Thread t = new Thread(new Escritor(monitor,i));
			t.start();
		}

	}

	public static void randomDelay(float min, float max){
		int random = (int)(max * Math.random() + min);
		try {
			Thread.sleep(random * 10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
