package monitores.ejercicio6;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Charla {

	private final Lock lock;
	private Condition salaVacia; //el orador espera para dar la charla
	private Condition hayLugar; //las personas esperan para ingresar
	private Condition enSala; //las personas que estan en la sala
	
	private int cantidadAsistentes; 
	private boolean entrada;
	
	public Charla() {
		this.lock = new ReentrantLock();
		this.salaVacia = lock.newCondition();
		this.hayLugar = lock.newCondition();
		this.enSala = lock.newCondition();
		this.cantidadAsistentes = 0;
		this.entrada = true;

	}
		
	public void iniciarCharla() {
		lock.lock();
		try {
			while(cantidadAsistentes == 0) {
				System.out.println("Descanso de 5 minutos por sala vacía");
				lock.unlock(); 
				Thread.sleep(5000);
				lock.lock(); 
			}
			entrada=false;
			System.out.println("Orador dando charla");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void asistirACharla(int id) {
		lock.lock();
		try {
			while(!entrada) {
				hayLugar.await();
			}
			cantidadAsistentes++;
			if(cantidadAsistentes==50) {
				entrada=false;
			}
			enSala.await();
			cantidadAsistentes--;
			if(cantidadAsistentes==0) {
				entrada = true;
				salaVacia.signal();
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	
	public void terminarCharla() {
		lock.lock();
		try {
			System.out.println("Orador termina charla");
			enSala.signalAll();
			salaVacia.await(); 
			hayLugar.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
}
