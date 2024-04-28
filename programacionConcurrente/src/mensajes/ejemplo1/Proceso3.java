package mensajes.ejemplo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Proceso3 {

	public static void main(String argv[]){
		Socket a;
		Socket b;
		BufferedReader al;
		BufferedReader bl;
		ServerSocket Canal1;
		ServerSocket Canal2;
		try {
			Canal1 = new ServerSocket(1234);
			Canal2 = new ServerSocket(2345);
			a = Canal1.accept();
			b = Canal2.accept();
			al = new BufferedReader(new
					InputStreamReader(a.getInputStream()));
			bl = new BufferedReader(new
					InputStreamReader(b.getInputStream()));
			String c = al.readLine();
			String d = bl.readLine();
			System.out.println(c+d);
			al.close();
			bl.close();
			a.close();
			b.close();
			Canal1.close();
			Canal2.close();
		} 
		catch (IOException e) {
			System.out.println("Problemas de conexión");
			System.exit(-1);
		}
		System.out.println("Termino Proceso 3");
	}
}
