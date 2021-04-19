package states;

import events.DoorOpensEvent;

public abstract class SecuritySystemState {
	
	/**
	 * Initializing the state
	 */
	public abstract void enter();
	
	/**
	 * Leaving the state
	 */
	public abstract void leave();
	
	public void handleEvent(DoorOpensEvent event) {
		
	}
	
}
