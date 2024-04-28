package monitores.ejercicio8;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bar { 
	private final Lock lock;
	private Condition hayPizzasGrandes;
	private Condition hayPizzasChicas;
	
	private int pizzasGrandes;
	private int pizzasChicas;
	
	
	public Bar(int pizzasGrandes, int pizzasChichas) {
		this.lock = new ReentrantLock();
		this.hayPizzasGrandes = lock.newCondition();
		this.hayPizzasChicas = lock.newCondition();
		this.pizzasGrandes = pizzasGrandes;
		this.pizzasChicas = pizzasChichas;
	}
	
	public String obtenerPizza() {
		String resultado = "";
		lock.lock();
		try {
			while(pizzasGrandes == 0) {
				hayPizzasGrandes.await();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			lock.unlock();
		}
		return resultado;
	}
		
	
}



//if(pizzasGrandes > 0) {
//	pizzasGrandes--;
//	resultado = "pizza Grande";
//}
//else
//	resultado = "Dos pizzas pequeñas";