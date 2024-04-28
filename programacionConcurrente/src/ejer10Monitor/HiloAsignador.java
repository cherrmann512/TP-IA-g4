package ejer10Monitor;

public class HiloAsignador implements Runnable {
	AsignarRecursos asignador;
	int id;
	
	public HiloAsignador(AsignarRecursos asignador, int id) {
		super();
		this.asignador = asignador;
		this.id = id;
	} 
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			Recurso recursoTomado = asignador.tomar();
			System.out.println("ID: "+ this.id+ " toma recurso " + recursoTomado.getNumero());
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			asignador.liberar(recursoTomado);
			System.out.println("ID: "+ this.id+ " libera recurso " + recursoTomado.getNumero());
		}
	}
}
