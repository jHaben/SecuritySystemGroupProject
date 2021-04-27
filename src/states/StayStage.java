package states;

import events.CancelPressEvent;
import events.DoorOpensEvent;

public class StayStage extends SecuritySystemState {
	private static StayStage instance;

	/**
	 * Private constructor. Singleton.
	 */
	private StayStage() {
	}

	/**
	 * returning the instance
	 * 
	 * @return the instance object
	 */
	public static StayStage instance() {
		if (instance == null) {
			instance = new StayStage();
		}
		return instance;
	}

	/**
	 * Entering stay-armed state. Will display on the GUI
	 */
	@Override
	public void enter() {
		SecuritySystemContext.instance().showStayArmed();
	}

	@Override
	public void leave() {
	}

	public void handleEvent(CancelPressEvent event) {
		SecuritySystemContext.instance().setUserEnteredPassword("");
		SecuritySystemContext.instance().changeState(PasswordRequiredStage.instance());
	}

	/**
	 * If a zone opens while it is in the StayArmed state, move into Breach State.
	 */
	@Override
	public void handleEvent(DoorOpensEvent event) {
		SecuritySystemContext.instance().setUserEnteredPassword("");
		SecuritySystemContext.instance().changeState(BreachStage.instance());

	}
}
