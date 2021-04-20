package states;

import events.AllDoorCloseEvent;

public class UnarmedState extends SecuritySystemState {
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
		SecuritySystemContext.instance().showReady();		
	}
	public void handleEvent(AllDoorCloseEvent event ) {
		System.out.println("right here");
		SecuritySystemContext.instance().changeState(ZoneReadyState.instance());
	}
	
	
}
