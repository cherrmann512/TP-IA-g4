package mensajes.ejemplo1;

import java.io.PrintStream;
import java.net.Socket;

public class Proceso1 {
	public static void main(String argv[]){
		Socket c1;
		try {
			c1 = new Socket("localhost",1234);
			PrintStream c1e = new                
					PrintStream(c1.getOutputStream());
			c1e.println("Hola");
			c1e.close();
			c1.close();
		}
		catch (Exception e) {
			System.out.println("Problemas de conexión");
			System.exit(-1);
		}
		System.out.println("Termino Proceso 1");
	}


}
