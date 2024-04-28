package monitores.ejercicio5;

public class Principal {

	public static void main(String[] args) {
		Pelu monitor = new Pelu();
		
		Thread p1 = new Thread(new Peluquero(1, monitor));
		Thread p2 = new Thread(new Peluquero(2, monitor));
		Thread p3 = new Thread(new Peluquero(3, monitor));
		Thread c1 = new Thread(new Cliente(1, monitor));
		Thread c2 = new Thread(new Cliente(2, monitor));
		Thread c3 = new Thread(new Cliente(3, monitor));
		Thread c4 = new Thread(new Cliente(4, monitor));
		Thread c5 = new Thread(new Cliente(5, monitor));
		Thread c6 = new Thread(new Cliente(6, monitor));
		p1.start();
		p2.start();
		p3.start();
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();
		c6.start();
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
