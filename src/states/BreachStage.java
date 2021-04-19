package states;

import events.AllDoorCloseEvent;

public class BreachStage extends SecuritySystemState {
	private static BreachStage instance;
	
	/**
	 * Private constructor. Singleton.
	 */
	private BreachStage() {
	}
	
	/**
	 * returning the instance
	 * @return the instance object
	 */
	public static BreachStage instance() {
		if (instance == null) {
			instance = new BreachStage();
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
}

