package monitores.ejercicio7;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Juego {
	private Lock lock;
	private Condition otroJugador;
	
	private String palabraCorrecta;
	private long jugadorApuesta; //jugador que tiene la apuesta actual
	private boolean acertijoFinalizado;
	
	
	public Juego() {
		this.lock = new ReentrantLock();
		this.otroJugador = lock.newCondition();
		this.palabraCorrecta = "apuesta";
		this.acertijoFinalizado = false;
	}
	
	
	public boolean concluido() {
		return acertijoFinalizado;
	}
	
	public boolean apostar(String palabra, int apuesta) {
		boolean resultado=false;
		lock.lock();
		try {
			otroJugador.signal();
			if(acertijoFinalizado) {
				return false;
			}
			
			long jugador = Thread.currentThread().getId();
			if(jugadorApuesta == jugador ) { //no puede apostar dos veces consecutivas
				resultado = false;
			}
			if(palabraCorrecta.equals(palabra)) {
				acertijoFinalizado=true;
				System.out.println("jugador ID: "+jugador +" ganó "+apuesta*10);
				resultado = true;
			}else {
				//jugador no ha acertado
				jugadorApuesta = jugador;
				
				otroJugador.await();
				System.out.println("jugador ID: "+jugador +" NO ganó");
				resultado = false;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return resultado;
	}
	
	public void notificarOtroJugador() {
		lock.lock();
		try {
			if(acertijoFinalizado) {
				return;
			}
			otroJugador.signal();
		} finally {
			lock.unlock();
		}
	}
	
	
}
