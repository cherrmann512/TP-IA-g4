package LEMonitor_otro;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class LEMonitorOtro {
private final Lock lock;
private Condition c;
int readIn, readOut;
boolean writer;

public LEMonitorOtro() {
	lock  = new ReentrantLock();
	c = lock.newCondition();
	writer = false;
	readIn = 0;
	readOut = 0;
}
public void IniLeer(int id) {
	lock.lock();
	try {
		while (writer)
			c.await();
		readIn ++;
		System.out.println("Inicia lectura id: "+id);
	}
	catch (InterruptedException e) {e.printStackTrace();}
	finally {
		lock.unlock();
	}
}
public void FinLeer(int id) {
	lock.lock();
	try {
		readOut ++;
		System.out.println("Fin lectura id: "+id);
		if (readIn == readOut)
			c.signalAll();
		}
	finally {
		lock.unlock();
	}
}
public void IniEscribir(int id) {
	lock.lock();
	try {
		while (writer)
			c.await();
		writer = true;
		while (readIn != readOut)
			c.await();
		System.out.println("Inicia escritura id: "+id);
	}
	catch (InterruptedException e) {e.printStackTrace();}
	finally {
		lock.unlock();
	}
}
public void FinEscribir(int id) {
	lock.lock();
	try {
		writer = false;
		System.out.println("Fin escritura id: "+id);
		c.signalAll();
	}
	finally {
		lock.unlock();
	}
}
}

