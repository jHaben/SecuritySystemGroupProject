package states;

import events.AllDoorCloseEvent;

public class PasswordRequiredStage extends SecuritySystemState {
	private static PasswordRequiredStage instance;
	
	/**
	 * Private constructor. Singleton.
	 */
	private PasswordRequiredStage() {
	}
	
	/**
	 * returning the instance
	 * @return the instance object
	 */
	public static PasswordRequiredStage instance() {
		if (instance == null) {
			instance = new PasswordRequiredStage();
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
