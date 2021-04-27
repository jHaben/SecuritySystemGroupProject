package states;

import events.AllDoorCloseEvent;
import events.SixtySecondEvent;
import events.TimerTickedEvent;
import timer.Notifiable;

public class StayCountDoorOpenState extends SecuritySystemState implements Notifiable {
	private static StayCountDoorOpenState instance;

	/**
	 * Private constructor. Singleton.
	 */
	private StayCountDoorOpenState() {
	}

	/**
	 * returning the instance
	 * 
	 * @return the instance object
	 */
	public static StayCountDoorOpenState instance() {
		if (instance == null) {
			instance = new StayCountDoorOpenState();
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
		SecuritySystemContext.instance().changeState(UnarmedStage.instance());

	}

	public void handleEvent(AllDoorCloseEvent event) {
		SecuritySystemContext.instance().changeState(StayCountDoorClosedState.instance());
	}

}
