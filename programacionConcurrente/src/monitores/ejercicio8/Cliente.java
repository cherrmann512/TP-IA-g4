package monitores.ejercicio8;

public class Cliente implements Runnable{
	
	private Bar monitorBar;

	public Cliente(Bar monitorBar) {
		this.monitorBar = monitorBar;
	}

	@Override
	public void run() {
		System.out.println("Cliente obtiene: " +monitorBar.obtenerPizza());
	}
	
	
	
}
