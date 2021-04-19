package states;

import display.SecuritySystemDisplay;
import events.UnarmedEvent;

/**
 * SecuritySystemContext
 * 
 * 
 * @author Group: Mitchell Young, Kou Yang, Trung Pham, Jack Haben
 */

public class SecuritySystemContext {
	private SecuritySystemDisplay display;
	private SecuritySystemState currentState;
	private static SecuritySystemContext instance;
	
	/**
	 * Making the class a singleton
	 */
	private SecuritySystemContext() {
		instance = this;
		currentState = UnarmedState.instance();
	}
	
	public static SecuritySystemContext instance() {
		if (instance == null) {
			instance = new SecuritySystemContext();
		}
		return instance;
	}
	
	
	// These are temporary methods used to find the current state
	// Meant for debugging.
	public SecuritySystemState getCurrentState() {
		return currentState;
	}
	// These are temporary methods used to find the current state
	// Meant for debugging.
	public void setCurrentState(SecuritySystemState currentState) {
		this.currentState = currentState;
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
	
	/**
	 * Initializing UnarmedState as the default state
	 */
	public void initialize() {
		instance.changeState(UnarmedState.instance());
	}
	
	/**
	 * ChangeState.
	 * Method used to change the current state to the
	 * next available state.
	 * 
	 * @param nextState object
	 */
    public void changeState(SecuritySystemState nextState) {
    	System.out.println("Start it");
        currentState.leave();
        currentState = nextState;
        currentState.enter();
    }
    
    /**
     * Calls the showNotReady method in SecuritySystemDisplay
     * (Which in turn calls it in GUIDisplay).
     */
    public void showNotReady() {
    	display.showNotReady();
    }

    
    public void handleEvent(UnarmedEvent event) {
    	currentState.handleEvent(event);
    }
	
}