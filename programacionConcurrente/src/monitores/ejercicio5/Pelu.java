package monitores.ejercicio5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Pelu {
	private final Lock lock;
	
	private Condition hayClientes; //peluqueros esperando clientes
	private Condition enCorte; //clientes cortandose el pelo. los clientes se bloquean hasta que el peluquero termina de cortarles el pelo y los desbloquea
	private Condition hayPeluqueros; //clientes esperando peluqueros
	
	private int clientes=0; //cantidad de clientes que quieren cortarse el pelo 
	
	public Pelu() {
		this.lock = new ReentrantLock();
		this.hayClientes = lock.newCondition();
		this.enCorte = lock.newCondition();
		this.hayPeluqueros = lock.newCondition();
	}
	
	public void empezarCorte(int p) {
		lock.lock();
		System.out.println("Peluquero id: "+p +" disponible");
		try {
			while(clientes==0) {
				hayClientes.await();
			}
			clientes--;
			hayPeluqueros.signal();//un peluquero empieza a cortar
			System.out.println("Peluquero id: "+p +" empieza a cortar el pelo");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	public void cortarseElPelo(int c){
		lock.lock();
		System.out.println("Cliente id: "+c +" quiere cortarse el pelo");
		try {
			clientes++;
			hayClientes.signal();
			System.out.println("Cliente id: "+c +" espera para cortarse el pelo");
			hayPeluqueros.await();
			System.out.println("Cliente id: "+c +" en corte");
			enCorte.await(); //se esta cortando el pelo
			System.out.println("Cliente id: "+c +" se va");
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			lock.unlock();
		}
	}
	
	public void terminarCorte(int p) {
		lock.lock();
		System.out.println("Peluquero id: "+p +" termina el corte");
		try {
			enCorte.signal();
		}finally {
			lock.unlock();
		}
	}
	
}
