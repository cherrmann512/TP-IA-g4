package monitores.ejercicio9;

public class Principal {
	
	
	public static void main(String[] args) {
		Bote monitor = new Bote(3);
		Thread p1 = new Thread(new Persona(monitor, 1));
		Thread p2 = new Thread(new Persona(monitor, 2));
		Thread p3 = new Thread(new Persona(monitor, 3));
		Thread p4 = new Thread(new Persona(monitor, 4));
		Thread p5 = new Thread(new Persona(monitor, 5));
		Thread p6 = new Thread(new Persona(monitor, 6));
		Thread p7 = new Thread(new Persona(monitor, 7));
		Thread p8 = new Thread(new Persona(monitor, 8));
		
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		p6.start();
		p7.start();
		p8.start();
		
		while (true) {
			monitor.autorizar();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		
	}
	
	
}
