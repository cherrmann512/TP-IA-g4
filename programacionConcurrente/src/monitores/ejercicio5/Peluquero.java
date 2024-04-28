package monitores.ejercicio5;

public class Peluquero implements Runnable{
	private int id;
	private Pelu pelu;
	
	public Peluquero(int id, Pelu pelu) {
		this.id = id;
		this.pelu = pelu;
	}

	@Override
	public void run() {
		while (true) {
			pelu.empezarCorte(id);
			Principal.randomDelay(10,50);
			pelu.terminarCorte(id);
			Principal.randomDelay(10,50);
		}
		
	}
	
}
