package states;

import events.AllDoorCloseEvent;
import events.ValidPassEvent;

/**
 * BreachDoorsOpenStage class. Singleton class
 * Class that determines the handleEvent of said class
 * 
 * @author Group: Mitchell Young, Kou Yang, Trung Pham, Jack Haben
 */

public class BreachDoorsOpenStage extends SecuritySystemState {
	private static BreachDoorsOpenStage instance;
	
	/**
	 * Private constructor. Singleton.
	 */
	private BreachDoorsOpenStage() {
	}
	
	/**
	 * returning the instance
	 * @return the instance object
	 */
	public static BreachDoorsOpenStage instance() {
		if (instance == null) {
			instance = new BreachDoorsOpenStage();
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
	}
	
	/**
	 * handleEvent method for when all the doors close
	 * Will go into BreachDoorsClosedState state
	 */
	public void handleEvent(AllDoorCloseEvent event) {
		SecuritySystemContext.instance().changeState(BreachDoorsClosedState.instance());
	}
	
	/**
	 * handleEvent method for when the user enters the correct password.
	 * Will use various conditionals to go into the according state.
	 */
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
			SecuritySystemContext.instance().changeState(UnarmedStage.instance());
		}
	}
	
}

