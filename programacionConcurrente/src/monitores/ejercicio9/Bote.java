package monitores.ejercicio9;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bote {
	private Lock lock;
	private Condition lleno; //espera que se llene 
	private Condition vacio; //espera que se vacíe
	private Boolean autorizado;
	private Boolean enNorte;
	private int capacidad;
	private int pasajeros;
	
	public Bote(int capacidad) {
		this.lock = new ReentrantLock();
		this.lleno = lock.newCondition();
		this.vacio = lock.newCondition();
		this.autorizado = false;
		this.enNorte = true; //arranca inicialmente en la costa norte
		this.pasajeros = 0;
		this.capacidad = capacidad;
	}
	
	public void abordar() {
		lock.lock();
		try {
			while(!autorizado || pasajeros == capacidad) {
				lleno.await();
			}
			pasajeros++;
			if(capacidad == pasajeros) {
				vacio.signalAll();
			}
			System.out.println("persona abordando");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
	}
	
	public void cruzar() {
		lock.lock();
		try {
			while(!autorizado || pasajeros < capacidad) {
				vacio.await();
			}
			System.out.println("cruzando");
			enNorte = !enNorte;
			pasajeros = 0;
			autorizado = false;
			lleno.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void autorizar() {
		lock.lock();
		try {
			autorizado = true;
			lleno.signalAll();
		} finally {
			lock.unlock();
		}
	}

	
	

}
