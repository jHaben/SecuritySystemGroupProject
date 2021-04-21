package states;

import buttons.CheckBoxes;
import events.AllDoorCloseEvent;
import events.CancelPressEvent;
import events.DoorOpensEvent;

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
	 * Entering stay-armed state. 
	 * Will display on the GUI
	 */
	@Override
	public void enter() {
		SecuritySystemContext.instance().showStayArmed();
	}

	@Override
	public void leave() {

	}
	public void handleEvent(CancelPressEvent event) {
		SecuritySystemContext.instance().changeState(PasswordRequiredStage.instance());
	}
	
	/**
	 * If a zone opens while it is in the StayArmed state
	 */
	@Override
	public void handleEvent(DoorOpensEvent event) {
		if(!CheckBoxes.instance().checkZonesReady()) {
			SecuritySystemContext.instance().changeState(BreachStage.instance());
		}
	}
}
