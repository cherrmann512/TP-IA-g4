package monitores.ejercicio6;

public class Principal {
	
	public static void main(String[] args) {
		Charla monitorCharla = new Charla();
		Thread orador = new Thread(new Orador(monitorCharla));
		
		for(int i=0; i<100; i++) {
			Thread persona = new Thread(new Persona(monitorCharla, i));
			persona.start();
		}		
		orador.start();
	}

}
