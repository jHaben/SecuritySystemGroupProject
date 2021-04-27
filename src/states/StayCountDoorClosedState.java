package states;

import events.DoorOpensEvent;
import events.SixtySecondEvent;
import events.TimerTickedEvent;
import timer.Notifiable;
import timer.Timer;

public class StayCountDoorClosedState extends SecuritySystemState implements Notifiable {
	private static StayCountDoorClosedState instance;
	private Timer timer = new Timer(this, 0);
	
	/**
	 * Private constructor. Singleton.
	 */
	private StayCountDoorClosedState() {
	}

	/**
	 * returning the instance
	 * 
	 * @return the instance object
	 */
	public static StayCountDoorClosedState instance() {
		if (instance == null) {
			instance = new StayCountDoorClosedState();
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
		SecuritySystemContext.instance().showTimeLeft(0);
		SecuritySystemContext.instance().changeState(StayStage.instance());
	}

	public void handleEvent(DoorOpensEvent event) {
		StayCountDoorOpenState.instance().getTimer().addTimeValue(timer.getTimeValue()-
				StayCountDoorOpenState.instance().getTimer().getTimeValue());
		SecuritySystemContext.instance().changeState(StayCountDoorOpenState.instance());
	}

}
