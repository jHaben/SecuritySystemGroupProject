package states;

import events.AllDoorCloseEvent;

public class AwayStage extends SecuritySystemState {
	private static UnarmedState instance;
	
	/**
	 * Private constructor. Singleton.
	 */
	private UnarmedState() {
	}
	
	/**
	 * returning the instance
	 * @return the instance object
	 */
	public static UnarmedState instance() {
		if (instance == null) {
			instance = new UnarmedState();
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