package states;

import events.DoorOpensEvent;
import events.MovementEvent;
import timer.Timer;

public class AwayStage extends SecuritySystemState {
	private static AwayStage instance;

	/**
	 * Private constructor. Singleton.
	 */
	private AwayStage() {
	}

	/**
	 * returning the instance
	 * 
	 * @return the instance object
	 */
	public static AwayStage instance() {
		if (instance == null) {
			instance = new AwayStage();
		}
		return instance;
	}

	/**
	 * Entering away-armed state. Will display on the GUI
	 */
	@Override
	public void enter() {
		SecuritySystemContext.instance().showAwayArmed();
	}

	/**
	 * @param event Process when the door opens.
	 */
	@Override
	public void handleEvent(DoorOpensEvent event) {
		SecuritySystemContext.instance().changeState(WarningStage.instance());
	}

	/**
	 * @param event
	 * @see states.SecuritySystemState#handleEvent(events.MovementEvent)
	 * 
	 *      Process when there is movement.
	 */
	@Override
	public void handleEvent(MovementEvent event) {
		SecuritySystemContext.instance().changeState(WarningStage.instance());
	}

	@Override
	public void leave() {
		SecuritySystemContext.instance().setTimer(new Timer(SecuritySystemContext.instance(), 10));
		SecuritySystemContext.instance().showWarning();
	}

}