//package semaforos.ejercicio10;
//
//public class MaquinaProceso {
//	int id;
//
//	public MaquinaProceso(int id) {
//		this.id = id;
//	}
//
//	public void procesando() {
//		// TODO Auto-generated method stub
//		while(true) {
//			try {
//				Principal.maquinaProcesamiento.acquireUninterruptibly();
//				System.out.println("Maquina " +id +" está procesando");
//				Thread.sleep(4000); // Simulate tiempo de procesamiento
//				Principal.cargaPlataforma.acquireUninterruptibly();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}
//	
//	
//}
