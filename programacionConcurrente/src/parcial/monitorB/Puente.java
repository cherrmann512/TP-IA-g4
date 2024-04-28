package parcial.monitorB;

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
	
	
	
	public Puente() {
		this.lock = new ReentrantLock();
		this.atravesar = lock.newCondition();
		this.cambioSentido = lock.newCondition();
		this.esperaCola = lock.newCondition();
		this.autorizado = true;
		this.autosEnPuente = 0;
		this.cambioSentido = lock.newCondition();
	}
	
	public void llegarAlPuente (int sentido) {
		lock.lock();
		try {
			while(!autorizado) {
				esperaCola.await();
			}
			autosEnPuente++;
			if(sentido==1) {
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			
		}
	}
	
	public void atravesar(int id) {
		lock.lock();
		try {
			while(!autorizado) {
				esperaCola.await();
			}
			autosEnPuente--;
			
			if(autosEnPuente==0) {
				cambioSentido.signal();
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			lock.unlock();
		}
	}
	
	public void salirPuente() {
		
	}
	
	
}
