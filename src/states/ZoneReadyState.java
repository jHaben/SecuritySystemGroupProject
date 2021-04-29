package states;

import events.AwayPressEvent;
import events.DoorOpensEvent;
import events.SixtySecondEvent;
import events.StayPressEvent;
import events.TimerTickedEvent;
import timer.Notifiable;
import timer.Timer;

/**
 * ZoneReadyState class. Singleton class
 * Class that determines the handleEvent of said class
 * 
 * @author Group: Mitchell Young, Kou Yang, Trung Pham, Jack Haben
 */
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
	 * Entering ZoneReadyState  state. Will display on the GUI
	 */
	@Override
	public void enter() {
		SecuritySystemContext.instance().showReady();
	}

	@Override
	public void leave() {
	}
	
	/**
	 * handleEvent method for when the doors Open.
	 * Changes state to unarmed State
	 */
	public void handleEvent(DoorOpensEvent event) {
		SecuritySystemContext.instance().changeState(UnarmedStage.instance());
	}

	/**
	 * handleEvent method for when the user presses "stay".
	 * Changes the state to StayCountDoorClosedState
	 */
	public void handleEvent(StayPressEvent event) {
		SecuritySystemContext.instance().setTimer(new Timer(SecuritySystemContext.instance(), 5));
		SecuritySystemContext.instance().changeState(StayCountDoorClosedState.instance());
		SecuritySystemContext.instance().getTimer().start();
	}
	/**
	 * handleEvent method for when the user presses "away".
	 * Changes the state to AwayCountDoorClosedState
	 */
	public void handleEvent(AwayPressEvent event) {
		SecuritySystemContext.instance().setTimer(new Timer(SecuritySystemContext.instance(), 5));
		SecuritySystemContext.instance().changeState(AwayCountDoorClosedState.instance());
		SecuritySystemContext.instance().getTimer().start();
		

	}
}
