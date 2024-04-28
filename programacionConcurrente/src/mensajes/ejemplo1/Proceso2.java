package mensajes.ejemplo1;

import java.io.PrintStream;
import java.net.Socket;

public class Proceso2 {
	public static void main(String argv[]){
		Socket c2;
		try {
			c2 = new Socket("localhost",2345);
			PrintStream c2e = new                
					PrintStream(c2.getOutputStream());
			c2e.println("Mundo");
			c2e.close();
			c2.close();

		}
		catch (Exception e) {
			System.out.println("Problemas de conexión");
			System.exit(-1);
		}
		System.out.println("Termino Proceso 2");
	}


}
