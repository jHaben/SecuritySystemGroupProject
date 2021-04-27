package states;

import events.AwayPressEvent;
import events.DoorOpensEvent;
import events.SixtySecondEvent;
import events.StayPressEvent;
import events.TimerTickedEvent;
import timer.Notifiable;
import timer.Timer;

public class ZoneReadyState extends SecuritySystemState{
	private static ZoneReadyState instance;

	/**
	 * Private constructor. Singleton.
	 */
	private ZoneReadyState() {
	}

	/**
	 * returning the instance
	 * 
	 * @return the instance object
	 */
	public static ZoneReadyState instance() {
		if (instance == null) {
			instance = new ZoneReadyState();
		}
		return instance;
	}

	/**
	 * Entering unarmed state. Will display on the GUI
	 */
	@Override
	public void enter() {
		SecuritySystemContext.instance().showReady();
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub
	}

	public void handleEvent(DoorOpensEvent event) {
		SecuritySystemContext.instance().changeState(UnarmedStage.instance());
	}

	public void handleEvent(StayPressEvent event) {
		StayCountDoorClosedState.instance().setTimer(new Timer(StayCountDoorClosedState.instance(), 5));
		StayCountDoorOpenState.instance().setTimer(new Timer(StayCountDoorOpenState.instance(), 5));
		SecuritySystemContext.instance().changeState(StayCountDoorClosedState.instance());
	}

	public void handleEvent(AwayPressEvent event) {
		AwayCountDoorClosedState.instance().setTimer(new Timer(AwayCountDoorClosedState.instance(), 5));
		AwayCountDoorOpenState.instance().setTimer(new Timer(AwayCountDoorOpenState.instance(), 5));
		SecuritySystemContext.instance().changeState(AwayCountDoorClosedState.instance());
	}
}
