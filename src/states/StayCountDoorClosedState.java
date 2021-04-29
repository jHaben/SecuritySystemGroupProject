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
	//private Timer timer = new Timer(this, 0);
	
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

//	public Timer getTimer() {
//		return timer;
//	}
//
//	public void setTimer(Timer timer) {
//		this.timer = timer;
//	}

	/**
	 * Entering unarmed state. Will display on the GUI
	 */
	@Override
	public void enter() {
		SecuritySystemContext.instance().showTimeLeft
		(SecuritySystemContext.instance().getTimer().getTimeValue());
		//timer.start();
	}

	@Override
	public void leave() {
		//timer.stop();
		
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
//		StayCountDoorOpenState.instance().getTimer().addTimeValue(timer.getTimeValue()-
//	    StayCountDoorOpenState.instance().getTimer().getTimeValue());
		SecuritySystemContext.instance().changeState(StayCountDoorOpenState.instance());
	}

}
