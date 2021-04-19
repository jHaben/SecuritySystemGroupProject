package states;

import events.AllDoorCloseEvent;

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
	 * Entering unarmed state. 
	 * Will display on the GUI
	 */
	@Override
	public void enter() {
		SecuritySystemContext.instance().showNotReady();
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub
		
	}
}