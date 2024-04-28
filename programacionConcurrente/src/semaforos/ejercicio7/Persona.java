package semaforos.ejercicio7;

public class Persona implements Runnable{
	private int id;
	public Persona(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		Principal.semSilla.acquireUninterruptibly();
		System.out.println("Persona id: "+this.id +" se sube");
		Principal.semSalir.release();
		Principal.semLlegar.acquireUninterruptibly();
		System.out.println("Persona id: "+this.id +" se bajó");
		Principal.semBajar.release();

	}

}
