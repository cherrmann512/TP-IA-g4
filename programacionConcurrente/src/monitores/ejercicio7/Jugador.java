package monitores.ejercicio7;

public class Jugador implements Runnable{
	private String palabra;
	private int apuesta;
	private Juego monitorJuego;
	
	public Jugador(String palabra, int apuesta, Juego monitorJuego) {
		this.palabra = palabra;
		this.apuesta = apuesta;
		this.monitorJuego = monitorJuego;
	}

	@Override
	public void run() {
		if(monitorJuego.apostar(palabra, apuesta)) {
			System.out.println("gano");
		} else {
			System.out.println("Perdio");
		}
		
	}
	
	
	
	
}
