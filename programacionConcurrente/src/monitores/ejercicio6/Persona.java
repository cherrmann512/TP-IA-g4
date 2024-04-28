package monitores.ejercicio6;

public class Persona implements Runnable{
	private Charla monitorCharla;
	private int id;
	
	public Persona(Charla monitorCharla, int id) {
		this.monitorCharla = monitorCharla;
		this.id = id;
	}
	
	@Override
	public void run() {
		monitorCharla.asistirACharla(id);
	}

}
