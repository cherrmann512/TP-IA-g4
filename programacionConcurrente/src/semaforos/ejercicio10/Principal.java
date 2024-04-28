package semaforos.ejercicio10;

import java.util.concurrent.Semaphore;

public class Principal {
	static Semaphore maquinaProcesamiento = new Semaphore(8);
	static Semaphore cargaPlataforma = new Semaphore(1);
	static Semaphore descargaPlataforma = new Semaphore(1);
	
	public static void main(String[] args) {
		
//		MaquinaProceso[] maquinas = new MaquinaProceso[8];
//		for(int i=0; i<8; i++) {
//			maquinas[i] = new MaquinaProceso(i+1);
//			
//		}
		
		Thread[] vehiculos = new Thread[4];
		for(int i=0; i<4; i++) {
			vehiculos[i] = new Thread(new Vehiculo(i+1));
			vehiculos[i].start();
		}
		

	}
}
