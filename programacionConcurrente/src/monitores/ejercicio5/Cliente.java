package monitores.ejercicio5;

public class Cliente implements Runnable{

	private int id;
	private Pelu pelu;
	
	public Cliente(int id, Pelu pelu) {
		this.id = id;
		this.pelu = pelu;
	}
	
	@Override
	public void run() {
		while(true) {
			pelu.cortarseElPelo(id);
		}
		
	}

}
