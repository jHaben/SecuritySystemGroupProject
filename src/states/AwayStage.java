package states;

import events.AllDoorCloseEvent;
import events.CancelPressEvent;

public class AwayStage extends SecuritySystemState {
	private static AwayStage instance;
	
	/**
	 * Private constructor. Singleton.
	 */
	private AwayStage() {
	}
	
	/**
	 * returning the instance
	 * @return the instance object
	 */
	public static AwayStage instance() {
		if (instance == null) {
			instance = new AwayStage();
		}
		return instance;
	}
	
	/**
	 * Entering away-armed state. 
	 * Will display on the GUI
	 */
	@Override
	public void enter() {
		SecuritySystemContext.instance().showAwayArmed();
	}

	@Override
	public void leave() {
	}
	
	
	
}