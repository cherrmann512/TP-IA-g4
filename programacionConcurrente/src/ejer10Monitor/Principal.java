package ejer10Monitor;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AsignarRecursos asig = new AsignarRecursos();
		for(int i =0; i<5; i++) {
			new Thread (new HiloAsignador(asig, i));
		}
	}

}
