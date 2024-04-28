package parcial.monitorA;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Puente {
	private Lock lock;
	private Condition atravesar; //espera para atravesar
	private Condition cambioSentido; //cuando un auto quiere atravesar del otro sentido y no hay nadie lo puede hacer
	private Condition esperaCola;// autos esperan para atravesar
	private int autosEnPuente;
	private Boolean autorizado;
	private int sentidoActual;
	
	
	//para el inciso B debo usar una variable cantidadMaxima que si es 3 me obliga el cambio de sentido
	public Puente() {
		this.lock = new ReentrantLock();
		this.atravesar = lock.newCondition();
		this.cambioSentido = lock.newCondition();
		this.esperaCola = lock.newCondition();
		this.autorizado = true;
		this.autosEnPuente = 0;
		this.cambioSentido = lock.newCondition();
		this.sentidoActual = 0; //arrancan en este sentido solo para inicialiazr la variable
	}
	
	public void llegarAlPuente (int sentido) {
		lock.lock();
		try {
			while(!autorizado) {
				esperaCola.await();
			}
			autosEnPuente++;
			if (sentido!=sentidoActual) {
				atravesar.await();
				cambioSentido.await();
				esperaCola.await();
			}
			if(sentido==1) {
				System.out.println("cuzando de 1 a 0");
			}else {
				System.out.println("cruzando de 0 a 1");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			lock.unlock();
		}
	}
	
	public void atravesar(int id) {
		lock.lock();
		try {
			while(!autorizado) {
				esperaCola.await();
			}
			atravesar.signal();
			autosEnPuente++;
			System.out.println("cruzando auto id" +id);
			Thread.sleep(2000);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			lock.unlock();
		}
	}
	
	public void salirPuente(int id) {
		lock.lock();
		try {
			System.out.println("auto id:" +id +" salio");
			autosEnPuente--;
			if(autosEnPuente==0) {
				cambioSentido.signal();
				esperaCola.signalAll();
				atravesar.signal();
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			lock.unlock();
		}
	}
	
	
}
