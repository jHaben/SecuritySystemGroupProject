package states;

import events.DoorOpensEvent;
import events.SixtySecondEvent;
import events.TimerTickedEvent;
import timer.Notifiable;
import timer.Timer;

/**
 * StayCountDoorClosedState class.  Singleton class
 * Class that determines the handleEvent of said class
 * 
 * @author Group: Mitchell Young, Kou Yang, Trung Pham, Jack Haben
 */
public class StayCountDoorClosedState extends SecuritySystemState implements Notifiable {
	private static StayCountDoorClosedState instance;
	
	
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
	
	/**
	 * Entering unarmed state. Will display on the GUI
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
		SecuritySystemContext.instance().changeState(StayStage.instance());
		SecuritySystemContext.instance().getTimer().stop();
		SecuritySystemContext.instance().setTimer(null);
	}

	public void handleEvent(DoorOpensEvent event) {
		SecuritySystemContext.instance().changeState(StayCountDoorOpenState.instance());
	}

}
