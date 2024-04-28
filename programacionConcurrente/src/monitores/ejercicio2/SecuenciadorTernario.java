package monitores.ejercicio2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SecuenciadorTernario  {
	private final Lock lock;
	private Condition prim, seg, ter;
	private boolean inicioPrimero = true, inicioSegundo = false, inicioTercero = false;
	
	
	public SecuenciadorTernario() {
		lock = new ReentrantLock();
		prim = lock.newCondition();
		seg = lock.newCondition();
		ter = lock.newCondition();
		
	}
	

	public void primero(int id) {
		lock.lock();
		try {
			if (!inicioPrimero) {
				prim.await();
			}else {
				System.out.println("id: "+id +" Primero");
				inicioPrimero = false;
				inicioSegundo=true;
				seg.signal();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();}
	}

	public void segundo(int id) {
			lock.lock();
			try {
				if(!inicioSegundo) {
					seg.await();
				}
				else {
					System.out.println("id: "+id +" Segundo");
					inicioSegundo = false;
					inicioTercero = true;
					ter.signal();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				lock.unlock();
			}
	}
	
	public void tercero(int id) {
		lock.lock();
		try {
			if(!inicioTercero) {
				ter.await();
			}
			else {
				System.out.println("id: "+id +" Tercero");
				inicioTercero = false;
				inicioPrimero = true;
				prim.signal();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
	}
	
}
