package semaforos.filosofos;

import java.util.concurrent.Semaphore;

public class Filosofo implements Runnable {
	final static int N = 5;
	static Semaphore sillas = new Semaphore (4,true);
	static Semaphore [] tenedores = {new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1)};
	
	private int id;
	
	public Filosofo(int i) {
		id = i;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (int i = 0;i<=N-1; i++ )
			new Thread(new Filosofo(i)).start();
			
	}

	public void run() {
		// TODO Auto-generated method stub
		while (true){
		System.out.println("pensando filósofo id:"+id);
		sillas.acquireUninterruptibly();
		tenedores[id].acquireUninterruptibly();
		tenedores[(id+1)% N].acquireUninterruptibly();
		System.out.println("comiendo filósofo id:"+id);
		tenedores[id].release();
		tenedores[(id+1)% N].release();
		sillas.release();
	
		randomDelay(10,20);
		}
		
		
	}
	void randomDelay(float min, float max){
		int random = (int)(max * Math.random() + min);
		try {
			Thread.sleep(random * 10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}