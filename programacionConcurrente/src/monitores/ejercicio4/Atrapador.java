package monitores.ejercicio4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Atrapador {
	private final Lock lock;
	private Condition hayN;
	private int cantidadN;
	
	public Atrapador() {
		super();
		this.lock = new ReentrantLock();
		this.hayN = lock.newCondition();
		this.cantidadN = 0;
	}
	
	public void esperar() {
		cantidadN++;
		lock.lock();
		try {
			hayN.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
//a	
	public void liberar(int N) {
		lock.lock();
		try {
			if(cantidadN >= N) {
				hayN.signalAll();
				System.out.println("libero "+cantidadN +" hilos");
				cantidadN=0;
				}
		}
		finally {
			lock.unlock();
		}
	}
//b
//	public void liberar(int N) {
//		lock.lock();
//		try {
//			if(cantidadN >= N) {
//				hayN.signalAll();
//				System.out.println("libero "+cantidadN +" hilos");
//				cantidadN=0;
//				}
//			else {
//				hayN.await();
//				cantidadN++;
//			}
//		}catch(InterruptedException e) {
//			e.printStackTrace();
//		}
//		finally {
//			lock.unlock();
//		}
//	}
}
