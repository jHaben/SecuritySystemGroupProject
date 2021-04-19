package states;

import events.AllDoorCloseEvent;
import events.AwayPressEvent;
import events.DoorOpensEvent;
import events.StayPressEvent;

public class ZoneReadyState extends SecuritySystemState {
private static ZoneReadyState instance;
	
	/**
	 * Private constructor. Singleton.
	 */
	private ZoneReadyState() {
	}
	
	/**
	 * returning the instance
	 * @return the instance object
	 */
	public static ZoneReadyState instance() {
		if (instance == null) {
			instance = new ZoneReadyState();
		}
		return instance;
	}
	
	/**
	 * Entering unarmed state. 
	 * Will display on the GUI
	 */
	@Override
	public void enter() {
		SecuritySystemContext.instance().showReady();
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub
		
	}
	public void HandleEvent(DoorOpensEvent event ) {
		SecuritySystemContext.instance().changeState(UnarmedState.instance());
	}
	public void HandleEvent(StayPressEvent event ) {
		SecuritySystemContext.instance().changeState(StayCoundownStage.instance());
	}
	public void HandleEvent(AwayPressEvent event ) {
		SecuritySystemContext.instance().changeState(AwayCountdownStage.instance());
	}
}
