package impostor;

import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class ImpostorSearchMain {
	
	public static void main(String[] args) {
		
		ImpostorAgent impostorAgent = new ImpostorAgent();
		
		ImpostorEnvironment impostorEnvironment = new ImpostorEnvironment();
		
		SearchBasedAgentSimulator simulator = new SearchBasedAgentSimulator(impostorEnvironment, impostorAgent);
		simulator.start();
	}

}
