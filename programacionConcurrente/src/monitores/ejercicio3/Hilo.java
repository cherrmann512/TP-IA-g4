package monitores.ejercicio3;

public class Hilo implements Runnable {

	private char letra;
	private int numero;
	private Barrera barrera = new Barrera();
	
	public Hilo(char letra, int numero, Barrera barrera) {
		this.letra = letra;
		this.numero = numero;
		this.barrera = barrera;
	}
	
	@Override
	public void run() {
		System.out.println("imprime letra: " +letra);
		barrera.esperar();
		System.out.println("imprime numero: "+numero);
	}
	

}
