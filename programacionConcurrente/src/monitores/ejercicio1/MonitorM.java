package monitores.ejercicio1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MonitorM {
private final Lock lock;
private int inicioSecuencia;
private Condition permiso, continuar, inicioSecuenciaCero;

public MonitorM(){
	lock = new ReentrantLock();
	permiso = lock.newCondition();
	continuar = lock.newCondition();
	inicioSecuenciaCero = lock.newCondition();
	inicioSecuencia = 0;
}
public void antesydespues(int id){
	lock.lock();
	try {
		if (inicioSecuencia == 0) {
			inicioSecuencia++;
			//antes
			System.out.println("id:"+id+"--ejecutado ANTES");
			permiso.signal();
			continuar.await();
			//después
			System.out.println("id:"+id+"--ejecutado DESPUES");
			inicioSecuencia--;
			inicioSecuenciaCero.signal();
		}
		else
			inicioSecuenciaCero.await();
	} catch (InterruptedException e) {
		e.printStackTrace();
	} 
	finally { lock.unlock();}
}

public void parte2 (int id) {
	lock.lock();
	try {
		permiso.await();
		//importante
		System.out.println("ide:"+id+"--ejecutado IMPORTANTE");
		continuar.signal();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	finally { lock.unlock();}
	
}
}
