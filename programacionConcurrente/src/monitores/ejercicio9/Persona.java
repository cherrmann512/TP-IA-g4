package monitores.ejercicio9;

public class Persona implements Runnable {

	private Bote monitorBote;
	private int id;
	
	public Persona(Bote monitorBote, int id) {
		this.monitorBote = monitorBote;
		this.id = id;
	}
	
	@Override
	public void run() {
		while(true) {
			monitorBote.abordar();
			System.out.println("id: "+this.id+ " abordo");
			monitorBote.cruzar();
			System.out.println("cruzaron todos");
		}

	}

}
