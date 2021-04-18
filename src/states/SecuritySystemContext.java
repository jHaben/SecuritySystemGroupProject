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
	
	public static SecuritySystemContext instance() {
		if (instance == null) {
			instance = new SecuritySystemContext();
		}
		return instance;
	}
	
	/**
	 * setDisplay method.
	 * When the display changes we can get the reference.
	 * 
	 * @param display
	 */
	public void setDisplay(SecuritySystemDisplay display) {
		this.display = display;
	}
	
	
	
	
	
}
