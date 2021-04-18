package states;

import display.SecuritySystemDisplay;

public class SecuritySystemContext {
	private SecuritySystemDisplay display;
	private SecuritySystemState currentState;
	private static SecuritySystemContext instance;
	
	/**
	 * Making the class a singleton
	 */
	private SecuritySystemContext() {
		instance = this;
	}
}
