package states;

import events.AllDoorCloseEvent;

public class StayStage extends SecuritySystemState {
	private static StayStage  instance;
	
	/**
	 * Private constructor. Singleton.
	 */
	private StayStage () {
	}
	
	/**
	 * returning the instance
	 * @return the instance object
	 */
	public static StayStage  instance() {
		if (instance == null) {
			instance = new StayStage ();
		}
		return instance;
	}
	
	/**
	 * Entering unarmed state. 
	 * Will display on the GUI
	 */
	@Override
	public void enter() {
		SecuritySystemContext.instance().showStayArmed();	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub
		
	}
}
