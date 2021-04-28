package states;

import events.DoorOpensEvent;
import events.ValidPassEvent;

public class BreachDoorsClosedState extends SecuritySystemState{
	private static BreachDoorsClosedState instance;
	
	/**
	 * Private constructor. Singleton.
	 */
	private BreachDoorsClosedState() {
	}
	
	/**
	 * returning the instance
	 * @return the instance object
	 */
	public static BreachDoorsClosedState instance() {
		if (instance == null) {
			instance = new BreachDoorsClosedState();
		}
		return instance;
	}
	
	/**
	 * Entering the breach stage.
	 */
	@Override
	public void enter() {
		SecuritySystemContext.instance().showBreachState();
	}

	@Override
	public void leave() {
		SecuritySystemContext.instance().showBreachState();
	}
	
	public void handleEvent(DoorOpensEvent event) {
		SecuritySystemContext.instance().changeState(BreachDoorsOpenStage.instance());
	}
	
	public void handleEvent(ValidPassEvent event) {
		
		if (SecuritySystemContext.instance().getUserEnteredPassword().length() > 5) {
			SecuritySystemContext.instance().setUserEnteredPassword("");
		}
		else {
			SecuritySystemContext.instance().setUserEnteredPassword(SecuritySystemContext.instance().getUserEnteredPassword() +
					SecuritySystemContext.instance().getDisplay().getGuiText().getText());
		}
		
		SecuritySystemContext.instance().showBreachState();
		
		if (SecuritySystemContext.instance().getUserEnteredPassword().equals(SecuritySystemContext.instance().getPassword())) {
			SecuritySystemContext.instance().setUserEnteredPassword("");
			SecuritySystemContext.instance().changeState(ZoneReadyState.instance());
		}
	}
}
