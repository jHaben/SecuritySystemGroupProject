package states;

import events.AllDoorCloseEvent;

public class AwayCheckDoorStage extends SecuritySystemState {
	private static AwayCheckDoorStage instance;
	
	/**
	 * Private constructor. Singleton.
	 */
	private AwayCheckDoorStage() {
	}
	
	/**
	 * returning the instance
	 * @return the instance object
	 */
	public static AwayCheckDoorStage instance() {
		if (instance == null) {
			instance = new AwayCheckDoorStage();
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