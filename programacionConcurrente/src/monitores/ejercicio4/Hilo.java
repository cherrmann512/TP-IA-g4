package monitores.ejercicio4;

public class Hilo implements Runnable{
	private int numero; 
	private Atrapador atrapador = new Atrapador();
	private int numProceso; //1 para esperar 2 para liberar
	private int cantidad; //cantidad que quiere liberar
	
	
	public Hilo(int numero, Atrapador atrapador, int numProceso, int cantidad) {
		super();
		this.numero = numero;
		this.atrapador = atrapador;
		this.numProceso = numProceso;
		this.cantidad = cantidad;
	}

	@Override
	public void run() {
		if(numProceso == 1) {
			System.out.println("hilo id: "+numero +" espera");
		atrapador.esperar();
		}
		if(numProceso == 2) {
			atrapador.liberar(cantidad);
			System.out.println("hilo id: "+numero +" llama a liberar");
		}
	}
}
