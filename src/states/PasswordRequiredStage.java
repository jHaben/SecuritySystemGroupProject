package states;

import buttons.NumberButton;
import events.AllDoorCloseEvent;
import events.TimerTickedEvent;

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
		SecuritySystemContext.instance().showPasswordRequired();
	}

	@Override
	public void leave() {
		
	}
	
	
	
}
