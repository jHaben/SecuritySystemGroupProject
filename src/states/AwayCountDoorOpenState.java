package states;

import events.AllDoorCloseEvent;
import events.SixtySecondEvent;
import events.TimerTickedEvent;
import timer.Notifiable;
import timer.Timer;

public class AwayCountDoorOpenState extends SecuritySystemState implements Notifiable {
	private static AwayCountDoorOpenState instance;
	private Timer timer = new Timer(this, 0);
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

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	/**
	 * Entering unarmed state. Will display on the GUI
	 */
	@Override
	public void enter() {
		SecuritySystemContext.instance().showTimeLeft(timer.getTimeValue());
		timer.start();
	}

	@Override
	public void leave() {
		timer.stop();
	}

	@Override
	public void handleEvent(TimerTickedEvent event) {
		SecuritySystemContext.instance().showTimeLeft(timer.getTimeValue());
	}

	@Override
	public void handleEvent(SixtySecondEvent event) throws InterruptedException {
		SecuritySystemContext.instance().changeState(UnarmedStage.instance());
	}

	public void handleEvent(AllDoorCloseEvent event) {
		AwayCountDoorClosedState.instance().getTimer().addTimeValue(timer.getTimeValue()-
				AwayCountDoorClosedState.instance().getTimer().getTimeValue());
		SecuritySystemContext.instance().changeState(AwayCountDoorClosedState.instance());
	}

}
