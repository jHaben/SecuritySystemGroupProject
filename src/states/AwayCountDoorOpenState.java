package states;

import events.AllDoorCloseEvent;
import events.SixtySecondEvent;
import events.TimerTickedEvent;
import timer.Notifiable;
import timer.Timer;

public class AwayCountDoorOpenState extends SecuritySystemState implements Notifiable {
	private static AwayCountDoorOpenState instance;
	/**
	 * Private constructor. Singleton.
	 */
	private AwayCountDoorOpenState() {
	}

	/**
	 * returning the instance
	 * 
	 * @return the instance object
	 */
	public static AwayCountDoorOpenState instance() {
		if (instance == null) {
			instance = new AwayCountDoorOpenState();
		}
		return instance;
	}

	/**
	 * Entering AwayCountDoorOpenState  state. Will display on the GUI
	 */
	@Override
	public void enter() {
		SecuritySystemContext.instance().showTimeLeft
		(SecuritySystemContext.instance().getTimer().getTimeValue());
	}

	@Override
	public void leave() {
	}

	@Override
	public void handleEvent(TimerTickedEvent event) {
		SecuritySystemContext.instance().showTimeLeft
		(SecuritySystemContext.instance().getTimer().getTimeValue());
	}

	@Override
	public void handleEvent(SixtySecondEvent event) throws InterruptedException {
		SecuritySystemContext.instance().changeState(UnarmedStage.instance());
		SecuritySystemContext.instance().getTimer().stop();
		SecuritySystemContext.instance().setTimer(null);
	}

	/**
	 * handleEvent method for when all the doors are closed.
	 * Changes state to the AwayCountDoorClosedState
	 */
	public void handleEvent(AllDoorCloseEvent event) {
		SecuritySystemContext.instance().changeState(AwayCountDoorClosedState.instance());
	}

}
