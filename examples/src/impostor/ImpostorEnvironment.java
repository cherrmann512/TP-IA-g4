package impostor;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class ImpostorEnvironment extends Environment{

	private int agentEnergy;
	
	
	public ImpostorEnvironmentState getEnvironmentState() {
		return (ImpostorEnvironmentState) super.getEnvironmentState();
	}
	
	@Override
	public Perception getPercept() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public boolean agentFailed(Action actionReturned) {

        ImpostorEnvironmentState impostorEnvironmentState =
                this.getEnvironmentState();

        int agentEnergy = impostorEnvironmentState.getAgentEnergy();

        // If the agent has no energy, he failed
        if (agentEnergy <= 0)
            return true;

        return false;
    }


	public int getAgentEnergy() {
		return agentEnergy;
	}


	public void setAgentEnergy(int agentEnergy) {
		this.agentEnergy = agentEnergy;
	}
	
	

}
