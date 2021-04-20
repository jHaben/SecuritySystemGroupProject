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
	
	@Override
	public void enter() {
		SecuritySystemContext.instance().showPasswordRequiredMessageStayState();
	}

	@Override
	public void leave() {
		
	}
}
