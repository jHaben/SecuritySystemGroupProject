package states;

import events.DoorOpensEvent;
import events.SixtySecondEvent;
import events.TimerTickedEvent;
import timer.Notifiable;

public class AwayCountDoorClosedState extends SecuritySystemState implements Notifiable {
	private static AwayCountDoorClosedState instance;

	/**
	 * Private constructor. Singleton.
	 */
	private AwayCountDoorClosedState() {
	}

	/**
	 * returning the instance
	 * 
	 * @return the instance object
	 */
	public static AwayCountDoorClosedState instance() {
		if (instance == null) {
			instance = new AwayCountDoorClosedState();
		}
		return instance;
	}

	/**
	 * Entering unarmed state. Will display on the GUI
	 */
	@Override
	public void enter() {
		SecuritySystemContext.instance().showTimeLeft(SecuritySystemContext.instance().getTimer().getTimeValue());
	}

	@Override
	public void leave() {
		SecuritySystemContext.instance().getTimer().stop();
		SecuritySystemContext.instance().setTimer(null);
		SecuritySystemContext.instance().showTimeLeft(0);
	}

	@Override
	public void handleEvent(TimerTickedEvent event) {
		SecuritySystemContext.instance().showTimeLeft(SecuritySystemContext.instance().getTimer().getTimeValue());

	}

	@Override
	public void handleEvent(SixtySecondEvent event) throws InterruptedException {
		SecuritySystemContext.instance().showTimeLeft(0);
		SecuritySystemContext.instance().changeState(AwayStage.instance());

	}

	public void handleEvent(DoorOpensEvent event) {
		SecuritySystemContext.instance().changeState(AwayCountDoorOpenState.instance());
	}

}
