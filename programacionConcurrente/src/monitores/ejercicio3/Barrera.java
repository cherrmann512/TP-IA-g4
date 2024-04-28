package monitores.ejercicio3;

public class Barrera {
	
	private int cantidadLetras = 0;
	private int n;
	private boolean escribir = false;

	
	public Barrera(int n) {
		this.n = n;
	}
	public Barrera() {}
	
	public synchronized void esperar() {
		try {
			cantidadLetras++;
			if(cantidadLetras == n) {
				notifyAll();
			}
			else {
				wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}

}
