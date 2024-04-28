package impostor;

import java.util.Vector;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import impostor.actions.*;

public class ImpostorAgent extends SearchBasedAgent{
	
	public ImpostorAgent() {
		
		//Impostor Goal
		ImpostorGoal goal = new	ImpostorGoal();
		
		ImpostorAgentState impostorState = new ImpostorAgentState(null, 0, 0, 0);
		this.setAgentState(impostorState);
		Vector<SearchAction> operators = new Vector<SearchAction>();
		operators.addElement(new Eliminate());
		operators.addElement(new GoAdministration());
		operators.addElement(new GoCafeteria());
		operators.addElement(new GoCommunications());
		operators.addElement(new GoElectrical());
		operators.addElement(new GoHallway1());
		operators.addElement(new GoHallway2());
		operators.addElement(new GoHallway3());
		operators.addElement(new GoHallway4());
		operators.addElement(new GoHallway5());
		operators.addElement(new GoHallway6());
		operators.addElement(new GoHallway7());
		operators.addElement(new GoLowerEngine());
		operators.addElement(new GoMedbay());
		operators.addElement(new GoNavigation());
		operators.addElement(new GoOxygen());
		operators.addElement(new GoReactor());
		operators.addElement(new GoSecurity());
		operators.addElement(new GoShields());
		operators.addElement(new GoStorage());
		operators.addElement(new GoUpperEngine());
		operators.addElement(new GoWeapons());
		operators.addElement(new Sabotage());
		operators.addElement(new Wait());
		
		Problem problem = new Problem(goal, impostorState, operators);
		this.setProblem(problem);
		
		
		
	}

	@Override
	public void see(Perception p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Action selectAction() {
		// TODO Auto-generated method stub
		return null;
	}

}
