package states;

import events.UnarmedEvent;

public abstract class SecuritySystemState {
	
	/**
	 * Initializing the state
	 */
	public abstract void enter();
	
	/**
	 * Leaving the state
	 */
	public abstract void leave();
	
	public void handleEvent(UnarmedEvent event) {
		System.out.println("How about now?");
	}
	
}
