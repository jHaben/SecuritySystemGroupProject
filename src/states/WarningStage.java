package states;

import events.AllDoorCloseEvent;

public class WarningStage extends SecuritySystemState {
	private static WarningStage instance;
	
	/**
	 * Private constructor. Singleton.
	 */
	private WarningStage() {
	}
	
	/**
	 * returning the instance
	 * @return the instance object
	 */
	public static WarningStage instance() {
		if (instance == null) {
			instance = new WarningStage();
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