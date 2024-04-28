package semaforos.ejercicio10;

public class Vehiculo implements Runnable{
	int id;

	
	public Vehiculo(int id) {
		this.id = id;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		//Si lo tienen que hacer siempre meter todo en un while(true)
		try {
			System.out.println("Vehiculo " + id + " llegando a la Plataforma de Carga.");
            Principal.cargaPlataforma.acquireUninterruptibly();
            System.out.println("Vehiculo " + id + " Cargando en la Plataforma de Carga.");
            Thread.sleep(2000); // Simula tiempo de carga
            Principal.cargaPlataforma.release();
            System.out.println("Vehiculo " + id + " Cargado, moviendose a la Maquina de Procesamiento.");
            Principal.maquinaProcesamiento.acquireUninterruptibly();
            System.out.println("Vehiculo " + id + " procesando en la Máquina.");
            Thread.sleep(3000); // Simula tiempo de procesamiento
            Principal.maquinaProcesamiento.release();
            System.out.println("Vehiculo " + id + " finalizó procesamiento, Moviendo a la Plataforma de Descarga.");
            Principal.descargaPlataforma.acquireUninterruptibly();
            System.out.println("Vehiculo " + id + " Descargando en la Plataforma de descarga.");
            Thread.sleep(2000); // Simula tiempo de descarga
            Principal.descargaPlataforma.release();
            System.out.println("Vehiculo " + id + " finalizó descarga.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
}


