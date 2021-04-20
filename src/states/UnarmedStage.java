package states;

import events.AllDoorCloseEvent;

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
		System.out.println("Going into `Ready to Arm` state - (UnarmedStage.java )");
		SecuritySystemContext.instance().changeState(ZoneReadyState.instance());
	}
	
	
}
