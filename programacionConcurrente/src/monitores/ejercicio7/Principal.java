package monitores.ejercicio7;

public class Principal {
	
	public static void main(String[] args) {
		Juego juego = new Juego();

	    Thread jugador1 = new Thread(new Jugador("aa", 1, juego));
	    Thread jugador2 = new Thread(new Jugador("a", 5, juego));
	    Thread jugador3 = new Thread(new Jugador("apuesta", 10, juego));
	    
	    jugador1.start();
	    jugador2.start();
	    jugador3.start();
	    
	}
	
	


}