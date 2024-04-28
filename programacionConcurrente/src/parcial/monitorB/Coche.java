package parcial.monitorB;

public class Coche implements Runnable{
	private Puente monitorPuente;
	private int id;
	private int sentido; //1 para sentido norte 0 para el otro sentido (sur)
	
	public Coche(int id,Puente monitorPuente, int sentido) {
		this.monitorPuente = monitorPuente;
		this.id = id;
		this.sentido = sentido;
	}
	
	@Override
	public void run() {
		monitorPuente.llegarAlPuente(sentido);
		monitorPuente.atravesar(id);
		monitorPuente.salirPuente();
		
	}
	
}
