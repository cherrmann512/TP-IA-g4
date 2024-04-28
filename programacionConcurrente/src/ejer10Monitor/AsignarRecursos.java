package ejer10Monitor;
import java.util.LinkedList;
import java.util.Queue;

public class AsignarRecursos {
	static int maxRecursos = 4;
	Queue<Recurso> recursos;
	private Integer cantEsperando =0; //espera para tomar un recurso
	
	public AsignarRecursos() {
		Queue<Recurso> recursos = new LinkedList<>();
		for(int i =0; i<maxRecursos; i++) {
			recursos.add(new Recurso (i));
		}
	}
	
	public synchronized Recurso tomar() {
		while(recursos.isEmpty()) {
			try {
				cantEsperando++;
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return recursos.poll();
	}
	
	public synchronized void liberar(Recurso rLiberar) {
		recursos.add(rLiberar);
		if(cantEsperando>0) {
			cantEsperando--;
			notify();
		}
	}
}
