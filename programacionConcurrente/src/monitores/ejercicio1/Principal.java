package monitores.ejercicio1;

public class Principal {
	public static void main (String[] args) {
		MonitorM monitor = new MonitorM();
		
		for(int i=0; i< 4; i++ ) {
			Thread p = new Thread(new Parte2(monitor,i));
			p.start();
		}
		for(int i=10; i <14; i++) {
			Thread aD = new Thread(new AntesyDespues(monitor,i));
			aD.start();
		}
	}
	public static void randomDelay(float min, float max){
		int random = (int)(max * Math.random() + min);
		try {
			Thread.sleep(random * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
