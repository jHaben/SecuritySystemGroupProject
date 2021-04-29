package states;

import events.AllDoorCloseEvent;

/**
 * UnarmedStage class. Singleton class
 * Class that determines the handleEvent of said class
 * 
 * @author Group: Mitchell Young, Kou Yang, Trung Pham, Jack Haben
 */
public class UnarmedStage extends SecuritySystemState {
	private static UnarmedStage instance;
	
	/**
	 * Private constructor. Singleton.
	 */
	private UnarmedStage() {
	}
	
	/**
	 * returning the instance
	 * @return the instance object
	 */
	public static UnarmedStage instance() {
		if (instance == null) {
			instance = new UnarmedStage();
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
		SecuritySystemContext.instance().changeState(ZoneReadyState.instance());
	}
	
	
}
