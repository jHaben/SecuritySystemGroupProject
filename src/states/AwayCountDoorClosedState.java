package states;

import events.DoorOpensEvent;
import events.SixtySecondEvent;
import events.TimerTickedEvent;
import timer.Notifiable;
import timer.Timer;

public class AwayCountDoorClosedState extends SecuritySystemState implements Notifiable {
	private static AwayCountDoorClosedState instance;
	private Timer timer = new Timer(this, 0);
	
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
		SecuritySystemContext.instance().changeState(AwayStage.instance());
	}

	public void handleEvent(DoorOpensEvent event) {
		AwayCountDoorOpenState.instance().getTimer().addTimeValue(timer.getTimeValue()-
				AwayCountDoorOpenState.instance().getTimer().getTimeValue());
		SecuritySystemContext.instance().changeState(AwayCountDoorOpenState.instance());
	}

}
