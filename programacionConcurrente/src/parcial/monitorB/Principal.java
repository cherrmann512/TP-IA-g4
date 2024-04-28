package parcial.monitorB;

public class Principal {
	
	public static void main(String[] args) {
		Puente monitorPuente = new Puente();
		
		for(int i=0; i<3; i++) {
			Thread coche = new Thread(new Coche(i, monitorPuente, 0));
			coche.start();
		}
		
		for(int i=0; i<3; i++) {
			Thread coche = new Thread(new Coche(i, monitorPuente, 1));
			coche.start();
		}
	}

}
